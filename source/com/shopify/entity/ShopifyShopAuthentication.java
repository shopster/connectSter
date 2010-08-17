package com.shopify.entity;

import java.io.Serializable;

public class ShopifyShopAuthentication
implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String uid;
    private String shop, signature, token;
    private long timestamp;

    public ShopifyShopAuthentication( String uid, String shop, String signature, String token, long timestamp )
    {
        this.shop = shop;
        this.signature = signature;
        this.token = token;
        this.timestamp = timestamp;
        this.uid = uid;
    }

    public String getShop()
    {
        return shop;
    }

    public void setShop( String shop )
    {
        this.shop = shop;
    }

    public String getSignature()
    {
        return signature;
    }

    public void setSignature( String signature )
    {
        this.signature = signature;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken( String token )
    {
        this.token = token;
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp( long timestamp )
    {
        this.timestamp = timestamp;
    }

    public String getUid()
    {
        return uid;
    }

    public void setUid( String uid )
    {
        this.uid = uid;
    }
}
