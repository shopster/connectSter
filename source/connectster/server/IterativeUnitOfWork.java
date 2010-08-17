package connectster.server;

import java.util.logging.Logger;

public abstract class IterativeUnitOfWork<E>
{
    private static Logger log = Logger.getLogger( IterativeUnitOfWork.class.getName( ) );

    /**
     * This is a callback method which allows for consuming each event as it is iterated over.
     * @param row The current row
     * @return true if we should continue processing rows, else false to stop.
     */
    public abstract boolean next( E row );

    /**
     * Override this to customize how errors are handled, default behaviour is to log warnings and proceed.
     * @param cause Throwable that caused this method to be invoked
     */
    public void onError( Throwable cause )
    {
        log.warning( "IterativeUnitOfWork Query Failure: " + cause.getMessage( ) );
    }
}
