require('./header.scss');

import React from 'react';
import LocaleSwitcher from './../common/localeswitcher/localeswitcher';

export default class Header extends React.Component {

  render() {
    return (
      <header>
        <div className="container">
          <div className="row">
            <div className="u-full-width">
              <LocaleSwitcher {...this.props}></LocaleSwitcher>
            </div>
          </div>
        </div>
      </header>
    );
  }
}
