package connectster.api.entity.implementation;

import connectster.api.entity.IOrderMapping;

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
public class OrderMappingDTO
implements IOrderMapping
{
    private long orderId;
    private long targetAdapterId;
    private Date updatedOn;
    private int retryCount;

    public OrderMappingDTO( ) { }
    public OrderMappingDTO( IOrderMapping mapping )
    {
        this.orderId = mapping.getOrderId( );
        this.targetAdapterId = mapping.getTargetAdapterId( );
        this.updatedOn = mapping.getUpdatedOn( );
        this.retryCount = mapping.getRetryCount( );
    }

    public OrderMappingDTO( IOrderMapping mapping, int retryCount )
    {
        this( mapping );
        this.retryCount = retryCount;
    }

    public OrderMappingDTO( IOrderMapping mapping, Date updatedOn, int retryCount )
    {
        this( mapping );
        this.updatedOn = updatedOn;
        this.retryCount = retryCount;
    }

    @Override
    public long getOrderId()
    {
        return orderId;
    }

    @Override
    public long getTargetAdapterId()
    {
        return targetAdapterId;
    }

    @Override
    public Date getUpdatedOn()
    {
        return updatedOn;
    }

    @Override
    public int compareTo( IOrderMapping o )
    {
        if( o.getOrderId( ) > getOrderId() )
        {
            return -1;
        }
        else
        if( o.getOrderId( ) < getOrderId() )
        {
            return 1;
        }

        return 0;
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
    public int getRetryCount()
    {
        return retryCount;
    }

    public void setRetryCount( int retryCount )
    {
        this.retryCount = retryCount;
    }
}
