package connectster.api.entity.implementation;

import connectster.api.entity.IUserProperty;

public class UserPropertyDTO
implements IUserProperty
{
    private String name;
    private String value;

    public UserPropertyDTO( String name, String value )
    {
        this.name = name;
        this.value = value;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue( String value )
    {
        this.value = value;
    }

    public String toString( )
    {
        return name + "=" + value;
    }
}
