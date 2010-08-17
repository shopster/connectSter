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

public class UnmapProductCommand
implements ICommand<IProductMapping>
{
    @Override
    public IResponse<IProductMapping> execute( Session session, Map<String, Object> parameters )
    {
        IResponse<IProductMapping> response;
        IProductMapping mapping = ( IProductMapping )parameters.get( ICommand.PARAMETER_PRODUCT_MAPPING );
                                                    
        try
        {
            Criteria mappingCriteria = session.createCriteria( ProductMapping.class );
            mappingCriteria.add( Restrictions.eq( "productId", mapping.getProductId( ) ) );
            mappingCriteria.add( Restrictions.eq( "destinationAdapterId", mapping.getTargetAdapterId( ) ) );
            mappingCriteria.add( Restrictions.eq( "destinationId", mapping.getTargetProductId( ) ) );

            ProductMapping productMapping = ( ProductMapping )mappingCriteria.uniqueResult( );
            session.delete( productMapping );

            response = new Response<IProductMapping>( productMapping, IResponse.Status.Successful, "Unmapped Product: " +
                productMapping.getProductId( ) + " to " + productMapping.getTargetProductId( ) );
        }
        catch( Exception x )
        {
            response = new Response<IProductMapping>( mapping, IResponse.Status.Failure, "Unable to Map Product: " +
                mapping.getProductId( ) + " to " + mapping.getTargetProductId( ) + ", Reason: " + x.getMessage( ) );
        }

        return response;
    }
}
