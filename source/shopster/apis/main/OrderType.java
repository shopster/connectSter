
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
 *             Type containing information on a main order.
 *             &lt;/summary&gt;
 * </pre>
 * 
 * 
 * <p>Java class for OrderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrderId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateCreated" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Customer" type="{urn:shopster:apis:main}OrderCustomerType" minOccurs="0"/>
 *         &lt;element name="BillingInfo" type="{urn:shopster:apis:main}BillingInfoType" minOccurs="0"/>
 *         &lt;element name="ShippingInfo" type="{urn:shopster:apis:main}AddressType" minOccurs="0"/>
 *         &lt;element name="ShippingMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Suppliers" type="{urn:shopster:apis:main}OrderSupplierListType" minOccurs="0"/>
 *         &lt;element name="Discounts" type="{urn:shopster:apis:main}OrderDiscountListType" minOccurs="0"/>
 *         &lt;element name="SubTotal" type="{urn:shopster:apis:main}AmountType" minOccurs="0"/>
 *         &lt;element name="ShippingCost" type="{urn:shopster:apis:main}AmountType" minOccurs="0"/>
 *         &lt;element name="HandlingCost" type="{urn:shopster:apis:main}AmountType" minOccurs="0"/>
 *         &lt;element name="Taxes" type="{urn:shopster:apis:main}OrderTaxListType" minOccurs="0"/>
 *         &lt;element name="Total" type="{urn:shopster:apis:main}AmountType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderType", propOrder = {
    "orderId",
    "dateCreated",
    "customer",
    "billingInfo",
    "shippingInfo",
    "shippingMethod",
    "status",
    "suppliers",
    "discounts",
    "subTotal",
    "shippingCost",
    "handlingCost",
    "taxes",
    "total"
})
public class OrderType {

    @XmlElementRef(name = "OrderId", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> orderId;
    @XmlElementRef(name = "DateCreated", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> dateCreated;
    @XmlElementRef(name = "Customer", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<OrderCustomerType> customer;
    @XmlElementRef(name = "BillingInfo", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<BillingInfoType> billingInfo;
    @XmlElementRef(name = "ShippingInfo", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<AddressType> shippingInfo;
    @XmlElementRef(name = "ShippingMethod", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> shippingMethod;
    @XmlElementRef(name = "Status", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> status;
    @XmlElementRef(name = "Suppliers", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<OrderSupplierListType> suppliers;
    @XmlElementRef(name = "Discounts", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<OrderDiscountListType> discounts;
    @XmlElementRef(name = "SubTotal", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<AmountType> subTotal;
    @XmlElementRef(name = "ShippingCost", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<AmountType> shippingCost;
    @XmlElementRef(name = "HandlingCost", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<AmountType> handlingCost;
    @XmlElementRef(name = "Taxes", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<OrderTaxListType> taxes;
    @XmlElementRef(name = "Total", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<AmountType> total;

    /**
     * Gets the value of the orderId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderId() {
        return orderId;
    }

    /**
     * Sets the value of the orderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderId(JAXBElement<String> value) {
        this.orderId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the dateCreated property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets the value of the dateCreated property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDateCreated(JAXBElement<String> value) {
        this.dateCreated = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OrderCustomerType }{@code >}
     *     
     */
    public JAXBElement<OrderCustomerType> getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OrderCustomerType }{@code >}
     *     
     */
    public void setCustomer(JAXBElement<OrderCustomerType> value) {
        this.customer = ((JAXBElement<OrderCustomerType> ) value);
    }

    /**
     * Gets the value of the billingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BillingInfoType }{@code >}
     *     
     */
    public JAXBElement<BillingInfoType> getBillingInfo() {
        return billingInfo;
    }

    /**
     * Sets the value of the billingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BillingInfoType }{@code >}
     *     
     */
    public void setBillingInfo(JAXBElement<BillingInfoType> value) {
        this.billingInfo = ((JAXBElement<BillingInfoType> ) value);
    }

    /**
     * Gets the value of the shippingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AddressType }{@code >}
     *     
     */
    public JAXBElement<AddressType> getShippingInfo() {
        return shippingInfo;
    }

    /**
     * Sets the value of the shippingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AddressType }{@code >}
     *     
     */
    public void setShippingInfo(JAXBElement<AddressType> value) {
        this.shippingInfo = ((JAXBElement<AddressType> ) value);
    }

    /**
     * Gets the value of the shippingMethod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShippingMethod() {
        return shippingMethod;
    }

    /**
     * Sets the value of the shippingMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShippingMethod(JAXBElement<String> value) {
        this.shippingMethod = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatus(JAXBElement<String> value) {
        this.status = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the suppliers property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OrderSupplierListType }{@code >}
     *     
     */
    public JAXBElement<OrderSupplierListType> getSuppliers() {
        return suppliers;
    }

    /**
     * Sets the value of the suppliers property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OrderSupplierListType }{@code >}
     *     
     */
    public void setSuppliers(JAXBElement<OrderSupplierListType> value) {
        this.suppliers = ((JAXBElement<OrderSupplierListType> ) value);
    }

    /**
     * Gets the value of the discounts property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OrderDiscountListType }{@code >}
     *     
     */
    public JAXBElement<OrderDiscountListType> getDiscounts() {
        return discounts;
    }

    /**
     * Sets the value of the discounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OrderDiscountListType }{@code >}
     *     
     */
    public void setDiscounts(JAXBElement<OrderDiscountListType> value) {
        this.discounts = ((JAXBElement<OrderDiscountListType> ) value);
    }

    /**
     * Gets the value of the subTotal property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getSubTotal() {
        return subTotal;
    }

    /**
     * Sets the value of the subTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setSubTotal(JAXBElement<AmountType> value) {
        this.subTotal = ((JAXBElement<AmountType> ) value);
    }

    /**
     * Gets the value of the shippingCost property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getShippingCost() {
        return shippingCost;
    }

    /**
     * Sets the value of the shippingCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setShippingCost(JAXBElement<AmountType> value) {
        this.shippingCost = ((JAXBElement<AmountType> ) value);
    }

    /**
     * Gets the value of the handlingCost property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getHandlingCost() {
        return handlingCost;
    }

    /**
     * Sets the value of the handlingCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setHandlingCost(JAXBElement<AmountType> value) {
        this.handlingCost = ((JAXBElement<AmountType> ) value);
    }

    /**
     * Gets the value of the taxes property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OrderTaxListType }{@code >}
     *     
     */
    public JAXBElement<OrderTaxListType> getTaxes() {
        return taxes;
    }

    /**
     * Sets the value of the taxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OrderTaxListType }{@code >}
     *     
     */
    public void setTaxes(JAXBElement<OrderTaxListType> value) {
        this.taxes = ((JAXBElement<OrderTaxListType> ) value);
    }

    /**
     * Gets the value of the total property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setTotal(JAXBElement<AmountType> value) {
        this.total = ((JAXBElement<AmountType> ) value);
    }

}
