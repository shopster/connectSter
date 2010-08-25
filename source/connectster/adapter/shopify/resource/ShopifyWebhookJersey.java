package connectster.adapter.shopify.resource;

import connectster.adapter.shopify.ShopifyAdapter;
import connectster.adapter.shopify.entity.ShopifyEntityHelper;
import connectster.adapter.shopify.entity.ShopifyOrder;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
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

/**
 * Note: This class should go away (or refactor to Jersey), it is only in use because ShopifyWebhookResource is
 *       not responding to shopify in a way shopify likes.  Either fix the restlet resource mentioned above or
 *       refactor so that jersey is the rest implementation in use and not restlet. 
 */

@Path("/shopify/webhook")
public class ShopifyWebhookJersey
{
    private static final Logger log = Logger.getLogger( ShopifyWebhookResource.class.getName( ) );

    /**
     * Consume an incoming Order event, this method will consume the order and attach it to the userid
     * as determined by the id=? paramater off the request attributes map.  On success we return and HTTP200
     * result, on failure an HTTP500.
     *
     * @param id The users guid within connectster, this should be set by connectster during install process
     * @param payload The xml payload (order xml in this case)
     * @return A 200 or 500 http code with empty payload
     */
    @POST
    @Produces("text/plain")
    public String post( @QueryParam("id") String id, String payload )
    {
        try
        {
            long userId = Long.parseLong( id );
            ShopifyOrder order = ShopifyEntityHelper.toShopifyOrder( payload );
            ShopifyAdapter.getInstance( ).addOrder( order, userId );
        }
        catch( Throwable x )
        {
            log.warning( "Error occured during webhook processing: " + x.getMessage( ) );
            throw new WebApplicationException( x, Response.Status.BAD_REQUEST );
        }

        return "OK\n\n";
    }
}
