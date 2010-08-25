package connectster.server.entity;

import connectster.api.entity.IAdapterData;
import org.apache.commons.lang.SerializationUtils;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass( AdapterDataKey.class )
public class AdapterData
implements IAdapterData
{
    private String category;
    private String name;
    private long adapterId;
    private byte[] valueBytes;

    public AdapterData() { }
    public AdapterData( String category, String name, long adapterId, Object value )
    {
        this.category = category;
        this.name = name;
        this.adapterId = adapterId;
        setValue( value );
    }

    @Id
    @AttributeOverrides( {
    @AttributeOverride( name = "category", column = @Column( name = "category" ) ),
    @AttributeOverride( name = "name", column = @Column( name = "name" ) ),
    @AttributeOverride( name = "adapterId", column = @Column( name = "adapterId" ) )
    } )

    @Override
    public String getCategory()
    {
        return category;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    @Transient
    public Object getValue()
    {
        return SerializationUtils.deserialize( valueBytes );
    }

    public void setValue( Object value )
    {
        this.valueBytes = SerializationUtils.serialize( ( Serializable )value );
    }

    @Lob
    @Column(length = Integer.MAX_VALUE - 1 )
    private byte[] getValueBytes()
    {
        return valueBytes;
    }

    private void setValueBytes( byte[] valueBytes )
    {
        this.valueBytes = valueBytes;
    }

    public void setCategory( String category )
    {
        this.category = category;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    @ManyToOne( targetEntity = AdapterDetails.class )
    @JoinColumn( name = "adapterId", nullable = false )
    public long getAdapterId()
    {
        return adapterId;
    }

    public void setAdapterId( long adapterId )
    {
        this.adapterId = adapterId;
    }
}
