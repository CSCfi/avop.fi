
package fi.csc.virta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:mace:funet.fi:virta/2015/09/01}Virta"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "virta"
})
@XmlRootElement(name = "OpiskelijanKaikkiTiedotResponse", namespace = "http://tietovaranto.csc.fi/luku")
public class OpiskelijanKaikkiTiedotResponse {

    @XmlElement(name = "Virta", required = true)
    protected Virta virta;

    /**
     * Gets the value of the virta property.
     * 
     * @return
     *     possible object is
     *     {@link Virta }
     *     
     */
    public Virta getVirta() {
        return virta;
    }

    /**
     * Sets the value of the virta property.
     * 
     * @param value
     *     allowed object is
     *     {@link Virta }
     *     
     */
    public void setVirta(Virta value) {
        this.virta = value;
    }

}
