package com.shopify;

import com.shopify.entity.AuthDetails;
import connectster.api.entity.IAdapterProperty;

import java.util.*;
import java.util.logging.Logger;

public class AuthManager
{
    public static final long CHECK_INTERVAL = 2500;

    private static final Logger log = Logger.getLogger( AuthManager.class.getName( ) );
    private static final Map<String,AuthDetails> authMap;
    private static final AuthManager instance;
    private static final Timer timer;
    private static long timeout;

    private AuthManager( )
    {
        Map<String, IAdapterProperty> properties = ShopifyAdapter.getInstance( ).getProperties( );
        timeout = Long.parseLong( properties.get( ShopifyAdapter.Property.Timeout.toString( ) ).getValue( ) );
    }

    static
    {
        instance = new AuthManager( );
        authMap = new HashMap<String,AuthDetails>( );
        timer = new Timer( "RequestCleanup" );
        timer.scheduleAtFixedRate( new CleanupTask( ), 0, CHECK_INTERVAL );
    }

    public static AuthManager getInstance( )
    {
        return instance;
    }

    public void add( String id, AuthDetails details )
    {
        synchronized( authMap )
        {            
            authMap.put( id, details );
        }
    }

    public AuthDetails remove( String id )
    {
        AuthDetails details;

        synchronized( authMap )
        {
            details = authMap.remove( id );
        }

        return details; 
    }

    private static class CleanupTask
    extends TimerTask
    {
        @Override
        public void run( )
        {
            synchronized( authMap )
            {
                Set<String> keys = authMap.keySet( );
                for( String key : keys )
                {
                    AuthDetails details = authMap.get( key );

                    long currentTimestamp = System.currentTimeMillis( );
                    long detailsTimestamp = details.getRequestTimestamp( );
                    if( currentTimestamp - detailsTimestamp > timeout )
                    {
                        keys.remove( key );
                        log.info( "Removing authorization request due to timeout: " + details.getStore( ) );
                    }
                }
            }
        }
    }
}
