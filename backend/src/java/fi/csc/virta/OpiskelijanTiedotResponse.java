
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
 *         &lt;element ref="{urn:mace:funet.fi:virta/2015/09/01}Opiskelijat"/>
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
    "opiskelijat"
})
@XmlRootElement(name = "OpiskelijanTiedotResponse", namespace = "http://tietovaranto.csc.fi/luku")
public class OpiskelijanTiedotResponse {

    @XmlElement(name = "Opiskelijat", required = true)
    protected OpiskelijatTyyppi opiskelijat;

    /**
     * Gets the value of the opiskelijat property.
     * 
     * @return
     *     possible object is
     *     {@link OpiskelijatTyyppi }
     *     
     */
    public OpiskelijatTyyppi getOpiskelijat() {
        return opiskelijat;
    }

    /**
     * Sets the value of the opiskelijat property.
     * 
     * @param value
     *     allowed object is
     *     {@link OpiskelijatTyyppi }
     *     
     */
    public void setOpiskelijat(OpiskelijatTyyppi value) {
        this.opiskelijat = value;
    }

}
