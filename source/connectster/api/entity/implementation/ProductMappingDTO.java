package connectster.api.entity.implementation;

import connectster.api.entity.IProductMapping;

import java.io.Serializable;
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
public class ProductMappingDTO
implements IProductMapping, Serializable
{
    private long productId;
    private long targetAdapterId;
    private String targetProductId;
    private Date updatedOn;
    private int retryCount;
    private String targetUserId;

    public ProductMappingDTO( IProductMapping mapping )
    {
        this.setProductId( mapping.getProductId( ) );
        this.setTargetAdapterId( mapping.getTargetAdapterId( ) );
        this.setTargetProductId( mapping.getTargetProductId( ) );
        this.setUpdatedOn( mapping.getUpdatedOn( ) );
        this.setRetryCount( mapping.getRetryCount( ) );
        this.setTargetUserId( mapping.getTargetUserId( ) );
    }

    public ProductMappingDTO( long targetAdapterId, long productId, String targetProductId, String targetUserId, Date updatedOn )
    {
        this.setProductId( productId );
        this.setTargetAdapterId( targetAdapterId );
        this.setTargetProductId( targetProductId );
        this.setUpdatedOn( updatedOn );
        this.setTargetUserId( targetUserId );
    }

    @Override
    public long getProductId()
    {
        return productId;
    }

    @Override
    public String getTargetProductId()
    {
        return targetProductId;
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

    public void setRetryCount( int retryCount )
    {
        this.retryCount = retryCount;
    }

    @Override
    public int getRetryCount()
    {
        return retryCount;
    }

    @Override
    public String getTargetUserId()
    {
        return targetUserId;
    }

    @Override
    public int compareTo( IProductMapping o )
    {
        if( o.getProductId() == getProductId() && o.getTargetProductId().equals( getTargetProductId() ) && o.getTargetAdapterId() == getTargetAdapterId() )
        {
            return 0;
        }

        return ( getProductId() < o.getProductId( ) ) ? -1 : 1;
    }

    public void setProductId( long productId )
    {
        this.productId = productId;
    }

    public void setTargetAdapterId( long targetAdapterId )
    {
        this.targetAdapterId = targetAdapterId;
    }

    public void setTargetProductId( String targetProductId )
    {
        this.targetProductId = targetProductId;
    }

    public void setUpdatedOn( Date updatedOn )
    {
        this.updatedOn = updatedOn;
    }

    public void setTargetUserId( String targetUserId )
    {
        this.targetUserId = targetUserId;
    }
}
