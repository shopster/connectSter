
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
 *             Response for the &lt;c&gt;GetMyInventoryItems&lt;/c&gt; command.
 *             &lt;/summary&gt;
 * </pre>
 * 
 * 
 * <p>Java class for GetInventoryItemsResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetInventoryItemsResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:shopster:apis:main}BaseResponseType">
 *       &lt;sequence>
 *         &lt;element name="NumFound" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Items" type="{urn:shopster:apis:main}InventoryItemListType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetInventoryItemsResponseType", propOrder = {
    "numFound",
    "items"
})
public class GetInventoryItemsResponseType
    extends BaseResponseType
{

    @XmlElementRef(name = "NumFound", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<Integer> numFound;
    @XmlElementRef(name = "Items", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<InventoryItemListType> items;

    /**
     * Gets the value of the numFound property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getNumFound() {
        return numFound;
    }

    /**
     * Sets the value of the numFound property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setNumFound(JAXBElement<Integer> value) {
        this.numFound = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the items property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link InventoryItemListType }{@code >}
     *     
     */
    public JAXBElement<InventoryItemListType> getItems() {
        return items;
    }

    /**
     * Sets the value of the items property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link InventoryItemListType }{@code >}
     *     
     */
    public void setItems(JAXBElement<InventoryItemListType> value) {
        this.items = ((JAXBElement<InventoryItemListType> ) value);
    }

}
