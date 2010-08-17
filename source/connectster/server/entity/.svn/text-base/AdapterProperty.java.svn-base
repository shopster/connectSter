package connectster.server.entity;

import connectster.api.entity.IAdapterProperty;

import javax.persistence.*;

@Entity
public class AdapterProperty
implements IAdapterProperty
{
    private long id;
    private String name;
    private String value;
    private AdapterDetails adapterDetails;

    public AdapterProperty( ) { }
    public AdapterProperty( String name, String value, AdapterDetails adapterDetails )
    {
        this.name = name;
        this.value = value;
        this.adapterDetails = adapterDetails;
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

    @Override
    public String getName()
    {
        return name;
    }

    public AdapterProperty setName( String name )
    {
        this.name = name;
        return this;
    }

    @Override
    public String getValue()
    {
        return value;
    }

    public AdapterProperty setValue( String value )
    {
        this.value = value;
        return this;
    }

    @ManyToOne( targetEntity = AdapterDetails.class )
    @JoinColumn( name = "adapter_id", nullable = false )
    public AdapterDetails getAdapterDetails()
    {
        return adapterDetails;
    }

    public AdapterProperty setAdapterDetails( AdapterDetails adapterDetails )
    {
        this.adapterDetails = adapterDetails;
        return this;
    }
}
