require('./localeswitcher.scss');

import React from 'react';
import {Link} from 'react-router';

export default class LocaleSwitcher extends React.Component {
  extractPathElement() {
    let matches = this.props.location.pathname
      .match(/^\/([a-z]+)\/(.*)\/(.*)$/);
    console.log("MATCHES:" + matches)
    return matches ? '/' + matches[3] : '';
  }

  render() {
    let path = this.extractPathElement();
    let wp = lang => '/rekrykysely/' + lang + (path !== undefined ? path : '');
    return (
      <div id="languages">
        <Link className="language-selection" to={wp('fi')}>Suomeksi</Link>
        <Link className="language-selection" to={wp('sv')}>På Svenska</Link>
        <Link className="language-selection" to={wp('en')}>In English</Link>
      </div>
    );
  }
}

