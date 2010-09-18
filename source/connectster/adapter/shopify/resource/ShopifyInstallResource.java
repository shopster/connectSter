package connectster.adapter.shopify.resource;

import connectster.adapter.shopify.AuthManager;
import connectster.adapter.shopify.ShopifyAdapter;
import connectster.adapter.shopify.ShopifyApplication;
import connectster.adapter.shopify.entity.AuthDetails;
import connectster.adapter.shopster.ShopsterAdapter;
import connectster.api.entity.IAdapterProperty;
import connectster.api.utility.GeneralUtilities;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.scribe.oauth.Scribe;
import org.scribe.oauth.Token;

import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * This is an integration piece, which should be the only of a few places where shopster is referenced outside of its
 * own scope.  Installation resources can make some assumptions about the nature of the authentication mechanism being used
 * to onboard an adapter on behalf of a given user.
 */
public class ShopifyInstallResource
extends ServerResource
{
    private static final Logger log = Logger.getLogger( ShopifyInstallResource.class.getName( ) );
    private static volatile long requestId = 0;

    @Get
    @SuppressWarnings( "unused" )
    public String represent( )
    {
        requestRequestToken( );
        return "OK";
    }

    private void requestRequestToken( )
    {
        // create a unique id and initialize state
        String id = String.valueOf( ++ requestId );

        // retrieve the application for this resource, assumed to be a shopify application, also obtain properties maps
        ShopifyApplication application = ( ShopifyApplication )getApplication( );
        Map<String, IAdapterProperty> masterProperties = application.getAdapterConnection( ).getMasterProperties( );
        Map<String, IAdapterProperty> properties = ShopifyAdapter.getInstance( ).getProperties( );
        long adapterId = application.getAdapterConnection( ).getAdapterId( );

        String callbackUri = properties.get( ShopifyAdapter.Property.InstallCallbackUri.toString( ) ).getValue( ) + id;
        log.warning( "Servicing an adapter installation request with id: " + id );

        // setup scribe properties
        Properties scribeProperties = new Properties( );
        scribeProperties.setProperty( "consumer.key", masterProperties.get( ShopsterAdapter.Property.KeyPrefix.toString( ) + "-" + adapterId ).getValue( ) );
        scribeProperties.setProperty( "consumer.secret", masterProperties.get( ShopsterAdapter.Property.SecretPrefix.toString( ) + "-" + adapterId ).getValue( ) );
        scribeProperties.setProperty( "request.token.verb", "POST" );
        scribeProperties.setProperty( "request.token.url", masterProperties.get( ShopsterAdapter.Property.OAuthUri.toString( ) ).getValue( ) );
        scribeProperties.setProperty( "access.token.verb", "POST" );
        scribeProperties.setProperty( "access.token.url", masterProperties.get( ShopsterAdapter.Property.OAuthUri.toString( ) ).getValue( ) );
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
        String uri = String.format( masterProperties.get( ShopsterAdapter.Property.OAuthUri.toString( ) ).getValue( ) + "?oauth_token=%s&oauth_callback=%s",
            GeneralUtilities.urlEncode( requestToken.getToken( ) ), GeneralUtilities.urlEncode( callbackUri ) );
        redirectPermanent( uri );
    }
}
