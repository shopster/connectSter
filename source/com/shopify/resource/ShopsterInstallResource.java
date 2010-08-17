package com.shopify.resource;

import com.shopify.AuthManager;
import com.shopify.ShopifyAdapter;
import com.shopify.ShopifyApplication;
import com.shopify.entity.AuthDetails;
import com.shopify.entity.ShopifyEntityHelper;
import com.shopify.entity.ShopifyWebhook;
import com.shopify.exception.ShopifyRestException;
import connectster.api.IResponse;
import connectster.api.entity.IAdapterProperty;
import connectster.api.entity.IUser;
import org.restlet.data.Method;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.scribe.oauth.Scribe;
import org.scribe.oauth.Token;

import java.util.logging.Logger;

public class ShopsterInstallResource
extends ServerResource
{
    private static final Logger log = Logger.getLogger( ShopsterInstallResource.class.getName( ) );

    @Get
    @SuppressWarnings( "unused" )
    public String represent( )
    {
        requestAccessToken( );
        return "OK";
    }

    private void requestAccessToken( )
    {
        // retrieve the id of the incoming request and extract auth details for it
        String id = ( String )getRequest( ).getAttributes( ).get( "id" );
        AuthDetails details = AuthManager.getInstance( ).remove( id );
        if( details != null )
        {
            // get uri parameters and auth details
            String verifier = getQuery().getValues( "oauth_verifier" );
            String uid = getQuery().getValues( "uid" );
            Scribe scribe = details.getScribe( );

            // request an access token for this client to shopster
            Token accessToken = scribe.getAccessToken( details.getRequestToken( ), verifier );
            IResponse<IUser> response = ShopifyAdapter.getInstance( ).install( uid, accessToken.getToken( ), accessToken.getSecret( ),
                details.getStore( ), details.getSignature( ), details.getT( ), details.getTimestamp( ) );

            // register a webhook for order processing
            if( response.getStatus( ) == IResponse.Status.Successful )
            {
                // get the newly created user
                IUser user = response.getSource( );
                log.info( "User created for: " + user.getName( ) + " - now creating webhook for this user." );

                IAdapterProperty baseCallbackUri = ShopifyAdapter.getInstance( ).getProperties( ).get( ShopifyAdapter.Property.BaseCallbackUri.toString( ) );
                if( baseCallbackUri == null )
                {
                    log.warning( "Error: unable to locate the shopify adapter property [" +
                        ShopifyAdapter.Property.BaseCallbackUri.toString( ) + "], please fix shopify adapter configuration." );
                }
                else
                {
                    // build a webhook object for this request, it will be externalized as an xml request to shopify
                    ShopifyWebhook webhook = new ShopifyWebhook( );
                    webhook.setAddress( baseCallbackUri.getValue( ) + ShopifyApplication.WEBHOOK_METHOD + "?id=" + user.getId( ) );
                    webhook.setTopic( "orders/create" );

                    try
                    {
                        ShopifyAdapter.getInstance( ).invokeRestCall( user, Method.POST, ShopifyAdapter.METHOD_ADD_WEBHOOK,
                            ShopifyEntityHelper.toXml( webhook ) );
                        log.info( "Webhook installed for: " + user.getName( ) );
                    }
                    catch( ShopifyRestException x )
                    {
                        log.warning( "Problem encountered registering webhook for: " + user.getName( ) + ", user may need to " +
                            " set webhook manually to: " + baseCallbackUri + ", Reason: " + x.getMessage( ) );
                    }
                }
            }

            // forward back to shopify page
            redirectPermanent( details.getShopifyUri( ) );
        }
    }
}
