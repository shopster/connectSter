package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IProduct;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.Product;
import connectster.server.entity.ProductMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Map;

public class GetProductBySourceCommand
implements ICommand<IProduct>
{
    @Override
    public IResponse<IProduct> execute( Session session, Map<String, Object> parameters )
    {
        IResponse<IProduct> response;
        long adapterId = ( Long )parameters.get( ICommand.PARAMETER_ADAPTER_ID );
        String productSourceId = ( String )parameters.get( ICommand.PARAMETER_PRODUCT_SOURCE_ID );
        long ownerId = ( Long )parameters.get( ICommand.PARAMETER_OWNER_ID );

        try
        {
            Criteria productCriteria = session.createCriteria( Product.class );
            productCriteria.add( Restrictions.eq( "sourceId", productSourceId ) );
            productCriteria.add( Restrictions.eq( "owner.id", ownerId ) );
            productCriteria.add( Restrictions.eq( "adapterDetails.id", adapterId ) );

            Product product = ( Product )productCriteria.uniqueResult( );
            if( product == null )
            {
                Criteria productMapCritiera = session.createCriteria( ProductMapping.class );
                productMapCritiera.add( Restrictions.eq( "destinationId", productSourceId ) );
                productMapCritiera.add( Restrictions.eq( "destinationAdapterId", adapterId ) );
                ProductMapping mapping = ( ProductMapping )productMapCritiera.uniqueResult( );
                if( mapping == null )
                {
                    return new Response<IProduct>( null, IResponse.Status.Failure, "Unable to find Product: " + adapterId +
                        productSourceId + ownerId + ", unable to find fallback mapping." );
                }

                Criteria productIdCriteria = session.createCriteria( Product.class );
                productIdCriteria.add( Restrictions.eq( "id", mapping.getProductId( ) ) );
                product = ( Product )productIdCriteria.uniqueResult( );
                if( product == null )
                {
                    return new Response<IProduct>( null, IResponse.Status.Failure, "Unable to find Product: " + adapterId +
                        productSourceId + ownerId + ", unable to locate mapped to product by id" );                    
                }
            }

            response = new Response<IProduct>( product, IResponse.Status.Successful, "Product found: " + adapterId +
                "/" + productSourceId + "/" + ownerId );
        }
        catch( Exception x )
        {
            response = new Response<IProduct>( null, IResponse.Status.Failure, "Unable to find Product: " + adapterId +
                productSourceId + ownerId + ", Reason: " + x.getMessage( ) );
        }

        return response;
    }
}
