package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IOrder;
import connectster.api.entity.IOrderMapping;
import connectster.api.entity.IUser;
import connectster.api.entity.IUserMapping;
import connectster.server.EntityHelper;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.OrderMapping;
import org.hibernate.Session;

import java.util.HashSet;
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
public class BuildOrderMappingsCommand
implements ICommand<Set<IOrderMapping>>
{
    @Override
    public IResponse<Set<IOrderMapping>> execute( Session session, Map<String, Object> parameters )
    {
        IResponse<Set<IOrderMapping>> response;
        Set<IOrderMapping> results = new HashSet<IOrderMapping>( );
        IOrder order = ( IOrder )parameters.get( ICommand.PARAMETER_ORDER );
        long userId = ( Long )parameters.get( ICommand.PARAMETER_USER_ID );

        try
        {
            // for each target user mapping, create an order mapping with a fresh retry count and no update
            IUser user = EntityHelper.getUserById( session, userId );
            for( IUserMapping userMapping : user.getUserMappings( ).values( ) )
            {
                // no need to send this order back to sender
                if( userMapping.getTargetAdapterId( ) == order.getSourceAdapterId( ) )
                {
                    continue;
                }
                
                OrderMapping mapping = new OrderMapping( );
                mapping.setOrderId( order.getId( ) );
                mapping.setRetryCount( 0 );
                mapping.setUpdatedOn( null );
                mapping.setTargetAdapterId( userMapping.getTargetAdapterId( ) );
                session.save( mapping );
                session.flush( );
            }

            response = new Response<Set<IOrderMapping>>( results, IResponse.Status.Successful, "Added Order Mappings for: " +
                order.getId( ) );
        }
        catch( Exception x )
        {
            response = new Response<Set<IOrderMapping>>( null, IResponse.Status.Failure, "Unable to Add Order Mappings for: " +
                order.getId( ) + ", Reason: " + x.getMessage( ) );
        }

        return response;
    }
}
