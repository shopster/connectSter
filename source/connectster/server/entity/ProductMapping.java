package connectster.server.entity;

import connectster.api.entity.IProductMapping;

import javax.persistence.*;
import java.util.Date;

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
@IdClass(ProductMappingKey.class)
public class ProductMapping
implements IProductMapping
{
    public ProductMapping( ) { }
    public ProductMapping( long productId, long destinationAdapterId, String destinationId, String destinationUserId )
    {
        this.productId = productId;
        this.destinationAdapterId = destinationAdapterId;
        this.destinationId = destinationId;
        this.setDestinationUserId( destinationUserId );
    }

    @Id
    @AttributeOverrides({
        @AttributeOverride(name = "productId", column = @Column(name="productId")),
        @AttributeOverride(name = "destinationAdapterId", column = @Column(name="destinationAdapterId")),
        @AttributeOverride(name = "destinationId", column = @Column(name="destinationId")),
        @AttributeOverride(name = "destinationUserId", column = @Column(name="destinationUserId"))
    })

    private long productId;
    private long destinationAdapterId;
    private String destinationId;
    private String destinationUserId;
    private Date updatedOn;
    private int retryCount;

    @ManyToOne( targetEntity = Product.class )
    public long getProductId()
    {
        return productId;
    }

    public void setProductId( long productId )
    {
        this.productId = productId;
    }

    @ManyToOne(targetEntity=AdapterDetails.class, cascade=CascadeType.ALL)
    @JoinColumn(name="destinationAdapterId", nullable=false, referencedColumnName="id")
    public long getTargetAdapterId()
    {
        return destinationAdapterId;
    }

    public void setAdapter( long adapterId )
    {
        this.destinationAdapterId = adapterId;
    }

    public String getTargetProductId()
    {
        return destinationId;
    }

    public void setDestinationId( String destinationId )
    {
        this.destinationId = destinationId;
    }

    @Override
    public Date getUpdatedOn()
    {
        return updatedOn;
    }

    public void setUpdatedOn( Date updatedOn )
    {
        this.updatedOn = updatedOn;
    }

    @Override
    public int compareTo( IProductMapping o )
    {
        if( o.getProductId() == productId && o.getTargetProductId().equals(destinationId) && o.getTargetAdapterId() == destinationAdapterId )
        {
            return 0;
        }

        return ( productId < o.getProductId( ) ) ? -1 : 1;
    }

    public int getRetryCount()
    {
        return retryCount;
    }

    @Override
    public String getTargetUserId()
    {
        return destinationUserId;
    }

    public void setRetryCount( int retryCount )
    {
        this.retryCount = retryCount;
    }

    @ManyToOne(targetEntity=UserMapping.class, cascade=CascadeType.ALL)
    @JoinColumn(name="destinationUserId", nullable=false, referencedColumnName="sourceUserId")
    public String getDestinationUserId( )
    {
        return destinationUserId;
    }

    public void setDestinationUserId( String destinationUserId )
    {
        this.destinationUserId = destinationUserId;
    }
}
