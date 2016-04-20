
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
 *       &lt;group ref="{http://tietovaranto.csc.fi/luku}PerusRequest"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "kutsuja",
    "hakuehdot"
})
@XmlRootElement(name = "TutkinnotRequest", namespace = "http://tietovaranto.csc.fi/luku")
public class TutkinnotRequest {

    @XmlElement(name = "Kutsuja", namespace = "http://tietovaranto.csc.fi/luku", required = true)
    protected Kutsuja kutsuja;
    @XmlElement(name = "Hakuehdot", namespace = "http://tietovaranto.csc.fi/luku", required = true)
    protected HakuEhdotOrganisaatioVapaa hakuehdot;

    /**
     * Gets the value of the kutsuja property.
     * 
     * @return
     *     possible object is
     *     {@link Kutsuja }
     *     
     */
    public Kutsuja getKutsuja() {
        return kutsuja;
    }

    /**
     * Sets the value of the kutsuja property.
     * 
     * @param value
     *     allowed object is
     *     {@link Kutsuja }
     *     
     */
    public void setKutsuja(Kutsuja value) {
        this.kutsuja = value;
    }

    /**
     * Gets the value of the hakuehdot property.
     * 
     * @return
     *     possible object is
     *     {@link HakuEhdotOrganisaatioVapaa }
     *     
     */
    public HakuEhdotOrganisaatioVapaa getHakuehdot() {
        return hakuehdot;
    }

    /**
     * Sets the value of the hakuehdot property.
     * 
     * @param value
     *     allowed object is
     *     {@link HakuEhdotOrganisaatioVapaa }
     *     
     */
    public void setHakuehdot(HakuEhdotOrganisaatioVapaa value) {
        this.hakuehdot = value;
    }

}
