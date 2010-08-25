package connectster.adapter.shopster;

import connectster.api.IAdapterConnection;
import connectster.api.IResponse;
import connectster.api.entity.*;
import connectster.api.entity.implementation.AdapterDataDTO;
import connectster.api.entity.implementation.ProductMappingDTO;
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
public class ShopsterMonitor
{
    private static final String LAST_UPDATED_CATEGORY = "LastUpdated";
    private static final int POLL_INTERVAL = 2000;
    private static Logger log = Logger.getLogger( ShopsterAdapter.class.getName( ) );

    private ShopsterAdapter adapter;
    private ShopsterRunnable executor;
    private IAdapterConnection connection;
    private Thread thread;

    public ShopsterMonitor( ShopsterAdapter adapter, IAdapterConnection connection )
    {
        this.adapter = adapter;
        this.connection = connection;
        this.executor = new ShopsterRunnable( );
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

    private class ShopsterRunnable
    implements Runnable
    {
        private boolean alive = true;

        @Override
        public void run( )
        {
            while( alive )
            {
                try
                {
                    log.info( "Executing ShopsterMonitor cycle to synchronize with shopster service." );
                    processProducts( );
                }
                catch( Exception x )
                {
                    x.printStackTrace( );
                }
            }
        }

        private void processProducts( )
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
                log.info( "Processing requests for " + user.getName( ) + " [" + user.getId( ) + "]" );

                // grab the last update filter so we can find only products of interest for this user
                Date lastUpdated = null;
                IResponse<IAdapterData> updateResponse = connection.loadData( LAST_UPDATED_CATEGORY, String.valueOf( user.getId( ) ) );
                if( updateResponse.getStatus( ) == IResponse.Status.Successful )
                {
                    lastUpdated = ( Date )updateResponse.getSource( ).getValue( );
                }

                try
                {
                    // store the time of query (could be negotiated with server for better accuracy)
                    Date currentDate = new Date( );

                    // get all products for this user on the remote shopster system
                    List<IProduct> products = adapter.remoteGetProducts( user, lastUpdated );
                    for( IProduct product : products )
                    {
                        // retrieve products by their source id to check if this is an update or (if not present) an addition
                        IResponse<IProduct> productResponse = connection.getProductBySource( user.getId( ), product.getSourceId( ) );
                        if( productResponse.getStatus( ) == IResponse.Status.Successful )
                        {
                            // don't update the product mappings since the monitor will check for lastUpdate conflicts anyhow
                            long productId = productResponse.getSource( ).getId( );
                            IResponse<IProduct> response = connection.updateProduct( productId, product );
                            log.info( "   Existing product: " + product.getName( ) + ", Message: " + response.getMessage( ) );
                        }
                        else
                        {
                            // create a new product with mappings 
                            IResponse<IProduct> addedProductResponse = connection.addProduct( product );
                            if( addedProductResponse.getStatus( ) == IResponse.Status.Successful )
                            {
                                IProduct newProduct = addedProductResponse.getSource( );
                                for( IUserMapping userMapping : user.getUserMappings( ).values( ) )
                                {
                                    // to avoid superflous duplicates, guard this value - this needs a better approach
                                    ProductMappingDTO productMapping = new ProductMappingDTO( userMapping.getTargetAdapterId( ),
                                        newProduct.getId( ), "*PENDING*" + newProduct.getSourceId( ), null );

                                    IResponse<IProductMapping> productMappingResponse = connection.mapProduct( productMapping );
                                    if( productMappingResponse.getStatus( ) == IResponse.Status.Failure )
                                    {
                                        log.warning( "Unable to map product id: " + newProduct.getId( ) + " to adapter id: " +
                                            userMapping.getTargetAdapterId( ) + " for user id: " + userMapping.getTargetUserId( ) );
                                    }
                                }
                            }

                            log.info( "   New product: " + product.getName( ) + ", Message: " + addedProductResponse.getMessage( ) );
                        }
                    }

                    // update the last update filter date
                    connection.storeData( new AdapterDataDTO<Date>( LAST_UPDATED_CATEGORY, String.valueOf( user.getId( ) ), currentDate ) );
                }
                catch( Exception x )
                {
                    x.printStackTrace( );
                    log.warning( "    Unable to retrieve products for user: " + user.getName( ) + " [" + user.getId( ) +
                        "], Reason: " + x.getMessage( ) + " - the last updated timestamp will not be changed so this can be attempted again." );
                }
            }

            try
            {
                Thread.sleep( POLL_INTERVAL );
            }
            catch( InterruptedException x )
            {
                log.warning( "ShopsterMonitor polling thread sleep call was interrupted, could cause resource issues: " + x.getMessage( ) );
            }
        }

        public void stop( )
        {                                    
            alive = false;
        }
    }
}
