package connectster.api.entity.implementation;

import connectster.api.IAdapterConnection;
import connectster.api.IResponse;
import connectster.api.entity.IProduct;
import connectster.api.entity.IProductMapping;

import java.util.Date;

public abstract class TestableAdapter
{
    protected IAdapterConnection connection;
    
    public IResponse<IProduct> testAddProduct( String sourceUserId, String sourceId, String name )
    {
        return connection.addProduct( new ProductDTO( connection.getAdapterId( ), sourceUserId, sourceId, name ) );
    }

    public IResponse<IProduct> testUpdateProduct( long oldId, long newAId, String newSUId, String newSId, String newName )
    {
        IProduct product = new ProductDTO( newAId, newSUId, newSId, newName );
        return connection.updateProduct( oldId, product );
    }

    public IResponse<IProductMapping> testMapProduct( long targetAdapterId, long productId, String targetProductId )
    {
        return connection.mapProduct( new ProductMappingDTO( targetAdapterId, productId, targetProductId, new Date( ) ) );
    }

    public IResponse<Long> testRemoveProduct( long productId )
    {
        return connection.removeProduct( productId );
    }

    public IResponse<IProductMapping> testUnmapProduct( long targetAdapterId, long productId, String targetProductId )
    {
        return connection.unmapProduct( new ProductMappingDTO( targetAdapterId, productId, targetProductId, new Date( ) ) );
    }
}
