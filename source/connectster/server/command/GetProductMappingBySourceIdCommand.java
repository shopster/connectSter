package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IProductMapping;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.ProductMapping;
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
public class GetProductMappingBySourceIdCommand
implements ICommand<IProductMapping>
{
    @Override
    public IResponse<IProductMapping> execute( Session session, Map<String, Object> parameters )
    {
        IResponse<IProductMapping> response;
        long adapterId = ( Long )parameters.get( ICommand.PARAMETER_ADAPTER_ID );
        String sourceId = ( String )parameters.get( ICommand.PARAMETER_SOURCE_ID );

        try
        {
            Criteria productMappingCriteria = session.createCriteria( ProductMapping.class );
            productMappingCriteria.add( Restrictions.eq( "destinationAdapterId", adapterId ) );
            productMappingCriteria.add( Restrictions.eq( "destinationId", sourceId ) );

            IProductMapping mapping = ( IProductMapping )productMappingCriteria.uniqueResult( );
            if( mapping == null )
            {
                response = new Response<IProductMapping>( null, IResponse.Status.Failure, "Unable to Find Product Mapping: " + sourceId );
            }
            else
            {
                response = new Response<IProductMapping>( mapping, IResponse.Status.Successful, "Found Product Mapping: " + sourceId );
            }
        }
        catch( Exception x )
        {
            response = new Response<IProductMapping>( null, IResponse.Status.Failure, "Unable to Find Product Mapping: " + sourceId +
                ", Reason: " + x.getMessage( ) );
        }

        return response;
    }
}
