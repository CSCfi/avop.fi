
package fi.csc.virta;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KoulutusalaVersioKoodiTyyppi.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="KoulutusalaVersioKoodiTyyppi">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;maxLength value="20"/>
 *     &lt;enumeration value="opmala"/>
 *     &lt;enumeration value="opm95opa"/>
 *     &lt;enumeration value="ohjausala"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "KoulutusalaVersioKoodiTyyppi")
@XmlEnum
public enum KoulutusalaVersioKoodiTyyppi {

    @XmlEnumValue("opmala")
    OPMALA("opmala"),
    @XmlEnumValue("opm95opa")
    OPM_95_OPA("opm95opa"),
    @XmlEnumValue("ohjausala")
    OHJAUSALA("ohjausala");
    private final String value;

    KoulutusalaVersioKoodiTyyppi(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static KoulutusalaVersioKoodiTyyppi fromValue(String v) {
        for (KoulutusalaVersioKoodiTyyppi c: KoulutusalaVersioKoodiTyyppi.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
