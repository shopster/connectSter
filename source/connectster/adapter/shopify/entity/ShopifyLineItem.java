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
 *
 * Form comes from shopify xml (see ShopifyEntityHelper for aliases):
 *
 * <line-item>
 *   <fulfillment-service>manual</fulfillment-service>
 *   <fulfillment-status nil="true"></fulfillment-status>
 *   <grams type="integer">200</grams>
 *   <id type="integer">466157049</id>
 *   <price type="decimal">199.00</price>
 *   <product-id type="integer">632910392</product-id>
 *   <quantity type="integer">1</quantity>
 *   <requires-shipping type="boolean">true</requires-shipping>
 *   <sku>IPOD2008GREEN</sku>
 *   <title>IPod Nano - 8gb</title>
 *   <variant-id type="integer">39072856</variant-id>
 *   <variant-title>green</variant-title>
 *   <vendor nil="true"></vendor>
 *   <name>IPod Nano - 8gb - green</name>
 * </line-item>
 */
public class ShopifyLineItem
implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String fulfillmentService;
    private String fulfillmentStatus;
    private int grams;
    private int id;
    private double price;
    private int productId;
    private int quantity;
    private boolean requiresShipping;
    private String sku;
    private String title;
    private int variantId;
    private String variantTitle;
    private String vendor;
    private String name;

    public String getFulfillmentService()
    {
        return fulfillmentService;
    }

    public void setFulfillmentService( String fulfillmentService )
    {
        this.fulfillmentService = fulfillmentService;
    }

    public String getFulfillmentStatus()
    {
        return fulfillmentStatus;
    }

    public void setFulfillmentStatus( String fulfillmentStatus )
    {
        this.fulfillmentStatus = fulfillmentStatus;
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

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity( int quantity )
    {
        this.quantity = quantity;
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

    public String getTitle()
    {
        return title;
    }

    public void setTitle( String title )
    {
        this.title = title;
    }

    public int getVariantId()
    {
        return variantId;
    }

    public void setVariantId( int variantId )
    {
        this.variantId = variantId;
    }

    public String getVariantTitle()
    {
        return variantTitle;
    }

    public void setVariantTitle( String variantTitle )
    {
        this.variantTitle = variantTitle;
    }

    public String getVendor()
    {
        return vendor;
    }

    public void setVendor( String vendor )
    {
        this.vendor = vendor;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }
}
