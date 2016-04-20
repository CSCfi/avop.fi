
package fi.csc.virta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HakuEhdot complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HakuEhdot">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="henkilotunnus" type="{urn:mace:funet.fi:virta/2015/09/01}HenkilotunnusTyyppi"/>
 *         &lt;element name="kansallinenOppijanumero" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HakuEhdot", namespace = "http://tietovaranto.csc.fi/luku", propOrder = {
    "henkilotunnus",
    "kansallinenOppijanumero"
})
@XmlSeeAlso({
    HakuEhdotOrganisaatioVapaa.class,
    fi.csc.virta.OpiskelijanTiedotRequest.Hakuehdot.class
})
public class HakuEhdot {

    protected String henkilotunnus;
    protected String kansallinenOppijanumero;

    /**
     * Gets the value of the henkilotunnus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHenkilotunnus() {
        return henkilotunnus;
    }

    /**
     * Sets the value of the henkilotunnus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHenkilotunnus(String value) {
        this.henkilotunnus = value;
    }

    /**
     * Gets the value of the kansallinenOppijanumero property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKansallinenOppijanumero() {
        return kansallinenOppijanumero;
    }

    /**
     * Sets the value of the kansallinenOppijanumero property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKansallinenOppijanumero(String value) {
        this.kansallinenOppijanumero = value;
    }

}
