package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IProduct;
import connectster.api.exceptions.AdapterException;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.Product;
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
                throw new AdapterException( "No product found for : " + adapterId + "/" + productSourceId + "/" + ownerId );
            }

            response = new Response<IProduct>( product, IResponse.Status.Successful, "Product Added: " + adapterId +
                "/" + productSourceId + "/" + ownerId );
        }
        catch( Exception x )
        {
            response = new Response<IProduct>( null, IResponse.Status.Failure, "Unable to Add Product: " + adapterId +
                productSourceId + ownerId + ", Reason: " + x.getMessage( ) );
        }

        return response;
    }
}
