package connectster.api;

import connectster.api.entity.*;
import connectster.api.entity.implementation.AdapterDataDTO;
import connectster.server.AdapterConnection;

import java.util.List;
import java.util.Set;

/**
 * Copyright 2010 Shopster E-Commerce Inc.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public interface IMasterProxy
{
    public IResponse<IProductMapping> proxyGetProductMappingBySourceId( AdapterConnection slaveAdapter, String sourceId );
    public IResponse<IProduct> proxyGetProductBySource( AdapterConnection slaveAdapter, long ownerId, String sourceProductId );
    public IResponse<IProductMapping> proxyGetProductMapping( AdapterConnection slaveAdapter, long adapterId, long productId );
    public IResponse<List<IUser>> proxyGetAdapterUsers( AdapterConnection slaveAdapter );
    public IResponse<IProduct> proxyAddProduct( AdapterConnection slaveAdapter, IProduct product );
    public IResponse<IProduct> proxyUpdateProduct( AdapterConnection slaveAdapter, long productId, IProduct product );
    public IResponse<IProductMapping> proxyMapProduct( AdapterConnection slaveAdapter, IProductMapping mapping );
    public IResponse<Long> proxyRemoveProduct( AdapterConnection slaveAdapter, long productId );
    public IResponse<IProductMapping> proxyUnmapProduct( AdapterConnection slaveAdapter, IProductMapping mapping );
    public IResponse<IAdapterData> proxyStoreData( AdapterConnection slaveAdapter, IAdapterData data );
    public IResponse<IAdapterData> proxyRemoveData( AdapterConnection slaveAdapter, String category, String name );
    public IResponse<IAdapterData> proxyLoadData( AdapterConnection slaveAdapter, String category, String name );
    public IResponse<IUser> proxyGetMappedUser( AdapterConnection slaveAdapter, String sourceId );
    public IResponse<IUserMapping> proxyMapUser( AdapterConnection slaveAdapter, long userId, String sourceId );
    public IResponse<IOrder> proxyAddOrder( AdapterConnection slaveAdapter, IOrder order );
    public IResponse<Set<IOrderMapping>> proxyBuildOrderMappings( AdapterConnection slaveAdapter, long userId, IOrder order );
    public IResponse<IUser> proxyGetUser( AdapterConnection slaveAdapter, long userId );
    public IResponse<IUser> proxyRegister( AdapterConnection slaveAdapter, String sourceId, String connectsterId,
        AdapterDataDTO data, List<IUserProperty> userProperties );
}
