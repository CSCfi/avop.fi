import React from 'react';
import {Link} from 'react-router-dom';
import './localeswitcher.scss';


export default class LocaleSwitcher extends React.Component {
  extractPathElement() {
    let matches = this.props.location.pathname
      .match(/^\/([a-z]+)\/(.*)$/);
    return matches ? '/' + matches[2] : '';
  }

  render() {
    let path = this.extractPathElement();
    let wp = lang => '/' + lang + path;
    return (
      <div id="languages">
        <Link className="language-selection" to={wp('fi')}>Suomeksi</Link>
        <Link className="language-selection" to={wp('sv')}>På Svenska</Link>
        <Link className="language-selection" to={wp('en')}>In English</Link>
      </div>
    );
  }
}

