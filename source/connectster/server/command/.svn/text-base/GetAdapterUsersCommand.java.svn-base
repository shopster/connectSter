package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IUser;
import connectster.server.EntityHelper;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.UserMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * GetAdapterUsersCommand
 *
 * For a given adapter id, this command will go out and fetch all user mappings for that adapter and then resolve them
 * to their corresponding connectster user objects.  This command guarantees a list in the response envelope, if there
 * were no mappings found then it will be empty.
 */
public class GetAdapterUsersCommand
implements ICommand<List<IUser>>
{
    @Override
    @SuppressWarnings( "unchecked" )
    public IResponse<List<IUser>> execute( Session session, Map<String, Object> parameters )
    {
        IResponse<List<IUser>> response;
        List<IUser> results = new ArrayList<IUser>( );
        Long adapterId = ( Long )parameters.get( ICommand.PARAMETER_ADAPTER_ID );

        try
        {
            Criteria userCriteria = session.createCriteria( UserMapping.class );
            userCriteria.add( Restrictions.eq( "adapterId", adapterId ) );

            List<UserMapping> mappings = ( List<UserMapping> )userCriteria.list( );
            for( UserMapping mapping : mappings )
            {
                IResponse<IUser> userResponse = new GetMappedUserCommand( ).execute( session, EntityHelper.listToMap(
                    ICommand.PARAMETER_ADAPTER_ID, adapterId, ICommand.PARAMETER_SOURCE_ID, mapping.getTargetUserId( ) ) );
                if( userResponse.getStatus( ) == IResponse.Status.Successful )
                {
                    results.add( userResponse.getSource( ) );
                }
            }

            response = new Response<List<IUser>>( results, IResponse.Status.Successful );
        }
        catch( Exception x )
        {
            response = new Response<List<IUser>>( results, IResponse.Status.Failure,
                "Unable to retrieve users for adapter " + adapterId +", Reason: " + x.getMessage( ) );
        }

        return response; 
    }
}
