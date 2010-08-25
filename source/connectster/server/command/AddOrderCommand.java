package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IOrder;
import connectster.api.entity.IOrderItem;
import connectster.api.entity.IProduct;
import connectster.server.EntityHelper;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.Order;
import connectster.server.entity.OrderItem;
import org.hibernate.Session;

import java.util.Date;
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
            newOrder.setBillingCity( order.getBillingCity( ) );
            newOrder.setBillingCountry( order.getBillingCountry( ) );
            newOrder.setBillingName( order.getBillingName( ) );
            newOrder.setBillingPostalCode( order.getBillingPostalCode( ) );
            newOrder.setBillingRegion( order.getBillingRegion( ) );
            newOrder.setBillingStreet1( order.getBillingStreet1( ) );
            newOrder.setBillingStreet2( order.getBillingStreet2( ) );
            newOrder.setReceivedAt( order.getReceivedAt( ) );
            newOrder.setShippingCity( order.getShippingCity( ) );
            newOrder.setShippingCountry( order.getShippingCountry( ) );
            newOrder.setShippingMethod( order.getShippingMethod( ) );
            newOrder.setShippingName( order.getShippingName( ) );
            newOrder.setShippingPostalCode( order.getShippingPostalCode( ) );
            newOrder.setShippingRegion( order.getShippingRegion( ) );
            newOrder.setShippingStreet1( order.getShippingStreet1( ) );
            newOrder.setShippingStreet2( order.getShippingStreet2( ) );
            newOrder.setSourceId( order.getSourceId( ) );

            Set<IOrderItem> orderItems = new HashSet<IOrderItem>( );
            for( IOrderItem orderItem : order.getItems( ) )
            {
                IResponse<IProduct> productResponse = new GetProductBySourceCommand( ).execute( session, EntityHelper.listToMap(
                    ICommand.PARAMETER_ADAPTER_ID, orderItem.getProduct( ).getSourceAdapterId( ), ICommand.PARAMETER_PRODUCT_SOURCE_ID,
                    orderItem.getProduct( ).getSourceId( ), ICommand.PARAMETER_OWNER_ID, orderItem.getProduct( ).getOwner( ).getId( ) ) );
                if( productResponse.getStatus( ) == IResponse.Status.Failure )
                {
                    return new Response<IOrder>( null, IResponse.Status.Failure, "Unable to retrieve productid: " + orderItem.getProduct( ).getSourceId( )+
                        " mapped by adapterid: " + orderItem.getProduct( ).getSourceAdapterId( ) + ", aborting order request." );
                }

                OrderItem item = new OrderItem( );
                item.setOrder( newOrder );
                item.setProduct( productResponse.getSource( ) );
                item.setQuantity( orderItem.getQuantity( ) );
                orderItems.add( item );
            }
            newOrder.setItems( orderItems );
            
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
