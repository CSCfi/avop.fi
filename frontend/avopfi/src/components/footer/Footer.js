import React from 'react';
import Translate from 'react-translate-component';
import LocalizedImage from '../common/localizedimage/localizedimage';
import './footer.scss';


import arene_logo from '../../images/arene.png';

let Footer = () =>
  <footer className="container">
    <div className="row">
      <div className="u-full-width">
        <Translate component="h4" content="footer.header"/>
      </div>

    </div>
    <div className="row">
      <div className="one-third column arene">
        <img className="img-arene" src={arene_logo} alt="Arene Ry"/>
      </div>

      <div className="one-third column okm">
        <LocalizedImage image="OKM_logo" />
      </div>

      <div className="one-third column csc">
        <LocalizedImage image="CSC" />
      </div>
    </div>

    <div className="row">
      <div className="one-third column">
        <Translate component="p" content="footer.arene.description"/>
      </div>
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
