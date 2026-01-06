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
import tw.gov.customs.schema.n5107.wcods.AdditionalDocumentIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.AdditionalDocumentIssueLocationIDType;
import tw.gov.customs.schema.n5107.wcods.AdditionalDocumentIssuingPartyIDType;
import tw.gov.customs.schema.n5107.wcods.AddressCountrySubDivisionIDType;
import tw.gov.customs.schema.n5107.wcods.AddressPostcodeIDType;
import tw.gov.customs.schema.n5107.wcods.AgentIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.AppealOfficeIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ApprovedEstablishmentPlaceIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ArrivalConveyanceFacilityIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ArrivalTransportMeansIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ArrivalTransportMeansRegistrationNationalityIDType;
import tw.gov.customs.schema.n5107.wcods.AssemblerIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.AssociatedTransportDocumentIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.AuthenticatorIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.AuthorisedPersonIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.BankAccountIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.BankAccountReferenceIDType;
import tw.gov.customs.schema.n5107.wcods.BorderTransportMeansConstructionPlaceIDType;
import tw.gov.customs.schema.n5107.wcods.BorderTransportMeansFirstArrivalLocationIDType;
import tw.gov.customs.schema.n5107.wcods.BorderTransportMeansIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.BorderTransportMeansJourneyIDType;
import tw.gov.customs.schema.n5107.wcods.BorderTransportMeansScheduledConveyanceIDType;
import tw.gov.customs.schema.n5107.wcods.BorderTransportMeansStayIDType;
import tw.gov.customs.schema.n5107.wcods.BuyerIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.CarrierIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.CertificateOfResponsibilityHolderIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.CertifierIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ClassificationIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.CommodityCommercialCategorizationIDType;
import tw.gov.customs.schema.n5107.wcods.CommodityIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.CommodityLotNumberIDType;
import tw.gov.customs.schema.n5107.wcods.CommunicationIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.CommunicationTypeIDType;
import tw.gov.customs.schema.n5107.wcods.ConsigneeIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ConsignmentCarrierAssignedIDType;
import tw.gov.customs.schema.n5107.wcods.ConsignorIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ConsolidatorIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ConsortiumCarrierIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ContactOfficeIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ContainerOperatorIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ContainerTerminalOperatorIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ControlReviewPlaceIDType;
import tw.gov.customs.schema.n5107.wcods.CrewMemberIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.DeclarationDeclarationOfficeIDType;
import tw.gov.customs.schema.n5107.wcods.DeclarationFunctionalReferenceIDType;
import tw.gov.customs.schema.n5107.wcods.DeclarationIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.DeclarationIssueLocationIDType;
import tw.gov.customs.schema.n5107.wcods.DeclarationSubsequentDeclarationOfficeIDType;
import tw.gov.customs.schema.n5107.wcods.DeclarationVersionIDType;
import tw.gov.customs.schema.n5107.wcods.DeconsolidatorIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.DeliveryDestinationIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.DepartureConveyanceFacilityIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.DepartureTransportMeansIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.DepartureTransportMeansRegistrationNationalityIDType;
import tw.gov.customs.schema.n5107.wcods.DistillerIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.DistributorIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.DraymanOrLightermanIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.EntryOfficeIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.EquipmentOwnerIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ExaminationPlaceIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ExhibitorIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ExitOfficeIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ExporterIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.FacilityPlaceIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.FeedlotIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.FinalTransportMeansLoadingPlaceIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.FreeTradeZoneIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.GoodsConsignedPlaceIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.GoodsLocationIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.GoodsReceiptPlaceIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.GovernmentOfficerIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.GovernmentServiceRequestorIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.GrowerIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ImporterIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.InsuranceCompanyIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.IntermediateCarrierIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.IntermediateConsigneeIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.InvoiceIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ItineraryIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ItineraryRoutingRegionIDType;
import tw.gov.customs.schema.n5107.wcods.LPCOAuthorizedPartyIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.LandingLocationIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.LoadingLocationIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ManufacturerIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.MasterIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.NonVesselOperatingCarrierIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.NotifyPartyIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ObligationGuaranteeReferenceIDType;
import tw.gov.customs.schema.n5107.wcods.OrganicCertifyingOrganizationIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.OriginRegionIDType;
import tw.gov.customs.schema.n5107.wcods.PaymentOfficeIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.PaymentReferenceIDType;
import tw.gov.customs.schema.n5107.wcods.PermittedPortIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.PointerTagIDType;
import tw.gov.customs.schema.n5107.wcods.PreviousDocumentIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ProducerIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.PropertyOperatorIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.PropertyOwnerIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.RegisteredFacilityIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.RepairPartyIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.ResponseFunctionalReferenceIDType;
import tw.gov.customs.schema.n5107.wcods.ResponsibleGovernmentAgencyIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.SellerIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.StevedoreIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.StoragePoliticalRegionIDType;
import tw.gov.customs.schema.n5107.wcods.StowPositionIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.StuffingEstablishmentIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.SubmitterIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.SupplierIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.SuretyIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.TerminalIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.TradeTermsLocationIDType;
import tw.gov.customs.schema.n5107.wcods.TranshipmentLocationIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.TransitDepartureIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.TransitDestinationIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.TransitOfficeIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.TransitPrincipalIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.TransitTransportMeansIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.TransitTransportMeansJourneyIDType;
import tw.gov.customs.schema.n5107.wcods.TransitTransportMeansRegistrationNationalityIDType;
import tw.gov.customs.schema.n5107.wcods.TransportContractDocumentIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.TransportContractDocumentIssuingPartyIDType;
import tw.gov.customs.schema.n5107.wcods.TransportEquipmentIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.TransportEquipmentSealIDType;
import tw.gov.customs.schema.n5107.wcods.TransportMeansOperatorIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.TransportMeansOwnerIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.UCRIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.UCRTraderAssignedReferenceIDType;
import tw.gov.customs.schema.n5107.wcods.UltimateConsigneeIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.UnloadingLocationIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.UnloadingPartyIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.VehicleOwnerIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.VerifierIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.VeterinarianIdentificationIDType;
import tw.gov.customs.schema.n5107.wcods.WarehouseIdentificationIDType;
import wco.datamodel.tw.ds._1.AgentSubBoxIDType;
import wco.datamodel.tw.ds._1.ApplicantIdentificationIDType;
import wco.datamodel.tw.ds._1.PreviousDocumentFunctionalReferenceIDType;
import wco.datamodel.tw.ds._1.PreviousDocumentUniversallyUniqueIDType;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:UniqueID xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm5ISO42173A="urn:un:unece:uncefact:codelist:standard:5:ISO42173A:2008-11-12" xmlns:clm60133="urn:un:unece:uncefact:codelist:standard:6:0133:40106" xmlns:clm63055="urn:un:unece:uncefact:codelist:standard:6:3055:D08A" xmlns:clm6Recommendation20="urn:un:unece:uncefact:codelist:standard:6:Recommendation20:5" xmlns:clmIANACharacterSetCode="urn:un:unece:uncefact:codelist:standard:IANA:CharacterSetCode:2007-05-14" xmlns:clmIANAMIMEMediaType="urn:un:unece:uncefact:codelist:standard:IANA:MIMEMediaType:2008-11-12" xmlns:ids5ISO316612A="urn:un:unece:uncefact:identifierlist:standard:5:ISO316612A:SecondEdition2006VI-3" xmlns:udt="urn:un:unece:uncefact:data:standard:UnqualifiedDataType:6" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UDT0000011&lt;/ccts:UniqueID&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Acronym xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm5ISO42173A="urn:un:unece:uncefact:codelist:standard:5:ISO42173A:2008-11-12" xmlns:clm60133="urn:un:unece:uncefact:codelist:standard:6:0133:40106" xmlns:clm63055="urn:un:unece:uncefact:codelist:standard:6:3055:D08A" xmlns:clm6Recommendation20="urn:un:unece:uncefact:codelist:standard:6:Recommendation20:5" xmlns:clmIANACharacterSetCode="urn:un:unece:uncefact:codelist:standard:IANA:CharacterSetCode:2007-05-14" xmlns:clmIANAMIMEMediaType="urn:un:unece:uncefact:codelist:standard:IANA:MIMEMediaType:2008-11-12" xmlns:ids5ISO316612A="urn:un:unece:uncefact:identifierlist:standard:5:ISO316612A:SecondEdition2006VI-3" xmlns:udt="urn:un:unece:uncefact:data:standard:UnqualifiedDataType:6" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UDT&lt;/ccts:Acronym&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:DictionaryEntryName xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm5ISO42173A="urn:un:unece:uncefact:codelist:standard:5:ISO42173A:2008-11-12" xmlns:clm60133="urn:un:unece:uncefact:codelist:standard:6:0133:40106" xmlns:clm63055="urn:un:unece:uncefact:codelist:standard:6:3055:D08A" xmlns:clm6Recommendation20="urn:un:unece:uncefact:codelist:standard:6:Recommendation20:5" xmlns:clmIANACharacterSetCode="urn:un:unece:uncefact:codelist:standard:IANA:CharacterSetCode:2007-05-14" xmlns:clmIANAMIMEMediaType="urn:un:unece:uncefact:codelist:standard:IANA:MIMEMediaType:2008-11-12" xmlns:ids5ISO316612A="urn:un:unece:uncefact:identifierlist:standard:5:ISO316612A:SecondEdition2006VI-3" xmlns:udt="urn:un:unece:uncefact:data:standard:UnqualifiedDataType:6" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Identifier. Type&lt;/ccts:DictionaryEntryName&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Version xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm5ISO42173A="urn:un:unece:uncefact:codelist:standard:5:ISO42173A:2008-11-12" xmlns:clm60133="urn:un:unece:uncefact:codelist:standard:6:0133:40106" xmlns:clm63055="urn:un:unece:uncefact:codelist:standard:6:3055:D08A" xmlns:clm6Recommendation20="urn:un:unece:uncefact:codelist:standard:6:Recommendation20:5" xmlns:clmIANACharacterSetCode="urn:un:unece:uncefact:codelist:standard:IANA:CharacterSetCode:2007-05-14" xmlns:clmIANAMIMEMediaType="urn:un:unece:uncefact:codelist:standard:IANA:MIMEMediaType:2008-11-12" xmlns:ids5ISO316612A="urn:un:unece:uncefact:identifierlist:standard:5:ISO316612A:SecondEdition2006VI-3" xmlns:udt="urn:un:unece:uncefact:data:standard:UnqualifiedDataType:6" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;2.01&lt;/ccts:Version&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Definition xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm5ISO42173A="urn:un:unece:uncefact:codelist:standard:5:ISO42173A:2008-11-12" xmlns:clm60133="urn:un:unece:uncefact:codelist:standard:6:0133:40106" xmlns:clm63055="urn:un:unece:uncefact:codelist:standard:6:3055:D08A" xmlns:clm6Recommendation20="urn:un:unece:uncefact:codelist:standard:6:Recommendation20:5" xmlns:clmIANACharacterSetCode="urn:un:unece:uncefact:codelist:standard:IANA:CharacterSetCode:2007-05-14" xmlns:clmIANAMIMEMediaType="urn:un:unece:uncefact:codelist:standard:IANA:MIMEMediaType:2008-11-12" xmlns:ids5ISO316612A="urn:un:unece:uncefact:identifierlist:standard:5:ISO316612A:SecondEdition2006VI-3" xmlns:udt="urn:un:unece:uncefact:data:standard:UnqualifiedDataType:6" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;A character string to identify and distinguish uniquely, one instance of an object in an identification scheme from all other objects in the same scheme together with relevant supplementary information.&lt;/ccts:Definition&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:PrimitiveType xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm5ISO42173A="urn:un:unece:uncefact:codelist:standard:5:ISO42173A:2008-11-12" xmlns:clm60133="urn:un:unece:uncefact:codelist:standard:6:0133:40106" xmlns:clm63055="urn:un:unece:uncefact:codelist:standard:6:3055:D08A" xmlns:clm6Recommendation20="urn:un:unece:uncefact:codelist:standard:6:Recommendation20:5" xmlns:clmIANACharacterSetCode="urn:un:unece:uncefact:codelist:standard:IANA:CharacterSetCode:2007-05-14" xmlns:clmIANAMIMEMediaType="urn:un:unece:uncefact:codelist:standard:IANA:MIMEMediaType:2008-11-12" xmlns:ids5ISO316612A="urn:un:unece:uncefact:identifierlist:standard:5:ISO316612A:SecondEdition2006VI-3" xmlns:udt="urn:un:unece:uncefact:data:standard:UnqualifiedDataType:6" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;string&lt;/ccts:PrimitiveType&gt;
 * </pre>
 * 
 * 
 * <p>IDType complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="IDType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *       &lt;attribute name="schemeID" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *       &lt;attribute name="schemeName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="schemeAgencyID" type="{urn:un:unece:uncefact:codelist:standard:6:3055:D08A}AgencyIdentificationCodeContentType" /&gt;
 *       &lt;attribute name="schemeAgencyName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="schemeVersionID" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *       &lt;attribute name="schemeDataURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *       &lt;attribute name="schemeURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDType", propOrder = {
    "value"
})
@XmlSeeAlso({
    ConsignmentCarrierAssignedIDType.class,
    UCRTraderAssignedReferenceIDType.class,
    BorderTransportMeansStayIDType.class,
    PaymentReferenceIDType.class,
    UCRIdentificationIDType.class,
    DeclarationDeclarationOfficeIDType.class,
    OriginRegionIDType.class,
    BorderTransportMeansFirstArrivalLocationIDType.class,
    ObligationGuaranteeReferenceIDType.class,
    ClassificationIdentificationIDType.class,
    CommodityIdentificationIDType.class,
    BorderTransportMeansJourneyIDType.class,
    TransitTransportMeansJourneyIDType.class,
    TransportEquipmentIdentificationIDType.class,
    TransportEquipmentSealIDType.class,
    DeclarationSubsequentDeclarationOfficeIDType.class,
    BorderTransportMeansScheduledConveyanceIDType.class,
    CommunicationIdentificationIDType.class,
    AddressCountrySubDivisionIDType.class,
    AddressPostcodeIDType.class,
    CommunicationTypeIDType.class,
    CommodityCommercialCategorizationIDType.class,
    CommodityLotNumberIDType.class,
    BorderTransportMeansConstructionPlaceIDType.class,
    ControlReviewPlaceIDType.class,
    BankAccountIdentificationIDType.class,
    PointerTagIDType.class,
    DeclarationVersionIDType.class,
    ItineraryRoutingRegionIDType.class,
    StoragePoliticalRegionIDType.class,
    AdditionalDocumentIssuingPartyIDType.class,
    AdditionalDocumentIssueLocationIDType.class,
    AdditionalDocumentIdentificationIDType.class,
    AssociatedTransportDocumentIdentificationIDType.class,
    DeclarationIssueLocationIDType.class,
    DeclarationIdentificationIDType.class,
    InvoiceIdentificationIDType.class,
    PreviousDocumentIdentificationIDType.class,
    TransportContractDocumentIssuingPartyIDType.class,
    TransportContractDocumentIdentificationIDType.class,
    DeclarationFunctionalReferenceIDType.class,
    ResponseFunctionalReferenceIDType.class,
    AppealOfficeIdentificationIDType.class,
    ContactOfficeIdentificationIDType.class,
    PaymentOfficeIdentificationIDType.class,
    EntryOfficeIdentificationIDType.class,
    ExitOfficeIdentificationIDType.class,
    TransitOfficeIdentificationIDType.class,
    TradeTermsLocationIDType.class,
    GoodsReceiptPlaceIdentificationIDType.class,
    ItineraryIdentificationIDType.class,
    TransitDestinationIdentificationIDType.class,
    LoadingLocationIdentificationIDType.class,
    UnloadingLocationIdentificationIDType.class,
    TranshipmentLocationIdentificationIDType.class,
    GoodsLocationIdentificationIDType.class,
    WarehouseIdentificationIDType.class,
    GoodsConsignedPlaceIdentificationIDType.class,
    ExaminationPlaceIdentificationIDType.class,
    StowPositionIdentificationIDType.class,
    TerminalIdentificationIDType.class,
    FacilityPlaceIdentificationIDType.class,
    DepartureConveyanceFacilityIdentificationIDType.class,
    ArrivalConveyanceFacilityIdentificationIDType.class,
    ApprovedEstablishmentPlaceIdentificationIDType.class,
    FreeTradeZoneIdentificationIDType.class,
    PermittedPortIdentificationIDType.class,
    LandingLocationIdentificationIDType.class,
    FinalTransportMeansLoadingPlaceIdentificationIDType.class,
    RegisteredFacilityIdentificationIDType.class,
    TransitDepartureIdentificationIDType.class,
    TransitPrincipalIdentificationIDType.class,
    AgentIdentificationIDType.class,
    AuthenticatorIdentificationIDType.class,
    BuyerIdentificationIDType.class,
    CarrierIdentificationIDType.class,
    NonVesselOperatingCarrierIdentificationIDType.class,
    ConsigneeIdentificationIDType.class,
    MasterIdentificationIDType.class,
    ConsolidatorIdentificationIDType.class,
    ConsignorIdentificationIDType.class,
    DeconsolidatorIdentificationIDType.class,
    StuffingEstablishmentIdentificationIDType.class,
    StevedoreIdentificationIDType.class,
    DeliveryDestinationIdentificationIDType.class,
    DistributorIdentificationIDType.class,
    ExporterIdentificationIDType.class,
    CrewMemberIdentificationIDType.class,
    ProducerIdentificationIDType.class,
    IntermediateConsigneeIdentificationIDType.class,
    ImporterIdentificationIDType.class,
    InsuranceCompanyIdentificationIDType.class,
    ManufacturerIdentificationIDType.class,
    ContainerOperatorIdentificationIDType.class,
    NotifyPartyIdentificationIDType.class,
    CertifierIdentificationIDType.class,
    SellerIdentificationIDType.class,
    SupplierIdentificationIDType.class,
    SuretyIdentificationIDType.class,
    TransportMeansOperatorIdentificationIDType.class,
    SubmitterIdentificationIDType.class,
    UltimateConsigneeIdentificationIDType.class,
    ResponsibleGovernmentAgencyIdentificationIDType.class,
    VerifierIdentificationIDType.class,
    AuthorisedPersonIdentificationIDType.class,
    BankAccountReferenceIDType.class,
    DistillerIdentificationIDType.class,
    DraymanOrLightermanIdentificationIDType.class,
    ExhibitorIdentificationIDType.class,
    FeedlotIdentificationIDType.class,
    GovernmentOfficerIdentificationIDType.class,
    GovernmentServiceRequestorIdentificationIDType.class,
    GrowerIdentificationIDType.class,
    LPCOAuthorizedPartyIdentificationIDType.class,
    PropertyOperatorIdentificationIDType.class,
    ContainerTerminalOperatorIdentificationIDType.class,
    TransportMeansOwnerIdentificationIDType.class,
    OrganicCertifyingOrganizationIdentificationIDType.class,
    EquipmentOwnerIdentificationIDType.class,
    CertificateOfResponsibilityHolderIdentificationIDType.class,
    PropertyOwnerIdentificationIDType.class,
    VehicleOwnerIdentificationIDType.class,
    VeterinarianIdentificationIDType.class,
    IntermediateCarrierIdentificationIDType.class,
    ConsortiumCarrierIdentificationIDType.class,
    AssemblerIdentificationIDType.class,
    UnloadingPartyIdentificationIDType.class,
    RepairPartyIdentificationIDType.class,
    ArrivalTransportMeansIdentificationIDType.class,
    DepartureTransportMeansIdentificationIDType.class,
    BorderTransportMeansIdentificationIDType.class,
    TransitTransportMeansIdentificationIDType.class,
    ArrivalTransportMeansRegistrationNationalityIDType.class,
    DepartureTransportMeansRegistrationNationalityIDType.class,
    TransitTransportMeansRegistrationNationalityIDType.class,
    PreviousDocumentFunctionalReferenceIDType.class,
    ApplicantIdentificationIDType.class,
    AgentSubBoxIDType.class,
    PreviousDocumentUniversallyUniqueIDType.class
})
public class IDType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "schemeID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String schemeID;
    @XmlAttribute(name = "schemeName")
    protected String schemeName;
    @XmlAttribute(name = "schemeAgencyID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String schemeAgencyID;
    @XmlAttribute(name = "schemeAgencyName")
    protected String schemeAgencyName;
    @XmlAttribute(name = "schemeVersionID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String schemeVersionID;
    @XmlAttribute(name = "schemeDataURI")
    @XmlSchemaType(name = "anyURI")
    protected String schemeDataURI;
    @XmlAttribute(name = "schemeURI")
    @XmlSchemaType(name = "anyURI")
    protected String schemeURI;

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
     * 取得 schemeID 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemeID() {
        return schemeID;
    }

    /**
     * 設定 schemeID 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemeID(String value) {
        this.schemeID = value;
    }

    /**
     * 取得 schemeName 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemeName() {
        return schemeName;
    }

    /**
     * 設定 schemeName 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemeName(String value) {
        this.schemeName = value;
    }

    /**
     * 取得 schemeAgencyID 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemeAgencyID() {
        return schemeAgencyID;
    }

    /**
     * 設定 schemeAgencyID 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemeAgencyID(String value) {
        this.schemeAgencyID = value;
    }

    /**
     * 取得 schemeAgencyName 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemeAgencyName() {
        return schemeAgencyName;
    }

    /**
     * 設定 schemeAgencyName 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemeAgencyName(String value) {
        this.schemeAgencyName = value;
    }

    /**
     * 取得 schemeVersionID 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemeVersionID() {
        return schemeVersionID;
    }

    /**
     * 設定 schemeVersionID 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemeVersionID(String value) {
        this.schemeVersionID = value;
    }

    /**
     * 取得 schemeDataURI 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemeDataURI() {
        return schemeDataURI;
    }

    /**
     * 設定 schemeDataURI 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemeDataURI(String value) {
        this.schemeDataURI = value;
    }

    /**
     * 取得 schemeURI 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemeURI() {
        return schemeURI;
    }

    /**
     * 設定 schemeURI 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemeURI(String value) {
        this.schemeURI = value;
    }

}
