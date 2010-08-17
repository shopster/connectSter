package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IUserProperty;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.UserProperty;
import org.hibernate.Session;

import java.util.Map;

public class SetUserPropertyCommand
implements ICommand<IUserProperty>
{
    @Override
    public IResponse<IUserProperty> execute( Session session, Map<String, Object> parameters )
    {
        IResponse<IUserProperty> response;
        IUserProperty property = ( IUserProperty )parameters.get( ICommand.PARAMETER_PROPERTY );
        Long userId = ( Long )parameters.get( ICommand.PARAMETER_USER_ID );

        try
        {
            UserProperty userProperty = new UserProperty( );
            userProperty.setUserId( userId );
            userProperty.setName( property.getName( ) );
            userProperty.setValue( property.getValue( ) );

            session.save( userProperty );
            session.flush( );

            response = new Response<IUserProperty>( userProperty, IResponse.Status.Successful, "Added Property: " +
                userProperty.getName( ) + " to UserID: " + userProperty.getUserId( ) );
        }
        catch( Exception x )
        {
            response = new Response<IUserProperty>( null, IResponse.Status.Failure, "Unable to Add Property: " +
                property + " to UserID: " + userId + ", Reason: " + x.getMessage( ) );
        }

        return response;
    }
}
