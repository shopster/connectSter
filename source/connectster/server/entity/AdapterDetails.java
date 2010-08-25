package connectster.server.entity;

import connectster.api.entity.IAdapterDetails;
import connectster.api.entity.IAdapterProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Copyright 2010 Shopster E-Commerce Inc.

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
 */

@Entity
public class AdapterDetails
implements IAdapterDetails
{
    private long id;
    private String name;
    private String description;
    private String className;
    private String version;
    private IAdapterDetails master;
    private List<AdapterProperty> adapterProperties = new ArrayList<AdapterProperty>( );

    public AdapterDetails( ) { }
    public AdapterDetails( String name, String description, String className, String version )
    {
        this.name = name;
        this.description = description;
        this.className = className;
        this.version = version;
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

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public String getClassName()
    {
        return className;
    }

    public void setClassName( String className )
    {
        this.className = className;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion( String version )
    {
        this.version = version;
    }

    @OneToMany(mappedBy="adapterDetails", targetEntity=AdapterProperty.class, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    public List<AdapterProperty> getAdapterProperties( )
    {
        return adapterProperties;
    }

    public void setAdapterProperties( List<AdapterProperty> adapterProperties )
    {
        this.adapterProperties = adapterProperties;
    }

    @Transient
    @Override
    public Map<String,IAdapterProperty> getProperties()
    {
        HashMap<String,IAdapterProperty> results = new HashMap<String,IAdapterProperty>( );
        for( AdapterProperty property : adapterProperties )
        {
            results.put( property.getName( ), property );
        }

        return results;
    }

    @ManyToOne(targetEntity=AdapterDetails.class)
    @JoinColumn(name="master_id", nullable=true)
    public IAdapterDetails getMaster()
    {
        return master;
    }

    public void setMaster( IAdapterDetails master )
    {
        this.master = master;
    }
}
