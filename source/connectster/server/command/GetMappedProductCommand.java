package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IProductMapping;
import connectster.api.entity.implementation.ProductMappingDTO;
import connectster.api.exceptions.AdapterException;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.Product;
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
        long sourceAdapterId = ( Long )parameters.get( ICommand.PARAMETER_ADAPTER_ID );
        long sourceProductId = ( Long )parameters.get( ICommand.PARAMETER_PRODUCT_ID );
        String targetUserId = ( String )parameters.get( ICommand.PARAMETER_TARGET_USER_ID );

        try
        {
            Criteria mappingCritera = session.createCriteria( ProductMapping.class );
            mappingCritera.add( Restrictions.eq( "destinationAdapterId", sourceAdapterId  ) );
            mappingCritera.add( Restrictions.eq( "productId", sourceProductId ) );
            mappingCritera.add( Restrictions.eq( "destinationUserId", targetUserId ) );

            // locate a mapping for this product, if it exists
            IProductMapping productMapping = ( ProductMapping )mappingCritera.uniqueResult( );
            if( productMapping == null )
            {
                // no mapping exists, this might mean that we want to find the source "mapping" which is really the product source id
                Criteria productCriteria = session.createCriteria( Product.class );
                productCriteria.add( Restrictions.eq( "id", sourceProductId ) );

                Product product = ( Product )productCriteria.uniqueResult( );
                if( product == null )
                {
                    throw new AdapterException( "Failed to find mapped user for: " + sourceAdapterId + ", " + sourceProductId );
                }

                productMapping = new ProductMappingDTO( product.getAdapterDetails( ).getId( ), product.getSourceAdapterId( ),
                    product.getSourceId( ), targetUserId, product.getLastUpdate( ) ); 
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
