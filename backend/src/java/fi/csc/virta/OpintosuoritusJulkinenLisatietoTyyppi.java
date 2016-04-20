
package fi.csc.virta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for OpintosuoritusJulkinenLisatietoTyyppi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OpintosuoritusJulkinenLisatietoTyyppi">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;urn:mace:funet.fi:virta/2015/09/01>OpintosuoritusJulkinenLisatietoTekstiTyyppi">
 *       &lt;attribute name="kieli" type="{urn:mace:funet.fi:virta/2015/09/01}KieliKoodiTyyppi" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpintosuoritusJulkinenLisatietoTyyppi", propOrder = {
    "value"
})
public class OpintosuoritusJulkinenLisatietoTyyppi {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "kieli")
    protected String kieli;

    /**
     * Gets the value of the value property.
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
     * Sets the value of the value property.
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
     * Gets the value of the kieli property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKieli() {
        return kieli;
    }

    /**
     * Sets the value of the kieli property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKieli(String value) {
        this.kieli = value;
    }

}
