import React from 'react';
import LocaleSwitcher from '../common/localeswitcher/localeswitcher';
import './header.scss';


export default class Header extends React.Component {

  render() {
    return (
      <header>
        <div className="container">
          <div className="row">
            <div className="u-full-width">
              <LocaleSwitcher {...this.props}/>
            </div>
          </div>
        </div>
      </header>
    );
  }
}
