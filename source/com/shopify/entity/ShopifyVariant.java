package com.shopify.entity;

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
public class ShopifyVariant
implements Serializable
{
    private static final long serialVersionUID = 1L;

    private double compareAtPrice;
    private Date createdAt;
    private String fulfillmentService;
    private int grams;
    private int id;
    private String inventoryManagement;
    private String inventoryPolicy;
    private int inventoryQuantity;
    private String option1;
    private String option2;
    private String option3;
    private int position;
    private double price;
    private int productId;
    private boolean requiresShipping;
    private String sku;
    private boolean taxable;
    private String title;
    private Date updatedAt;

    public double getCompareAtPrice()
    {
        return compareAtPrice;
    }

    public void setCompareAtPrice( double compareAtPrice )
    {
        this.compareAtPrice = compareAtPrice;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt( Date createdAt )
    {
        this.createdAt = createdAt;
    }

    public String getFulfillmentService()
    {
        return fulfillmentService;
    }

    public void setFulfillmentService( String fulfillmentService )
    {
        this.fulfillmentService = fulfillmentService;
    }

    public int getGrams()
    {
        return grams;
    }

    public void setGrams( int grams )
    {
        this.grams = grams;
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getInventoryManagement()
    {
        return inventoryManagement;
    }

    public void setInventoryManagement( String inventoryManagement )
    {
        this.inventoryManagement = inventoryManagement;
    }

    public String getInventoryPolicy()
    {
        return inventoryPolicy;
    }

    public void setInventoryPolicy( String inventoryPolicy )
    {
        this.inventoryPolicy = inventoryPolicy;
    }

    public int getInventoryQuantity()
    {
        return inventoryQuantity;
    }

    public void setInventoryQuantity( int inventoryQuantity )
    {
        this.inventoryQuantity = inventoryQuantity;
    }

    public String getOption1()
    {
        return option1;
    }

    public void setOption1( String option1 )
    {
        this.option1 = option1;
    }

    public String getOption2()
    {
        return option2;
    }

    public void setOption2( String option2 )
    {
        this.option2 = option2;
    }

    public String getOption3()
    {
        return option3;
    }

    public void setOption3( String option3 )
    {
        this.option3 = option3;
    }

    public int getPosition()
    {
        return position;
    }

    public void setPosition( int position )
    {
        this.position = position;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice( double price )
    {
        this.price = price;
    }

    public int getProductId()
    {
        return productId;
    }

    public void setProductId( int productId )
    {
        this.productId = productId;
    }

    public boolean isRequiresShipping()
    {
        return requiresShipping;
    }

    public void setRequiresShipping( boolean requiresShipping )
    {
        this.requiresShipping = requiresShipping;
    }

    public String getSku()
    {
        return sku;
    }

    public void setSku( String sku )
    {
        this.sku = sku;
    }

    public boolean isTaxable()
    {
        return taxable;
    }

    public void setTaxable( boolean taxable )
    {
        this.taxable = taxable;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle( String title )
    {
        this.title = title;
    }

    public Date getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt( Date updatedAt )
    {
        this.updatedAt = updatedAt;
    }
}
