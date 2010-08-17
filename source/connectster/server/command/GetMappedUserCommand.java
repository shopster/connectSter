package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IUser;
import connectster.api.exceptions.AdapterException;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.User;
import connectster.server.entity.UserMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Map;

public class GetMappedUserCommand
implements ICommand<IUser>
{
    @Override
    public IResponse<IUser> execute( Session session, Map<String, Object> parameters )
    {
        IResponse<IUser> response;
        long adapterId = ( Long )parameters.get( ICommand.PARAMETER_ADAPTER_ID );
        String sourceUserId = ( String )parameters.get( ICommand.PARAMETER_SOURCE_ID );

        try
        {
            // first get the user mapping for this user based on source id and adapter id
            Criteria userMappingCriteria = session.createCriteria( UserMapping.class );
            userMappingCriteria.add( Restrictions.eq( "adapterId", adapterId ) );
            userMappingCriteria.add( Restrictions.eq( "sourceUserId", sourceUserId ) );

            UserMapping userMapping = ( UserMapping )userMappingCriteria.uniqueResult( );
            if( userMapping == null )
            {
                throw new AdapterException( "Failed to find mapped user for: " + adapterId + ", " + sourceUserId );
            }

            // next get the user associated with this mapping, db constraints mean they must be present if a mapping exists
            Criteria userCriteria = session.createCriteria( User.class );
            userCriteria.add( Restrictions.eq( "id", userMapping.getUserId( ) ) );
            User user = ( User )userCriteria.uniqueResult( );

            response = new Response<IUser>( user, IResponse.Status.Successful, "Loaded user: " +
                user.getId( ) + "/" + user.getName( ) );
        }
        catch( Exception x )
        {
            response = new Response<IUser>( null, IResponse.Status.Failure, "Unable to find user: " +
                sourceUserId + ", Reason: " + x.getMessage( ) );
        }

        return response;
    }
}
