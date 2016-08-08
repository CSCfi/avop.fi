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
    about: 'Som bakgrundinformation för enkäten används följande uppgifter: utbildning, yrkeshögskola, yrkeshögskolans kommun, språket för examen och undervisningsform. Personuppgifter förmedlas inte vidare till enkäten.',
    education: 'Utbildning',
    school: 'Yrkeshögskola',
    municipality: 'Kommun',
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
    general_error: 'The application has encountered an unknown error.'
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
    some_rights_contact_study_office: 'Tiedoillasi löytyi %(rights_count)s opiskeluoikeutta, mutta tiedot eivät riitä palautteen antamiseen . Ota yhteys opintotoimistoosi',
    additional_invalid_rights: 'Lisäksi löytyi %(rights_count)s oikeutta, mutta tiedot eivät riitä palautteen antamiseen.'
  }
};

export default localizations_sv;
