import Translate from 'react-translate-component';
import LocalizedImage from '../common/localizedimage/localizedimage';

import './footer.scss';

let Footer = () =>
  <footer className="container">
    <div className="row">
      <div className="u-full-width">
        <Translate component="h4" content="footer.header"/>
      </div>

    </div>
    <div className="row">
      <div className="one-third column okm">
        <LocalizedImage image="OKM_logo" alt="footer.okm.logo_alt" />
      </div>

      <div className="one-third column csc">
        <LocalizedImage image="CSC" alt="footer.csc.logo_alt"/>
      </div>
    </div>

    <div className="row">
      <div className="one-third column">
        <Translate component="p" content="footer.okm.description"/>
      </div>
      <div className="one-third column">
        <Translate component="div" content="footer.csc.description"/>
        <span>arvo@csc.fi</span>
      </div>
    </div>

  </footer>;

export default Footer;
