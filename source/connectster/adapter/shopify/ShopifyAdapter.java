package connectster.adapter.shopify;

import connectster.adapter.shopify.exception.ShopifyRestException;
import connectster.adapter.shopify.entity.*;
import connectster.adapter.shopster.ShopsterAdapter;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;
import connectster.api.IAdapter;
import connectster.api.IAdapterConnection;
import connectster.api.IResponse;
import connectster.api.entity.*;
import connectster.api.entity.implementation.*;
import connectster.api.exceptions.AdapterException;
import connectster.api.utility.GeneralUtilities;
import org.restlet.Client;
import org.restlet.Component;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.*;
import org.restlet.representation.Representation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

/**
 * Copyright 2010 Shopster E-Commerce Inc.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class ShopifyAdapter
extends TestableAdapter
implements IAdapter
{
    public static String AuthenticationCategory = "authorization";
    public static enum Property { ConsumerKey, ConsumerSecret, Timeout, Protocol, ShopifyKey, ShopifySecret, RequestUri,
        InstallCallbackUri, BaseCallbackUri
    }

    public static final String METHOD_PRODUCTS = "/admin/products.xml";
    public static final String METHOD_UPDATE_PRODUCT = "/admin/products/{id}.xml";
    public static final String METHOD_UPDATE_VARIANT = "/admin/products/#{id}/variants/#{id}.xml";
    public static final String METHOD_ADD_WEBHOOK = "/admin/webhooks.xml";

    private static final Logger log = Logger.getLogger( ShopifyAdapter.class.getName( ) );
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd'T'hh:mm:ssZ", Locale.US );
    private static ShopifyAdapter instance;

    private Component component;
    private IAdapterConnection connection;
    private Map<String, IAdapterProperty> properties;
    private ShopifyMonitor monitor;
    private HttpServer server;

    public ShopifyAdapter( )
    {
        component = new Component( );
        properties = new HashMap<String, IAdapterProperty>( );
    }

    @Override
    public void shutdown( )
    {
        log.info( "Shutting down ShopifyAdapter ..." );
        monitor.stop( );
    }

    @Override
    public void initialize( IAdapterConnection connection, Map<String,IAdapterProperty> adapterProperties )
    throws AdapterException
    {
        instance = this;
        this.connection = connection;

        // pull the properties back and configure our RESTlet subsystem to talk to shopify
        for( IAdapterProperty property : adapterProperties.values( ) )
        {
            properties.put( property.getName( ), property );
        }

        for( Property property : Property.values( ) )
        {
            if( !properties.containsKey( property.toString( ) ) )
            {
                throw new AdapterException( "Unable to find all of the core properties needed, missing: " + property.toString( ) );
            }
        }

        // instantiate a REST server instance to accept incoming application
        component.getServers( ).add( Protocol.HTTP, 8182 );
        component.getDefaultHost( ).attach( new ShopifyApplication( ) );

        try
        {
            // start up restlet internal server
            component.start( );

            // start up the grizzly server for jersey (not needed when RESTlet for webhooks is fixed)
            IAdapterProperty webhookUri = properties.get( Property.BaseCallbackUri.toString( ) );
            server = HttpServerFactory.create( webhookUri.getValue( ) + "/" );
            server.start();
        }
        catch( Exception x )
        {
            throw new AdapterException( x );
        }

        // note: disabled since shopster does not support adding items - start up the shopify monitor to poll for new products
        //monitor = new ShopifyMonitor( this, connection );
        //monitor.start( );

        log.info( "Shopify Adapter Online." );
    }

    @Override
    public List<IProduct> remoteGetProducts( IUser user, Date lastUpdated )
    throws AdapterException
    {
        try
        {
            Map<String,String> parameters = null;
            if( lastUpdated != null )
            {
                parameters = new HashMap<String,String>( );
                synchronized( dateFormat )
                {
                    parameters.put( "created_at_min", dateFormat.format( lastUpdated ) );
                }
            }

            ArrayList<IProduct> results = new ArrayList<IProduct>( );
            String xml = invokeRestCall( user, Method.GET, METHOD_PRODUCTS, null, parameters );

            ShopifyProductGroup products = ShopifyEntityHelper.getProducts( xml );
            for( ShopifyProduct product : products.getProducts( ) )
            {
                results.add( new ProductDTO( connection.getAdapterId( ), user.getName( ), String.valueOf( product.getId( ) ),
                    product.getTitle( ) ) );
            }

            return results;
        }
        catch( ShopifyRestException x )
        {
            throw new AdapterException( x );            
        }
    }

    @Override
    public IResponse<IProductMapping> remoteAddProduct( IProduct product )
    {
        IResponse<IProductMapping> result;

        try
        {
            // convert connectster product to a shopify product and then build an xml entity from it
            ShopifyProduct shopifyProduct = ShopifyEntityHelper.toShopifyProduct( String.valueOf( product.getId( ) ), product );
            String entity = ShopifyEntityHelper.toXml( shopifyProduct );

            // guard vs non type="array" specified for variants collections - fix this via registered converter with xstream?
            entity = entity.replace( "<variants>", "<variants type=\"array\">" );

            // make remote call to shopify to add this entity
            String xml = invokeRestCall( product.getOwner( ), Method.POST, METHOD_PRODUCTS, entity );

            // convert the shopify product back so that we have newly assigned id
            ShopifyProduct resultProduct = ShopifyEntityHelper.toShopifyProduct( xml );

            // extract shopify id and use to map this product to shopify
           ProductMappingDTO productMapping = new ProductMappingDTO( connection.getAdapterId( ), product.getId( ),
               String.valueOf( resultProduct.getId( ) ), product.getLastUpdate( ) );

            result = new ResponseDTO<IProductMapping>( productMapping, IResponse.Status.Successful, "Remotely added product: " +
                resultProduct.getId( ) );
        }
        catch( Exception x )
        {
            result = new ResponseDTO<IProductMapping>( null, IResponse.Status.Failure, x.getMessage( ) );
        }

        return result;
    }

    @Override
    public IResponse<IProduct> remoteUpdateProduct( IProduct product, IProductMapping mapping )
    {
        IResponse<IProduct> result;

        try
        {
            // convert connectster product to a shopify product and then build an xml entity from it
            ShopifyProduct shopifyProduct = ShopifyEntityHelper.toShopifyProduct( mapping.getTargetProductId( ), product );
            List<ShopifyVariant> variants = shopifyProduct.getVariants( );
            shopifyProduct.setVariants( null );
            String entity = ShopifyEntityHelper.toXml( shopifyProduct );

            // guard vs non type="array" specified for variants collections - fix this via registered converter with xstream?
            entity = entity.replace( "<variants>", "<variants type=\"array\">" );
            
            // make remote call to shopify to update this entity
            String normalizedMethod = METHOD_UPDATE_PRODUCT.replace( "{id}", mapping.getTargetProductId( ) );
            invokeRestCall( product.getOwner( ), Method.PUT, normalizedMethod, entity );

            // make a remote call to shopify to update variant entity
            normalizedMethod = METHOD_UPDATE_VARIANT.replace( "{id}", mapping.getTargetProductId( ) );
            for( ShopifyVariant variant : variants )
            {
                variant.setId( Integer.parseInt( shopifyProduct.getId( ) ) );
                invokeRestCall( product.getOwner( ), Method.PUT, normalizedMethod, ShopifyEntityHelper.toXml( variant ) );
            }

            result = new ResponseDTO<IProduct>( product, IResponse.Status.Successful, "Successfully updated remote product: " +
                mapping.getTargetProductId( ) );
        }
        catch( ShopifyRestException x )
        {
            result = new ResponseDTO<IProduct>( product, IResponse.Status.Failure, x.getMessage( ) );
        }

        return result;
    }

    @Override
    public IResponse<String> remoteAddOrder( IOrder order )
    {
        return new ResponseDTO<String>( null, IResponse.Status.Failure, "Not Implemented" );
    }

    public IResponse<IUser> install( String uid, String accessKey, String accessSecret, String shop, String signature, String token,
        long timestamp )
    {
        ShopifyShopAuthentication shopAuthentication = new ShopifyShopAuthentication( uid, shop, signature, token, timestamp );
        AdapterDataDTO<ShopifyShopAuthentication> data = new AdapterDataDTO<ShopifyShopAuthentication>( AuthenticationCategory, shop, shopAuthentication );

        List<IUserProperty> userProperties = new ArrayList<IUserProperty>( );
        userProperties.add( new UserPropertyDTO( ShopsterAdapter.Property.AccessKey.toString( ), accessKey ) );
        userProperties.add( new UserPropertyDTO( ShopsterAdapter.Property.AccessSecret.toString( ), accessSecret ) );

        return connection.register( connection.getAdapterId( ), shop, uid, data, userProperties );
    }

    public Map<String,IAdapterProperty> getProperties( )
    {
        return properties;
    }

    public String invokeRestCall( IUser user, Method httpMethod, String webMethod, String entity )
    throws ShopifyRestException
    {
        return invokeRestCall( user, httpMethod, webMethod, entity, null );
    }

    public String invokeRestCall( IUser user, Method httpMethod, String webMethod, String entity, Map<String,String> parameters )
    throws ShopifyRestException
    {
        // get the previously stored ShopifyShopAuthentication data saved to connectster as an AdapterData piece.
        IResponse<IAdapterData> dataResponse = connection.loadData( AuthenticationCategory, user.getName( ) );
        if( dataResponse.getStatus( ) == IResponse.Status.Failure )
        {
            throw new ShopifyRestException( "Unable to find adapter data for: [" + AuthenticationCategory + "/" + user.getName( ) +
                "], returning empty list of product." );
        }
        IAdapterData data = dataResponse.getSource( );
           
        // get the properties needed for this method call
        String shopifySecret = properties.get( Property.ShopifySecret.toString( ) ).getValue( );
        String shopifyKey = properties.get( Property.ShopifyKey.toString( ) ).getValue( );

        IAdapterProperty protocolProperty = properties.get( Property.Protocol.toString( ) );
        String protocol = ( protocolProperty == null ) ? "https" : protocolProperty.getValue( );

        // retrieve the data object stored for this adapter
        ShopifyShopAuthentication authentication = ( ShopifyShopAuthentication )data.getValue( );
        String requestUri =  protocol + "://" + authentication.getShop( ) + webMethod;
        String md5Password = GeneralUtilities.md5( shopifySecret + authentication.getToken( ) );

        // add all query parameters passed in
        Reference reference = new Reference( requestUri );
        if( parameters != null )
        {
            for( String key : parameters.keySet( ) )
            {
                reference.addQueryParameter( key, parameters.get( key ) );
            }
        }

        // build a request to shopify using the authentication and shop/user name
        ChallengeResponse challenge = new ChallengeResponse( ChallengeScheme.HTTP_BASIC );
        challenge.setIdentifier( shopifyKey );
        challenge.setSecret( md5Password );

        // build actual request to shopify
        Request request = new Request( );
        request.setResourceRef( reference );
        request.setChallengeResponse( challenge );
        request.setMethod( httpMethod );

        if( entity != null )
        {
            request.setEntity( entity, MediaType.TEXT_XML );
        }

        // make the request over https and store reponse
        Client client = new Client( Protocol.HTTPS );
        Response response = client.handle( request );
        response.commit( );

        // get status and check if we were successful
        if( response.getStatus( ).getCode( ) < 200 || response.getStatus( ).getCode( ) > 399 )
        {
            throw new ShopifyRestException( "Web request error occured: " + response.getStatus( ).getCode( ) + " - " +
                response.getStatus( ).getDescription( ) );
        }

        // get representation from response
        Representation representation = response.getEntity( );
        if( representation == null )
        {
            throw new ShopifyRestException( "Null response from shopify on method call: " + webMethod );
        }

        try
        {
            return representation.getText( );
        }
        catch( IOException x )
        {
            throw new ShopifyRestException( x );
        }
    }

    public void addOrder( ShopifyOrder shopifyOrder, long userId )
    {
        // build lightweight order dto for adding to connection
        OrderDTO order = new OrderDTO( );
        order.setName( shopifyOrder.getName( ) );
        order.setOwner( new UserDTO( userId ) );
        order.setSourceId( String.valueOf( shopifyOrder.getId( ) ) );
        order.setSourceAdapterId( connection.getAdapterId( ) );

        // convert shopify order specifics to connectster order
        ShopifyAddress billingAddress = shopifyOrder.getBillingAddress( );
        order.setBillingCity( billingAddress.getCity( ) );
        order.setBillingCountry( billingAddress.getCountryCode( ) );
        order.setBillingName( billingAddress.getName( ) );
        order.setBillingPostalCode( billingAddress.getZip( ) );
        order.setBillingRegion( billingAddress.getProvinceCode( ) );
        order.setBillingStreet1( billingAddress.getAddress1( ) );

        String address2 = billingAddress.getAddress2( );
        if( address2 == null || address2.isEmpty( ) )
        {
            address2 = " ";
        }
        order.setBillingStreet2( address2 );

        ShopifyAddress shippingAddress = shopifyOrder.getShippingAddress( );
        if( shippingAddress == null )
        {
            shippingAddress = billingAddress;
        }
        
        order.setShippingCity( shippingAddress.getCity( ) );
        order.setShippingCountry( shippingAddress.getCountryCode( ) );
        order.setShippingName( shippingAddress.getName( ) );
        order.setShippingPostalCode( shippingAddress.getProvinceCode( ) );
        order.setShippingRegion( shippingAddress.getProvinceCode( ) );
        order.setShippingStreet1( shippingAddress.getAddress1( ) );

        address2 = shippingAddress.getAddress2( );
        if( address2 == null || address2.isEmpty( ) )
        {
            address2 = " ";
        }
        order.setShippingStreet2( address2 );

        // here we walk over all line items and try to locate their connectster counterpart
        Set<IOrderItem> orderItems = new HashSet<IOrderItem>( );
        for( ShopifyLineItem lineItem : shopifyOrder.getLineItems( ) )
        {
            // if no matches are found then error this order out
            IResponse<IProduct> response = connection.getProductBySource( userId, String.valueOf( lineItem.getProductId( ) ) );
            if( response.getStatus( ) == IResponse.Status.Failure )
            {
                log.warning( "Shopify Order specifies a product id: " + lineItem.getProductId( ) + ", cancelling this order: " +
                    shopifyOrder.getOrderNumber( ) );
                return;
            }

            // build a new line item wrapper (orderitem in connectster speak)
            IProduct product = response.getSource( );
            OrderItemDTO orderItem = new OrderItemDTO( );
            orderItem.setProduct( product );
            orderItem.setOrder( order );
            orderItem.setQuantity( lineItem.getQuantity( ) );
            orderItems.add( orderItem );
        }
        order.setItems( orderItems );

        // note: no method from shopify? assume standard?
        order.setShippingMethod( "Standard" );

        // get response, if a failure log and fail out
        IResponse<IOrder> orderResponse = connection.addOrder( order );
        if( orderResponse.getStatus( ) == IResponse.Status.Failure )
        {
            log.warning( "Error encountered persisting order: " + order.getSourceId( ) + ", Reason: " +
                orderResponse.getMessage( ) );
            return;
        }

        // now with the order in place, create a mapping for each order
        connection.buildOrderMappings( userId, orderResponse.getSource( ) );
    }

    public static ShopifyAdapter getInstance( )
    {
        return instance;
    }
}

