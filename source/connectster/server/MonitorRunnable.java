package connectster.server;

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
public abstract class MonitorRunnable
implements Runnable
{
    private boolean alive;
    private int interval;

    public MonitorRunnable( int interval )
    {
        alive = true;
        this.interval = interval;
    }

    @Override
    public final void run( )
    {
        while( alive )
        {
            try
            {
                Thread.sleep( interval );
                execute( );
            }
            catch( Exception x )
            {
                x.printStackTrace( );
            }
        }
    }

    public final void stop( )
    {
        alive = false;
    }

    public abstract void execute( );
}
