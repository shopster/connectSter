package com.shopify.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
 * Orders come from the xml shopify form:
 * 
 *  
 * <order>
 *   <buyer-accepts-marketing type="boolean">false</buyer-accepts-marketing>
 *   <closed-at type="datetime" nil="true"></closed-at>
 *   <created-at type="datetime">2008-01-10T11:00:00-05:00</created-at>
 *   <currency>USD</currency>
 *   <email>bob.norman@hostmail.com</email>
 *   <financial-status>authorized</financial-status>
 *   <fulfillment-status nil="true"></fulfillment-status>
 *   <gateway>authorize_net</gateway>
 *   <id type="integer">450789469</id>
 *   <landing-site>http://www.example.com?source=abc</landing-site>
 *   <name>#1001</name>
 *   <note nil="true"></note>
 *   <number type="integer">1</number>
 *   <referring-site>http://www.otherexample.com</referring-site>
 *   <subtotal-price type="decimal">199.00</subtotal-price>
 *   <taxes-included type="boolean">false</taxes-included>
 *   <token>b1946ac92492d2347c6235b4d2611184</token>
 *   <total-discounts type="decimal">0.00</total-discounts>
 *   <total-line-items-price type="decimal">199.00</total-line-items-price>
 *   <total-price type="decimal">210.94</total-price>
 *   <total-tax type="decimal">11.94</total-tax>
 *   <total-weight type="integer">0</total-weight>
 *   <updated-at type="datetime">2008-01-10T11:00:00-05:00</updated-at>
 *   <browser-ip nil="true"></browser-ip>
 *   <landing-site-ref>abc</landing-site-ref>
 *   <order-number type="integer">1001</order-number>
 *   <billing-address>
 *     <address1>Chestnut Street 92</address1>
 *     <address2></address2>
 *     <city>Louisville</city>
 *     <company nil="true"></company>
 *     <country>United States</country>
 *     <first-name>Bob</first-name>
 *     <last-name>Norman</last-name>
 *     <phone>555-625-1199</phone>
 *     <province>Kentucky</province>
 *     <zip>40202</zip>
 *     <name>Bob Norman</name>
 *     <country-code>US</country-code>
 *     <province-code>KY</province-code>
 *   </billing-address>
 *   <shipping-address>
 *     <address1>Chestnut Street 92</address1>
 *     <address2></address2>
 *     <city>Louisville</city>
 *     <company nil="true"></company>
 *     <country>United States</country>
 *     <first-name>Bob</first-name>
 *     <last-name>Norman</last-name>
 *     <phone>555-625-1199</phone>
 *     <province>Kentucky</province>
 *     <zip>40202</zip>
 *     <name>Bob Norman</name>
 *     <country-code>US</country-code>
 *     <province-code>KY</province-code>
 *   </shipping-address>
 *   <line-items type="array">
 *     <line-item>
 *       <fulfillment-service>manual</fulfillment-service>
 *       <fulfillment-status nil="true"></fulfillment-status>
 *       <grams type="integer">200</grams>
 *       <id type="integer">466157049</id>
 *       <price type="decimal">199.00</price>
 *       <product-id type="integer">632910392</product-id>
 *       <quantity type="integer">1</quantity>
 *       <requires-shipping type="boolean">true</requires-shipping>
 *       <sku>IPOD2008GREEN</sku>
 *       <title>IPod Nano - 8gb</title>
 *       <variant-id type="integer">39072856</variant-id>
 *       <variant-title>green</variant-title>
 *       <vendor nil="true"></vendor>
 *       <name>IPod Nano - 8gb - green</name>
 *     </line-item>
 *     <line-item>
 *       <fulfillment-service>manual</fulfillment-service>
 *       <fulfillment-status nil="true"></fulfillment-status>
 *       <grams type="integer">200</grams>
 *       <id type="integer">703073504</id>
 *       <price type="decimal">199.00</price>
 *       <product-id type="integer">632910392</product-id>
 *       <quantity type="integer">1</quantity>
 *       <requires-shipping type="boolean">true</requires-shipping>
 *       <sku>IPOD2008BLACK</sku>
 *       <title>IPod Nano - 8gb</title>
 *       <variant-id type="integer">457924702</variant-id>
 *       <variant-title>black</variant-title>
 *       <vendor nil="true"></vendor>
 *       <name>IPod Nano - 8gb - black</name>
 *     </line-item>
 *   </line-items>
 *   <shipping-lines type="array">
 *     <shipping-line>
 *       <code>Free Shipping</code>
 *       <price type="decimal">0.00</price>
 *       <title>Free Shipping</title>
 *     </shipping-line>
 *   </shipping-lines>
 *   <tax-lines type="array">
 *     <tax-line>
 *       <price type="decimal">11.94</price>
 *       <rate type="float">0.06</rate>
 *       <title>State Tax</title>
 *     </tax-line>
 *   </tax-lines>
 *   <payment-details>
 *     <credit-card-number>XXXX-XXXX-XXXX-4242</credit-card-number>
 *     <credit-card-company>Visa</credit-card-company>
 *   </payment-details>
 *   <shipping-line>
 *     <code>Free Shipping</code>
 *     <price type="decimal">0.00</price>
 *     <title>Free Shipping</title>
 *   </shipping-line>
 *   <note-attributes type="array">
 *   </note-attributes>
 * </order>
 *
 * For Aliases see ShopifyEntityHelper::buildXStream.
 */
public class ShopifyOrder
implements Serializable
{
    private static final long serialVersionUID = 1L;

    private boolean buyerAcceptsMarketing;
    private Date closedAt;
    private Date createdAt;
    private String currency;
    private String email;
    private String financialStatus;
    private String fulfillmentStatus;
    private String gateway;
    private int id;
    private String landingSite;
    private String name;
    private String note;
    private int number;
    private String referringSite;
    private double subtotalPrice;
    private boolean taxesIncluded;
    private String token;
    private double totalDiscounts;
    private double totalLineItemsPrice;
    private double totalPrice;
    private double totalTax;
    private int totalWeight;
    private Date updatedWeight;
    private String browserIp;
    private String landingSiteRef;
    private int orderNumber;
    private ShopifyAddress billingAddress;
    private ShopifyAddress shippingAddress;
    private List<ShopifyLineItem> lineItems;
    private List<ShopifyShippingLine> shippingLines;
    private List<ShopifyTaxLine> taxLines;
    private ShopifyPaymentDetails paymentDetails;
    private List<ShopifyNoteAttribute> noteAttributes;

    public boolean isBuyerAcceptsMarketing()
    {
        return buyerAcceptsMarketing;
    }

    public void setBuyerAcceptsMarketing( boolean buyerAcceptsMarketing )
    {
        this.buyerAcceptsMarketing = buyerAcceptsMarketing;
    }

    public Date getClosedAt()
    {
        return closedAt;
    }

    public void setClosedAt( Date closedAt )
    {
        this.closedAt = closedAt;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt( Date createdAt )
    {
        this.createdAt = createdAt;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency( String currency )
    {
        this.currency = currency;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getFinancialStatus()
    {
        return financialStatus;
    }

    public void setFinancialStatus( String financialStatus )
    {
        this.financialStatus = financialStatus;
    }

    public String getFulfillmentStatus()
    {
        return fulfillmentStatus;
    }

    public void setFulfillmentStatus( String fulfillmentStatus )
    {
        this.fulfillmentStatus = fulfillmentStatus;
    }

    public String getGateway()
    {
        return gateway;
    }

    public void setGateway( String gateway )
    {
        this.gateway = gateway;
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getLandingSite()
    {
        return landingSite;
    }

    public void setLandingSite( String landingSite )
    {
        this.landingSite = landingSite;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote( String note )
    {
        this.note = note;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber( int number )
    {
        this.number = number;
    }

    public String getReferringSite()
    {
        return referringSite;
    }

    public void setReferringSite( String referringSite )
    {
        this.referringSite = referringSite;
    }

    public double getSubtotalPrice()
    {
        return subtotalPrice;
    }

    public void setSubtotalPrice( double subtotalPrice )
    {
        this.subtotalPrice = subtotalPrice;
    }

    public boolean isTaxesIncluded()
    {
        return taxesIncluded;
    }

    public void setTaxesIncluded( boolean taxesIncluded )
    {
        this.taxesIncluded = taxesIncluded;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken( String token )
    {
        this.token = token;
    }

    public double getTotalDiscounts()
    {
        return totalDiscounts;
    }

    public void setTotalDiscounts( double totalDiscounts )
    {
        this.totalDiscounts = totalDiscounts;
    }

    public double getTotalLineItemsPrice()
    {
        return totalLineItemsPrice;
    }

    public void setTotalLineItemsPrice( double totalLineItemsPrice )
    {
        this.totalLineItemsPrice = totalLineItemsPrice;
    }

    public double getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice( double totalPrice )
    {
        this.totalPrice = totalPrice;
    }

    public double getTotalTax()
    {
        return totalTax;
    }

    public void setTotalTax( double totalTax )
    {
        this.totalTax = totalTax;
    }

    public int getTotalWeight()
    {
        return totalWeight;
    }

    public void setTotalWeight( int totalWeight )
    {
        this.totalWeight = totalWeight;
    }

    public Date getUpdatedWeight()
    {
        return updatedWeight;
    }

    public void setUpdatedWeight( Date updatedWeight )
    {
        this.updatedWeight = updatedWeight;
    }

    public String getBrowserIp()
    {
        return browserIp;
    }

    public void setBrowserIp( String browserIp )
    {
        this.browserIp = browserIp;
    }

    public String getLandingSiteRef()
    {
        return landingSiteRef;
    }

    public void setLandingSiteRef( String landingSiteRef )
    {
        this.landingSiteRef = landingSiteRef;
    }

    public int getOrderNumber()
    {
        return orderNumber;
    }

    public void setOrderNumber( int orderNumber )
    {
        this.orderNumber = orderNumber;
    }

    public ShopifyAddress getBillingAddress()
    {
        return billingAddress;
    }

    public void setBillingAddress( ShopifyAddress billingAddress )
    {
        this.billingAddress = billingAddress;
    }

    public ShopifyAddress getShippingAddress()
    {
        return shippingAddress;
    }

    public void setShippingAddress( ShopifyAddress shippingAddress )
    {
        this.shippingAddress = shippingAddress;
    }

    public List<ShopifyLineItem> getLineItems()
    {
        return lineItems;
    }

    public void setLineItems( List<ShopifyLineItem> lineItems )
    {
        this.lineItems = lineItems;
    }

    public List<ShopifyShippingLine> getShippingLines()
    {
        return shippingLines;
    }

    public void setShippingLines( List<ShopifyShippingLine> shippingLines )
    {
        this.shippingLines = shippingLines;
    }

    public List<ShopifyTaxLine> getTaxLines()
    {
        return taxLines;
    }

    public void setTaxLines( List<ShopifyTaxLine> taxLines )
    {
        this.taxLines = taxLines;
    }

    public ShopifyPaymentDetails getPaymentDetails()
    {
        return paymentDetails;
    }

    public void setPaymentDetails( ShopifyPaymentDetails paymentDetails )
    {
        this.paymentDetails = paymentDetails;
    }

    public List<ShopifyNoteAttribute> getNoteAttributes()
    {
        return noteAttributes;
    }

    public void setNoteAttributes( List<ShopifyNoteAttribute> noteAttributes )
    {
        this.noteAttributes = noteAttributes;
    }
}
