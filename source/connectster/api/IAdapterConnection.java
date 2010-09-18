package connectster.api;

import connectster.api.entity.*;
import connectster.api.entity.implementation.AdapterDataDTO;

import java.util.List;
import java.util.Map;
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

/**
 * The IAdapterConnection provides an interface to deal with crud at a local level.  Here you are no typically
 * communicating remotely (except register) and instead are interacting with the connectster hub.  Most internal
 * adapter calls rely on a connection for propagating changes, etc... while external calls are executed at the
 * adapter level itself instead of the connection.
 */
public interface IAdapterConnection
{
    public long getAdapterId( );
    public Map<String,IAdapterProperty> getMasterProperties( );
    public IResponse<IProductMapping> getProductMappingBySourceId( String sourceId );
    public IResponse<IProduct> getProductBySource( long ownerId, String sourceProductId );
    public IResponse<IProductMapping> getProductMapping( long sourceAdapterId, long productId, String targetUserId );
    public IResponse<List<IUser>> getAdapterUsers( );
    public IResponse<IProduct> addProduct( IProduct product );
    public IResponse<IProduct> updateProduct( long productId, IProduct product );
    public IResponse<Long> removeProduct( long productId );
    public IResponse<IProductMapping> mapProduct( IProductMapping mapping );
    public IResponse<IProductMapping> unmapProduct( IProductMapping mapping );
    public IResponse<IAdapterData> storeData( IAdapterData data );
    public IResponse<IAdapterData> removeData( String category, String name );
    public IResponse<IAdapterData> loadData( String category, String name );
    public IResponse<IUser> getUserMapping( String sourceId );
    public IResponse<IUserMapping> mapUser( long userId, String sourceId );
    public IResponse<IUser> getUser( long userId );
    public IResponse<IOrder> addOrder( IOrder order );
    public IResponse<Set<IOrderMapping>> buildOrderMappings( long userId, IOrder order );
    public IResponse<IUser> register( long sourceAdapterId, String sourceId, String masterId, AdapterDataDTO data,
        List<IUserProperty> userProperties );
}
