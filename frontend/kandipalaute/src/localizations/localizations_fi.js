let localizations_fi = {
  header: {
    logotext: 'Yliopistojen valtakunnallinen opiskelijapalautekysely',
    header_alt: 'Kyselyn logo ja teksti: Vastaa ja vaikuta'
  },
  content: {
    kysely: {
      information: 'Tietoa kyselystä',
      about1: 'Kandipalaute on palautekysely, jossa selvitetään kandidaatin tutkinnon suorittaneiden opiskelijoiden tyytyväisyyttä yliopistoonsa ja kokemuksia opintojen sujumisesta. Kysely perustuu oppimista, opiskelua ja opetusta koskevaan tieteelliseen tutkimukseen, ja sen pohjalta kehitettyyn Helsingin yliopiston HowULearn-kyselyyn. Kyselyn tuloksia hyödynnetään yliopistojen koulutuksen kehittämisessä sekä valtakunnallisesti yliopistojen ohjauksessa. Kyselyn täyttävät kaikki alempaan korkeakoulututkintoon kuuluvat tai vastaavat opinnot suorittaneet yliopisto-opiskelijat.',
      about2: 'Opiskelijan HAKA-kirjautumisen avulla haetaan henkilön opiskeluoikeuteen liittyviä tietoja VIRTA-opintotietopalvelusta taustatiedoksi Kandipalaute-kyselyn vastaajatunnuksen luomiseksi ja sähköisen palautteen antamisen mahdollistamiseksi. Henkilön yksilöiviä tunnisteita ei välitetä eteenpäin itse Kandipalaute-kyselyyn ja annettua palautetta käsitellään anonyymisti.',
      about3: 'Kandipalaute-kyselystä ja sen kehittämisestä vastaa Suomen yliopistot UNIFI ry.',
      privacy: {
        text: 'Lisätietoa: %(link1)s, %(link2)s ja %(link3)s.',
        url1Text: 'tietosuojaseloste',
        url2Text: 'kyselyn eettiset periaatteet',
        accessibilityLink: 'https://arvokyselyt.fi/documents/accessibility_statement_FI.html',
        accessibilityLinkText: 'saavutettavuusseloste'
      }
    },
    login: {
      header: 'Yliopisto-opiskelija',
      description: 'Vastaa kyselyyn kirjautumalla oman korkeakoulusi tunnuksilla:'
    },
    tulokset: {
      header: 'Kyselyn tulokset',
      results1: 'Yliopiston henkilökunta voi tarkastella kyselyn tuloksia reaaliaikaisesti Arvo - opetushallinnon vaikuttavuustietopalvelun avulla. Katseluoikeudet (Arvo-katselija) voi anoa Opintopolun virkailijantyöpöydän kautta (Omat tiedot).',
      results2: 'Annetuista vastauksista muodostettava sähköinen tutkimusaineisto arkistoidaan pysyvästi %(link)s, jossa aineistot ovat saatavilla myöhempään tutkimus-, opiskelu- ja opetuskäyttöön. Arkistointia varten aineistoa muokataan siten, ettei yksittäisen vastaajan tunnistaminen ole mahdollista (anonymisointi). Kyselyn tuloksista johdettuja tilastoraportteja on avoimesti saatavilla ',
      vipunen_link: 'opetushallinnon tilastopalvelu Vipusessa.',
      link1: {
        url: 'https://www.fsd.uta.fi/',
        text: 'Yhteiskuntatieteelliseen tietoarkistoon'
      }
    }
  },
  footer: {
    header: 'Yhteistyössä:',
    unifi: {
      description: 'Suomen Yliopistot UNIFI ry',
      logo_alt: 'Unifin logo'
    },
    okm: {
      description: 'Opetus- ja kulttuuriministeriö',
      logo_alt: 'Opetus- ja kulttuuriministeriön logo'
    },
    csc: {
      description: 'Arvo - opetushallinnon vaikuttavuustietopalvelu',
      logo_alt: 'CSC - Tieteen tietotekniikan keskuksen logo'
    }
  },
  profiledata: {
    header: 'Palautekyselyn taustatiedot',
    about: 'Palautekyselyyn välitetään taustatiedoiksi koulutus, yliopisto, koulutuksen kunta, tutkinnon suorituskieli ja opiskeluoikeuden alkamisvuosi. Henkilöön liittyviä tietoja ei välitetä palautekyselylle.',
    education: 'Koulutus',
    school: 'Yliopisto',
    municipality: 'Kunta',
    language: 'Tutkinnon suorituskieli',
    startYear: 'Tutkinnon aloitusvuosi',
    form_of_education: 'Koulutusmuoto',
    reminder: 'Tarkistathan, että koulutuksesi tiedot ovat oikein. Jos tiedoissasi on korjattavaa, ota yhteyttä opintotoimistoosi. Siirtymällä palautekyselyyn hyväksyt tietojen käyttämisen palautekyselyn taustatietona.',
    survey: 'Siirry palautekyselyyn',
    type: {
      day: 'Päiväopiskelu',
      multi: 'Monimuoto-opiskelu'
    },
    submit: 'Siirry palautekyselyyn'
  },
  errors: {
    title: 'Virhetilanne',
    general_error: 'Valitettavasti järjestelmän toiminnassa tapahtui virhe. Jos ongelma toistuu, ole hyvä ja ota yhteys ylläpitoon arvo@csc.fi.',
    haka_error: 'Valitettavasti Haka ei luovuttanut kirjautumisesi yhteydessä vaadittuja tietoja, ota yhteys oppilaitokseesi.',
    virta_error: 'Virhe haettaessa tietojasi Virta-opintotietopalvelusta. ',
    no_data_in_virta: 'Valitettavasti kirjautumistietosi eivät vastaa Virta-opintotietopalvelusta löydettäviä tietoja. Ota yhteys oppilaitokseesi.',
    arvo_error: 'Valitettavasti palautekyselyyn siirtymisessä tapahtui virhe. Ota yhteys arvo@csc.fi.',
    attach_code: 'Liitä viestin tämä virhekoodi'
  },
  opiskeluoikeus_errors: {
    invalid_organization: 'Opiskeluoikeutesi ei kuulu HAKA-kirjaumista vastaavaan korkeakouluun.',
    invalid_type: 'Väärä tyyppi.',
    invalid_date: 'Opiskeluoikeutesi ei ole voimassa.',
    invalid_laajuus: 'Puuttellinen tieto opintorekisterissä.',
    not_active: 'Opiskeluoikeutesi ei ole aktiivinen',
    not_enough_opintosuoritus: 'Sinulla ei ole riittävästi opintopisteitä opintorekisterissä.',
    no_kandi: 'Sinulla ole kandidaatin tutkinnon suoritusmerkintää opintorekisterissä.',
    no_patevyys: 'Sinulla ei ole vaadittua pätevyysmerkintää opintorekisterissä',
    header: 'Opiskeluoikeuksia ei löydy',
    no_rights_contact_study_office: 'Tiedoillasi ei löytynyt yhtään opiskeluoikeutta. Ota yhteys opintotoimistoosi.',
    some_rights_contact_study_office: 'Tiedoillasi löytyi %(rights_count)s opiskeluoikeutta, mutta tiedot eivät riitä palautteen antamiseen. Ota yhteys opintotoimistoosi.',
    additional_invalid_rights: 'Lisäksi löytyi %(rights_count)s oikeutta, mutta tiedot eivät riitä palautteen antamiseen.'
  }
};

export default localizations_fi;
