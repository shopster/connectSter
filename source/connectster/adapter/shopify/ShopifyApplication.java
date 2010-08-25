package connectster.adapter.shopify;

import connectster.adapter.shopify.resource.ShopifyInstallResource;
import connectster.adapter.shopify.resource.ShopsterInstallResource;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class ShopifyApplication
extends Application
{
    public static final String WEBHOOK_METHOD = "/shopify/webhook";

    @Override
    public synchronized Restlet createInboundRoot( )
    {
        Router router = new Router( getContext( ) );
        router.attach( "/install-adapter", ShopifyInstallResource.class );
        router.attach( "/install-adapter-callback/{id}", ShopsterInstallResource.class );
//        router.attach( WEBHOOK_METHOD, ShopifyWebhookResource.class );
        return router;
    }
}
