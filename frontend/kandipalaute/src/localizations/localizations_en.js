let localizations_en = {
  header: {
    logotext: 'The Finnish Bachelor’s Graduate Survey'
  },
  content: {
    kysely: {
      information: 'About the questionnaire',
      about1: 'Kandipalaute - The Finnish Bachelor’s Graduate Survey is a national student feedback survey that examines students’ satisfaction with their university and studying experience. The survey is founded on HowULearn-questionnaire that was developed by the University of Helsinki based on prior research on academic teaching and learning. The findings are used by institutions to improve education and learning and nationally to inform performance-based monitoring and guidance. All graduating Bachelor degree students or students with corresponding studies from universities are requested to fill out the questionnaire.',
      about2: 'Collected personal data is used to fetch information related to person’s study right from VIRTA - higher education achievement register as background information to create a respondent ID and enable the use of electronic graduate feedback questionnaire. The collected personal data is not transferred to the questionnaire and all answers are handled confidentially and anonymized.',
      about3: 'The responsibility for development and implementation of the questionnaire lies with Universities Finland UNIFI.',
      privacy: 'More information in privacy policy.'
    },
    login: {
      header: 'University student',
      description: 'Please sign in to the survey by using your university credentials:'
    },
    tulokset: {
      header: 'The results',
      results1: 'The staff of the universities can review the real time survey results by using the Arvo - education management information service with appropriate user rights.',
      results2: 'The statistics are freely available at the Vipunen statistics services of the educational administration.',
      link1: {
        url: '',
        text: ''
      }
    }
  },
  footer: {
    header: 'In cooperation:',
    arene: {
      description: 'Universities Finland UNIFI'
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
    about: 'Information on education, university, municipality, language of learning and start date of the right to study is used as survey background information. The collected personal information is not transferred to the feedback system.',
    education: 'Education',
    school: 'University',
    municipality: 'Municipality',
    language: 'Language of learning',
    startYear: 'Start date of the right to study',
    form_of_education: 'Mode of education',
    reminder: 'Please confirm the education information is correct. In case of errors, please contact your study office. Once you move to the feedback questionnaire, you accept that the information is used as background information.',
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
    not_active: 'Your right to study is not active.',
    not_enough_opintosuoritus: 'You do not have enough study points recorded in the student registration system.',
    no_kandi: 'You do not have a bachelor degree recorded in the student registration system.',
    no_patevyys: 'You do not have requiered qualification recorded in the student registration system.',
    header: 'No rights to study found.',
    no_rights_contact_study_office: 'No rights to study found with your logging information. Please contact your study office for further information.',
    some_rights_contact_study_office: ' %(rights_count)s rights to study found without required information to grant access to the graduate survey. Please contact your study office for further information',
    additional_invalid_rights: 'In addition, %(rights_count) rights to study found without required information to grant access to the graduate survey. Please contact your study office for further information'
  }
};

export default localizations_en;
