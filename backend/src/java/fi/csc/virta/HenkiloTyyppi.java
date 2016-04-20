
package fi.csc.virta;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 			Person
 * 			* Information of a single person
 * 		
 * 
 * <p>Java class for HenkiloTyyppi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HenkiloTyyppi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Henkilotunnus" type="{urn:mace:funet.fi:virta/2015/09/01}HenkilotunnusTyyppi" minOccurs="0"/>
 *         &lt;element name="Sukunimi" type="{urn:mace:funet.fi:virta/2015/09/01}SukunimiTyyppi" minOccurs="0"/>
 *         &lt;element name="Etunimet" type="{urn:mace:funet.fi:virta/2015/09/01}EtunimetTyyppi" minOccurs="0"/>
 *         &lt;element name="Sukupuoli" type="{urn:mace:funet.fi:virta/2015/09/01}SukupuoliKoodiTyyppi" minOccurs="0"/>
 *         &lt;element name="Kansalaisuus" type="{urn:mace:funet.fi:virta/2015/09/01}MaatunnusKoodiTyyppi" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Aidinkieli" type="{urn:mace:funet.fi:virta/2015/09/01}KieliKoodiTyyppi" minOccurs="0"/>
 *         &lt;element name="Asuinkunta" type="{urn:mace:funet.fi:virta/2015/09/01}KuntaKoodiTyyppi" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HenkiloTyyppi", propOrder = {
    "henkilotunnus",
    "sukunimi",
    "etunimet",
    "sukupuoli",
    "kansalaisuus",
    "aidinkieli",
    "asuinkunta"
})
@XmlSeeAlso({
    OpiskelijaTyyppi.class
})
public class HenkiloTyyppi {

    @XmlElement(name = "Henkilotunnus")
    protected String henkilotunnus;
    @XmlElement(name = "Sukunimi")
    protected String sukunimi;
    @XmlElement(name = "Etunimet")
    protected String etunimet;
    @XmlElement(name = "Sukupuoli")
    protected String sukupuoli;
    @XmlElement(name = "Kansalaisuus")
    protected List<String> kansalaisuus;
    @XmlElement(name = "Aidinkieli")
    protected String aidinkieli;
    @XmlElement(name = "Asuinkunta")
    protected String asuinkunta;

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
     * Gets the value of the sukunimi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSukunimi() {
        return sukunimi;
    }

    /**
     * Sets the value of the sukunimi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSukunimi(String value) {
        this.sukunimi = value;
    }

    /**
     * Gets the value of the etunimet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtunimet() {
        return etunimet;
    }

    /**
     * Sets the value of the etunimet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtunimet(String value) {
        this.etunimet = value;
    }

    /**
     * Gets the value of the sukupuoli property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSukupuoli() {
        return sukupuoli;
    }

    /**
     * Sets the value of the sukupuoli property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSukupuoli(String value) {
        this.sukupuoli = value;
    }

    /**
     * Gets the value of the kansalaisuus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the kansalaisuus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKansalaisuus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getKansalaisuus() {
        if (kansalaisuus == null) {
            kansalaisuus = new ArrayList<String>();
        }
        return this.kansalaisuus;
    }

    /**
     * Gets the value of the aidinkieli property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAidinkieli() {
        return aidinkieli;
    }

    /**
     * Sets the value of the aidinkieli property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAidinkieli(String value) {
        this.aidinkieli = value;
    }

    /**
     * Gets the value of the asuinkunta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsuinkunta() {
        return asuinkunta;
    }

    /**
     * Sets the value of the asuinkunta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsuinkunta(String value) {
        this.asuinkunta = value;
    }

}
