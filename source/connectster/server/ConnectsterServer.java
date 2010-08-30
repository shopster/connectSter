package connectster.server;

import connectster.api.IAdapter;
import connectster.api.exceptions.AdapterException;
import connectster.server.entity.AdapterDetails;
import connectster.api.utility.GeneralUtilities;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

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
public class ConnectsterServer
{
    private static Logger log = Logger.getLogger( ConnectsterServer.class.getName( ) );

    private Map<Long, AdapterConnection> adapters;
    private ProductMonitor productMonitor;
    private OrderMonitor orderMonitor;

    public ConnectsterServer( )
    {
        adapters = new HashMap<Long, AdapterConnection>( );
    }

    public AdapterConnection getAdapterConnection( long id )
    {
        return adapters.get( id );
    }

    public IAdapter getAdapter( long id )
    {
        return adapters.get( id ).getInstalledAdapter( ).getAdapter( );
    }

    public void startup( )
    {
        initializeAdapters( );
        initializeMonitors( );
        log.info( "Connectster Server Started." );
    }

    public void shutdown( )
    {
        shutdownMonitors( );
        shutdownAdapters( );
        log.info( "Connectster Server Shutdown." );
    }

    public void initializeMonitors( )
    {
        // populate the active adapters list
        HashMap<Long,IAdapter> activeAdapters = new HashMap<Long,IAdapter>( );
        for( AdapterConnection connection : adapters.values( ) )
        {
            Long adapterId = connection.getInstalledAdapter( ).getDetails( ).getId( );
            IAdapter adapter = connection.getInstalledAdapter( ).getAdapter( );
            activeAdapters.put( adapterId, adapter );
        }

        // instantiate and start up the product monitor
        productMonitor = new ProductMonitor( activeAdapters );
        productMonitor.start( );

        // instantiate and start up the order monitor
        orderMonitor = new OrderMonitor( activeAdapters );
        orderMonitor.start( );
    }

    public void shutdownMonitors( )
    {
        productMonitor.stop( );
        orderMonitor.stop( );
    }

    /**
     * Allows each adapter to shutdown gracefully in the same order they have been registered.  Any form of exception
     * is captured and logged, so that each adapter has a chance to shutdown.
     */
    public void shutdownAdapters( )
    {
        for( AdapterConnection connection : adapters.values( ) )
        {
            InstalledAdapter installedAdapter = connection.getInstalledAdapter( );
            IAdapter adapter = installedAdapter.getAdapter( );

            try
            {
                log.info( "Shutting down adapter: " + installedAdapter.getDetails( ).getName( ) );
                adapter.shutdown( );
                log.info( "Adapter: " + installedAdapter.getDetails( ).getName( ) + ", has been shutdown." );
            }
            catch( Throwable x )
            {
                log.warning( "Failed to shutdown adapters: " + installedAdapter.getDetails( ).getName( ) + ", Reasons: " +
                    x.getMessage( ) );
            }
        }
    }


    /** Initializes all adapters by processing each AdapterDetail object found in the database and its associated
     *  AdapterProperty collection, then passing this down to the reflectively instantiated IAdapter instance via
     *  the initialize() method.  This method will build an AdapterConnection and put it into the adapters map for
     *  future reference.  The purpose of the AdapterConnection is to handle adapter requests and responses in a
     *  more secure way, it serves as the forward facing api to the adapters.
     */
    public void initializeAdapters( )
    {
        IterativeUnitOfWork<AdapterDetails> uow = new IterativeUnitOfWork<AdapterDetails>( ) {
            @Override
            public boolean next( AdapterDetails details )
            {
                try
                {
                    Class adapterClass = Class.forName( details.getClassName( ) );
                    IAdapter adapter = ( IAdapter )adapterClass.newInstance( );

                    AdapterConnection connection;
                    if( details.getMaster( ) == null )
                    {
                        connection = new MasterAdapterConnection( new InstalledAdapter( adapter, details ) );
                    }
                    else
                    {
                        AdapterConnection foundConnection = adapters.get( details.getMaster( ).getId( ) );
                        if( foundConnection == null || !( foundConnection instanceof MasterAdapterConnection ) )
                        {
                            throw new AdapterException( "Unable to locate a MasterConnectionAdapter for this adapter: " +
                                details.getMaster( ).getName( ) );
                        }

                        MasterAdapterConnection masterConnection = ( MasterAdapterConnection )foundConnection;
                        connection = new SlaveAdapterConnection( masterConnection, new InstalledAdapter( adapter, details ) );
                    }
                                                   
                    adapter.initialize( connection, details.getProperties( ) );
                    adapters.put( details.getId( ), connection );
                    log.info( "Adapter [" + details.getName( ) + "], has successfully been loaded and initialized." );
                }
                catch( Throwable x )
                {
                    log.warning( "Unable to Load Adapter [" + details.getName( ) + "], reason: " + x.getMessage( )  );
                    log.warning( GeneralUtilities.convertStackTraceToString( x ) );
                }

                return true;
            }
        };

        log.info( "Installing Master Adapters ..." );
        HibernateUtility.execute( "from AdapterDetails order where master_id = null", uow );

        log.info( "Installing Slave Adapters ..." );
        HibernateUtility.execute( "from AdapterDetails order where master_id <> null", uow );
    }
}
