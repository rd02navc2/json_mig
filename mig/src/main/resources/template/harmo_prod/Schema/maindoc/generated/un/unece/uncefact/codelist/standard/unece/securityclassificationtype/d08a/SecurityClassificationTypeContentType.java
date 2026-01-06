//
// 此檔案是由 Eclipse Implementation of JAXB, v2.3.8 所產生 
// 請參閱 https://eclipse-ee4j.github.io/jaxb-ri 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2025.10.20 於 05:05:05 PM CST 
//


package un.unece.uncefact.codelist.standard.unece.securityclassificationtype.d08a;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SecurityClassificationTypeContentType 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * <pre>
 * &lt;simpleType name="SecurityClassificationTypeContentType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="CS"/&gt;
 *     &lt;enumeration value="GC"/&gt;
 *     &lt;enumeration value="GNC"/&gt;
 *     &lt;enumeration value="GS"/&gt;
 *     &lt;enumeration value="GTS"/&gt;
 *     &lt;enumeration value="UNC"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SecurityClassificationTypeContentType", namespace = "urn:un:unece:uncefact:codelist:standard:UNECE:SecurityClassificationType:D08A")
@XmlEnum
public enum SecurityClassificationTypeContentType {


    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69677="urn:un:unece:uncefact:codelist:standard:UNECE:SecurityClassificationType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Competition sensitive&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69677="urn:un:unece:uncefact:codelist:standard:UNECE:SecurityClassificationType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Information which provides a competitive advantage.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    CS,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69677="urn:un:unece:uncefact:codelist:standard:UNECE:SecurityClassificationType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Government confidential&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69677="urn:un:unece:uncefact:codelist:standard:UNECE:SecurityClassificationType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Information which is defined by a government entity as confidential.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    GC,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69677="urn:un:unece:uncefact:codelist:standard:UNECE:SecurityClassificationType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Government non-classified&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69677="urn:un:unece:uncefact:codelist:standard:UNECE:SecurityClassificationType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Information which is defined by a government entity as not confidential.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    GNC,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69677="urn:un:unece:uncefact:codelist:standard:UNECE:SecurityClassificationType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Government secret&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69677="urn:un:unece:uncefact:codelist:standard:UNECE:SecurityClassificationType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Information which is defined by a government entity as secret.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    GS,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69677="urn:un:unece:uncefact:codelist:standard:UNECE:SecurityClassificationType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Government top secret&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69677="urn:un:unece:uncefact:codelist:standard:UNECE:SecurityClassificationType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Information which is defined by a government entity as having the highest level of secrecy.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    GTS,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69677="urn:un:unece:uncefact:codelist:standard:UNECE:SecurityClassificationType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Unclassified&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69677="urn:un:unece:uncefact:codelist:standard:UNECE:SecurityClassificationType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Information which is openly available.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    UNC;

    public String value() {
        return name();
    }

    public static SecurityClassificationTypeContentType fromValue(String v) {
        return valueOf(v);
    }

}
