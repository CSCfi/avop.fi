let localizations_fi = {
  header: {
    logotext: 'Ammattikorkeakoulujen valmistumisvaiheen opiskelijapalaute'
  },
  content: {
    kysely: {
      information: 'Tervetuloa vastaamaan rekrytointikyselyyn!',
      about1: 'Tämä kysely on osa opetus- ja kulttuuriministeriön rekrytointitiedonkeruuta, jonka tarkoituksena on tuottaa vertailutietoa korkeakoulujen tärkeästä voimavarasta, henkilöstöstä.  Kyselyn vastaukset menevät korkeakoululle, joka yhdistää ne tarvittaviin taustatietoihin alla kuvatulla tavalla ja lähettää opetus- ja kulttuuriministeriölle.',
      about2: 'HAKA-kirjautumisen avulla vastaaja tunnistetaan ja hänestä haetaan yksilöivä tunnistetieto vastaajatunnuksen luomiseksi ja sähköisen palautteen antamisen mahdollistamiseksi. Tunniste myös tallennetaan taustatiedoksi, jonka avulla kerätyt tiedot yhdistetään muuhun rekrytointitiedonkeruun aineistoon, esimerkiksi nimike, kansalaisuus maanosatasolla ja henkilöstöryhmä (kts. tarkemmin rekisteriseloste: https://wiki.eduuni.fi/display/CscArvo/Privacy+policy). Tietojen raportoinnissa ja analysoinnissa yksittäisiä henkilöitä ei ole tunnistettavissa.',
      about3: 'Työsuhteen päättymisen jälkeen Haka-kirjautuminen ei ole enää mahdollista. Tällöin organisaation Arvo-vastuuhenkilön on mahdollista luoda vastaajalle henkilökohtainen linkki kyselyyn vastaamista varten.',
      privacy: 'Lisätietoja tietosuojaselosteessa.'
    },
    login: {
      header: 'Haka-kirjautuminen',
      description: 'Vastaa kyselyyn kirjautumalla oman organisaatiosi tunnuksilla:'
    },
    tulokset: {
      header: 'Kyselyn tulokset',
      results1: 'Kyselyn tuloksista johdettuja tilastoraportteja on myöhemmin avoimesti saatavilla opetushallinnon tilastopalvelu Vipusessa.',
      results2: ''
    }
  },
  footer: {
    header: 'Yhteistyössä:',
    okm: {
      description: 'Opetus- ja kulttuuriministeriö'
    },
    csc: {
      description: 'Arvo - opetushallinnon vaikuttavuustietopalvelu'
    }
  },
  profiledata: {
    header: 'Palautekyselyn taustatiedot',
    about: 'Palautekyselyyn välitetään taustatiedoiksi koulutus, ammattikorkeakoulu, koulutuksen kunta, tutkinnon aloitusvuosi, tutkinnon suorituskieli ja koulutusmuoto. Henkilöön liittyviä tietoja ei välitetä palautekyselylle.',
    about_yamk: 'Palautekyselyyn välitetään taustatiedoiksi koulutus, ammattikorkeakoulu, koulutuksen kunta, tutkinnon aloitusvuosi ja tutkinnon suorituskieli. Henkilöön liittyviä tietoja ei välitetä palautekyselylle.',
    education: 'Tutkintonimike',
    school: 'Ammattikorkeakoulu',
    municipality: 'Kunta',
    startYear: 'Tutkinnon aloitusvuosi',
    language: 'Tutkinnon suorituskieli',
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
    not_enough_opintosuoritus: 'Sinulla ei ole tarvittavia suoritusmerkintöjä opintorekisterissä.',
    no_kandi: 'Sinulla ole kandidaatin tutkinnon suoritusmerkintää opintorekisterissä.',
    header: 'Opiskeluoikeuksia ei löydy',
    no_rights_contact_study_office: 'Tiedoillasi ei löytynyt yhtään opiskeluoikeutta. Ota yhteys opintotoimistoosi.',
    some_rights_contact_study_office: 'Tiedoillasi löytyi %(rights_count)s opiskeluoikeutta, mutta tiedot eivät riitä palautteen antamiseen. Ota yhteys opintotoimistoosi.',
    additional_invalid_rights: 'Lisäksi löytyi %(rights_count)s oikeutta, mutta tiedot eivät riitä palautteen antamiseen.'
  }
};

export default localizations_fi;
