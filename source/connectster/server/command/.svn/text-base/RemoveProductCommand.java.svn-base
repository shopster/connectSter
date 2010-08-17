package connectster.server.command;

import connectster.api.IResponse;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Map;

public class RemoveProductCommand
implements ICommand<Long>
{
    @Override
    public IResponse<Long> execute( Session session, Map<String, Object> parameters )
    {
        IResponse<Long> response;
        long productId = ( Long )parameters.get( ICommand.PARAMETER_PRODUCT_ID );

        try
        {
            Criteria productCriteria = session.createCriteria( Product.class );
            productCriteria.add( Restrictions.eq( "id", productId ) );

            Product product = ( Product )productCriteria.uniqueResult( );
            session.delete( product );
            session.flush( );

            response = new Response<Long>( productId, IResponse.Status.Successful, "Removed Product ID: " +
                productId );
        }
        catch( Exception x )
        {
            response = new Response<Long>( productId, IResponse.Status.Failure, "Unable to Remove Product ID: " +
                productId + ", Reason: " + x.getMessage( ) );
        }

        return response;
    }
}
