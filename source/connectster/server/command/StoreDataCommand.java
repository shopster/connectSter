package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IAdapterData;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.AdapterData;
import org.hibernate.Session;

import java.util.Map;

public class StoreDataCommand
implements ICommand<IAdapterData>
{
    @Override
    public IResponse<IAdapterData> execute( Session session, Map<String, Object> parameters )
    {
        IResponse<IAdapterData> response;
        IAdapterData callerData = ( IAdapterData )parameters.get( ICommand.PARAMETER_ADAPTER_DATA );
        long adapterId = ( Long )parameters.get( ICommand.PARAMETER_ADAPTER_ID );

        try
        {
            AdapterData data = new AdapterData( callerData.getCategory(), callerData.getName(), adapterId, callerData.getValue() );
            session.saveOrUpdate( data );
            session.flush( );

            response = new Response<IAdapterData>( data, IResponse.Status.Successful, "Added adapter data for: " +
                data.getCategory( ) + "/" + data.getName( ) );
        }
        catch( Exception x )
        {
            response = new Response<IAdapterData>( callerData, IResponse.Status.Failure, "Unable to add data to adapter datastore: " +
                callerData.getCategory( ) + "/" + callerData.getName( ) + ", Reason: " + x.getMessage( ) );
        }

        return response;
    }
}
