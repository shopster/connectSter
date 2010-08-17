package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IOrderMapping;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.OrderMapping;
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
 */
public class GetPendingOrdersCommand
implements ICommand<Set<IOrderMapping>>
{
    private static final int MAX_RETRIES = 3;
    private static final String HQL = "from OrderMapping as om where om.updatedOn is null and om.retryCount < " + MAX_RETRIES;

    /** This command assumes that the mappings have already been created when the order was added into the system.  If an
     *  order has not been successfully sent and verified, then it will have a null updatedOn timestamp and a retryCount
     *  to identify the number of attempts.
     */
    @Override
    @SuppressWarnings( "unchecked" )
    public IResponse<Set<IOrderMapping>> execute( Session session, Map<String, Object> parameters )
    {
        IResponse<Set<IOrderMapping>> response;
        Set<IOrderMapping> mappings = new HashSet<IOrderMapping>( );

        try
        {
            // Criteria API preferred, refactor when http://opensource.atlassian.com/projects/hibernate/browse/HHH-2049 resolved.
            Query query = session.createQuery( HQL );
            List<OrderMapping> results = query.list( );
            for( OrderMapping mapping : results )
            {
                if( !mappings.contains( mapping ) )
                {
                    mappings.add( mapping );
                }
            }

            response = new Response<Set<IOrderMapping>>( mappings, IResponse.Status.Successful, "Retrieved all out of date products successfully." );
        }
        catch( Exception x )
        {
            response = new Response<Set<IOrderMapping>>( mappings, IResponse.Status.Failure, "Error retrieving out of date products: " +
                x.getMessage( ) );
        }

        return response;
    }
}
