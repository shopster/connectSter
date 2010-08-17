package connectster.server;

import connectster.api.IResponse;

public class Response<E>
implements IResponse<E>
{
    private E source;
    private Status status;
    private String message;

    public Response( E source, IResponse.Status status )
    {
        this( source, status, "" );
    }

    public Response( E source, IResponse.Status status, String message )
    {
        this.source = source;
        this.status = status;
        this.message = message;
    }

    @Override
    public E getSource()
    {
        return source;
    }

    @Override
    public Status getStatus()
    {
        return status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage( String message )
    {
        this.message = message;
    }
}
