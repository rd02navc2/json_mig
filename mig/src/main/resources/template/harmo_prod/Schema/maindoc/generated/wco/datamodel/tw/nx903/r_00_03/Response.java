//
// 此檔案是由 Eclipse Implementation of JAXB, v2.3.8 所產生 
// 請參閱 https://eclipse-ee4j.github.io/jaxb-ri 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2025.10.20 於 05:05:05 PM CST 
//


package wco.datamodel.tw.nx903.r_00_03;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tw.gov.customs.schema.n5107.wcods.AdditionalInformationContentTextType;
import tw.gov.customs.schema.n5107.wcods.ContactOfficeIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.DeclarationIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ErrorValidationCodeType;
import tw.gov.customs.schema.n5107.wcods.PreviousDocumentTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.ResponseFunctionalReferenceIDType;
import wco.datamodel.tw.ds._1.PreviousDocumentFunctionalReferenceIDType;
import wco.datamodel.tw.ds._1.PreviousDocumentUniversallyUniqueIDType;


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
 *         &lt;element name="FunctionalReferenceID"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;ResponseFunctionalReferenceIDType"&gt;
 *               &lt;/restriction&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="IssueDateTime" type="{urn:wco:datamodel:WCO:DS:1}ResponseIssueDateTimeType"/&gt;
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
 *         &lt;element name="Error" maxOccurs="99"&gt;
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
 *                   &lt;element name="AdditionalInformation"&gt;
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
 *                   &lt;element name="ID" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;DeclarationIdentificationIDType"&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="GoodsShipment"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="GovernmentAgencyGoodsItem"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="PreviousDocument"&gt;
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
 *                                                 &lt;element name="tw_UniversallyUniqueID"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;simpleContent&gt;
 *                                                       &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;PreviousDocumentUniversallyUniqueIDType"&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/simpleContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                                 &lt;element name="TypeCode"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;simpleContent&gt;
 *                                                       &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PreviousDocumentTypeCodeType"&gt;
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
    "functionalReferenceID",
    "issueDateTime",
    "contactOffice",
    "error",
    "declaration"
})
@XmlRootElement(name = "Response")
public class Response {

    @XmlElement(name = "FunctionalReferenceID", required = true)
    protected Response.FunctionalReferenceID functionalReferenceID;
    @XmlElement(name = "IssueDateTime", required = true)
    protected String issueDateTime;
    @XmlElement(name = "ContactOffice", required = true)
    protected Response.ContactOffice contactOffice;
    @XmlElement(name = "Error", required = true)
    protected List<Response.Error> error;
    @XmlElement(name = "Declaration", required = true)
    protected Response.Declaration declaration;

    /**
     * 取得 functionalReferenceID 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link Response.FunctionalReferenceID }
     *     
     */
    public Response.FunctionalReferenceID getFunctionalReferenceID() {
        return functionalReferenceID;
    }

    /**
     * 設定 functionalReferenceID 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link Response.FunctionalReferenceID }
     *     
     */
    public void setFunctionalReferenceID(Response.FunctionalReferenceID value) {
        this.functionalReferenceID = value;
    }

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
     *         &lt;element name="ID" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;DeclarationIdentificationIDType"&gt;
     *               &lt;/restriction&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="GoodsShipment"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="GovernmentAgencyGoodsItem"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="PreviousDocument"&gt;
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
     *                                       &lt;element name="tw_UniversallyUniqueID"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;simpleContent&gt;
     *                                             &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;PreviousDocumentUniversallyUniqueIDType"&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/simpleContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
     *                                       &lt;element name="TypeCode"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;simpleContent&gt;
     *                                             &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PreviousDocumentTypeCodeType"&gt;
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
        "id",
        "goodsShipment"
    })
    public static class Declaration {

        @XmlElement(name = "ID")
        protected Response.Declaration.ID id;
        @XmlElement(name = "GoodsShipment", required = true)
        protected Response.Declaration.GoodsShipment goodsShipment;

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
         * <p>anonymous complex type 的 Java 類別.
         * 
         * <p>下列綱要片段會指定此類別中包含的預期內容.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="GovernmentAgencyGoodsItem"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="PreviousDocument"&gt;
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
         *                             &lt;element name="tw_UniversallyUniqueID"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;simpleContent&gt;
         *                                   &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;PreviousDocumentUniversallyUniqueIDType"&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/simpleContent&gt;
         *                               &lt;/complexType&gt;
         *                             &lt;/element&gt;
         *                             &lt;element name="TypeCode"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;simpleContent&gt;
         *                                   &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PreviousDocumentTypeCodeType"&gt;
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
            "governmentAgencyGoodsItem"
        })
        public static class GoodsShipment {

            @XmlElement(name = "GovernmentAgencyGoodsItem", required = true)
            protected Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem governmentAgencyGoodsItem;

            /**
             * 取得 governmentAgencyGoodsItem 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem }
             *     
             */
            public Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem getGovernmentAgencyGoodsItem() {
                return governmentAgencyGoodsItem;
            }

            /**
             * 設定 governmentAgencyGoodsItem 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem }
             *     
             */
            public void setGovernmentAgencyGoodsItem(Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem value) {
                this.governmentAgencyGoodsItem = value;
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
             *         &lt;element name="PreviousDocument"&gt;
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
             *                   &lt;element name="tw_UniversallyUniqueID"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;simpleContent&gt;
             *                         &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;PreviousDocumentUniversallyUniqueIDType"&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/simpleContent&gt;
             *                     &lt;/complexType&gt;
             *                   &lt;/element&gt;
             *                   &lt;element name="TypeCode"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;simpleContent&gt;
             *                         &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PreviousDocumentTypeCodeType"&gt;
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
                "previousDocument"
            })
            public static class GovernmentAgencyGoodsItem {

                @XmlElement(name = "PreviousDocument", required = true)
                protected Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.PreviousDocument previousDocument;

                /**
                 * 取得 previousDocument 特性的值.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.PreviousDocument }
                 *     
                 */
                public Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.PreviousDocument getPreviousDocument() {
                    return previousDocument;
                }

                /**
                 * 設定 previousDocument 特性的值.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.PreviousDocument }
                 *     
                 */
                public void setPreviousDocument(Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.PreviousDocument value) {
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
                 *         &lt;element name="tw_UniversallyUniqueID"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;simpleContent&gt;
                 *               &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;PreviousDocumentUniversallyUniqueIDType"&gt;
                 *               &lt;/restriction&gt;
                 *             &lt;/simpleContent&gt;
                 *           &lt;/complexType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="TypeCode"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;simpleContent&gt;
                 *               &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;PreviousDocumentTypeCodeType"&gt;
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
                    "twFunctionalReferenceID",
                    "twUniversallyUniqueID",
                    "typeCode"
                })
                public static class PreviousDocument {

                    @XmlElement(name = "tw_FunctionalReferenceID")
                    protected Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.PreviousDocument.TwFunctionalReferenceID twFunctionalReferenceID;
                    @XmlElement(name = "tw_UniversallyUniqueID", required = true)
                    protected Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.PreviousDocument.TwUniversallyUniqueID twUniversallyUniqueID;
                    @XmlElement(name = "TypeCode", required = true)
                    protected Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.PreviousDocument.TypeCode typeCode;

                    /**
                     * 取得 twFunctionalReferenceID 特性的值.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.PreviousDocument.TwFunctionalReferenceID }
                     *     
                     */
                    public Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.PreviousDocument.TwFunctionalReferenceID getTwFunctionalReferenceID() {
                        return twFunctionalReferenceID;
                    }

                    /**
                     * 設定 twFunctionalReferenceID 特性的值.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.PreviousDocument.TwFunctionalReferenceID }
                     *     
                     */
                    public void setTwFunctionalReferenceID(Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.PreviousDocument.TwFunctionalReferenceID value) {
                        this.twFunctionalReferenceID = value;
                    }

                    /**
                     * 取得 twUniversallyUniqueID 特性的值.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.PreviousDocument.TwUniversallyUniqueID }
                     *     
                     */
                    public Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.PreviousDocument.TwUniversallyUniqueID getTwUniversallyUniqueID() {
                        return twUniversallyUniqueID;
                    }

                    /**
                     * 設定 twUniversallyUniqueID 特性的值.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.PreviousDocument.TwUniversallyUniqueID }
                     *     
                     */
                    public void setTwUniversallyUniqueID(Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.PreviousDocument.TwUniversallyUniqueID value) {
                        this.twUniversallyUniqueID = value;
                    }

                    /**
                     * 取得 typeCode 特性的值.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.PreviousDocument.TypeCode }
                     *     
                     */
                    public Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.PreviousDocument.TypeCode getTypeCode() {
                        return typeCode;
                    }

                    /**
                     * 設定 typeCode 特性的值.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.PreviousDocument.TypeCode }
                     *     
                     */
                    public void setTypeCode(Response.Declaration.GoodsShipment.GovernmentAgencyGoodsItem.PreviousDocument.TypeCode value) {
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
                     *     &lt;restriction base="&lt;urn:wco:datamodel:TW:DS:1&gt;PreviousDocumentUniversallyUniqueIDType"&gt;
                     *     &lt;/restriction&gt;
                     *   &lt;/simpleContent&gt;
                     * &lt;/complexType&gt;
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "")
                    public static class TwUniversallyUniqueID
                        extends PreviousDocumentUniversallyUniqueIDType
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
     *         &lt;element name="AdditionalInformation"&gt;
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
        "validationCode",
        "additionalInformation"
    })
    public static class Error {

        @XmlElement(name = "ValidationCode", required = true)
        protected Response.Error.ValidationCode validationCode;
        @XmlElement(name = "AdditionalInformation", required = true)
        protected Response.Error.AdditionalInformation additionalInformation;

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
         * 取得 additionalInformation 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link Response.Error.AdditionalInformation }
         *     
         */
        public Response.Error.AdditionalInformation getAdditionalInformation() {
            return additionalInformation;
        }

        /**
         * 設定 additionalInformation 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link Response.Error.AdditionalInformation }
         *     
         */
        public void setAdditionalInformation(Response.Error.AdditionalInformation value) {
            this.additionalInformation = value;
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
            protected Response.Error.AdditionalInformation.Content content;

            /**
             * 取得 content 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link Response.Error.AdditionalInformation.Content }
             *     
             */
            public Response.Error.AdditionalInformation.Content getContent() {
                return content;
            }

            /**
             * 設定 content 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link Response.Error.AdditionalInformation.Content }
             *     
             */
            public void setContent(Response.Error.AdditionalInformation.Content value) {
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
     *   &lt;simpleContent&gt;
     *     &lt;restriction base="&lt;urn:wco:datamodel:WCO:DS:1&gt;ResponseFunctionalReferenceIDType"&gt;
     *     &lt;/restriction&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class FunctionalReferenceID
        extends ResponseFunctionalReferenceIDType
    {


    }

}
