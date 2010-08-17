package connectster.server.entity;

import connectster.api.entity.IUser;
import connectster.api.entity.IUserMapping;
import connectster.api.entity.IUserProperty;

import javax.persistence.*;
import java.util.*;

@Entity
public class User
implements IUser
{
    private long id;
    private String name;
    private Set<UserMapping> mappings;
    private Set<UserProperty> properties;

    public User( )
    {
        this( String.valueOf( "Unknown" ) );
    }

    public User( String name )
    {
        this.name = name;
        mappings = new HashSet<UserMapping>( );
        properties = new HashSet<UserProperty>( );
    }

    @Id
    @GeneratedValue
    public long getId()
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    @Transient
    public Map<Long,IUserMapping> getUserMappings()
    {
        Map<Long,IUserMapping> userProperties = new HashMap<Long,IUserMapping>( );
        for( IUserMapping mapping : mappings )
        {
            userProperties.put( mapping.getTargetAdapterId( ), mapping );
        }

        return userProperties;
    }


    @Override
    @Transient
    public Map<String,IUserProperty> getUserProperties()
    {
        Map<String,IUserProperty> userProperties = new HashMap<String,IUserProperty>( );
        for( IUserProperty property : properties )
        {
            userProperties.put( property.getName( ), property );
        }

        return userProperties;
    }

    @OneToMany( mappedBy = "userId", targetEntity = UserMapping.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    public Set<UserMapping> getMappings()
    {
        return mappings;
    }

    public void setMappings( Set<UserMapping> mappings )
    {
        this.mappings = mappings;
    }

    @OneToMany( mappedBy = "userId", targetEntity = UserProperty.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    public Set<UserProperty> getProperties()
    {
        return properties;
    }

    public void setProperties( Set<UserProperty> properties )
    {
        this.properties = properties;
    }

    @Transient
    public void addProperty( UserProperty property )
    {
        properties.add( property );
    }
}
