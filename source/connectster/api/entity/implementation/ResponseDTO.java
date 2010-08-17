package connectster.api.entity.implementation;

import connectster.api.IResponse;

public class ResponseDTO<E>
implements IResponse<E>
{
    private E source;
    private Status status;
    private String message;

    public ResponseDTO( E source, IResponse.Status status, String message )
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

    @Override
    public String getMessage()
    {
        return message;
    }
}
