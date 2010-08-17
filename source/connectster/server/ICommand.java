package connectster.server;

import connectster.api.IResponse;
import org.hibernate.Session;

import java.util.Map;

public interface ICommand<E>
{
    public static final Map<String,Object> NO_PARAMETERS = null;

    public static final String PARAMETER_PRODUCT_SOURCE_ID = "productSourceId";
    public static final String PARAMETER_OWNER_ID = "ownerId";
    public static final String PARAMETER_ADAPTER_ID = "adapterId";
    public static final String PARAMETER_SOURCE_ADAPTER_ID = "sourceAdapterId";
    public static final String PARAMETER_ADAPTER_DETAILS = "adapterDetails";
    public static final String PARAMETER_ADAPTER_DATA = "adapterData";
    public static final String PARAMETER_CATEGORY = "userId";
    public static final String PARAMETER_PROPERTY = "property";
    public static final String PARAMETER_NAME = "name";
    public static final String PARAMETER_ORDER = "order";
    public static final String PARAMETER_ORDER_ID = "orderId";
    public static final String PARAMETER_ORDER_MAPPING = "orderMapping";
    public static final String PARAMETER_PRODUCT = "product";
    public static final String PARAMETER_PRODUCT_ID = "productId";
    public static final String PARAMETER_PRODUCT_MAPPING = "productMapping";
    public static final String PARAMETER_SOURCE_ID = "sourceId";
    public static final String PARAMETER_TARGET_PRODUCT_ID = "targetProductId";
    public static final String PARAMETER_USER_ID = "userId";
    public static final String PARAMETER_USER_PROPERTIES = "userProperties";
    public static final String PARAMETER_MASTER_ID = "masterId";

    public IResponse<E> execute( Session session, Map<String,Object> parameters );
}
