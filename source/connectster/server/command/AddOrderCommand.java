package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IOrder;
import connectster.server.EntityHelper;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.Order;
import org.hibernate.Session;

import java.util.Date;
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
public class AddOrderCommand
implements ICommand<IOrder>
{
    @Override
    public IResponse<IOrder> execute( Session session, Map<String, Object> parameters )
    {
        IResponse<IOrder> response;
        IOrder order = ( IOrder )parameters.get( ICommand.PARAMETER_ORDER );

        try
        {
            Order newOrder = new Order( );
            newOrder.setReceivedAt( new Date( ) );
            newOrder.setAdapterDetails( EntityHelper.getAdapterDetailsById( session, order.getSourceAdapterId( ) ) );
            newOrder.setName( order.getName( ) );
            newOrder.setOwner( EntityHelper.getUserById( session, order.getOwner( ).getId( ) ) );
            newOrder.setSourceId( order.getSourceId( ) );
            session.save( newOrder );
            session.flush( );

            response = new Response<IOrder>( newOrder, IResponse.Status.Successful, "Added Order: " + newOrder );
        }
        catch( Exception x )
        {
            response = new Response<IOrder>( order, IResponse.Status.Failure, "Unable to Add Order: " + order +
                ", Reason: " + x.getMessage( ) );
        }

        return response;
    }
}
