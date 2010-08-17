package connectster.api.entity.implementation;

import connectster.api.entity.IUser;
import connectster.api.entity.IUserMapping;
import connectster.api.entity.IUserProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDTO
implements IUser
{
    private long id;
    private String name;
    private Map<Long,IUserMapping> userMappings;
    private Map<String,IUserProperty> userProperties;

    public UserDTO( IUser user )
    {
        this.id = user.getId( );
        this.name = user.getName( );
        this.userMappings = user.getUserMappings( );
        this.userProperties = user.getUserProperties( );
    }

    public UserDTO( long id )
    {
        this( id, null, ( List<IUserMapping> )null, null );
    }

    public UserDTO( long id, String name, Map<Long,IUserMapping> userMappings, List<IUserProperty> userProperties )
    {
        this( id, name, ( List<IUserMapping> )null, userProperties );
        this.userMappings = userMappings;
    }

    public UserDTO( long id, String name, List<IUserMapping> userMappings, List<IUserProperty> userProperties )
    {
        this.id = id;
        this.name = name;

        this.userMappings = new HashMap<Long,IUserMapping>( );
        if( userMappings != null )
        {
            for( IUserMapping mapping : userMappings )
            {
                this.userMappings.put( mapping.getTargetAdapterId( ), mapping );
            }
        }

        this.userProperties = new HashMap<String,IUserProperty>( );
        if( userProperties != null )
        {
            for( IUserProperty property : userProperties )
            {
                this.userProperties.put( property.getName( ), property );
            }
        }
    }

    @Override
    public long getId()
    {
        return id;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public Map<Long,IUserMapping> getUserMappings()
    {
        return userMappings;
    }

    @Override
    public Map<String, IUserProperty> getUserProperties()
    {
        return userProperties;
    }
}
