//
// 此檔案是由 Eclipse Implementation of JAXB, v2.3.8 所產生 
// 請參閱 https://eclipse-ee4j.github.io/jaxb-ri 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2025.10.20 於 05:05:05 PM CST 
//


package un.unece.uncefact.data.standard.unqualifieddatatype._6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import tw.gov.customs.schema.n5107.wcods.AdditionalDocumentLPCOExemptionCodeType;
import tw.gov.customs.schema.n5107.wcods.AdditionalDocumentTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.AdditionalInformationReconciliationReasonCodeType;
import tw.gov.customs.schema.n5107.wcods.AdditionalInformationRequestOverrideCodeType;
import tw.gov.customs.schema.n5107.wcods.AdditionalInformationStatementCodeType;
import tw.gov.customs.schema.n5107.wcods.AdditionalInformationStatementTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.AddressCountryCodeType;
import tw.gov.customs.schema.n5107.wcods.AgentFunctionCodeType;
import tw.gov.customs.schema.n5107.wcods.AgentRoleCodeType;
import tw.gov.customs.schema.n5107.wcods.AmendmentChangeReasonCodeType;
import tw.gov.customs.schema.n5107.wcods.ArrivalTransportMeansTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.AssociatedTransportDocumentTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.BorderTransportMeansBallastOrCargoTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.BorderTransportMeansBunkerFuelTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.BorderTransportMeansCallPurposeCodeType;
import tw.gov.customs.schema.n5107.wcods.BorderTransportMeansRegistrationCountrySubdivisionCodeType;
import tw.gov.customs.schema.n5107.wcods.BorderTransportMeansRegistrationNationalityCodeType;
import tw.gov.customs.schema.n5107.wcods.BorderTransportMeansSecurityLevelCodeType;
import tw.gov.customs.schema.n5107.wcods.BorderTransportMeansTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.ClassificationIdentificationTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.CommercialDriversLicenseCountryCodeType;
import tw.gov.customs.schema.n5107.wcods.CommercialDriversLicenseCountrySubdivisionCodeType;
import tw.gov.customs.schema.n5107.wcods.CommercialDriversLicenseEndorsementCodeType;
import tw.gov.customs.schema.n5107.wcods.CommodityCategoryCodeType;
import tw.gov.customs.schema.n5107.wcods.CommodityCategoryQualifierCodeType;
import tw.gov.customs.schema.n5107.wcods.CommodityCharacteristicCodeType;
import tw.gov.customs.schema.n5107.wcods.CommodityCharacteristicQualifierCodeType;
import tw.gov.customs.schema.n5107.wcods.CommodityClassificationNameCodeType;
import tw.gov.customs.schema.n5107.wcods.CommodityCriteriaConformanceCodeType;
import tw.gov.customs.schema.n5107.wcods.CommodityGoodsGroupNameCodeType;
import tw.gov.customs.schema.n5107.wcods.CommodityIDTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.CommodityIdentityQualifierCodeType;
import tw.gov.customs.schema.n5107.wcods.CommodityIntendedUseCodeType;
import tw.gov.customs.schema.n5107.wcods.CommodityNameQualifierCodeType;
import tw.gov.customs.schema.n5107.wcods.CommodityPhysicalStateCodeType;
import tw.gov.customs.schema.n5107.wcods.CommodityProcessTypeIdentificationCodeType;
import tw.gov.customs.schema.n5107.wcods.CommodityRelatedPackagingDangerousGoodsPackingRequirementGroupCodeType;
import tw.gov.customs.schema.n5107.wcods.CommodityRelatedPackagingHierarchicCodeType;
import tw.gov.customs.schema.n5107.wcods.CommoditySensitiveGoodsCodeType;
import tw.gov.customs.schema.n5107.wcods.ConsignmentGoodsStatusCodeType;
import tw.gov.customs.schema.n5107.wcods.ConsignmentItemAssociatedGovernmentProcedureCodeType;
import tw.gov.customs.schema.n5107.wcods.ConsignmentItemGoodsStatusCodeType;
import tw.gov.customs.schema.n5107.wcods.ConsignmentItemRelatedPackagingDangerousGoodsPackingRequirementGroupCodeType;
import tw.gov.customs.schema.n5107.wcods.ConstituentElementCodeType;
import tw.gov.customs.schema.n5107.wcods.CrewMemberEndorsementTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.CurrencyExchangeCurrencyTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.CustomsValuationChargesTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.CustomsValuationFreightChargeApportionmentCodeType;
import tw.gov.customs.schema.n5107.wcods.CustomsValuationMethodCodeType;
import tw.gov.customs.schema.n5107.wcods.CustomsValuationPartyRelationshipCodeType;
import tw.gov.customs.schema.n5107.wcods.CustomsValuationPaymentTermsCodeType;
import tw.gov.customs.schema.n5107.wcods.DeclarationFunctionCodeType;
import tw.gov.customs.schema.n5107.wcods.DeclarationStatusCodeType;
import tw.gov.customs.schema.n5107.wcods.DeclarationTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.DepartureTransportMeansTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.DutyTaxFeeDutyRegimeCodeType;
import tw.gov.customs.schema.n5107.wcods.DutyTaxFeeTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.ErrorValidationCodeType;
import tw.gov.customs.schema.n5107.wcods.FacilityPlaceTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.FreightPaymentMethodCodeType;
import tw.gov.customs.schema.n5107.wcods.FreightRateTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.GoodsShipmentExportationCountryCodeType;
import tw.gov.customs.schema.n5107.wcods.GoodsShipmentExportationRegionCodeType;
import tw.gov.customs.schema.n5107.wcods.GoodsShipmentFreeTradeZoneStatusCodeType;
import tw.gov.customs.schema.n5107.wcods.GoodsShipmentTransactionNatureCodeType;
import tw.gov.customs.schema.n5107.wcods.GovernmentAgencyIdentificationCodeType;
import tw.gov.customs.schema.n5107.wcods.GovernmentProcedureCurrentCodeType;
import tw.gov.customs.schema.n5107.wcods.GovernmentProcedurePreviousCodeType;
import tw.gov.customs.schema.n5107.wcods.HandlingInstructionsCodeType;
import tw.gov.customs.schema.n5107.wcods.InvoiceTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.ItineraryFunctionCodeType;
import tw.gov.customs.schema.n5107.wcods.ItineraryRoutingCountryCodeType;
import tw.gov.customs.schema.n5107.wcods.MasterNationalityCodeType;
import tw.gov.customs.schema.n5107.wcods.ObligationGuaranteeInvalidTransitCountryCodeType;
import tw.gov.customs.schema.n5107.wcods.ObligationGuaranteeSecurityDetailsCodeType;
import tw.gov.customs.schema.n5107.wcods.OriginCountryCodeType;
import tw.gov.customs.schema.n5107.wcods.PackagingTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.PaymentMethodCodeType;
import tw.gov.customs.schema.n5107.wcods.PointerDocumentSectionCodeType;
import tw.gov.customs.schema.n5107.wcods.PreviousDocumentTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.ResponseFunctionCodeType;
import tw.gov.customs.schema.n5107.wcods.SourceCountryCodeType;
import tw.gov.customs.schema.n5107.wcods.SourcePoliticalRegionCodeType;
import tw.gov.customs.schema.n5107.wcods.SourceTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.StatusNameCodeType;
import tw.gov.customs.schema.n5107.wcods.StorageCountryCodeType;
import tw.gov.customs.schema.n5107.wcods.TemperatureCategoryCodeType;
import tw.gov.customs.schema.n5107.wcods.TradeTermsConditionCodeType;
import tw.gov.customs.schema.n5107.wcods.TradeTermsCountryRelationshipCodeType;
import tw.gov.customs.schema.n5107.wcods.TransitControlResultCodeType;
import tw.gov.customs.schema.n5107.wcods.TransitTransportMeansTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.TransportContractDocumentConditionCodeType;
import tw.gov.customs.schema.n5107.wcods.TransportContractDocumentTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.TransportEquipmentAttachedCodeType;
import tw.gov.customs.schema.n5107.wcods.TransportEquipmentCharacteristicCodeType;
import tw.gov.customs.schema.n5107.wcods.TransportEquipmentEventStatusCodeType;
import tw.gov.customs.schema.n5107.wcods.TransportEquipmentFullnessCodeType;
import tw.gov.customs.schema.n5107.wcods.TransportEquipmentLicensePlateIssuingCountryCodeType;
import tw.gov.customs.schema.n5107.wcods.TransportEquipmentRegistrationCountrySubdivisionCodeType;
import tw.gov.customs.schema.n5107.wcods.TransportEquipmentSupplierPartyTypeCodeType;
import tw.gov.customs.schema.n5107.wcods.TransportMeansIntermediateTransportMeansModeAndTypeIdentificationCodeType;
import tw.gov.customs.schema.n5107.wcods.TransportMeansOwnerNationalityCodeType;
import tw.gov.customs.schema.n5107.wcods.ValuationAdjustmentAdditionCodeType;
import wco.datamodel.tw.ds._1.ApplicationTypeCodeType;
import wco.datamodel.tw.ds._1.GovernmentProcedureTransportTypeCodeType;
import wco.datamodel.tw.ds._1.SamplingPeriodCodeType;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:UniqueID xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm5ISO42173A="urn:un:unece:uncefact:codelist:standard:5:ISO42173A:2008-11-12" xmlns:clm60133="urn:un:unece:uncefact:codelist:standard:6:0133:40106" xmlns:clm63055="urn:un:unece:uncefact:codelist:standard:6:3055:D08A" xmlns:clm6Recommendation20="urn:un:unece:uncefact:codelist:standard:6:Recommendation20:5" xmlns:clmIANACharacterSetCode="urn:un:unece:uncefact:codelist:standard:IANA:CharacterSetCode:2007-05-14" xmlns:clmIANAMIMEMediaType="urn:un:unece:uncefact:codelist:standard:IANA:MIMEMediaType:2008-11-12" xmlns:ids5ISO316612A="urn:un:unece:uncefact:identifierlist:standard:5:ISO316612A:SecondEdition2006VI-3" xmlns:udt="urn:un:unece:uncefact:data:standard:UnqualifiedDataType:6" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UDT000007&lt;/ccts:UniqueID&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Acronym xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm5ISO42173A="urn:un:unece:uncefact:codelist:standard:5:ISO42173A:2008-11-12" xmlns:clm60133="urn:un:unece:uncefact:codelist:standard:6:0133:40106" xmlns:clm63055="urn:un:unece:uncefact:codelist:standard:6:3055:D08A" xmlns:clm6Recommendation20="urn:un:unece:uncefact:codelist:standard:6:Recommendation20:5" xmlns:clmIANACharacterSetCode="urn:un:unece:uncefact:codelist:standard:IANA:CharacterSetCode:2007-05-14" xmlns:clmIANAMIMEMediaType="urn:un:unece:uncefact:codelist:standard:IANA:MIMEMediaType:2008-11-12" xmlns:ids5ISO316612A="urn:un:unece:uncefact:identifierlist:standard:5:ISO316612A:SecondEdition2006VI-3" xmlns:udt="urn:un:unece:uncefact:data:standard:UnqualifiedDataType:6" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UDT&lt;/ccts:Acronym&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:DictionaryEntryName xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm5ISO42173A="urn:un:unece:uncefact:codelist:standard:5:ISO42173A:2008-11-12" xmlns:clm60133="urn:un:unece:uncefact:codelist:standard:6:0133:40106" xmlns:clm63055="urn:un:unece:uncefact:codelist:standard:6:3055:D08A" xmlns:clm6Recommendation20="urn:un:unece:uncefact:codelist:standard:6:Recommendation20:5" xmlns:clmIANACharacterSetCode="urn:un:unece:uncefact:codelist:standard:IANA:CharacterSetCode:2007-05-14" xmlns:clmIANAMIMEMediaType="urn:un:unece:uncefact:codelist:standard:IANA:MIMEMediaType:2008-11-12" xmlns:ids5ISO316612A="urn:un:unece:uncefact:identifierlist:standard:5:ISO316612A:SecondEdition2006VI-3" xmlns:udt="urn:un:unece:uncefact:data:standard:UnqualifiedDataType:6" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Code. Type&lt;/ccts:DictionaryEntryName&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Version xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm5ISO42173A="urn:un:unece:uncefact:codelist:standard:5:ISO42173A:2008-11-12" xmlns:clm60133="urn:un:unece:uncefact:codelist:standard:6:0133:40106" xmlns:clm63055="urn:un:unece:uncefact:codelist:standard:6:3055:D08A" xmlns:clm6Recommendation20="urn:un:unece:uncefact:codelist:standard:6:Recommendation20:5" xmlns:clmIANACharacterSetCode="urn:un:unece:uncefact:codelist:standard:IANA:CharacterSetCode:2007-05-14" xmlns:clmIANAMIMEMediaType="urn:un:unece:uncefact:codelist:standard:IANA:MIMEMediaType:2008-11-12" xmlns:ids5ISO316612A="urn:un:unece:uncefact:identifierlist:standard:5:ISO316612A:SecondEdition2006VI-3" xmlns:udt="urn:un:unece:uncefact:data:standard:UnqualifiedDataType:6" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;2.01&lt;/ccts:Version&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Definition xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm5ISO42173A="urn:un:unece:uncefact:codelist:standard:5:ISO42173A:2008-11-12" xmlns:clm60133="urn:un:unece:uncefact:codelist:standard:6:0133:40106" xmlns:clm63055="urn:un:unece:uncefact:codelist:standard:6:3055:D08A" xmlns:clm6Recommendation20="urn:un:unece:uncefact:codelist:standard:6:Recommendation20:5" xmlns:clmIANACharacterSetCode="urn:un:unece:uncefact:codelist:standard:IANA:CharacterSetCode:2007-05-14" xmlns:clmIANAMIMEMediaType="urn:un:unece:uncefact:codelist:standard:IANA:MIMEMediaType:2008-11-12" xmlns:ids5ISO316612A="urn:un:unece:uncefact:identifierlist:standard:5:ISO316612A:SecondEdition2006VI-3" xmlns:udt="urn:un:unece:uncefact:data:standard:UnqualifiedDataType:6" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;A character string (letters, figures, or symbols) that for brevity and/or languange independence may be used to represent or replace a definitive value or text of an attribute together with relevant supplementary information.&lt;/ccts:Definition&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:PrimitiveType xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm5ISO42173A="urn:un:unece:uncefact:codelist:standard:5:ISO42173A:2008-11-12" xmlns:clm60133="urn:un:unece:uncefact:codelist:standard:6:0133:40106" xmlns:clm63055="urn:un:unece:uncefact:codelist:standard:6:3055:D08A" xmlns:clm6Recommendation20="urn:un:unece:uncefact:codelist:standard:6:Recommendation20:5" xmlns:clmIANACharacterSetCode="urn:un:unece:uncefact:codelist:standard:IANA:CharacterSetCode:2007-05-14" xmlns:clmIANAMIMEMediaType="urn:un:unece:uncefact:codelist:standard:IANA:MIMEMediaType:2008-11-12" xmlns:ids5ISO316612A="urn:un:unece:uncefact:identifierlist:standard:5:ISO316612A:SecondEdition2006VI-3" xmlns:udt="urn:un:unece:uncefact:data:standard:UnqualifiedDataType:6" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;string&lt;/ccts:PrimitiveType&gt;
 * </pre>
 * 
 * 
 * <p>CodeType complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="CodeType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;token"&gt;
 *       &lt;attribute name="listID" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *       &lt;attribute name="listAgencyID" type="{urn:un:unece:uncefact:codelist:standard:6:3055:D08A}AgencyIdentificationCodeContentType" /&gt;
 *       &lt;attribute name="listAgencyName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="listName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="listVersionID" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="languageID" type="{http://www.w3.org/2001/XMLSchema}language" /&gt;
 *       &lt;attribute name="listURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *       &lt;attribute name="listSchemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CodeType", propOrder = {
    "value"
})
@XmlSeeAlso({
    DeclarationFunctionCodeType.class,
    ResponseFunctionCodeType.class,
    DeclarationStatusCodeType.class,
    GoodsShipmentExportationCountryCodeType.class,
    OriginCountryCodeType.class,
    ItineraryRoutingCountryCodeType.class,
    GoodsShipmentExportationRegionCodeType.class,
    TradeTermsConditionCodeType.class,
    TransportContractDocumentConditionCodeType.class,
    HandlingInstructionsCodeType.class,
    ConsignmentGoodsStatusCodeType.class,
    ConsignmentItemGoodsStatusCodeType.class,
    AdditionalInformationRequestOverrideCodeType.class,
    FreightPaymentMethodCodeType.class,
    AmendmentChangeReasonCodeType.class,
    ObligationGuaranteeSecurityDetailsCodeType.class,
    AgentFunctionCodeType.class,
    GoodsShipmentTransactionNatureCodeType.class,
    TradeTermsCountryRelationshipCodeType.class,
    PaymentMethodCodeType.class,
    DutyTaxFeeTypeCodeType.class,
    CustomsValuationMethodCodeType.class,
    CustomsValuationFreightChargeApportionmentCodeType.class,
    CurrencyExchangeCurrencyTypeCodeType.class,
    PackagingTypeCodeType.class,
    BorderTransportMeansCallPurposeCodeType.class,
    TransportEquipmentSupplierPartyTypeCodeType.class,
    TransportEquipmentCharacteristicCodeType.class,
    TransportEquipmentFullnessCodeType.class,
    GovernmentProcedurePreviousCodeType.class,
    CustomsValuationPartyRelationshipCodeType.class,
    DutyTaxFeeDutyRegimeCodeType.class,
    GovernmentProcedureCurrentCodeType.class,
    ValuationAdjustmentAdditionCodeType.class,
    MasterNationalityCodeType.class,
    AdditionalInformationStatementCodeType.class,
    ObligationGuaranteeInvalidTransitCountryCodeType.class,
    ConsignmentItemAssociatedGovernmentProcedureCodeType.class,
    CommoditySensitiveGoodsCodeType.class,
    TransitControlResultCodeType.class,
    AddressCountryCodeType.class,
    ItineraryFunctionCodeType.class,
    CommodityCharacteristicCodeType.class,
    TransportEquipmentLicensePlateIssuingCountryCodeType.class,
    BorderTransportMeansRegistrationCountrySubdivisionCodeType.class,
    SourcePoliticalRegionCodeType.class,
    TransportEquipmentRegistrationCountrySubdivisionCodeType.class,
    CommercialDriversLicenseCountryCodeType.class,
    CommercialDriversLicenseCountrySubdivisionCodeType.class,
    TransportMeansOwnerNationalityCodeType.class,
    AdditionalInformationReconciliationReasonCodeType.class,
    CustomsValuationPaymentTermsCodeType.class,
    BorderTransportMeansSecurityLevelCodeType.class,
    GoodsShipmentFreeTradeZoneStatusCodeType.class,
    CommodityCriteriaConformanceCodeType.class,
    FreightRateTypeCodeType.class,
    BorderTransportMeansBunkerFuelTypeCodeType.class,
    TemperatureCategoryCodeType.class,
    CommodityPhysicalStateCodeType.class,
    CommodityCategoryCodeType.class,
    CommodityCategoryQualifierCodeType.class,
    CommodityIntendedUseCodeType.class,
    CommodityGoodsGroupNameCodeType.class,
    CommodityRelatedPackagingHierarchicCodeType.class,
    CommodityCharacteristicQualifierCodeType.class,
    CommodityNameQualifierCodeType.class,
    BorderTransportMeansBallastOrCargoTypeCodeType.class,
    ClassificationIdentificationTypeCodeType.class,
    CommodityIDTypeCodeType.class,
    CommodityProcessTypeIdentificationCodeType.class,
    CommodityRelatedPackagingDangerousGoodsPackingRequirementGroupCodeType.class,
    ConsignmentItemRelatedPackagingDangerousGoodsPackingRequirementGroupCodeType.class,
    CommodityClassificationNameCodeType.class,
    CommodityIdentityQualifierCodeType.class,
    ConstituentElementCodeType.class,
    TransportMeansIntermediateTransportMeansModeAndTypeIdentificationCodeType.class,
    TransportEquipmentEventStatusCodeType.class,
    GovernmentAgencyIdentificationCodeType.class,
    CommercialDriversLicenseEndorsementCodeType.class,
    AdditionalDocumentLPCOExemptionCodeType.class,
    AdditionalInformationStatementTypeCodeType.class,
    CustomsValuationChargesTypeCodeType.class,
    PointerDocumentSectionCodeType.class,
    ErrorValidationCodeType.class,
    StatusNameCodeType.class,
    TransportEquipmentAttachedCodeType.class,
    CrewMemberEndorsementTypeCodeType.class,
    SourceCountryCodeType.class,
    SourceTypeCodeType.class,
    StorageCountryCodeType.class,
    AdditionalDocumentTypeCodeType.class,
    AssociatedTransportDocumentTypeCodeType.class,
    DeclarationTypeCodeType.class,
    PreviousDocumentTypeCodeType.class,
    TransportContractDocumentTypeCodeType.class,
    InvoiceTypeCodeType.class,
    FacilityPlaceTypeCodeType.class,
    AgentRoleCodeType.class,
    ArrivalTransportMeansTypeCodeType.class,
    DepartureTransportMeansTypeCodeType.class,
    BorderTransportMeansTypeCodeType.class,
    TransitTransportMeansTypeCodeType.class,
    BorderTransportMeansRegistrationNationalityCodeType.class,
    GovernmentProcedureTransportTypeCodeType.class,
    ApplicationTypeCodeType.class,
    SamplingPeriodCodeType.class
})
public class CodeType {

    @XmlValue
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String value;
    @XmlAttribute(name = "listID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String listID;
    @XmlAttribute(name = "listAgencyID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String listAgencyID;
    @XmlAttribute(name = "listAgencyName")
    protected String listAgencyName;
    @XmlAttribute(name = "listName")
    protected String listName;
    @XmlAttribute(name = "listVersionID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String listVersionID;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "languageID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String languageID;
    @XmlAttribute(name = "listURI")
    @XmlSchemaType(name = "anyURI")
    protected String listURI;
    @XmlAttribute(name = "listSchemeURI")
    @XmlSchemaType(name = "anyURI")
    protected String listSchemeURI;

    /**
     * 取得 value 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * 設定 value 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 取得 listID 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListID() {
        return listID;
    }

    /**
     * 設定 listID 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListID(String value) {
        this.listID = value;
    }

    /**
     * 取得 listAgencyID 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListAgencyID() {
        return listAgencyID;
    }

    /**
     * 設定 listAgencyID 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListAgencyID(String value) {
        this.listAgencyID = value;
    }

    /**
     * 取得 listAgencyName 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListAgencyName() {
        return listAgencyName;
    }

    /**
     * 設定 listAgencyName 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListAgencyName(String value) {
        this.listAgencyName = value;
    }

    /**
     * 取得 listName 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListName() {
        return listName;
    }

    /**
     * 設定 listName 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListName(String value) {
        this.listName = value;
    }

    /**
     * 取得 listVersionID 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListVersionID() {
        return listVersionID;
    }

    /**
     * 設定 listVersionID 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListVersionID(String value) {
        this.listVersionID = value;
    }

    /**
     * 取得 name 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * 設定 name 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * 取得 languageID 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageID() {
        return languageID;
    }

    /**
     * 設定 languageID 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageID(String value) {
        this.languageID = value;
    }

    /**
     * 取得 listURI 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListURI() {
        return listURI;
    }

    /**
     * 設定 listURI 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListURI(String value) {
        this.listURI = value;
    }

    /**
     * 取得 listSchemeURI 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListSchemeURI() {
        return listSchemeURI;
    }

    /**
     * 設定 listSchemeURI 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListSchemeURI(String value) {
        this.listSchemeURI = value;
    }

}
