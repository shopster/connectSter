
package shopster.apis.main;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BaseResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Timestamp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{urn:shopster:apis:main}ResponseStatusType" minOccurs="0"/>
 *         &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Build" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MessageID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Errors" type="{urn:shopster:apis:main}ErrorCollectionType" minOccurs="0"/>
 *         &lt;element name="AccessExpirationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseResponseType", propOrder = {
    "timestamp",
    "status",
    "version",
    "build",
    "messageID",
    "errors",
    "accessExpirationDate"
})
@XmlSeeAlso({
    GetUserInfoResponseType.class,
    GetVersionsResponseType.class,
    VerifyPlaceOrderResponseType.class,
    GetInventoryCategoriesResponseType.class,
    GetOrdersResponseType.class,
    PlaceOrderResponseType.class,
    GetInventoryItemsResponseType.class
})
public class BaseResponseType {

    @XmlElementRef(name = "Timestamp", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> timestamp;
    @XmlElement(name = "Status")
    protected ResponseStatusType status;
    @XmlElementRef(name = "Version", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> version;
    @XmlElementRef(name = "Build", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> build;
    @XmlElementRef(name = "MessageID", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> messageID;
    @XmlElementRef(name = "Errors", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<ErrorCollectionType> errors;
    @XmlElementRef(name = "AccessExpirationDate", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> accessExpirationDate;

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTimestamp(JAXBElement<String> value) {
        this.timestamp = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseStatusType }
     *     
     */
    public ResponseStatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseStatusType }
     *     
     */
    public void setStatus(ResponseStatusType value) {
        this.status = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVersion(JAXBElement<String> value) {
        this.version = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the build property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBuild() {
        return build;
    }

    /**
     * Sets the value of the build property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBuild(JAXBElement<String> value) {
        this.build = ((JAXBElement<String> ) value);
    }

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
     * Gets the value of the errors property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ErrorCollectionType }{@code >}
     *     
     */
    public JAXBElement<ErrorCollectionType> getErrors() {
        return errors;
    }

    /**
     * Sets the value of the errors property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ErrorCollectionType }{@code >}
     *     
     */
    public void setErrors(JAXBElement<ErrorCollectionType> value) {
        this.errors = ((JAXBElement<ErrorCollectionType> ) value);
    }

    /**
     * Gets the value of the accessExpirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccessExpirationDate() {
        return accessExpirationDate;
    }

    /**
     * Sets the value of the accessExpirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccessExpirationDate(JAXBElement<String> value) {
        this.accessExpirationDate = ((JAXBElement<String> ) value);
    }

}
