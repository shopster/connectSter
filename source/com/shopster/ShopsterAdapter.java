package com.shopster;

import com.sun.xml.internal.ws.api.message.Headers;
import com.sun.xml.internal.ws.developer.WSBindingProvider;
import connectster.api.IAdapter;
import connectster.api.IAdapterConnection;
import connectster.api.IResponse;
import connectster.api.entity.*;
import connectster.api.entity.implementation.ProductDTO;
import connectster.api.entity.implementation.ResponseDTO;
import connectster.api.exceptions.AdapterException;
import connectster.server.exceptions.ConnectsterException;
import shopster.apis.main.*;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;

public class ShopsterAdapter
implements IAdapter
{
    public enum Property { ConsumerKey, ConsumerSecret, Namespace, Endpoint, WebServiceVersion, OAuthUri, AccessKey, AccessSecret }

    private static final int GET_ITEMS_PAGE_SIZE = 35;
    private static Logger log = Logger.getLogger( ShopsterAdapter.class.getName( ) );
    private static final String WS_VERSION = "Version";
    private static final String DEFAULT_VENDOR = "Shopster User";
    private static final String DEFAULT_TYPE = "Product";

    private static final BigDecimal KG_MODIFIER = new BigDecimal( 1000 );
    private static final BigDecimal LB_MODIFIER = new BigDecimal( 453.59237 );

    private String endpoint, namespace, version, consumerKey, consumerSecret, oauthUri;
    private IAdapterConnection connection;
    private ShopsterMonitor monitor;

    @Override
    public void initialize( IAdapterConnection connection, Map<String,IAdapterProperty> properties )
    throws AdapterException
    {
        this.connection = connection;
        endpoint = properties.get( Property.Endpoint.toString( ) ).getValue( );
        namespace = properties.get( Property.Namespace.toString( ) ).getValue( );
        version = properties.get( Property.WebServiceVersion.toString( ) ).getValue( );
        consumerKey = properties.get( Property.ConsumerKey.toString( ) ).getValue( );
        consumerSecret = properties.get( Property.ConsumerSecret.toString( ) ).getValue( );
        oauthUri = properties.get( Property.OAuthUri.toString( ) ).getValue( );

        monitor = new ShopsterMonitor( this, connection );
        monitor.start( );
    }

    @Override
    public void shutdown( )
    {
        log.info( "Shutting down ShopsterAdapter ..." );
        monitor.stop( );
    }

    /**
     * Build a new service port, initialize with the appropriate endpoint, namespace and service version and
     * then set the oauth bindings w/oauthhandler.
     *
     * @param user The user to authenticate against shopster with.
     * @return A thread safe instance of service port.
     * @throws AdapterException when user properties or mappings fail to load.
     */
    private AuthMain buildProvider( IUser user )
    throws AdapterException
    {
        // retrieve all user properties and validate we have an access key and access secret
        Map<String, IUserProperty> userProperties = user.getUserProperties( );
        if( !userProperties.containsKey( Property.AccessKey.toString( ) ) || !userProperties.containsKey( Property.AccessSecret.toString( ) ) )
        {
            throw new AdapterException( "Unable to locate properties [" + Property.AccessKey.toString( ) + ", " +
                Property.AccessSecret.toString( ) + "] : UserID=" + user.getId( ) );
        }

        // get a user mapping for the given user that works with this adapter, if none exists fail this call
        Map<Long, IUserMapping> userMappings = user.getUserMappings( );
        if( !userMappings.containsKey( connection.getAdapterId( ) ) )
        {
            throw new AdapterException( "User mapping for [" + user.getName( ) + "] not found for adapter id: " +
                connection.getAdapterId( ) );
        }

        // grab the access token and secret associated with this user
        IUserMapping userMapping = userMappings.get( connection.getAdapterId( ) );
        String accessToken = userProperties.get( Property.AccessKey.toString( ) ).getValue( );
        String accessSecret = userProperties.get( Property.AccessSecret.toString( ) ).getValue( );

        Main main = new Main( );
        IMain port = main.getMainBindingIMain( );
        WSBindingProvider provider = ( WSBindingProvider )port;
        provider.getRequestContext( ).put( BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint );
        provider.setOutboundHeaders( Headers.create( new QName( namespace, WS_VERSION ), version ) );
        provider.getBinding( ).setHandlerChain( Collections.singletonList( ( Handler )new OAuthHandler(
             endpoint, oauthUri, consumerKey, consumerSecret, accessToken, accessSecret ) ) );

        return new AuthMain( userMapping, port );
    }

    @Override
    public List<IProduct> remoteGetProducts( IUser user, Date lastUpdated )
    throws AdapterException
    {
        try
        {
            // build a request with the specified date
            ObjectFactory factory = new ObjectFactory( );
            GetInventoryItemsRequestType request = new GetInventoryItemsRequestType( );
            if( lastUpdated != null )
            {
                GregorianCalendar calendar = new GregorianCalendar( );
                calendar.setTime( lastUpdated );

                XMLGregorianCalendar xmlCalendar = DatatypeFactory.newInstance( ).newXMLGregorianCalendar( );
                xmlCalendar.setYear( calendar.get( GregorianCalendar.YEAR ) );
                xmlCalendar.setMonth( calendar.get( GregorianCalendar.MONTH ) );
                xmlCalendar.setDay( calendar.get( GregorianCalendar.DAY_OF_MONTH ) );
                xmlCalendar.setTime( calendar.get( GregorianCalendar.HOUR ), calendar.get( GregorianCalendar.MINUTE ),
                    calendar.get( GregorianCalendar.SECOND ) );
                request.setLastUpdatedSince( factory.createGetInventoryItemsRequestTypeLastUpdatedSince( xmlCalendar ) );
            }

            // start with page one and take on 2 items at a time
            request.setPageIndex( factory.createGetInventoryCategoriesRequestTypePageIndex( 0 ) );
            request.setPageSize( factory.createGetInventoryCategoriesRequestTypePageSize( GET_ITEMS_PAGE_SIZE ) );

            // build a new port for this request and get response
            AuthMain auth = buildProvider( user );
            GetInventoryItemsResponseType response = auth.port.getInventoryItems( request );
            int itemsRemaining = response.getNumFound( ).getValue( );
            int pageIndex = 0;

            // gives back an array list of products
            ArrayList<IProduct> products = new ArrayList<IProduct>( );
            while( itemsRemaining > 0 )
            {
                itemsRemaining -= GET_ITEMS_PAGE_SIZE;
                pageIndex ++;

                JAXBElement<InventoryItemListType> list = response.getItems( );
                for( InventoryItemType item : list.getValue( ).getItem( ) )
                {                   
                    // note : currently no timestamp coming back from shopster, so use current date instead
                    ProductDTO product = new ProductDTO( connection.getAdapterId( ), auth.mapping.getTargetUserId( ),
                        item.getItemId( ).getValue( ), item.getName( ).getValue( ), new Date( ) );

                    String vendor = item.getSupplierId( ).getValue( );
                    product.setVendor( vendor == null ? DEFAULT_VENDOR : vendor );

                    String type = item.getShortDescription( ).getValue( );
                    product.setType( type == null ? DEFAULT_TYPE : type );

                    product.setCurrency( item.getPricing().getValue().getCurrency().value() );
                    product.setSku( item.getSku( ).getValue() );
                    product.setPrice( item.getPricing().getValue().getRetailPrice().doubleValue() );
                    product.setQuantity( item.getQuantity( ).getValue( ) );

                    // note : according to api we will receieve KG or LBS as units, convert based on this to grams
                    String shopsterUnit = item.getWeight( ).getValue( ).getUnit( ).value( );
                    BigDecimal weight = item.getWeight( ).getValue( ).getValue( );
                    if( shopsterUnit != null && shopsterUnit.equalsIgnoreCase( "KG" ) )
                    {
                        product.setGrams( weight.multiply( KG_MODIFIER ).intValue( ) );
                    }
                    else
                    {
                        product.setGrams( weight.multiply( LB_MODIFIER ).intValue( ) );
                    }

                    products.add( product );
                }

                // process next incoming page of items
                if( itemsRemaining > 0 )
                {
                    request.setPageIndex( factory.createGetInventoryCategoriesRequestTypePageIndex( pageIndex ) );
                    request.setPageSize( factory.createGetInventoryCategoriesRequestTypePageSize( GET_ITEMS_PAGE_SIZE ) );
                    response = auth.port.getInventoryItems( request );
                }
            }

            return products;
        }
        catch( Exception x )
        {    
            throw new AdapterException( "Unable to obtain port and make a soap request to shopster.", x );
        }
    }

    /**
     * Currently we do not support adding a product back into shopster.
     * @param product The product to push back into shopster.
     * @return The new mapping for this product.
     */
    @Override
    public IResponse<IProductMapping> remoteAddProduct( IProduct product )
    {
        return new ResponseDTO<IProductMapping>( null, IResponse.Status.Failure, "Not Implemented" );
    }

    @Override
    public IResponse<IProduct> remoteUpdateProduct( IProduct product, IProductMapping mapping )
    {
        return new ResponseDTO<IProduct>( null, IResponse.Status.Failure, "Not Implemented" );
    }

    @Override
    public IResponse<String> remoteAddOrder( IOrder order )
    {
        IResponse<String> response;
        ObjectFactory factory = new ObjectFactory( );

        BillingInfoType billingInfo = factory.createBillingInfoType( );
        AddressType addressType = factory.createAddressType( );
        addressType.setName( factory.createAddressTypeName( order.getBillingName( ) ) );
        addressType.setStreet1( factory.createAddressTypeStreet1( order.getBillingStreet1( ) ) );
        addressType.setStreet1( factory.createAddressTypeStreet2( order.getBillingStreet2( ) ) );
        addressType.setCity( factory.createAddressTypeCity( order.getBillingCity( ) ) );
        addressType.setRegion( factory.createAddressTypeRegion( order.getBillingRegion( ) ) );
        addressType.setPostalCode( factory.createAddressTypePostalCode( order.getBillingPostalCode( ) ) );
        addressType.setCountry( factory.createAddressTypeCountry( order.getBillingCountry( ) ) );
        billingInfo.setAddress( factory.createAddressType( addressType ) );

        AddressType shippingInfo = factory.createAddressType( );
        shippingInfo.setName( factory.createAddressTypeName( order.getShippingName( ) ) );
        shippingInfo.setStreet1( factory.createAddressTypeStreet1( order.getShippingStreet1( ) ) );
        shippingInfo.setStreet1( factory.createAddressTypeStreet2( order.getShippingStreet2( ) ) );
        shippingInfo.setCity( factory.createAddressTypeCity( order.getBillingCity( ) ) );
        shippingInfo.setRegion( factory.createAddressTypeRegion( order.getBillingRegion( ) ) );
        shippingInfo.setPostalCode( factory.createAddressTypePostalCode( order.getBillingPostalCode( ) ) );
        shippingInfo.setCountry( factory.createAddressTypeCountry( order.getBillingCountry( ) ) );
        JAXBElement<AddressType> shippingElement = new JAXBElement<AddressType>(
            new QName("urn:shopster:apis:main", "ShippingInfo"), AddressType.class, shippingInfo );

        OrderCartItemListType itemType = factory.createOrderCartItemListType( );
        List<OrderCartItemType> items = itemType.getItem( );
        for( IOrderItem orderItem : order.getItems( ) )
        {
            OrderCartItemType item = factory.createOrderCartItemType( );
            item.setQuantity( factory.createOrderCartItemTypeQuantity( orderItem.getQuantity( ) ) );

            // get mapping for target product id on shopster side
            IResponse<IProductMapping> mapping = connection.getProductMapping( Long.parseLong( orderItem.getId( ) ) );
            if( mapping.getStatus( ) == IResponse.Status.Failure )
            {
                return new ResponseDTO<String>( null, IResponse.Status.Failure, "Unable to push mapping to shopster, cancelling order: " +
                    order.getId( ) );
            }

            item.setItemId( factory.createOrderItemTypeItemId( orderItem.getId( ) ) );
            items.add( item );
        }

        OrderCartType cart = factory.createOrderCartType( );
        cart.setBillingInfo( factory.createBillingInfoType( billingInfo ) );
        cart.setShippingInfo( shippingElement );
        cart.setItems( factory.createOrderCartItemListType( itemType ) );
        cart.setShippingMethod( factory.createOrderTypeShippingMethod( order.getShippingMethod( ) ) );

        PlaceOrderRequestType placeOrder = new PlaceOrderRequestType( );
        placeOrder.setCart( factory.createOrderCartType( cart ) );

        try
        {
            AuthMain auth = buildProvider( order.getOwner( ) );
            PlaceOrderResponseType orderResponse = auth.port.placeOrder( placeOrder );
            ResponseStatusType status = orderResponse.getStatus();
            if( ResponseStatusType.FAILED.equals( status ) )
            {
                StringBuffer buffer = new StringBuffer( "Remote SOAP call failed: " );
                for( ErrorType error : orderResponse.getErrors( ).getValue().getErrorType( ) )
                {
                    buffer.append( error.getMessage( ).getValue( ) );
                }

                throw new ConnectsterException( buffer.toString( ) );
            }

            String orderId = orderResponse.getNewOrderId( ).getValue( );
            response = new ResponseDTO<String>( orderId, IResponse.Status.Successful,
                "New order created remotely for shopster, new order id: " + orderId );
        }
        catch( Exception x )
        {
            response = new ResponseDTO<String>( null, IResponse.Status.Failure,
                "Exception encountered attempting remote place order on shopster: " + x.getMessage( ) );
        }

        return response;
    }

    private class AuthMain
    {
        protected IUserMapping mapping;
        protected IMain port;

        public AuthMain( IUserMapping mapping, IMain port )
        {
            this.mapping = mapping;
            this.port = port;
        }
    }
}
