package connectster.adapter.shopify.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShopifyProductGroup
implements Serializable
{
    private List<ShopifyProduct> products;

    public ShopifyProductGroup( )
    {
        products = new ArrayList<ShopifyProduct>( );
    }

    public List<ShopifyProduct> getProducts()
    {
        return products;
    }

    public void setProducts( List<ShopifyProduct> products )
    {
        this.products = products;
    }
}
