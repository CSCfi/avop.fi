let localizations_sv = {
  header: {
    logotext: 'Responsenkäten för yrkeshögskolestuderande i slutskedet av studierna'
  },
  content: {
    kysely: {
      information: 'Välkomna att svara på rekryteringsenkäten',
      about1: 'Denna enkät är en del av undervisnings- och kulturministeriets datainsamling. Syftet med datainsamlingen är att generera kunskap om en viktig resurs vid högskolorna, dvs. personalen. Högskolorna samlar in informationen och skickar den vidare till undervisnings- och kulturministeriets datainsamling.',
      about2: 'Med hjälp av HAKA-inloggning identifieras respondenten för att kunna skapa en unik svarskod. Detta möjliggör ifyllandet av enkäten. Uppgifter som identifierar respondenten ska sparas, och med hjälp av dessa uppgifter förenas enkätens data med vissa bakgrundsvariabler (t.ex. yrkesbeteckning, svarandens nationalitet enligt världsdel, personalgrupp). Se registerbeskrivningen för närmare information (finns på: https://wiki.eduuni.fi/display/CscArvo/Privacy+policy). Det går inte att urskilja enskilda personer i rapporteringen eller i analysen av informationen.',
      about3: 'Efter anställningsförhållandet är det inte möjligt att använda HAKA-inloggning. Då skickas en personlig länk till respondenten för att svara på enkäten.',
      privacy: 'Mer information.'
    },
    login: {
      header: 'Logga in',
      description: 'Använd din personliga HAKA-kod för att logga in på enkäten:'
    },
    tulokset: {
      header: 'Enkätens resultat',
      results1: 'Statistiska rapporter av enkätens resultat finns till allmänt påseende via utbildningsförvaltningens statistiktjänst Vipunen.',
      results2: 'Tack för att du tar dig tid!'
    }
  },
  footer: {
    header: 'I samarbete med:',
    arene: {
      description: 'Rådet för yrkeshögskolornas rektorer, Arene'
    },
    okm: {
      description: 'Undervisnings- och kulturministeriet'
    },
    csc: {
      description: 'Arvo - informationstjänst för effektivitetshantering i utbildningsförvaltning'
    }
  },
  profiledata: {
    header: 'Bakgrundsinformation till enkäten',
    about: 'Som bakgrundsinformation för enkäten används följande uppgifter: utbildning, yrkeshögskola, yrkeshögskolans kommun, inledningsdatum för studierna, språket för examen och undervisningsform. Personuppgifter förmedlas inte vidare till enkäten och alla svar behandlas anonymt.',
    about_yamk: 'Som bakgrundinformation för enkäten används följande uppgifter: utbildning, yrkeshögskola, yrkeshögskolans kommun, inledningsdatum för studierna och språket för examen. Personuppgifter förmedlas inte vidare till enkäten och alla svar behandlas anonymt.',
    education: 'Examensbenämning',
    school: 'Yrkeshögskola',
    municipality: 'Kommun',
    startYear: 'Inledningsdatum för studierna',
    language: 'Språket för examen',
    form_of_education: 'Undervisningsform',
    reminder: 'Var god och kontrollera att uppgifterna om din utbildning är korrekta. Genom att gå vidare till enkäten godkänner du att uppgifterna används som bakgrundsinformation för enkäten.',
    survey: 'Gå till enkäten',
    type: {
      day: 'Dagundervisning',
      multi: 'Flerformsundervisning'
    },
    submit: 'Gå till enkäten'
  },
  errors: {
    title: 'Ett fel',
    general_error: 'Ett fel har inträffat. Vänligen försök igen eller kontakta kundtjänsten (arvo@postit.csc.fi) om problemet kvarstår.',
    haka_error: 'Tyvärr returnerades inte i samband inloggningen via HAKA alla uppgifter som krävs för tjänsten, ta kontakt med din läroanstalt.',
    virta_error: 'Ett fel har inträffat. Vänligen försök igen eller kontakta kundtjänsten (arvo@postit.csc.fi) om problemet kvarstår.',
    no_data_in_virta: 'Tyvärr motsvarar dina uppgifter förmedlade via inloggningen inte med de uppgifter som finns i Virta-tjänsten, ta kontakt med din läroanstalt.',
    arvo_error: 'Tyvärr inträffade ett fel vid förflyttningen till responsenkäten, ta kontakt med arvo@csc.fi',
    attach_code: 'Bifoga denna kod i meddelandet'
  },
  opiskeluoikeus_errors: {
    invalid_organization: 'Din studierätt tillhör inte den högskola som din HAKA-inloggning ger till känna.',
    invalid_type: 'Fel typ.',
    invalid_date: 'Din studierätt är inte i kraft.',
    invalid_laajuus: 'Bristfällig uppgift i studieregistret.',
    not_enough_opintosuoritus: 'Du har inte tillräckligt med studiepoäng i studieregistret.',
    no_kandi: 'Du saknar registrering om avlagd kandidatexamen i studieregistret.',
    header: 'Ingen studierätt hittades.',
    no_rights_contact_study_office: 'Med dina uppgifter hittades ingen studierätt. Kontakta din studiebyrå.',
    some_rights_contact_study_office: 'Med dina uppgifter hittades %(rights_count)s studierätter, men uppgifterna räcker inte till för ge respons. Kontakta din studiebyrå.',
    additional_invalid_rights: 'Dessutom hittades %(rights_count)s studierätter, men informationen räcker inte till för att kunna ge respons.'
  }
};

export default localizations_sv;
