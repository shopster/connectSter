package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IOrderMapping;
import connectster.server.ICommand;
import connectster.server.Response;
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
public class UpdateOrderMappingCommand
implements ICommand<IOrderMapping>
{
    @Override
    public IResponse<IOrderMapping> execute( Session session, Map<String, Object> parameters )
    {
        IResponse<IOrderMapping> response;
        IOrderMapping mappingParameter = ( IOrderMapping )parameters.get( ICommand.PARAMETER_ORDER_MAPPING );

        try
        {
            Criteria mappingCriteria = session.createCriteria( OrderMapping.class );
            mappingCriteria.add( Restrictions.eq( "orderId", mappingParameter.getOrderId( ) ) );
            mappingCriteria.add( Restrictions.eq( "targetAdapterId", mappingParameter.getTargetAdapterId( ) ) );

            OrderMapping mapping = ( OrderMapping )mappingCriteria.uniqueResult( );
            mapping.setRetryCount( mappingParameter.getRetryCount( ) );
            mapping.setUpdatedOn( mappingParameter.getUpdatedOn( ) );
            session.save( mapping );
            session.flush( );

            response = new Response<IOrderMapping>( null, IResponse.Status.Successful, "Added Product: " );
        }
        catch( Exception x )
        {
            response = new Response<IOrderMapping>( null, IResponse.Status.Failure, "Unable to Add Product: " +
                ", Reason: " + x.getMessage( ) );
        }

        return response;
    }
}
