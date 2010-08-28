package connectster.server.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/** Copyright 2010 Shopster E-Commerce Inc.

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
 */
@Embeddable
public class ProductMappingKey
implements Serializable
{
    private long productId;
    private long destinationAdapterId;
    private String destinationId;
    private String destinationUserId;

    public long getProductId()
    {
        return productId;
    }

    public void setProductId( long productId )
    {
        this.productId = productId;
    }

    public long getAdapter()
    {
        return destinationAdapterId;
    }

    public void setAdapter( long adapterId )
    {
        this.destinationAdapterId = adapterId;
    }

    public String getDestinationId()
    {
        return destinationId;
    }

    public void setDestinationId( String destinationId )
    {
        this.destinationId = destinationId;
    }

    public boolean equals( Object rhs )
    {
        if( rhs == null || !( rhs instanceof ProductMappingKey ) )
        {
            return false;
        }

        ProductMappingKey rhsKey = ( ProductMappingKey )rhs;
        return rhsKey.getAdapter( ) == destinationAdapterId && rhsKey.getDestinationId().equals( destinationId )
            && rhsKey.getProductId( ) == productId;
    }

    public int hashCode( )
    {
        return ( int )productId;
    }

    public String getDestinationUserId()
    {
        return destinationUserId;
    }

    public void setDestinationUserId( String destinationUserId )
    {
        this.destinationUserId = destinationUserId;
    }
}
