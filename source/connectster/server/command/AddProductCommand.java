package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IProduct;
import connectster.server.EntityHelper;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.AdapterDetails;
import connectster.server.entity.Product;
import org.hibernate.Session;

import java.util.Map;

public class AddProductCommand
implements ICommand<IProduct>
{
    @Override
    public IResponse<IProduct> execute( Session session, Map<String, Object> parameters )
    {
        IResponse<IProduct> response;
        IProduct product = ( IProduct )parameters.get( ICommand.PARAMETER_PRODUCT );
        AdapterDetails adapterDetails = ( AdapterDetails )parameters.get( ICommand.PARAMETER_ADAPTER_DETAILS );

        try
        {
            Product trustedProduct = new Product( );
            trustedProduct.setName( product.getName( ) );
            trustedProduct.setSourceId( product.getSourceId( ) );
            trustedProduct.setAdapterDetails( adapterDetails );
            trustedProduct.setOwner( EntityHelper.getUserForProduct( session, product ) );
            trustedProduct.setVendor( product.getVendor( ) );
            trustedProduct.setType( product.getType( ) );
            trustedProduct.setCurrency( product.getCurrency( ) );
            trustedProduct.setGrams( product.getGrams( ) );
            trustedProduct.setPrice( product.getPrice( ) );
            trustedProduct.setQuantity( product.getQuantity( ) );
            trustedProduct.setSku( product.getSku( ) );
            session.save( trustedProduct );
            session.flush( );

            response = new Response<IProduct>( trustedProduct, IResponse.Status.Successful, "Added Product: " + trustedProduct );
        }
        catch( Exception x )
        {
            response = new Response<IProduct>( product, IResponse.Status.Failure, "Unable to Add Product: " + product +
                ", Reason: " + x.getMessage( ) );
        }

        return response;
    }
}
