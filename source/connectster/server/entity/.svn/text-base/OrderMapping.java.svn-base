package connectster.server.entity;

import connectster.api.entity.IOrderMapping;

import javax.persistence.*;
import java.util.Date;

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
@IdClass(OrderMappingKey.class)
public class OrderMapping
implements IOrderMapping
{
    public OrderMapping( ) { }
    public OrderMapping( long orderId, long targetAdapterId )
    {
        this.orderId = orderId;
        this.targetAdapterId = targetAdapterId;
    }

    @Id
    @AttributeOverrides({
        @AttributeOverride(name = "orderId", column = @Column(name="orderId")),
        @AttributeOverride(name = "targetAdapterId", column = @Column(name="targetAdapterId"))
    })

    private long orderId;
    private long targetAdapterId;
    private Date updatedOn;
    private int retryCount;

    @Override
    @ManyToOne( targetEntity = Order.class )
    public long getOrderId()
    {
        return orderId;
    }

    @Override
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="targetAdapterId", nullable=false, referencedColumnName="id")
    public long getTargetAdapterId()
    {
        return targetAdapterId;
    }

    @Override
    public Date getUpdatedOn()
    {
        return updatedOn;
    }

    public void setOrderId( long orderId )
    {
        this.orderId = orderId;
    }

    public void setTargetAdapterId( long targetAdapterId )
    {
        this.targetAdapterId = targetAdapterId;
    }

    public void setUpdatedOn( Date updatedOn )
    {
        this.updatedOn = updatedOn;
    }

    @Override
    public int compareTo( IOrderMapping o )
    {
        if( o.getOrderId() == orderId && o.getTargetAdapterId() == targetAdapterId )
        {
            return 0;
        }

        return ( orderId < o.getOrderId( ) ) ? -1 : 1;
    }

    public int getRetryCount()
    {
        return retryCount;
    }

    public void setRetryCount( int retryCount )
    {
        this.retryCount = retryCount;
    }
}
