package connectster.api.exceptions;

public class AdapterException
extends Exception    
{
    public AdapterException( String message )
    {
        super( message );
    }

    public AdapterException( Throwable cause )
    {
        super( cause );
    }

    public AdapterException( String message, Throwable cause )
    {
        super( message, cause );
    }
}
