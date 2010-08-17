package connectster.server.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

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
@Embeddable
public class OrderMappingKey
implements Serializable
{
    private long orderId;
    private long targetAdapterId;

    public long getOrderId()
    {
        return orderId;
    }

    public void setOrderId( long orderId )
    {
        this.orderId = orderId;
    }

    public long getTargetAdapterId()
    {
        return targetAdapterId;
    }

    public void setTargetAdapterId( long targetAdapterId )
    {
        this.targetAdapterId = targetAdapterId;
    }

    public boolean equals( Object rhs )
    {
        if( rhs == null || !( rhs instanceof OrderMappingKey ) )
        {
            return false;
        }

        OrderMappingKey rhsKey = ( OrderMappingKey )rhs;
        return rhsKey.getOrderId() == orderId && rhsKey.getTargetAdapterId() == targetAdapterId;
    }

    public int hashCode( )
    {
        return ( int )orderId;
    }
}
