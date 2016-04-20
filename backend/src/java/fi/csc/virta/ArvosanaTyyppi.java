
package fi.csc.virta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 			Opintosuorituksen arvosana. Arvosana ja arvosana-asteikko.
 * 		
 * 
 * <p>Java class for ArvosanaTyyppi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArvosanaTyyppi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Viisiportainen" type="{urn:mace:funet.fi:virta/2015/09/01}ArvosanaViisiportainenKoodiTyyppi"/>
 *         &lt;element name="ToinenKotimainen" type="{urn:mace:funet.fi:virta/2015/09/01}ArvosanaToinenKotimainenKoodiTyyppi"/>
 *         &lt;element name="Hyvaksytty" type="{urn:mace:funet.fi:virta/2015/09/01}ArvosanaHyvaksyttyKoodiTyyppi"/>
 *         &lt;element name="Naytetyo" type="{urn:mace:funet.fi:virta/2015/09/01}ArvosanaNaytetyoKoodiTyyppi"/>
 *         &lt;element name="Tutkielma" type="{urn:mace:funet.fi:virta/2015/09/01}ArvosanaTutkielmaKoodiTyyppi"/>
 *         &lt;element name="EiKaytossa" type="{urn:mace:funet.fi:virta/2015/09/01}ArvosanaEiKaytossaKoodiTyyppi"/>
 *         &lt;element name="Muu" type="{urn:mace:funet.fi:virta/2015/09/01}ArvosanaAsteikkoMuuTyyppi"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArvosanaTyyppi", propOrder = {
    "viisiportainen",
    "toinenKotimainen",
    "hyvaksytty",
    "naytetyo",
    "tutkielma",
    "eiKaytossa",
    "muu"
})
public class ArvosanaTyyppi {

    @XmlElement(name = "Viisiportainen")
    protected String viisiportainen;
    @XmlElement(name = "ToinenKotimainen")
    @XmlSchemaType(name = "string")
    protected ArvosanaToinenKotimainenKoodiTyyppi toinenKotimainen;
    @XmlElement(name = "Hyvaksytty")
    @XmlSchemaType(name = "string")
    protected ArvosanaHyvaksyttyKoodiTyyppi hyvaksytty;
    @XmlElement(name = "Naytetyo")
    @XmlSchemaType(name = "string")
    protected ArvosanaNaytetyoKoodiTyyppi naytetyo;
    @XmlElement(name = "Tutkielma")
    @XmlSchemaType(name = "string")
    protected ArvosanaTutkielmaKoodiTyyppi tutkielma;
    @XmlElement(name = "EiKaytossa")
    @XmlSchemaType(name = "string")
    protected ArvosanaEiKaytossaKoodiTyyppi eiKaytossa;
    @XmlElement(name = "Muu")
    protected ArvosanaAsteikkoMuuTyyppi muu;

    /**
     * Gets the value of the viisiportainen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getViisiportainen() {
        return viisiportainen;
    }

    /**
     * Sets the value of the viisiportainen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setViisiportainen(String value) {
        this.viisiportainen = value;
    }

    /**
     * Gets the value of the toinenKotimainen property.
     * 
     * @return
     *     possible object is
     *     {@link ArvosanaToinenKotimainenKoodiTyyppi }
     *     
     */
    public ArvosanaToinenKotimainenKoodiTyyppi getToinenKotimainen() {
        return toinenKotimainen;
    }

    /**
     * Sets the value of the toinenKotimainen property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArvosanaToinenKotimainenKoodiTyyppi }
     *     
     */
    public void setToinenKotimainen(ArvosanaToinenKotimainenKoodiTyyppi value) {
        this.toinenKotimainen = value;
    }

    /**
     * Gets the value of the hyvaksytty property.
     * 
     * @return
     *     possible object is
     *     {@link ArvosanaHyvaksyttyKoodiTyyppi }
     *     
     */
    public ArvosanaHyvaksyttyKoodiTyyppi getHyvaksytty() {
        return hyvaksytty;
    }

    /**
     * Sets the value of the hyvaksytty property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArvosanaHyvaksyttyKoodiTyyppi }
     *     
     */
    public void setHyvaksytty(ArvosanaHyvaksyttyKoodiTyyppi value) {
        this.hyvaksytty = value;
    }

    /**
     * Gets the value of the naytetyo property.
     * 
     * @return
     *     possible object is
     *     {@link ArvosanaNaytetyoKoodiTyyppi }
     *     
     */
    public ArvosanaNaytetyoKoodiTyyppi getNaytetyo() {
        return naytetyo;
    }

    /**
     * Sets the value of the naytetyo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArvosanaNaytetyoKoodiTyyppi }
     *     
     */
    public void setNaytetyo(ArvosanaNaytetyoKoodiTyyppi value) {
        this.naytetyo = value;
    }

    /**
     * Gets the value of the tutkielma property.
     * 
     * @return
     *     possible object is
     *     {@link ArvosanaTutkielmaKoodiTyyppi }
     *     
     */
    public ArvosanaTutkielmaKoodiTyyppi getTutkielma() {
        return tutkielma;
    }

    /**
     * Sets the value of the tutkielma property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArvosanaTutkielmaKoodiTyyppi }
     *     
     */
    public void setTutkielma(ArvosanaTutkielmaKoodiTyyppi value) {
        this.tutkielma = value;
    }

    /**
     * Gets the value of the eiKaytossa property.
     * 
     * @return
     *     possible object is
     *     {@link ArvosanaEiKaytossaKoodiTyyppi }
     *     
     */
    public ArvosanaEiKaytossaKoodiTyyppi getEiKaytossa() {
        return eiKaytossa;
    }

    /**
     * Sets the value of the eiKaytossa property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArvosanaEiKaytossaKoodiTyyppi }
     *     
     */
    public void setEiKaytossa(ArvosanaEiKaytossaKoodiTyyppi value) {
        this.eiKaytossa = value;
    }

    /**
     * Gets the value of the muu property.
     * 
     * @return
     *     possible object is
     *     {@link ArvosanaAsteikkoMuuTyyppi }
     *     
     */
    public ArvosanaAsteikkoMuuTyyppi getMuu() {
        return muu;
    }

    /**
     * Sets the value of the muu property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArvosanaAsteikkoMuuTyyppi }
     *     
     */
    public void setMuu(ArvosanaAsteikkoMuuTyyppi value) {
        this.muu = value;
    }

}
