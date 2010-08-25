package connectster.api.entity.implementation;

import connectster.api.entity.IProduct;
import connectster.api.entity.IProductMapping;
import connectster.api.entity.IUser;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
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
public class ProductDTO
implements IProduct, Serializable
{
    private long sourceAdapterId;
    private long id;
    private String sourceId;
    private String name;
    private String sourceUserId;
    private Date lastUpdate;
    private Set<IProductMapping> mappings;
    private IUser owner;
    private String vendor;
    private String type;
    private int quantity;
    private String currency;
    private double price;
    private String sku;
    private int grams;

    public ProductDTO( long sourceAdapterId, String sourceUserId, String sourceId, String name )
    {
        this( 0, sourceAdapterId, sourceUserId, sourceId, name, new Date( ) );
    }

    public ProductDTO( long sourceAdapterId, String sourceUserId, String sourceId, String name, Date lastUpdate )
    {
        this( 0, sourceAdapterId, sourceUserId, sourceId, name, lastUpdate );
    }

    public ProductDTO( long id, long sourceAdapterId, String sourceUserId, String sourceId, String name, Date lastUpdate )
    {
        setId( id );
        setSourceAdapterId( sourceAdapterId );
        setSourceId( sourceId );
        setName( name );
        setSourceUserId( sourceUserId );
        setLastUpdate( lastUpdate );
        setMappings( new HashSet<IProductMapping>( ) );
    }

    public ProductDTO( IProduct product )
    {
        setId( product.getId( ) );
        setSourceId( product.getSourceId( ) );
        setCurrency( product.getCurrency( ) );
        setLastUpdate( product.getLastUpdate( ) );
        setSku( product.getSku( ) );
        setGrams( product.getGrams( ) );
        setName( product.getName( ) );
        setOwner( product.getOwner( ) );
        setPrice( product.getPrice( ) );
        setSourceAdapterId( product.getSourceAdapterId( ) );
        setSourceUserId( product.getSourceUserId( ) );
        setVendor( product.getVendor( ) );
        setType( product.getType( ) );
        setQuantity( product.getQuantity( ) );
        setMappings( product.getMappings( ) );
    }

    @Override
    public String getSourceId()
    {
        return sourceId;
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
    public long getSourceAdapterId()
    {
        return sourceAdapterId;
    }

    @Override
    public String getSourceUserId()
    {
        return sourceUserId;
    }

    @Override
    public Date getLastUpdate()
    {
        return lastUpdate;
    }

    public Set<IProductMapping> getMappings()
    {
        return mappings;
    }

    @Override
    public IUser getOwner()
    {
        return owner;
    }

    public void setMappings( Set<IProductMapping> mappings )
    {
        this.mappings = mappings;
    }

    public void setOwner( IUser owner )
    {
        this.owner = owner;
    }

    @Override
    public String toString( )
    {
        return getSourceId() + "/" + getName();
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

    public void setSourceAdapterId( long sourceAdapterId )
    {
        this.sourceAdapterId = sourceAdapterId;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public void setSourceId( String sourceId )
    {
        this.sourceId = sourceId;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public void setSourceUserId( String sourceUserId )
    {
        this.sourceUserId = sourceUserId;
    }

    public void setLastUpdate( Date lastUpdate )
    {
        this.lastUpdate = lastUpdate;
    }
}
