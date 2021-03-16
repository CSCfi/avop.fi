// Settings configured here will be merged into the final config object.
const config = {
  hakaLoginUrl: (currentDomain, lang) => `/rekrykysely/Shibboleth.sso/Login?target=${currentDomain}/rekrykysely/${lang}/user`,
}

export default config;
