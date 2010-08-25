package connectster.server.entity;

import connectster.api.entity.IOrder;
import connectster.api.entity.IOrderItem;
import connectster.api.entity.IOrderMapping;
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
@Table(name = "Ordering", uniqueConstraints = { @UniqueConstraint( columnNames={ "sourceId", "sourceAdapterId", "owner" } ) } )
public class Order
implements IOrder
{
    private long id;
    private String name;
    private String sourceId;
    private Date receivedAt;
    private User owner;
    private AdapterDetails adapterDetails;
    private Set<IOrderMapping> mappings;

    private String billingName;
    private String billingStreet1;
    private String billingStreet2;
    private String billingCity;
    private String billingRegion;
    private String billingPostalCode;
    private String billingCountry;
    private String shippingName;
    private String shippingStreet1;
    private String shippingStreet2;
    private String shippingCity;
    private String shippingRegion;
    private String shippingPostalCode;
    private String shippingCountry;
    private String shippingMethod;
    private Set<IOrderItem> items;

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

    public String getSourceId()
    {
        return sourceId;
    }

    @Transient
    @Override
    public long getSourceAdapterId()
    {
        return adapterDetails.getId( );
    }

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

    public void setSourceId( String sourceId )
    {
        this.sourceId = sourceId;
    }

    public Date getReceivedAt()
    {
        return receivedAt;
    }

    public void setReceivedAt( Date receivedAt )
    {
        this.receivedAt = receivedAt;
    }

    @OneToMany( mappedBy = "orderId", targetEntity = OrderMapping.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    public Set<IOrderMapping> getMappings()
    {
        return mappings;
    }

    public void setMappings( Set<IOrderMapping> mappings )
    {
        this.mappings = mappings;
    }

    @ManyToOne
    @JoinColumn(name="owner", nullable=false)
    public User getOwner()
    {
        return owner;
    }

    public void setOwner( User owner )
    {
        this.owner = owner;
    }

    @ManyToOne
    @JoinColumn(name="sourceAdapterId", nullable=false)
    public AdapterDetails getAdapterDetails()
    {
        return adapterDetails;
    }

    public void setAdapterDetails( AdapterDetails adapterDetails )
    {
        this.adapterDetails = adapterDetails;
    }

    public String getBillingName()
    {
        return billingName;
    }

    public void setBillingName( String billingName )
    {
        this.billingName = billingName;
    }

    public String getBillingStreet1()
    {
        return billingStreet1;
    }

    public void setBillingStreet1( String billingStreet1 )
    {
        this.billingStreet1 = billingStreet1;
    }

    public String getBillingStreet2()
    {
        return billingStreet2;
    }

    public void setBillingStreet2( String billingStreet2 )
    {
        this.billingStreet2 = billingStreet2;
    }

    public String getBillingCity()
    {
        return billingCity;
    }

    public void setBillingCity( String billingCity )
    {
        this.billingCity = billingCity;
    }

    public String getBillingRegion()
    {
        return billingRegion;
    }

    public void setBillingRegion( String billingRegion )
    {
        this.billingRegion = billingRegion;
    }

    public String getBillingPostalCode()
    {
        return billingPostalCode;
    }

    public void setBillingPostalCode( String billingPostalCode )
    {
        this.billingPostalCode = billingPostalCode;
    }

    public String getBillingCountry()
    {
        return billingCountry;
    }

    public void setBillingCountry( String billingCountry )
    {
        this.billingCountry = billingCountry;
    }

    public String getShippingName()
    {
        return shippingName;
    }

    public void setShippingName( String shippingName )
    {
        this.shippingName = shippingName;
    }

    public String getShippingStreet1()
    {
        return shippingStreet1;
    }

    public void setShippingStreet1( String shippingStreet1 )
    {
        this.shippingStreet1 = shippingStreet1;
    }

    public String getShippingStreet2()
    {
        return shippingStreet2;
    }

    public void setShippingStreet2( String shippingStreet2 )
    {
        this.shippingStreet2 = shippingStreet2;
    }

    public String getShippingCity()
    {
        return shippingCity;
    }

    public void setShippingCity( String shippingCity )
    {
        this.shippingCity = shippingCity;
    }

    public String getShippingRegion()
    {
        return shippingRegion;
    }

    public void setShippingRegion( String shippingRegion )
    {
        this.shippingRegion = shippingRegion;
    }

    public String getShippingPostalCode()
    {
        return shippingPostalCode;
    }

    public void setShippingPostalCode( String shippingPostalCode )
    {
        this.shippingPostalCode = shippingPostalCode;
    }

    public String getShippingCountry()
    {
        return shippingCountry;
    }

    public void setShippingCountry( String shippingCountry )
    {
        this.shippingCountry = shippingCountry;
    }

    public String getShippingMethod()
    {
        return shippingMethod;
    }

    public void setShippingMethod( String shippingMethod )
    {
        this.shippingMethod = shippingMethod;
    }

    @OneToMany( mappedBy = "order", targetEntity = OrderItem.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    public Set<IOrderItem> getItems()
    {
        return items;
    }

    public void setItems( Set<IOrderItem> items )
    {
        this.items = items;
    }
}
