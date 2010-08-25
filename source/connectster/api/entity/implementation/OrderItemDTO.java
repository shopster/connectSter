package connectster.api.entity.implementation;

import connectster.api.entity.IOrder;
import connectster.api.entity.IOrderItem;
import connectster.api.entity.IProduct;

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
public class OrderItemDTO
implements IOrderItem
{
    private String id;
    private IProduct product;
    private IOrder order;
    private int quantity;

    public String getId()
    {
        return id;
    }

    public void setId( String id )
    {
        this.id = id;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity( int quantity )
    {
        this.quantity = quantity;
    }

    public IProduct getProduct()
    {
        return product;
    }

    public void setProduct( IProduct product )
    {
        this.product = product;
    }

    public IOrder getOrder( )
    {
        return order;
    }

    public void setOrder( IOrder orderId )
    {
        this.order = orderId;
    }
}
