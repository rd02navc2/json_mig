//
// 此檔案是由 Eclipse Implementation of JAXB, v2.3.8 所產生 
// 請參閱 https://eclipse-ee4j.github.io/jaxb-ri 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2025.10.20 於 05:04:42 PM CST 
//


package wco.datamodel.tw.nx901.r_00_03;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tw.gov.customs.schema.n5107.wcods.AdditionalDocumentIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.AdditionalInformationContentTextType;
import tw.gov.customs.schema.n5107.wcods.AdditionalInformationStatementDescriptionTextType;
import tw.gov.customs.schema.n5107.wcods.AgentIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.AgentRoleCodeType;
import tw.gov.customs.schema.n5107.wcods.ContactOfficeIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.DeclarationFunctionCodeType;
import tw.gov.customs.schema.n5107.wcods.DeclarationIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ResponsibleGovernmentAgencyIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.StatusNameCodeType;
import wco.datamodel.tw.ds._1.AdditionalInformationProcessNumberTextType;
import wco.datamodel.tw.ds._1.AgentSubBoxIDType;
import wco.datamodel.tw.ds._1.ApplicantIdentificationIDType;
import wco.datamodel.tw.ds._1.ApplicationTypeCodeType;
import wco.datamodel.tw.ds._1.PreviousDocumentFunctionalReferenceIDType;


/**
 * <p>anonymous complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IssueDateTime" type="{urn:wco:datamodel:WCO:DS:1}ResponseIssueDateTimeType" minOccurs="0"/&gt;
 *         &lt;element name="ContactOffice" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ID"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;ContactOfficeIdentificationIDType"&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Status" maxOccurs="99"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="NameCode"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;StatusNameCodeType"&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Declaration"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="AcceptanceDateTime" type="{urn:wco:datamodel:WCO:DS:1}DeclarationAcceptanceDateTimeType" minOccurs="0"/&gt;
 *                   &lt;element name="FunctionCode"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;DeclarationFunctionCodeType"&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="ID" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;DeclarationIdentificationIDType"&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="AdditionalInformation" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="Content" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalInformationContentTextType"&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="tw_ProcessNumber" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;AdditionalInformationProcessNumberTextType"&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Agent" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="ID"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AgentIdentificationIDType"&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="RoleCode"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AgentRoleCodeType"&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="tw_SubBoxID"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;AgentSubBoxIDType"&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="GoodsShipment" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="AdditionalDocument" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="ID"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;simpleContent&gt;
 *                                             &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalDocumentIdentificationIDType"&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="AdditionalInformation" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="StatementDescription"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;simpleContent&gt;
 *                                             &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalInformationStatementDescriptionTextType"&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="GovernmentAgencyGoodsItem" maxOccurs="9999" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="SequenceNumeric" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{urn:wco:datamodel:WCO:DS:1}GovernmentAgencyGoodsItemSequenceNumericType"&gt;
 *                                             &lt;minInclusive value="0"/&gt;
 *                                             &lt;maxInclusive value="9999"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="AdditionalDocument" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="tw_SequenceNumeric"&gt;
 *                                                   &lt;simpleType&gt;
 *                                                     &lt;restriction base="{urn:wco:datamodel:TW:DS:1}AdditionalDocumentSequenceNumericType"&gt;
 *                                                       &lt;minInclusive value="0"/&gt;
 *                                                       &lt;maxInclusive value="9999"/&gt;
 *                                                     &lt;/restriction&gt;
 *                                                   &lt;/simpleType&gt;
 *                                                 &lt;/element&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="AdditionalInformation" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="Content"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;simpleContent&gt;
 *                                                       &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalInformationContentTextType"&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/simpleContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="Status" maxOccurs="99"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="NameCode"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;simpleContent&gt;
 *                                                       &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;StatusNameCodeType"&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/simpleContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="PreviousDocument"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="tw_FunctionalReferenceID"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;PreviousDocumentFunctionalReferenceIDType"&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="ResponsibleGovernmentAgency"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="ID"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;ResponsibleGovernmentAgencyIdentificationIDType"&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="tw_Application" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="tw_TypeCode" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;ApplicationTypeCodeType"&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="Agent" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="ID"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;simpleContent&gt;
 *                                             &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AgentIdentificationIDType"&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="tw_Applicant" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="tw_ID"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;simpleContent&gt;
 *                                             &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;ApplicantIdentificationIDType"&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "issueDateTime",
    "contactOffice",
    "status",
    "declaration"
})
@XmlRootElement(name = "Response")
public class Response {

    @XmlElement(name = "IssueDateTime")
    protected String issueDateTime;
    @XmlElement(name = "ContactOffice")
    protected Response.ContactOffice contactOffice;
    @XmlElement(name = "Status", required = true)
    protected List<Response.Status> status;
    @XmlElement(name = "Declaration", required = true)
    protected Response.Declaration declaration;

    /**
     * 取得 issueDateTime 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssueDateTime() {
        return issueDateTime;
    }

    /**
     * 設定 issueDateTime 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssueDateTime(String value) {
        this.issueDateTime = value;
    }

    /**
     * 取得 contactOffice 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link Response.ContactOffice }
     *     
     */
    public Response.ContactOffice getContactOffice() {
        return contactOffice;
    }

    /**
     * 設定 contactOffice 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link Response.ContactOffice }
     *     
     */
    public void setContactOffice(Response.ContactOffice value) {
        this.contactOffice = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the status property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Response.Status }
     * 
     * 
     */
    public List<Response.Status> getStatus() {
        if (status == null) {
            status = new ArrayList<Response.Status>();
        }
        return this.status;
    }

    /**
     * 取得 declaration 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link Response.Declaration }
     *     
     */
    public Response.Declaration getDeclaration() {
        return declaration;
    }

    /**
     * 設定 declaration 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link Response.Declaration }
     *     
     */
    public void setDeclaration(Response.Declaration value) {
        this.declaration = value;
    }


    /**
     * <p>anonymous complex type 的 Java 類別.
     * 
     * <p>下列綱要片段會指定此類別中包含的預期內容.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="ID"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;ContactOfficeIdentificationIDType"&gt;
     *               &lt;/restriction&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "id"
    })
    public static class ContactOffice {

        @XmlElement(name = "ID", required = true)
        protected Response.ContactOffice.ID id;

        /**
         * 取得 id 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link Response.ContactOffice.ID }
         *     
         */
        public Response.ContactOffice.ID getID() {
            return id;
        }

        /**
         * 設定 id 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link Response.ContactOffice.ID }
         *     
         */
        public void setID(Response.ContactOffice.ID value) {
            this.id = value;
        }


        /**
         * <p>anonymous complex type 的 Java 類別.
         * 
         * <p>下列綱要片段會指定此類別中包含的預期內容.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;ContactOfficeIdentificationIDType"&gt;
         *     &lt;/restriction&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class ID
            extends ContactOfficeIdentificationIDType
        {


        }

    }


    /**
     * <p>anonymous complex type 的 Java 類別.
     * 
     * <p>下列綱要片段會指定此類別中包含的預期內容.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="AcceptanceDateTime" type="{urn:wco:datamodel:WCO:DS:1}DeclarationAcceptanceDateTimeType" minOccurs="0"/&gt;
     *         &lt;element name="FunctionCode"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;DeclarationFunctionCodeType"&gt;
     *               &lt;/restriction&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="ID" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;DeclarationIdentificationIDType"&gt;
     *               &lt;/restriction&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="AdditionalInformation" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="Content" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalInformationContentTextType"&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="tw_ProcessNumber" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;AdditionalInformationProcessNumberTextType"&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Agent" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="ID"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AgentIdentificationIDType"&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="RoleCode"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AgentRoleCodeType"&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="tw_SubBoxID"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;AgentSubBoxIDType"&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="GoodsShipment" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="AdditionalDocument" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="ID"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;simpleContent&gt;
     *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalDocumentIdentificationIDType"&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="AdditionalInformation" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="StatementDescription"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;simpleContent&gt;
     *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalInformationStatementDescriptionTextType"&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="GovernmentAgencyGoodsItem" maxOccurs="9999" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="SequenceNumeric" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{urn:wco:datamodel:WCO:DS:1}GovernmentAgencyGoodsItemSequenceNumericType"&gt;
     *                                   &lt;minInclusive value="0"/&gt;
     *                                   &lt;maxInclusive value="9999"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="AdditionalDocument" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="tw_SequenceNumeric"&gt;
     *                                         &lt;simpleType&gt;
     *                                           &lt;restriction base="{urn:wco:datamodel:TW:DS:1}AdditionalDocumentSequenceNumericType"&gt;
     *                                             &lt;minInclusive value="0"/&gt;
     *                                             &lt;maxInclusive value="9999"/&gt;
     *                                           &lt;/restriction&gt;
     *                                         &lt;/simpleType&gt;
     *                                       &lt;/element&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="AdditionalInformation" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="Content"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;simpleContent&gt;
     *                                             &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalInformationContentTextType"&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/simpleContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="Status" maxOccurs="99"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="NameCode"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;simpleContent&gt;
     *                                             &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;StatusNameCodeType"&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/simpleContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="PreviousDocument"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="tw_FunctionalReferenceID"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;PreviousDocumentFunctionalReferenceIDType"&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="ResponsibleGovernmentAgency"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="ID"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;ResponsibleGovernmentAgencyIdentificationIDType"&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="tw_Application" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="tw_TypeCode" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;ApplicationTypeCodeType"&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="Agent" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="ID"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;simpleContent&gt;
     *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AgentIdentificationIDType"&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="tw_Applicant" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="tw_ID"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;simpleContent&gt;
     *                                   &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;ApplicantIdentificationIDType"&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "acceptanceDateTime",
        "functionCode",
        "id",
        "additionalInformation",
        "agent",
        "goodsShipment",
        "previousDocument",
        "responsibleGovernmentAgency",
        "twApplication"
    })
    public static class Declaration {

        @XmlElement(name = "AcceptanceDateTime")
        protected String acceptanceDateTime;
        @XmlElement(name = "FunctionCode", required = true)
        protected Response.Declaration.FunctionCode functionCode;
        @XmlElement(name = "ID")
        protected Response.Declaration.ID id;
        @XmlElement(name = "AdditionalInformation")
        protected Response.Declaration.AdditionalInformation additionalInformation;
        @XmlElement(name = "Agent")
        protected Response.Declaration.Agent agent;
        @XmlElement(name = "GoodsShipment")
        protected Response.Declaration.GoodsShipment goodsShipment;
        @XmlElement(name = "PreviousDocument", required = true)
        protected Response.Declaration.PreviousDocument previousDocument;
        @XmlElement(name = "ResponsibleGovernmentAgency", required = true)
        protected Response.Declaration.ResponsibleGovernmentAgency responsibleGovernmentAgency;
        @XmlElement(name = "tw_Application")
        protected Response.Declaration.TwApplication twApplication;

        /**
         * 取得 acceptanceDateTime 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAcceptanceDateTime() {
            return acceptanceDateTime;
        }

        /**
         * 設定 acceptanceDateTime 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAcceptanceDateTime(String value) {
            this.acceptanceDateTime = value;
        }

        /**
         * 取得 functionCode 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link Response.Declaration.FunctionCode }
         *     
         */
        public Response.Declaration.FunctionCode getFunctionCode() {
            return functionCode;
        }

        /**
         * 設定 functionCode 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link Response.Declaration.FunctionCode }
         *     
         */
        public void setFunctionCode(Response.Declaration.FunctionCode value) {
            this.functionCode = value;
        }

        /**
         * 取得 id 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link Response.Declaration.ID }
         *     
         */
        public Response.Declaration.ID getID() {
            return id;
        }

        /**
         * 設定 id 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link Response.Declaration.ID }
         *     
         */
        public void setID(Response.Declaration.ID value) {
            this.id = value;
        }

        /**
         * 取得 additionalInformation 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link Response.Declaration.AdditionalInformation }
         *     
         */
        public Response.Declaration.AdditionalInformation getAdditionalInformation() {
            return additionalInformation;
        }

        /**
         * 設定 additionalInformation 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link Response.Declaration.AdditionalInformation }
         *     
         */
        public void setAdditionalInformation(Response.Declaration.AdditionalInformation value) {
            this.additionalInformation = value;
        }

        /**
         * 取得 agent 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link Response.Declaration.Agent }
         *     
         */
        public Response.Declaration.Agent getAgent() {
            return agent;
        }

        /**
         * 設定 agent 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link Response.Declaration.Agent }
         *     
         */
        public void setAgent(Response.Declaration.Agent value) {
            this.agent = value;
        }

        /**
         * 取得 goodsShipment 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link Response.Declaration.GoodsShipment }
         *     
         */
        public Response.Declaration.GoodsShipment getGoodsShipment() {
            return goodsShipment;
        }

        /**
         * 設定 goodsShipment 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link Response.Declaration.GoodsShipment }
         *     
         */
        public void setGoodsShipment(Response.Declaration.GoodsShipment value) {
            this.goodsShipment = value;
        }

        /**
         * 取得 previousDocument 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link Response.Declaration.PreviousDocument }
         *     
         */
        public Response.Declaration.PreviousDocument getPreviousDocument() {
            return previousDocument;
        }

        /**
         * 設定 previousDocument 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link Response.Declaration.PreviousDocument }
         *     
         */
        public void setPreviousDocument(Response.Declaration.PreviousDocument value) {
            this.previousDocument = value;
        }

        /**
         * 取得 responsibleGovernmentAgency 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link Response.Declaration.ResponsibleGovernmentAgency }
         *     
         */
        public Response.Declaration.ResponsibleGovernmentAgency getResponsibleGovernmentAgency() {
            return responsibleGovernmentAgency;
        }

        /**
         * 設定 responsibleGovernmentAgency 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link Response.Declaration.ResponsibleGovernmentAgency }
         *     
         */
        public void setResponsibleGovernmentAgency(Response.Declaration.ResponsibleGovernmentAgency value) {
            this.responsibleGovernmentAgency = value;
        }

        /**
         * 取得 twApplication 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link Response.Declaration.TwApplication }
         *     
         */
        public Response.Declaration.TwApplication getTwApplication() {
            return twApplication;
        }

        /**
         * 設定 twApplication 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link Response.Declaration.TwApplication }
         *     
         */
        public void setTwApplication(Response.Declaration.TwApplication value) {
            this.twApplication = value;
        }


        /**
         * <p>anonymous complex type 的 Java 類別.
         * 
         * <p>下列綱要片段會指定此類別中包含的預期內容.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="Content" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalInformationContentTextType"&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="tw_ProcessNumber" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;AdditionalInformationProcessNumberTextType"&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "content",
            "twProcessNumber"
        })
        public static class AdditionalInformation {

            @XmlElement(name = "Content")
            protected Response.Declaration.AdditionalInformation.Content content;
            @XmlElement(name = "tw_ProcessNumber")
            protected Response.Declaration.AdditionalInformation.TwProcessNumber twProcessNumber;

            /**
             * 取得 content 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.AdditionalInformation.Content }
             *     
             */
            public Response.Declaration.AdditionalInformation.Content getContent() {
                return content;
            }

            /**
             * 設定 content 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.AdditionalInformation.Content }
             *     
             */
            public void setContent(Response.Declaration.AdditionalInformation.Content value) {
                this.content = value;
            }

            /**
             * 取得 twProcessNumber 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.AdditionalInformation.TwProcessNumber }
             *     
             */
            public Response.Declaration.AdditionalInformation.TwProcessNumber getTwProcessNumber() {
                return twProcessNumber;
            }

            /**
             * 設定 twProcessNumber 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.AdditionalInformation.TwProcessNumber }
             *     
             */
            public void setTwProcessNumber(Response.Declaration.AdditionalInformation.TwProcessNumber value) {
                this.twProcessNumber = value;
            }


            /**
             * <p>anonymous complex type 的 Java 類別.
             * 
             * <p>下列綱要片段會指定此類別中包含的預期內容.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;simpleContent&gt;
             *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalInformationContentTextType"&gt;
             *     &lt;/restriction&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Content
                extends AdditionalInformationContentTextType
            {


            }


            /**
             * <p>anonymous complex type 的 Java 類別.
             * 
             * <p>下列綱要片段會指定此類別中包含的預期內容.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;simpleContent&gt;
             *     &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;AdditionalInformationProcessNumberTextType"&gt;
             *     &lt;/restriction&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class TwProcessNumber
                extends AdditionalInformationProcessNumberTextType
            {


            }

        }


        /**
         * <p>anonymous complex type 的 Java 類別.
         * 
         * <p>下列綱要片段會指定此類別中包含的預期內容.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="ID"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AgentIdentificationIDType"&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="RoleCode"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AgentRoleCodeType"&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="tw_SubBoxID"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;AgentSubBoxIDType"&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "id",
            "roleCode",
            "twSubBoxID"
        })
        public static class Agent {

            @XmlElement(name = "ID", required = true)
            protected Response.Declaration.Agent.ID id;
            @XmlElement(name = "RoleCode", required = true)
            protected Response.Declaration.Agent.RoleCode roleCode;
            @XmlElement(name = "tw_SubBoxID", required = true)
            protected Response.Declaration.Agent.TwSubBoxID twSubBoxID;

            /**
             * 取得 id 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.Agent.ID }
             *     
             */
            public Response.Declaration.Agent.ID getID() {
                return id;
            }

            /**
             * 設定 id 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.Agent.ID }
             *     
             */
            public void setID(Response.Declaration.Agent.ID value) {
                this.id = value;
            }

            /**
             * 取得 roleCode 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.Agent.RoleCode }
             *     
             */
            public Response.Declaration.Agent.RoleCode getRoleCode() {
                return roleCode;
            }

            /**
             * 設定 roleCode 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.Agent.RoleCode }
             *     
             */
            public void setRoleCode(Response.Declaration.Agent.RoleCode value) {
                this.roleCode = value;
            }

            /**
             * 取得 twSubBoxID 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.Agent.TwSubBoxID }
             *     
             */
            public Response.Declaration.Agent.TwSubBoxID getTwSubBoxID() {
                return twSubBoxID;
            }

            /**
             * 設定 twSubBoxID 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.Agent.TwSubBoxID }
             *     
             */
            public void setTwSubBoxID(Response.Declaration.Agent.TwSubBoxID value) {
                this.twSubBoxID = value;
            }


            /**
             * <p>anonymous complex type 的 Java 類別.
             * 
             * <p>下列綱要片段會指定此類別中包含的預期內容.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;simpleContent&gt;
             *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AgentIdentificationIDType"&gt;
             *     &lt;/restriction&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class ID
                extends AgentIdentificationIDType
            {


            }


            /**
             * <p>anonymous complex type 的 Java 類別.
             * 
             * <p>下列綱要片段會指定此類別中包含的預期內容.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;simpleContent&gt;
             *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AgentRoleCodeType"&gt;
             *     &lt;/restriction&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class RoleCode
                extends AgentRoleCodeType
            {


            }


            /**
             * <p>anonymous complex type 的 Java 類別.
             * 
             * <p>下列綱要片段會指定此類別中包含的預期內容.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;simpleContent&gt;
             *     &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;AgentSubBoxIDType"&gt;
             *     &lt;/restriction&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class TwSubBoxID
                extends AgentSubBoxIDType
            {


            }

        }


        /**
         * <p>anonymous complex type 的 Java 類別.
         * 
         * <p>下列綱要片段會指定此類別中包含的預期內容.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;DeclarationFunctionCodeType"&gt;
         *     &lt;/restriction&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class FunctionCode
            extends DeclarationFunctionCodeType
        {


        }


        /**
         * <p>anonymous complex type 的 Java 類別.
         * 
         * <p>下列綱要片段會指定此類別中包含的預期內容.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="AdditionalDocument" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="ID"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;simpleContent&gt;
         *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalDocumentIdentificationIDType"&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/simpleContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="AdditionalInformation" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="StatementDescription"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;simpleContent&gt;
         *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalInformationStatementDescriptionTextType"&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/simpleContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="GovernmentAgencyGoodsItem" maxOccurs="9999" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="SequenceNumeric" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{urn:wco:datamodel:WCO:DS:1}GovernmentAgencyGoodsItemSequenceNumericType"&gt;
         *                         &lt;minInclusive value="0"/&gt;
         *                         &lt;maxInclusive value="9999"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="AdditionalDocument" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="tw_SequenceNumeric"&gt;
         *                               &lt;simpleType&gt;
         *                                 &lt;restriction base="{urn:wco:datamodel:TW:DS:1}AdditionalDocumentSequenceNumericType"&gt;
         *                                   &lt;minInclusive value="0"/&gt;
         *                                   &lt;maxInclusive value="9999"/&gt;
         *                                 &lt;/restriction&gt;
         *                               &lt;/simpleType&gt;
         *                             &lt;/element&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="AdditionalInformation" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="Content"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;simpleContent&gt;
         *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalInformationContentTextType"&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleContent&gt;
         *                               &lt;/complexType&gt;
         *                             &lt;/element&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="Status" maxOccurs="99"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="NameCode"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;simpleContent&gt;
         *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;StatusNameCodeType"&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleContent&gt;
         *                               &lt;/complexType&gt;
         *                             &lt;/element&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "additionalDocument",
            "additionalInformation",
            "governmentAgencyGoodsItem"
        })
        public static class GoodsShipment {

            @XmlElement(name = "AdditionalDocument")
            protected Response.Declaration.GoodsShipment.AdditionalDocument additionalDocument;
            @XmlElement(name = "AdditionalInformation")
            protected Response.Declaration.GoodsShipment.AdditionalInformation additionalInformation;
            @XmlElement(name = "GovernmentAgencyGoodsItem")
            protected List<Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem> governmentAgencyGoodsItem;

            /**
             * 取得 additionalDocument 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.GoodsShipment.AdditionalDocument }
             *     
             */
            public Response.Declaration.GoodsShipment.AdditionalDocument getAdditionalDocument() {
                return additionalDocument;
            }

            /**
             * 設定 additionalDocument 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.GoodsShipment.AdditionalDocument }
             *     
             */
            public void setAdditionalDocument(Response.Declaration.GoodsShipment.AdditionalDocument value) {
                this.additionalDocument = value;
            }

            /**
             * 取得 additionalInformation 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.GoodsShipment.AdditionalInformation }
             *     
             */
            public Response.Declaration.GoodsShipment.AdditionalInformation getAdditionalInformation() {
                return additionalInformation;
            }

            /**
             * 設定 additionalInformation 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.GoodsShipment.AdditionalInformation }
             *     
             */
            public void setAdditionalInformation(Response.Declaration.GoodsShipment.AdditionalInformation value) {
                this.additionalInformation = value;
            }

            /**
             * Gets the value of the governmentAgencyGoodsItem property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the governmentAgencyGoodsItem property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getGovernmentAgencyGoodsItem().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem }
             * 
             * 
             */
            public List<Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem> getGovernmentAgencyGoodsItem() {
                if (governmentAgencyGoodsItem == null) {
                    governmentAgencyGoodsItem = new ArrayList<Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem>();
                }
                return this.governmentAgencyGoodsItem;
            }


            /**
             * <p>anonymous complex type 的 Java 類別.
             * 
             * <p>下列綱要片段會指定此類別中包含的預期內容.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="ID"&gt;
             *           &lt;complexType&gt;
             *             &lt;simpleContent&gt;
             *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalDocumentIdentificationIDType"&gt;
             *               &lt;/restriction&gt;
             *             &lt;/simpleContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "id"
            })
            public static class AdditionalDocument {

                @XmlElement(name = "ID", required = true)
                protected Response.Declaration.GoodsShipment.AdditionalDocument.ID id;

                /**
                 * 取得 id 特性的值.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Response.Declaration.GoodsShipment.AdditionalDocument.ID }
                 *     
                 */
                public Response.Declaration.GoodsShipment.AdditionalDocument.ID getID() {
                    return id;
                }

                /**
                 * 設定 id 特性的值.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Response.Declaration.GoodsShipment.AdditionalDocument.ID }
                 *     
                 */
                public void setID(Response.Declaration.GoodsShipment.AdditionalDocument.ID value) {
                    this.id = value;
                }


                /**
                 * <p>anonymous complex type 的 Java 類別.
                 * 
                 * <p>下列綱要片段會指定此類別中包含的預期內容.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;simpleContent&gt;
                 *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalDocumentIdentificationIDType"&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/simpleContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class ID
                    extends AdditionalDocumentIdentificationIDType
                {


                }

            }


            /**
             * <p>anonymous complex type 的 Java 類別.
             * 
             * <p>下列綱要片段會指定此類別中包含的預期內容.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="StatementDescription"&gt;
             *           &lt;complexType&gt;
             *             &lt;simpleContent&gt;
             *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalInformationStatementDescriptionTextType"&gt;
             *               &lt;/restriction&gt;
             *             &lt;/simpleContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "statementDescription"
            })
            public static class AdditionalInformation {

                @XmlElement(name = "StatementDescription", required = true)
                protected Response.Declaration.GoodsShipment.AdditionalInformation.StatementDescription statementDescription;

                /**
                 * 取得 statementDescription 特性的值.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Response.Declaration.GoodsShipment.AdditionalInformation.StatementDescription }
                 *     
                 */
                public Response.Declaration.GoodsShipment.AdditionalInformation.StatementDescription getStatementDescription() {
                    return statementDescription;
                }

                /**
                 * 設定 statementDescription 特性的值.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Response.Declaration.GoodsShipment.AdditionalInformation.StatementDescription }
                 *     
                 */
                public void setStatementDescription(Response.Declaration.GoodsShipment.AdditionalInformation.StatementDescription value) {
                    this.statementDescription = value;
                }


                /**
                 * <p>anonymous complex type 的 Java 類別.
                 * 
                 * <p>下列綱要片段會指定此類別中包含的預期內容.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;simpleContent&gt;
                 *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalInformationStatementDescriptionTextType"&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/simpleContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class StatementDescription
                    extends AdditionalInformationStatementDescriptionTextType
                {


                }

            }


            /**
             * <p>anonymous complex type 的 Java 類別.
             * 
             * <p>下列綱要片段會指定此類別中包含的預期內容.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="SequenceNumeric" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{urn:wco:datamodel:WCO:DS:1}GovernmentAgencyGoodsItemSequenceNumericType"&gt;
             *               &lt;minInclusive value="0"/&gt;
             *               &lt;maxInclusive value="9999"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="AdditionalDocument" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="tw_SequenceNumeric"&gt;
             *                     &lt;simpleType&gt;
             *                       &lt;restriction base="{urn:wco:datamodel:TW:DS:1}AdditionalDocumentSequenceNumericType"&gt;
             *                         &lt;minInclusive value="0"/&gt;
             *                         &lt;maxInclusive value="9999"/&gt;
             *                       &lt;/restriction&gt;
             *                     &lt;/simpleType&gt;
             *                   &lt;/element&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="AdditionalInformation" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="Content"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;simpleContent&gt;
             *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalInformationContentTextType"&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleContent&gt;
             *                     &lt;/complexType&gt;
             *                   &lt;/element&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="Status" maxOccurs="99"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="NameCode"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;simpleContent&gt;
             *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;StatusNameCodeType"&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleContent&gt;
             *                     &lt;/complexType&gt;
             *                   &lt;/element&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "sequenceNumeric",
                "additionalDocument",
                "additionalInformation",
                "status"
            })
            public static class GovernmentAgencyGoodsItem {

                @XmlElement(name = "SequenceNumeric")
                protected BigDecimal sequenceNumeric;
                @XmlElement(name = "AdditionalDocument")
                protected Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalDocument additionalDocument;
                @XmlElement(name = "AdditionalInformation")
                protected Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalInformation additionalInformation;
                @XmlElement(name = "Status", required = true)
                protected List<Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.Status> status;

                /**
                 * 取得 sequenceNumeric 特性的值.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getSequenceNumeric() {
                    return sequenceNumeric;
                }

                /**
                 * 設定 sequenceNumeric 特性的值.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setSequenceNumeric(BigDecimal value) {
                    this.sequenceNumeric = value;
                }

                /**
                 * 取得 additionalDocument 特性的值.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalDocument }
                 *     
                 */
                public Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalDocument getAdditionalDocument() {
                    return additionalDocument;
                }

                /**
                 * 設定 additionalDocument 特性的值.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalDocument }
                 *     
                 */
                public void setAdditionalDocument(Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalDocument value) {
                    this.additionalDocument = value;
                }

                /**
                 * 取得 additionalInformation 特性的值.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalInformation }
                 *     
                 */
                public Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalInformation getAdditionalInformation() {
                    return additionalInformation;
                }

                /**
                 * 設定 additionalInformation 特性的值.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalInformation }
                 *     
                 */
                public void setAdditionalInformation(Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalInformation value) {
                    this.additionalInformation = value;
                }

                /**
                 * Gets the value of the status property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the status property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getStatus().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.Status }
                 * 
                 * 
                 */
                public List<Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.Status> getStatus() {
                    if (status == null) {
                        status = new ArrayList<Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.Status>();
                    }
                    return this.status;
                }


                /**
                 * <p>anonymous complex type 的 Java 類別.
                 * 
                 * <p>下列綱要片段會指定此類別中包含的預期內容.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;complexContent&gt;
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *       &lt;sequence&gt;
                 *         &lt;element name="tw_SequenceNumeric"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{urn:wco:datamodel:TW:DS:1}AdditionalDocumentSequenceNumericType"&gt;
                 *               &lt;minInclusive value="0"/&gt;
                 *               &lt;maxInclusive value="9999"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *       &lt;/sequence&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/complexContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "twSequenceNumeric"
                })
                public static class AdditionalDocument {

                    @XmlElement(name = "tw_SequenceNumeric", required = true)
                    protected BigDecimal twSequenceNumeric;

                    /**
                     * 取得 twSequenceNumeric 特性的值.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigDecimal }
                     *     
                     */
                    public BigDecimal getTwSequenceNumeric() {
                        return twSequenceNumeric;
                    }

                    /**
                     * 設定 twSequenceNumeric 特性的值.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigDecimal }
                     *     
                     */
                    public void setTwSequenceNumeric(BigDecimal value) {
                        this.twSequenceNumeric = value;
                    }

                }


                /**
                 * <p>anonymous complex type 的 Java 類別.
                 * 
                 * <p>下列綱要片段會指定此類別中包含的預期內容.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;complexContent&gt;
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *       &lt;sequence&gt;
                 *         &lt;element name="Content"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;simpleContent&gt;
                 *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalInformationContentTextType"&gt;
                 *               &lt;/restriction&gt;
                 *             &lt;/simpleContent&gt;
                 *           &lt;/complexType&gt;
                 *         &lt;/element&gt;
                 *       &lt;/sequence&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/complexContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "content"
                })
                public static class AdditionalInformation {

                    @XmlElement(name = "Content", required = true)
                    protected Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalInformation.Content content;

                    /**
                     * 取得 content 特性的值.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalInformation.Content }
                     *     
                     */
                    public Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalInformation.Content getContent() {
                        return content;
                    }

                    /**
                     * 設定 content 特性的值.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalInformation.Content }
                     *     
                     */
                    public void setContent(Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalInformation.Content value) {
                        this.content = value;
                    }


                    /**
                     * <p>anonymous complex type 的 Java 類別.
                     * 
                     * <p>下列綱要片段會指定此類別中包含的預期內容.
                     * 
                     * <pre>
                     * &lt;complexType&gt;
                     *   &lt;simpleContent&gt;
                     *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalInformationContentTextType"&gt;
                     *     &lt;/restriction&gt;
                     *   &lt;/simpleContent&gt;
                     * &lt;/complexType&gt;
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "")
                    public static class Content
                        extends AdditionalInformationContentTextType
                    {


                    }

                }


                /**
                 * <p>anonymous complex type 的 Java 類別.
                 * 
                 * <p>下列綱要片段會指定此類別中包含的預期內容.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;complexContent&gt;
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *       &lt;sequence&gt;
                 *         &lt;element name="NameCode"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;simpleContent&gt;
                 *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;StatusNameCodeType"&gt;
                 *               &lt;/restriction&gt;
                 *             &lt;/simpleContent&gt;
                 *           &lt;/complexType&gt;
                 *         &lt;/element&gt;
                 *       &lt;/sequence&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/complexContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "nameCode"
                })
                public static class Status {

                    @XmlElement(name = "NameCode", required = true)
                    protected Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.Status.NameCode nameCode;

                    /**
                     * 取得 nameCode 特性的值.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.Status.NameCode }
                     *     
                     */
                    public Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.Status.NameCode getNameCode() {
                        return nameCode;
                    }

                    /**
                     * 設定 nameCode 特性的值.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.Status.NameCode }
                     *     
                     */
                    public void setNameCode(Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.Status.NameCode value) {
                        this.nameCode = value;
                    }


                    /**
                     * <p>anonymous complex type 的 Java 類別.
                     * 
                     * <p>下列綱要片段會指定此類別中包含的預期內容.
                     * 
                     * <pre>
                     * &lt;complexType&gt;
                     *   &lt;simpleContent&gt;
                     *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;StatusNameCodeType"&gt;
                     *     &lt;/restriction&gt;
                     *   &lt;/simpleContent&gt;
                     * &lt;/complexType&gt;
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "")
                    public static class NameCode
                        extends StatusNameCodeType
                    {


                    }

                }

            }

        }


        /**
         * <p>anonymous complex type 的 Java 類別.
         * 
         * <p>下列綱要片段會指定此類別中包含的預期內容.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;DeclarationIdentificationIDType"&gt;
         *     &lt;/restriction&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class ID
            extends DeclarationIdentificationIDType
        {


        }


        /**
         * <p>anonymous complex type 的 Java 類別.
         * 
         * <p>下列綱要片段會指定此類別中包含的預期內容.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="tw_FunctionalReferenceID"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;PreviousDocumentFunctionalReferenceIDType"&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "twFunctionalReferenceID"
        })
        public static class PreviousDocument {

            @XmlElement(name = "tw_FunctionalReferenceID", required = true)
            protected Response.Declaration.PreviousDocument.TwFunctionalReferenceID twFunctionalReferenceID;

            /**
             * 取得 twFunctionalReferenceID 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.PreviousDocument.TwFunctionalReferenceID }
             *     
             */
            public Response.Declaration.PreviousDocument.TwFunctionalReferenceID getTwFunctionalReferenceID() {
                return twFunctionalReferenceID;
            }

            /**
             * 設定 twFunctionalReferenceID 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.PreviousDocument.TwFunctionalReferenceID }
             *     
             */
            public void setTwFunctionalReferenceID(Response.Declaration.PreviousDocument.TwFunctionalReferenceID value) {
                this.twFunctionalReferenceID = value;
            }


            /**
             * <p>anonymous complex type 的 Java 類別.
             * 
             * <p>下列綱要片段會指定此類別中包含的預期內容.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;simpleContent&gt;
             *     &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;PreviousDocumentFunctionalReferenceIDType"&gt;
             *     &lt;/restriction&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class TwFunctionalReferenceID
                extends PreviousDocumentFunctionalReferenceIDType
            {


            }

        }


        /**
         * <p>anonymous complex type 的 Java 類別.
         * 
         * <p>下列綱要片段會指定此類別中包含的預期內容.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="ID"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;ResponsibleGovernmentAgencyIdentificationIDType"&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "id"
        })
        public static class ResponsibleGovernmentAgency {

            @XmlElement(name = "ID", required = true)
            protected Response.Declaration.ResponsibleGovernmentAgency.ID id;

            /**
             * 取得 id 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.ResponsibleGovernmentAgency.ID }
             *     
             */
            public Response.Declaration.ResponsibleGovernmentAgency.ID getID() {
                return id;
            }

            /**
             * 設定 id 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.ResponsibleGovernmentAgency.ID }
             *     
             */
            public void setID(Response.Declaration.ResponsibleGovernmentAgency.ID value) {
                this.id = value;
            }


            /**
             * <p>anonymous complex type 的 Java 類別.
             * 
             * <p>下列綱要片段會指定此類別中包含的預期內容.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;simpleContent&gt;
             *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;ResponsibleGovernmentAgencyIdentificationIDType"&gt;
             *     &lt;/restriction&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class ID
                extends ResponsibleGovernmentAgencyIdentificationIDType
            {


            }

        }


        /**
         * <p>anonymous complex type 的 Java 類別.
         * 
         * <p>下列綱要片段會指定此類別中包含的預期內容.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="tw_TypeCode" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;ApplicationTypeCodeType"&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Agent" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="ID"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;simpleContent&gt;
         *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AgentIdentificationIDType"&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/simpleContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="tw_Applicant" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="tw_ID"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;simpleContent&gt;
         *                         &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;ApplicantIdentificationIDType"&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/simpleContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "twTypeCode",
            "agent",
            "twApplicant"
        })
        public static class TwApplication {

            @XmlElement(name = "tw_TypeCode")
            protected Response.Declaration.TwApplication.TwTypeCode twTypeCode;
            @XmlElement(name = "Agent")
            protected Response.Declaration.TwApplication.Agent agent;
            @XmlElement(name = "tw_Applicant")
            protected Response.Declaration.TwApplication.TwApplicant twApplicant;

            /**
             * 取得 twTypeCode 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.TwApplication.TwTypeCode }
             *     
             */
            public Response.Declaration.TwApplication.TwTypeCode getTwTypeCode() {
                return twTypeCode;
            }

            /**
             * 設定 twTypeCode 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.TwApplication.TwTypeCode }
             *     
             */
            public void setTwTypeCode(Response.Declaration.TwApplication.TwTypeCode value) {
                this.twTypeCode = value;
            }

            /**
             * 取得 agent 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.TwApplication.Agent }
             *     
             */
            public Response.Declaration.TwApplication.Agent getAgent() {
                return agent;
            }

            /**
             * 設定 agent 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.TwApplication.Agent }
             *     
             */
            public void setAgent(Response.Declaration.TwApplication.Agent value) {
                this.agent = value;
            }

            /**
             * 取得 twApplicant 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.TwApplication.TwApplicant }
             *     
             */
            public Response.Declaration.TwApplication.TwApplicant getTwApplicant() {
                return twApplicant;
            }

            /**
             * 設定 twApplicant 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.TwApplication.TwApplicant }
             *     
             */
            public void setTwApplicant(Response.Declaration.TwApplication.TwApplicant value) {
                this.twApplicant = value;
            }


            /**
             * <p>anonymous complex type 的 Java 類別.
             * 
             * <p>下列綱要片段會指定此類別中包含的預期內容.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="ID"&gt;
             *           &lt;complexType&gt;
             *             &lt;simpleContent&gt;
             *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AgentIdentificationIDType"&gt;
             *               &lt;/restriction&gt;
             *             &lt;/simpleContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "id"
            })
            public static class Agent {

                @XmlElement(name = "ID", required = true)
                protected Response.Declaration.TwApplication.Agent.ID id;

                /**
                 * 取得 id 特性的值.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Response.Declaration.TwApplication.Agent.ID }
                 *     
                 */
                public Response.Declaration.TwApplication.Agent.ID getID() {
                    return id;
                }

                /**
                 * 設定 id 特性的值.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Response.Declaration.TwApplication.Agent.ID }
                 *     
                 */
                public void setID(Response.Declaration.TwApplication.Agent.ID value) {
                    this.id = value;
                }


                /**
                 * <p>anonymous complex type 的 Java 類別.
                 * 
                 * <p>下列綱要片段會指定此類別中包含的預期內容.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;simpleContent&gt;
                 *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AgentIdentificationIDType"&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/simpleContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class ID
                    extends AgentIdentificationIDType
                {


                }

            }


            /**
             * <p>anonymous complex type 的 Java 類別.
             * 
             * <p>下列綱要片段會指定此類別中包含的預期內容.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="tw_ID"&gt;
             *           &lt;complexType&gt;
             *             &lt;simpleContent&gt;
             *               &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;ApplicantIdentificationIDType"&gt;
             *               &lt;/restriction&gt;
             *             &lt;/simpleContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "twID"
            })
            public static class TwApplicant {

                @XmlElement(name = "tw_ID", required = true)
                protected Response.Declaration.TwApplication.TwApplicant.TwID twID;

                /**
                 * 取得 twID 特性的值.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Response.Declaration.TwApplication.TwApplicant.TwID }
                 *     
                 */
                public Response.Declaration.TwApplication.TwApplicant.TwID getTwID() {
                    return twID;
                }

                /**
                 * 設定 twID 特性的值.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Response.Declaration.TwApplication.TwApplicant.TwID }
                 *     
                 */
                public void setTwID(Response.Declaration.TwApplication.TwApplicant.TwID value) {
                    this.twID = value;
                }


                /**
                 * <p>anonymous complex type 的 Java 類別.
                 * 
                 * <p>下列綱要片段會指定此類別中包含的預期內容.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;simpleContent&gt;
                 *     &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;ApplicantIdentificationIDType"&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/simpleContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class TwID
                    extends ApplicantIdentificationIDType
                {


                }

            }


            /**
             * <p>anonymous complex type 的 Java 類別.
             * 
             * <p>下列綱要片段會指定此類別中包含的預期內容.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;simpleContent&gt;
             *     &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;ApplicationTypeCodeType"&gt;
             *     &lt;/restriction&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class TwTypeCode
                extends ApplicationTypeCodeType
            {


            }

        }

    }


    /**
     * <p>anonymous complex type 的 Java 類別.
     * 
     * <p>下列綱要片段會指定此類別中包含的預期內容.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="NameCode"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;StatusNameCodeType"&gt;
     *               &lt;/restriction&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "nameCode"
    })
    public static class Status {

        @XmlElement(name = "NameCode", required = true)
        protected Response.Status.NameCode nameCode;

        /**
         * 取得 nameCode 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link Response.Status.NameCode }
         *     
         */
        public Response.Status.NameCode getNameCode() {
            return nameCode;
        }

        /**
         * 設定 nameCode 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link Response.Status.NameCode }
         *     
         */
        public void setNameCode(Response.Status.NameCode value) {
            this.nameCode = value;
        }


        /**
         * <p>anonymous complex type 的 Java 類別.
         * 
         * <p>下列綱要片段會指定此類別中包含的預期內容.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;StatusNameCodeType"&gt;
         *     &lt;/restriction&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class NameCode
            extends StatusNameCodeType
        {


        }

    }

}
