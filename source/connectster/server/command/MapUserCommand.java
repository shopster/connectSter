package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IUserMapping;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.UserMapping;
import org.hibernate.Session;

import java.util.Map;

public class MapUserCommand
implements ICommand<IUserMapping>
{
    @Override
    public IResponse<IUserMapping> execute( Session session, Map<String, Object> parameters )
    {
        IResponse<IUserMapping> response;

        long adapterId = ( Long )parameters.get( ICommand.PARAMETER_ADAPTER_ID );
        String sourceId = ( String )parameters.get( ICommand.PARAMETER_SOURCE_ID );
        long userId = ( Long )parameters.get( ICommand.PARAMETER_USER_ID ); 

        try
        {
            UserMapping mapping = new UserMapping( );
            mapping.setAdapterId( adapterId );
            mapping.setSourceUserId( sourceId );
            mapping.setUserId( userId );
            session.save( mapping );
            session.flush( );

            response = new Response<IUserMapping>( mapping, IResponse.Status.Successful, "Mapping User: "
                + adapterId + "/" + sourceId );
        }
        catch( Exception x )
        {
            response = new Response<IUserMapping>( null, IResponse.Status.Failure, "Unable to create User Mapping for: "
                + adapterId + "/" + sourceId + ", Reason: " + x.getMessage( ) );
        }

        return response;
    }
}
