package connectster.server;

import connectster.api.IAdapter;
import connectster.api.IResponse;
import connectster.api.entity.IOrder;
import connectster.api.entity.IOrderMapping;
import connectster.api.entity.implementation.OrderMappingDTO;
import connectster.server.command.GetOrderByIdCommand;
import connectster.server.command.GetPendingOrdersCommand;
import connectster.server.command.UpdateOrderMappingCommand;

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
public class OrderMonitor
extends Monitor
{
    public static int ORDER_MONITOR_INTERVAL = 5000;
    private static Logger log = Logger.getLogger( OrderMonitor.class.getName( ) );

    public OrderMonitor( final Map<Long, IAdapter> adapters )
    {
        // wire in the monitor implementation
        super( new MonitorRunnable( ORDER_MONITOR_INTERVAL ) {
            @Override
            public void execute( )
            {
                // get pending orders (orders for which update date is null and retry count < MAX_RETRIES
                IResponse<Set<IOrderMapping>> pendingResponse = EntityHelper.execute( new GetPendingOrdersCommand( ), null );
                if( pendingResponse.getStatus( ) == IResponse.Status.Successful )
                {
                    for( IOrderMapping mapping : pendingResponse.getSource( ) )
                    {
                        // always increment our attempt count
                        OrderMappingDTO mappingDTO = new OrderMappingDTO( mapping, mapping.getRetryCount( ) + 1 );
                        IResponse<IOrderMapping> mappingResponse = EntityHelper.execute( new UpdateOrderMappingCommand( ),
                            EntityHelper.listToMap( ICommand.PARAMETER_ORDER_MAPPING, mappingDTO ) );
                        if( mappingResponse.getStatus( ) == IResponse.Status.Failure )
                        {
                            log.warning( "Unable to retrieve existing mapping entity for retry count update, Reason: " +
                                mappingResponse.getMessage( ) );
                        }

                        // now push this order to each of the target adapters
                        IAdapter adapter = adapters.get( mapping.getTargetAdapterId( ) );
                        if( adapter != null )
                        {
                            // attempt to obtain the order by id and then use it to make a remote adapter call
                            IResponse<IOrder> orderResponse = EntityHelper.execute( new GetOrderByIdCommand( ), EntityHelper.listToMap(
                                ICommand.PARAMETER_ORDER_ID, mapping.getOrderId( ) ) );
                            if( orderResponse.getStatus( ) == IResponse.Status.Successful )
                            {
                                IResponse<String> remoteResponse = adapter.remoteAddOrder( orderResponse.getSource( ) );
                                if( remoteResponse.getStatus( ) == IResponse.Status.Failure )
                                {
                                    log.warning( "Unable to send an order to remote adapter: " + mapping.getTargetAdapterId( ) +
                                        ", order id: " + mapping.getOrderId( ) + ", Reason: " + remoteResponse.getMessage( ) );
                                }
                                else
                                {
                                    log.info( "Order sent to remote adapter: " + mapping.getTargetAdapterId( ) +
                                        ", order id: " + mapping.getOrderId( ) + ", Message: " + remoteResponse.getMessage( ) );

                                    IResponse<IOrderMapping> response = EntityHelper.execute( new UpdateOrderMappingCommand( ),
                                        EntityHelper.listToMap( ICommand.PARAMETER_ORDER_MAPPING, new OrderMappingDTO( mapping, new Date( ), 0 ) ) );
                                    if( response.getStatus( ) == IResponse.Status.Failure )
                                    {
                                        log.warning( "Unable to update order mapping: " + mappingDTO + ", Reason: " +
                                            response.getMessage( ) );
                                    }
                                }
                            }
                        }
                    }
                }
                else
                {
                    log.warning( "Error occured attempting to fetch out of date orders, Reason: " + pendingResponse.getMessage( ) );
                }
            }
        } );
    }
}
