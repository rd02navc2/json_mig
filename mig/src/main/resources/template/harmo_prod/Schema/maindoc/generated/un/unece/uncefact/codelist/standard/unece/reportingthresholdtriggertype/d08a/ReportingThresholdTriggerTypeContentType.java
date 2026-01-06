//
// 此檔案是由 Eclipse Implementation of JAXB, v2.3.8 所產生 
// 請參閱 https://eclipse-ee4j.github.io/jaxb-ri 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2025.10.20 於 05:05:05 PM CST 
//


package un.unece.uncefact.codelist.standard.unece.reportingthresholdtriggertype.d08a;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ReportingThresholdTriggerTypeContentType 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * <pre>
 * &lt;simpleType name="ReportingThresholdTriggerTypeContentType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="BTH"/&gt;
 *     &lt;enumeration value="PCT"/&gt;
 *     &lt;enumeration value="VAL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ReportingThresholdTriggerTypeContentType", namespace = "urn:un:unece:uncefact:codelist:standard:UNECE:ReportingThresholdTriggerType:D08A")
@XmlEnum
public enum ReportingThresholdTriggerTypeContentType {


    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69667="urn:un:unece:uncefact:codelist:standard:UNECE:ReportingThresholdTriggerType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Value and percent&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69667="urn:un:unece:uncefact:codelist:standard:UNECE:ReportingThresholdTriggerType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Both value and percent can be used.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    BTH,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69667="urn:un:unece:uncefact:codelist:standard:UNECE:ReportingThresholdTriggerType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Percent&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69667="urn:un:unece:uncefact:codelist:standard:UNECE:ReportingThresholdTriggerType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;The percentage of the value is used.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    PCT,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69667="urn:un:unece:uncefact:codelist:standard:UNECE:ReportingThresholdTriggerType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Value&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69667="urn:un:unece:uncefact:codelist:standard:UNECE:ReportingThresholdTriggerType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;The actual value is used.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    VAL;

    public String value() {
        return name();
    }

    public static ReportingThresholdTriggerTypeContentType fromValue(String v) {
        return valueOf(v);
    }

}
