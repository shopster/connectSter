package connectster.server;

import connectster.api.IAdapterConnection;

public abstract class AdapterConnection
implements IAdapterConnection
{
    private InstalledAdapter installedAdapter;

    AdapterConnection( InstalledAdapter adapter )
    {
        this.installedAdapter = adapter;
    }

    public InstalledAdapter getInstalledAdapter( )
    {
        return installedAdapter;
    }
}
