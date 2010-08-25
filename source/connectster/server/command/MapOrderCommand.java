package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IOrderMapping;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.Order;
import connectster.server.entity.OrderMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Map;

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
public class MapOrderCommand
implements ICommand<IOrderMapping>
{
    @Override
    public IResponse<IOrderMapping> execute( Session session, Map<String, Object> parameters )
    {
        IOrderMapping orderMapping = ( IOrderMapping )parameters.get( ICommand.PARAMETER_ORDER_MAPPING );

        try
        {
            Criteria orderCriteria = session.createCriteria( Order.class );
            orderCriteria.add( Restrictions.eq( "id", orderMapping.getOrderId( ) ) );

            Order order = ( Order )orderCriteria.uniqueResult( );
            if( order == null || order.getSourceAdapterId( ) == orderMapping.getTargetAdapterId( ) )
            {
                return new Response<IOrderMapping>( orderMapping, IResponse.Status.Failure, "No product or source adapter mapping: " +
                    orderMapping.getOrderId( ) + " to " + orderMapping.getTargetAdapterId( ) );
            }

            OrderMapping newMapping = new OrderMapping( );
            newMapping.setRetryCount( orderMapping.getRetryCount( ) );
            newMapping.setUpdatedOn( orderMapping.getUpdatedOn( ) );
            newMapping.setOrderId( orderMapping.getOrderId( ) );
            newMapping.setTargetAdapterId( orderMapping.getTargetAdapterId( ) );
            session.save( newMapping );
            session.flush( );

            return new Response<IOrderMapping>( orderMapping, IResponse.Status.Successful, "Mapped Order Successfully: " +
                orderMapping.getOrderId( ) + " on adapter: " + orderMapping.getTargetAdapterId( ) );
        }
        catch( Exception x )
        {
            return new Response<IOrderMapping>( orderMapping, IResponse.Status.Failure, "Failed to map order: " +
                orderMapping.getOrderId( ) + ", Reason: " + x.getMessage( ) );
        }
    }
}
