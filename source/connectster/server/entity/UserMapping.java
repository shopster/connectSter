package connectster.server.entity;

import connectster.api.entity.IUserMapping;

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
@IdClass( UserMappingKey.class )
@Table( uniqueConstraints = { @UniqueConstraint( columnNames={ "sourceUserId", "userId" } ) } )
public class UserMapping
implements IUserMapping
{
    public UserMapping( ) { }
    public UserMapping( long userId, long adapterId, String sourceUserId )
    {
        this.userId = userId;
        this.sourceUserId = sourceUserId;
        this.adapterId = adapterId;
    }

    @Id
    @AttributeOverrides({
        @AttributeOverride(name = "userId", column = @Column(name="userId")),
        @AttributeOverride(name = "sourceUserId", column = @Column(name="sourceUserId"))
    })

    private long userId;
    private String sourceUserId;
    private long adapterId;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="userId", nullable=false)    
    public long getUserId()
    {
        return userId;
    }

    public UserMapping setUserId( long userId )
    {
        this.userId = userId;
        return this;
    }

    public long getAdapterId()
    {
        return adapterId;
    }

    public UserMapping setAdapterId( long adapter )
    {
        this.adapterId = adapter;
        return this;
    }

    public String getSourceUserId()
    {
        return sourceUserId;
    }

    public UserMapping setSourceUserId( String sourceUserId )
    {
        this.sourceUserId = sourceUserId;
        return this;
    }

    @Transient
    @Override
    public String getTargetUserId()
    {
        return sourceUserId;
    }

    @Transient
    @Override
    public long getTargetAdapterId()
    {
        return adapterId;
    }
}
