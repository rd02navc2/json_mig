//
// 此檔案是由 Eclipse Implementation of JAXB, v2.3.8 所產生 
// 請參閱 https://eclipse-ee4j.github.io/jaxb-ri 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2025.10.20 於 05:05:05 PM CST 
//


package un.unece.uncefact.codelist.standard.unece.costmanagementcode.d08a;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the un.unece.uncefact.codelist.standard.unece.costmanagementcode.d08a package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private static final QName _CostManagementCode_QNAME = new QName("urn:un:unece:uncefact:codelist:standard:UNECE:CostManagementCode:D08A", "CostManagementCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: un.unece.uncefact.codelist.standard.unece.costmanagementcode.d08a
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CostManagementCodeContentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CostManagementCodeContentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:codelist:standard:UNECE:CostManagementCode:D08A", name = "CostManagementCode")
    public JAXBElement<CostManagementCodeContentType> createCostManagementCode(CostManagementCodeContentType value) {
        return new JAXBElement<CostManagementCodeContentType>(_CostManagementCode_QNAME, CostManagementCodeContentType.class, null, value);
    }

}
