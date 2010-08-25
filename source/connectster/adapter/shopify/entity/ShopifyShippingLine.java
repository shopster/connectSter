package connectster.adapter.shopify.entity;

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
public class ShopifyShippingLine
implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String code;
    private double price;
    private String title;

    public String getCode()
    {
        return code;
    }

    public void setCode( String code )
    {
        this.code = code;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice( double price )
    {
        this.price = price;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle( String title )
    {
        this.title = title;
    }

    public boolean equals( Object rhs )
    {
        if( rhs == null || !( rhs instanceof ShopifyShippingLine ) )
        {
            return false;
        }

        ShopifyShippingLine rhsLine = ( ShopifyShippingLine )rhs;
        return rhsLine.getCode().equals( code ) && rhsLine.getPrice() == price && rhsLine.getTitle().equals( title );
    }
}
