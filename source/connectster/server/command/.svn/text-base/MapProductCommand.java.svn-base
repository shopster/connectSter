package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IProductMapping;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.Product;
import connectster.server.entity.ProductMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Map;

public class MapProductCommand
implements ICommand<IProductMapping>
{
    @Override
    public IResponse<IProductMapping> execute( Session session, Map<String, Object> parameters )
    {
        IProductMapping mapping = ( IProductMapping )parameters.get( ICommand.PARAMETER_PRODUCT_MAPPING );

        try
        {
            Criteria productCriteria = session.createCriteria( Product.class );
            productCriteria.add( Restrictions.eq( "id", mapping.getProductId( ) ) );

            Product product = ( Product )productCriteria.uniqueResult( );
            if( product == null || product.getAdapterDetails( ).getId( ) == mapping.getTargetAdapterId( ) )
            {
                return new Response<IProductMapping>( mapping, IResponse.Status.Failure, "No product or source adapter mapping: " +
                    mapping.getProductId( ) + " to " + mapping.getTargetProductId( ) );
            }

            ProductMapping newMapping = new ProductMapping( );
            newMapping.setAdapter( mapping.getTargetAdapterId( ) );
            newMapping.setDestinationId( mapping.getTargetProductId( ) );
            newMapping.setProductId( mapping.getProductId( ) );
            newMapping.setUpdatedOn( mapping.getUpdatedOn( ) );
            session.save( newMapping );
            session.flush( );

            return new Response<IProductMapping>( mapping, IResponse.Status.Successful, "Mapped Product: " +
                mapping.getProductId( ) + " to " + mapping.getTargetProductId( ) );
        }
        catch( Exception x )
        {
            return new Response<IProductMapping>( mapping, IResponse.Status.Failure, "Unable to Map Product: " +
                mapping.getProductId( ) + " to " + mapping.getTargetProductId( ) + ", Reason: " + x.getMessage( ) );
        }
    }
}
