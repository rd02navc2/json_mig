//
// 此檔案是由 Eclipse Implementation of JAXB, v2.3.8 所產生 
// 請參閱 https://eclipse-ee4j.github.io/jaxb-ri 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2025.10.20 於 05:04:53 PM CST 
//


package wco.datamodel.tw.nx902.r_00_03;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import tw.gov.customs.schema.n5107.wcods.AdditionalDocumentIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.AdditionalInformationContentTextType;
import tw.gov.customs.schema.n5107.wcods.AgentIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.AgentRoleCodeType;
import tw.gov.customs.schema.n5107.wcods.ContactOfficeIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.DeclarationFunctionCodeType;
import tw.gov.customs.schema.n5107.wcods.DeclarationIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.GovernmentProcedureCurrentCodeType;
import tw.gov.customs.schema.n5107.wcods.PaymentPaymentAmountType;
import tw.gov.customs.schema.n5107.wcods.PaymentReferenceIDType;
import tw.gov.customs.schema.n5107.wcods.ResponsibleGovernmentAgencyIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.StatusNameCodeType;
import wco.datamodel.tw.ds._1.AdditionalInformationProcessNumberTextType;
import wco.datamodel.tw.ds._1.AgentSubBoxIDType;
import wco.datamodel.tw.ds._1.ApplicantIdentificationIDType;
import wco.datamodel.tw.ds._1.ApplicationTypeCodeType;
import wco.datamodel.tw.ds._1.PreviousDocumentFunctionalReferenceIDType;
import wco.datamodel.tw.ds._1.SamplingPeriodCodeType;


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
 *         &lt;element name="Status" minOccurs="0"&gt;
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
 *         &lt;element name="tw_Sampling" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="tw_PeriodCode" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;SamplingPeriodCodeType"&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="tw_SamplingDate" type="{urn:wco:datamodel:TW:DS:1}SamplingSamplingDateType" minOccurs="0"/&gt;
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
 *                   &lt;element name="DutyTaxFee" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="Payment" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="PaymentAmount" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;simpleContent&gt;
 *                                             &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PaymentPaymentAmountType"&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="ReferenceID" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;simpleContent&gt;
 *                                             &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PaymentReferenceIDType"&gt;
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
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="GovernmentProcedure" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="CurrentCode" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;GovernmentProcedureCurrentCodeType"&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleContent&gt;
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
    "twSampling",
    "declaration"
})
@XmlRootElement(name = "Response")
public class Response {

    @XmlElement(name = "IssueDateTime")
    protected String issueDateTime;
    @XmlElement(name = "ContactOffice")
    protected Response.ContactOffice contactOffice;
    @XmlElement(name = "Status")
    protected Response.Status status;
    @XmlElement(name = "tw_Sampling")
    protected Response.TwSampling twSampling;
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
     * 取得 status 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link Response.Status }
     *     
     */
    public Response.Status getStatus() {
        return status;
    }

    /**
     * 設定 status 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link Response.Status }
     *     
     */
    public void setStatus(Response.Status value) {
        this.status = value;
    }

    /**
     * 取得 twSampling 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link Response.TwSampling }
     *     
     */
    public Response.TwSampling getTwSampling() {
        return twSampling;
    }

    /**
     * 設定 twSampling 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link Response.TwSampling }
     *     
     */
    public void setTwSampling(Response.TwSampling value) {
        this.twSampling = value;
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
     *         &lt;element name="DutyTaxFee" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="Payment" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="PaymentAmount" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;simpleContent&gt;
     *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PaymentPaymentAmountType"&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="ReferenceID" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;simpleContent&gt;
     *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PaymentReferenceIDType"&gt;
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
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="GovernmentProcedure" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="CurrentCode" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;GovernmentProcedureCurrentCodeType"&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleContent&gt;
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
        "dutyTaxFee",
        "goodsShipment",
        "governmentProcedure",
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
        @XmlElement(name = "DutyTaxFee")
        protected Response.Declaration.DutyTaxFee dutyTaxFee;
        @XmlElement(name = "GoodsShipment")
        protected Response.Declaration.GoodsShipment goodsShipment;
        @XmlElement(name = "GovernmentProcedure")
        protected Response.Declaration.GovernmentProcedure governmentProcedure;
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
         * 取得 dutyTaxFee 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link Response.Declaration.DutyTaxFee }
         *     
         */
        public Response.Declaration.DutyTaxFee getDutyTaxFee() {
            return dutyTaxFee;
        }

        /**
         * 設定 dutyTaxFee 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link Response.Declaration.DutyTaxFee }
         *     
         */
        public void setDutyTaxFee(Response.Declaration.DutyTaxFee value) {
            this.dutyTaxFee = value;
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
         * 取得 governmentProcedure 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link Response.Declaration.GovernmentProcedure }
         *     
         */
        public Response.Declaration.GovernmentProcedure getGovernmentProcedure() {
            return governmentProcedure;
        }

        /**
         * 設定 governmentProcedure 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link Response.Declaration.GovernmentProcedure }
         *     
         */
        public void setGovernmentProcedure(Response.Declaration.GovernmentProcedure value) {
            this.governmentProcedure = value;
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
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="Payment" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="PaymentAmount" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;simpleContent&gt;
         *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PaymentPaymentAmountType"&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/simpleContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="ReferenceID" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;simpleContent&gt;
         *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PaymentReferenceIDType"&gt;
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
            "payment"
        })
        public static class DutyTaxFee {

            @XmlElement(name = "Payment")
            protected Response.Declaration.DutyTaxFee.Payment payment;

            /**
             * 取得 payment 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.DutyTaxFee.Payment }
             *     
             */
            public Response.Declaration.DutyTaxFee.Payment getPayment() {
                return payment;
            }

            /**
             * 設定 payment 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.DutyTaxFee.Payment }
             *     
             */
            public void setPayment(Response.Declaration.DutyTaxFee.Payment value) {
                this.payment = value;
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
             *         &lt;element name="PaymentAmount" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;simpleContent&gt;
             *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PaymentPaymentAmountType"&gt;
             *               &lt;/restriction&gt;
             *             &lt;/simpleContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="ReferenceID" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;simpleContent&gt;
             *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PaymentReferenceIDType"&gt;
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
                "paymentAmount",
                "referenceID"
            })
            public static class Payment {

                @XmlElement(name = "PaymentAmount")
                protected Response.Declaration.DutyTaxFee.Payment.PaymentAmount paymentAmount;
                @XmlElement(name = "ReferenceID")
                protected Response.Declaration.DutyTaxFee.Payment.ReferenceID referenceID;

                /**
                 * 取得 paymentAmount 特性的值.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Response.Declaration.DutyTaxFee.Payment.PaymentAmount }
                 *     
                 */
                public Response.Declaration.DutyTaxFee.Payment.PaymentAmount getPaymentAmount() {
                    return paymentAmount;
                }

                /**
                 * 設定 paymentAmount 特性的值.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Response.Declaration.DutyTaxFee.Payment.PaymentAmount }
                 *     
                 */
                public void setPaymentAmount(Response.Declaration.DutyTaxFee.Payment.PaymentAmount value) {
                    this.paymentAmount = value;
                }

                /**
                 * 取得 referenceID 特性的值.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Response.Declaration.DutyTaxFee.Payment.ReferenceID }
                 *     
                 */
                public Response.Declaration.DutyTaxFee.Payment.ReferenceID getReferenceID() {
                    return referenceID;
                }

                /**
                 * 設定 referenceID 特性的值.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Response.Declaration.DutyTaxFee.Payment.ReferenceID }
                 *     
                 */
                public void setReferenceID(Response.Declaration.DutyTaxFee.Payment.ReferenceID value) {
                    this.referenceID = value;
                }


                /**
                 * <p>anonymous complex type 的 Java 類別.
                 * 
                 * <p>下列綱要片段會指定此類別中包含的預期內容.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;simpleContent&gt;
                 *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PaymentPaymentAmountType"&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/simpleContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class PaymentAmount
                    extends PaymentPaymentAmountType
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
                 *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PaymentReferenceIDType"&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/simpleContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class ReferenceID
                    extends PaymentReferenceIDType
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
            "additionalDocument"
        })
        public static class GoodsShipment {

            @XmlElement(name = "AdditionalDocument")
            protected Response.Declaration.GoodsShipment.AdditionalDocument additionalDocument;

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
         *         &lt;element name="CurrentCode" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;GovernmentProcedureCurrentCodeType"&gt;
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
            "currentCode"
        })
        public static class GovernmentProcedure {

            @XmlElement(name = "CurrentCode")
            protected Response.Declaration.GovernmentProcedure.CurrentCode currentCode;

            /**
             * 取得 currentCode 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.GovernmentProcedure.CurrentCode }
             *     
             */
            public Response.Declaration.GovernmentProcedure.CurrentCode getCurrentCode() {
                return currentCode;
            }

            /**
             * 設定 currentCode 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.GovernmentProcedure.CurrentCode }
             *     
             */
            public void setCurrentCode(Response.Declaration.GovernmentProcedure.CurrentCode value) {
                this.currentCode = value;
            }


            /**
             * <p>anonymous complex type 的 Java 類別.
             * 
             * <p>下列綱要片段會指定此類別中包含的預期內容.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;simpleContent&gt;
             *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;GovernmentProcedureCurrentCodeType"&gt;
             *     &lt;/restriction&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class CurrentCode
                extends GovernmentProcedureCurrentCodeType
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
     *         &lt;element name="tw_PeriodCode" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;SamplingPeriodCodeType"&gt;
     *               &lt;/restriction&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="tw_SamplingDate" type="{urn:wco:datamodel:TW:DS:1}SamplingSamplingDateType" minOccurs="0"/&gt;
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
        "twPeriodCode",
        "twSamplingDate"
    })
    public static class TwSampling {

        @XmlElement(name = "tw_PeriodCode")
        protected Response.TwSampling.TwPeriodCode twPeriodCode;
        @XmlElement(name = "tw_SamplingDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar twSamplingDate;

        /**
         * 取得 twPeriodCode 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link Response.TwSampling.TwPeriodCode }
         *     
         */
        public Response.TwSampling.TwPeriodCode getTwPeriodCode() {
            return twPeriodCode;
        }

        /**
         * 設定 twPeriodCode 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link Response.TwSampling.TwPeriodCode }
         *     
         */
        public void setTwPeriodCode(Response.TwSampling.TwPeriodCode value) {
            this.twPeriodCode = value;
        }

        /**
         * 取得 twSamplingDate 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getTwSamplingDate() {
            return twSamplingDate;
        }

        /**
         * 設定 twSamplingDate 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setTwSamplingDate(XMLGregorianCalendar value) {
            this.twSamplingDate = value;
        }


        /**
         * <p>anonymous complex type 的 Java 類別.
         * 
         * <p>下列綱要片段會指定此類別中包含的預期內容.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;SamplingPeriodCodeType"&gt;
         *     &lt;/restriction&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class TwPeriodCode
            extends SamplingPeriodCodeType
        {


        }

    }

}
