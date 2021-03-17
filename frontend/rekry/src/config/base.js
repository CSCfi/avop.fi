// Settings configured here will be merged into the final config object.
const config = {
  hakaLoginUrl: (currentDomain, lang) => `/Shibboleth.sso/Login?target=${currentDomain}/rekrykysely/${lang}/user`,
}

export default config;
