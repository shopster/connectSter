package connectster.adapter.shopify;

import connectster.api.IAdapter;
import connectster.api.IAdapterConnection;
import connectster.api.IResponse;
import connectster.api.entity.*;
import connectster.api.entity.implementation.AdapterDataDTO;
import connectster.api.exceptions.AdapterException;

import java.util.Date;
import java.util.List;
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
public class ShopifyMonitor
{
    private static final String LAST_POLLED_CATEGORY = "LastPolled";
    private static final int POLL_INTERVAL = 10000;
    private static Logger log = Logger.getLogger( ShopifyMonitor.class.getName( ) );

    private IAdapterConnection connection;
    private IAdapter adapter;
    private ShopifyRunnable executor;
    private Thread thread;

    public ShopifyMonitor( IAdapter adapter, IAdapterConnection connection )
    {
        this.connection = connection;
        this.adapter = adapter;
        this.executor = new ShopifyRunnable( );
        this.thread = new Thread( executor );
    }

    public void start( )
    {
        log.info( "ShopsterMonitor starting up.");
        thread.start( );
    }

    public void stop( )
    {
        log.info( "ShopsterMonitor shutting down." );
        executor.stop( );
    }

    private class ShopifyRunnable
    implements Runnable
    {
        private boolean alive = true;

        @Override
        public void run()
        {
            while( alive )
            {
                try
                {
                    log.info( "Executing ShopifyMonitor cycle to synchronize with shopify service." );
                    processProducts( );
                    Thread.sleep( POLL_INTERVAL );
                }
                catch( Exception x )
                {
                    x.printStackTrace( );
                }
            }
        }

        public void processProducts( )
        throws AdapterException
        {
            // get all users registered on the shopster adapter
            IResponse<List<IUser>> userResponse = connection.getAdapterUsers( );
            if( userResponse.getStatus( ) == IResponse.Status.Failure )
            {
                throw new AdapterException( "Unable to retrieve user list for shopster adapter: " + userResponse.getMessage( ) );
            }

            // walk over each user and update their products on each associated adapter
            List<IUser> users = userResponse.getSource( );
            for( IUser user : users )
            {
                log.info( "Polling for new products on shopify for " + user.getName( ) + " [" + user.getId( ) + "]" );

                // grab the last update filter so we can find only products of interest for this user
                Date lastUpdated = null;
                IResponse<IAdapterData> updateResponse = connection.loadData( LAST_POLLED_CATEGORY, String.valueOf( user.getId( ) ) );
                if( updateResponse.getStatus( ) == IResponse.Status.Successful )
                {
                    lastUpdated = ( Date )updateResponse.getSource( ).getValue( );
                }

                // TODO : we must walk over a set of user mappings TO THIS ADAPTER now since we could have multiple shopster stores - change user.getName() to
                // TODO : userMapping.getName(), getting the user mapping by walking a list of all user mappings TO THIS ADAPTER.

                // for each of the products represented, grab each product created since last poll
                List<IProduct> products = adapter.remoteGetProducts( user, user.getName( ), lastUpdated );
                for( IProduct product : products )
                {
                    // verify we do not already have this product mapped in the system, if so just ignore it (no updates from shopify)
                    IResponse<IProductMapping> findProductResponse = connection.getProductMappingBySourceId( product.getSourceId( ) );
                    if( findProductResponse.getStatus( ) == IResponse.Status.Failure )
                    {
                        // add the product and let product monitor pick it up for propagation to all interested adapters
                        IResponse<IProduct> addProductResponse = connection.addProduct( product );
                        if( addProductResponse.getStatus( ) == IResponse.Status.Successful )
                        {
                            log.info( addProductResponse.getMessage( ) );
                        }
                        else
                        {
                            log.warning( addProductResponse.getMessage( ) );
                        }
                    }
                }

                // update the last update filter date
                connection.storeData( new AdapterDataDTO<Date>( LAST_POLLED_CATEGORY, String.valueOf( user.getId( ) ), new Date( ) ) );                    
            }
        }

        public void stop( )
        {
            alive = false;
        }
    }
}
