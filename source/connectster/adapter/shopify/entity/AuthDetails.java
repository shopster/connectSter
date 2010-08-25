package connectster.adapter.shopify.entity;

import org.scribe.oauth.Scribe;
import org.scribe.oauth.Token;

public class AuthDetails
{
    private String store;
    private String t;
    private String signature;
    private long timestamp;
    private Token requestToken;
    private Scribe scribe;
    private String shopifyUri;
    private long requestTimestamp;

    public String getStore()
    {
        return store;
    }

    public void setStore( String store )
    {
        this.store = store;
    }

    public String getT()
    {
        return t;
    }

    public void setT( String t )
    {
        this.t = t;
    }

    public String getSignature()
    {
        return signature;
    }

    public void setSignature( String signature )
    {
        this.signature = signature;
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp( long timestamp )
    {
        this.timestamp = timestamp;
    }

    public Token getRequestToken()
    {
        return requestToken;
    }

    public void setRequestToken( Token requestToken )
    {
        this.requestToken = requestToken;
    }

    public Scribe getScribe()
    {
        return scribe;
    }

    public void setScribe( Scribe scribe )
    {
        this.scribe = scribe;
    }

    public String getShopifyUri()
    {
        return shopifyUri;
    }

    public void setShopifyUri( String shopifyUri )
    {
        this.shopifyUri = shopifyUri;
    }

    public long getRequestTimestamp()
    {
        return requestTimestamp;
    }

    public void setRequestTimestamp( long requestTimestamp )
    {
        this.requestTimestamp = requestTimestamp;
    }
}
