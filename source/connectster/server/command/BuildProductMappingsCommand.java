package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IUser;
import connectster.api.entity.IUserMapping;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.Product;
import connectster.server.entity.ProductMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;
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
public class BuildProductMappingsCommand
implements ICommand<Integer>
{
    @Override
    @SuppressWarnings( "unchecked" )
    public IResponse<Integer> execute( Session session, Map<String, Object> parameters )
    {
        IUser user = ( IUser )parameters.get( ICommand.PARAMETER_USER );
        IUserMapping userMapping = ( IUserMapping )parameters.get( ICommand.PARAMETER_USER_MAPPING );
        int count = 0;

        try
        {
            Criteria productCriteria = session.createCriteria( Product.class );
            productCriteria.add( Restrictions.eq( "owner", user ) );
            productCriteria.setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY );

            List<Product> products = ( List<Product> )productCriteria.list( );
            for( Product product : products )
            {
                ProductMapping mapping = new ProductMapping( );
                mapping.setUpdatedOn( null );
                mapping.setDestinationId( "*PENDING*" + product.getId( ) );
                mapping.setDestinationUserId( userMapping.getTargetUserId( ) );
                mapping.setRetryCount( 0 );
                mapping.setAdapter( userMapping.getTargetAdapterId( ) );
                mapping.setProductId( product.getId( ) );
                session.save( mapping );
                session.flush( );

                count++;
            }

            return new Response<Integer>( count, IResponse.Status.Successful, "Product Mappings Created" );
        }
        catch( Exception x )
        {
            return new Response<Integer>( count, IResponse.Status.Failure, x.getMessage( ) );
        }
    }
}
