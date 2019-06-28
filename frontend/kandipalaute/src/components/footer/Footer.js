require('./footer.scss');

import React from 'react';
import Translate from 'react-translate-component';
import LocalizedImage from '../common/localizedimage/localizedimage';

let unifi_logo = require('../../images/Unifi_logo_scaled.png');

let Footer = () =>
  <footer className="container">
    <div className="row">
      <div className="u-full-width">
        <Translate component="h4" content="footer.header"/>
      </div>

    </div>
    <div className="row">
      <div className="one-third column unifi">
        <img className="img-unifi" src={unifi_logo} alt="Unifi"/>
      </div>

      <div className="one-third column okm">
        <LocalizedImage image="OKM_logo" />
      </div>

      <div className="one-third column csc">
        <LocalizedImage image="CSC" />
      </div>
    </div>

    <div className="row">
      <div className="one-third column"><Translate component="p" content="footer.arene.description"/></div>
      <div className="one-third column"><Translate component="p" content="footer.okm.description"/></div>
      <div className="one-third column"><Translate component="div" content="footer.csc.description"/>
        <span>arvo@csc.fi</span></div>
    </div>
  </footer>;

export default Footer;
