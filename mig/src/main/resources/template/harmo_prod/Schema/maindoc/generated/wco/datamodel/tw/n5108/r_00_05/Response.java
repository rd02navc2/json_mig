//
// 此檔案是由 Eclipse Implementation of JAXB, v2.3.8 所產生 
// 請參閱 https://eclipse-ee4j.github.io/jaxb-ri 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2025.10.20 於 05:04:30 PM CST 
//


package wco.datamodel.tw.n5108.r_00_05;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tw.gov.customs.schema.n5107.wcods.BorderTransportMeansIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.BorderTransportMeansJourneyIDType;
import tw.gov.customs.schema.n5107.wcods.BorderTransportMeansTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.ConsignmentBoardedQuantityType;
import tw.gov.customs.schema.n5107.wcods.ErrorValidationCodeType;
import tw.gov.customs.schema.n5107.wcods.PreviousDocumentTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.StatusNameCodeType;
import tw.gov.customs.schema.n5107.wcods.SubmitterIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.TransportContractDocumentIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.TransportContractDocumentTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.TransportEquipmentIdentificationIDType;
import wco.datamodel.tw.ds._1.BorderTransportMeansRegistrationTextType;
import wco.datamodel.tw.ds._1.ConsignmentManifestSerialNumberTextType;
import wco.datamodel.tw.ds._1.ConsignmentShippingOrderNumberTextType;
import wco.datamodel.tw.ds._1.GovernmentProcedureTransportTypeCodeType;
import wco.datamodel.tw.ds._1.PreviousDocumentFunctionalReferenceIDType;
import wco.datamodel.tw.ds._1.TransportEquipmentEmptyContainerQuantityType;
import wco.datamodel.tw.ds._1.TransportEquipmentFullContainerQuantityType;


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
 *         &lt;element name="Error" maxOccurs="9" minOccurs="0"&gt;
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
 *         &lt;element name="Declaration"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="BorderTransportMeans"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="ArrivalDateTime" type="{urn:wco:datamodel:WCO:DS:1}BorderTransportMeansArrivalDateTimeType" minOccurs="0"/&gt;
 *                             &lt;element name="ID" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;BorderTransportMeansIdentificationIDType"&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="JourneyID" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;BorderTransportMeansJourneyIDType"&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="tw_Registration" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;BorderTransportMeansRegistrationTextType"&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
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
 *                             &lt;element name="tw_ManifestSerialNumber" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;ConsignmentManifestSerialNumberTextType"&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="tw_ShippingOrderNumber" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;ConsignmentShippingOrderNumberTextType"&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="ConsignmentItem" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="PreviousDocument" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="tw_FunctionalReferenceID" minOccurs="0"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;simpleContent&gt;
 *                                                       &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;PreviousDocumentFunctionalReferenceIDType"&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/simpleContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                                 &lt;element name="TypeCode" minOccurs="0"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;simpleContent&gt;
 *                                                       &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PreviousDocumentTypeCodeType"&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/simpleContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                                 &lt;element name="Submitter" minOccurs="0"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;complexContent&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                         &lt;sequence&gt;
 *                                                           &lt;element name="ID"&gt;
 *                                                             &lt;complexType&gt;
 *                                                               &lt;simpleContent&gt;
 *                                                                 &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;SubmitterIdentificationIDType"&gt;
 *                                                                 &lt;/restriction&gt;
 *                                                               &lt;/simpleContent&gt;
 *                                                             &lt;/complexType&gt;
 *                                                           &lt;/element&gt;
 *                                                         &lt;/sequence&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/complexContent&gt;
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
 *                             &lt;element name="TransportContractDocument" maxOccurs="4" minOccurs="0"&gt;
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
 *                             &lt;element name="TransportEquipment" maxOccurs="9999" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="ID"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;simpleContent&gt;
 *                                             &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;TransportEquipmentIdentificationIDType"&gt;
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
 *                   &lt;element name="TransportEquipment" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="tw_EmptyContainerQuantity" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;TransportEquipmentEmptyContainerQuantityType"&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="tw_FullContainerQuantity" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;TransportEquipmentFullContainerQuantityType"&gt;
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
    "error",
    "status",
    "declaration"
})
@XmlRootElement(name = "Response")
public class Response {

    @XmlElement(name = "Error")
    protected List<Response.Error> error;
    @XmlElement(name = "Status")
    protected Response.Status status;
    @XmlElement(name = "Declaration", required = true)
    protected Response.Declaration declaration;

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
     * {@link Response.Error }
     * 
     * 
     */
    public List<Response.Error> getError() {
        if (error == null) {
            error = new ArrayList<Response.Error>();
        }
        return this.error;
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
     *         &lt;element name="BorderTransportMeans"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="ArrivalDateTime" type="{urn:wco:datamodel:WCO:DS:1}BorderTransportMeansArrivalDateTimeType" minOccurs="0"/&gt;
     *                   &lt;element name="ID" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;BorderTransportMeansIdentificationIDType"&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="JourneyID" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;BorderTransportMeansJourneyIDType"&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="tw_Registration" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;BorderTransportMeansRegistrationTextType"&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
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
     *                   &lt;element name="tw_ManifestSerialNumber" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;ConsignmentManifestSerialNumberTextType"&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="tw_ShippingOrderNumber" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;ConsignmentShippingOrderNumberTextType"&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="ConsignmentItem" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="PreviousDocument" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="tw_FunctionalReferenceID" minOccurs="0"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;simpleContent&gt;
     *                                             &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;PreviousDocumentFunctionalReferenceIDType"&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/simpleContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
     *                                       &lt;element name="TypeCode" minOccurs="0"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;simpleContent&gt;
     *                                             &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PreviousDocumentTypeCodeType"&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/simpleContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
     *                                       &lt;element name="Submitter" minOccurs="0"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;complexContent&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                               &lt;sequence&gt;
     *                                                 &lt;element name="ID"&gt;
     *                                                   &lt;complexType&gt;
     *                                                     &lt;simpleContent&gt;
     *                                                       &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;SubmitterIdentificationIDType"&gt;
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
     *                   &lt;element name="TransportContractDocument" maxOccurs="4" minOccurs="0"&gt;
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
     *                   &lt;element name="TransportEquipment" maxOccurs="9999" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="ID"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;simpleContent&gt;
     *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;TransportEquipmentIdentificationIDType"&gt;
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
     *         &lt;element name="TransportEquipment" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="tw_EmptyContainerQuantity" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;TransportEquipmentEmptyContainerQuantityType"&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="tw_FullContainerQuantity" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;TransportEquipmentFullContainerQuantityType"&gt;
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
        "consignment",
        "governmentProcedure",
        "transportEquipment"
    })
    public static class Declaration {

        @XmlElement(name = "BorderTransportMeans", required = true)
        protected Response.Declaration.BorderTransportMeans borderTransportMeans;
        @XmlElement(name = "Consignment")
        protected Response.Declaration.Consignment consignment;
        @XmlElement(name = "GovernmentProcedure", required = true)
        protected Response.Declaration.GovernmentProcedure governmentProcedure;
        @XmlElement(name = "TransportEquipment")
        protected Response.Declaration.TransportEquipment transportEquipment;

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
         * 取得 transportEquipment 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link Response.Declaration.TransportEquipment }
         *     
         */
        public Response.Declaration.TransportEquipment getTransportEquipment() {
            return transportEquipment;
        }

        /**
         * 設定 transportEquipment 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link Response.Declaration.TransportEquipment }
         *     
         */
        public void setTransportEquipment(Response.Declaration.TransportEquipment value) {
            this.transportEquipment = value;
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
         *         &lt;element name="ID" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;BorderTransportMeansIdentificationIDType"&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="JourneyID" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;BorderTransportMeansJourneyIDType"&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="tw_Registration" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;BorderTransportMeansRegistrationTextType"&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
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
            "id",
            "journeyID",
            "twRegistration",
            "typeCode"
        })
        public static class BorderTransportMeans {

            @XmlElement(name = "ArrivalDateTime")
            protected String arrivalDateTime;
            @XmlElement(name = "ID")
            protected Response.Declaration.BorderTransportMeans.ID id;
            @XmlElement(name = "JourneyID")
            protected Response.Declaration.BorderTransportMeans.JourneyID journeyID;
            @XmlElement(name = "tw_Registration")
            protected Response.Declaration.BorderTransportMeans.TwRegistration twRegistration;
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
             * 取得 id 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.BorderTransportMeans.ID }
             *     
             */
            public Response.Declaration.BorderTransportMeans.ID getID() {
                return id;
            }

            /**
             * 設定 id 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.BorderTransportMeans.ID }
             *     
             */
            public void setID(Response.Declaration.BorderTransportMeans.ID value) {
                this.id = value;
            }

            /**
             * 取得 journeyID 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.BorderTransportMeans.JourneyID }
             *     
             */
            public Response.Declaration.BorderTransportMeans.JourneyID getJourneyID() {
                return journeyID;
            }

            /**
             * 設定 journeyID 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.BorderTransportMeans.JourneyID }
             *     
             */
            public void setJourneyID(Response.Declaration.BorderTransportMeans.JourneyID value) {
                this.journeyID = value;
            }

            /**
             * 取得 twRegistration 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.BorderTransportMeans.TwRegistration }
             *     
             */
            public Response.Declaration.BorderTransportMeans.TwRegistration getTwRegistration() {
                return twRegistration;
            }

            /**
             * 設定 twRegistration 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.BorderTransportMeans.TwRegistration }
             *     
             */
            public void setTwRegistration(Response.Declaration.BorderTransportMeans.TwRegistration value) {
                this.twRegistration = value;
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
             *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;BorderTransportMeansIdentificationIDType"&gt;
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
                extends BorderTransportMeansIdentificationIDType
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


            /**
             * <p>anonymous complex type 的 Java 類別.
             * 
             * <p>下列綱要片段會指定此類別中包含的預期內容.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;simpleContent&gt;
             *     &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;BorderTransportMeansRegistrationTextType"&gt;
             *     &lt;/restriction&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class TwRegistration
                extends BorderTransportMeansRegistrationTextType
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
         *         &lt;element name="tw_ManifestSerialNumber" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;ConsignmentManifestSerialNumberTextType"&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="tw_ShippingOrderNumber" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;ConsignmentShippingOrderNumberTextType"&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="ConsignmentItem" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="PreviousDocument" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="tw_FunctionalReferenceID" minOccurs="0"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;simpleContent&gt;
         *                                   &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;PreviousDocumentFunctionalReferenceIDType"&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleContent&gt;
         *                               &lt;/complexType&gt;
         *                             &lt;/element&gt;
         *                             &lt;element name="TypeCode" minOccurs="0"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;simpleContent&gt;
         *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PreviousDocumentTypeCodeType"&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleContent&gt;
         *                               &lt;/complexType&gt;
         *                             &lt;/element&gt;
         *                             &lt;element name="Submitter" minOccurs="0"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;complexContent&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                     &lt;sequence&gt;
         *                                       &lt;element name="ID"&gt;
         *                                         &lt;complexType&gt;
         *                                           &lt;simpleContent&gt;
         *                                             &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;SubmitterIdentificationIDType"&gt;
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
         *         &lt;element name="TransportContractDocument" maxOccurs="4" minOccurs="0"&gt;
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
         *         &lt;element name="TransportEquipment" maxOccurs="9999" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="ID"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;simpleContent&gt;
         *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;TransportEquipmentIdentificationIDType"&gt;
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
            "twManifestSerialNumber",
            "twShippingOrderNumber",
            "consignmentItem",
            "transportContractDocument",
            "transportEquipment"
        })
        public static class Consignment {

            @XmlElement(name = "BoardedQuantity")
            protected Response.Declaration.Consignment.BoardedQuantity boardedQuantity;
            @XmlElement(name = "tw_ManifestSerialNumber")
            protected Response.Declaration.Consignment.TwManifestSerialNumber twManifestSerialNumber;
            @XmlElement(name = "tw_ShippingOrderNumber")
            protected Response.Declaration.Consignment.TwShippingOrderNumber twShippingOrderNumber;
            @XmlElement(name = "ConsignmentItem")
            protected Response.Declaration.Consignment.ConsignmentItem consignmentItem;
            @XmlElement(name = "TransportContractDocument")
            protected List<Response.Declaration.Consignment.TransportContractDocument> transportContractDocument;
            @XmlElement(name = "TransportEquipment")
            protected List<Response.Declaration.Consignment.TransportEquipment> transportEquipment;

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
             * 取得 twManifestSerialNumber 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.Consignment.TwManifestSerialNumber }
             *     
             */
            public Response.Declaration.Consignment.TwManifestSerialNumber getTwManifestSerialNumber() {
                return twManifestSerialNumber;
            }

            /**
             * 設定 twManifestSerialNumber 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.Consignment.TwManifestSerialNumber }
             *     
             */
            public void setTwManifestSerialNumber(Response.Declaration.Consignment.TwManifestSerialNumber value) {
                this.twManifestSerialNumber = value;
            }

            /**
             * 取得 twShippingOrderNumber 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.Consignment.TwShippingOrderNumber }
             *     
             */
            public Response.Declaration.Consignment.TwShippingOrderNumber getTwShippingOrderNumber() {
                return twShippingOrderNumber;
            }

            /**
             * 設定 twShippingOrderNumber 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.Consignment.TwShippingOrderNumber }
             *     
             */
            public void setTwShippingOrderNumber(Response.Declaration.Consignment.TwShippingOrderNumber value) {
                this.twShippingOrderNumber = value;
            }

            /**
             * 取得 consignmentItem 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.Consignment.ConsignmentItem }
             *     
             */
            public Response.Declaration.Consignment.ConsignmentItem getConsignmentItem() {
                return consignmentItem;
            }

            /**
             * 設定 consignmentItem 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.Consignment.ConsignmentItem }
             *     
             */
            public void setConsignmentItem(Response.Declaration.Consignment.ConsignmentItem value) {
                this.consignmentItem = value;
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
             * {@link Response.Declaration.Consignment.TransportContractDocument }
             * 
             * 
             */
            public List<Response.Declaration.Consignment.TransportContractDocument> getTransportContractDocument() {
                if (transportContractDocument == null) {
                    transportContractDocument = new ArrayList<Response.Declaration.Consignment.TransportContractDocument>();
                }
                return this.transportContractDocument;
            }

            /**
             * Gets the value of the transportEquipment property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the transportEquipment property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTransportEquipment().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Response.Declaration.Consignment.TransportEquipment }
             * 
             * 
             */
            public List<Response.Declaration.Consignment.TransportEquipment> getTransportEquipment() {
                if (transportEquipment == null) {
                    transportEquipment = new ArrayList<Response.Declaration.Consignment.TransportEquipment>();
                }
                return this.transportEquipment;
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
             *         &lt;element name="PreviousDocument" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="tw_FunctionalReferenceID" minOccurs="0"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;simpleContent&gt;
             *                         &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;PreviousDocumentFunctionalReferenceIDType"&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleContent&gt;
             *                     &lt;/complexType&gt;
             *                   &lt;/element&gt;
             *                   &lt;element name="TypeCode" minOccurs="0"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;simpleContent&gt;
             *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PreviousDocumentTypeCodeType"&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleContent&gt;
             *                     &lt;/complexType&gt;
             *                   &lt;/element&gt;
             *                   &lt;element name="Submitter" minOccurs="0"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;complexContent&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                           &lt;sequence&gt;
             *                             &lt;element name="ID"&gt;
             *                               &lt;complexType&gt;
             *                                 &lt;simpleContent&gt;
             *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;SubmitterIdentificationIDType"&gt;
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
                "previousDocument"
            })
            public static class ConsignmentItem {

                @XmlElement(name = "PreviousDocument")
                protected Response.Declaration.Consignment.ConsignmentItem.PreviousDocument previousDocument;

                /**
                 * 取得 previousDocument 特性的值.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Response.Declaration.Consignment.ConsignmentItem.PreviousDocument }
                 *     
                 */
                public Response.Declaration.Consignment.ConsignmentItem.PreviousDocument getPreviousDocument() {
                    return previousDocument;
                }

                /**
                 * 設定 previousDocument 特性的值.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Response.Declaration.Consignment.ConsignmentItem.PreviousDocument }
                 *     
                 */
                public void setPreviousDocument(Response.Declaration.Consignment.ConsignmentItem.PreviousDocument value) {
                    this.previousDocument = value;
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
                 *         &lt;element name="tw_FunctionalReferenceID" minOccurs="0"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;simpleContent&gt;
                 *               &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;PreviousDocumentFunctionalReferenceIDType"&gt;
                 *               &lt;/restriction&gt;
                 *             &lt;/simpleContent&gt;
                 *           &lt;/complexType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="TypeCode" minOccurs="0"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;simpleContent&gt;
                 *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PreviousDocumentTypeCodeType"&gt;
                 *               &lt;/restriction&gt;
                 *             &lt;/simpleContent&gt;
                 *           &lt;/complexType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="Submitter" minOccurs="0"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;complexContent&gt;
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                 &lt;sequence&gt;
                 *                   &lt;element name="ID"&gt;
                 *                     &lt;complexType&gt;
                 *                       &lt;simpleContent&gt;
                 *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;SubmitterIdentificationIDType"&gt;
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
                    "twFunctionalReferenceID",
                    "typeCode",
                    "submitter"
                })
                public static class PreviousDocument {

                    @XmlElement(name = "tw_FunctionalReferenceID")
                    protected Response.Declaration.Consignment.ConsignmentItem.PreviousDocument.TwFunctionalReferenceID twFunctionalReferenceID;
                    @XmlElement(name = "TypeCode")
                    protected Response.Declaration.Consignment.ConsignmentItem.PreviousDocument.TypeCode typeCode;
                    @XmlElement(name = "Submitter")
                    protected Response.Declaration.Consignment.ConsignmentItem.PreviousDocument.Submitter submitter;

                    /**
                     * 取得 twFunctionalReferenceID 特性的值.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Response.Declaration.Consignment.ConsignmentItem.PreviousDocument.TwFunctionalReferenceID }
                     *     
                     */
                    public Response.Declaration.Consignment.ConsignmentItem.PreviousDocument.TwFunctionalReferenceID getTwFunctionalReferenceID() {
                        return twFunctionalReferenceID;
                    }

                    /**
                     * 設定 twFunctionalReferenceID 特性的值.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Response.Declaration.Consignment.ConsignmentItem.PreviousDocument.TwFunctionalReferenceID }
                     *     
                     */
                    public void setTwFunctionalReferenceID(Response.Declaration.Consignment.ConsignmentItem.PreviousDocument.TwFunctionalReferenceID value) {
                        this.twFunctionalReferenceID = value;
                    }

                    /**
                     * 取得 typeCode 特性的值.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Response.Declaration.Consignment.ConsignmentItem.PreviousDocument.TypeCode }
                     *     
                     */
                    public Response.Declaration.Consignment.ConsignmentItem.PreviousDocument.TypeCode getTypeCode() {
                        return typeCode;
                    }

                    /**
                     * 設定 typeCode 特性的值.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Response.Declaration.Consignment.ConsignmentItem.PreviousDocument.TypeCode }
                     *     
                     */
                    public void setTypeCode(Response.Declaration.Consignment.ConsignmentItem.PreviousDocument.TypeCode value) {
                        this.typeCode = value;
                    }

                    /**
                     * 取得 submitter 特性的值.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Response.Declaration.Consignment.ConsignmentItem.PreviousDocument.Submitter }
                     *     
                     */
                    public Response.Declaration.Consignment.ConsignmentItem.PreviousDocument.Submitter getSubmitter() {
                        return submitter;
                    }

                    /**
                     * 設定 submitter 特性的值.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Response.Declaration.Consignment.ConsignmentItem.PreviousDocument.Submitter }
                     *     
                     */
                    public void setSubmitter(Response.Declaration.Consignment.ConsignmentItem.PreviousDocument.Submitter value) {
                        this.submitter = value;
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
                     *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;SubmitterIdentificationIDType"&gt;
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
                    public static class Submitter {

                        @XmlElement(name = "ID", required = true)
                        protected Response.Declaration.Consignment.ConsignmentItem.PreviousDocument.Submitter.ID id;

                        /**
                         * 取得 id 特性的值.
                         * 
                         * @return
                         *     possible object is
                         *     {@link Response.Declaration.Consignment.ConsignmentItem.PreviousDocument.Submitter.ID }
                         *     
                         */
                        public Response.Declaration.Consignment.ConsignmentItem.PreviousDocument.Submitter.ID getID() {
                            return id;
                        }

                        /**
                         * 設定 id 特性的值.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link Response.Declaration.Consignment.ConsignmentItem.PreviousDocument.Submitter.ID }
                         *     
                         */
                        public void setID(Response.Declaration.Consignment.ConsignmentItem.PreviousDocument.Submitter.ID value) {
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
                         *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;SubmitterIdentificationIDType"&gt;
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
                            extends SubmitterIdentificationIDType
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


                    /**
                     * <p>anonymous complex type 的 Java 類別.
                     * 
                     * <p>下列綱要片段會指定此類別中包含的預期內容.
                     * 
                     * <pre>
                     * &lt;complexType&gt;
                     *   &lt;simpleContent&gt;
                     *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PreviousDocumentTypeCodeType"&gt;
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
                        extends PreviousDocumentTypeCodeType
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
                protected Response.Declaration.Consignment.TransportContractDocument.ID id;
                @XmlElement(name = "TypeCode", required = true)
                protected Response.Declaration.Consignment.TransportContractDocument.TypeCode typeCode;

                /**
                 * 取得 id 特性的值.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Response.Declaration.Consignment.TransportContractDocument.ID }
                 *     
                 */
                public Response.Declaration.Consignment.TransportContractDocument.ID getID() {
                    return id;
                }

                /**
                 * 設定 id 特性的值.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Response.Declaration.Consignment.TransportContractDocument.ID }
                 *     
                 */
                public void setID(Response.Declaration.Consignment.TransportContractDocument.ID value) {
                    this.id = value;
                }

                /**
                 * 取得 typeCode 特性的值.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Response.Declaration.Consignment.TransportContractDocument.TypeCode }
                 *     
                 */
                public Response.Declaration.Consignment.TransportContractDocument.TypeCode getTypeCode() {
                    return typeCode;
                }

                /**
                 * 設定 typeCode 特性的值.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Response.Declaration.Consignment.TransportContractDocument.TypeCode }
                 *     
                 */
                public void setTypeCode(Response.Declaration.Consignment.TransportContractDocument.TypeCode value) {
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
             *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;TransportEquipmentIdentificationIDType"&gt;
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
            public static class TransportEquipment {

                @XmlElement(name = "ID", required = true)
                protected Response.Declaration.Consignment.TransportEquipment.ID id;

                /**
                 * 取得 id 特性的值.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Response.Declaration.Consignment.TransportEquipment.ID }
                 *     
                 */
                public Response.Declaration.Consignment.TransportEquipment.ID getID() {
                    return id;
                }

                /**
                 * 設定 id 特性的值.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Response.Declaration.Consignment.TransportEquipment.ID }
                 *     
                 */
                public void setID(Response.Declaration.Consignment.TransportEquipment.ID value) {
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
                 *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;TransportEquipmentIdentificationIDType"&gt;
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
                    extends TransportEquipmentIdentificationIDType
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
             *     &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;ConsignmentManifestSerialNumberTextType"&gt;
             *     &lt;/restriction&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class TwManifestSerialNumber
                extends ConsignmentManifestSerialNumberTextType
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
             *     &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;ConsignmentShippingOrderNumberTextType"&gt;
             *     &lt;/restriction&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class TwShippingOrderNumber
                extends ConsignmentShippingOrderNumberTextType
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
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="tw_EmptyContainerQuantity" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;TransportEquipmentEmptyContainerQuantityType"&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="tw_FullContainerQuantity" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;TransportEquipmentFullContainerQuantityType"&gt;
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
            "twEmptyContainerQuantity",
            "twFullContainerQuantity"
        })
        public static class TransportEquipment {

            @XmlElement(name = "tw_EmptyContainerQuantity")
            protected Response.Declaration.TransportEquipment.TwEmptyContainerQuantity twEmptyContainerQuantity;
            @XmlElement(name = "tw_FullContainerQuantity")
            protected Response.Declaration.TransportEquipment.TwFullContainerQuantity twFullContainerQuantity;

            /**
             * 取得 twEmptyContainerQuantity 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.TransportEquipment.TwEmptyContainerQuantity }
             *     
             */
            public Response.Declaration.TransportEquipment.TwEmptyContainerQuantity getTwEmptyContainerQuantity() {
                return twEmptyContainerQuantity;
            }

            /**
             * 設定 twEmptyContainerQuantity 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.TransportEquipment.TwEmptyContainerQuantity }
             *     
             */
            public void setTwEmptyContainerQuantity(Response.Declaration.TransportEquipment.TwEmptyContainerQuantity value) {
                this.twEmptyContainerQuantity = value;
            }

            /**
             * 取得 twFullContainerQuantity 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.TransportEquipment.TwFullContainerQuantity }
             *     
             */
            public Response.Declaration.TransportEquipment.TwFullContainerQuantity getTwFullContainerQuantity() {
                return twFullContainerQuantity;
            }

            /**
             * 設定 twFullContainerQuantity 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.TransportEquipment.TwFullContainerQuantity }
             *     
             */
            public void setTwFullContainerQuantity(Response.Declaration.TransportEquipment.TwFullContainerQuantity value) {
                this.twFullContainerQuantity = value;
            }


            /**
             * <p>anonymous complex type 的 Java 類別.
             * 
             * <p>下列綱要片段會指定此類別中包含的預期內容.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;simpleContent&gt;
             *     &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;TransportEquipmentEmptyContainerQuantityType"&gt;
             *     &lt;/restriction&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class TwEmptyContainerQuantity
                extends TransportEquipmentEmptyContainerQuantityType
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
             *     &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;TransportEquipmentFullContainerQuantityType"&gt;
             *     &lt;/restriction&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class TwFullContainerQuantity
                extends TransportEquipmentFullContainerQuantityType
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
        protected Response.Error.ValidationCode validationCode;

        /**
         * 取得 validationCode 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link Response.Error.ValidationCode }
         *     
         */
        public Response.Error.ValidationCode getValidationCode() {
            return validationCode;
        }

        /**
         * 設定 validationCode 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link Response.Error.ValidationCode }
         *     
         */
        public void setValidationCode(Response.Error.ValidationCode value) {
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
