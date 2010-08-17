package com.shopify.resource;

import com.shopify.ShopifyAdapter;
import com.shopify.entity.ShopifyEntityHelper;
import com.shopify.entity.ShopifyOrder;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.representation.Variant;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

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
 *
 * ShopifyWebhookResource provides an entry point for webhook callbacks from shopify such as new incoming
 * orders and product changes.
 */
public class ShopifyWebhookResource
extends ServerResource
{
    private static final Logger log = Logger.getLogger( ShopifyWebhookResource.class.getName( ) );

    /**
     * Consume an incoming Order event, this method will consume the order and attach it to the userid
     * as determined by the id=? paramater off the request attributes map.  On success we return and HTTP200
     * result, on failure an HTTP500.
     *
     * @return A 200 or 500 http code with empty payload
     */
    @Post
    @Override
    public Representation post( Representation representation, Variant variant )
    {
        try
        {
            // first extract the specific connectster userid that this push is being made for
            String userIdString = ( String )getRequestAttributes( ).get( "id" );
            if( userIdString == null || userIdString.trim( ).isEmpty( ) )
            {
                getResponse( ).setStatus( Status.SERVER_ERROR_INTERNAL );
                return null;
            }

            long userId;
            try
            {
                userId = Long.parseLong( userIdString );
            }
            catch( NumberFormatException x )
            {
                getResponse( ).setStatus( Status.SERVER_ERROR_INTERNAL );
                return null;
            }

            // now extract the order payload and build a shopify version of the order
            String xml = representation.getText( );
            ShopifyOrder order = ShopifyEntityHelper.toShopifyOrder( xml );
            ShopifyAdapter.getInstance( ).addOrder( order, userId );
        }
        catch( Exception x )
        {
            log.warning( "Error encountered reading incoming stream from Shopify: " + x.getMessage( ) );
        }

        return null;
    }
}
