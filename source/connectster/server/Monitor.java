package connectster.server;

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
public class Monitor
{
    private static Logger log = Logger.getLogger( Monitor.class.getName( ) );

    private MonitorRunnable monitor;

    public Monitor( MonitorRunnable monitor )
    {
        this.monitor = monitor;
    }

    public void start( )
    {
        log.info( getClass( ).getName( ) + " monitor starting up.");
        new Thread( monitor ).start( );
    }

    public void stop( )
    {
        log.info( getClass( ).getName( ) + " monitor shutting down.");
        monitor.stop( );
    }
}
