package com.shopify.resource;

import com.shopify.AuthManager;
import com.shopify.ShopifyAdapter;
import com.shopify.entity.AuthDetails;
import connectster.api.entity.IAdapterProperty;
import connectster.api.utility.GeneralUtilities;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.scribe.oauth.Scribe;
import org.scribe.oauth.Token;

import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

public class ShopifyInstallResource
extends ServerResource
{
    private static final Logger log = Logger.getLogger( ShopifyInstallResource.class.getName( ) );
    private static volatile long requestId = 0;

    @Get
    @SuppressWarnings( "unused" )
    public String represent()
    {
        requestRequestToken( );
        return "OK";
    }

    private void requestRequestToken( )
    {
        // create a unique id and initialize state
        String id = String.valueOf( ++ requestId );
        Map<String, IAdapterProperty> properties = ShopifyAdapter.getInstance( ).getProperties( );
        String callbackUri = properties.get( ShopifyAdapter.Property.InstallCallbackUri.toString( ) ).getValue( ) + id;
        log.warning( "Servicing an adapter installation request with id: " + id );

        // setup scribe properties
        Properties scribeProperties = new Properties( );
        scribeProperties.setProperty( "consumer.key", properties.get( ShopifyAdapter.Property.ConsumerKey.toString( ) ).getValue( ) );
        scribeProperties.setProperty( "consumer.secret", properties.get( ShopifyAdapter.Property.ConsumerSecret.toString( ) ).getValue( ) );
        scribeProperties.setProperty( "request.token.verb", "POST" );
        scribeProperties.setProperty( "request.token.url", properties.get( ShopifyAdapter.Property.RequestUri.toString( ) ).getValue( ) );
        scribeProperties.setProperty( "access.token.verb", "POST" );
        scribeProperties.setProperty( "access.token.url", properties.get( ShopifyAdapter.Property.RequestUri.toString( ) ).getValue( ) );
        scribeProperties.setProperty( "callback.url", callbackUri );
        Scribe scribe = new Scribe( scribeProperties );

        // extract parameters coming in from shopify and get request token from shopster
        Token requestToken = scribe.getRequestToken();
        String store = getQuery().getValues( "shop" );
        String t = getQuery().getValues( "t" );
        String signature = getQuery().getValues( "signature" );
        long timestamp = Long.parseLong( getQuery().getValues( "timestamp" ) );

        // store details for an expected callback
        AuthDetails details = new AuthDetails( );
        details.setStore( store );
        details.setRequestToken( requestToken );
        details.setSignature( signature );
        details.setT( t );
        details.setTimestamp( timestamp );
        details.setScribe( scribe );
        details.setShopifyUri( properties.get( ShopifyAdapter.Property.Protocol.toString( ) ).getValue( ) + "://" + store + "/admin" );
        details.setRequestTimestamp( System.currentTimeMillis( ) );
        AuthManager.getInstance( ).add( id, details );

        // build callback string and forward browser to shopster to allow for callbacks
        String uri = String.format( properties.get( ShopifyAdapter.Property.RequestUri.toString( ) ).getValue( ) + "?oauth_token=%s&oauth_callback=%s",
            GeneralUtilities.urlEncode( requestToken.getToken( ) ), GeneralUtilities.urlEncode( callbackUri ) );
        redirectPermanent( uri );
    }
}
