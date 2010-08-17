package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IUser;
import connectster.api.entity.IUserProperty;
import connectster.api.entity.implementation.AdapterDataDTO;
import connectster.api.entity.implementation.UserDTO;
import connectster.server.EntityHelper;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.User;
import org.hibernate.Session;

import java.util.List;
import java.util.Map;

public class RegisterUserCommand
implements ICommand<IUser>
{
    @Override
    @SuppressWarnings( "unchecked" )
    public IResponse<IUser> execute( Session session, Map<String, Object> parameters )
    {
        IUser user;
        long sourceAdapterId = ( Long )parameters.get( ICommand.PARAMETER_SOURCE_ADAPTER_ID );
        String sourceId = ( String )parameters.get( ICommand.PARAMETER_SOURCE_ID );
        long masterAdapterId = ( Long )parameters.get( ICommand.PARAMETER_ADAPTER_ID );
        String masterId = ( String )parameters.get( ICommand.PARAMETER_MASTER_ID );
        AdapterDataDTO data = ( AdapterDataDTO )parameters.get( ICommand.PARAMETER_ADAPTER_DATA );
        List<IUserProperty> userProperties = ( List<IUserProperty> )parameters.get( ICommand.PARAMETER_USER_PROPERTIES );

        // determine if there is a user in connectster already associated with this shop, if not create one
        IResponse<IUser> userResponse = new GetMappedUserCommand( ).execute( session, EntityHelper.listToMap(
            ICommand.PARAMETER_ADAPTER_ID, sourceAdapterId, ICommand.PARAMETER_SOURCE_ID, sourceId ) );
        if( userResponse.getStatus( ) == IResponse.Status.Successful )
        {
            user = userResponse.getSource( );
        }
        else
        {
            // persist the user to database
            User newUser = new User( sourceId );
            session.save( newUser );
            session.flush( );

            // attach the access key properties to the new user object
            for( IUserProperty userProperty : userProperties )
            {
                new SetUserPropertyCommand( ).execute( session, EntityHelper.listToMap( ICommand.PARAMETER_USER_ID,
                    newUser.getId( ), ICommand.PARAMETER_PROPERTY, userProperty ) );
            }

            user = new UserDTO( newUser.getId( ), newUser.getName( ), newUser.getUserMappings( ), userProperties );
        }

        // map users to target/source adapters and store any associated adapter data
        new MapUserCommand( ).execute( session, EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_ID, sourceAdapterId,
            ICommand.PARAMETER_USER_ID, user.getId( ), ICommand.PARAMETER_SOURCE_ID, sourceId ) );
        new MapUserCommand( ).execute( session, EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_ID, masterAdapterId,
            ICommand.PARAMETER_USER_ID, user.getId( ), ICommand.PARAMETER_SOURCE_ID, masterId ) );

        if( data != null )
        {
            new StoreDataCommand( ).execute( session, EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_ID, 
                sourceAdapterId, ICommand.PARAMETER_ADAPTER_DATA, data ) );
        }

        return new Response<IUser>( user, IResponse.Status.Successful, "Adapter User Registered for: " + sourceAdapterId +
            ": " + sourceId + "/" + masterId );
    }
}
