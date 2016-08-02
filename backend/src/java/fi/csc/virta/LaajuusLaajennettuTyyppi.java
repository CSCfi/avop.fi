
package fi.csc.virta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * 
 * 			The scope of a degree or a study module as ECTS credit.
 * 			Additionally the scope may be given as course unit.
 * 		
 * 
 * <p>Java class for LaajuusLaajennettuTyyppi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LaajuusLaajennettuTyyppi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Opintopiste" type="{urn:mace:funet.fi:virta/2015/09/01}LaajuusTyyppi"/>
 *         &lt;element name="Opintoviikko" type="{urn:mace:funet.fi:virta/2015/09/01}LaajuusTyyppi" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LaajuusLaajennettuTyyppi", propOrder = {
    "opintopiste",
    "opintoviikko"
})
public class LaajuusLaajennettuTyyppi {

    @XmlElement(name = "Opintopiste", required = true)
    protected BigDecimal opintopiste;
    @XmlElement(name = "Opintoviikko")
    protected BigDecimal opintoviikko;

    /**
     * Gets the value of the opintopiste property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOpintopiste() {
        return opintopiste;
    }

    /**
     * Sets the value of the opintopiste property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOpintopiste(BigDecimal value) {
        this.opintopiste = value;
    }

    /**
     * Gets the value of the opintoviikko property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOpintoviikko() {
        return opintoviikko;
    }

    /**
     * Sets the value of the opintoviikko property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOpintoviikko(BigDecimal value) {
        this.opintoviikko = value;
    }

}
