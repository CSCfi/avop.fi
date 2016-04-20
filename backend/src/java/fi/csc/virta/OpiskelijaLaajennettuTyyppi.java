
package fi.csc.virta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OpiskelijaLaajennettuTyyppi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OpiskelijaLaajennettuTyyppi">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:mace:funet.fi:virta/2015/09/01}OpiskelijaTyyppi">
 *       &lt;sequence>
 *         &lt;element name="Opiskeluoikeudet" type="{urn:mace:funet.fi:virta/2015/09/01}OpiskeluoikeudetTyyppi" minOccurs="0"/>
 *         &lt;element name="LukukausiIlmoittautumiset" type="{urn:mace:funet.fi:virta/2015/09/01}LukukausiIlmoittautumisetTyyppi" minOccurs="0"/>
 *         &lt;element name="Opintosuoritukset" type="{urn:mace:funet.fi:virta/2015/09/01}OpintosuorituksetTyyppi" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpiskelijaLaajennettuTyyppi", propOrder = {
    "opiskeluoikeudet",
    "lukukausiIlmoittautumiset",
    "opintosuoritukset"
})
public class OpiskelijaLaajennettuTyyppi
    extends OpiskelijaTyyppi
{

    @XmlElement(name = "Opiskeluoikeudet")
    protected OpiskeluoikeudetTyyppi opiskeluoikeudet;
    @XmlElement(name = "LukukausiIlmoittautumiset")
    protected LukukausiIlmoittautumisetTyyppi lukukausiIlmoittautumiset;
    @XmlElement(name = "Opintosuoritukset")
    protected OpintosuorituksetTyyppi opintosuoritukset;

    /**
     * Gets the value of the opiskeluoikeudet property.
     * 
     * @return
     *     possible object is
     *     {@link OpiskeluoikeudetTyyppi }
     *     
     */
    public OpiskeluoikeudetTyyppi getOpiskeluoikeudet() {
        return opiskeluoikeudet;
    }

    /**
     * Sets the value of the opiskeluoikeudet property.
     * 
     * @param value
     *     allowed object is
     *     {@link OpiskeluoikeudetTyyppi }
     *     
     */
    public void setOpiskeluoikeudet(OpiskeluoikeudetTyyppi value) {
        this.opiskeluoikeudet = value;
    }

    /**
     * Gets the value of the lukukausiIlmoittautumiset property.
     * 
     * @return
     *     possible object is
     *     {@link LukukausiIlmoittautumisetTyyppi }
     *     
     */
    public LukukausiIlmoittautumisetTyyppi getLukukausiIlmoittautumiset() {
        return lukukausiIlmoittautumiset;
    }

    /**
     * Sets the value of the lukukausiIlmoittautumiset property.
     * 
     * @param value
     *     allowed object is
     *     {@link LukukausiIlmoittautumisetTyyppi }
     *     
     */
    public void setLukukausiIlmoittautumiset(LukukausiIlmoittautumisetTyyppi value) {
        this.lukukausiIlmoittautumiset = value;
    }

    /**
     * Gets the value of the opintosuoritukset property.
     * 
     * @return
     *     possible object is
     *     {@link OpintosuorituksetTyyppi }
     *     
     */
    public OpintosuorituksetTyyppi getOpintosuoritukset() {
        return opintosuoritukset;
    }

    /**
     * Sets the value of the opintosuoritukset property.
     * 
     * @param value
     *     allowed object is
     *     {@link OpintosuorituksetTyyppi }
     *     
     */
    public void setOpintosuoritukset(OpintosuorituksetTyyppi value) {
        this.opintosuoritukset = value;
    }

}
