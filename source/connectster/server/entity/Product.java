package connectster.server.entity;

import connectster.api.entity.IProduct;
import connectster.api.entity.IProductMapping;
import connectster.api.entity.IUserMapping;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Copyright 2010 Shopster E-Commerce Inc.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@Entity
@Table(uniqueConstraints = { @UniqueConstraint( columnNames={ "sourceId", "sourceAdapterId", "owner" } ) } )
public class Product
implements IProduct
{
    private long id;
    private String sourceId;
    private AdapterDetails adapterDetails;
    private String name;
    private User owner;
    private Set<IProductMapping> mappings;
    private Date lastUpdate;
    private String vendor;
    private String type;
    private int quantity;
    private String currency;
    private double price;
    private String sku;
    private int grams;

    public Product( )
    {
        this.lastUpdate = new Date( );
    }

    public Product( AdapterDetails adapterDetails, String sourceId, String name, User owner,
        Set<IProductMapping> mappings, Date lastUpdate )
    {
        this.adapterDetails = adapterDetails;
        this.sourceId = sourceId;
        this.name = name;
        this.owner = owner;
        this.mappings = mappings;
        this.lastUpdate = lastUpdate;
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

    public String getSourceId()
    {
        return sourceId;
    }

    public Product setSourceId( String sourceId )
    {
        this.sourceId = sourceId;
        return this;
    }

    public String getName()
    {
        return name;
    }

    @Transient
    @Override
    public long getSourceAdapterId()
    {
        return adapterDetails.getId( );
    }

    /**
     * Searches for the first occurrence of a the adapter id for the adapter associated with this product in the
     * user mappings and then returns that userId.
     *
     * Could be optimized by creating a hashmap facade, not expected to be on critical path so this is a consideration.
     *
     * @return The user id on the other end of the mapping, otherwise null if not found.
     */
    @Transient
    @Override
    public String getSourceUserId()
    {
        String sourceId = null;
        for( IUserMapping mapping : owner.getUserMappings( ).values( ) )
        {
            if( mapping.getTargetAdapterId( ) == adapterDetails.getId( ) )
            {
                sourceId = mapping.getTargetUserId( );
                break;
            }
        }
        
        return sourceId;
    }

    public Product setName( String name )
    {
        this.name = name;
        return this;
    }

    @ManyToOne
    @JoinColumn(name="sourceAdapterId", nullable=false)    
    public AdapterDetails getAdapterDetails()
    {
        return adapterDetails;
    }

    public Product setAdapterDetails( AdapterDetails adapterDetails )
    {
        this.adapterDetails = adapterDetails;
        return this;
    }

    public String toString( )
    {
        return "Product[ ID:" + getId( ) + ", Name: " + getName( ) + ", SID=" + getSourceId( ) + ", Adapter=" +
            getAdapterDetails( ).getName( ) + " ]";
    }

    @ManyToOne
    @JoinColumn(name="owner", nullable=false)
    public User getOwner()
    {
        return owner;                                 
    }

    public Product setOwner( User owner )
    {
        this.owner = owner;
        return this;
    }

    @OneToMany( mappedBy = "productId", targetEntity = ProductMapping.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    public Set<IProductMapping> getMappings()
    {
        return mappings;
    }

    public void setMappings( Set<IProductMapping> mappings )
    {
        this.mappings = mappings;
    }

    public Date getLastUpdate()
    {
        return lastUpdate;
    }

    public void setLastUpdate( Date lastUpdate )
    {
        this.lastUpdate = lastUpdate;
    }

    public boolean equals( Object rhs )
    {
        if( rhs == null || !( rhs instanceof Product) )
        {
            return false;
        }

        return getId( ) == ( ( Product )rhs ).getId( );
    }

    public String getVendor()
    {
        return vendor;
    }

    public void setVendor( String vendor )
    {
        this.vendor = vendor;
    }

    public String getType()
    {
        return type;
    }

    public void setType( String type )
    {
        this.type = type;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity( int quantity )
    {
        this.quantity = quantity;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency( String currency )
    {
        this.currency = currency;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice( double price )
    {
        this.price = price;
    }

    public String getSku()
    {
        return sku;
    }

    public void setSku( String sku )
    {
        this.sku = sku;
    }

    public int getGrams()
    {
        return grams;
    }

    public void setGrams( int grams )
    {
        this.grams = grams;
    }
}