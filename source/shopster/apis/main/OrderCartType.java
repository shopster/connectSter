
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
 *             Type containing data used to place a new order.
 *             &lt;/summary&gt;
 * </pre>
 * 
 * 
 * <p>Java class for OrderCartType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderCartType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Customer" type="{urn:shopster:apis:main}OrderCustomerType" minOccurs="0"/>
 *         &lt;element name="BillingInfo" type="{urn:shopster:apis:main}BillingInfoType" minOccurs="0"/>
 *         &lt;element name="ShippingInfo" type="{urn:shopster:apis:main}AddressType" minOccurs="0"/>
 *         &lt;element name="ShippingMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Items" type="{urn:shopster:apis:main}OrderCartItemListType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderCartType", propOrder = {
    "customer",
    "billingInfo",
    "shippingInfo",
    "shippingMethod",
    "items"
})
public class OrderCartType {

    @XmlElementRef(name = "Customer", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<OrderCustomerType> customer;
    @XmlElementRef(name = "BillingInfo", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<BillingInfoType> billingInfo;
    @XmlElementRef(name = "ShippingInfo", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<AddressType> shippingInfo;
    @XmlElementRef(name = "ShippingMethod", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> shippingMethod;
    @XmlElementRef(name = "Items", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<OrderCartItemListType> items;

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
     * Gets the value of the items property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OrderCartItemListType }{@code >}
     *     
     */
    public JAXBElement<OrderCartItemListType> getItems() {
        return items;
    }

    /**
     * Sets the value of the items property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OrderCartItemListType }{@code >}
     *     
     */
    public void setItems(JAXBElement<OrderCartItemListType> value) {
        this.items = ((JAXBElement<OrderCartItemListType> ) value);
    }

}
