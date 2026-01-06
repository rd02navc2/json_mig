//
// 此檔案是由 Eclipse Implementation of JAXB, v2.3.8 所產生 
// 請參閱 https://eclipse-ee4j.github.io/jaxb-ri 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2025.10.20 於 05:05:05 PM CST 
//


package un.unece.uncefact.codelist.standard.unece.resourcecostcategory.d08a;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ResourceCostCategoryContentType 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * <pre>
 * &lt;simpleType name="ResourceCostCategoryContentType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="LAB"/&gt;
 *     &lt;enumeration value="MAT"/&gt;
 *     &lt;enumeration value="ODC"/&gt;
 *     &lt;enumeration value="SBC"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ResourceCostCategoryContentType", namespace = "urn:un:unece:uncefact:codelist:standard:UNECE:ResourceCostCategory:D08A")
@XmlEnum
public enum ResourceCostCategoryContentType {


    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69669="urn:un:unece:uncefact:codelist:standard:UNECE:ResourceCostCategory:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Labour&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69669="urn:un:unece:uncefact:codelist:standard:UNECE:ResourceCostCategory:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Labour used to produce an item.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    LAB,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69669="urn:un:unece:uncefact:codelist:standard:UNECE:ResourceCostCategory:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Material&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69669="urn:un:unece:uncefact:codelist:standard:UNECE:ResourceCostCategory:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Material used to produce an item.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    MAT,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69669="urn:un:unece:uncefact:codelist:standard:UNECE:ResourceCostCategory:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Other direct cost&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69669="urn:un:unece:uncefact:codelist:standard:UNECE:ResourceCostCategory:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;A cost directly incurred to produce an item other than labour or materials.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    ODC,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69669="urn:un:unece:uncefact:codelist:standard:UNECE:ResourceCostCategory:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Subcontract&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69669="urn:un:unece:uncefact:codelist:standard:UNECE:ResourceCostCategory:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;The cost of any work subcontracted out to another entity to produce an item.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    SBC;

    public String value() {
        return name();
    }

    public static ResourceCostCategoryContentType fromValue(String v) {
        return valueOf(v);
    }

}
