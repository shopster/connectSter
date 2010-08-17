package com.shopify.entity;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import connectster.api.entity.IProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
public class ShopifyEntityHelper
{
    private static SimpleDateFormat dateFormat;
    private static XStream xstream;

    private static final String EMPTY_RESULT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
    "<nil-classes type=\"array\"/>\n";

    static
    {
        dateFormat = new SimpleDateFormat( "yyyy-MM-dd'T'hh:mm:ssZ", Locale.US );
        xstream = buildXStream( );
    }

    public static String toXml( ShopifyVariant variant )
    {
        return xstream.toXML( variant );
    }

    public static String toXml( ShopifyWebhook webhook )
    {
        return xstream.toXML( webhook );
    }

    public static String toXml( ShopifyProductGroup productGroup )
    {
        return xstream.toXML( productGroup );
    }

    public static String toXml( ShopifyProduct product )
    {
        return xstream.toXML( product );
    }

    public static ShopifyOrder toShopifyOrder( String xml )
    {
        return ( ShopifyOrder )xstream.fromXML( xml );
    }

    public static ShopifyProduct toShopifyProduct( String xml )
    {
        return ( ShopifyProduct )xstream.fromXML( xml );
    }

    public static ShopifyProduct toShopifyProduct( String id, IProduct product )
    {
        ShopifyProduct shopifyProduct = new ShopifyProduct( );
        shopifyProduct.setId( id );
        shopifyProduct.setTitle( product.getName( ) );
        shopifyProduct.setUpdatedAt( product.getLastUpdate( ) );
        shopifyProduct.setVendor( product.getVendor( ) );
        shopifyProduct.setProductType( product.getType( ) );

        ShopifyVariant shopifyVariant = new ShopifyVariant( );
        shopifyVariant.setOption1( "Connectster" );
        shopifyVariant.setGrams( product.getGrams( ) );
        shopifyVariant.setProductId( ( int )product.getId( ) );
        shopifyVariant.setPrice( product.getPrice( ) );
        shopifyVariant.setSku( product.getSku( ) );
        shopifyVariant.setInventoryQuantity( product.getQuantity( ) );

        List<ShopifyVariant> variants = new ArrayList<ShopifyVariant>( );
        variants.add( shopifyVariant );
        shopifyProduct.setVariants( variants );

        return shopifyProduct;
    }

    /** Returns a ShopifyProductGroup representing the collection of products as specified in the xml payload.  If the
     *  xml payload is null or matches the EMPTY_RESULT guard condition, then an empty product group is returned.
     *
     * @param xml The payload to deserialize into product group.
     * @return A ShopifyProductGroup either empty if xml was null/guarded or populated, but never null.
     */
    public static ShopifyProductGroup getProducts( String xml )
    {
        if( xml == null || xml.equalsIgnoreCase( EMPTY_RESULT ) )
        {
            return new ShopifyProductGroup( );
        }

        return ( ShopifyProductGroup )xstream.fromXML( xml );
    }

    public static XStream buildXStream()
    {
        XStream xstream = new XStream()
        {
            @Override
            protected MapperWrapper wrapMapper( MapperWrapper next )
            {
                return new MapperWrapper( next )
                {
                    @Override
                    public boolean shouldSerializeMember( Class definedIn, String fieldName )
                    {
                        return definedIn != Object.class && super.shouldSerializeMember( definedIn, fieldName );
                    }
                };
            }
        };

        // product
        xstream.alias( "products", ShopifyProductGroup.class );
        xstream.alias( "product", ShopifyProduct.class );
        xstream.aliasField( "body-html", ShopifyProduct.class, "bodyHtml" );
        xstream.aliasField( "created-at", ShopifyProduct.class, "createdAt" );
        xstream.aliasField( "product-type", ShopifyProduct.class, "productType" );
        xstream.aliasField( "published-at", ShopifyProduct.class, "publishedAt" );
        xstream.aliasField( "template-suffix", ShopifyProduct.class, "templateSuffix" );
        xstream.aliasField( "updated-at", ShopifyProduct.class, "updatedAt" );

        // product-variant
        xstream.alias( "variant", ShopifyVariant.class );
        xstream.aliasField( "compare-at-price", ShopifyVariant.class, "compareAtPrice" );
        xstream.aliasField( "created-at", ShopifyVariant.class, "createdAt" );
        xstream.aliasField( "fulfillment-service", ShopifyVariant.class, "fulfillmentService" );
        xstream.aliasField( "inventory-management", ShopifyVariant.class, "inventoryManagement" );
        xstream.aliasField( "inventory-policy", ShopifyVariant.class, "inventoryPolicy" );
        xstream.aliasField( "inventory-quantity", ShopifyVariant.class, "inventoryQuantity" );
        xstream.aliasField( "product-id", ShopifyVariant.class, "productId" );
        xstream.aliasField( "requires-shipping", ShopifyVariant.class, "requiresShipping" );
        xstream.aliasField( "updated-at", ShopifyVariant.class, "updatedAt" );

        // product-image
        xstream.alias( "image", ShopifyImage.class );
        xstream.aliasField( "created-at", ShopifyImage.class, "createdAt" );
        xstream.aliasField( "product-id", ShopifyImage.class, "productId" );
        xstream.aliasField( "updated-at", ShopifyImage.class, "updatedAt" );

        // product-option
        xstream.alias( "option", ShopifyOption.class );

        // order
        xstream.alias( "order", ShopifyOrder.class );
        xstream.aliasField( "buyer-accepts-marketing", ShopifyOrder.class, "buyerAcceptsMarketing" );
        xstream.aliasField( "closed-at", ShopifyOrder.class, "closedAt" );
        xstream.aliasField( "created-at", ShopifyOrder.class, "createdAt" );
        xstream.aliasField( "financial-status", ShopifyOrder.class, "financialStatus" );
        xstream.aliasField( "fulfillment-status", ShopifyOrder.class, "fulfillmentStatus" );
        xstream.aliasField( "landing-site", ShopifyOrder.class, "landingSite" );
        xstream.aliasField( "referring-site", ShopifyOrder.class, "referringSite" );
        xstream.aliasField( "subtotal-price", ShopifyOrder.class, "subtotalPrice" );
        xstream.aliasField( "taxes-included", ShopifyOrder.class, "taxesIncluded" );
        xstream.aliasField( "total-discounts", ShopifyOrder.class, "totalDiscounts" );
        xstream.aliasField( "total-line-items-price", ShopifyOrder.class, "totalLineItemsPrice" );
        xstream.aliasField( "total-price", ShopifyOrder.class, "totalPrice" );
        xstream.aliasField( "total-tax", ShopifyOrder.class, "totalTax" );
        xstream.aliasField( "total-weight", ShopifyOrder.class, "totalWeight" );
        xstream.aliasField( "updated-at", ShopifyOrder.class, "updatedAt" );
        xstream.aliasField( "browser-ip", ShopifyOrder.class, "browserIp" );
        xstream.aliasField( "landing-site-ref", ShopifyOrder.class, "landingSiteRef" );
        xstream.aliasField( "order-number", ShopifyOrder.class, "orderNumber" );
        xstream.aliasField( "billing-address", ShopifyOrder.class, "billingAddress" );
        xstream.aliasField( "shipping-address", ShopifyOrder.class, "shippingAddress" );
        xstream.aliasField( "line-items", ShopifyOrder.class, "lineItems" );
        xstream.aliasField( "shipping-lines", ShopifyOrder.class, "shippingLines" );
        xstream.aliasField( "tax-lines", ShopifyOrder.class, "taxLines" );
        xstream.aliasField( "payment-details", ShopifyOrder.class, "paymentDetails" );
        xstream.aliasField( "shipping-line", ShopifyOrder.class, "shippingLine" );
        xstream.aliasField( "note-attributes", ShopifyOrder.class, "noteAttributes" );

        // order-address
        xstream.aliasField( "first-name", ShopifyAddress.class, "firstName" );
        xstream.aliasField( "last-name", ShopifyAddress.class, "lastName" );
        xstream.aliasField( "country-code", ShopifyAddress.class, "countryCode" );
        xstream.aliasField( "province-code", ShopifyAddress.class, "provinceCode" );

        // order-lineitem
        xstream.alias( "line-item", ShopifyLineItem.class );
        xstream.aliasField( "fulfillment-service", ShopifyLineItem.class, "fulfillmentService" );
        xstream.aliasField( "fulfillment-status", ShopifyLineItem.class, "fulfillmentStatus" );
        xstream.aliasField( "product-id", ShopifyLineItem.class, "productId" );
        xstream.aliasField( "requires-shipping", ShopifyLineItem.class, "requiresShipping" );
        xstream.aliasField( "variant-id", ShopifyLineItem.class, "variantId" );
        xstream.aliasField( "variant-title", ShopifyLineItem.class, "variantTitle" );

        // order-shipping/tax-line
        xstream.alias( "shipping-line", ShopifyShippingLine.class );
        xstream.alias( "tax-line", ShopifyTaxLine.class );
        xstream.aliasField( "credit-card-number", ShopifyPaymentDetails.class, "creditCardNumber" );
        xstream.aliasField( "credit-card-company", ShopifyPaymentDetails.class, "creditCardCompany" );

        // webhook
        xstream.alias( "webhook", ShopifyWebhook.class );

        registerConverters( xstream );
        
        return xstream;
    }

    private static void registerConverters( XStream xstream )
    {

        xstream.registerConverter( new SingleValueConverter( ) {
            @Override
            public String toString( Object o )
            {
                return ( o == null ) ? "-1" : o.toString( );
            }

            @Override
            public Object fromString( String s )
            {
                return ( s == null || s.trim( ).length( ) < 1 ) ? -1 : Integer.parseInt( s );
            }

            @Override
            public boolean canConvert( Class aClass )
            {
                return aClass == Integer.class;
            }
        });

        // Date converter, using format: 2010-06-25T15:17:42-04:00
        xstream.registerConverter( new SingleValueConverter()
        {
            @Override
            public String toString( Object o )
            {
                return dateFormat.format( o );
            }

            @Override
            public Object fromString( String s )
            {
                try
                {
                    return dateFormat.parse( s );
                }
                catch( ParseException x )
                {
                    return null;
                }
            }

            @Override
            public boolean canConvert( Class aClass )
            {
                return aClass == Date.class;
            }
        } );

        xstream.registerConverter( new SingleValueConverter()
        {
            @Override
            public String toString( Object o )
            {
                return ( o == null ) ? "0" : o.toString();
            }

            @Override
            public Object fromString( String s )
            {
                return ( s == null || s.isEmpty() ) ? 0 : Double.parseDouble( s );
            }

            @Override
            public boolean canConvert( Class aClass )
            {
                return aClass == double.class || aClass == Double.class;
            }
        } );
      
        xstream.registerConverter( new Converter()
        {

            @Override
            public void marshal( Object o, HierarchicalStreamWriter writer, MarshallingContext context )
            {
                ShopifyProductGroup group = ( ShopifyProductGroup )o;
                writer.startNode( "products" );

                List<ShopifyProduct> products = group.getProducts( );
                for( ShopifyProduct product : products )
                {
                    context.convertAnother( product );
                }

                writer.endNode ();
            }

            @Override
            public Object unmarshal( HierarchicalStreamReader reader, UnmarshallingContext context )
            {
                ShopifyProductGroup products = new ShopifyProductGroup();

                List<ShopifyProduct> lst = new ArrayList<ShopifyProduct>();
                while( reader.hasMoreChildren() )
                {
                    reader.moveDown( );
                    ShopifyProduct thisProduct = ( ShopifyProduct )context.convertAnother( products, ShopifyProduct.class );
                    lst.add( thisProduct );
                    reader.moveUp( );
                }

                products.setProducts( lst );
                return products;
            }

            @Override
            public boolean canConvert( Class aClass )
            {
                return aClass == ShopifyProductGroup.class;
            }
        } );
    }
}
