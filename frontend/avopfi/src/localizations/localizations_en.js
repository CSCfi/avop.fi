let localizations_en = {
  header: {
    logotext: 'Polytechic graduand feedback questionnaire'
  },
  content: {
    kysely: {
      information: 'About the questionnaire',
      about1: 'AVOP - Graduand feedback questionnaire asks graduating students to evaluate and provide feedback on their education. The findings are used locally by institutions to improve their institutional processes and practices and nationally to inform performance-based monitoring and funding. All graduating degree students from universities of applied sciences are requested to fill out the questionnaire (except Police University College).',
      about2: 'Collected personal data is used to fetch information related to person’s study right from VIRTA - higher education achievement register as background information to create a respondent ID and enable the use of electronic graduate feedback questionnaire. The collected personal data is not transferred to the AVOP-survey and your answers to the survey are completely anonymous.',
      about3: 'The questionnaire was developed in close cooperation with the Rectors\' Conference of Finnish Universities of Applied Sciences (ARENE), the Union of Students in Finnish Universities of Applied Sciences (SAMOK), Foundation for Research on Studying and Education (OTUS) and the Ministry for Education and Culture. The responsibility for development and implementation of the questionnaire lies with Arene.',
      privacy: 'More information in privacy policy.'
    },
    login: {
      header: 'UAS student',
      description: 'Please sign in to the survey by using your own UAS credentials:'
    },
    tulokset: {
      header: 'The results',
      results1: 'The staff of the universities of applied sciences can review the real time survey results by using the Arvo - education management information service with appropriate user rights.',
      results2: 'The statistics are freely available at the Vipunen statistics services of the educational administration.'
    }
  },
  footer: {
    header: 'In cooperation:',
    arene: {
      description: 'Rectors´Conference of Finnish Universities of Applied Sciences, Arene'
    },
    okm: {
      description: 'Ministry of Education and Culture'
    },
    csc: {
      description: 'Arvo - Education information management service'
    }
  },
  profiledata: {
    header: 'Background information',
    about: 'Information on education, university of applied sciences, municipality, language of learning and mode of teaching is used as survey background information. The collected personal information is not transferred to the feedback system.',
    about_yamk: 'Information on education, university of applied sciences, municipality and language of learning is used as survey background information. The collected personal information is not transferred to the feedback system.',
    education: 'Degree title',
    school: 'University of applied sciences',
    municipality: 'Municipality',
    language: 'Language of learning',
    form_of_education: 'Mode of education',
    reminder: 'Please confirm the education information is correct. Once you move to the feedback questionnaire, you accept that the information is used as background information.',
    survey: 'Go to the survey',
    type: {
      day: 'Daytime studies',
      multi: 'Multiform studies'
    },
    submit: 'Go to the survey'
  },
  errors: {
    title: 'Error',
    general_error: 'The application has encountered an unknown error.',
    haka_error: 'Haka did not return required information. Contact your study office'
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

export default localizations_en;
