//
// 此檔案是由 Eclipse Implementation of JAXB, v2.3.8 所產生 
// 請參閱 https://eclipse-ee4j.github.io/jaxb-ri 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2025.10.20 於 05:05:05 PM CST 
//


package un.unece.uncefact.codelist.standard.unece.scheduletasktype.d08a;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ScheduleTaskTypeContentType 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * <pre>
 * &lt;simpleType name="ScheduleTaskTypeContentType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="AC"/&gt;
 *     &lt;enumeration value="FA"/&gt;
 *     &lt;enumeration value="MS"/&gt;
 *     &lt;enumeration value="SA"/&gt;
 *     &lt;enumeration value="SUM"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ScheduleTaskTypeContentType", namespace = "urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskType:D08A")
@XmlEnum
public enum ScheduleTaskTypeContentType {


    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69675="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Activity&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69675="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;An activity is a single atomic unit of work to be accomplished.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    AC,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69675="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Finish activity&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69675="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Last task in a networked schedule.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    FA,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69675="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Milestone&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69675="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;A milestone is a specific goal to be accomplished within a project.  Milestones typically have zero duration.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    MS,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69675="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Start activity&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69675="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;First task in a networked schedule.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    SA,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Name xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69675="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Summary&lt;/ccts:Name&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Description xmlns:ccts="urn:un:unece:uncefact:documentation:standard:CoreComponentsTechnicalSpecification:2" xmlns:clm69675="urn:un:unece:uncefact:codelist:standard:UNECE:ScheduleTaskType:D08A" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;A summary task summarizes detailed activities.  It is also known as a hammock activity.&lt;/ccts:Description&gt;
     * </pre>
     * 
     * 
     */
    SUM;

    public String value() {
        return name();
    }

    public static ScheduleTaskTypeContentType fromValue(String v) {
        return valueOf(v);
    }

}
