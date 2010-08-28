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
public class UserMappingKey
implements Serializable
{
    private long userId;
    private String sourceUserId;

    public long getUserId()
    {
        return userId;
    }

    public void setUserId( long userId )
    {
        this.userId = userId;
    }

    public String getSourceUserId()
    {
        return sourceUserId;
    }

    public void setSourceUserId( String sourceUserId )
    {
        this.sourceUserId = sourceUserId;
    }

    public boolean equals( Object rhs )
    {
        if( rhs == null || !( rhs instanceof UserMappingKey ) )
        {
            return false;
        }

        UserMappingKey rhsUserKey = ( UserMappingKey )rhs;
        return rhsUserKey.getSourceUserId( ).equals( sourceUserId ) && rhsUserKey.getUserId( ) == userId;
    }

    public int hashCode( )
    {
        return ( int )userId;
    }
}
