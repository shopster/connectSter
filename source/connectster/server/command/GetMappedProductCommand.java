package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IProductMapping;
import connectster.api.exceptions.AdapterException;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.ProductMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Map;

public class GetMappedProductCommand
implements ICommand<IProductMapping>
{
    @Override
    public IResponse<IProductMapping> execute( Session session, Map<String, Object> parameters )
    {
        IResponse<IProductMapping> response;
        long sourceAdapterId = ( Long )parameters.get( ICommand.PARAMETER_SOURCE_ADAPTER_ID );
        long sourceProductId = ( Long )parameters.get( ICommand.PARAMETER_PRODUCT_ID );

        try
        {
            Criteria mappingCritera = session.createCriteria( ProductMapping.class );
            mappingCritera.add( Restrictions.eq( "destinationAdapterId", sourceAdapterId  ) );
            mappingCritera.add( Restrictions.eq( "productId", sourceProductId ) );

            ProductMapping productMapping = ( ProductMapping )mappingCritera.uniqueResult( );
            if( productMapping == null )
            {
                throw new AdapterException( "Failed to find mapped user for: " + sourceAdapterId + ", " + sourceProductId );
            }

            response = new Response<IProductMapping>( productMapping, IResponse.Status.Successful, "Found product mapping: " +
                productMapping.getTargetProductId( ) + "/" + productMapping.getTargetAdapterId( ) );
        }
        catch( Exception x )
        {
            response = new Response<IProductMapping>( null, IResponse.Status.Failure, "Unable to find product mapping: " +
                sourceAdapterId + "/" + sourceProductId + ", Reason: " + x.getMessage( ) );
        }

        return response;
    }
}
