require('./content.scss');

import React from 'react';
import config from 'config';
import Translate from 'react-translate-component';
import LocalizedImage from '../common/localizedimage/localizedimage';

let hakaLoginImage = require('../../images/Haka_login_vaaka_lg.jpg');

export default class Content extends React.Component {

  constructor(props) {
    super(props);
  }

  extractCurrentDomain() {
    return window.location.protocol + '//' +
      window.location.hostname +
      ((window.location.port === '') ? '' : ':' + window.location.port);
  }

  render() {
    return (
      <div>
        <section id="theme">
          <div className="container">
            <div className="row">

              <div className="six columns">
                <div className="u-full-width">
                  <div id="logo">
                    <LocalizedImage image="logo" />
                  </div>
                </div>
              </div>

              <div className="six columns">
                <div className="u-full-width">
                  <div id="haka-login">
                    <Translate component="h4" content="content.login.header"/>
                    <Translate component="p" content="content.login.description"/>
                    <div id="haka" onClick={this.login}>
                      <a href={config.hakaLoginUrl(this.extractCurrentDomain(), this.props.params.lang)}>
                        <img src={hakaLoginImage} alt="haka-login"/>
                      </a>
                    </div>
                  </div>
                </div>
              </div>

            </div>
          </div>
        </section>

        <section id="main_content">
          <div className="container">
             <div className="row">
              <div className="u-full-width"><Translate component="h4" content="content.kysely.information"/></div>
              <div className="u-full-width"><Translate component="p" content="content.kysely.about1"/></div>
              <div className="u-full-width"><Translate component="p" content="content.kysely.about2"/></div>
              <div className="u-full-width">
                <Translate component="p" content="content.kysely.about3"/>
              </div>
              <div className="u-full-width"><Translate component="h4" content="content.tulokset.header"/></div>
              <div className="u-full-width"><Translate component="p" content="content.tulokset.results1"/></div>
              <div className="u-full-width"><Translate component="p" content="content.tulokset.results2"/></div>
              <div className="u-full-width">
                <a href="https://vipunen.fi/" className="vipunen">
                  <LocalizedImage image="vipunen"/>
                </a>
              </div>

            </div>
          </div>
        </section>
      </div>
    );
  }
}
