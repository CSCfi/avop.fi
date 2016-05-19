'use strict';

import baseConfig from './base';

let config = {
  appEnv: 'dev',
  hakaLoginUrl: (currentDomain, lang) => `${currentDomain}/${lang}/user`
};

export default Object.freeze(Object.assign({}, baseConfig, config));
