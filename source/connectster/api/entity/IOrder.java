package connectster.api.entity;

import java.util.Date;
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
public interface IOrder
{
    public long getId( );
    public String getName();
    public String getSourceId();
    public long getSourceAdapterId( );
    public String getSourceUserId( );
    public Date getReceivedAt( );
    public Set<IOrderMapping> getMappings( );
    public IUser getOwner( );

    public String getBillingName( );
    public String getBillingStreet1( );
    public String getBillingStreet2( );
    public String getBillingCity( );
    public String getBillingRegion( );
    public String getBillingPostalCode( );
    public String getBillingCountry( );
    public String getShippingName( );
    public String getShippingStreet1( );
    public String getShippingStreet2( );
    public String getShippingCity( );
    public String getShippingRegion( );
    public String getShippingPostalCode( );
    public String getShippingCountry( );
    public String getShippingMethod( );
    public Set<IOrderItem> getItems( );
    
}
