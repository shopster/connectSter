
package shopster.apis.main;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns:msc="http://schemas.microsoft.com/ws/2005/12/wsdl/contract" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" xmlns:tns="urn:shopster:apis:main" xmlns:wsa="http://schemas.xmlsoap.org/ws/2004/08/addressing" xmlns:wsa10="http://www.w3.org/2005/08/addressing" xmlns:wsam="http://www.w3.org/2007/05/addressing/metadata" xmlns:wsap="http://schemas.xmlsoap.org/ws/2004/08/addressing/policy" xmlns:wsaw="http://www.w3.org/2006/05/addressing/wsdl" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns:wsp="http://schemas.xmlsoap.org/ws/2004/09/policy" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" xmlns:wsx="http://schemas.xmlsoap.org/ws/2004/09/mex" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;
 *             Request for the &lt;c&gt;GetInventoryItems&lt;/c&gt; command.
 *             &lt;/summary&gt;
 * </pre>
 * 
 * 
 * <p>Java class for GetInventoryItemsRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetInventoryItemsRequestType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:shopster:apis:main}BaseRequestType">
 *       &lt;sequence>
 *         &lt;element name="PageIndex" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PageSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DetailGroups" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ItemIdList" type="{urn:shopster:apis:main}ItemIdListType" minOccurs="0"/>
 *         &lt;element name="SupplierId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CategoryId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SearchTerm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastUpdatedSince" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetInventoryItemsRequestType", propOrder = {
    "pageIndex",
    "pageSize",
    "detailGroups",
    "itemIdList",
    "supplierId",
    "categoryId",
    "searchTerm",
    "lastUpdatedSince"
})
public class GetInventoryItemsRequestType
    extends BaseRequestType
{

    @XmlElementRef(name = "PageIndex", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<Integer> pageIndex;
    @XmlElementRef(name = "PageSize", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<Integer> pageSize;
    @XmlElementRef(name = "DetailGroups", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> detailGroups;
    @XmlElementRef(name = "ItemIdList", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<ItemIdListType> itemIdList;
    @XmlElementRef(name = "SupplierId", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> supplierId;
    @XmlElementRef(name = "CategoryId", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> categoryId;
    @XmlElementRef(name = "SearchTerm", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<String> searchTerm;
    @XmlElementRef(name = "LastUpdatedSince", namespace = "urn:shopster:apis:main", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> lastUpdatedSince;

    /**
     * Gets the value of the pageIndex property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getPageIndex() {
        return pageIndex;
    }

    /**
     * Sets the value of the pageIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setPageIndex(JAXBElement<Integer> value) {
        this.pageIndex = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the pageSize property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getPageSize() {
        return pageSize;
    }

    /**
     * Sets the value of the pageSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setPageSize(JAXBElement<Integer> value) {
        this.pageSize = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the detailGroups property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDetailGroups() {
        return detailGroups;
    }

    /**
     * Sets the value of the detailGroups property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDetailGroups(JAXBElement<String> value) {
        this.detailGroups = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the itemIdList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ItemIdListType }{@code >}
     *     
     */
    public JAXBElement<ItemIdListType> getItemIdList() {
        return itemIdList;
    }

    /**
     * Sets the value of the itemIdList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ItemIdListType }{@code >}
     *     
     */
    public void setItemIdList(JAXBElement<ItemIdListType> value) {
        this.itemIdList = ((JAXBElement<ItemIdListType> ) value);
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
     * Gets the value of the categoryId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCategoryId() {
        return categoryId;
    }

    /**
     * Sets the value of the categoryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCategoryId(JAXBElement<String> value) {
        this.categoryId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the searchTerm property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSearchTerm() {
        return searchTerm;
    }

    /**
     * Sets the value of the searchTerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSearchTerm(JAXBElement<String> value) {
        this.searchTerm = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the lastUpdatedSince property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getLastUpdatedSince() {
        return lastUpdatedSince;
    }

    /**
     * Sets the value of the lastUpdatedSince property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setLastUpdatedSince(JAXBElement<XMLGregorianCalendar> value) {
        this.lastUpdatedSince = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

}
