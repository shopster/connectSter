package connectster.server;

import connectster.api.IMasterProxy;
import connectster.api.IResponse;
import connectster.api.entity.*;
import connectster.api.entity.implementation.AdapterDataDTO;
import connectster.server.command.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MasterAdapterConnection
extends AdapterConnection
implements IMasterProxy
{
    private IAdapterDetails adapter;

    public MasterAdapterConnection( InstalledAdapter adapter )
    {
        super( adapter );
        this.adapter = adapter.getDetails( );
    }

    @Override
    public long getAdapterId()
    {
        return adapter.getId( );
    }

    @Override
    public Map<String, IAdapterProperty> getMasterProperties()
    {
        return new HashMap<String,IAdapterProperty>( );
    }

    @Override
    public IResponse<IProductMapping> getProductMappingBySourceId( String sourceId )
    {
        return EntityHelper.execute( new GetProductMappingBySourceIdCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_SOURCE_ID,
            sourceId, ICommand.PARAMETER_ADAPTER_ID, getAdapterId( ) ) );
    }

    @Override
    public Map<String, IAdapterProperty> getProperties()
    {
        return adapter.getProperties( );
    }

    @Override
    public IResponse<IProductMapping> proxyGetProductMappingBySourceId( AdapterConnection slaveAdapter, String sourceId )
    {
        return EntityHelper.execute( new GetProductMappingBySourceIdCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_SOURCE_ID,
            sourceId, ICommand.PARAMETER_ADAPTER_ID, slaveAdapter.getInstalledAdapter( ).getDetails( ).getId( ) ) );
    }

    @Override
    public IResponse<IProduct> proxyGetProductBySource( AdapterConnection slaveAdapter, long ownerId, String sourceProductId )
    {
        return EntityHelper.execute( new GetProductBySourceCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_ID,
            slaveAdapter.getInstalledAdapter( ).getDetails( ).getId( ), ICommand.PARAMETER_PRODUCT_SOURCE_ID, sourceProductId,
            ICommand.PARAMETER_OWNER_ID, ownerId ) );
    }

    @Override
    public IResponse<IProductMapping> proxyGetProductMapping( AdapterConnection slaveAdapter, long adapterId, long productId, String targetUserId )
    {
        return EntityHelper.execute( new GetMappedProductCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_ID,
            adapterId, ICommand.PARAMETER_PRODUCT_ID, productId, ICommand.PARAMETER_TARGET_USER_ID, targetUserId ) );
    }

    @Override
    public IResponse<List<IUser>> proxyGetAdapterUsers( AdapterConnection slaveAdapter )
    {
        return EntityHelper.execute( new GetAdapterUsersCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_ID,
            slaveAdapter.getInstalledAdapter( ).getDetails( ).getId( ) ) );
    }

    public IResponse<IProduct> proxyAddProduct( AdapterConnection slaveAdapter, IProduct product )
    {
        return EntityHelper.execute( new AddProductCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_DETAILS,
            slaveAdapter.getInstalledAdapter( ).getDetails( ), ICommand.PARAMETER_PRODUCT, product ) );
    }

    @Override
    public IResponse<IProduct> proxyUpdateProduct( AdapterConnection slaveAdapter, long productId, IProduct product )
    {
        return EntityHelper.execute( new UpdateProductCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_DETAILS,
            slaveAdapter.getInstalledAdapter( ).getDetails( ), ICommand.PARAMETER_PRODUCT_ID, productId, ICommand.PARAMETER_PRODUCT, product ) );
    }

    @Override
    public IResponse<IProductMapping> proxyMapProduct( AdapterConnection slaveAdapter, IProductMapping mapping )
    {
        return EntityHelper.execute( new MapProductCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_PRODUCT_MAPPING, mapping ) );
    }

    @Override
    public IResponse<Long> proxyRemoveProduct( AdapterConnection slaveAdapter, long productId )
    {
        return EntityHelper.execute( new RemoveProductCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_PRODUCT_ID, productId ) );
    }

    @Override
    public IResponse<IProductMapping> proxyUnmapProduct( AdapterConnection slaveAdapter, IProductMapping mapping )
    {
        return EntityHelper.execute( new UnmapProductCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_PRODUCT_MAPPING, mapping ) );
    }

    @Override
    public IResponse<IAdapterData> proxyStoreData( AdapterConnection slaveAdapter, IAdapterData data )
    {
        return EntityHelper.execute( new StoreDataCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_ID,
            slaveAdapter.getInstalledAdapter( ).getDetails( ).getId( ), ICommand.PARAMETER_ADAPTER_DATA, data ) );
    }

    @Override
    public IResponse<IAdapterData> proxyLoadData( AdapterConnection slaveAdapter, String category, String name )
    {
        return EntityHelper.execute( new LoadDataCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_ID,
            slaveAdapter.getInstalledAdapter( ).getDetails( ).getId( ), ICommand.PARAMETER_CATEGORY, category, ICommand.PARAMETER_NAME, name ) );
    }

    @Override
    public IResponse<IUser> proxyGetMappedUser( AdapterConnection slaveAdapter, String sourceId )
    {
        return EntityHelper.execute( new GetMappedUserCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_ID,
            slaveAdapter.getInstalledAdapter( ).getDetails( ).getId( ), ICommand.PARAMETER_SOURCE_ID, sourceId ) );
    }

    @Override
    public IResponse<IUserMapping> proxyMapUser( AdapterConnection slaveAdapter, long userId, String sourceId )
    {
        return EntityHelper.execute( new MapUserCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_ID,
            slaveAdapter.getInstalledAdapter( ).getDetails( ).getId( ), ICommand.PARAMETER_USER_ID, userId, ICommand.PARAMETER_SOURCE_ID, sourceId ) );
    }

    @Override
    public IResponse<IOrder> proxyAddOrder( AdapterConnection slaveAdapter, IOrder order )
    {
        return EntityHelper.execute( new AddOrderCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_ORDER, order ) );
    }

    @Override
    public IResponse<Set<IOrderMapping>> proxyBuildOrderMappings( AdapterConnection slaveAdapter, long userId, IOrder order )
    {
        return EntityHelper.execute( new BuildOrderMappingsCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_USER_ID,
            userId, ICommand.PARAMETER_ORDER, order ) );
    }

    @Override
    public IResponse<IUser> proxyGetUser( AdapterConnection slaveAdapter, long userId )
    {
        return EntityHelper.execute( new GetUserByIdCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_USER_ID, userId ) );
    }

    @Override
    public IResponse<IUser> proxyRegister( AdapterConnection slaveAdapter, String sourceId, String connectsterId,
        AdapterDataDTO data, List<IUserProperty> userProperties )
    {
        return EntityHelper.execute( new RegisterUserCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_SOURCE_ADAPTER_ID,
            slaveAdapter.getInstalledAdapter( ).getDetails( ).getId( ), ICommand.PARAMETER_SOURCE_ID, sourceId,
            ICommand.PARAMETER_ADAPTER_ID, adapter.getId( ), ICommand.PARAMETER_MASTER_ID, connectsterId, ICommand.PARAMETER_ADAPTER_DATA,
            data, ICommand.PARAMETER_USER_PROPERTIES, userProperties ) );
    }

    @Override
    public IResponse<IAdapterData> proxyRemoveData( AdapterConnection slaveAdapter, String category, String name )
    {
        return EntityHelper.execute( new RemoveDataCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_ID,
            slaveAdapter.getInstalledAdapter().getDetails( ).getId( ), ICommand.PARAMETER_CATEGORY, category,
            ICommand.PARAMETER_NAME, name ) );
    }

    @Override
    public IResponse<IProduct> getProductBySource( long ownerId, String sourceProductId )
    {
        return EntityHelper.execute( new GetProductBySourceCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_ID,
            adapter.getId( ), ICommand.PARAMETER_PRODUCT_SOURCE_ID, sourceProductId, ICommand.PARAMETER_OWNER_ID, ownerId ) );
    }

    @Override
    public IResponse<IProductMapping> getProductMapping( long adapterId, long productId, String targetUserId )
    {
        return EntityHelper.execute( new GetMappedProductCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_ID,
            adapterId, ICommand.PARAMETER_PRODUCT_ID, productId, ICommand.PARAMETER_TARGET_USER_ID, targetUserId ) );
    }

    @Override
    public IResponse<IProduct> addProduct( IProduct product )
    {
        return EntityHelper.execute( new AddProductCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_DETAILS,
            getInstalledAdapter( ).getDetails( ), ICommand.PARAMETER_PRODUCT, product ) );
    }

    @Override
    public IResponse<IProduct> updateProduct( long productId, IProduct product )
    {
        return EntityHelper.execute( new UpdateProductCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_DETAILS,
            getInstalledAdapter( ).getDetails( ), ICommand.PARAMETER_PRODUCT_ID, productId, ICommand.PARAMETER_PRODUCT, product ) );
    }

    @Override
    public IResponse<Long> removeProduct( long productId )
    {
        return EntityHelper.execute( new RemoveProductCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_PRODUCT_ID, productId ) );
    }

    @Override
    public IResponse<IProductMapping> mapProduct( IProductMapping mapping )
    {
        return EntityHelper.execute( new MapProductCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_PRODUCT_MAPPING, mapping ) );
    }

    @Override
    public IResponse<IProductMapping> unmapProduct( IProductMapping mapping )
    {
        return EntityHelper.execute( new UnmapProductCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_PRODUCT_MAPPING, mapping ) );
    }

    @Override
    public IResponse<IAdapterData> storeData( IAdapterData data )
    {
        return EntityHelper.execute( new StoreDataCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_ID,
            adapter.getId( ), ICommand.PARAMETER_ADAPTER_DATA, data ) );
    }

    @Override
    public IResponse<IAdapterData> removeData( String category, String name )
    {
        return EntityHelper.execute( new RemoveDataCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_ID,
            adapter.getId( ), ICommand.PARAMETER_CATEGORY, category, ICommand.PARAMETER_NAME, name ) );
    }

    @Override
    public IResponse<IAdapterData> loadData( String category, String name )
    {
        return EntityHelper.execute( new LoadDataCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_ID,
            adapter.getId( ), ICommand.PARAMETER_CATEGORY, category, ICommand.PARAMETER_NAME, name ) );
    }

    @Override
    public IResponse<IUser> getUserMapping( String sourceId )
    {
        return EntityHelper.execute( new GetMappedUserCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_ID,
            adapter.getId( ), ICommand.PARAMETER_SOURCE_ID, sourceId ) );
    }

    @Override
    public IResponse<IUserMapping> mapUser( long userId, String sourceId )
    {
        return EntityHelper.execute( new MapUserCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_ID,
            adapter.getId( ), ICommand.PARAMETER_USER_ID, userId, ICommand.PARAMETER_SOURCE_ID, sourceId ) );
    }

    @Override
    public IResponse<IUser> getUser( long userId )
    {
        return EntityHelper.execute( new GetUserByIdCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_USER_ID, userId ) );
    }

    @Override
    public IResponse<IOrder> addOrder( IOrder order )
    {
        return EntityHelper.execute( new AddOrderCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_ORDER, order ) );
    }

    @Override
    public IResponse<Set<IOrderMapping>> buildOrderMappings( long userId, IOrder order )
    {
        return EntityHelper.execute( new BuildOrderMappingsCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_USER_ID,
            userId, ICommand.PARAMETER_ORDER, order ) );
    }

    @Override
    public IResponse<List<IUser>> getAdapterUsers()
    {
        return EntityHelper.execute( new GetAdapterUsersCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_ADAPTER_ID,
            adapter.getId( ) ) );
    }

    @Override
    public IResponse<IUser> register( long sourceAdapterId, String sourceId, String masterId, AdapterDataDTO data,
        List<IUserProperty> userProperties )
    {
        return EntityHelper.execute( new RegisterUserCommand( ), EntityHelper.listToMap( ICommand.PARAMETER_SOURCE_ADAPTER_ID,
            sourceAdapterId, ICommand.PARAMETER_SOURCE_ID, sourceId, ICommand.PARAMETER_ADAPTER_ID, adapter.getId( ),
            ICommand.PARAMETER_MASTER_ID, masterId, ICommand.PARAMETER_ADAPTER_DATA, data, ICommand.PARAMETER_USER_PROPERTIES,
            userProperties ) );    
    }
}
