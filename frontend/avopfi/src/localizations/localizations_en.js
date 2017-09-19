let localizations_en = {
  header: {
    logotext: 'Polytechic graduand feedback questionnaire'
  },
  content: {
    kysely: {
      information: 'About the questionnaire',
      about1: 'AVOP - Graduand feedback questionnaire asks graduating students to evaluate and provide feedback on their education. The findings are used locally by institutions to improve their institutional processes and practices and nationally to inform performance-based monitoring and funding. All graduating degree students from universities of applied sciences are requested to fill out the questionnaire (except Police University College).',
      about2: 'Collected personal data is used to fetch information related to person’s study right from VIRTA - higher education achievement register as background information to create a respondent ID and enable the use of electronic graduate feedback questionnaire. The collected personal data is not transferred to the AVOP-survey and your answers to the survey are handled anonymously.',
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
      description: 'Rectors’ Conference of Finnish Universities of Applied Sciences, Arene'
    },
    okm: {
      description: 'Ministry of Education and Culture'
    },
    csc: {
      description: 'Arvo - education management information service'
    }
  },
  profiledata: {
    header: 'Background information',
    about: 'Information on education, university of applied sciences, municipality, start date of the right to study, language of learning and mode of education is used as survey background information. The collected personal information is not transferred to the feedback system.',
    about_yamk: 'Information on education, university of applied sciences, municipality, start date of the right to study and language of learning is used as survey background information. The collected personal information is not transferred to the feedback system.',
    education: 'Degree title',
    school: 'University of applied sciences',
    municipality: 'Municipality',
    startYear: 'Start date of the right to study',
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
    general_error: 'The application has encountered an unspecified error. Please contact arvo@postit.csc.fi.',
    haka_error: 'Haka did not return required information when logging in. Please contact your higher education institution.',
    virta_error: 'There was an error when retrieving your information from tVirta higher education achievement register.',
    no_data_in_virta: 'Your logging information does not correspond with the information found from the Virta higher education achievement register. Please contact your higher education institution',
    arvo_error: 'Unfortunately an error occured while accessing the survey. Please contact arvo@csc.fi.'
  },
  opiskeluoikeus_errors: {
    invalid_organization: 'Your right to study does not correspond to the HAKA home organisation.',
    invalid_type: 'Wrong type of degree.',
    invalid_date: 'Your right to study is not valid.',
    invalid_laajuus: 'Insufficient information in the student registration system.',
    not_enough_opintosuoritus: 'You do not have enough study points recorded in the student registration system.',
    no_kandi: 'Sinulla ole kandidaatin tutkinnon suoritusmerkintää opintorekisterissä.',
    header: 'No rights to study found.',
    no_rights_contact_study_office: 'No rights to study found with your logging information. Please contact your study office for further information.',
    some_rights_contact_study_office: ' %(rights_count)s rights to study found without required information to grant access to the graduate survey. Please contact your study office for further information.',
    additional_invalid_rights: 'In addition, %(rights_count)rights to study found without required information to grant access to the graduate survey. Please contact your study office for further information.'
  }
};

export default localizations_en;
