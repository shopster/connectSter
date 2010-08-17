
package shopster.apis.main;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns:msc="http://schemas.microsoft.com/ws/2005/12/wsdl/contract" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" xmlns:tns="urn:shopster:apis:main" xmlns:wsa="http://schemas.xmlsoap.org/ws/2004/08/addressing" xmlns:wsa10="http://www.w3.org/2005/08/addressing" xmlns:wsam="http://www.w3.org/2007/05/addressing/metadata" xmlns:wsap="http://schemas.xmlsoap.org/ws/2004/08/addressing/policy" xmlns:wsaw="http://www.w3.org/2006/05/addressing/wsdl" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns:wsp="http://schemas.xmlsoap.org/ws/2004/09/policy" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" xmlns:wsx="http://schemas.xmlsoap.org/ws/2004/09/mex" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;
 *             Class defining the information returned when an "error" occurs.
 *             &lt;/summary&gt;
 * </pre>
 * 
 * 
 * <p>Java class for ErrorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ErrorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ErrorClassification" type="{urn:shopster:apis:main}ErrorClassificationType" minOccurs="0"/>
 *         &lt;element name="SeverityCode" type="{urn:shopster:apis:main}ErrorSeverityType" minOccurs="0"/>
 *         &lt;element name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ErrorParameters" type="{urn:shopster:apis:main}ErrorParametersCollectionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ErrorType", propOrder = {
    "errorClassification",
    "severityCode",
    "errorCode",
    "message",
    "errorParameters"
})
public class ErrorType {

    @XmlElement(name = "ErrorClassification")
    protected ErrorClassificationType errorClassification;
    @XmlElement(name = "SeverityCode")
    protected ErrorSeverityType severityCode;
    @XmlElementRef(name = "ErrorCode", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> errorCode;
    @XmlElementRef(name = "Message", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> message;
    @XmlElementRef(name = "ErrorParameters", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<ErrorParametersCollectionType> errorParameters;

    /**
     * Gets the value of the errorClassification property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorClassificationType }
     *     
     */
    public ErrorClassificationType getErrorClassification() {
        return errorClassification;
    }

    /**
     * Sets the value of the errorClassification property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorClassificationType }
     *     
     */
    public void setErrorClassification(ErrorClassificationType value) {
        this.errorClassification = value;
    }

    /**
     * Gets the value of the severityCode property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorSeverityType }
     *     
     */
    public ErrorSeverityType getSeverityCode() {
        return severityCode;
    }

    /**
     * Sets the value of the severityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorSeverityType }
     *     
     */
    public void setSeverityCode(ErrorSeverityType value) {
        this.severityCode = value;
    }

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setErrorCode(JAXBElement<String> value) {
        this.errorCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMessage(JAXBElement<String> value) {
        this.message = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the errorParameters property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ErrorParametersCollectionType }{@code >}
     *     
     */
    public JAXBElement<ErrorParametersCollectionType> getErrorParameters() {
        return errorParameters;
    }

    /**
     * Sets the value of the errorParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ErrorParametersCollectionType }{@code >}
     *     
     */
    public void setErrorParameters(JAXBElement<ErrorParametersCollectionType> value) {
        this.errorParameters = ((JAXBElement<ErrorParametersCollectionType> ) value);
    }

}
