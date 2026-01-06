//
// 此檔案是由 Eclipse Implementation of JAXB, v2.3.8 所產生 
// 請參閱 https://eclipse-ee4j.github.io/jaxb-ri 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2025.10.20 於 05:05:05 PM CST 
//


package un.unece.uncefact.codelist.standard.unece.projecttypecode.d08a;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ProjectTypeCodeContentType 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * <pre>
 * &lt;simpleType name="ProjectTypeCodeContentType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="DEP"/&gt;
 *     &lt;enumeration value="FRP"/&gt;
 *     &lt;enumeration value="LRP"/&gt;
 *     &lt;enumeration value="OS"/&gt;
 *     &lt;enumeration value="PRC"/&gt;
 *     &lt;enumeration value="PRD"/&gt;
 *     &lt;enumeration value="RDT"/&gt;
 *     &lt;enumeration value="SDD"/&gt;
 *     &lt;enumeration value="ZZZ"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ProjectTypeCodeContentType", namespace = "urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08A")
@XmlEnum
public enum ProjectTypeCodeContentType {


    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Deployment&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;A project intended to take an existing product and place it into operational use.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    DEP,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Full rate production&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;A project geared to producing goods and/or services at an economic level. Also known as full scale development.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    FRP,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Low rate initial production&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;A project serving as the first effort of the production and deployment phase, such as establishing an initial production base for the system and facilitating an orderly ramp-up, sufficient to lead to a smooth transition to full rate production.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    LRP,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Operations and support&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;A project that provides a support program for operating and sustaining a system and/or service over its total life cycle.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    OS,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Government Procurement&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;A project involving buying goods and/or services for the government.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    PRC,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Production&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;A project producing goods and/or services, such as the process of converting raw materials into finished goods. It may include functions such as production scheduling, inspection, and quality control.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    PRD,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Research, development, test and evaluation&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;A project geared to researching, developing, testing, and evaluating a new product or service.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    RDT,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;System development and demonstration&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;A project consisting of two efforts, development of a system, and the demonstration to the project sponsor that the system satisfies project requirements.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    SDD,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Mutually defined&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69665="urn:un:unece:uncefact:codelist:standard:UNECE:ProjectTypeCode:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Mutually agreed upon project type.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    ZZZ;

    public String value() {
        return name();
    }

    public static ProjectTypeCodeContentType fromValue(String v) {
        return valueOf(v);
    }

}
