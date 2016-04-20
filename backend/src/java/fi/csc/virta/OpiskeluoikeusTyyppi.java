
package fi.csc.virta;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 			StudyRight
 * 			* Single study right
 * 		
 * 
 * <p>Java class for OpiskeluoikeusTyyppi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OpiskeluoikeusTyyppi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlkuPvm" type="{urn:mace:funet.fi:virta/2015/09/01}PvmTyyppi"/>
 *         &lt;element name="LoppuPvm" type="{urn:mace:funet.fi:virta/2015/09/01}PvmTyyppi" minOccurs="0"/>
 *         &lt;element name="Tila" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{urn:mace:funet.fi:virta/2015/09/01}AikajaksoTyyppi">
 *                 &lt;sequence>
 *                   &lt;element name="Koodi" type="{urn:mace:funet.fi:virta/2015/09/01}OpiskeluoikeusTilaKoodiTyyppi"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Tyyppi" type="{urn:mace:funet.fi:virta/2015/09/01}OpiskeluoikeusTyyppiKoodiTyyppi"/>
 *         &lt;element name="Myontaja" type="{urn:mace:funet.fi:virta/2015/09/01}OrganisaatioKoodiTyyppi"/>
 *         &lt;element name="Organisaatio" type="{urn:mace:funet.fi:virta/2015/09/01}OrganisaatioRooliOsuusTyyppi" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Jakso" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{urn:mace:funet.fi:virta/2015/09/01}AikajaksoTyyppi">
 *                 &lt;sequence>
 *                   &lt;element name="Koulutuskoodi" type="{urn:mace:funet.fi:virta/2015/09/01}KoulutuskoodiKoodiTyyppi" minOccurs="0"/>
 *                   &lt;element name="Koulutuskunta" type="{urn:mace:funet.fi:virta/2015/09/01}KuntaKoodiTyyppi"/>
 *                   &lt;element name="Koulutuskieli" type="{urn:mace:funet.fi:virta/2015/09/01}KieliKoodiTyyppi" minOccurs="0"/>
 *                   &lt;element name="Rahoituslahde" type="{urn:mace:funet.fi:virta/2015/09/01}RahoituslahdeKoodiTyyppi" minOccurs="0"/>
 *                   &lt;element name="Patevyys" type="{urn:mace:funet.fi:virta/2015/09/01}PatevyysKoodiTyyppi" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="Luokittelu" type="{urn:mace:funet.fi:virta/2015/09/01}OpiskeluoikeusLuokitteluKoodiTyyppi" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="koulutusmoduulitunniste" use="required" type="{urn:mace:funet.fi:virta/2015/09/01}KoulutusmoduulitunnisteTyyppi" />
 *                 &lt;attribute name="valtakunnallinenKoulutusmoduulitunniste" type="{urn:mace:funet.fi:virta/2015/09/01}ValtakunnallinenKoulutusmoduulitunnisteTyyppi" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Ensisijaisuus" type="{urn:mace:funet.fi:virta/2015/09/01}AikajaksoTyyppi" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Koulutusala" type="{urn:mace:funet.fi:virta/2015/09/01}KoulutusalaVersioTyyppi" minOccurs="0"/>
 *         &lt;element name="Erikoistumiskoulutus" type="{urn:mace:funet.fi:virta/2015/09/01}ErikoistumiskoulutusKoodiTyyppi" minOccurs="0"/>
 *         &lt;element name="Liittyvyys" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="liittyvaOpiskeluoikeusAvain" use="required" type="{urn:mace:funet.fi:virta/2015/09/01}AvainTyyppi" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SiirtoOpiskelija" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SiirtoPvm" type="{urn:mace:funet.fi:virta/2015/09/01}PvmTyyppi"/>
 *                   &lt;element name="Lukukausikertyma" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="IlmoittautuminenTila" type="{urn:mace:funet.fi:virta/2015/09/01}LukukausiIlmoittautuminenTilaKoodiTyyppi"/>
 *                             &lt;element name="Maara" type="{urn:mace:funet.fi:virta/2015/09/01}LukukausiMaaraTyyppi"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="lahdeOpiskeluoikeusAvain" type="{urn:mace:funet.fi:virta/2015/09/01}AvainTyyppi" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Laajuus" type="{urn:mace:funet.fi:virta/2015/09/01}LaajuusLaajennettuTyyppi" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="avain" use="required" type="{urn:mace:funet.fi:virta/2015/09/01}AvainTyyppi" />
 *       &lt;attribute name="opiskelijaAvain" use="required" type="{urn:mace:funet.fi:virta/2015/09/01}AvainTyyppi" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpiskeluoikeusTyyppi", propOrder = {
    "alkuPvm",
    "loppuPvm",
    "tila",
    "tyyppi",
    "myontaja",
    "organisaatio",
    "jakso",
    "ensisijaisuus",
    "koulutusala",
    "erikoistumiskoulutus",
    "liittyvyys",
    "siirtoOpiskelija",
    "laajuus"
})
public class OpiskeluoikeusTyyppi {

    @XmlElement(name = "AlkuPvm", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar alkuPvm;
    @XmlElement(name = "LoppuPvm")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar loppuPvm;
    @XmlElement(name = "Tila", required = true)
    protected List<OpiskeluoikeusTyyppi.Tila> tila;
    @XmlElement(name = "Tyyppi", required = true)
    protected String tyyppi;
    @XmlElement(name = "Myontaja", required = true)
    protected String myontaja;
    @XmlElement(name = "Organisaatio")
    protected List<OrganisaatioRooliOsuusTyyppi> organisaatio;
    @XmlElement(name = "Jakso")
    protected List<OpiskeluoikeusTyyppi.Jakso> jakso;
    @XmlElement(name = "Ensisijaisuus")
    protected List<AikajaksoTyyppi> ensisijaisuus;
    @XmlElement(name = "Koulutusala")
    protected KoulutusalaVersioTyyppi koulutusala;
    @XmlElement(name = "Erikoistumiskoulutus")
    protected String erikoistumiskoulutus;
    @XmlElement(name = "Liittyvyys")
    protected List<OpiskeluoikeusTyyppi.Liittyvyys> liittyvyys;
    @XmlElement(name = "SiirtoOpiskelija")
    protected OpiskeluoikeusTyyppi.SiirtoOpiskelija siirtoOpiskelija;
    @XmlElement(name = "Laajuus")
    protected LaajuusLaajennettuTyyppi laajuus;
    @XmlAttribute(name = "avain", required = true)
    protected String avain;
    @XmlAttribute(name = "opiskelijaAvain", required = true)
    protected String opiskelijaAvain;

    /**
     * Gets the value of the alkuPvm property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAlkuPvm() {
        return alkuPvm;
    }

    /**
     * Sets the value of the alkuPvm property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAlkuPvm(XMLGregorianCalendar value) {
        this.alkuPvm = value;
    }

    /**
     * Gets the value of the loppuPvm property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLoppuPvm() {
        return loppuPvm;
    }

    /**
     * Sets the value of the loppuPvm property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLoppuPvm(XMLGregorianCalendar value) {
        this.loppuPvm = value;
    }

    /**
     * Gets the value of the tila property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tila property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTila().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OpiskeluoikeusTyyppi.Tila }
     * 
     * 
     */
    public List<OpiskeluoikeusTyyppi.Tila> getTila() {
        if (tila == null) {
            tila = new ArrayList<OpiskeluoikeusTyyppi.Tila>();
        }
        return this.tila;
    }

    /**
     * Gets the value of the tyyppi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTyyppi() {
        return tyyppi;
    }

    /**
     * Sets the value of the tyyppi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTyyppi(String value) {
        this.tyyppi = value;
    }

    /**
     * Gets the value of the myontaja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMyontaja() {
        return myontaja;
    }

    /**
     * Sets the value of the myontaja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMyontaja(String value) {
        this.myontaja = value;
    }

    /**
     * Gets the value of the organisaatio property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the organisaatio property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrganisaatio().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrganisaatioRooliOsuusTyyppi }
     * 
     * 
     */
    public List<OrganisaatioRooliOsuusTyyppi> getOrganisaatio() {
        if (organisaatio == null) {
            organisaatio = new ArrayList<OrganisaatioRooliOsuusTyyppi>();
        }
        return this.organisaatio;
    }

    /**
     * Gets the value of the jakso property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jakso property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJakso().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OpiskeluoikeusTyyppi.Jakso }
     * 
     * 
     */
    public List<OpiskeluoikeusTyyppi.Jakso> getJakso() {
        if (jakso == null) {
            jakso = new ArrayList<OpiskeluoikeusTyyppi.Jakso>();
        }
        return this.jakso;
    }

    /**
     * Gets the value of the ensisijaisuus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ensisijaisuus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnsisijaisuus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AikajaksoTyyppi }
     * 
     * 
     */
    public List<AikajaksoTyyppi> getEnsisijaisuus() {
        if (ensisijaisuus == null) {
            ensisijaisuus = new ArrayList<AikajaksoTyyppi>();
        }
        return this.ensisijaisuus;
    }

    /**
     * Gets the value of the koulutusala property.
     * 
     * @return
     *     possible object is
     *     {@link KoulutusalaVersioTyyppi }
     *     
     */
    public KoulutusalaVersioTyyppi getKoulutusala() {
        return koulutusala;
    }

    /**
     * Sets the value of the koulutusala property.
     * 
     * @param value
     *     allowed object is
     *     {@link KoulutusalaVersioTyyppi }
     *     
     */
    public void setKoulutusala(KoulutusalaVersioTyyppi value) {
        this.koulutusala = value;
    }

    /**
     * Gets the value of the erikoistumiskoulutus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErikoistumiskoulutus() {
        return erikoistumiskoulutus;
    }

    /**
     * Sets the value of the erikoistumiskoulutus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErikoistumiskoulutus(String value) {
        this.erikoistumiskoulutus = value;
    }

    /**
     * Gets the value of the liittyvyys property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the liittyvyys property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLiittyvyys().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OpiskeluoikeusTyyppi.Liittyvyys }
     * 
     * 
     */
    public List<OpiskeluoikeusTyyppi.Liittyvyys> getLiittyvyys() {
        if (liittyvyys == null) {
            liittyvyys = new ArrayList<OpiskeluoikeusTyyppi.Liittyvyys>();
        }
        return this.liittyvyys;
    }

    /**
     * Gets the value of the siirtoOpiskelija property.
     * 
     * @return
     *     possible object is
     *     {@link OpiskeluoikeusTyyppi.SiirtoOpiskelija }
     *     
     */
    public OpiskeluoikeusTyyppi.SiirtoOpiskelija getSiirtoOpiskelija() {
        return siirtoOpiskelija;
    }

    /**
     * Sets the value of the siirtoOpiskelija property.
     * 
     * @param value
     *     allowed object is
     *     {@link OpiskeluoikeusTyyppi.SiirtoOpiskelija }
     *     
     */
    public void setSiirtoOpiskelija(OpiskeluoikeusTyyppi.SiirtoOpiskelija value) {
        this.siirtoOpiskelija = value;
    }

    /**
     * Gets the value of the laajuus property.
     * 
     * @return
     *     possible object is
     *     {@link LaajuusLaajennettuTyyppi }
     *     
     */
    public LaajuusLaajennettuTyyppi getLaajuus() {
        return laajuus;
    }

    /**
     * Sets the value of the laajuus property.
     * 
     * @param value
     *     allowed object is
     *     {@link LaajuusLaajennettuTyyppi }
     *     
     */
    public void setLaajuus(LaajuusLaajennettuTyyppi value) {
        this.laajuus = value;
    }

    /**
     * Gets the value of the avain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvain() {
        return avain;
    }

    /**
     * Sets the value of the avain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvain(String value) {
        this.avain = value;
    }

    /**
     * Gets the value of the opiskelijaAvain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpiskelijaAvain() {
        return opiskelijaAvain;
    }

    /**
     * Sets the value of the opiskelijaAvain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpiskelijaAvain(String value) {
        this.opiskelijaAvain = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{urn:mace:funet.fi:virta/2015/09/01}AikajaksoTyyppi">
     *       &lt;sequence>
     *         &lt;element name="Koulutuskoodi" type="{urn:mace:funet.fi:virta/2015/09/01}KoulutuskoodiKoodiTyyppi" minOccurs="0"/>
     *         &lt;element name="Koulutuskunta" type="{urn:mace:funet.fi:virta/2015/09/01}KuntaKoodiTyyppi"/>
     *         &lt;element name="Koulutuskieli" type="{urn:mace:funet.fi:virta/2015/09/01}KieliKoodiTyyppi" minOccurs="0"/>
     *         &lt;element name="Rahoituslahde" type="{urn:mace:funet.fi:virta/2015/09/01}RahoituslahdeKoodiTyyppi" minOccurs="0"/>
     *         &lt;element name="Patevyys" type="{urn:mace:funet.fi:virta/2015/09/01}PatevyysKoodiTyyppi" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="Luokittelu" type="{urn:mace:funet.fi:virta/2015/09/01}OpiskeluoikeusLuokitteluKoodiTyyppi" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="koulutusmoduulitunniste" use="required" type="{urn:mace:funet.fi:virta/2015/09/01}KoulutusmoduulitunnisteTyyppi" />
     *       &lt;attribute name="valtakunnallinenKoulutusmoduulitunniste" type="{urn:mace:funet.fi:virta/2015/09/01}ValtakunnallinenKoulutusmoduulitunnisteTyyppi" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "koulutuskoodi",
        "koulutuskunta",
        "koulutuskieli",
        "rahoituslahde",
        "patevyys",
        "luokittelu"
    })
    public static class Jakso
        extends AikajaksoTyyppi
    {

        @XmlElement(name = "Koulutuskoodi")
        protected String koulutuskoodi;
        @XmlElement(name = "Koulutuskunta", required = true)
        protected String koulutuskunta;
        @XmlElement(name = "Koulutuskieli")
        protected String koulutuskieli;
        @XmlElement(name = "Rahoituslahde")
        protected String rahoituslahde;
        @XmlElement(name = "Patevyys")
        protected List<String> patevyys;
        @XmlElement(name = "Luokittelu")
        protected List<String> luokittelu;
        @XmlAttribute(name = "koulutusmoduulitunniste", required = true)
        protected String koulutusmoduulitunniste;
        @XmlAttribute(name = "valtakunnallinenKoulutusmoduulitunniste")
        protected String valtakunnallinenKoulutusmoduulitunniste;

        /**
         * Gets the value of the koulutuskoodi property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKoulutuskoodi() {
            return koulutuskoodi;
        }

        /**
         * Sets the value of the koulutuskoodi property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKoulutuskoodi(String value) {
            this.koulutuskoodi = value;
        }

        /**
         * Gets the value of the koulutuskunta property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKoulutuskunta() {
            return koulutuskunta;
        }

        /**
         * Sets the value of the koulutuskunta property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKoulutuskunta(String value) {
            this.koulutuskunta = value;
        }

        /**
         * Gets the value of the koulutuskieli property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKoulutuskieli() {
            return koulutuskieli;
        }

        /**
         * Sets the value of the koulutuskieli property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKoulutuskieli(String value) {
            this.koulutuskieli = value;
        }

        /**
         * Gets the value of the rahoituslahde property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRahoituslahde() {
            return rahoituslahde;
        }

        /**
         * Sets the value of the rahoituslahde property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRahoituslahde(String value) {
            this.rahoituslahde = value;
        }

        /**
         * Gets the value of the patevyys property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the patevyys property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPatevyys().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getPatevyys() {
            if (patevyys == null) {
                patevyys = new ArrayList<String>();
            }
            return this.patevyys;
        }

        /**
         * Gets the value of the luokittelu property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the luokittelu property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLuokittelu().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getLuokittelu() {
            if (luokittelu == null) {
                luokittelu = new ArrayList<String>();
            }
            return this.luokittelu;
        }

        /**
         * Gets the value of the koulutusmoduulitunniste property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKoulutusmoduulitunniste() {
            return koulutusmoduulitunniste;
        }

        /**
         * Sets the value of the koulutusmoduulitunniste property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKoulutusmoduulitunniste(String value) {
            this.koulutusmoduulitunniste = value;
        }

        /**
         * Gets the value of the valtakunnallinenKoulutusmoduulitunniste property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValtakunnallinenKoulutusmoduulitunniste() {
            return valtakunnallinenKoulutusmoduulitunniste;
        }

        /**
         * Sets the value of the valtakunnallinenKoulutusmoduulitunniste property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValtakunnallinenKoulutusmoduulitunniste(String value) {
            this.valtakunnallinenKoulutusmoduulitunniste = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="liittyvaOpiskeluoikeusAvain" use="required" type="{urn:mace:funet.fi:virta/2015/09/01}AvainTyyppi" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Liittyvyys {

        @XmlAttribute(name = "liittyvaOpiskeluoikeusAvain", required = true)
        protected String liittyvaOpiskeluoikeusAvain;

        /**
         * Gets the value of the liittyvaOpiskeluoikeusAvain property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLiittyvaOpiskeluoikeusAvain() {
            return liittyvaOpiskeluoikeusAvain;
        }

        /**
         * Sets the value of the liittyvaOpiskeluoikeusAvain property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLiittyvaOpiskeluoikeusAvain(String value) {
            this.liittyvaOpiskeluoikeusAvain = value;
        }

    }


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
     *         &lt;element name="SiirtoPvm" type="{urn:mace:funet.fi:virta/2015/09/01}PvmTyyppi"/>
     *         &lt;element name="Lukukausikertyma" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="IlmoittautuminenTila" type="{urn:mace:funet.fi:virta/2015/09/01}LukukausiIlmoittautuminenTilaKoodiTyyppi"/>
     *                   &lt;element name="Maara" type="{urn:mace:funet.fi:virta/2015/09/01}LukukausiMaaraTyyppi"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="lahdeOpiskeluoikeusAvain" type="{urn:mace:funet.fi:virta/2015/09/01}AvainTyyppi" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "siirtoPvm",
        "lukukausikertyma"
    })
    public static class SiirtoOpiskelija {

        @XmlElement(name = "SiirtoPvm", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar siirtoPvm;
        @XmlElement(name = "Lukukausikertyma", required = true)
        protected List<OpiskeluoikeusTyyppi.SiirtoOpiskelija.Lukukausikertyma> lukukausikertyma;
        @XmlAttribute(name = "lahdeOpiskeluoikeusAvain")
        protected String lahdeOpiskeluoikeusAvain;

        /**
         * Gets the value of the siirtoPvm property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getSiirtoPvm() {
            return siirtoPvm;
        }

        /**
         * Sets the value of the siirtoPvm property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setSiirtoPvm(XMLGregorianCalendar value) {
            this.siirtoPvm = value;
        }

        /**
         * Gets the value of the lukukausikertyma property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the lukukausikertyma property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLukukausikertyma().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OpiskeluoikeusTyyppi.SiirtoOpiskelija.Lukukausikertyma }
         * 
         * 
         */
        public List<OpiskeluoikeusTyyppi.SiirtoOpiskelija.Lukukausikertyma> getLukukausikertyma() {
            if (lukukausikertyma == null) {
                lukukausikertyma = new ArrayList<OpiskeluoikeusTyyppi.SiirtoOpiskelija.Lukukausikertyma>();
            }
            return this.lukukausikertyma;
        }

        /**
         * Gets the value of the lahdeOpiskeluoikeusAvain property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLahdeOpiskeluoikeusAvain() {
            return lahdeOpiskeluoikeusAvain;
        }

        /**
         * Sets the value of the lahdeOpiskeluoikeusAvain property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLahdeOpiskeluoikeusAvain(String value) {
            this.lahdeOpiskeluoikeusAvain = value;
        }


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
         *         &lt;element name="IlmoittautuminenTila" type="{urn:mace:funet.fi:virta/2015/09/01}LukukausiIlmoittautuminenTilaKoodiTyyppi"/>
         *         &lt;element name="Maara" type="{urn:mace:funet.fi:virta/2015/09/01}LukukausiMaaraTyyppi"/>
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
            "ilmoittautuminenTila",
            "maara"
        })
        public static class Lukukausikertyma {

            @XmlElement(name = "IlmoittautuminenTila", required = true)
            protected String ilmoittautuminenTila;
            @XmlElement(name = "Maara")
            protected short maara;

            /**
             * Gets the value of the ilmoittautuminenTila property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIlmoittautuminenTila() {
                return ilmoittautuminenTila;
            }

            /**
             * Sets the value of the ilmoittautuminenTila property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIlmoittautuminenTila(String value) {
                this.ilmoittautuminenTila = value;
            }

            /**
             * Gets the value of the maara property.
             * 
             */
            public short getMaara() {
                return maara;
            }

            /**
             * Sets the value of the maara property.
             * 
             */
            public void setMaara(short value) {
                this.maara = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{urn:mace:funet.fi:virta/2015/09/01}AikajaksoTyyppi">
     *       &lt;sequence>
     *         &lt;element name="Koodi" type="{urn:mace:funet.fi:virta/2015/09/01}OpiskeluoikeusTilaKoodiTyyppi"/>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "koodi"
    })
    public static class Tila
        extends AikajaksoTyyppi
    {

        @XmlElement(name = "Koodi", required = true)
        protected String koodi;

        /**
         * Gets the value of the koodi property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKoodi() {
            return koodi;
        }

        /**
         * Sets the value of the koodi property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKoodi(String value) {
            this.koodi = value;
        }

    }

}
