
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
 *             Response for the &lt;c&gt;GetVersions&lt;/c&gt; command.
 *             &lt;/summary&gt;
 * </pre>
 * 
 * 
 * <p>Java class for GetVersionsResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetVersionsResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:shopster:apis:main}BaseResponseType">
 *       &lt;sequence>
 *         &lt;element name="MinimumSupportedVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetVersionsResponseType", propOrder = {
    "minimumSupportedVersion"
})
public class GetVersionsResponseType
    extends BaseResponseType
{

    @XmlElementRef(name = "MinimumSupportedVersion", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> minimumSupportedVersion;

    /**
     * Gets the value of the minimumSupportedVersion property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMinimumSupportedVersion() {
        return minimumSupportedVersion;
    }

    /**
     * Sets the value of the minimumSupportedVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMinimumSupportedVersion(JAXBElement<String> value) {
        this.minimumSupportedVersion = ((JAXBElement<String> ) value);
    }

}
