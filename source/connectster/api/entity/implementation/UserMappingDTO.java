package connectster.api.entity.implementation;

import connectster.api.entity.IUserMapping;

public class UserMappingDTO
implements IUserMapping
{
    private long adapterId;
    private long userId;
    private String sourceUserId;

    public UserMappingDTO( long userId, long adapterId, String sourceUserId )
    {
        this.adapterId = adapterId;
        this.userId = userId;
        this.sourceUserId = sourceUserId;
    }

    @Override
    public String getTargetUserId()
    {
        return sourceUserId;
    }

    @Override
    public long getTargetAdapterId()
    {
        return adapterId;
    }

    public long getUserId( )
    {
        return userId;
    }
}
