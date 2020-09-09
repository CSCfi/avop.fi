'use strict';

// Settings configured here will be merged into the final config object.
export default {
  hakaLoginUrl: (currentDomain, lang) => `/rekrykysely/Shibboleth.sso/Login?target=${currentDomain}/rekrykysely/${lang}/user`
}
