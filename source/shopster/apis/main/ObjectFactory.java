
package shopster.apis.main;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the shopster.apis.main package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PlaceOrderResponseType_QNAME = new QName("urn:shopster:apis:main", "PlaceOrderResponseType");
    private final static QName _OrderType_QNAME = new QName("urn:shopster:apis:main", "OrderType");
    private final static QName _GetOrdersResponse_QNAME = new QName("urn:shopster:apis:main", "GetOrdersResponse");
    private final static QName _ItemIdListType_QNAME = new QName("urn:shopster:apis:main", "ItemIdListType");
    private final static QName _ItemImageType_QNAME = new QName("urn:shopster:apis:main", "ItemImageType");
    private final static QName _GetInventoryCategoriesResponse_QNAME = new QName("urn:shopster:apis:main", "GetInventoryCategoriesResponse");
    private final static QName _OrderItemType_QNAME = new QName("urn:shopster:apis:main", "OrderItemType");
    private final static QName _ErrorParametersCollectionType_QNAME = new QName("urn:shopster:apis:main", "ErrorParametersCollectionType");
    private final static QName _InventoryItemPricingType_QNAME = new QName("urn:shopster:apis:main", "InventoryItemPricingType");
    private final static QName _InventoryItemListType_QNAME = new QName("urn:shopster:apis:main", "InventoryItemListType");
    private final static QName _PlaceOrderRequestType_QNAME = new QName("urn:shopster:apis:main", "PlaceOrderRequestType");
    private final static QName _OrderTaxType_QNAME = new QName("urn:shopster:apis:main", "OrderTaxType");
    private final static QName _ResponseStatusType_QNAME = new QName("urn:shopster:apis:main", "ResponseStatusType");
    private final static QName _GetOrdersRequest_QNAME = new QName("urn:shopster:apis:main", "GetOrdersRequest");
    private final static QName _OrderListType_QNAME = new QName("urn:shopster:apis:main", "OrderListType");
    private final static QName _AmountType_QNAME = new QName("urn:shopster:apis:main", "AmountType");
    private final static QName _OrderDiscountListType_QNAME = new QName("urn:shopster:apis:main", "OrderDiscountListType");
    private final static QName _ErrorClassificationType_QNAME = new QName("urn:shopster:apis:main", "ErrorClassificationType");
    private final static QName _OrderCartItemListType_QNAME = new QName("urn:shopster:apis:main", "Items");
    private final static QName _VerifyPlaceOrderRequest_QNAME = new QName("urn:shopster:apis:main", "VerifyPlaceOrderRequest");
    private final static QName _OrderCartItemType_QNAME = new QName("urn:shopster:apis:main", "OrderCartItemType");
    private final static QName _GetUserInfoResponseType_QNAME = new QName("urn:shopster:apis:main", "GetUserInfoResponseType");
    private final static QName _InventoryCategoryListType_QNAME = new QName("urn:shopster:apis:main", "InventoryCategoryListType");
    private final static QName _VerifyPlaceOrderResponseType_QNAME = new QName("urn:shopster:apis:main", "VerifyPlaceOrderResponseType");
    private final static QName _PlaceOrderResponse_QNAME = new QName("urn:shopster:apis:main", "PlaceOrderResponse");
    private final static QName _ItemWeightType_QNAME = new QName("urn:shopster:apis:main", "ItemWeightType");
    private final static QName _GetOrdersResponseType_QNAME = new QName("urn:shopster:apis:main", "GetOrdersResponseType");
    private final static QName _GetInventoryItemsResponseType_QNAME = new QName("urn:shopster:apis:main", "GetInventoryItemsResponseType");
    private final static QName _AddressType_QNAME = new QName("urn:shopster:apis:main", "Address");
    private final static QName _OrderItemListType_QNAME = new QName("urn:shopster:apis:main", "OrderItemListType");
    private final static QName _OrderDiscountType_QNAME = new QName("urn:shopster:apis:main", "OrderDiscountType");
    private final static QName _GetInventoryItemsResponse_QNAME = new QName("urn:shopster:apis:main", "GetInventoryItemsResponse");
    private final static QName _ErrorSeverityType_QNAME = new QName("urn:shopster:apis:main", "ErrorSeverityType");
    private final static QName _OrderIdListType_QNAME = new QName("urn:shopster:apis:main", "OrderIdListType");
    private final static QName _InventoryItemType_QNAME = new QName("urn:shopster:apis:main", "InventoryItemType");
    private final static QName _GetOrdersRequestType_QNAME = new QName("urn:shopster:apis:main", "GetOrdersRequestType");
    private final static QName _CategoryIdListType_QNAME = new QName("urn:shopster:apis:main", "CategoryIdListType");
    private final static QName _GetInventoryItemsRequestType_QNAME = new QName("urn:shopster:apis:main", "GetInventoryItemsRequestType");
    private final static QName _OrderTaxListType_QNAME = new QName("urn:shopster:apis:main", "OrderTaxListType");
    private final static QName _CurrencyCodeType_QNAME = new QName("urn:shopster:apis:main", "CurrencyCodeType");
    private final static QName _GetVersionsRequestType_QNAME = new QName("urn:shopster:apis:main", "GetVersionsRequestType");
    private final static QName _OrderSupplierType_QNAME = new QName("urn:shopster:apis:main", "OrderSupplierType");
    private final static QName _Version_QNAME = new QName("urn:shopster:apis:main", "Version");
    private final static QName _OrderCartType_QNAME = new QName("urn:shopster:apis:main", "Cart");
    private final static QName _InventoryCategoryType_QNAME = new QName("urn:shopster:apis:main", "InventoryCategoryType");
    private final static QName _ErrorType_QNAME = new QName("urn:shopster:apis:main", "ErrorType");
    private final static QName _GetUserInfoRequest_QNAME = new QName("urn:shopster:apis:main", "GetUserInfoRequest");
    private final static QName _GetInventoryCategoriesRequestType_QNAME = new QName("urn:shopster:apis:main", "GetInventoryCategoriesRequestType");
    private final static QName _BaseResponseType_QNAME = new QName("urn:shopster:apis:main", "BaseResponseType");
    private final static QName _GetInventoryItemsRequest_QNAME = new QName("urn:shopster:apis:main", "GetInventoryItemsRequest");
    private final static QName _VerifyPlaceOrderRequestType_QNAME = new QName("urn:shopster:apis:main", "VerifyPlaceOrderRequestType");
    private final static QName _ItemImageListType_QNAME = new QName("urn:shopster:apis:main", "ItemImageListType");
    private final static QName _GetVersionsRequest_QNAME = new QName("urn:shopster:apis:main", "GetVersionsRequest");
    private final static QName _ErrorCollectionType_QNAME = new QName("urn:shopster:apis:main", "ErrorCollectionType");
    private final static QName _GetInventoryCategoriesRequest_QNAME = new QName("urn:shopster:apis:main", "GetInventoryCategoriesRequest");
    private final static QName _GetInventoryCategoriesResponseType_QNAME = new QName("urn:shopster:apis:main", "GetInventoryCategoriesResponseType");
    private final static QName _GetVersionsResponse_QNAME = new QName("urn:shopster:apis:main", "GetVersionsResponse");
    private final static QName _GetVersionsResponseType_QNAME = new QName("urn:shopster:apis:main", "GetVersionsResponseType");
    private final static QName _GetUserInfoResponse_QNAME = new QName("urn:shopster:apis:main", "GetUserInfoResponse");
    private final static QName _BillingInfoType_QNAME = new QName("urn:shopster:apis:main", "BillingInfo");
    private final static QName _BaseRequestType_QNAME = new QName("urn:shopster:apis:main", "BaseRequestType");
    private final static QName _PlaceOrderRequest_QNAME = new QName("urn:shopster:apis:main", "PlaceOrderRequest");
    private final static QName _GetUserInfoRequestType_QNAME = new QName("urn:shopster:apis:main", "GetUserInfoRequestType");
    private final static QName _WeightUnitType_QNAME = new QName("urn:shopster:apis:main", "WeightUnitType");
    private final static QName _VerifyPlaceOrderResponse_QNAME = new QName("urn:shopster:apis:main", "VerifyPlaceOrderResponse");
    private final static QName _OrderCustomerType_QNAME = new QName("urn:shopster:apis:main", "OrderCustomerType");
    private final static QName _OrderSupplierListType_QNAME = new QName("urn:shopster:apis:main", "OrderSupplierListType");
    private final static QName _BillingInfoTypeAddress_QNAME = new QName("urn:shopster:apis:main", "Address");
    private final static QName _AddressTypeName_QNAME = new QName("urn:shopster:apis:main", "Name");
    private final static QName _AddressTypePostalCode_QNAME = new QName("urn:shopster:apis:main", "PostalCode");
    private final static QName _AddressTypeRegion_QNAME = new QName("urn:shopster:apis:main", "Region");
    private final static QName _AddressTypeCountry_QNAME = new QName("urn:shopster:apis:main", "Country");
    private final static QName _AddressTypeStreet2_QNAME = new QName("urn:shopster:apis:main", "Street2");
    private final static QName _AddressTypeStreet1_QNAME = new QName("urn:shopster:apis:main", "Street1");
    private final static QName _AddressTypeCity_QNAME = new QName("urn:shopster:apis:main", "City");
    private final static QName _AddressTypeTitle_QNAME = new QName("urn:shopster:apis:main", "Title");
    private final static QName _GetInventoryItemsRequestTypeSearchTerm_QNAME = new QName("urn:shopster:apis:main", "SearchTerm");
    private final static QName _GetInventoryItemsRequestTypePageSize_QNAME = new QName("urn:shopster:apis:main", "PageSize");
    private final static QName _GetInventoryItemsRequestTypeLastUpdatedSince_QNAME = new QName("urn:shopster:apis:main", "LastUpdatedSince");
    private final static QName _GetInventoryItemsRequestTypeItemIdList_QNAME = new QName("urn:shopster:apis:main", "ItemIdList");
    private final static QName _GetInventoryItemsRequestTypeDetailGroups_QNAME = new QName("urn:shopster:apis:main", "DetailGroups");
    private final static QName _GetInventoryItemsRequestTypeCategoryId_QNAME = new QName("urn:shopster:apis:main", "CategoryId");
    private final static QName _GetInventoryItemsRequestTypeSupplierId_QNAME = new QName("urn:shopster:apis:main", "SupplierId");
    private final static QName _GetInventoryItemsRequestTypePageIndex_QNAME = new QName("urn:shopster:apis:main", "PageIndex");
    private final static QName _GetVersionsResponseTypeMinimumSupportedVersion_QNAME = new QName("urn:shopster:apis:main", "MinimumSupportedVersion");
    private final static QName _OrderCartItemTypeItemId_QNAME = new QName("urn:shopster:apis:main", "ItemId");
    private final static QName _OrderCartItemTypeQuantity_QNAME = new QName("urn:shopster:apis:main", "Quantity");
    private final static QName _AmountTypeAmount_QNAME = new QName("urn:shopster:apis:main", "Amount");
    private final static QName _GetOrdersRequestTypeOrderStatusFilter_QNAME = new QName("urn:shopster:apis:main", "OrderStatusFilter");
    private final static QName _GetOrdersRequestTypeOrderIds_QNAME = new QName("urn:shopster:apis:main", "OrderIds");
    private final static QName _OrderTypeBillingInfo_QNAME = new QName("urn:shopster:apis:main", "BillingInfo");
    private final static QName _OrderTypeStatus_QNAME = new QName("urn:shopster:apis:main", "Status");
    private final static QName _OrderTypeTaxes_QNAME = new QName("urn:shopster:apis:main", "Taxes");
    private final static QName _OrderTypeSubTotal_QNAME = new QName("urn:shopster:apis:main", "SubTotal");
    private final static QName _OrderTypeHandlingCost_QNAME = new QName("urn:shopster:apis:main", "HandlingCost");
    private final static QName _OrderTypeTotal_QNAME = new QName("urn:shopster:apis:main", "Total");
    private final static QName _OrderTypeShippingCost_QNAME = new QName("urn:shopster:apis:main", "ShippingCost");
    private final static QName _OrderTypeSuppliers_QNAME = new QName("urn:shopster:apis:main", "Suppliers");
    private final static QName _OrderTypeShippingMethod_QNAME = new QName("urn:shopster:apis:main", "ShippingMethod");
    private final static QName _OrderTypeOrderId_QNAME = new QName("urn:shopster:apis:main", "OrderId");
    private final static QName _OrderTypeCustomer_QNAME = new QName("urn:shopster:apis:main", "Customer");
    private final static QName _OrderTypeShippingInfo_QNAME = new QName("urn:shopster:apis:main", "ShippingInfo");
    private final static QName _OrderTypeDiscounts_QNAME = new QName("urn:shopster:apis:main", "Discounts");
    private final static QName _OrderTypeDateCreated_QNAME = new QName("urn:shopster:apis:main", "DateCreated");
    private final static QName _OrderCustomerTypeFullName_QNAME = new QName("urn:shopster:apis:main", "FullName");
    private final static QName _OrderCustomerTypeContactPhoneNumber_QNAME = new QName("urn:shopster:apis:main", "ContactPhoneNumber");
    private final static QName _OrderCustomerTypeEmailAddress_QNAME = new QName("urn:shopster:apis:main", "EmailAddress");
    private final static QName _GetInventoryItemsResponseTypeItems_QNAME = new QName("urn:shopster:apis:main", "Items");
    private final static QName _GetInventoryItemsResponseTypeNumFound_QNAME = new QName("urn:shopster:apis:main", "NumFound");
    private final static QName _BaseRequestTypeMessageID_QNAME = new QName("urn:shopster:apis:main", "MessageID");
    private final static QName _BaseRequestTypeOutputSelector_QNAME = new QName("urn:shopster:apis:main", "OutputSelector");
    private final static QName _OrderDiscountTypeCode_QNAME = new QName("urn:shopster:apis:main", "Code");
    private final static QName _ErrorTypeMessage_QNAME = new QName("urn:shopster:apis:main", "Message");
    private final static QName _ErrorTypeErrorCode_QNAME = new QName("urn:shopster:apis:main", "ErrorCode");
    private final static QName _ErrorTypeErrorParameters_QNAME = new QName("urn:shopster:apis:main", "ErrorParameters");
    private final static QName _PlaceOrderRequestTypeCart_QNAME = new QName("urn:shopster:apis:main", "Cart");
    private final static QName _InventoryCategoryTypeOrderIndex_QNAME = new QName("urn:shopster:apis:main", "OrderIndex");
    private final static QName _InventoryCategoryTypeEnabled_QNAME = new QName("urn:shopster:apis:main", "Enabled");
    private final static QName _InventoryCategoryTypeLineage_QNAME = new QName("urn:shopster:apis:main", "Lineage");
    private final static QName _InventoryCategoryTypeUrlName_QNAME = new QName("urn:shopster:apis:main", "UrlName");
    private final static QName _OrderTaxTypeDescription_QNAME = new QName("urn:shopster:apis:main", "Description");
    private final static QName _OrderTaxTypeTaxAmount_QNAME = new QName("urn:shopster:apis:main", "TaxAmount");
    private final static QName _OrderSupplierTypeDateShipped_QNAME = new QName("urn:shopster:apis:main", "DateShipped");
    private final static QName _OrderSupplierTypeTrackingNumber_QNAME = new QName("urn:shopster:apis:main", "TrackingNumber");
    private final static QName _OrderSupplierTypeTrackingUrl_QNAME = new QName("urn:shopster:apis:main", "TrackingUrl");
    private final static QName _OrderSupplierTypeShippingCarrier_QNAME = new QName("urn:shopster:apis:main", "ShippingCarrier");
    private final static QName _OrderSupplierTypeProducts_QNAME = new QName("urn:shopster:apis:main", "Products");
    private final static QName _OrderSupplierTypeHandlingFee_QNAME = new QName("urn:shopster:apis:main", "HandlingFee");
    private final static QName _GetInventoryCategoriesRequestTypeParentCategoryId_QNAME = new QName("urn:shopster:apis:main", "ParentCategoryId");
    private final static QName _GetInventoryCategoriesRequestTypeRootCategoryId_QNAME = new QName("urn:shopster:apis:main", "RootCategoryId");
    private final static QName _GetUserInfoResponseTypeUserId_QNAME = new QName("urn:shopster:apis:main", "UserId");
    private final static QName _BaseResponseTypeBuild_QNAME = new QName("urn:shopster:apis:main", "Build");
    private final static QName _BaseResponseTypeErrors_QNAME = new QName("urn:shopster:apis:main", "Errors");
    private final static QName _BaseResponseTypeTimestamp_QNAME = new QName("urn:shopster:apis:main", "Timestamp");
    private final static QName _BaseResponseTypeAccessExpirationDate_QNAME = new QName("urn:shopster:apis:main", "AccessExpirationDate");
    private final static QName _ItemImageTypeThumbUrl_QNAME = new QName("urn:shopster:apis:main", "ThumbUrl");
    private final static QName _ItemImageTypeLargeUrl_QNAME = new QName("urn:shopster:apis:main", "LargeUrl");
    private final static QName _ItemImageTypeDetailUrl_QNAME = new QName("urn:shopster:apis:main", "DetailUrl");
    private final static QName _ItemImageTypeImageNumber_QNAME = new QName("urn:shopster:apis:main", "ImageNumber");
    private final static QName _InventoryItemTypeWeight_QNAME = new QName("urn:shopster:apis:main", "Weight");
    private final static QName _InventoryItemTypeIsStoreVisible_QNAME = new QName("urn:shopster:apis:main", "IsStoreVisible");
    private final static QName _InventoryItemTypeStoreUrl_QNAME = new QName("urn:shopster:apis:main", "StoreUrl");
    private final static QName _InventoryItemTypeShortDescription_QNAME = new QName("urn:shopster:apis:main", "ShortDescription");
    private final static QName _InventoryItemTypeLongDescription_QNAME = new QName("urn:shopster:apis:main", "LongDescription");
    private final static QName _InventoryItemTypeCanPurchase_QNAME = new QName("urn:shopster:apis:main", "CanPurchase");
    private final static QName _InventoryItemTypeWarehouseId_QNAME = new QName("urn:shopster:apis:main", "WarehouseId");
    private final static QName _InventoryItemTypePricing_QNAME = new QName("urn:shopster:apis:main", "Pricing");
    private final static QName _InventoryItemTypeSku_QNAME = new QName("urn:shopster:apis:main", "Sku");
    private final static QName _InventoryItemTypeCategories_QNAME = new QName("urn:shopster:apis:main", "Categories");
    private final static QName _InventoryItemTypeImages_QNAME = new QName("urn:shopster:apis:main", "Images");
    private final static QName _OrderItemTypeOriginalUnitPrice_QNAME = new QName("urn:shopster:apis:main", "OriginalUnitPrice");
    private final static QName _OrderItemTypeUnitPrice_QNAME = new QName("urn:shopster:apis:main", "UnitPrice");
    private final static QName _GetOrdersResponseTypeOrders_QNAME = new QName("urn:shopster:apis:main", "Orders");
    private final static QName _PlaceOrderResponseTypeNewOrderId_QNAME = new QName("urn:shopster:apis:main", "NewOrderId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: shopster.apis.main
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BillingInfoType }
     * 
     */
    public BillingInfoType createBillingInfoType() {
        return new BillingInfoType();
    }

    /**
     * Create an instance of {@link AddressType }
     * 
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link OrderCartItemListType }
     * 
     */
    public OrderCartItemListType createOrderCartItemListType() {
        return new OrderCartItemListType();
    }

    /**
     * Create an instance of {@link GetInventoryItemsRequestType }
     * 
     */
    public GetInventoryItemsRequestType createGetInventoryItemsRequestType() {
        return new GetInventoryItemsRequestType();
    }

    /**
     * Create an instance of {@link GetVersionsResponseType }
     * 
     */
    public GetVersionsResponseType createGetVersionsResponseType() {
        return new GetVersionsResponseType();
    }

    /**
     * Create an instance of {@link OrderCartItemType }
     * 
     */
    public OrderCartItemType createOrderCartItemType() {
        return new OrderCartItemType();
    }

    /**
     * Create an instance of {@link AmountType }
     * 
     */
    public AmountType createAmountType() {
        return new AmountType();
    }

    /**
     * Create an instance of {@link GetOrdersRequestType }
     * 
     */
    public GetOrdersRequestType createGetOrdersRequestType() {
        return new GetOrdersRequestType();
    }

    /**
     * Create an instance of {@link OrderType }
     * 
     */
    public OrderType createOrderType() {
        return new OrderType();
    }

    /**
     * Create an instance of {@link ErrorCollectionType }
     * 
     */
    public ErrorCollectionType createErrorCollectionType() {
        return new ErrorCollectionType();
    }

    /**
     * Create an instance of {@link GetUserInfoRequestType }
     * 
     */
    public GetUserInfoRequestType createGetUserInfoRequestType() {
        return new GetUserInfoRequestType();
    }

    /**
     * Create an instance of {@link ItemWeightType }
     * 
     */
    public ItemWeightType createItemWeightType() {
        return new ItemWeightType();
    }

    /**
     * Create an instance of {@link OrderIdListType }
     * 
     */
    public OrderIdListType createOrderIdListType() {
        return new OrderIdListType();
    }

    /**
     * Create an instance of {@link OrderCustomerType }
     * 
     */
    public OrderCustomerType createOrderCustomerType() {
        return new OrderCustomerType();
    }

    /**
     * Create an instance of {@link GetInventoryItemsResponseType }
     * 
     */
    public GetInventoryItemsResponseType createGetInventoryItemsResponseType() {
        return new GetInventoryItemsResponseType();
    }

    /**
     * Create an instance of {@link InventoryItemListType }
     * 
     */
    public InventoryItemListType createInventoryItemListType() {
        return new InventoryItemListType();
    }

    /**
     * Create an instance of {@link OrderSupplierListType }
     * 
     */
    public OrderSupplierListType createOrderSupplierListType() {
        return new OrderSupplierListType();
    }

    /**
     * Create an instance of {@link OrderTaxListType }
     * 
     */
    public OrderTaxListType createOrderTaxListType() {
        return new OrderTaxListType();
    }

    /**
     * Create an instance of {@link BaseRequestType }
     * 
     */
    public BaseRequestType createBaseRequestType() {
        return new BaseRequestType();
    }

    /**
     * Create an instance of {@link OrderDiscountType }
     * 
     */
    public OrderDiscountType createOrderDiscountType() {
        return new OrderDiscountType();
    }

    /**
     * Create an instance of {@link ErrorType }
     * 
     */
    public ErrorType createErrorType() {
        return new ErrorType();
    }

    /**
     * Create an instance of {@link PlaceOrderRequestType }
     * 
     */
    public PlaceOrderRequestType createPlaceOrderRequestType() {
        return new PlaceOrderRequestType();
    }

    /**
     * Create an instance of {@link ItemIdListType }
     * 
     */
    public ItemIdListType createItemIdListType() {
        return new ItemIdListType();
    }

    /**
     * Create an instance of {@link InventoryCategoryType }
     * 
     */
    public InventoryCategoryType createInventoryCategoryType() {
        return new InventoryCategoryType();
    }

    /**
     * Create an instance of {@link OrderDiscountListType }
     * 
     */
    public OrderDiscountListType createOrderDiscountListType() {
        return new OrderDiscountListType();
    }

    /**
     * Create an instance of {@link OrderTaxType }
     * 
     */
    public OrderTaxType createOrderTaxType() {
        return new OrderTaxType();
    }

    /**
     * Create an instance of {@link OrderSupplierType }
     * 
     */
    public OrderSupplierType createOrderSupplierType() {
        return new OrderSupplierType();
    }

    /**
     * Create an instance of {@link GetInventoryCategoriesRequestType }
     * 
     */
    public GetInventoryCategoriesRequestType createGetInventoryCategoriesRequestType() {
        return new GetInventoryCategoriesRequestType();
    }

    /**
     * Create an instance of {@link GetUserInfoResponseType }
     * 
     */
    public GetUserInfoResponseType createGetUserInfoResponseType() {
        return new GetUserInfoResponseType();
    }

    /**
     * Create an instance of {@link BaseResponseType }
     * 
     */
    public BaseResponseType createBaseResponseType() {
        return new BaseResponseType();
    }

    /**
     * Create an instance of {@link InventoryItemType }
     * 
     */
    public InventoryItemType createInventoryItemType() {
        return new InventoryItemType();
    }

    /**
     * Create an instance of {@link ItemImageType }
     * 
     */
    public ItemImageType createItemImageType() {
        return new ItemImageType();
    }

    /**
     * Create an instance of {@link VerifyPlaceOrderRequestType }
     * 
     */
    public VerifyPlaceOrderRequestType createVerifyPlaceOrderRequestType() {
        return new VerifyPlaceOrderRequestType();
    }

    /**
     * Create an instance of {@link ItemImageListType }
     * 
     */
    public ItemImageListType createItemImageListType() {
        return new ItemImageListType();
    }

    /**
     * Create an instance of {@link OrderItemType }
     * 
     */
    public OrderItemType createOrderItemType() {
        return new OrderItemType();
    }

    /**
     * Create an instance of {@link OrderListType }
     * 
     */
    public OrderListType createOrderListType() {
        return new OrderListType();
    }

    /**
     * Create an instance of {@link OrderCartType }
     * 
     */
    public OrderCartType createOrderCartType() {
        return new OrderCartType();
    }

    /**
     * Create an instance of {@link GetOrdersResponseType }
     * 
     */
    public GetOrdersResponseType createGetOrdersResponseType() {
        return new GetOrdersResponseType();
    }

    /**
     * Create an instance of {@link CategoryIdListType }
     * 
     */
    public CategoryIdListType createCategoryIdListType() {
        return new CategoryIdListType();
    }

    /**
     * Create an instance of {@link GetInventoryCategoriesResponseType }
     * 
     */
    public GetInventoryCategoriesResponseType createGetInventoryCategoriesResponseType() {
        return new GetInventoryCategoriesResponseType();
    }

    /**
     * Create an instance of {@link PlaceOrderResponseType }
     * 
     */
    public PlaceOrderResponseType createPlaceOrderResponseType() {
        return new PlaceOrderResponseType();
    }

    /**
     * Create an instance of {@link InventoryItemPricingType }
     * 
     */
    public InventoryItemPricingType createInventoryItemPricingType() {
        return new InventoryItemPricingType();
    }

    /**
     * Create an instance of {@link OrderItemListType }
     * 
     */
    public OrderItemListType createOrderItemListType() {
        return new OrderItemListType();
    }

    /**
     * Create an instance of {@link GetVersionsRequestType }
     * 
     */
    public GetVersionsRequestType createGetVersionsRequestType() {
        return new GetVersionsRequestType();
    }

    /**
     * Create an instance of {@link ErrorParametersCollectionType }
     * 
     */
    public ErrorParametersCollectionType createErrorParametersCollectionType() {
        return new ErrorParametersCollectionType();
    }

    /**
     * Create an instance of {@link VerifyPlaceOrderResponseType }
     * 
     */
    public VerifyPlaceOrderResponseType createVerifyPlaceOrderResponseType() {
        return new VerifyPlaceOrderResponseType();
    }

    /**
     * Create an instance of {@link InventoryCategoryListType }
     * 
     */
    public InventoryCategoryListType createInventoryCategoryListType() {
        return new InventoryCategoryListType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlaceOrderResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "PlaceOrderResponseType")
    public JAXBElement<PlaceOrderResponseType> createPlaceOrderResponseType(PlaceOrderResponseType value) {
        return new JAXBElement<PlaceOrderResponseType>(_PlaceOrderResponseType_QNAME, PlaceOrderResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "OrderType")
    public JAXBElement<OrderType> createOrderType(OrderType value) {
        return new JAXBElement<OrderType>(_OrderType_QNAME, OrderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrdersResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "GetOrdersResponse")
    public JAXBElement<GetOrdersResponseType> createGetOrdersResponse(GetOrdersResponseType value) {
        return new JAXBElement<GetOrdersResponseType>(_GetOrdersResponse_QNAME, GetOrdersResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemIdListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ItemIdListType")
    public JAXBElement<ItemIdListType> createItemIdListType(ItemIdListType value) {
        return new JAXBElement<ItemIdListType>(_ItemIdListType_QNAME, ItemIdListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemImageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ItemImageType")
    public JAXBElement<ItemImageType> createItemImageType(ItemImageType value) {
        return new JAXBElement<ItemImageType>(_ItemImageType_QNAME, ItemImageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInventoryCategoriesResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "GetInventoryCategoriesResponse")
    public JAXBElement<GetInventoryCategoriesResponseType> createGetInventoryCategoriesResponse(GetInventoryCategoriesResponseType value) {
        return new JAXBElement<GetInventoryCategoriesResponseType>(_GetInventoryCategoriesResponse_QNAME, GetInventoryCategoriesResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderItemType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "OrderItemType")
    public JAXBElement<OrderItemType> createOrderItemType(OrderItemType value) {
        return new JAXBElement<OrderItemType>(_OrderItemType_QNAME, OrderItemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorParametersCollectionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ErrorParametersCollectionType")
    public JAXBElement<ErrorParametersCollectionType> createErrorParametersCollectionType(ErrorParametersCollectionType value) {
        return new JAXBElement<ErrorParametersCollectionType>(_ErrorParametersCollectionType_QNAME, ErrorParametersCollectionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InventoryItemPricingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "InventoryItemPricingType")
    public JAXBElement<InventoryItemPricingType> createInventoryItemPricingType(InventoryItemPricingType value) {
        return new JAXBElement<InventoryItemPricingType>(_InventoryItemPricingType_QNAME, InventoryItemPricingType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InventoryItemListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "InventoryItemListType")
    public JAXBElement<InventoryItemListType> createInventoryItemListType(InventoryItemListType value) {
        return new JAXBElement<InventoryItemListType>(_InventoryItemListType_QNAME, InventoryItemListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlaceOrderRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "PlaceOrderRequestType")
    public JAXBElement<PlaceOrderRequestType> createPlaceOrderRequestType(PlaceOrderRequestType value) {
        return new JAXBElement<PlaceOrderRequestType>(_PlaceOrderRequestType_QNAME, PlaceOrderRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderTaxType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "OrderTaxType")
    public JAXBElement<OrderTaxType> createOrderTaxType(OrderTaxType value) {
        return new JAXBElement<OrderTaxType>(_OrderTaxType_QNAME, OrderTaxType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseStatusType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ResponseStatusType")
    public JAXBElement<ResponseStatusType> createResponseStatusType(ResponseStatusType value) {
        return new JAXBElement<ResponseStatusType>(_ResponseStatusType_QNAME, ResponseStatusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrdersRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "GetOrdersRequest")
    public JAXBElement<GetOrdersRequestType> createGetOrdersRequest(GetOrdersRequestType value) {
        return new JAXBElement<GetOrdersRequestType>(_GetOrdersRequest_QNAME, GetOrdersRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "OrderListType")
    public JAXBElement<OrderListType> createOrderListType(OrderListType value) {
        return new JAXBElement<OrderListType>(_OrderListType_QNAME, OrderListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "AmountType")
    public JAXBElement<AmountType> createAmountType(AmountType value) {
        return new JAXBElement<AmountType>(_AmountType_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderDiscountListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "OrderDiscountListType")
    public JAXBElement<OrderDiscountListType> createOrderDiscountListType(OrderDiscountListType value) {
        return new JAXBElement<OrderDiscountListType>(_OrderDiscountListType_QNAME, OrderDiscountListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorClassificationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ErrorClassificationType")
    public JAXBElement<ErrorClassificationType> createErrorClassificationType(ErrorClassificationType value) {
        return new JAXBElement<ErrorClassificationType>(_ErrorClassificationType_QNAME, ErrorClassificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderCartItemListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "OrderCartItemListType")
    public JAXBElement<OrderCartItemListType> createOrderCartItemListType(OrderCartItemListType value) {
        return new JAXBElement<OrderCartItemListType>(_OrderCartItemListType_QNAME, OrderCartItemListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyPlaceOrderRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "VerifyPlaceOrderRequest")
    public JAXBElement<VerifyPlaceOrderRequestType> createVerifyPlaceOrderRequest(VerifyPlaceOrderRequestType value) {
        return new JAXBElement<VerifyPlaceOrderRequestType>(_VerifyPlaceOrderRequest_QNAME, VerifyPlaceOrderRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderCartItemType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "OrderCartItemType")
    public JAXBElement<OrderCartItemType> createOrderCartItemType(OrderCartItemType value) {
        return new JAXBElement<OrderCartItemType>(_OrderCartItemType_QNAME, OrderCartItemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserInfoResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "GetUserInfoResponseType")
    public JAXBElement<GetUserInfoResponseType> createGetUserInfoResponseType(GetUserInfoResponseType value) {
        return new JAXBElement<GetUserInfoResponseType>(_GetUserInfoResponseType_QNAME, GetUserInfoResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InventoryCategoryListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "InventoryCategoryListType")
    public JAXBElement<InventoryCategoryListType> createInventoryCategoryListType(InventoryCategoryListType value) {
        return new JAXBElement<InventoryCategoryListType>(_InventoryCategoryListType_QNAME, InventoryCategoryListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyPlaceOrderResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "VerifyPlaceOrderResponseType")
    public JAXBElement<VerifyPlaceOrderResponseType> createVerifyPlaceOrderResponseType(VerifyPlaceOrderResponseType value) {
        return new JAXBElement<VerifyPlaceOrderResponseType>(_VerifyPlaceOrderResponseType_QNAME, VerifyPlaceOrderResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlaceOrderResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "PlaceOrderResponse")
    public JAXBElement<PlaceOrderResponseType> createPlaceOrderResponse(PlaceOrderResponseType value) {
        return new JAXBElement<PlaceOrderResponseType>(_PlaceOrderResponse_QNAME, PlaceOrderResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemWeightType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ItemWeightType")
    public JAXBElement<ItemWeightType> createItemWeightType(ItemWeightType value) {
        return new JAXBElement<ItemWeightType>(_ItemWeightType_QNAME, ItemWeightType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrdersResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "GetOrdersResponseType")
    public JAXBElement<GetOrdersResponseType> createGetOrdersResponseType(GetOrdersResponseType value) {
        return new JAXBElement<GetOrdersResponseType>(_GetOrdersResponseType_QNAME, GetOrdersResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInventoryItemsResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "GetInventoryItemsResponseType")
    public JAXBElement<GetInventoryItemsResponseType> createGetInventoryItemsResponseType(GetInventoryItemsResponseType value) {
        return new JAXBElement<GetInventoryItemsResponseType>(_GetInventoryItemsResponseType_QNAME, GetInventoryItemsResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "AddressType")
    public JAXBElement<AddressType> createAddressType(AddressType value) {
        return new JAXBElement<AddressType>(_AddressType_QNAME, AddressType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderItemListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "OrderItemListType")
    public JAXBElement<OrderItemListType> createOrderItemListType(OrderItemListType value) {
        return new JAXBElement<OrderItemListType>(_OrderItemListType_QNAME, OrderItemListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderDiscountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "OrderDiscountType")
    public JAXBElement<OrderDiscountType> createOrderDiscountType(OrderDiscountType value) {
        return new JAXBElement<OrderDiscountType>(_OrderDiscountType_QNAME, OrderDiscountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInventoryItemsResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "GetInventoryItemsResponse")
    public JAXBElement<GetInventoryItemsResponseType> createGetInventoryItemsResponse(GetInventoryItemsResponseType value) {
        return new JAXBElement<GetInventoryItemsResponseType>(_GetInventoryItemsResponse_QNAME, GetInventoryItemsResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorSeverityType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ErrorSeverityType")
    public JAXBElement<ErrorSeverityType> createErrorSeverityType(ErrorSeverityType value) {
        return new JAXBElement<ErrorSeverityType>(_ErrorSeverityType_QNAME, ErrorSeverityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderIdListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "OrderIdListType")
    public JAXBElement<OrderIdListType> createOrderIdListType(OrderIdListType value) {
        return new JAXBElement<OrderIdListType>(_OrderIdListType_QNAME, OrderIdListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InventoryItemType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "InventoryItemType")
    public JAXBElement<InventoryItemType> createInventoryItemType(InventoryItemType value) {
        return new JAXBElement<InventoryItemType>(_InventoryItemType_QNAME, InventoryItemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrdersRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "GetOrdersRequestType")
    public JAXBElement<GetOrdersRequestType> createGetOrdersRequestType(GetOrdersRequestType value) {
        return new JAXBElement<GetOrdersRequestType>(_GetOrdersRequestType_QNAME, GetOrdersRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoryIdListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "CategoryIdListType")
    public JAXBElement<CategoryIdListType> createCategoryIdListType(CategoryIdListType value) {
        return new JAXBElement<CategoryIdListType>(_CategoryIdListType_QNAME, CategoryIdListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInventoryItemsRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "GetInventoryItemsRequestType")
    public JAXBElement<GetInventoryItemsRequestType> createGetInventoryItemsRequestType(GetInventoryItemsRequestType value) {
        return new JAXBElement<GetInventoryItemsRequestType>(_GetInventoryItemsRequestType_QNAME, GetInventoryItemsRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderTaxListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "OrderTaxListType")
    public JAXBElement<OrderTaxListType> createOrderTaxListType(OrderTaxListType value) {
        return new JAXBElement<OrderTaxListType>(_OrderTaxListType_QNAME, OrderTaxListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrencyCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "CurrencyCodeType")
    public JAXBElement<CurrencyCodeType> createCurrencyCodeType(CurrencyCodeType value) {
        return new JAXBElement<CurrencyCodeType>(_CurrencyCodeType_QNAME, CurrencyCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVersionsRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "GetVersionsRequestType")
    public JAXBElement<GetVersionsRequestType> createGetVersionsRequestType(GetVersionsRequestType value) {
        return new JAXBElement<GetVersionsRequestType>(_GetVersionsRequestType_QNAME, GetVersionsRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderSupplierType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "OrderSupplierType")
    public JAXBElement<OrderSupplierType> createOrderSupplierType(OrderSupplierType value) {
        return new JAXBElement<OrderSupplierType>(_OrderSupplierType_QNAME, OrderSupplierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Version")
    public JAXBElement<String> createVersion(String value) {
        return new JAXBElement<String>(_Version_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderCartType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Cart")
    public JAXBElement<OrderCartType> createOrderCartType(OrderCartType value) {
        return new JAXBElement<OrderCartType>(_OrderCartType_QNAME, OrderCartType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InventoryCategoryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "InventoryCategoryType")
    public JAXBElement<InventoryCategoryType> createInventoryCategoryType(InventoryCategoryType value) {
        return new JAXBElement<InventoryCategoryType>(_InventoryCategoryType_QNAME, InventoryCategoryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ErrorType")
    public JAXBElement<ErrorType> createErrorType(ErrorType value) {
        return new JAXBElement<ErrorType>(_ErrorType_QNAME, ErrorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserInfoRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "GetUserInfoRequest")
    public JAXBElement<GetUserInfoRequestType> createGetUserInfoRequest(GetUserInfoRequestType value) {
        return new JAXBElement<GetUserInfoRequestType>(_GetUserInfoRequest_QNAME, GetUserInfoRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInventoryCategoriesRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "GetInventoryCategoriesRequestType")
    public JAXBElement<GetInventoryCategoriesRequestType> createGetInventoryCategoriesRequestType(GetInventoryCategoriesRequestType value) {
        return new JAXBElement<GetInventoryCategoriesRequestType>(_GetInventoryCategoriesRequestType_QNAME, GetInventoryCategoriesRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BaseResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "BaseResponseType")
    public JAXBElement<BaseResponseType> createBaseResponseType(BaseResponseType value) {
        return new JAXBElement<BaseResponseType>(_BaseResponseType_QNAME, BaseResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInventoryItemsRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "GetInventoryItemsRequest")
    public JAXBElement<GetInventoryItemsRequestType> createGetInventoryItemsRequest(GetInventoryItemsRequestType value) {
        return new JAXBElement<GetInventoryItemsRequestType>(_GetInventoryItemsRequest_QNAME, GetInventoryItemsRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyPlaceOrderRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "VerifyPlaceOrderRequestType")
    public JAXBElement<VerifyPlaceOrderRequestType> createVerifyPlaceOrderRequestType(VerifyPlaceOrderRequestType value) {
        return new JAXBElement<VerifyPlaceOrderRequestType>(_VerifyPlaceOrderRequestType_QNAME, VerifyPlaceOrderRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemImageListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ItemImageListType")
    public JAXBElement<ItemImageListType> createItemImageListType(ItemImageListType value) {
        return new JAXBElement<ItemImageListType>(_ItemImageListType_QNAME, ItemImageListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVersionsRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "GetVersionsRequest")
    public JAXBElement<GetVersionsRequestType> createGetVersionsRequest(GetVersionsRequestType value) {
        return new JAXBElement<GetVersionsRequestType>(_GetVersionsRequest_QNAME, GetVersionsRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorCollectionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ErrorCollectionType")
    public JAXBElement<ErrorCollectionType> createErrorCollectionType(ErrorCollectionType value) {
        return new JAXBElement<ErrorCollectionType>(_ErrorCollectionType_QNAME, ErrorCollectionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInventoryCategoriesRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "GetInventoryCategoriesRequest")
    public JAXBElement<GetInventoryCategoriesRequestType> createGetInventoryCategoriesRequest(GetInventoryCategoriesRequestType value) {
        return new JAXBElement<GetInventoryCategoriesRequestType>(_GetInventoryCategoriesRequest_QNAME, GetInventoryCategoriesRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInventoryCategoriesResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "GetInventoryCategoriesResponseType")
    public JAXBElement<GetInventoryCategoriesResponseType> createGetInventoryCategoriesResponseType(GetInventoryCategoriesResponseType value) {
        return new JAXBElement<GetInventoryCategoriesResponseType>(_GetInventoryCategoriesResponseType_QNAME, GetInventoryCategoriesResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVersionsResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "GetVersionsResponse")
    public JAXBElement<GetVersionsResponseType> createGetVersionsResponse(GetVersionsResponseType value) {
        return new JAXBElement<GetVersionsResponseType>(_GetVersionsResponse_QNAME, GetVersionsResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVersionsResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "GetVersionsResponseType")
    public JAXBElement<GetVersionsResponseType> createGetVersionsResponseType(GetVersionsResponseType value) {
        return new JAXBElement<GetVersionsResponseType>(_GetVersionsResponseType_QNAME, GetVersionsResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserInfoResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "GetUserInfoResponse")
    public JAXBElement<GetUserInfoResponseType> createGetUserInfoResponse(GetUserInfoResponseType value) {
        return new JAXBElement<GetUserInfoResponseType>(_GetUserInfoResponse_QNAME, GetUserInfoResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BillingInfoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "BillingInfoType")
    public JAXBElement<BillingInfoType> createBillingInfoType(BillingInfoType value) {
        return new JAXBElement<BillingInfoType>(_BillingInfoType_QNAME, BillingInfoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BaseRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "BaseRequestType")
    public JAXBElement<BaseRequestType> createBaseRequestType(BaseRequestType value) {
        return new JAXBElement<BaseRequestType>(_BaseRequestType_QNAME, BaseRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlaceOrderRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "PlaceOrderRequest")
    public JAXBElement<PlaceOrderRequestType> createPlaceOrderRequest(PlaceOrderRequestType value) {
        return new JAXBElement<PlaceOrderRequestType>(_PlaceOrderRequest_QNAME, PlaceOrderRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserInfoRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "GetUserInfoRequestType")
    public JAXBElement<GetUserInfoRequestType> createGetUserInfoRequestType(GetUserInfoRequestType value) {
        return new JAXBElement<GetUserInfoRequestType>(_GetUserInfoRequestType_QNAME, GetUserInfoRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeightUnitType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "WeightUnitType")
    public JAXBElement<WeightUnitType> createWeightUnitType(WeightUnitType value) {
        return new JAXBElement<WeightUnitType>(_WeightUnitType_QNAME, WeightUnitType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyPlaceOrderResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "VerifyPlaceOrderResponse")
    public JAXBElement<VerifyPlaceOrderResponseType> createVerifyPlaceOrderResponse(VerifyPlaceOrderResponseType value) {
        return new JAXBElement<VerifyPlaceOrderResponseType>(_VerifyPlaceOrderResponse_QNAME, VerifyPlaceOrderResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderCustomerType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "OrderCustomerType")
    public JAXBElement<OrderCustomerType> createOrderCustomerType(OrderCustomerType value) {
        return new JAXBElement<OrderCustomerType>(_OrderCustomerType_QNAME, OrderCustomerType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderSupplierListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "OrderSupplierListType")
    public JAXBElement<OrderSupplierListType> createOrderSupplierListType(OrderSupplierListType value) {
        return new JAXBElement<OrderSupplierListType>(_OrderSupplierListType_QNAME, OrderSupplierListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Address", scope = BillingInfoType.class)
    public JAXBElement<AddressType> createBillingInfoTypeAddress(AddressType value) {
        return new JAXBElement<AddressType>(_BillingInfoTypeAddress_QNAME, AddressType.class, BillingInfoType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Name", scope = AddressType.class)
    public JAXBElement<String> createAddressTypeName(String value) {
        return new JAXBElement<String>(_AddressTypeName_QNAME, String.class, AddressType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "PostalCode", scope = AddressType.class)
    public JAXBElement<String> createAddressTypePostalCode(String value) {
        return new JAXBElement<String>(_AddressTypePostalCode_QNAME, String.class, AddressType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Region", scope = AddressType.class)
    public JAXBElement<String> createAddressTypeRegion(String value) {
        return new JAXBElement<String>(_AddressTypeRegion_QNAME, String.class, AddressType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Country", scope = AddressType.class)
    public JAXBElement<String> createAddressTypeCountry(String value) {
        return new JAXBElement<String>(_AddressTypeCountry_QNAME, String.class, AddressType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Street2", scope = AddressType.class)
    public JAXBElement<String> createAddressTypeStreet2(String value) {
        return new JAXBElement<String>(_AddressTypeStreet2_QNAME, String.class, AddressType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Street1", scope = AddressType.class)
    public JAXBElement<String> createAddressTypeStreet1(String value) {
        return new JAXBElement<String>(_AddressTypeStreet1_QNAME, String.class, AddressType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "City", scope = AddressType.class)
    public JAXBElement<String> createAddressTypeCity(String value) {
        return new JAXBElement<String>(_AddressTypeCity_QNAME, String.class, AddressType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Title", scope = AddressType.class)
    public JAXBElement<String> createAddressTypeTitle(String value) {
        return new JAXBElement<String>(_AddressTypeTitle_QNAME, String.class, AddressType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "SearchTerm", scope = GetInventoryItemsRequestType.class)
    public JAXBElement<String> createGetInventoryItemsRequestTypeSearchTerm(String value) {
        return new JAXBElement<String>(_GetInventoryItemsRequestTypeSearchTerm_QNAME, String.class, GetInventoryItemsRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "PageSize", scope = GetInventoryItemsRequestType.class)
    public JAXBElement<Integer> createGetInventoryItemsRequestTypePageSize(Integer value) {
        return new JAXBElement<Integer>(_GetInventoryItemsRequestTypePageSize_QNAME, Integer.class, GetInventoryItemsRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "LastUpdatedSince", scope = GetInventoryItemsRequestType.class)
    public JAXBElement<XMLGregorianCalendar> createGetInventoryItemsRequestTypeLastUpdatedSince(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GetInventoryItemsRequestTypeLastUpdatedSince_QNAME, XMLGregorianCalendar.class, GetInventoryItemsRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemIdListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ItemIdList", scope = GetInventoryItemsRequestType.class)
    public JAXBElement<ItemIdListType> createGetInventoryItemsRequestTypeItemIdList(ItemIdListType value) {
        return new JAXBElement<ItemIdListType>(_GetInventoryItemsRequestTypeItemIdList_QNAME, ItemIdListType.class, GetInventoryItemsRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "DetailGroups", scope = GetInventoryItemsRequestType.class)
    public JAXBElement<String> createGetInventoryItemsRequestTypeDetailGroups(String value) {
        return new JAXBElement<String>(_GetInventoryItemsRequestTypeDetailGroups_QNAME, String.class, GetInventoryItemsRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "CategoryId", scope = GetInventoryItemsRequestType.class)
    public JAXBElement<String> createGetInventoryItemsRequestTypeCategoryId(String value) {
        return new JAXBElement<String>(_GetInventoryItemsRequestTypeCategoryId_QNAME, String.class, GetInventoryItemsRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "SupplierId", scope = GetInventoryItemsRequestType.class)
    public JAXBElement<String> createGetInventoryItemsRequestTypeSupplierId(String value) {
        return new JAXBElement<String>(_GetInventoryItemsRequestTypeSupplierId_QNAME, String.class, GetInventoryItemsRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "PageIndex", scope = GetInventoryItemsRequestType.class)
    public JAXBElement<Integer> createGetInventoryItemsRequestTypePageIndex(Integer value) {
        return new JAXBElement<Integer>(_GetInventoryItemsRequestTypePageIndex_QNAME, Integer.class, GetInventoryItemsRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "MinimumSupportedVersion", scope = GetVersionsResponseType.class)
    public JAXBElement<String> createGetVersionsResponseTypeMinimumSupportedVersion(String value) {
        return new JAXBElement<String>(_GetVersionsResponseTypeMinimumSupportedVersion_QNAME, String.class, GetVersionsResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ItemId", scope = OrderCartItemType.class)
    public JAXBElement<String> createOrderCartItemTypeItemId(String value) {
        return new JAXBElement<String>(_OrderCartItemTypeItemId_QNAME, String.class, OrderCartItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Quantity", scope = OrderCartItemType.class)
    public JAXBElement<Integer> createOrderCartItemTypeQuantity(Integer value) {
        return new JAXBElement<Integer>(_OrderCartItemTypeQuantity_QNAME, Integer.class, OrderCartItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Amount", scope = AmountType.class)
    public JAXBElement<BigDecimal> createAmountTypeAmount(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AmountTypeAmount_QNAME, BigDecimal.class, AmountType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "PageSize", scope = GetOrdersRequestType.class)
    public JAXBElement<Integer> createGetOrdersRequestTypePageSize(Integer value) {
        return new JAXBElement<Integer>(_GetInventoryItemsRequestTypePageSize_QNAME, Integer.class, GetOrdersRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "DetailGroups", scope = GetOrdersRequestType.class)
    public JAXBElement<String> createGetOrdersRequestTypeDetailGroups(String value) {
        return new JAXBElement<String>(_GetInventoryItemsRequestTypeDetailGroups_QNAME, String.class, GetOrdersRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "OrderStatusFilter", scope = GetOrdersRequestType.class)
    public JAXBElement<String> createGetOrdersRequestTypeOrderStatusFilter(String value) {
        return new JAXBElement<String>(_GetOrdersRequestTypeOrderStatusFilter_QNAME, String.class, GetOrdersRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderIdListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "OrderIds", scope = GetOrdersRequestType.class)
    public JAXBElement<OrderIdListType> createGetOrdersRequestTypeOrderIds(OrderIdListType value) {
        return new JAXBElement<OrderIdListType>(_GetOrdersRequestTypeOrderIds_QNAME, OrderIdListType.class, GetOrdersRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "PageIndex", scope = GetOrdersRequestType.class)
    public JAXBElement<Integer> createGetOrdersRequestTypePageIndex(Integer value) {
        return new JAXBElement<Integer>(_GetInventoryItemsRequestTypePageIndex_QNAME, Integer.class, GetOrdersRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BillingInfoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "BillingInfo", scope = OrderType.class)
    public JAXBElement<BillingInfoType> createOrderTypeBillingInfo(BillingInfoType value) {
        return new JAXBElement<BillingInfoType>(_OrderTypeBillingInfo_QNAME, BillingInfoType.class, OrderType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Status", scope = OrderType.class)
    public JAXBElement<String> createOrderTypeStatus(String value) {
        return new JAXBElement<String>(_OrderTypeStatus_QNAME, String.class, OrderType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderTaxListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Taxes", scope = OrderType.class)
    public JAXBElement<OrderTaxListType> createOrderTypeTaxes(OrderTaxListType value) {
        return new JAXBElement<OrderTaxListType>(_OrderTypeTaxes_QNAME, OrderTaxListType.class, OrderType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "SubTotal", scope = OrderType.class)
    public JAXBElement<AmountType> createOrderTypeSubTotal(AmountType value) {
        return new JAXBElement<AmountType>(_OrderTypeSubTotal_QNAME, AmountType.class, OrderType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "HandlingCost", scope = OrderType.class)
    public JAXBElement<AmountType> createOrderTypeHandlingCost(AmountType value) {
        return new JAXBElement<AmountType>(_OrderTypeHandlingCost_QNAME, AmountType.class, OrderType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Total", scope = OrderType.class)
    public JAXBElement<AmountType> createOrderTypeTotal(AmountType value) {
        return new JAXBElement<AmountType>(_OrderTypeTotal_QNAME, AmountType.class, OrderType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ShippingCost", scope = OrderType.class)
    public JAXBElement<AmountType> createOrderTypeShippingCost(AmountType value) {
        return new JAXBElement<AmountType>(_OrderTypeShippingCost_QNAME, AmountType.class, OrderType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderSupplierListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Suppliers", scope = OrderType.class)
    public JAXBElement<OrderSupplierListType> createOrderTypeSuppliers(OrderSupplierListType value) {
        return new JAXBElement<OrderSupplierListType>(_OrderTypeSuppliers_QNAME, OrderSupplierListType.class, OrderType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ShippingMethod", scope = OrderType.class)
    public JAXBElement<String> createOrderTypeShippingMethod(String value) {
        return new JAXBElement<String>(_OrderTypeShippingMethod_QNAME, String.class, OrderType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "OrderId", scope = OrderType.class)
    public JAXBElement<String> createOrderTypeOrderId(String value) {
        return new JAXBElement<String>(_OrderTypeOrderId_QNAME, String.class, OrderType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderCustomerType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Customer", scope = OrderType.class)
    public JAXBElement<OrderCustomerType> createOrderTypeCustomer(OrderCustomerType value) {
        return new JAXBElement<OrderCustomerType>(_OrderTypeCustomer_QNAME, OrderCustomerType.class, OrderType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ShippingInfo", scope = OrderType.class)
    public JAXBElement<AddressType> createOrderTypeShippingInfo(AddressType value) {
        return new JAXBElement<AddressType>(_OrderTypeShippingInfo_QNAME, AddressType.class, OrderType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderDiscountListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Discounts", scope = OrderType.class)
    public JAXBElement<OrderDiscountListType> createOrderTypeDiscounts(OrderDiscountListType value) {
        return new JAXBElement<OrderDiscountListType>(_OrderTypeDiscounts_QNAME, OrderDiscountListType.class, OrderType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "DateCreated", scope = OrderType.class)
    public JAXBElement<String> createOrderTypeDateCreated(String value) {
        return new JAXBElement<String>(_OrderTypeDateCreated_QNAME, String.class, OrderType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "FullName", scope = OrderCustomerType.class)
    public JAXBElement<String> createOrderCustomerTypeFullName(String value) {
        return new JAXBElement<String>(_OrderCustomerTypeFullName_QNAME, String.class, OrderCustomerType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ContactPhoneNumber", scope = OrderCustomerType.class)
    public JAXBElement<String> createOrderCustomerTypeContactPhoneNumber(String value) {
        return new JAXBElement<String>(_OrderCustomerTypeContactPhoneNumber_QNAME, String.class, OrderCustomerType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "EmailAddress", scope = OrderCustomerType.class)
    public JAXBElement<String> createOrderCustomerTypeEmailAddress(String value) {
        return new JAXBElement<String>(_OrderCustomerTypeEmailAddress_QNAME, String.class, OrderCustomerType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InventoryItemListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Items", scope = GetInventoryItemsResponseType.class)
    public JAXBElement<InventoryItemListType> createGetInventoryItemsResponseTypeItems(InventoryItemListType value) {
        return new JAXBElement<InventoryItemListType>(_GetInventoryItemsResponseTypeItems_QNAME, InventoryItemListType.class, GetInventoryItemsResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "NumFound", scope = GetInventoryItemsResponseType.class)
    public JAXBElement<Integer> createGetInventoryItemsResponseTypeNumFound(Integer value) {
        return new JAXBElement<Integer>(_GetInventoryItemsResponseTypeNumFound_QNAME, Integer.class, GetInventoryItemsResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "MessageID", scope = BaseRequestType.class)
    public JAXBElement<String> createBaseRequestTypeMessageID(String value) {
        return new JAXBElement<String>(_BaseRequestTypeMessageID_QNAME, String.class, BaseRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "OutputSelector", scope = BaseRequestType.class)
    public JAXBElement<String> createBaseRequestTypeOutputSelector(String value) {
        return new JAXBElement<String>(_BaseRequestTypeOutputSelector_QNAME, String.class, BaseRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Name", scope = OrderDiscountType.class)
    public JAXBElement<String> createOrderDiscountTypeName(String value) {
        return new JAXBElement<String>(_AddressTypeName_QNAME, String.class, OrderDiscountType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Amount", scope = OrderDiscountType.class)
    public JAXBElement<AmountType> createOrderDiscountTypeAmount(AmountType value) {
        return new JAXBElement<AmountType>(_AmountTypeAmount_QNAME, AmountType.class, OrderDiscountType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Code", scope = OrderDiscountType.class)
    public JAXBElement<String> createOrderDiscountTypeCode(String value) {
        return new JAXBElement<String>(_OrderDiscountTypeCode_QNAME, String.class, OrderDiscountType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Message", scope = ErrorType.class)
    public JAXBElement<String> createErrorTypeMessage(String value) {
        return new JAXBElement<String>(_ErrorTypeMessage_QNAME, String.class, ErrorType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ErrorCode", scope = ErrorType.class)
    public JAXBElement<String> createErrorTypeErrorCode(String value) {
        return new JAXBElement<String>(_ErrorTypeErrorCode_QNAME, String.class, ErrorType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorParametersCollectionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ErrorParameters", scope = ErrorType.class)
    public JAXBElement<ErrorParametersCollectionType> createErrorTypeErrorParameters(ErrorParametersCollectionType value) {
        return new JAXBElement<ErrorParametersCollectionType>(_ErrorTypeErrorParameters_QNAME, ErrorParametersCollectionType.class, ErrorType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderCartType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Cart", scope = PlaceOrderRequestType.class)
    public JAXBElement<OrderCartType> createPlaceOrderRequestTypeCart(OrderCartType value) {
        return new JAXBElement<OrderCartType>(_PlaceOrderRequestTypeCart_QNAME, OrderCartType.class, PlaceOrderRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "OrderIndex", scope = InventoryCategoryType.class)
    public JAXBElement<Integer> createInventoryCategoryTypeOrderIndex(Integer value) {
        return new JAXBElement<Integer>(_InventoryCategoryTypeOrderIndex_QNAME, Integer.class, InventoryCategoryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Name", scope = InventoryCategoryType.class)
    public JAXBElement<String> createInventoryCategoryTypeName(String value) {
        return new JAXBElement<String>(_AddressTypeName_QNAME, String.class, InventoryCategoryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Enabled", scope = InventoryCategoryType.class)
    public JAXBElement<Boolean> createInventoryCategoryTypeEnabled(Boolean value) {
        return new JAXBElement<Boolean>(_InventoryCategoryTypeEnabled_QNAME, Boolean.class, InventoryCategoryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "CategoryId", scope = InventoryCategoryType.class)
    public JAXBElement<String> createInventoryCategoryTypeCategoryId(String value) {
        return new JAXBElement<String>(_GetInventoryItemsRequestTypeCategoryId_QNAME, String.class, InventoryCategoryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoryIdListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Lineage", scope = InventoryCategoryType.class)
    public JAXBElement<CategoryIdListType> createInventoryCategoryTypeLineage(CategoryIdListType value) {
        return new JAXBElement<CategoryIdListType>(_InventoryCategoryTypeLineage_QNAME, CategoryIdListType.class, InventoryCategoryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "UrlName", scope = InventoryCategoryType.class)
    public JAXBElement<String> createInventoryCategoryTypeUrlName(String value) {
        return new JAXBElement<String>(_InventoryCategoryTypeUrlName_QNAME, String.class, InventoryCategoryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Description", scope = OrderTaxType.class)
    public JAXBElement<String> createOrderTaxTypeDescription(String value) {
        return new JAXBElement<String>(_OrderTaxTypeDescription_QNAME, String.class, OrderTaxType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "TaxAmount", scope = OrderTaxType.class)
    public JAXBElement<AmountType> createOrderTaxTypeTaxAmount(AmountType value) {
        return new JAXBElement<AmountType>(_OrderTaxTypeTaxAmount_QNAME, AmountType.class, OrderTaxType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "DateShipped", scope = OrderSupplierType.class)
    public JAXBElement<String> createOrderSupplierTypeDateShipped(String value) {
        return new JAXBElement<String>(_OrderSupplierTypeDateShipped_QNAME, String.class, OrderSupplierType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "TrackingNumber", scope = OrderSupplierType.class)
    public JAXBElement<String> createOrderSupplierTypeTrackingNumber(String value) {
        return new JAXBElement<String>(_OrderSupplierTypeTrackingNumber_QNAME, String.class, OrderSupplierType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "TrackingUrl", scope = OrderSupplierType.class)
    public JAXBElement<String> createOrderSupplierTypeTrackingUrl(String value) {
        return new JAXBElement<String>(_OrderSupplierTypeTrackingUrl_QNAME, String.class, OrderSupplierType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Name", scope = OrderSupplierType.class)
    public JAXBElement<String> createOrderSupplierTypeName(String value) {
        return new JAXBElement<String>(_AddressTypeName_QNAME, String.class, OrderSupplierType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Status", scope = OrderSupplierType.class)
    public JAXBElement<String> createOrderSupplierTypeStatus(String value) {
        return new JAXBElement<String>(_OrderTypeStatus_QNAME, String.class, OrderSupplierType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ShippingCarrier", scope = OrderSupplierType.class)
    public JAXBElement<String> createOrderSupplierTypeShippingCarrier(String value) {
        return new JAXBElement<String>(_OrderSupplierTypeShippingCarrier_QNAME, String.class, OrderSupplierType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderItemListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Products", scope = OrderSupplierType.class)
    public JAXBElement<OrderItemListType> createOrderSupplierTypeProducts(OrderItemListType value) {
        return new JAXBElement<OrderItemListType>(_OrderSupplierTypeProducts_QNAME, OrderItemListType.class, OrderSupplierType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "HandlingFee", scope = OrderSupplierType.class)
    public JAXBElement<AmountType> createOrderSupplierTypeHandlingFee(AmountType value) {
        return new JAXBElement<AmountType>(_OrderSupplierTypeHandlingFee_QNAME, AmountType.class, OrderSupplierType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ShippingCost", scope = OrderSupplierType.class)
    public JAXBElement<AmountType> createOrderSupplierTypeShippingCost(AmountType value) {
        return new JAXBElement<AmountType>(_OrderTypeShippingCost_QNAME, AmountType.class, OrderSupplierType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "PageSize", scope = GetInventoryCategoriesRequestType.class)
    public JAXBElement<Integer> createGetInventoryCategoriesRequestTypePageSize(Integer value) {
        return new JAXBElement<Integer>(_GetInventoryItemsRequestTypePageSize_QNAME, Integer.class, GetInventoryCategoriesRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ParentCategoryId", scope = GetInventoryCategoriesRequestType.class)
    public JAXBElement<String> createGetInventoryCategoriesRequestTypeParentCategoryId(String value) {
        return new JAXBElement<String>(_GetInventoryCategoriesRequestTypeParentCategoryId_QNAME, String.class, GetInventoryCategoriesRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "PageIndex", scope = GetInventoryCategoriesRequestType.class)
    public JAXBElement<Integer> createGetInventoryCategoriesRequestTypePageIndex(Integer value) {
        return new JAXBElement<Integer>(_GetInventoryItemsRequestTypePageIndex_QNAME, Integer.class, GetInventoryCategoriesRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "RootCategoryId", scope = GetInventoryCategoriesRequestType.class)
    public JAXBElement<String> createGetInventoryCategoriesRequestTypeRootCategoryId(String value) {
        return new JAXBElement<String>(_GetInventoryCategoriesRequestTypeRootCategoryId_QNAME, String.class, GetInventoryCategoriesRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "UserId", scope = GetUserInfoResponseType.class)
    public JAXBElement<String> createGetUserInfoResponseTypeUserId(String value) {
        return new JAXBElement<String>(_GetUserInfoResponseTypeUserId_QNAME, String.class, GetUserInfoResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "MessageID", scope = BaseResponseType.class)
    public JAXBElement<String> createBaseResponseTypeMessageID(String value) {
        return new JAXBElement<String>(_BaseRequestTypeMessageID_QNAME, String.class, BaseResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Build", scope = BaseResponseType.class)
    public JAXBElement<String> createBaseResponseTypeBuild(String value) {
        return new JAXBElement<String>(_BaseResponseTypeBuild_QNAME, String.class, BaseResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorCollectionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Errors", scope = BaseResponseType.class)
    public JAXBElement<ErrorCollectionType> createBaseResponseTypeErrors(ErrorCollectionType value) {
        return new JAXBElement<ErrorCollectionType>(_BaseResponseTypeErrors_QNAME, ErrorCollectionType.class, BaseResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Version", scope = BaseResponseType.class)
    public JAXBElement<String> createBaseResponseTypeVersion(String value) {
        return new JAXBElement<String>(_Version_QNAME, String.class, BaseResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Timestamp", scope = BaseResponseType.class)
    public JAXBElement<String> createBaseResponseTypeTimestamp(String value) {
        return new JAXBElement<String>(_BaseResponseTypeTimestamp_QNAME, String.class, BaseResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "AccessExpirationDate", scope = BaseResponseType.class)
    public JAXBElement<String> createBaseResponseTypeAccessExpirationDate(String value) {
        return new JAXBElement<String>(_BaseResponseTypeAccessExpirationDate_QNAME, String.class, BaseResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderCartType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Cart", scope = VerifyPlaceOrderRequestType.class)
    public JAXBElement<OrderCartType> createVerifyPlaceOrderRequestTypeCart(OrderCartType value) {
        return new JAXBElement<OrderCartType>(_PlaceOrderRequestTypeCart_QNAME, OrderCartType.class, VerifyPlaceOrderRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ThumbUrl", scope = ItemImageType.class)
    public JAXBElement<String> createItemImageTypeThumbUrl(String value) {
        return new JAXBElement<String>(_ItemImageTypeThumbUrl_QNAME, String.class, ItemImageType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "LargeUrl", scope = ItemImageType.class)
    public JAXBElement<String> createItemImageTypeLargeUrl(String value) {
        return new JAXBElement<String>(_ItemImageTypeLargeUrl_QNAME, String.class, ItemImageType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "DetailUrl", scope = ItemImageType.class)
    public JAXBElement<String> createItemImageTypeDetailUrl(String value) {
        return new JAXBElement<String>(_ItemImageTypeDetailUrl_QNAME, String.class, ItemImageType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ImageNumber", scope = ItemImageType.class)
    public JAXBElement<Integer> createItemImageTypeImageNumber(Integer value) {
        return new JAXBElement<Integer>(_ItemImageTypeImageNumber_QNAME, Integer.class, ItemImageType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemWeightType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Weight", scope = InventoryItemType.class)
    public JAXBElement<ItemWeightType> createInventoryItemTypeWeight(ItemWeightType value) {
        return new JAXBElement<ItemWeightType>(_InventoryItemTypeWeight_QNAME, ItemWeightType.class, InventoryItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "IsStoreVisible", scope = InventoryItemType.class)
    public JAXBElement<Boolean> createInventoryItemTypeIsStoreVisible(Boolean value) {
        return new JAXBElement<Boolean>(_InventoryItemTypeIsStoreVisible_QNAME, Boolean.class, InventoryItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "StoreUrl", scope = InventoryItemType.class)
    public JAXBElement<String> createInventoryItemTypeStoreUrl(String value) {
        return new JAXBElement<String>(_InventoryItemTypeStoreUrl_QNAME, String.class, InventoryItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Name", scope = InventoryItemType.class)
    public JAXBElement<String> createInventoryItemTypeName(String value) {
        return new JAXBElement<String>(_AddressTypeName_QNAME, String.class, InventoryItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ShortDescription", scope = InventoryItemType.class)
    public JAXBElement<String> createInventoryItemTypeShortDescription(String value) {
        return new JAXBElement<String>(_InventoryItemTypeShortDescription_QNAME, String.class, InventoryItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "LongDescription", scope = InventoryItemType.class)
    public JAXBElement<String> createInventoryItemTypeLongDescription(String value) {
        return new JAXBElement<String>(_InventoryItemTypeLongDescription_QNAME, String.class, InventoryItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "CanPurchase", scope = InventoryItemType.class)
    public JAXBElement<Boolean> createInventoryItemTypeCanPurchase(Boolean value) {
        return new JAXBElement<Boolean>(_InventoryItemTypeCanPurchase_QNAME, Boolean.class, InventoryItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "SupplierId", scope = InventoryItemType.class)
    public JAXBElement<String> createInventoryItemTypeSupplierId(String value) {
        return new JAXBElement<String>(_GetInventoryItemsRequestTypeSupplierId_QNAME, String.class, InventoryItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "WarehouseId", scope = InventoryItemType.class)
    public JAXBElement<String> createInventoryItemTypeWarehouseId(String value) {
        return new JAXBElement<String>(_InventoryItemTypeWarehouseId_QNAME, String.class, InventoryItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ItemId", scope = InventoryItemType.class)
    public JAXBElement<String> createInventoryItemTypeItemId(String value) {
        return new JAXBElement<String>(_OrderCartItemTypeItemId_QNAME, String.class, InventoryItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InventoryItemPricingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Pricing", scope = InventoryItemType.class)
    public JAXBElement<InventoryItemPricingType> createInventoryItemTypePricing(InventoryItemPricingType value) {
        return new JAXBElement<InventoryItemPricingType>(_InventoryItemTypePricing_QNAME, InventoryItemPricingType.class, InventoryItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Quantity", scope = InventoryItemType.class)
    public JAXBElement<Integer> createInventoryItemTypeQuantity(Integer value) {
        return new JAXBElement<Integer>(_OrderCartItemTypeQuantity_QNAME, Integer.class, InventoryItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Sku", scope = InventoryItemType.class)
    public JAXBElement<String> createInventoryItemTypeSku(String value) {
        return new JAXBElement<String>(_InventoryItemTypeSku_QNAME, String.class, InventoryItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoryIdListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Categories", scope = InventoryItemType.class)
    public JAXBElement<CategoryIdListType> createInventoryItemTypeCategories(CategoryIdListType value) {
        return new JAXBElement<CategoryIdListType>(_InventoryItemTypeCategories_QNAME, CategoryIdListType.class, InventoryItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemImageListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Images", scope = InventoryItemType.class)
    public JAXBElement<ItemImageListType> createInventoryItemTypeImages(ItemImageListType value) {
        return new JAXBElement<ItemImageListType>(_InventoryItemTypeImages_QNAME, ItemImageListType.class, InventoryItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Name", scope = OrderItemType.class)
    public JAXBElement<String> createOrderItemTypeName(String value) {
        return new JAXBElement<String>(_AddressTypeName_QNAME, String.class, OrderItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ItemId", scope = OrderItemType.class)
    public JAXBElement<String> createOrderItemTypeItemId(String value) {
        return new JAXBElement<String>(_OrderCartItemTypeItemId_QNAME, String.class, OrderItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "OriginalUnitPrice", scope = OrderItemType.class)
    public JAXBElement<AmountType> createOrderItemTypeOriginalUnitPrice(AmountType value) {
        return new JAXBElement<AmountType>(_OrderItemTypeOriginalUnitPrice_QNAME, AmountType.class, OrderItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Sku", scope = OrderItemType.class)
    public JAXBElement<String> createOrderItemTypeSku(String value) {
        return new JAXBElement<String>(_InventoryItemTypeSku_QNAME, String.class, OrderItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "UnitPrice", scope = OrderItemType.class)
    public JAXBElement<AmountType> createOrderItemTypeUnitPrice(AmountType value) {
        return new JAXBElement<AmountType>(_OrderItemTypeUnitPrice_QNAME, AmountType.class, OrderItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ShippingMethod", scope = OrderCartType.class)
    public JAXBElement<String> createOrderCartTypeShippingMethod(String value) {
        return new JAXBElement<String>(_OrderTypeShippingMethod_QNAME, String.class, OrderCartType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BillingInfoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "BillingInfo", scope = OrderCartType.class)
    public JAXBElement<BillingInfoType> createOrderCartTypeBillingInfo(BillingInfoType value) {
        return new JAXBElement<BillingInfoType>(_OrderTypeBillingInfo_QNAME, BillingInfoType.class, OrderCartType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderCartItemListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Items", scope = OrderCartType.class)
    public JAXBElement<OrderCartItemListType> createOrderCartTypeItems(OrderCartItemListType value) {
        return new JAXBElement<OrderCartItemListType>(_GetInventoryItemsResponseTypeItems_QNAME, OrderCartItemListType.class, OrderCartType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "ShippingInfo", scope = OrderCartType.class)
    public JAXBElement<AddressType> createOrderCartTypeShippingInfo(AddressType value) {
        return new JAXBElement<AddressType>(_OrderTypeShippingInfo_QNAME, AddressType.class, OrderCartType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderCustomerType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Customer", scope = OrderCartType.class)
    public JAXBElement<OrderCustomerType> createOrderCartTypeCustomer(OrderCustomerType value) {
        return new JAXBElement<OrderCustomerType>(_OrderTypeCustomer_QNAME, OrderCustomerType.class, OrderCartType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "NumFound", scope = GetOrdersResponseType.class)
    public JAXBElement<Integer> createGetOrdersResponseTypeNumFound(Integer value) {
        return new JAXBElement<Integer>(_GetInventoryItemsResponseTypeNumFound_QNAME, Integer.class, GetOrdersResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Orders", scope = GetOrdersResponseType.class)
    public JAXBElement<OrderListType> createGetOrdersResponseTypeOrders(OrderListType value) {
        return new JAXBElement<OrderListType>(_GetOrdersResponseTypeOrders_QNAME, OrderListType.class, GetOrdersResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InventoryCategoryListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "Categories", scope = GetInventoryCategoriesResponseType.class)
    public JAXBElement<InventoryCategoryListType> createGetInventoryCategoriesResponseTypeCategories(InventoryCategoryListType value) {
        return new JAXBElement<InventoryCategoryListType>(_InventoryItemTypeCategories_QNAME, InventoryCategoryListType.class, GetInventoryCategoriesResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "NumFound", scope = GetInventoryCategoriesResponseType.class)
    public JAXBElement<Integer> createGetInventoryCategoriesResponseTypeNumFound(Integer value) {
        return new JAXBElement<Integer>(_GetInventoryItemsResponseTypeNumFound_QNAME, Integer.class, GetInventoryCategoriesResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:shopster:apis:main", name = "NewOrderId", scope = PlaceOrderResponseType.class)
    public JAXBElement<String> createPlaceOrderResponseTypeNewOrderId(String value) {
        return new JAXBElement<String>(_PlaceOrderResponseTypeNewOrderId_QNAME, String.class, PlaceOrderResponseType.class, value);
    }

}
