package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IProduct;
import connectster.server.EntityHelper;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.AdapterDetails;
import connectster.server.entity.Product;
import connectster.server.exceptions.ConnectsterException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Map;

public class UpdateProductCommand
implements ICommand<IProduct>
{
    @Override
    public IResponse<IProduct> execute( Session session, Map<String, Object> parameters )
    {
        IResponse<IProduct> response;
        long productId = ( Long )parameters.get( ICommand.PARAMETER_PRODUCT_ID );
        IProduct product = ( IProduct )parameters.get( ICommand.PARAMETER_PRODUCT );
        AdapterDetails adapterDetails = ( AdapterDetails )parameters.get( ICommand.PARAMETER_ADAPTER_DETAILS );

        try
        {
            // fetch the product by id
            Criteria productCriteria = session.createCriteria( Product.class );
            productCriteria.add( Restrictions.eq( "id", productId ) );
            Product trustedProduct = ( Product )productCriteria.uniqueResult( );
            if( trustedProduct == null )
            {
                throw new ConnectsterException( "Unable to find product to update: " + product );
            }

            // now using the provided product, update this product accordingly
            AdapterDetails newAdapterDetails = ( adapterDetails.getId( ) == product.getSourceAdapterId( ) )
                ? adapterDetails : EntityHelper.getAdapterDetailsById( session, product.getSourceAdapterId( ) );
            trustedProduct.setAdapterDetails( newAdapterDetails );
            trustedProduct.setOwner( EntityHelper.getUserForProduct( session, product ) );
            trustedProduct.setName( product.getName( ) );
            trustedProduct.setSourceId( product.getSourceId( ) );
            trustedProduct.setLastUpdate( product.getLastUpdate( ) );
            trustedProduct.setCurrency( product.getCurrency( ) );
            trustedProduct.setGrams( product.getGrams( ) );
            trustedProduct.setPrice( product.getPrice( ) );
            trustedProduct.setQuantity( product.getQuantity( ) );
            trustedProduct.setSku( product.getSku( ) );
            trustedProduct.setType( product.getType( ) );
            trustedProduct.setVendor( product.getVendor( ) );

            session.update( trustedProduct );
            session.flush( );

            response = new Response<IProduct>( trustedProduct, IResponse.Status.Successful, "Updated Product: " + trustedProduct );
        }
        catch( Exception x )
        {
            response = new Response<IProduct>( product, IResponse.Status.Failure, "Unable to Update Product: " + product +
                ", Reason: " + x.getMessage( ) );
        }

        return response;
    }
}
