
package fi.csc.virta;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 			Koulutusalat yhdistettynä, versio-attribuutilla ja osuus-tiedolla.
 * 		
 * 
 * <p>Java class for KoulutusalaVersioOsuusTyyppi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KoulutusalaVersioOsuusTyyppi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Koodi" type="{urn:mace:funet.fi:virta/2015/09/01}KoulutusalaVersioTyyppi"/>
 *         &lt;element name="Osuus" type="{urn:mace:funet.fi:virta/2015/09/01}OsuusTyyppi" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KoulutusalaVersioOsuusTyyppi", propOrder = {
    "koodi",
    "osuus"
})
public class KoulutusalaVersioOsuusTyyppi {

    @XmlElement(name = "Koodi", required = true)
    protected KoulutusalaVersioTyyppi koodi;
    @XmlElement(name = "Osuus")
    protected BigDecimal osuus;

    /**
     * Gets the value of the koodi property.
     * 
     * @return
     *     possible object is
     *     {@link KoulutusalaVersioTyyppi }
     *     
     */
    public KoulutusalaVersioTyyppi getKoodi() {
        return koodi;
    }

    /**
     * Sets the value of the koodi property.
     * 
     * @param value
     *     allowed object is
     *     {@link KoulutusalaVersioTyyppi }
     *     
     */
    public void setKoodi(KoulutusalaVersioTyyppi value) {
        this.koodi = value;
    }

    /**
     * Gets the value of the osuus property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOsuus() {
        return osuus;
    }

    /**
     * Sets the value of the osuus property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOsuus(BigDecimal value) {
        this.osuus = value;
    }

}
