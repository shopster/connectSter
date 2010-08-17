package connectster.server;

import connectster.api.IResponse;
import connectster.api.entity.IProduct;
import connectster.server.entity.AdapterDetails;
import connectster.server.entity.User;
import connectster.server.entity.UserMapping;
import connectster.server.exceptions.ConnectsterException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.*;
import java.util.logging.Logger;

public class EntityHelper
{
    private static final Logger log = Logger.getLogger( EntityHelper.class.getName( ) );

    /**
     * Extract all of the name-value-pairs from the given list.  The list is assumed to be of the
     * correct size and each name must be of type String, otherwise an array bounds or casting
     * runtime exception will be thrown. 
     *
     * @param nvps The list of all name-value pairs in a name,value,name,value,... sequence
     * @return A map of NvP's
     */
    public static Map<String,Object> listToMap( Object ... nvps )
    {
        HashMap<String,Object> result = new HashMap<String, Object>( );
        for( int i = 0; i < nvps.length; i += 2 )
        {
            result.put( ( String )nvps[ i ], nvps[ i + 1 ] );
        }

        return result;
    }

    public static <E> List<E> buildList( E ... objects )
    {
        ArrayList<E> results = new ArrayList<E>( );
        results.addAll( Arrays.asList( objects ) );
        return results;
    }

    public static <E> Set<E> buildSet( E ... objects )
    {
        HashSet<E> results = new HashSet<E>( );
        results.addAll( Arrays.asList( objects ) );
        return results;
    }

    public static User getUserById( Session session, long userId )
    throws ConnectsterException
    {
        Criteria userCriteria = session.createCriteria( User.class );
        userCriteria.add( Restrictions.eq( "id", userId ) );
        User userFound = ( User )userCriteria.uniqueResult( );
        if( userFound == null )
        {
            throw new ConnectsterException( "Unable to locate a user with id: " + userId );
        }

        return userFound;
    }

    public static User getUserForProduct( Session session, IProduct product )
    throws ConnectsterException
    {
        String sourceUserId = product.getSourceUserId( );
        if( sourceUserId == null )
        {
            throw new ConnectsterException( "Unable to lookup source user id on product: " + product.getSourceId( ) );
        }

        Criteria userMappingCriteria = session.createCriteria( UserMapping.class );
        userMappingCriteria.add( Restrictions.eq( "sourceUserId", sourceUserId ) );
        UserMapping mappingFound = ( UserMapping )userMappingCriteria.uniqueResult( );
        if( mappingFound == null )
        {
            throw new ConnectsterException( "Unable to locate a user mapping for source user id: " + sourceUserId );
        }

        Criteria userCriteria = session.createCriteria( User.class );
        userCriteria.add( Restrictions.eq( "id", mappingFound.getUserId( ) ) );
        User userFound = ( User )userCriteria.uniqueResult( );
        if( userFound == null )
        {
            throw new ConnectsterException( "Unable to locate a user with id: " + mappingFound.getUserId( ) );
        }

        return userFound;
    }

    public static AdapterDetails getAdapterDetailsById( Session session, long id )
    throws ConnectsterException
    {
        try
        {
            Criteria adapterCritiera = session.createCriteria( AdapterDetails.class );
            adapterCritiera.add( Restrictions.eq( "id", id ) );
            return ( AdapterDetails )adapterCritiera.uniqueResult( );
        }
        catch( Exception x )
        {
            throw new ConnectsterException( "Failed to retrieve adapter: " + id + ", Reason: " + x.getMessage( ) );
        }
    }

    public static <E> IResponse<E> execute( ICommand<E> command )
    {
        return execute( command, null );
    }

    public static <E> IResponse<E> execute( ICommand<E> command, Map<String,Object> parameters )
    {
        Session session = null;
        Transaction transaction = null;
        IResponse<E> response;

        try
        {
            session = HibernateUtility.createSession( );
            transaction = session.beginTransaction( );
            response = command.execute( session, parameters );
            transaction.commit( );
        }
        catch( Throwable x )
        {
            if( transaction != null )
            {
                transaction.rollback( );
            }
            
            response = new Response<E>( null, IResponse.Status.Failure, x.getMessage( ) );
        }
        finally
        {
            if( session != null )
            {
                session.close( );
            }
        }

        return response;
    }
}