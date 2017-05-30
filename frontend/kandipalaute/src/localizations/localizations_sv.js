let localizations_sv = {
  header: {
    logotext: 'Responsenkäten för yrkeshögskolestuderande i slutskedet av studierna'
  },
  content: {
    kysely: {
      information: 'Om enkäten',
      about1: 'Kandidatrespons är universitetens riksomfattande undersökning, som utvärderar erfarenheter av hur studierna förlöpt och hur nöjd studerande är med sitt universitet. Enkäten grundar sig på vetenskaplig forskning om inlärning, studier och undervisning som hör till HowULearn-enkäten som utvecklas av Helsingfors universitet. Undersökningens resultat utnyttjas till att utveckla utbildningen och nationellt i styrning av universiteten. Enkäten besvaras av de universitetsstuderande som har avlagt en lägre högskoleexamen eller motsvarande.',
      about2: 'Med hjälp av studerandes HAKA-inloggning hittas personens information om studierätt från nationella VIRTA-studieregistret. Uppgifterna används som bakgrundsinformation för att skapa svarsidentifiering och gör de möjligt att ge respons i elektronisk form. Information som möjliggör personlig identifiering överförs inte vidare till själva Kandidatrespons-enkäten, utan materialet behandlas anonymt.',
      about3: 'Kandidatrespons-enkäten koordineras och utvecklas av Finlands universitet UNIFI rf.',
      privacy: 'Utförligare information i registerbeskrivningen.'
    },
    login: {
      header: 'Studerande vid universitet',
      description: 'Svara på enkäten genom att logga in med ditt eget universitets användarnamn och lösenord:'
    },
    tulokset: {
      header: 'Undersökningsresultaten',
      results1: 'Universitetets personal kan följa med enkätens resultat i realtid via utbildningsförvaltningens tjänst ”Arvo”. Ansökan om läsrättigheter (Arvo-katselija) kan anhållas via Opintopolku (virkailijan työpöytä, omat tiedot).',
      results2: 'Statistiska rapporter av enkätens resultat finns till allmänt påseende via utbildningsförvaltningens statistiktjänst Vipunen.'
    }
  },
  footer: {
    header: 'I samarbete med:',
    arene: {
      description: 'Finlands universitet UNIFI rf'
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
    about: 'Som bakgrundsinformation för enkäten används följande uppgifter: utbildning, yrkeshögskola, yrkeshögskolans kommun, språket för examen och inledningsdatum för studierna. Personuppgifter förmedlas inte vidare till enkäten och alla svar behandlas anonymt.',
    education: 'Utbildning',
    school: 'Universitet',
    municipality: 'Kommun',
    startYear: 'Inledningsdatum för studierna',
    language: 'Språket för examen',
    form_of_education: 'Undervisningsform',
    reminder: 'Var god och kontrollera att uppgifterna om din utbildning är korrekta. Om det finns brister eller fel i dina uppgifter, kontakta din studiebyrå. Genom att gå vidare till enkäten godkänner du att uppgifterna används som bakgrundsinformation för enkäten.',
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
    arvo_error: 'Tyvärr inträffade ett fel vid förflyttningen till responsenkäten, ta kontakt med arvo@csc.fi'
  },
  opiskeluoikeus_errors: {
    invalid_organization: 'Din studierätt tillhör inte den högskola som din HAKA-inloggning ger till känna.',
    invalid_type: 'Fel typ.',
    invalid_date: 'Din studierätt är inte i kraft.',
    invalid_laajuus: 'Bristfällig uppgift i studieregistret.',
    not_active: 'Din studierätt är inte aktiv.',
    not_enough_opintosuoritus: 'Du har inte tillräckligt med studiepoäng i studieregistret.',
    no_kandi: 'Du saknar registrering om avlagd kandidatexamen i studieregistret.',
    no_patevyys: 'Du saknar behövlig behörighetsanteckning i studieregistret.',
    header: 'Ingen studierätt hittades.',
    no_rights_contact_study_office: 'Med dina uppgifter hittades ingen studierätt. Kontakta din studiebyrå.',
    some_rights_contact_study_office: 'Med dina uppgifter hittades %(rights_count)st studierätter, men uppgifterna räcker inte till för ge respons. Kontakta din studiebyrå.',
    additional_invalid_rights: 'Dessutom hittades %(rights_count)st studierätter, men informationen räcker inte till för att kunna ge respons.'
  }
};

export default localizations_sv;
