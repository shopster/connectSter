package connectster.api.entity.implementation;

import connectster.api.entity.IAdapterData;

public class AdapterDataDTO<E>
implements IAdapterData
{
    private String category, name;
    private E value;

    public AdapterDataDTO( String category, String name, E value )
    {
        this.name = name;
        this.category = category;
        this.value = value;
    }

    @Override
    public String getCategory()
    {
        return category;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public E getValue()
    {
        return value;
    }
}
