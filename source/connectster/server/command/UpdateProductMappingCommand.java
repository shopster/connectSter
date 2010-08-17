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
public class UpdateProductMappingCommand
implements ICommand<IProductMapping>
{
    @Override
    public IResponse<IProductMapping> execute( Session session, Map<String, Object> parameters )
    {
        IProductMapping mapping = ( IProductMapping )parameters.get( ICommand.PARAMETER_PRODUCT_MAPPING );

        IResponse<IProductMapping> response;
        try
        {
            Criteria mappingCritiera = session.createCriteria( ProductMapping.class );
            mappingCritiera.add( Restrictions.eq( "productId", mapping.getProductId( ) ) );
            mappingCritiera.add( Restrictions.eq( "destinationId", mapping.getTargetProductId( ) ) );
            mappingCritiera.add( Restrictions.eq( "destinationAdapterId", mapping.getTargetAdapterId( ) ) );

            ProductMapping trustedMapping = ( ProductMapping )mappingCritiera.uniqueResult( );
            trustedMapping.setUpdatedOn( mapping.getUpdatedOn( ) );
            trustedMapping.setRetryCount( mapping.getRetryCount( ) );
            session.update( trustedMapping );
            session.flush( );

            response = new Response<IProductMapping>( mapping, IResponse.Status.Successful );
        }
        catch( Exception x )
        {
            response = new Response<IProductMapping>( mapping, IResponse.Status.Failure, x.getMessage( ) );
        }

        return response;
    }
}
