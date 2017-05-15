let localizations_sv = {
  header: {
    logotext: 'Responsenkäten för yrkeshögskolestuderande i slutskedet av studierna'
  },
  content: {
    kysely: {
      information: 'Enkäten i korthet',
      about1: 'AVOP - Responsenkäten för yrkeshögskolestuderande i slutskedet av studierna är ett utvärderingssystem som ger studenten möjlighet att utvärdera och ge respons på sin utbildning. Utvärderingsresultaten används lokalt vid högskolorna med syfte att förbättra de egna processerna och att prägla uppföljningen och finansieringen av den nationella utbildningen. Alla utexaminerade yrkesehögskolestuderanden ombeds fylla i enkäten (förutom Polishögskolan).',
      about2: 'Med hjälp av HAKA-identifieringen hämtas personens uppgifter gällande studierätten från VIRTA-datalager som bakgrundsinformation för att kunna skapa AVOP svarskoden och möjliggöra givande av respons elektroniskt. Uppgifter som skulle identifiera personen skickas inte vidare till AVOP-enkäten utan förfrågan är helt anonym.',
      about3: 'Den elektroniska enkäten AVOP, utgör en del av den nationella ARVO-tjänsten (informationstjänst för hantering av utbildningsärenden), som gör det möjligt att på nationell nivå samla ihop förenlig data om effekterna av utbildning.',
      privacy: 'Mer information.'
    },
    login: {
      header: 'Yrkeshögskolestuderande',
      description: 'Använd din personliga HAKA-kod för att logga in på enkäten:'
    },
    tulokset: {
      header: 'Enkätens resultat',
      results1: 'Personalen vid yrkeshögskolorna kommer åt enkätens resultat i realtid via Arvo-tjänsten.',
      results2: 'Statistiken som stått som bakgrund för enkätresultaten är fritt tillgängliga via utbildningsförvaltningens statistiktjänst Vipunen:'
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
    haka_error: 'HAKA returnerade inte behövlig information. Kontakta din studiebyrå.',
    virta_error: 'Ett fel har inträffat. Vänligen försök igen eller kontakta kundtjänsten (arvo@postit.csc.fi) om problemet kvarstår.',
    no_data_in_virta: 'Ett fel har inträffat. Vänligen försök igen eller kontakta kundtjänsten (arvo@postit.csc.fi) om problemet kvarstår.',
    arvo_error: 'Ett fel har inträffat. Vänligen försök igen eller kontakta kundtjänsten (arvo@postit.csc.fi) om problemet kvarstår.'
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
