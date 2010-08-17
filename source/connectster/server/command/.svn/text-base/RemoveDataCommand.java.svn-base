package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IAdapterData;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.AdapterData;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Map;

public class RemoveDataCommand
implements ICommand<IAdapterData>
{
    @Override
    public IResponse<IAdapterData> execute( Session session, Map<String, Object> parameters )
    {
        IResponse<IAdapterData> response;
        String category = ( String )parameters.get( ICommand.PARAMETER_CATEGORY );
        long adapterId = ( Long )parameters.get( ICommand.PARAMETER_ADAPTER_ID );
        String name = ( String )parameters.get( ICommand.PARAMETER_NAME );

        try
        {
            Criteria productCriteria = session.createCriteria( AdapterData.class );
            productCriteria.add( Restrictions.eq( "category", category ) );
            productCriteria.add( Restrictions.eq( "name", name ) );
            productCriteria.add( Restrictions.eq( "adapterId", adapterId ) );

            AdapterData data = ( AdapterData )productCriteria.uniqueResult( );
            session.delete( data );
            session.flush( );

            response = new Response<IAdapterData>( data, IResponse.Status.Successful, "Added adapter data for: " +
                data.getCategory( ) + "/" + data.getName( ) );
        }
        catch( Exception x )
        {
            response = new Response<IAdapterData>( null, IResponse.Status.Failure, "Unable to add data to adapter datastore: " +
                category + "/" + name + ", Reason: " + x.getMessage( ) );
        }

        return response;
    }
}
