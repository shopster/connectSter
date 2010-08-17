package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IProduct;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.Product;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
 * GetOutOfDateProductsCommand will retrieve all products for which there is a last update mismatch between the product
 * and its associated mappings.  If a product has a last update which is different, it means the product has been updated
 * and is now out of sync with its mappings and should be pushed to the associated adapter as specified in that mapping.
 *  
 * Note: For now this command will continually retry pushes, assuming that at some point we will get through, but there
 * should be a means of scaling back attempts or cancelling to handle errant adapters, etc...
 */
public class GetOutOfDateProductsCommand
implements ICommand<Set<IProduct>>
{
    private static final int MAX_RETRIES = 3;
    private static final String hql = "from Product p left outer join p.mappings as pm " +
        "where p.lastUpdate <> pm.updatedOn or ( pm.updatedOn is null and pm.retryCount < " + MAX_RETRIES + " )";

    @Override
    @SuppressWarnings( "unchecked" )
    public IResponse<Set<IProduct>> execute( Session session, Map<String, Object> parameters )
    {
        IResponse<Set<IProduct>> response;
        Set<IProduct> products = new HashSet<IProduct>( );

        try
        {
            // Criteria API preferred, refactor when http://opensource.atlassian.com/projects/hibernate/browse/HHH-2049 resolved.
            Query query = session.createQuery( hql );
            List<Object[ ]> rows = query.list( );
            for( Object[ ] row : rows )
            {
                Product product = ( Product )row[ 0 ];
                if( !products.contains( product ) )
                {
                    products.add( product );                    
                }
            }

            response = new Response<Set<IProduct>>( products, IResponse.Status.Successful, "Retrieved all out of date products successfully." );
        }
        catch( Exception x )
        {
            response = new Response<Set<IProduct>>( products, IResponse.Status.Failure, "Error retrieving out of date products: " +
                x.getMessage( ) );
        }

        return response;
    }
}
