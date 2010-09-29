package connectster.adapter.shopster;

import com.sun.xml.ws.api.message.Headers;
import com.sun.xml.ws.developer.WSBindingProvider;
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
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;

public class ShopsterAdapter
implements IAdapter
{
    public enum Property { Namespace, Endpoint, WebServiceVersion, OAuthUri, AccessKey, AccessSecret, KeyPrefix, SecretPrefix, AdapterPrefix, PollingInterval }

    private static final int GET_ITEMS_PAGE_SIZE = 24;
    private static Logger log = Logger.getLogger( ShopsterAdapter.class.getName( ) );
    private static final String WS_VERSION = "Version";
    private static final String DEFAULT_VENDOR = "Shopster User";
    private static final String DEFAULT_TYPE = "Product";

    private static final BigDecimal KG_MODIFIER = new BigDecimal( 1000 );
    private static final BigDecimal LB_MODIFIER = new BigDecimal( 453.59237 );

    private Map<Long, KeyPair> keyMap;
    private String endpoint, namespace, version, oauthUri;
    private IAdapterConnection connection;
    private ShopsterMonitor monitor;
    private Map<String,IAdapterProperty> properties;

    @Override
    public void initialize( IAdapterConnection connection, Map<String,IAdapterProperty> properties )
    throws AdapterException
    {
        this.connection = connection;
        endpoint = properties.get( Property.Endpoint.toString( ) ).getValue( );
        namespace = properties.get( Property.Namespace.toString( ) ).getValue( );
        version = properties.get( Property.WebServiceVersion.toString( ) ).getValue( );
        oauthUri = properties.get( Property.OAuthUri.toString( ) ).getValue( );
        this.properties = properties;

        // the key map for specific keys relating to a particular adapter, to do this first obtain all adapter prefixed keys
        keyMap = new HashMap<Long, KeyPair>( );
        for( IAdapterProperty property : properties.values( ) )
        {
            // found a new property specified by adapter, extract the adapter id off this key (i.e. AdapterPrefix-123 = 123)
            String adapterPropertyName = property.getName( );
            if( adapterPropertyName.startsWith( Property.AdapterPrefix.toString( ) ) )
            {
                try
                {
                    // validate key based on all 3 pieces being available and demarcated properly
                    long adapterId = Long.parseLong( adapterPropertyName.split( "-" )[ 1 ] );
                    IAdapterProperty keyProperty = properties.get( Property.KeyPrefix.toString( ) + "-" + adapterId );
                    IAdapterProperty secretProperty = properties.get( Property.SecretPrefix.toString( ) + "-" + adapterId );

                    if( keyProperty == null || secretProperty == null )
                    {
                        throw new IOException( "Unable to full parse key details, please verify key, secret and adapter: " +
                            adapterPropertyName );
                    }

                    // insert keypair into map
                    keyMap.put( adapterId, new KeyPair( keyProperty.getValue( ), secretProperty.getValue( ) ) );
                }
                catch( Exception x )
                {
                    log.warning( "Unable to parse key from: " + adapterPropertyName +
                        ", ignoring bad key tag as this adapter will use default keys instead." );
                }
            }
        }

        monitor = new ShopsterMonitor( this, connection );
        monitor.start( );
    }

    public boolean hasKey( Long id )
    {
        return keyMap.get( id ) != null;
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
     * @param sourceAdapterId The source adapter id, used to determine key set in this adapters case
     * @param user The user to authenticate against shopster with.
     * @return A thread safe instance of service port.
     * @throws AdapterException when user properties or mappings fail to load.
     */
    private AuthMain buildProvider( IUser user, Long sourceAdapterId )
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

        // if they exist, use source adapters mapped keys, otherwise use the shopster default keys
        KeyPair key = keyMap.get( sourceAdapterId );
        if( key == null )
        {
            throw new AdapterException( "Unable to find a configured key for adapterId: " + sourceAdapterId );
        }

        provider.getBinding( ).setHandlerChain( Collections.singletonList( ( Handler )new OAuthHandler(
             endpoint, oauthUri, key.getConsumerKey(), key.getConsumerSecret(), accessToken, accessSecret ) ) );

        return new AuthMain( userMapping, port );
    }

    @Override
    public List<IProduct> remoteGetProducts( long sourceAdapterId, IUser user, String targetUserId, Date lastUpdated )
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

                XMLGregorianCalendar xmlCalendar = DatatypeFactory.newInstance( ).newXMLGregorianCalendar( calendar );
                request.setLastUpdatedSince( factory.createGetInventoryItemsRequestTypeLastUpdatedSince( xmlCalendar ) );
            }

            // start with page one and take on 2 items at a time
            request.setPageIndex( factory.createGetInventoryCategoriesRequestTypePageIndex( 0 ) );
            request.setPageSize( factory.createGetInventoryCategoriesRequestTypePageSize( GET_ITEMS_PAGE_SIZE ) );

            // build a new port for this request and get response
            AuthMain auth = buildProvider( user, sourceAdapterId );
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
    public IResponse<IProductMapping> remoteAddProduct( String targetUserId, IProduct product )
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
        addressType.setStreet2( factory.createAddressTypeStreet2( order.getBillingStreet2( ) ) );
        addressType.setCity( factory.createAddressTypeCity( order.getBillingCity( ) ) );
        addressType.setRegion( factory.createAddressTypeRegion( order.getBillingRegion( ) ) );
        addressType.setPostalCode( factory.createAddressTypePostalCode( order.getBillingPostalCode( ) ) );
        addressType.setCountry( factory.createAddressTypeCountry( order.getBillingCountry( ) ) );
        billingInfo.setAddress( new JAXBElement<AddressType>( new QName( "urn:shopster:apis:main", "Address" ), AddressType.class, addressType ) );

        AddressType shippingInfo = factory.createAddressType( );
        shippingInfo.setName( factory.createAddressTypeName( order.getShippingName( ) ) );
        shippingInfo.setStreet1( factory.createAddressTypeStreet1( order.getShippingStreet1( ) ) );
        shippingInfo.setStreet2( factory.createAddressTypeStreet2( order.getShippingStreet2( ) ) );
        shippingInfo.setCity( factory.createAddressTypeCity( order.getBillingCity( ) ) );
        shippingInfo.setRegion( factory.createAddressTypeRegion( order.getBillingRegion( ) ) );
        shippingInfo.setPostalCode( factory.createAddressTypePostalCode( order.getBillingPostalCode( ) ) );
        shippingInfo.setCountry( factory.createAddressTypeCountry( order.getBillingCountry( ) ) );
        JAXBElement<AddressType> shippingElement = new JAXBElement<AddressType>(
            new QName( "urn:shopster:apis:main", "ShippingInfo" ), AddressType.class, shippingInfo );

        OrderCartItemListType itemType = factory.createOrderCartItemListType( );
        List<OrderCartItemType> items = itemType.getItem( );
        for( IOrderItem orderItem : order.getItems( ) )
        {
            OrderCartItemType item = factory.createOrderCartItemType( );
            item.setQuantity( factory.createOrderCartItemTypeQuantity( orderItem.getQuantity( ) ) );

            // todo : retest

            // get mapping for target product id on shopster side
            IResponse<IProductMapping> mappingResponse = connection.getProductMapping( connection.getAdapterId( ),
                orderItem.getProduct().getId( ), order.getSourceUserId( ) );
            if( mappingResponse.getStatus( ) == IResponse.Status.Failure )
            {
                return new ResponseDTO<String>( null, IResponse.Status.Failure, "Unable to push mapping to shopster, cancelling order: " +
                    order.getId( ) );
            }

            IProductMapping mapping = mappingResponse.getSource( );
            item.setItemId( factory.createOrderItemTypeItemId( mapping.getTargetProductId( ) ) );
            items.add( item );
        }

        OrderCartType cart = factory.createOrderCartType( );
        cart.setBillingInfo( new JAXBElement<BillingInfoType>( new QName( "urn:shopster:apis:main", "BillingInfo" ), BillingInfoType.class, billingInfo ) );
        cart.setShippingInfo( shippingElement );

        cart.setItems( new JAXBElement<OrderCartItemListType>( new QName( "urn:shopster:apis:main", "Items" ), OrderCartItemListType.class, itemType ) );
        cart.setShippingMethod( factory.createOrderTypeShippingMethod( order.getShippingMethod( ) ) );

        PlaceOrderRequestType placeOrder = new PlaceOrderRequestType( );
        placeOrder.setCart( new JAXBElement<OrderCartType>( new QName( "urn:shopster:apis:main", "Cart" ), OrderCartType.class, cart ) );

        try
        {
            AuthMain auth = buildProvider( order.getOwner( ), order.getSourceAdapterId( ) );
            PlaceOrderResponseType orderResponse = auth.port.placeOrder( placeOrder );
            ResponseStatusType status = orderResponse.getStatus();
            if( ResponseStatusType.FAILED.equals( status ) )
            {
                StringBuffer buffer = new StringBuffer( "Remote SOAP call failed: " );
                for( ErrorType error : orderResponse.getErrors( ).getValue().getErrorType( ) )
                {
                    buffer.append( error.getMessage( ).getValue( ) );
                }

                log.warning( "SOAP Call to Shopster Failed: " + buffer );

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

    public Map<String, IAdapterProperty> getProperties( )
    {
        return properties;
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
