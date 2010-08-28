package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IUser;
import connectster.api.entity.IUserMapping;
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
import java.util.logging.Logger;

public class RegisterUserCommand
implements ICommand<IUser>
{
    private static Logger log = Logger.getLogger( RegisterUserCommand.class.getName( ) );

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
        boolean existingUser = false;
        IResponse<IUser> userResponse = new GetMappedUserCommand( ).execute( session, EntityHelper.listToMap(
            ICommand.PARAMETER_ADAPTER_ID, sourceAdapterId, ICommand.PARAMETER_SOURCE_ID, sourceId ) );
        if( userResponse.getStatus( ) == IResponse.Status.Failure )
        {
            // determine if there is a user mapping for the target adapter already, use it if so
            userResponse = new GetMappedUserCommand( ).execute( session, EntityHelper.listToMap(
                ICommand.PARAMETER_ADAPTER_ID, masterAdapterId, ICommand.PARAMETER_SOURCE_ID, masterId ) );
            if( userResponse.getStatus( ) == IResponse.Status.Successful )
            {
                existingUser = true;                
            }
        }
        else
        {
            existingUser = true;
        }
        
        user = userResponse.getSource( );

        // there were no mappings associated with this user, so we now need to create a new user mapping
        if( user == null )
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

        // map users to target/source adapters and clone all product mappings at this point so we can catch and update them in PM
        // note : it would be better here to queue this request up or have another monitor that ensures all products are mapped etc
        IResponse<IUserMapping> mappingResponse = new MapUserCommand( ).execute( session, EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_ID, sourceAdapterId,
            ICommand.PARAMETER_USER_ID, user.getId( ), ICommand.PARAMETER_SOURCE_ID, sourceId ) );
        if( mappingResponse.getStatus( ) == IResponse.Status.Successful )
        {
            if( existingUser ) cloneProductMappings( session, user, mappingResponse.getSource( ) );
        }

        if( !existingUser )
        {
            new MapUserCommand( ).execute( session, EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_ID, masterAdapterId,
                ICommand.PARAMETER_USER_ID, user.getId( ), ICommand.PARAMETER_SOURCE_ID, masterId ) );
        }

        if( data != null )
        {
            new StoreDataCommand( ).execute( session, EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_ID, 
                sourceAdapterId, ICommand.PARAMETER_ADAPTER_DATA, data ) );
        }

        return new Response<IUser>( user, IResponse.Status.Successful, "Adapter User Registered for: " + sourceAdapterId +
            ": " + sourceId + "/" + masterId );
    }

    /**
     * This method should be called when a new user registers but is associted with an existing account (
     * @param session Session object from hibernate to pass down to command for transaction context.
     * @param user Connectster user object for which this mapping is being added.
     * @param userMapping The new user mapping we need to build out product mappings to.
     */
    private void cloneProductMappings( Session session, IUser user, IUserMapping userMapping )
    {
        IResponse<Integer> response = new BuildProductMappingsCommand( ).execute( session,
            EntityHelper.listToMap( ICommand.PARAMETER_USER, user, ICommand.PARAMETER_USER_MAPPING, userMapping ) );
        log.info( "Cloned Mappings for: " + user.getId( ) + ", number created: " + response.getSource( ) +
            ", Response: " + response.getMessage( ) );
    }
}
