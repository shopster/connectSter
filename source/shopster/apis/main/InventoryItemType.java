
package shopster.apis.main;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns:msc="http://schemas.microsoft.com/ws/2005/12/wsdl/contract" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" xmlns:tns="urn:shopster:apis:main" xmlns:wsa="http://schemas.xmlsoap.org/ws/2004/08/addressing" xmlns:wsa10="http://www.w3.org/2005/08/addressing" xmlns:wsam="http://www.w3.org/2007/05/addressing/metadata" xmlns:wsap="http://schemas.xmlsoap.org/ws/2004/08/addressing/policy" xmlns:wsaw="http://www.w3.org/2006/05/addressing/wsdl" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns:wsp="http://schemas.xmlsoap.org/ws/2004/09/policy" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" xmlns:wsx="http://schemas.xmlsoap.org/ws/2004/09/mex" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;
 *             Represents one item in a merchant's inventory.
 *             &lt;/summary&gt;
 * </pre>
 * 
 * 
 * <p>Java class for InventoryItemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InventoryItemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ItemId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="IsStoreVisible" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShortDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LongDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SupplierId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WarehouseId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sku" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Categories" type="{urn:shopster:apis:main}CategoryIdListType" minOccurs="0"/>
 *         &lt;element name="StoreUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Images" type="{urn:shopster:apis:main}ItemImageListType" minOccurs="0"/>
 *         &lt;element name="Pricing" type="{urn:shopster:apis:main}InventoryItemPricingType" minOccurs="0"/>
 *         &lt;element name="Weight" type="{urn:shopster:apis:main}ItemWeightType" minOccurs="0"/>
 *         &lt;element name="CanPurchase" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InventoryItemType", propOrder = {
    "itemId",
    "quantity",
    "isStoreVisible",
    "name",
    "shortDescription",
    "longDescription",
    "supplierId",
    "warehouseId",
    "sku",
    "categories",
    "storeUrl",
    "images",
    "pricing",
    "weight",
    "canPurchase"
})
public class InventoryItemType {

    @XmlElementRef(name = "ItemId", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> itemId;
    @XmlElementRef(name = "Quantity", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<Integer> quantity;
    @XmlElementRef(name = "IsStoreVisible", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<Boolean> isStoreVisible;
    @XmlElementRef(name = "Name", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> name;
    @XmlElementRef(name = "ShortDescription", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> shortDescription;
    @XmlElementRef(name = "LongDescription", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> longDescription;
    @XmlElementRef(name = "SupplierId", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> supplierId;
    @XmlElementRef(name = "WarehouseId", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> warehouseId;
    @XmlElementRef(name = "Sku", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> sku;
    @XmlElementRef(name = "Categories", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<CategoryIdListType> categories;
    @XmlElementRef(name = "StoreUrl", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> storeUrl;
    @XmlElementRef(name = "Images", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<ItemImageListType> images;
    @XmlElementRef(name = "Pricing", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<InventoryItemPricingType> pricing;
    @XmlElementRef(name = "Weight", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<ItemWeightType> weight;
    @XmlElementRef(name = "CanPurchase", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<Boolean> canPurchase;

    /**
     * Gets the value of the itemId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getItemId() {
        return itemId;
    }

    /**
     * Sets the value of the itemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setItemId(JAXBElement<String> value) {
        this.itemId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setQuantity(JAXBElement<Integer> value) {
        this.quantity = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the isStoreVisible property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getIsStoreVisible() {
        return isStoreVisible;
    }

    /**
     * Sets the value of the isStoreVisible property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setIsStoreVisible(JAXBElement<Boolean> value) {
        this.isStoreVisible = ((JAXBElement<Boolean> ) value);
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setName(JAXBElement<String> value) {
        this.name = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the shortDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShortDescription() {
        return shortDescription;
    }

    /**
     * Sets the value of the shortDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShortDescription(JAXBElement<String> value) {
        this.shortDescription = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the longDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLongDescription() {
        return longDescription;
    }

    /**
     * Sets the value of the longDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLongDescription(JAXBElement<String> value) {
        this.longDescription = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the supplierId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSupplierId() {
        return supplierId;
    }

    /**
     * Sets the value of the supplierId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSupplierId(JAXBElement<String> value) {
        this.supplierId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the warehouseId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWarehouseId() {
        return warehouseId;
    }

    /**
     * Sets the value of the warehouseId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWarehouseId(JAXBElement<String> value) {
        this.warehouseId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the sku property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSku() {
        return sku;
    }

    /**
     * Sets the value of the sku property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSku(JAXBElement<String> value) {
        this.sku = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the categories property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CategoryIdListType }{@code >}
     *     
     */
    public JAXBElement<CategoryIdListType> getCategories() {
        return categories;
    }

    /**
     * Sets the value of the categories property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CategoryIdListType }{@code >}
     *     
     */
    public void setCategories(JAXBElement<CategoryIdListType> value) {
        this.categories = ((JAXBElement<CategoryIdListType> ) value);
    }

    /**
     * Gets the value of the storeUrl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStoreUrl() {
        return storeUrl;
    }

    /**
     * Sets the value of the storeUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStoreUrl(JAXBElement<String> value) {
        this.storeUrl = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the images property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ItemImageListType }{@code >}
     *     
     */
    public JAXBElement<ItemImageListType> getImages() {
        return images;
    }

    /**
     * Sets the value of the images property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ItemImageListType }{@code >}
     *     
     */
    public void setImages(JAXBElement<ItemImageListType> value) {
        this.images = ((JAXBElement<ItemImageListType> ) value);
    }

    /**
     * Gets the value of the pricing property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link InventoryItemPricingType }{@code >}
     *     
     */
    public JAXBElement<InventoryItemPricingType> getPricing() {
        return pricing;
    }

    /**
     * Sets the value of the pricing property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link InventoryItemPricingType }{@code >}
     *     
     */
    public void setPricing(JAXBElement<InventoryItemPricingType> value) {
        this.pricing = ((JAXBElement<InventoryItemPricingType> ) value);
    }

    /**
     * Gets the value of the weight property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ItemWeightType }{@code >}
     *     
     */
    public JAXBElement<ItemWeightType> getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ItemWeightType }{@code >}
     *     
     */
    public void setWeight(JAXBElement<ItemWeightType> value) {
        this.weight = ((JAXBElement<ItemWeightType> ) value);
    }

    /**
     * Gets the value of the canPurchase property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getCanPurchase() {
        return canPurchase;
    }

    /**
     * Sets the value of the canPurchase property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setCanPurchase(JAXBElement<Boolean> value) {
        this.canPurchase = ((JAXBElement<Boolean> ) value);
    }

}
