
package fi.csc.virta;

import java.math.BigDecimal;
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
 * 			Study
 * 			* Single study
 * 		
 * 
 * <p>Java class for OpintosuoritusTyyppi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OpintosuoritusTyyppi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SuoritusPvm" type="{urn:mace:funet.fi:virta/2015/09/01}PvmTyyppi"/>
 *         &lt;element name="Laajuus" type="{urn:mace:funet.fi:virta/2015/09/01}LaajuusLaajennettuTyyppi"/>
 *         &lt;element name="Arvosana" type="{urn:mace:funet.fi:virta/2015/09/01}ArvosanaTyyppi"/>
 *         &lt;element name="Myontaja" type="{urn:mace:funet.fi:virta/2015/09/01}OrganisaatioKoodiTyyppi"/>
 *         &lt;element name="Organisaatio" type="{urn:mace:funet.fi:virta/2015/09/01}OrganisaatioRooliOsuusTyyppi" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Laji" type="{urn:mace:funet.fi:virta/2015/09/01}OpintosuoritusLajiKoodiTyyppi"/>
 *         &lt;element name="Nimi" type="{urn:mace:funet.fi:virta/2015/09/01}OpintosuoritusNimiTyyppi" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Kieli" type="{urn:mace:funet.fi:virta/2015/09/01}KieliKoodiTyyppi" minOccurs="0"/>
 *         &lt;element name="Koulutuskoodi" type="{urn:mace:funet.fi:virta/2015/09/01}KoulutuskoodiKoodiTyyppi" minOccurs="0"/>
 *         &lt;element name="Koulutusala" type="{urn:mace:funet.fi:virta/2015/09/01}KoulutusalaVersioOsuusTyyppi" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Sisaltyvyys" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Opintopiste" type="{urn:mace:funet.fi:virta/2015/09/01}LaajuusTyyppi" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="sisaltyvaOpintosuoritusAvain" use="required" type="{urn:mace:funet.fi:virta/2015/09/01}AvainTyyppi" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="HyvaksilukuPvm" type="{urn:mace:funet.fi:virta/2015/09/01}PvmTyyppi" minOccurs="0"/>
 *         &lt;element name="TKILaajuus" type="{urn:mace:funet.fi:virta/2015/09/01}LaajuusLaajennettuTyyppi" minOccurs="0"/>
 *         &lt;element name="TKILaajuusHarjoittelu" type="{urn:mace:funet.fi:virta/2015/09/01}LaajuusLaajennettuTyyppi" minOccurs="0"/>
 *         &lt;element name="TKILaajuusMuu" type="{urn:mace:funet.fi:virta/2015/09/01}LaajuusLaajennettuTyyppi" minOccurs="0"/>
 *         &lt;element name="OpetusharjoitteluTyyppi" type="{urn:mace:funet.fi:virta/2015/09/01}OpetusharjoitteluTyyppiKoodiTyyppi" minOccurs="0"/>
 *         &lt;element name="Opinnaytetyo" type="{urn:mace:funet.fi:virta/2015/09/01}KyllaEiKytkinTyyppi" minOccurs="0"/>
 *         &lt;element name="Hankkeistettu" type="{urn:mace:funet.fi:virta/2015/09/01}KyllaEiKytkinTyyppi" minOccurs="0"/>
 *         &lt;element name="Patevyys" type="{urn:mace:funet.fi:virta/2015/09/01}PatevyysKoodiTyyppi" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Luokittelu" type="{urn:mace:funet.fi:virta/2015/09/01}OpintosuoritusLuokitteluKoodiTyyppi" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="JulkinenLisatieto" type="{urn:mace:funet.fi:virta/2015/09/01}OpintosuoritusJulkinenLisatietoTyyppi" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="avain" use="required" type="{urn:mace:funet.fi:virta/2015/09/01}AvainTyyppi" />
 *       &lt;attribute name="opiskelijaAvain" use="required" type="{urn:mace:funet.fi:virta/2015/09/01}AvainTyyppi" />
 *       &lt;attribute name="koulutusmoduulitunniste" use="required" type="{urn:mace:funet.fi:virta/2015/09/01}KoulutusmoduulitunnisteTyyppi" />
 *       &lt;attribute name="valtakunnallinenKoulutusmoduulitunniste" type="{urn:mace:funet.fi:virta/2015/09/01}ValtakunnallinenKoulutusmoduulitunnisteTyyppi" />
 *       &lt;attribute name="opiskeluoikeusAvain" type="{urn:mace:funet.fi:virta/2015/09/01}AvainTyyppi" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpintosuoritusTyyppi", propOrder = {
    "suoritusPvm",
    "laajuus",
    "arvosana",
    "myontaja",
    "organisaatio",
    "laji",
    "nimi",
    "kieli",
    "koulutuskoodi",
    "koulutusala",
    "sisaltyvyys",
    "hyvaksilukuPvm",
    "tkiLaajuus",
    "tkiLaajuusHarjoittelu",
    "tkiLaajuusMuu",
    "opetusharjoitteluTyyppi",
    "opinnaytetyo",
    "hankkeistettu",
    "patevyys",
    "luokittelu",
    "julkinenLisatieto"
})
public class OpintosuoritusTyyppi {

    @XmlElement(name = "SuoritusPvm", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar suoritusPvm;
    @XmlElement(name = "Laajuus", required = true)
    protected LaajuusLaajennettuTyyppi laajuus;
    @XmlElement(name = "Arvosana", required = true)
    protected ArvosanaTyyppi arvosana;
    @XmlElement(name = "Myontaja", required = true)
    protected String myontaja;
    @XmlElement(name = "Organisaatio")
    protected List<OrganisaatioRooliOsuusTyyppi> organisaatio;
    @XmlElement(name = "Laji", required = true)
    protected String laji;
    @XmlElement(name = "Nimi")
    protected List<OpintosuoritusNimiTyyppi> nimi;
    @XmlElement(name = "Kieli")
    protected String kieli;
    @XmlElement(name = "Koulutuskoodi")
    protected String koulutuskoodi;
    @XmlElement(name = "Koulutusala")
    protected List<KoulutusalaVersioOsuusTyyppi> koulutusala;
    @XmlElement(name = "Sisaltyvyys")
    protected List<OpintosuoritusTyyppi.Sisaltyvyys> sisaltyvyys;
    @XmlElement(name = "HyvaksilukuPvm")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar hyvaksilukuPvm;
    @XmlElement(name = "TKILaajuus")
    protected LaajuusLaajennettuTyyppi tkiLaajuus;
    @XmlElement(name = "TKILaajuusHarjoittelu")
    protected LaajuusLaajennettuTyyppi tkiLaajuusHarjoittelu;
    @XmlElement(name = "TKILaajuusMuu")
    protected LaajuusLaajennettuTyyppi tkiLaajuusMuu;
    @XmlElement(name = "OpetusharjoitteluTyyppi")
    protected String opetusharjoitteluTyyppi;
    @XmlElement(name = "Opinnaytetyo")
    protected Boolean opinnaytetyo;
    @XmlElement(name = "Hankkeistettu")
    protected Boolean hankkeistettu;
    @XmlElement(name = "Patevyys")
    protected List<String> patevyys;
    @XmlElement(name = "Luokittelu")
    protected List<String> luokittelu;
    @XmlElement(name = "JulkinenLisatieto")
    protected List<OpintosuoritusJulkinenLisatietoTyyppi> julkinenLisatieto;
    @XmlAttribute(name = "avain", required = true)
    protected String avain;
    @XmlAttribute(name = "opiskelijaAvain", required = true)
    protected String opiskelijaAvain;
    @XmlAttribute(name = "koulutusmoduulitunniste", required = true)
    protected String koulutusmoduulitunniste;
    @XmlAttribute(name = "valtakunnallinenKoulutusmoduulitunniste")
    protected String valtakunnallinenKoulutusmoduulitunniste;
    @XmlAttribute(name = "opiskeluoikeusAvain")
    protected String opiskeluoikeusAvain;

    /**
     * Gets the value of the suoritusPvm property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSuoritusPvm() {
        return suoritusPvm;
    }

    /**
     * Sets the value of the suoritusPvm property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSuoritusPvm(XMLGregorianCalendar value) {
        this.suoritusPvm = value;
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
     * Gets the value of the arvosana property.
     * 
     * @return
     *     possible object is
     *     {@link ArvosanaTyyppi }
     *     
     */
    public ArvosanaTyyppi getArvosana() {
        return arvosana;
    }

    /**
     * Sets the value of the arvosana property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArvosanaTyyppi }
     *     
     */
    public void setArvosana(ArvosanaTyyppi value) {
        this.arvosana = value;
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
     * Gets the value of the laji property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaji() {
        return laji;
    }

    /**
     * Sets the value of the laji property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaji(String value) {
        this.laji = value;
    }

    /**
     * Gets the value of the nimi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nimi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNimi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OpintosuoritusNimiTyyppi }
     * 
     * 
     */
    public List<OpintosuoritusNimiTyyppi> getNimi() {
        if (nimi == null) {
            nimi = new ArrayList<OpintosuoritusNimiTyyppi>();
        }
        return this.nimi;
    }

    /**
     * Gets the value of the kieli property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKieli() {
        return kieli;
    }

    /**
     * Sets the value of the kieli property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKieli(String value) {
        this.kieli = value;
    }

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
     * Gets the value of the koulutusala property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the koulutusala property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKoulutusala().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KoulutusalaVersioOsuusTyyppi }
     * 
     * 
     */
    public List<KoulutusalaVersioOsuusTyyppi> getKoulutusala() {
        if (koulutusala == null) {
            koulutusala = new ArrayList<KoulutusalaVersioOsuusTyyppi>();
        }
        return this.koulutusala;
    }

    /**
     * Gets the value of the sisaltyvyys property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sisaltyvyys property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSisaltyvyys().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OpintosuoritusTyyppi.Sisaltyvyys }
     * 
     * 
     */
    public List<OpintosuoritusTyyppi.Sisaltyvyys> getSisaltyvyys() {
        if (sisaltyvyys == null) {
            sisaltyvyys = new ArrayList<OpintosuoritusTyyppi.Sisaltyvyys>();
        }
        return this.sisaltyvyys;
    }

    /**
     * Gets the value of the hyvaksilukuPvm property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getHyvaksilukuPvm() {
        return hyvaksilukuPvm;
    }

    /**
     * Sets the value of the hyvaksilukuPvm property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setHyvaksilukuPvm(XMLGregorianCalendar value) {
        this.hyvaksilukuPvm = value;
    }

    /**
     * Gets the value of the tkiLaajuus property.
     * 
     * @return
     *     possible object is
     *     {@link LaajuusLaajennettuTyyppi }
     *     
     */
    public LaajuusLaajennettuTyyppi getTKILaajuus() {
        return tkiLaajuus;
    }

    /**
     * Sets the value of the tkiLaajuus property.
     * 
     * @param value
     *     allowed object is
     *     {@link LaajuusLaajennettuTyyppi }
     *     
     */
    public void setTKILaajuus(LaajuusLaajennettuTyyppi value) {
        this.tkiLaajuus = value;
    }

    /**
     * Gets the value of the tkiLaajuusHarjoittelu property.
     * 
     * @return
     *     possible object is
     *     {@link LaajuusLaajennettuTyyppi }
     *     
     */
    public LaajuusLaajennettuTyyppi getTKILaajuusHarjoittelu() {
        return tkiLaajuusHarjoittelu;
    }

    /**
     * Sets the value of the tkiLaajuusHarjoittelu property.
     * 
     * @param value
     *     allowed object is
     *     {@link LaajuusLaajennettuTyyppi }
     *     
     */
    public void setTKILaajuusHarjoittelu(LaajuusLaajennettuTyyppi value) {
        this.tkiLaajuusHarjoittelu = value;
    }

    /**
     * Gets the value of the tkiLaajuusMuu property.
     * 
     * @return
     *     possible object is
     *     {@link LaajuusLaajennettuTyyppi }
     *     
     */
    public LaajuusLaajennettuTyyppi getTKILaajuusMuu() {
        return tkiLaajuusMuu;
    }

    /**
     * Sets the value of the tkiLaajuusMuu property.
     * 
     * @param value
     *     allowed object is
     *     {@link LaajuusLaajennettuTyyppi }
     *     
     */
    public void setTKILaajuusMuu(LaajuusLaajennettuTyyppi value) {
        this.tkiLaajuusMuu = value;
    }

    /**
     * Gets the value of the opetusharjoitteluTyyppi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpetusharjoitteluTyyppi() {
        return opetusharjoitteluTyyppi;
    }

    /**
     * Sets the value of the opetusharjoitteluTyyppi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpetusharjoitteluTyyppi(String value) {
        this.opetusharjoitteluTyyppi = value;
    }

    /**
     * Gets the value of the opinnaytetyo property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOpinnaytetyo() {
        return opinnaytetyo;
    }

    /**
     * Sets the value of the opinnaytetyo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOpinnaytetyo(Boolean value) {
        this.opinnaytetyo = value;
    }

    /**
     * Gets the value of the hankkeistettu property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHankkeistettu() {
        return hankkeistettu;
    }

    /**
     * Sets the value of the hankkeistettu property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHankkeistettu(Boolean value) {
        this.hankkeistettu = value;
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
     * Gets the value of the julkinenLisatieto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the julkinenLisatieto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJulkinenLisatieto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OpintosuoritusJulkinenLisatietoTyyppi }
     * 
     * 
     */
    public List<OpintosuoritusJulkinenLisatietoTyyppi> getJulkinenLisatieto() {
        if (julkinenLisatieto == null) {
            julkinenLisatieto = new ArrayList<OpintosuoritusJulkinenLisatietoTyyppi>();
        }
        return this.julkinenLisatieto;
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

    /**
     * Gets the value of the opiskeluoikeusAvain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpiskeluoikeusAvain() {
        return opiskeluoikeusAvain;
    }

    /**
     * Sets the value of the opiskeluoikeusAvain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpiskeluoikeusAvain(String value) {
        this.opiskeluoikeusAvain = value;
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
     *         &lt;element name="Opintopiste" type="{urn:mace:funet.fi:virta/2015/09/01}LaajuusTyyppi" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="sisaltyvaOpintosuoritusAvain" use="required" type="{urn:mace:funet.fi:virta/2015/09/01}AvainTyyppi" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "opintopiste"
    })
    public static class Sisaltyvyys {

        @XmlElement(name = "Opintopiste")
        protected BigDecimal opintopiste;
        @XmlAttribute(name = "sisaltyvaOpintosuoritusAvain", required = true)
        protected String sisaltyvaOpintosuoritusAvain;

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
         * Gets the value of the sisaltyvaOpintosuoritusAvain property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSisaltyvaOpintosuoritusAvain() {
            return sisaltyvaOpintosuoritusAvain;
        }

        /**
         * Sets the value of the sisaltyvaOpintosuoritusAvain property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSisaltyvaOpintosuoritusAvain(String value) {
            this.sisaltyvaOpintosuoritusAvain = value;
        }

    }

}
