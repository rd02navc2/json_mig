//
// 此檔案是由 Eclipse Implementation of JAXB, v2.3.8 所產生 
// 請參閱 https://eclipse-ee4j.github.io/jaxb-ri 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2025.10.20 於 05:05:05 PM CST 
//


package un.unece.uncefact.codelist.standard.unece.fundingtypecode.d08a;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>FundingTypeCodeContentType 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * <pre>
 * &lt;simpleType name="FundingTypeCodeContentType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="INC"/&gt;
 *     &lt;enumeration value="MYR"/&gt;
 *     &lt;enumeration value="SYR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "FundingTypeCodeContentType", namespace = "urn:un:unece:uncefact:codelist:standard:UNECE:FundingTypeCode:D08A")
@XmlEnum
public enum FundingTypeCodeContentType {


    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69659="urn:un:unece:uncefact:codelist:standard:UNECE:FundingTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Incremental&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69659="urn:un:unece:uncefact:codelist:standard:UNECE:FundingTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Funded in arbitrary increments&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    INC,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69659="urn:un:unece:uncefact:codelist:standard:UNECE:FundingTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Multi-year&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69659="urn:un:unece:uncefact:codelist:standard:UNECE:FundingTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Funded over multiple years.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    MYR,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69659="urn:un:unece:uncefact:codelist:standard:UNECE:FundingTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Single year&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69659="urn:un:unece:uncefact:codelist:standard:UNECE:FundingTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Funded for a single year.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    SYR;

    public String value() {
        return name();
    }

    public static FundingTypeCodeContentType fromValue(String v) {
        return valueOf(v);
    }

}
