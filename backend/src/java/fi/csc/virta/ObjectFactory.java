
package fi.csc.virta;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fi.csc.virta package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Opiskelijat_QNAME = new QName("urn:mace:funet.fi:virta/2015/09/01", "Opiskelijat");
    private final static QName _Opiskeluoikeudet_QNAME = new QName("urn:mace:funet.fi:virta/2015/09/01", "Opiskeluoikeudet");
    private final static QName _Organisaatio_QNAME = new QName("http://tietovaranto.csc.fi/luku", "organisaatio");
    private final static QName _Opintosuoritukset_QNAME = new QName("urn:mace:funet.fi:virta/2015/09/01", "Opintosuoritukset");
    private final static QName _LukukausiIlmoittautumiset_QNAME = new QName("urn:mace:funet.fi:virta/2015/09/01", "LukukausiIlmoittautumiset");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fi.csc.virta
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OpiskelijanTiedotRequest }
     * 
     */
    public OpiskelijanTiedotRequest createOpiskelijanTiedotRequest() {
        return new OpiskelijanTiedotRequest();
    }

    /**
     * Create an instance of {@link OpintosuoritusTyyppi }
     * 
     */
    public OpintosuoritusTyyppi createOpintosuoritusTyyppi() {
        return new OpintosuoritusTyyppi();
    }

    /**
     * Create an instance of {@link OpiskeluoikeusTyyppi }
     * 
     */
    public OpiskeluoikeusTyyppi createOpiskeluoikeusTyyppi() {
        return new OpiskeluoikeusTyyppi();
    }

    /**
     * Create an instance of {@link OpiskeluoikeusTyyppi.SiirtoOpiskelija }
     * 
     */
    public OpiskeluoikeusTyyppi.SiirtoOpiskelija createOpiskeluoikeusTyyppiSiirtoOpiskelija() {
        return new OpiskeluoikeusTyyppi.SiirtoOpiskelija();
    }

    /**
     * Create an instance of {@link ArvosanaAsteikkoMuuTyyppi }
     * 
     */
    public ArvosanaAsteikkoMuuTyyppi createArvosanaAsteikkoMuuTyyppi() {
        return new ArvosanaAsteikkoMuuTyyppi();
    }

    /**
     * Create an instance of {@link ArvosanaAsteikkoMuuTyyppi.Asteikko }
     * 
     */
    public ArvosanaAsteikkoMuuTyyppi.Asteikko createArvosanaAsteikkoMuuTyyppiAsteikko() {
        return new ArvosanaAsteikkoMuuTyyppi.Asteikko();
    }

    /**
     * Create an instance of {@link OpiskelijanKaikkiTiedotRequest }
     * 
     */
    public OpiskelijanKaikkiTiedotRequest createOpiskelijanKaikkiTiedotRequest() {
        return new OpiskelijanKaikkiTiedotRequest();
    }

    /**
     * Create an instance of {@link Kutsuja }
     * 
     */
    public Kutsuja createKutsuja() {
        return new Kutsuja();
    }

    /**
     * Create an instance of {@link HakuEhdotOrganisaatioVapaa }
     * 
     */
    public HakuEhdotOrganisaatioVapaa createHakuEhdotOrganisaatioVapaa() {
        return new HakuEhdotOrganisaatioVapaa();
    }

    /**
     * Create an instance of {@link LukukausiIlmoittautumisetRequest }
     * 
     */
    public LukukausiIlmoittautumisetRequest createLukukausiIlmoittautumisetRequest() {
        return new LukukausiIlmoittautumisetRequest();
    }

    /**
     * Create an instance of {@link LukukausiIlmoittautumisetResponse }
     * 
     */
    public LukukausiIlmoittautumisetResponse createLukukausiIlmoittautumisetResponse() {
        return new LukukausiIlmoittautumisetResponse();
    }

    /**
     * Create an instance of {@link LukukausiIlmoittautumisetTyyppi }
     * 
     */
    public LukukausiIlmoittautumisetTyyppi createLukukausiIlmoittautumisetTyyppi() {
        return new LukukausiIlmoittautumisetTyyppi();
    }

    /**
     * Create an instance of {@link OpintosuorituksetResponse }
     * 
     */
    public OpintosuorituksetResponse createOpintosuorituksetResponse() {
        return new OpintosuorituksetResponse();
    }

    /**
     * Create an instance of {@link OpintosuorituksetTyyppi }
     * 
     */
    public OpintosuorituksetTyyppi createOpintosuorituksetTyyppi() {
        return new OpintosuorituksetTyyppi();
    }

    /**
     * Create an instance of {@link TutkinnotRequest }
     * 
     */
    public TutkinnotRequest createTutkinnotRequest() {
        return new TutkinnotRequest();
    }

    /**
     * Create an instance of {@link OpiskelijanTiedotRequest.Hakuehdot }
     * 
     */
    public OpiskelijanTiedotRequest.Hakuehdot createOpiskelijanTiedotRequestHakuehdot() {
        return new OpiskelijanTiedotRequest.Hakuehdot();
    }

    /**
     * Create an instance of {@link OpiskelijanTiedotResponse }
     * 
     */
    public OpiskelijanTiedotResponse createOpiskelijanTiedotResponse() {
        return new OpiskelijanTiedotResponse();
    }

    /**
     * Create an instance of {@link OpiskelijatTyyppi }
     * 
     */
    public OpiskelijatTyyppi createOpiskelijatTyyppi() {
        return new OpiskelijatTyyppi();
    }

    /**
     * Create an instance of {@link OpintosuorituksetRequest }
     * 
     */
    public OpintosuorituksetRequest createOpintosuorituksetRequest() {
        return new OpintosuorituksetRequest();
    }

    /**
     * Create an instance of {@link OpiskelijanKaikkiTiedotResponse }
     * 
     */
    public OpiskelijanKaikkiTiedotResponse createOpiskelijanKaikkiTiedotResponse() {
        return new OpiskelijanKaikkiTiedotResponse();
    }

    /**
     * Create an instance of {@link Virta }
     * 
     */
    public Virta createVirta() {
        return new Virta();
    }

    /**
     * Create an instance of {@link OpiskelijaLaajennettuTyyppi }
     * 
     */
    public OpiskelijaLaajennettuTyyppi createOpiskelijaLaajennettuTyyppi() {
        return new OpiskelijaLaajennettuTyyppi();
    }

    /**
     * Create an instance of {@link OpiskeluoikeudetRequest }
     * 
     */
    public OpiskeluoikeudetRequest createOpiskeluoikeudetRequest() {
        return new OpiskeluoikeudetRequest();
    }

    /**
     * Create an instance of {@link TutkinnotResponse }
     * 
     */
    public TutkinnotResponse createTutkinnotResponse() {
        return new TutkinnotResponse();
    }

    /**
     * Create an instance of {@link OpiskeluoikeudetResponse }
     * 
     */
    public OpiskeluoikeudetResponse createOpiskeluoikeudetResponse() {
        return new OpiskeluoikeudetResponse();
    }

    /**
     * Create an instance of {@link OpiskeluoikeudetTyyppi }
     * 
     */
    public OpiskeluoikeudetTyyppi createOpiskeluoikeudetTyyppi() {
        return new OpiskeluoikeudetTyyppi();
    }

    /**
     * Create an instance of {@link HakuEhdot }
     * 
     */
    public HakuEhdot createHakuEhdot() {
        return new HakuEhdot();
    }

    /**
     * Create an instance of {@link OrganisaatioRooliOsuusTyyppi }
     * 
     */
    public OrganisaatioRooliOsuusTyyppi createOrganisaatioRooliOsuusTyyppi() {
        return new OrganisaatioRooliOsuusTyyppi();
    }

    /**
     * Create an instance of {@link OpintosuoritusNimiTyyppi }
     * 
     */
    public OpintosuoritusNimiTyyppi createOpintosuoritusNimiTyyppi() {
        return new OpintosuoritusNimiTyyppi();
    }

    /**
     * Create an instance of {@link OpintosuoritusJulkinenLisatietoTyyppi }
     * 
     */
    public OpintosuoritusJulkinenLisatietoTyyppi createOpintosuoritusJulkinenLisatietoTyyppi() {
        return new OpintosuoritusJulkinenLisatietoTyyppi();
    }

    /**
     * Create an instance of {@link AikajaksoTyyppi }
     * 
     */
    public AikajaksoTyyppi createAikajaksoTyyppi() {
        return new AikajaksoTyyppi();
    }

    /**
     * Create an instance of {@link KoulutusalaVersioTyyppi }
     * 
     */
    public KoulutusalaVersioTyyppi createKoulutusalaVersioTyyppi() {
        return new KoulutusalaVersioTyyppi();
    }

    /**
     * Create an instance of {@link OpiskelijaTyyppi }
     * 
     */
    public OpiskelijaTyyppi createOpiskelijaTyyppi() {
        return new OpiskelijaTyyppi();
    }

    /**
     * Create an instance of {@link KoulutusalaVersioOsuusTyyppi }
     * 
     */
    public KoulutusalaVersioOsuusTyyppi createKoulutusalaVersioOsuusTyyppi() {
        return new KoulutusalaVersioOsuusTyyppi();
    }

    /**
     * Create an instance of {@link HenkiloTyyppi }
     * 
     */
    public HenkiloTyyppi createHenkiloTyyppi() {
        return new HenkiloTyyppi();
    }

    /**
     * Create an instance of {@link ArvosanaTyyppi }
     * 
     */
    public ArvosanaTyyppi createArvosanaTyyppi() {
        return new ArvosanaTyyppi();
    }

    /**
     * Create an instance of {@link LaajuusLaajennettuTyyppi }
     * 
     */
    public LaajuusLaajennettuTyyppi createLaajuusLaajennettuTyyppi() {
        return new LaajuusLaajennettuTyyppi();
    }

    /**
     * Create an instance of {@link LukukausiIlmoittautuminenTyyppi }
     * 
     */
    public LukukausiIlmoittautuminenTyyppi createLukukausiIlmoittautuminenTyyppi() {
        return new LukukausiIlmoittautuminenTyyppi();
    }

    /**
     * Create an instance of {@link OpintosuoritusTyyppi.Sisaltyvyys }
     * 
     */
    public OpintosuoritusTyyppi.Sisaltyvyys createOpintosuoritusTyyppiSisaltyvyys() {
        return new OpintosuoritusTyyppi.Sisaltyvyys();
    }

    /**
     * Create an instance of {@link OpiskeluoikeusTyyppi.Tila }
     * 
     */
    public OpiskeluoikeusTyyppi.Tila createOpiskeluoikeusTyyppiTila() {
        return new OpiskeluoikeusTyyppi.Tila();
    }

    /**
     * Create an instance of {@link OpiskeluoikeusTyyppi.Jakso }
     * 
     */
    public OpiskeluoikeusTyyppi.Jakso createOpiskeluoikeusTyyppiJakso() {
        return new OpiskeluoikeusTyyppi.Jakso();
    }

    /**
     * Create an instance of {@link OpiskeluoikeusTyyppi.Liittyvyys }
     * 
     */
    public OpiskeluoikeusTyyppi.Liittyvyys createOpiskeluoikeusTyyppiLiittyvyys() {
        return new OpiskeluoikeusTyyppi.Liittyvyys();
    }

    /**
     * Create an instance of {@link OpiskeluoikeusTyyppi.SiirtoOpiskelija.Lukukausikertyma }
     * 
     */
    public OpiskeluoikeusTyyppi.SiirtoOpiskelija.Lukukausikertyma createOpiskeluoikeusTyyppiSiirtoOpiskelijaLukukausikertyma() {
        return new OpiskeluoikeusTyyppi.SiirtoOpiskelija.Lukukausikertyma();
    }

    /**
     * Create an instance of {@link ArvosanaAsteikkoMuuTyyppi.Asteikko.AsteikkoArvosana }
     * 
     */
    public ArvosanaAsteikkoMuuTyyppi.Asteikko.AsteikkoArvosana createArvosanaAsteikkoMuuTyyppiAsteikkoAsteikkoArvosana() {
        return new ArvosanaAsteikkoMuuTyyppi.Asteikko.AsteikkoArvosana();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpiskelijatTyyppi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mace:funet.fi:virta/2015/09/01", name = "Opiskelijat")
    public JAXBElement<OpiskelijatTyyppi> createOpiskelijat(OpiskelijatTyyppi value) {
        return new JAXBElement<OpiskelijatTyyppi>(_Opiskelijat_QNAME, OpiskelijatTyyppi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpiskeluoikeudetTyyppi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mace:funet.fi:virta/2015/09/01", name = "Opiskeluoikeudet")
    public JAXBElement<OpiskeluoikeudetTyyppi> createOpiskeluoikeudet(OpiskeluoikeudetTyyppi value) {
        return new JAXBElement<OpiskeluoikeudetTyyppi>(_Opiskeluoikeudet_QNAME, OpiskeluoikeudetTyyppi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tietovaranto.csc.fi/luku", name = "organisaatio")
    public JAXBElement<String> createOrganisaatio(String value) {
        return new JAXBElement<String>(_Organisaatio_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpintosuorituksetTyyppi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mace:funet.fi:virta/2015/09/01", name = "Opintosuoritukset")
    public JAXBElement<OpintosuorituksetTyyppi> createOpintosuoritukset(OpintosuorituksetTyyppi value) {
        return new JAXBElement<OpintosuorituksetTyyppi>(_Opintosuoritukset_QNAME, OpintosuorituksetTyyppi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LukukausiIlmoittautumisetTyyppi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mace:funet.fi:virta/2015/09/01", name = "LukukausiIlmoittautumiset")
    public JAXBElement<LukukausiIlmoittautumisetTyyppi> createLukukausiIlmoittautumiset(LukukausiIlmoittautumisetTyyppi value) {
        return new JAXBElement<LukukausiIlmoittautumisetTyyppi>(_LukukausiIlmoittautumiset_QNAME, LukukausiIlmoittautumisetTyyppi.class, null, value);
    }

}
