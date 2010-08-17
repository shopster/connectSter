package connectster.api;

import connectster.api.entity.*;
import connectster.api.exceptions.AdapterException;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
 *
 * The IAdapter interface specifies how we talk to the remote service that this adapter represents.  If you want
 * to, for example, add a product to the remote service, then this is the place to look.  See the IAdapterConnection
 * interface for how to work within the connectster hub locally (with the exception of registering adapters).
 */
public interface IAdapter
{
    public void initialize( IAdapterConnection connection, Map<String,IAdapterProperty> properties ) throws AdapterException;
    public List<IProduct> remoteGetProducts( IUser user, Date lastUpdated ) throws AdapterException;
    public IResponse<IProductMapping> remoteAddProduct( IProduct product );
    public IResponse<IProduct> remoteUpdateProduct( IProduct product, IProductMapping mapping );
    public IResponse<String> remoteAddOrder( IOrder order );
    public void shutdown( );
}