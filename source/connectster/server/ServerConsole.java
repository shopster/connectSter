package connectster.server;

import connectster.server.entity.AdapterDetails;
import connectster.server.entity.AdapterProperty;
import sun.misc.Signal;
import sun.misc.SignalHandler;

import java.io.FileReader;
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
implements SignalHandler
{
    private static final String SHOPSTER_PREFIX = "Shopster.";
    private static final String SHOPIFY_PREFIX = "Shopify.";

    private static ServerConsole console;
    private static ConnectsterServer server;

    public static void main( String ... args )
    throws Exception
    {
        console = new ServerConsole( );

        // determine if a fresh install request is being asked for
        if( args.length == 2 && args[ 0 ].equalsIgnoreCase( "--install" ) )
        {
            Properties properties = new Properties( );
            properties.load( new FileReader( args[ 1 ] ) );
            initializeSystem( properties );
        }

        // build and start server
        server = new ConnectsterServer( );
        server.startup( );

        // register a shutdown hook to capture TERM/INT/ABORT signals and just sleep while app runs
        installHooks( );
        while( true ) { Thread.sleep( 0 ); }
    }

    private static void installHooks( )
    {
        Signal.handle( new Signal( "TERM" ), console );
        Signal.handle( new Signal( "INT" ), console );
        Signal.handle( new Signal( "ABRT" ), console );
    }

    /**
     * Deal with signals to server console to quit/abort or interrupt.
     * @param signal The signal being received by JVM.
     */
    @Override
    public void handle( Signal signal )
    {
        System.out.println( "\n\n*** SHUTDOWN REQUESTED ***\n\n" );
        server.shutdown( );
        System.exit( 0 );
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
            "connectster.adapter.shopster.ShopsterAdapter", "1.0" );

        // read in all the shopster properties
        List<AdapterProperty> shopsterProperties = new ArrayList<AdapterProperty>( );
        for( Object rawKey : properties.keySet( ) )
        {
            String key = ( String )rawKey;
            if( key.startsWith( SHOPSTER_PREFIX ) )
            {
                String normalizedKey = key.substring( SHOPSTER_PREFIX.length( ) );
                shopsterProperties.add( new AdapterProperty( normalizedKey, ( String )properties.get( key ), shopsterAdapter ) );
            }
        }
        shopsterAdapter.setAdapterProperties( shopsterProperties );

        HibernateUtility.transaction( );
        HibernateUtility.getSession( ).save( shopsterAdapter );
        HibernateUtility.commit( );

        // build shopify adapter details and assign properties for test purposes
        AdapterDetails shopifyAdapter = new AdapterDetails( "ShopifyAdapter", "This is the shopify adapter implementation",
            "connectster.adapter.shopify.ShopifyAdapter", "1.0" );

        // read in all the shopify properties
        List<AdapterProperty> shopifyProperties = new ArrayList<AdapterProperty>( );
        for( Object rawKey : properties.keySet( ) )
        {
            String key = ( String )rawKey;
            if( key.startsWith( SHOPIFY_PREFIX ) )
            {
                String normalizedKey = key.substring( SHOPIFY_PREFIX.length( ) );
                shopifyProperties.add( new AdapterProperty( normalizedKey,( String )properties.get( key ), shopifyAdapter ) );
            }
        }
        shopifyAdapter.setAdapterProperties( shopifyProperties );
        shopifyAdapter.setMaster( shopsterAdapter );

        HibernateUtility.transaction( );
        HibernateUtility.getSession( ).save( shopifyAdapter );
        HibernateUtility.commit( );
    }
}
