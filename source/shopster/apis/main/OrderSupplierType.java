
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
 *             Type containing order information specific to a supplier
 *             including products.
 *             &lt;/summary&gt;
 * </pre>
 * 
 * 
 * <p>Java class for OrderSupplierType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderSupplierType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Products" type="{urn:shopster:apis:main}OrderItemListType" minOccurs="0"/>
 *         &lt;element name="ShippingCost" type="{urn:shopster:apis:main}AmountType" minOccurs="0"/>
 *         &lt;element name="HandlingFee" type="{urn:shopster:apis:main}AmountType" minOccurs="0"/>
 *         &lt;element name="DateShipped" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShippingCarrier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TrackingUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TrackingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderSupplierType", propOrder = {
    "name",
    "status",
    "products",
    "shippingCost",
    "handlingFee",
    "dateShipped",
    "shippingCarrier",
    "trackingUrl",
    "trackingNumber"
})
public class OrderSupplierType {

    @XmlElementRef(name = "Name", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> name;
    @XmlElementRef(name = "Status", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> status;
    @XmlElementRef(name = "Products", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<OrderItemListType> products;
    @XmlElementRef(name = "ShippingCost", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<AmountType> shippingCost;
    @XmlElementRef(name = "HandlingFee", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<AmountType> handlingFee;
    @XmlElementRef(name = "DateShipped", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> dateShipped;
    @XmlElementRef(name = "ShippingCarrier", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> shippingCarrier;
    @XmlElementRef(name = "TrackingUrl", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> trackingUrl;
    @XmlElementRef(name = "TrackingNumber", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> trackingNumber;

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
     * Gets the value of the products property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OrderItemListType }{@code >}
     *     
     */
    public JAXBElement<OrderItemListType> getProducts() {
        return products;
    }

    /**
     * Sets the value of the products property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OrderItemListType }{@code >}
     *     
     */
    public void setProducts(JAXBElement<OrderItemListType> value) {
        this.products = ((JAXBElement<OrderItemListType> ) value);
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
     * Gets the value of the handlingFee property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getHandlingFee() {
        return handlingFee;
    }

    /**
     * Sets the value of the handlingFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setHandlingFee(JAXBElement<AmountType> value) {
        this.handlingFee = ((JAXBElement<AmountType> ) value);
    }

    /**
     * Gets the value of the dateShipped property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDateShipped() {
        return dateShipped;
    }

    /**
     * Sets the value of the dateShipped property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDateShipped(JAXBElement<String> value) {
        this.dateShipped = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the shippingCarrier property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShippingCarrier() {
        return shippingCarrier;
    }

    /**
     * Sets the value of the shippingCarrier property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShippingCarrier(JAXBElement<String> value) {
        this.shippingCarrier = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the trackingUrl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTrackingUrl() {
        return trackingUrl;
    }

    /**
     * Sets the value of the trackingUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTrackingUrl(JAXBElement<String> value) {
        this.trackingUrl = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the trackingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTrackingNumber() {
        return trackingNumber;
    }

    /**
     * Sets the value of the trackingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTrackingNumber(JAXBElement<String> value) {
        this.trackingNumber = ((JAXBElement<String> ) value);
    }

}
