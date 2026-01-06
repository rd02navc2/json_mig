//
// 此檔案是由 Eclipse Implementation of JAXB, v2.3.8 所產生 
// 請參閱 https://eclipse-ee4j.github.io/jaxb-ri 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2025.10.20 於 05:04:18 PM CST 
//


package wco.datamodel.tw.n5107.r_00_05;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tw.gov.customs.schema.n5107.wcods.AdditionalInformationStatementCodeType;
import tw.gov.customs.schema.n5107.wcods.AgentIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.AgentRoleCodeType;
import tw.gov.customs.schema.n5107.wcods.AssociatedTransportDocumentIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.BorderTransportMeansJourneyIDType;
import tw.gov.customs.schema.n5107.wcods.BorderTransportMeansTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.CarrierIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ConsignmentBoardedQuantityType;
import tw.gov.customs.schema.n5107.wcods.ContactOfficeIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.DeclarationIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.DeclarationTotalPackageQuantityType;
import tw.gov.customs.schema.n5107.wcods.DeclarationTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.ErrorValidationCodeType;
import tw.gov.customs.schema.n5107.wcods.PackagingTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.StatusNameCodeType;
import tw.gov.customs.schema.n5107.wcods.TransportContractDocumentIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.TransportContractDocumentTypeCodeType;
import wco.datamodel.tw.ds._1.AgentSubBoxIDType;
import wco.datamodel.tw.ds._1.GovernmentProcedureTransportTypeCodeType;


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
 *         &lt;element name="IssueDateTime" type="{urn:wco:datamodel:WCO:DS:1}ResponseIssueDateTimeType"/&gt;
 *         &lt;element name="AdditionalInformation"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="LimitDateTime" type="{urn:wco:datamodel:WCO:DS:1}AdditionalInformationLimitDateTimeType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ContactOffice"&gt;
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
 *         &lt;element name="Status"&gt;
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
 *                   &lt;element name="ID"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;DeclarationIdentificationIDType"&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="TotalPackageQuantity" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;DeclarationTotalPackageQuantityType"&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="TypeCode" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;DeclarationTypeCodeType"&gt;
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
 *                   &lt;element name="BorderTransportMeans"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="ArrivalDateTime" type="{urn:wco:datamodel:WCO:DS:1}BorderTransportMeansArrivalDateTimeType" minOccurs="0"/&gt;
 *                             &lt;element name="TypeCode"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;BorderTransportMeansTypeCodeType"&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Consignment" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="BoardedQuantity" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;ConsignmentBoardedQuantityType"&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="AssociatedTransportDocument" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="ID"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;simpleContent&gt;
 *                                             &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AssociatedTransportDocumentIdentificationIDType"&gt;
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
 *                   &lt;element name="GoodsShipment"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="Consignment"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="BorderTransportMeans" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="JourneyID"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;simpleContent&gt;
 *                                                       &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;BorderTransportMeansJourneyIDType"&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/simpleContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="Carrier" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="ID"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;simpleContent&gt;
 *                                                       &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;CarrierIdentificationIDType"&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/simpleContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TransportContractDocument" maxOccurs="4"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="ID"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;simpleContent&gt;
 *                                                       &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;TransportContractDocumentIdentificationIDType"&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/simpleContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                                 &lt;element name="TypeCode"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;simpleContent&gt;
 *                                                       &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;TransportContractDocumentTypeCodeType"&gt;
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
 *                             &lt;element name="GovernmentAgencyGoodsItem" maxOccurs="99" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="SequenceNumeric"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{urn:wco:datamodel:WCO:DS:1}GovernmentAgencyGoodsItemSequenceNumericType"&gt;
 *                                             &lt;minInclusive value="0"/&gt;
 *                                             &lt;maxInclusive value="9999"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="AdditionalInformation" maxOccurs="9" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="StatementCode"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;simpleContent&gt;
 *                                                       &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalInformationStatementCodeType"&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/simpleContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="Error" maxOccurs="9"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="ValidationCode"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;simpleContent&gt;
 *                                                       &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;ErrorValidationCodeType"&gt;
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
 *                   &lt;element name="GovernmentProcedure"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="tw_TransportTypeCode"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;GovernmentProcedureTransportTypeCodeType"&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Packaging" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="TypeCode"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PackagingTypeCodeType"&gt;
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
    "issueDateTime",
    "additionalInformation",
    "contactOffice",
    "status",
    "declaration"
})
@XmlRootElement(name = "Response")
public class Response {

    @XmlElement(name = "IssueDateTime", required = true)
    protected String issueDateTime;
    @XmlElement(name = "AdditionalInformation", required = true)
    protected Response.AdditionalInformation additionalInformation;
    @XmlElement(name = "ContactOffice", required = true)
    protected Response.ContactOffice contactOffice;
    @XmlElement(name = "Status", required = true)
    protected Response.Status status;
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
     * 取得 additionalInformation 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link Response.AdditionalInformation }
     *     
     */
    public Response.AdditionalInformation getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * 設定 additionalInformation 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link Response.AdditionalInformation }
     *     
     */
    public void setAdditionalInformation(Response.AdditionalInformation value) {
        this.additionalInformation = value;
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
     *         &lt;element name="LimitDateTime" type="{urn:wco:datamodel:WCO:DS:1}AdditionalInformationLimitDateTimeType"/&gt;
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
        "limitDateTime"
    })
    public static class AdditionalInformation {

        @XmlElement(name = "LimitDateTime", required = true)
        protected String limitDateTime;

        /**
         * 取得 limitDateTime 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLimitDateTime() {
            return limitDateTime;
        }

        /**
         * 設定 limitDateTime 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLimitDateTime(String value) {
            this.limitDateTime = value;
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
     *         &lt;element name="ID"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;DeclarationIdentificationIDType"&gt;
     *               &lt;/restriction&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="TotalPackageQuantity" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;DeclarationTotalPackageQuantityType"&gt;
     *               &lt;/restriction&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="TypeCode" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;DeclarationTypeCodeType"&gt;
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
     *         &lt;element name="BorderTransportMeans"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="ArrivalDateTime" type="{urn:wco:datamodel:WCO:DS:1}BorderTransportMeansArrivalDateTimeType" minOccurs="0"/&gt;
     *                   &lt;element name="TypeCode"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;BorderTransportMeansTypeCodeType"&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Consignment" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="BoardedQuantity" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;ConsignmentBoardedQuantityType"&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="AssociatedTransportDocument" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="ID"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;simpleContent&gt;
     *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AssociatedTransportDocumentIdentificationIDType"&gt;
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
     *         &lt;element name="GoodsShipment"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="Consignment"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="BorderTransportMeans" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="JourneyID"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;simpleContent&gt;
     *                                             &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;BorderTransportMeansJourneyIDType"&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/simpleContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="Carrier" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="ID"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;simpleContent&gt;
     *                                             &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;CarrierIdentificationIDType"&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/simpleContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TransportContractDocument" maxOccurs="4"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="ID"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;simpleContent&gt;
     *                                             &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;TransportContractDocumentIdentificationIDType"&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/simpleContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
     *                                       &lt;element name="TypeCode"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;simpleContent&gt;
     *                                             &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;TransportContractDocumentTypeCodeType"&gt;
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
     *                   &lt;element name="GovernmentAgencyGoodsItem" maxOccurs="99" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="SequenceNumeric"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{urn:wco:datamodel:WCO:DS:1}GovernmentAgencyGoodsItemSequenceNumericType"&gt;
     *                                   &lt;minInclusive value="0"/&gt;
     *                                   &lt;maxInclusive value="9999"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="AdditionalInformation" maxOccurs="9" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="StatementCode"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;simpleContent&gt;
     *                                             &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalInformationStatementCodeType"&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/simpleContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="Error" maxOccurs="9"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="ValidationCode"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;simpleContent&gt;
     *                                             &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;ErrorValidationCodeType"&gt;
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
     *         &lt;element name="GovernmentProcedure"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="tw_TransportTypeCode"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;GovernmentProcedureTransportTypeCodeType"&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Packaging" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="TypeCode"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PackagingTypeCodeType"&gt;
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
        "id",
        "totalPackageQuantity",
        "typeCode",
        "agent",
        "borderTransportMeans",
        "consignment",
        "goodsShipment",
        "governmentProcedure",
        "packaging"
    })
    public static class Declaration {

        @XmlElement(name = "ID", required = true)
        protected Response.Declaration.ID id;
        @XmlElement(name = "TotalPackageQuantity")
        protected Response.Declaration.TotalPackageQuantity totalPackageQuantity;
        @XmlElement(name = "TypeCode")
        protected Response.Declaration.TypeCode typeCode;
        @XmlElement(name = "Agent")
        protected Response.Declaration.Agent agent;
        @XmlElement(name = "BorderTransportMeans", required = true)
        protected Response.Declaration.BorderTransportMeans borderTransportMeans;
        @XmlElement(name = "Consignment")
        protected Response.Declaration.Consignment consignment;
        @XmlElement(name = "GoodsShipment", required = true)
        protected Response.Declaration.GoodsShipment goodsShipment;
        @XmlElement(name = "GovernmentProcedure", required = true)
        protected Response.Declaration.GovernmentProcedure governmentProcedure;
        @XmlElement(name = "Packaging")
        protected Response.Declaration.Packaging packaging;

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
         * 取得 totalPackageQuantity 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link Response.Declaration.TotalPackageQuantity }
         *     
         */
        public Response.Declaration.TotalPackageQuantity getTotalPackageQuantity() {
            return totalPackageQuantity;
        }

        /**
         * 設定 totalPackageQuantity 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link Response.Declaration.TotalPackageQuantity }
         *     
         */
        public void setTotalPackageQuantity(Response.Declaration.TotalPackageQuantity value) {
            this.totalPackageQuantity = value;
        }

        /**
         * 取得 typeCode 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link Response.Declaration.TypeCode }
         *     
         */
        public Response.Declaration.TypeCode getTypeCode() {
            return typeCode;
        }

        /**
         * 設定 typeCode 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link Response.Declaration.TypeCode }
         *     
         */
        public void setTypeCode(Response.Declaration.TypeCode value) {
            this.typeCode = value;
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
         * 取得 borderTransportMeans 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link Response.Declaration.BorderTransportMeans }
         *     
         */
        public Response.Declaration.BorderTransportMeans getBorderTransportMeans() {
            return borderTransportMeans;
        }

        /**
         * 設定 borderTransportMeans 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link Response.Declaration.BorderTransportMeans }
         *     
         */
        public void setBorderTransportMeans(Response.Declaration.BorderTransportMeans value) {
            this.borderTransportMeans = value;
        }

        /**
         * 取得 consignment 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link Response.Declaration.Consignment }
         *     
         */
        public Response.Declaration.Consignment getConsignment() {
            return consignment;
        }

        /**
         * 設定 consignment 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link Response.Declaration.Consignment }
         *     
         */
        public void setConsignment(Response.Declaration.Consignment value) {
            this.consignment = value;
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
         * 取得 packaging 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link Response.Declaration.Packaging }
         *     
         */
        public Response.Declaration.Packaging getPackaging() {
            return packaging;
        }

        /**
         * 設定 packaging 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link Response.Declaration.Packaging }
         *     
         */
        public void setPackaging(Response.Declaration.Packaging value) {
            this.packaging = value;
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
         *         &lt;element name="ArrivalDateTime" type="{urn:wco:datamodel:WCO:DS:1}BorderTransportMeansArrivalDateTimeType" minOccurs="0"/&gt;
         *         &lt;element name="TypeCode"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;BorderTransportMeansTypeCodeType"&gt;
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
            "arrivalDateTime",
            "typeCode"
        })
        public static class BorderTransportMeans {

            @XmlElement(name = "ArrivalDateTime")
            protected String arrivalDateTime;
            @XmlElement(name = "TypeCode", required = true)
            protected Response.Declaration.BorderTransportMeans.TypeCode typeCode;

            /**
             * 取得 arrivalDateTime 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getArrivalDateTime() {
                return arrivalDateTime;
            }

            /**
             * 設定 arrivalDateTime 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setArrivalDateTime(String value) {
                this.arrivalDateTime = value;
            }

            /**
             * 取得 typeCode 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.BorderTransportMeans.TypeCode }
             *     
             */
            public Response.Declaration.BorderTransportMeans.TypeCode getTypeCode() {
                return typeCode;
            }

            /**
             * 設定 typeCode 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.BorderTransportMeans.TypeCode }
             *     
             */
            public void setTypeCode(Response.Declaration.BorderTransportMeans.TypeCode value) {
                this.typeCode = value;
            }


            /**
             * <p>anonymous complex type 的 Java 類別.
             * 
             * <p>下列綱要片段會指定此類別中包含的預期內容.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;simpleContent&gt;
             *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;BorderTransportMeansTypeCodeType"&gt;
             *     &lt;/restriction&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class TypeCode
                extends BorderTransportMeansTypeCodeType
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
         *         &lt;element name="BoardedQuantity" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;ConsignmentBoardedQuantityType"&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="AssociatedTransportDocument" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="ID"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;simpleContent&gt;
         *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AssociatedTransportDocumentIdentificationIDType"&gt;
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
            "boardedQuantity",
            "associatedTransportDocument"
        })
        public static class Consignment {

            @XmlElement(name = "BoardedQuantity")
            protected Response.Declaration.Consignment.BoardedQuantity boardedQuantity;
            @XmlElement(name = "AssociatedTransportDocument")
            protected Response.Declaration.Consignment.AssociatedTransportDocument associatedTransportDocument;

            /**
             * 取得 boardedQuantity 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.Consignment.BoardedQuantity }
             *     
             */
            public Response.Declaration.Consignment.BoardedQuantity getBoardedQuantity() {
                return boardedQuantity;
            }

            /**
             * 設定 boardedQuantity 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.Consignment.BoardedQuantity }
             *     
             */
            public void setBoardedQuantity(Response.Declaration.Consignment.BoardedQuantity value) {
                this.boardedQuantity = value;
            }

            /**
             * 取得 associatedTransportDocument 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.Consignment.AssociatedTransportDocument }
             *     
             */
            public Response.Declaration.Consignment.AssociatedTransportDocument getAssociatedTransportDocument() {
                return associatedTransportDocument;
            }

            /**
             * 設定 associatedTransportDocument 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.Consignment.AssociatedTransportDocument }
             *     
             */
            public void setAssociatedTransportDocument(Response.Declaration.Consignment.AssociatedTransportDocument value) {
                this.associatedTransportDocument = value;
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
             *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AssociatedTransportDocumentIdentificationIDType"&gt;
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
            public static class AssociatedTransportDocument {

                @XmlElement(name = "ID", required = true)
                protected Response.Declaration.Consignment.AssociatedTransportDocument.ID id;

                /**
                 * 取得 id 特性的值.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Response.Declaration.Consignment.AssociatedTransportDocument.ID }
                 *     
                 */
                public Response.Declaration.Consignment.AssociatedTransportDocument.ID getID() {
                    return id;
                }

                /**
                 * 設定 id 特性的值.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Response.Declaration.Consignment.AssociatedTransportDocument.ID }
                 *     
                 */
                public void setID(Response.Declaration.Consignment.AssociatedTransportDocument.ID value) {
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
                 *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AssociatedTransportDocumentIdentificationIDType"&gt;
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
                    extends AssociatedTransportDocumentIdentificationIDType
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
             *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;ConsignmentBoardedQuantityType"&gt;
             *     &lt;/restriction&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class BoardedQuantity
                extends ConsignmentBoardedQuantityType
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
         *         &lt;element name="Consignment"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="BorderTransportMeans" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="JourneyID"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;simpleContent&gt;
         *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;BorderTransportMeansJourneyIDType"&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleContent&gt;
         *                               &lt;/complexType&gt;
         *                             &lt;/element&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="Carrier" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="ID"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;simpleContent&gt;
         *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;CarrierIdentificationIDType"&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleContent&gt;
         *                               &lt;/complexType&gt;
         *                             &lt;/element&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TransportContractDocument" maxOccurs="4"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="ID"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;simpleContent&gt;
         *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;TransportContractDocumentIdentificationIDType"&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleContent&gt;
         *                               &lt;/complexType&gt;
         *                             &lt;/element&gt;
         *                             &lt;element name="TypeCode"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;simpleContent&gt;
         *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;TransportContractDocumentTypeCodeType"&gt;
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
         *         &lt;element name="GovernmentAgencyGoodsItem" maxOccurs="99" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="SequenceNumeric"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{urn:wco:datamodel:WCO:DS:1}GovernmentAgencyGoodsItemSequenceNumericType"&gt;
         *                         &lt;minInclusive value="0"/&gt;
         *                         &lt;maxInclusive value="9999"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="AdditionalInformation" maxOccurs="9" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="StatementCode"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;simpleContent&gt;
         *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalInformationStatementCodeType"&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleContent&gt;
         *                               &lt;/complexType&gt;
         *                             &lt;/element&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="Error" maxOccurs="9"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="ValidationCode"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;simpleContent&gt;
         *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;ErrorValidationCodeType"&gt;
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
            "consignment",
            "governmentAgencyGoodsItem"
        })
        public static class GoodsShipment {

            @XmlElement(name = "Consignment", required = true)
            protected Response.Declaration.GoodsShipment.Consignment consignment;
            @XmlElement(name = "GovernmentAgencyGoodsItem")
            protected List<Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem> governmentAgencyGoodsItem;

            /**
             * 取得 consignment 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.GoodsShipment.Consignment }
             *     
             */
            public Response.Declaration.GoodsShipment.Consignment getConsignment() {
                return consignment;
            }

            /**
             * 設定 consignment 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.GoodsShipment.Consignment }
             *     
             */
            public void setConsignment(Response.Declaration.GoodsShipment.Consignment value) {
                this.consignment = value;
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
             *         &lt;element name="BorderTransportMeans" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="JourneyID"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;simpleContent&gt;
             *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;BorderTransportMeansJourneyIDType"&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleContent&gt;
             *                     &lt;/complexType&gt;
             *                   &lt;/element&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="Carrier" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="ID"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;simpleContent&gt;
             *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;CarrierIdentificationIDType"&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleContent&gt;
             *                     &lt;/complexType&gt;
             *                   &lt;/element&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TransportContractDocument" maxOccurs="4"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="ID"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;simpleContent&gt;
             *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;TransportContractDocumentIdentificationIDType"&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleContent&gt;
             *                     &lt;/complexType&gt;
             *                   &lt;/element&gt;
             *                   &lt;element name="TypeCode"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;simpleContent&gt;
             *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;TransportContractDocumentTypeCodeType"&gt;
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
                "borderTransportMeans",
                "carrier",
                "transportContractDocument"
            })
            public static class Consignment {

                @XmlElement(name = "BorderTransportMeans")
                protected Response.Declaration.GoodsShipment.Consignment.BorderTransportMeans borderTransportMeans;
                @XmlElement(name = "Carrier")
                protected Response.Declaration.GoodsShipment.Consignment.Carrier carrier;
                @XmlElement(name = "TransportContractDocument", required = true)
                protected List<Response.Declaration.GoodsShipment.Consignment.TransportContractDocument> transportContractDocument;

                /**
                 * 取得 borderTransportMeans 特性的值.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Response.Declaration.GoodsShipment.Consignment.BorderTransportMeans }
                 *     
                 */
                public Response.Declaration.GoodsShipment.Consignment.BorderTransportMeans getBorderTransportMeans() {
                    return borderTransportMeans;
                }

                /**
                 * 設定 borderTransportMeans 特性的值.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Response.Declaration.GoodsShipment.Consignment.BorderTransportMeans }
                 *     
                 */
                public void setBorderTransportMeans(Response.Declaration.GoodsShipment.Consignment.BorderTransportMeans value) {
                    this.borderTransportMeans = value;
                }

                /**
                 * 取得 carrier 特性的值.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Response.Declaration.GoodsShipment.Consignment.Carrier }
                 *     
                 */
                public Response.Declaration.GoodsShipment.Consignment.Carrier getCarrier() {
                    return carrier;
                }

                /**
                 * 設定 carrier 特性的值.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Response.Declaration.GoodsShipment.Consignment.Carrier }
                 *     
                 */
                public void setCarrier(Response.Declaration.GoodsShipment.Consignment.Carrier value) {
                    this.carrier = value;
                }

                /**
                 * Gets the value of the transportContractDocument property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the transportContractDocument property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getTransportContractDocument().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Response.Declaration.GoodsShipment.Consignment.TransportContractDocument }
                 * 
                 * 
                 */
                public List<Response.Declaration.GoodsShipment.Consignment.TransportContractDocument> getTransportContractDocument() {
                    if (transportContractDocument == null) {
                        transportContractDocument = new ArrayList<Response.Declaration.GoodsShipment.Consignment.TransportContractDocument>();
                    }
                    return this.transportContractDocument;
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
                 *         &lt;element name="JourneyID"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;simpleContent&gt;
                 *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;BorderTransportMeansJourneyIDType"&gt;
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
                    "journeyID"
                })
                public static class BorderTransportMeans {

                    @XmlElement(name = "JourneyID", required = true)
                    protected Response.Declaration.GoodsShipment.Consignment.BorderTransportMeans.JourneyID journeyID;

                    /**
                     * 取得 journeyID 特性的值.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Response.Declaration.GoodsShipment.Consignment.BorderTransportMeans.JourneyID }
                     *     
                     */
                    public Response.Declaration.GoodsShipment.Consignment.BorderTransportMeans.JourneyID getJourneyID() {
                        return journeyID;
                    }

                    /**
                     * 設定 journeyID 特性的值.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Response.Declaration.GoodsShipment.Consignment.BorderTransportMeans.JourneyID }
                     *     
                     */
                    public void setJourneyID(Response.Declaration.GoodsShipment.Consignment.BorderTransportMeans.JourneyID value) {
                        this.journeyID = value;
                    }


                    /**
                     * <p>anonymous complex type 的 Java 類別.
                     * 
                     * <p>下列綱要片段會指定此類別中包含的預期內容.
                     * 
                     * <pre>
                     * &lt;complexType&gt;
                     *   &lt;simpleContent&gt;
                     *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;BorderTransportMeansJourneyIDType"&gt;
                     *     &lt;/restriction&gt;
                     *   &lt;/simpleContent&gt;
                     * &lt;/complexType&gt;
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "")
                    public static class JourneyID
                        extends BorderTransportMeansJourneyIDType
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
                 *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;CarrierIdentificationIDType"&gt;
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
                public static class Carrier {

                    @XmlElement(name = "ID", required = true)
                    protected Response.Declaration.GoodsShipment.Consignment.Carrier.ID id;

                    /**
                     * 取得 id 特性的值.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Response.Declaration.GoodsShipment.Consignment.Carrier.ID }
                     *     
                     */
                    public Response.Declaration.GoodsShipment.Consignment.Carrier.ID getID() {
                        return id;
                    }

                    /**
                     * 設定 id 特性的值.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Response.Declaration.GoodsShipment.Consignment.Carrier.ID }
                     *     
                     */
                    public void setID(Response.Declaration.GoodsShipment.Consignment.Carrier.ID value) {
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
                     *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;CarrierIdentificationIDType"&gt;
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
                        extends CarrierIdentificationIDType
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
                 *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;TransportContractDocumentIdentificationIDType"&gt;
                 *               &lt;/restriction&gt;
                 *             &lt;/simpleContent&gt;
                 *           &lt;/complexType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="TypeCode"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;simpleContent&gt;
                 *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;TransportContractDocumentTypeCodeType"&gt;
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
                    "typeCode"
                })
                public static class TransportContractDocument {

                    @XmlElement(name = "ID", required = true)
                    protected Response.Declaration.GoodsShipment.Consignment.TransportContractDocument.ID id;
                    @XmlElement(name = "TypeCode", required = true)
                    protected Response.Declaration.GoodsShipment.Consignment.TransportContractDocument.TypeCode typeCode;

                    /**
                     * 取得 id 特性的值.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Response.Declaration.GoodsShipment.Consignment.TransportContractDocument.ID }
                     *     
                     */
                    public Response.Declaration.GoodsShipment.Consignment.TransportContractDocument.ID getID() {
                        return id;
                    }

                    /**
                     * 設定 id 特性的值.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Response.Declaration.GoodsShipment.Consignment.TransportContractDocument.ID }
                     *     
                     */
                    public void setID(Response.Declaration.GoodsShipment.Consignment.TransportContractDocument.ID value) {
                        this.id = value;
                    }

                    /**
                     * 取得 typeCode 特性的值.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Response.Declaration.GoodsShipment.Consignment.TransportContractDocument.TypeCode }
                     *     
                     */
                    public Response.Declaration.GoodsShipment.Consignment.TransportContractDocument.TypeCode getTypeCode() {
                        return typeCode;
                    }

                    /**
                     * 設定 typeCode 特性的值.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Response.Declaration.GoodsShipment.Consignment.TransportContractDocument.TypeCode }
                     *     
                     */
                    public void setTypeCode(Response.Declaration.GoodsShipment.Consignment.TransportContractDocument.TypeCode value) {
                        this.typeCode = value;
                    }


                    /**
                     * <p>anonymous complex type 的 Java 類別.
                     * 
                     * <p>下列綱要片段會指定此類別中包含的預期內容.
                     * 
                     * <pre>
                     * &lt;complexType&gt;
                     *   &lt;simpleContent&gt;
                     *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;TransportContractDocumentIdentificationIDType"&gt;
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
                        extends TransportContractDocumentIdentificationIDType
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
                     *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;TransportContractDocumentTypeCodeType"&gt;
                     *     &lt;/restriction&gt;
                     *   &lt;/simpleContent&gt;
                     * &lt;/complexType&gt;
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "")
                    public static class TypeCode
                        extends TransportContractDocumentTypeCodeType
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
             *         &lt;element name="SequenceNumeric"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{urn:wco:datamodel:WCO:DS:1}GovernmentAgencyGoodsItemSequenceNumericType"&gt;
             *               &lt;minInclusive value="0"/&gt;
             *               &lt;maxInclusive value="9999"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="AdditionalInformation" maxOccurs="9" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="StatementCode"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;simpleContent&gt;
             *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalInformationStatementCodeType"&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleContent&gt;
             *                     &lt;/complexType&gt;
             *                   &lt;/element&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="Error" maxOccurs="9"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="ValidationCode"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;simpleContent&gt;
             *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;ErrorValidationCodeType"&gt;
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
                "additionalInformation",
                "error"
            })
            public static class GovernmentAgencyGoodsItem {

                @XmlElement(name = "SequenceNumeric", required = true)
                protected BigDecimal sequenceNumeric;
                @XmlElement(name = "AdditionalInformation")
                protected List<Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalInformation> additionalInformation;
                @XmlElement(name = "Error", required = true)
                protected List<Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.Error> error;

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
                 * Gets the value of the additionalInformation property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the additionalInformation property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getAdditionalInformation().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalInformation }
                 * 
                 * 
                 */
                public List<Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalInformation> getAdditionalInformation() {
                    if (additionalInformation == null) {
                        additionalInformation = new ArrayList<Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalInformation>();
                    }
                    return this.additionalInformation;
                }

                /**
                 * Gets the value of the error property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the error property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getError().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.Error }
                 * 
                 * 
                 */
                public List<Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.Error> getError() {
                    if (error == null) {
                        error = new ArrayList<Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.Error>();
                    }
                    return this.error;
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
                 *         &lt;element name="StatementCode"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;simpleContent&gt;
                 *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalInformationStatementCodeType"&gt;
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
                    "statementCode"
                })
                public static class AdditionalInformation {

                    @XmlElement(name = "StatementCode", required = true)
                    protected Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalInformation.StatementCode statementCode;

                    /**
                     * 取得 statementCode 特性的值.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalInformation.StatementCode }
                     *     
                     */
                    public Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalInformation.StatementCode getStatementCode() {
                        return statementCode;
                    }

                    /**
                     * 設定 statementCode 特性的值.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalInformation.StatementCode }
                     *     
                     */
                    public void setStatementCode(Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.AdditionalInformation.StatementCode value) {
                        this.statementCode = value;
                    }


                    /**
                     * <p>anonymous complex type 的 Java 類別.
                     * 
                     * <p>下列綱要片段會指定此類別中包含的預期內容.
                     * 
                     * <pre>
                     * &lt;complexType&gt;
                     *   &lt;simpleContent&gt;
                     *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;AdditionalInformationStatementCodeType"&gt;
                     *     &lt;/restriction&gt;
                     *   &lt;/simpleContent&gt;
                     * &lt;/complexType&gt;
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "")
                    public static class StatementCode
                        extends AdditionalInformationStatementCodeType
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
                 *         &lt;element name="ValidationCode"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;simpleContent&gt;
                 *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;ErrorValidationCodeType"&gt;
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
                    "validationCode"
                })
                public static class Error {

                    @XmlElement(name = "ValidationCode", required = true)
                    protected Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.Error.ValidationCode validationCode;

                    /**
                     * 取得 validationCode 特性的值.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.Error.ValidationCode }
                     *     
                     */
                    public Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.Error.ValidationCode getValidationCode() {
                        return validationCode;
                    }

                    /**
                     * 設定 validationCode 特性的值.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.Error.ValidationCode }
                     *     
                     */
                    public void setValidationCode(Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.Error.ValidationCode value) {
                        this.validationCode = value;
                    }


                    /**
                     * <p>anonymous complex type 的 Java 類別.
                     * 
                     * <p>下列綱要片段會指定此類別中包含的預期內容.
                     * 
                     * <pre>
                     * &lt;complexType&gt;
                     *   &lt;simpleContent&gt;
                     *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;ErrorValidationCodeType"&gt;
                     *     &lt;/restriction&gt;
                     *   &lt;/simpleContent&gt;
                     * &lt;/complexType&gt;
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "")
                    public static class ValidationCode
                        extends ErrorValidationCodeType
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
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="tw_TransportTypeCode"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;GovernmentProcedureTransportTypeCodeType"&gt;
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
            "twTransportTypeCode"
        })
        public static class GovernmentProcedure {

            @XmlElement(name = "tw_TransportTypeCode", required = true)
            protected Response.Declaration.GovernmentProcedure.TwTransportTypeCode twTransportTypeCode;

            /**
             * 取得 twTransportTypeCode 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.GovernmentProcedure.TwTransportTypeCode }
             *     
             */
            public Response.Declaration.GovernmentProcedure.TwTransportTypeCode getTwTransportTypeCode() {
                return twTransportTypeCode;
            }

            /**
             * 設定 twTransportTypeCode 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.GovernmentProcedure.TwTransportTypeCode }
             *     
             */
            public void setTwTransportTypeCode(Response.Declaration.GovernmentProcedure.TwTransportTypeCode value) {
                this.twTransportTypeCode = value;
            }


            /**
             * <p>anonymous complex type 的 Java 類別.
             * 
             * <p>下列綱要片段會指定此類別中包含的預期內容.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;simpleContent&gt;
             *     &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;GovernmentProcedureTransportTypeCodeType"&gt;
             *     &lt;/restriction&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class TwTransportTypeCode
                extends GovernmentProcedureTransportTypeCodeType
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
         *         &lt;element name="TypeCode"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PackagingTypeCodeType"&gt;
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
            "typeCode"
        })
        public static class Packaging {

            @XmlElement(name = "TypeCode", required = true)
            protected Response.Declaration.Packaging.TypeCode typeCode;

            /**
             * 取得 typeCode 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.Packaging.TypeCode }
             *     
             */
            public Response.Declaration.Packaging.TypeCode getTypeCode() {
                return typeCode;
            }

            /**
             * 設定 typeCode 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.Packaging.TypeCode }
             *     
             */
            public void setTypeCode(Response.Declaration.Packaging.TypeCode value) {
                this.typeCode = value;
            }


            /**
             * <p>anonymous complex type 的 Java 類別.
             * 
             * <p>下列綱要片段會指定此類別中包含的預期內容.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;simpleContent&gt;
             *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PackagingTypeCodeType"&gt;
             *     &lt;/restriction&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class TypeCode
                extends PackagingTypeCodeType
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
         *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;DeclarationTotalPackageQuantityType"&gt;
         *     &lt;/restriction&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class TotalPackageQuantity
            extends DeclarationTotalPackageQuantityType
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
         *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;DeclarationTypeCodeType"&gt;
         *     &lt;/restriction&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class TypeCode
            extends DeclarationTypeCodeType
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
