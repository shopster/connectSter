package connectster.server;

import connectster.adapter.shopify.ShopifyAdapter;
import connectster.adapter.shopster.ShopsterAdapter;
import connectster.server.entity.AdapterDetails;
import connectster.server.entity.AdapterProperty;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
public class ServerConsole
{
    public static void main( String ... args )
    throws IOException
    {
        if( args.length == 2 && args[ 0 ].equalsIgnoreCase( "--install" ) )
        {
            Properties properties = new Properties( );
            properties.load( new FileReader( args[ 1 ] ) );
            initializeSystem( properties );
        }

        ConnectsterServer server = new ConnectsterServer( );
        server.startup( );

        System.out.println( "Hit Enter to Quit Server Console ..." );
        new InputStreamReader( System.in ).read( );

        server.shutdown( );

    }

    /**
     * This method will pull initialization properties off the given properties file and build up the initial adapter
     * details for the shopster and shopify adapters.  This is the minimal configuration set, further adapters can be
     * added via the database.  This should really be put into a database script or a manager page for connectster.
     *
     * @param properties Installation properties
     */
    public static void initializeSystem( Properties properties )
    {
        // build shopster adapter details
        AdapterDetails shopsterAdapter = new AdapterDetails( "ConnectsterAdapter", "This is the connectster adapter.",
            "ShopsterAdapter", "1.0" );

        List<AdapterProperty> shopsterProperties = new ArrayList<AdapterProperty>( );
        shopsterProperties.add( new AdapterProperty( ShopsterAdapter.Property.WebServiceVersion.toString( ),
            ( String )properties.get( "Shopster." + ShopsterAdapter.Property.WebServiceVersion.toString( ) ), shopsterAdapter ) );
        shopsterProperties.add( new AdapterProperty( ShopsterAdapter.Property.OAuthUri.toString( ),
            ( String )properties.get( "Shopster." + ShopsterAdapter.Property.OAuthUri.toString( ) ), shopsterAdapter ) );
        shopsterProperties.add( new AdapterProperty( ShopsterAdapter.Property.Namespace.toString( ),
            ( String )properties.get( "Shopster." + ShopsterAdapter.Property.Namespace.toString( ) ), shopsterAdapter ) );
        shopsterProperties.add( new AdapterProperty( ShopsterAdapter.Property.Endpoint.toString( ),
            ( String )properties.get( "Shopster." + ShopsterAdapter.Property.Endpoint.toString( ) ), shopsterAdapter ) );
        shopsterProperties.add( new AdapterProperty( ShopsterAdapter.Property.ConsumerKey.toString( ),
            ( String )properties.get( "Shopster." + ShopsterAdapter.Property.ConsumerKey.toString( ) ), shopsterAdapter ) );
        shopsterProperties.add( new AdapterProperty( ShopsterAdapter.Property.ConsumerSecret.toString( ),
            ( String )properties.get( "Shopster." + ShopsterAdapter.Property.ConsumerSecret.toString( ) ), shopsterAdapter ) );
        shopsterAdapter.setAdapterProperties( shopsterProperties );

        HibernateUtility.transaction( );
        HibernateUtility.getSession( ).save( shopsterAdapter );
        HibernateUtility.commit( );

        // build shopify adapter details and assign properties for test purposes
        AdapterDetails shopifyAdapter = new AdapterDetails( "ShopifyAdapter", "This is the shopify adapter implementation",
            "ShopifyAdapter", "1.0" );

        List<AdapterProperty> adapterProperties = new ArrayList<AdapterProperty>( );
        adapterProperties.add( new AdapterProperty( ShopsterAdapter.Property.Namespace.toString( ),
            ( String )properties.get( "Shopify." + ShopsterAdapter.Property.Namespace.toString( ) ), shopifyAdapter ) );
        adapterProperties.add( new AdapterProperty( ShopsterAdapter.Property.Endpoint.toString( ),
            ( String )properties.get( "Shopify." + ShopsterAdapter.Property.Endpoint.toString( ) ), shopifyAdapter ) );
        adapterProperties.add( new AdapterProperty( ShopsterAdapter.Property.ConsumerKey.toString( ),
            ( String )properties.get( "Shopify." + ShopsterAdapter.Property.ConsumerKey.toString( ) ), shopifyAdapter ) );
        adapterProperties.add( new AdapterProperty( ShopsterAdapter.Property.ConsumerSecret.toString( ),
            ( String )properties.get( "Shopify." + ShopsterAdapter.Property.ConsumerSecret.toString( ) ), shopifyAdapter ) );
        adapterProperties.add( new AdapterProperty( ShopifyAdapter.Property.Protocol.toString( ),
            ( String )properties.get( "Shopify." + ShopifyAdapter.Property.Protocol.toString( ) ), shopifyAdapter ) );
        adapterProperties.add( new AdapterProperty( ShopifyAdapter.Property.Timeout.toString( ),
            ( String )properties.get( "Shopify." + ShopifyAdapter.Property.Timeout.toString( ) ), shopifyAdapter ) );
        adapterProperties.add( new AdapterProperty( ShopifyAdapter.Property.ShopifyKey.toString( ),
            ( String )properties.get( "Shopify." + ShopifyAdapter.Property.ShopifyKey.toString( ) ), shopifyAdapter ) );
        adapterProperties.add( new AdapterProperty( ShopifyAdapter.Property.ShopifySecret.toString( ),
            ( String )properties.get( "Shopify." + ShopifyAdapter.Property.ShopifySecret.toString( ) ), shopifyAdapter ) );
        adapterProperties.add( new AdapterProperty( ShopifyAdapter.Property.InstallCallbackUri.toString( ),
            ( String )properties.get( "Shopify." + ShopifyAdapter.Property.InstallCallbackUri.toString( ) ), shopifyAdapter ) );
        adapterProperties.add( new AdapterProperty( ShopifyAdapter.Property.BaseCallbackUri.toString( ),
            ( String )properties.get( "Shopify." + ShopifyAdapter.Property.BaseCallbackUri.toString( ) ), shopifyAdapter ) );
        adapterProperties.add( new AdapterProperty( ShopifyAdapter.Property.RequestUri.toString( ),
            ( String )properties.get( "Shopify." + ShopifyAdapter.Property.RequestUri.toString( ) ), shopifyAdapter ) );
        shopifyAdapter.setAdapterProperties( adapterProperties );
        shopifyAdapter.setMaster( shopsterAdapter );

        HibernateUtility.transaction( );
        HibernateUtility.getSession( ).save( shopifyAdapter );
        HibernateUtility.commit( );
    }
}
