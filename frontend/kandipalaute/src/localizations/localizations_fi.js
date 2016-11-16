let localizations_fi = {
  header: {
    logotext: 'Yliopistojen valtakunnallinen opiskelijapalautekysely'
  },
  content: {
    kysely: {
      information: 'Tietoa kyselystä',
      about1: 'Kandipalaute on yliopistojen valtakunnallinen opiskelijapalautekysely, jossa  selvitetään kandidaatin tutkinnon suorittaneiden opiskelijoiden tyytyväisyyttä yliopistoonsa ja kokemuksia opintojen sujumisesta. Kysely perustuu oppimista, opiskelua ja opetusta koskevaan tieteelliseen tutkimukseen, ja sen pohjalta kehitettyyn Helsingin yliopiston HowULearn-kyselyyn. Kyselyn tuloksia hyödynnetään yliopistojen koulutuksen kehittämisessä sekä valtakunnallisesti yliopistojen ohjauksessa. Kyselyn täyttävät kaikki alempaan korkeakoulututkintoon kuuluvat tai vastaavat opinnot suorittaneet yliopisto-opiskelijat.',
      about2: 'Opiskelijan HAKA-kirjautumisen avulla haetaan henkilön opiskeluoikeuteen liittyviä tietoja VIRTA-opintotietopalvelusta taustatiedoksi Kandipalaute-kyselyn vastaajatunnuksen luomiseksi ja sähköisen palautteen antamisen mahdollistamiseksi. Henkilön yksilöiviä tunnisteita ei välitetä eteenpäin itse Kandipalaute-kyselyyn ja annettua palautetta käsitellään anonyymisti.',
      about3: 'Kandipalaute-kyselystä ja sen kehittämisestä vastaa Suomen yliopistot UNIFI ry.',
      privacy: 'Lisätietoja tietosuojaselosteessa.'
    },
    login: {
      header: 'Yliopisto-opiskelija',
      description: 'Vastaa kyselyyn kirjautumalla oman korkeakoulusi tunnuksilla:'
    },
    tulokset: {
      header: 'Kyselyn tulokset',
      results1: 'Yliopiston henkilökunta voi tarkastella kyselyn tuloksia reaaliaikaisesti Arvo - opetushallinnon vaikuttavuustietopalvelun avulla. Katseluoikeudet (Arvo-katselija) voi anoa Opintopolun virkailijantyöpöydän kautta (Omat tiedot)',
      results2: 'Kyselyn tuloksista johdettuja tilastoraportteja on avoimesti saatavilla opetushallinnon tilastopalvelu Vipusessa:'
    }
  },
  footer: {
    header: 'Yhteistyössä:',
    arene: {
      description: 'Suomen Yliopistot UNIFI ry'
    },
    okm: {
      description: 'Opetus- ja kulttuuriministeriö'
    },
    csc: {
      description: 'Arvo - opetushallinnon vaikuttavuustietopalvelu'
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
    reminder: 'Tarkistathan, että koulutuksesi tiedot ovat oikein. Siirtymällä palautekyselyyn hyväksyt tietojen käyttämisen palautekyselyn taustatietona.',
    survey: 'Siirry palautekyselyyn',
    type: {
      day: 'Päiväopiskelu',
      multi: 'Monimuoto-opiskelu'
    },
    submit: 'Siirry palautekyselyyn'
  },
  errors: {
    title: 'Virhetilanne',
    general_error: 'Valitettavasti järjestelmän toiminnassa tapahtui virhe. Jos ongelma toistuu, ole hyvä ja ota yhteys ylläpitoon arvo@postit.csc.fi.',
    haka_error: 'Haka ei palauttanut tarvittavia tietoja. Ota yhteyttä opintotoimistoosi'
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
