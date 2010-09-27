package connectster.server;

import connectster.api.IAdapter;
import connectster.api.IResponse;
import connectster.api.entity.IProduct;
import connectster.api.entity.IProductMapping;
import connectster.api.entity.implementation.ProductMappingDTO;
import connectster.server.command.*;

import java.util.Date;
import java.util.Map;
import java.util.Set;
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
public class ProductMonitor
extends Monitor
{
    public static int PRODUCT_MONITOR_INTERVAL = 10000;
    private static Logger log = Logger.getLogger( ProductMonitor.class.getName( ) );

    public ProductMonitor( final Map<Long, IAdapter> adapters )
    {
        // wire in the monitor implementation
        super( new MonitorRunnable( PRODUCT_MONITOR_INTERVAL ) {
            @Override
            public void execute( )
            {
                IResponse<Set<IProduct>> productResponse = EntityHelper.execute( new GetOutOfDateProductsCommand( ), ICommand.NO_PARAMETERS );
                if( productResponse.getStatus( ) == IResponse.Status.Successful )
                {
                    // walk over each product and check mappings to add/update product remotely
                    for( IProduct product : productResponse.getSource( ) )
                    {
                        // walk over each mapping for this product, checking for out of date (remote update) or null (remote add)
                        for( IProductMapping productMapping : product.getMappings( ) )
                        {
                            // no self-mappings here please
                            if( productMapping.getTargetAdapterId( ) == product.getSourceAdapterId( ) )
                            {
                                continue;
                            }

                            // obtain target adapter and guard against it not being present (adapter was deleted w/o cascade?)
                            IAdapter targetAdapter = adapters.get( productMapping.getTargetAdapterId( ) );
                            if( targetAdapter == null )
                            {
                                log.warning( "Unable to locate target adapter for remote send, adapter id: " +
                                    productMapping.getTargetAdapterId( ) + " was called for on product id: " + product.getId( ) );
                                continue;
                            }

                            // never been updated, time to add
                            if( productMapping.getUpdatedOn( ) == null )
                            {
                                addProduct( targetAdapter, product, productMapping );
                            }
                            else
                            if( productChanged( product, productMapping ) )
                            {
                                updateProduct( targetAdapter, product, productMapping );
                            }
                        }
                    }
                }
                else
                {
                    log.warning( "Error occurred attempting to fetch out of date products, Reason: " + productResponse.getMessage( ) );
                }
            }
        } );
    }

    private static boolean productChanged( IProduct product, IProductMapping productMapping )
    {
        return productMapping.getUpdatedOn( ).compareTo( product.getLastUpdate( ) ) == -1;
    }

    /** Updates a given product based on the provided product mapping and target adapter.  If the product does not
     *  exist remotely, then no product will be added..
     *
     * @param targetAdapter The target adapter to send this product to.
     * @param product The product details to send.
     * @param mapping The mapping to use in updating timestamps, etc..
     */
    private static void updateProduct( IAdapter targetAdapter, IProduct product, IProductMapping mapping )
    {
        IResponse<IProduct> response = targetAdapter.remoteUpdateProduct( product, mapping );
        if( response.getStatus( ) == IResponse.Status.Successful )
        {
            // build a new product mapping which we will use to update the timestamp so it is not considered out of date by monitor
            ProductMappingDTO newMapping = new ProductMappingDTO( mapping );
            newMapping.setUpdatedOn( new Date( ) );
            newMapping.setRetryCount( 0 );

            // on failure we can't really do much, log the message as a warning and proceed, no retry fails (yet)
            IResponse<IProductMapping> mappingResponse = EntityHelper.execute( new UpdateProductMappingCommand( ),
                EntityHelper.listToMap( ICommand.PARAMETER_PRODUCT_MAPPING, newMapping ) );
            if( mappingResponse.getStatus( ) == IResponse.Status.Failure )
            {
                log.warning( "Product mapping failed to update timestamp, this could lead to repeated attempts to send: "
                    + mappingResponse.getMessage( ) );
            }
        }

        log.info( "ProductMonitor update product response: " + response.getMessage( ) );
    }

    private static void addProduct( IAdapter targetAdapter, IProduct product, IProductMapping productMapping )
    {
        // add the product to the remote system
        IResponse<IProductMapping> addProductResponse = targetAdapter.remoteAddProduct( productMapping.getTargetUserId( ), product );
        if( addProductResponse.getStatus( ) == IResponse.Status.Failure )
        {
            log.warning( "Unable to remotely add the product id: " + product.getId( ) + ", Reason: " +
                addProductResponse.getMessage( ) );

            IResponse<IProductMapping> updateMappingResponse = EntityHelper.execute( new IncrementProductMappingRetryCountCommand( ),
                EntityHelper.listToMap( ICommand.PARAMETER_PRODUCT_MAPPING, productMapping ) );
            if( updateMappingResponse.getStatus( ) == IResponse.Status.Failure )
            {
                log.warning( "Unable to update retry count for productMapping to product id: " + product.getId( ) +
                    ", Reason: " + updateMappingResponse.getMessage( ) );
            }
        }
        else
        {
            // update the initial mapping with an actual target product id
            EntityHelper.execute( new UnmapProductCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_PRODUCT_MAPPING, productMapping ) );
            ProductMappingDTO mapping = new ProductMappingDTO( productMapping );
            mapping.setTargetProductId( addProductResponse.getSource( ).getTargetProductId( ) );
            mapping.setUpdatedOn( new Date( ) );
            
            IResponse<IProductMapping> readdMappingResponse = EntityHelper.execute( new MapProductCommand( ), EntityHelper.listToMap(
                ICommand.PARAMETER_PRODUCT_MAPPING, mapping ) );
            if( readdMappingResponse.getStatus( ) == IResponse.Status.Failure )
            {
                log.warning( "Unable to map product id: " + product.getId( ) + " to adapter id: " + productMapping.getTargetAdapterId( ) +
                    ", this could result in multiple products on remote adapter so product is being deleted, source was: " + product.getSourceAdapterId( ) +
                    "/" + product.getSourceId( ) + ", Reason: " + readdMappingResponse.getMessage( ) );
                EntityHelper.execute( new RemoveProductCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_PRODUCT_ID, product.getId( ) ) );
            }
        }
    }
}
