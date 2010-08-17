package com.shopify.exception;

public class ShopifyRestException
extends Exception
{
    public ShopifyRestException( String message )
    {
        super( message );
    }

    public ShopifyRestException( Throwable cause )
    {
        super( cause );
    }

    public ShopifyRestException( String message, Throwable cause )
    {
        super( message, cause );
    }
}
