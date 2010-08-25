package connectster.server.entity;

import connectster.api.entity.IUserProperty;

import javax.persistence.*;

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

@Entity
@IdClass(UserPropertyKey.class)
@Table(uniqueConstraints = { @UniqueConstraint( columnNames={ "userId", "name" } ) } )
public class UserProperty
implements IUserProperty
{
    public UserProperty( ) { }
    public UserProperty( long userId, String name, String value )
    {
        this.userId = userId;
        this.name = name;
        this.value = value;
    }

    @Id
    @AttributeOverrides({
        @AttributeOverride(name = "userId", column = @Column(name="userId")),
        @AttributeOverride(name = "name", column = @Column(name="name"))
    })

    private long userId;
    private String name;
    private String value;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="userId", nullable=false)
    public long getUserId()
    {
        return userId;
    }

    public UserProperty setUserId( long userId )
    {
        this.userId = userId;
        return this;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue( String value )
    {
        this.value = value;
    }

    public String toString( )
    {
        return name + "=" + value;
    }
}
