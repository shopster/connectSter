package connectster.server;

import connectster.api.IMasterProxy;
import connectster.api.IResponse;
import connectster.api.entity.*;
import connectster.api.entity.implementation.AdapterDataDTO;

import java.util.List;
import java.util.Set;

public class SlaveAdapterConnection
extends AdapterConnection
{
    private IMasterProxy master;
    private long adapterId;

    public SlaveAdapterConnection( IMasterProxy master, InstalledAdapter adapter )
    {
        super( adapter );
        this.master = master;
        this.adapterId = adapter.getDetails().getId();
    }

    @Override
    public long getAdapterId()
    {
        return adapterId;
    }

    @Override
    public IResponse<IProductMapping> getProductMappingBySourceId( String sourceId )
    {
        return master.proxyGetProductMappingBySourceId( this, sourceId );
    }

    @Override
    public IResponse<IProduct> getProductBySource( long ownerId, String sourceProductId )
    {
        return master.proxyGetProductBySource( this, ownerId, sourceProductId );
    }

    @Override
    public IResponse<IProductMapping> getProductMapping( long sourceAdapterId, long productId, String targetUserId )
    {
        return master.proxyGetProductMapping( this, sourceAdapterId, productId, targetUserId );
    }

    @Override
    public IResponse<List<IUser>> getAdapterUsers( )
    {
        return master.proxyGetAdapterUsers( this );
    }

    @Override
    public IResponse<IProduct> addProduct( IProduct product )
    {
        return master.proxyAddProduct( this, product );
    }

    @Override
    public IResponse<IProduct> updateProduct( long productId, IProduct product )
    {
        return master.proxyUpdateProduct( this, productId, product );
    }

    @Override
    public IResponse<Long> removeProduct( long productId )
    {
        return master.proxyRemoveProduct( this, productId );
    }

    @Override
    public IResponse<IProductMapping> mapProduct( IProductMapping mapping )
    {
        return master.proxyMapProduct( this, mapping );
    }

    @Override
    public IResponse<IProductMapping> unmapProduct( IProductMapping mapping )
    {
        return master.proxyUnmapProduct( this, mapping );
    }

    @Override
    public IResponse<IAdapterData> storeData( IAdapterData data )
    {
        return master.proxyStoreData( this, data );
    }

    @Override
    public IResponse<IAdapterData> removeData( String category, String name )
    {
        return master.proxyRemoveData( this, category, name );
    }

    @Override
    public IResponse<IAdapterData> loadData( String category, String name )
    {
        return master.proxyLoadData( this, category, name );
    }

    @Override
    public IResponse<IUser> getUserMapping( String sourceId )
    {
        return master.proxyGetMappedUser( this, sourceId );
    }

    @Override
    public IResponse<IUserMapping> mapUser( long userId, String sourceId )
    {
        return master.proxyMapUser( this, userId, sourceId );
    }

    @Override
    public IResponse<IUser> getUser( long userId )
    {
        return master.proxyGetUser( this, userId );
    }

    @Override
    public IResponse<IOrder> addOrder( IOrder order )
    {
        return master.proxyAddOrder( this, order );
    }

    @Override
    public IResponse<Set<IOrderMapping>> buildOrderMappings( long userId, IOrder order )
    {
        return master.proxyBuildOrderMappings( this, userId, order );
    }

    @Override
    public IResponse<IUser> register( long sourceAdapterId, String sourceId, String connectsterId, AdapterDataDTO data,
        List<IUserProperty> userProperties )
    {
        return master.proxyRegister( this, sourceId, connectsterId, data, userProperties );
    }
}
