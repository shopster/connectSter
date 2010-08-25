package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IOrder;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.Order;
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
public class GetOrderByIdCommand
implements ICommand<IOrder>
{
    @Override
    public IResponse<IOrder> execute( Session session, Map<String, Object> parameters )
    {
        IResponse<IOrder> response;
        long orderId = ( Long )parameters.get( ICommand.PARAMETER_ORDER_ID );

        try
        {
            Criteria orderCriteria = session.createCriteria( Order.class );
            orderCriteria.add( Restrictions.eq( "id", orderId ) );
            Order order = ( Order )orderCriteria.uniqueResult( );
            response = new Response<IOrder>( order, IResponse.Status.Successful, "Found Order: " + orderId );
        }
        catch( Exception x )
        {
            response = new Response<IOrder>( null, IResponse.Status.Failure, "Unable to Find Order: " + orderId +
                ", Reason: " + x.getMessage( ) );
        }

        return response;

    }
}
