let localizations_en = {
  header: {
    logotext: 'Haka-login'
  },
  content: {
    kysely: {
      information: 'Welcome to recruitment survey!',
      about1: 'This survey is a part of a data collection carried out by the Ministry of Education and Culture regarding recruitment. The purpose is to produce benchmark data on the most important resource of higher education institutions, namely human resources. The data is collected by higher education institutions and sent to the Ministry of Education and Culture.',
      about2: 'The person is identified using Haka login to create a unique answer identifier and to make electronic feedback possible. The identifier is saved as a background information which is used to associate the data collected with this survey to other background variables (such as title, nationality at continental level, personnel group). Read more in the privacy policy (available at https://wiki.eduuni.fi/display/CscArvo/Privacy+policy). It will not be possible to identify individuals in the reporting and analysis of the survey results.',
      about3: '',
      privacy: 'More information in privacy policy.'
    },
    login: {
      header: 'Haka-login',
      description: 'Please sign in to the survey by using your own organization\'s credentials:'
    },
    tulokset: {
      header: 'The results',
      results1: 'The statistics are freely available at the Vipunen statistics services of the educational administration.',
      results2: ''
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
    header: 'Welcome to answer the recruitment survey!',
    about: 'Please select your organization:',
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
    general_error: 'The application has encountered an unspecified error. Please contact arvo@csc.fi.',
    haka_error: 'Haka did not return required information when logging in. Please contact your higher education institution.',
    virta_error: 'There was an error when retrieving your information from tVirta higher education achievement register.',
    no_data_in_virta: 'Your logging information does not correspond with the information found from the Virta higher education achievement register. Please contact your higher education institution',
    arvo_error: 'Unfortunately an error occured while accessing the survey. Please contact arvo@csc.fi.',
    attach_code: 'Attach this error code to the message'
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
