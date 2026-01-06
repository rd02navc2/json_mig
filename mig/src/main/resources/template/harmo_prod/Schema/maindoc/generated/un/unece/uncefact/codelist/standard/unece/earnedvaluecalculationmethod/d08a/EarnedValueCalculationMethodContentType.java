//
// 此檔案是由 Eclipse Implementation of JAXB, v2.3.8 所產生 
// 請參閱 https://eclipse-ee4j.github.io/jaxb-ri 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2025.10.20 於 05:05:05 PM CST 
//


package un.unece.uncefact.codelist.standard.unece.earnedvaluecalculationmethod.d08a;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>EarnedValueCalculationMethodContentType 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * <pre>
 * &lt;simpleType name="EarnedValueCalculationMethodContentType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="APF"/&gt;
 *     &lt;enumeration value="LOE"/&gt;
 *     &lt;enumeration value="MTN"/&gt;
 *     &lt;enumeration value="P01"/&gt;
 *     &lt;enumeration value="P10"/&gt;
 *     &lt;enumeration value="P50"/&gt;
 *     &lt;enumeration value="PLN"/&gt;
 *     &lt;enumeration value="PTC"/&gt;
 *     &lt;enumeration value="STD"/&gt;
 *     &lt;enumeration value="UNT"/&gt;
 *     &lt;enumeration value="ZZZ"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EarnedValueCalculationMethodContentType", namespace = "urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A")
@XmlEnum
public enum EarnedValueCalculationMethodContentType {


    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Apportioned effort&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Earned value dependent on other discrete tasks being completed.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    APF("APF"),

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Level of effort&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Earned value is based on the level of effort in the absence of specific end results or deliverables, such as management and other non discrete work tasks.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    LOE("LOE"),

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Milestone&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Earn a specified percent complete (of the total budget) when a milestone is complete.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    MTN("MTN"),

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Work complete&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Earn 100% of the budget value when the work effort is complete.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    @XmlEnumValue("P01")
    P_01("P01"),

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Work start&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Earn 100% of the budget value when the work effort begins.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    @XmlEnumValue("P10")
    P_10("P10"),

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Half start&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Earn 50% of the budget value when work begins, earn remaining 50% when work completes.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    @XmlEnumValue("P50")
    P_50("P50"),

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Package planning&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Not an earned value method per se, but used to identify a task or work package that must be broken down into discrete work effort at a later time.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    PLN("PLN"),

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Percent complete&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Earned value is based on the percent complete (between 0 and 100).&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    PTC("PTC"),

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Standards&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Earned value is based on a set standard defined for the type of product being produced.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    STD("STD"),

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Units&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Earned value is based on quantity of material units or manufactured components.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    UNT("UNT"),

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Mutually defined&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69657="urn:un:unece:uncefact:codelist:standard:UNECE:EarnedValueCalculationMethod:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Mutually agreed upon earned value calculation method.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    ZZZ("ZZZ");
    private final String value;

    EarnedValueCalculationMethodContentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EarnedValueCalculationMethodContentType fromValue(String v) {
        for (EarnedValueCalculationMethodContentType c: EarnedValueCalculationMethodContentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
