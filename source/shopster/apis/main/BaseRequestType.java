
package shopster.apis.main;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BaseRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OutputSelector" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseRequestType", propOrder = {
    "messageID",
    "outputSelector"
})
@XmlSeeAlso({
    GetUserInfoRequestType.class,
    GetInventoryCategoriesRequestType.class,
    VerifyPlaceOrderRequestType.class,
    GetInventoryItemsRequestType.class,
    GetVersionsRequestType.class,
    GetOrdersRequestType.class,
    PlaceOrderRequestType.class
})
public class BaseRequestType {

    @XmlElementRef(name = "MessageID", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> messageID;
    @XmlElementRef(name = "OutputSelector", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> outputSelector;

    /**
     * Gets the value of the messageID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMessageID() {
        return messageID;
    }

    /**
     * Sets the value of the messageID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMessageID(JAXBElement<String> value) {
        this.messageID = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the outputSelector property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOutputSelector() {
        return outputSelector;
    }

    /**
     * Sets the value of the outputSelector property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOutputSelector(JAXBElement<String> value) {
        this.outputSelector = ((JAXBElement<String> ) value);
    }

}
