require('./content.scss');

import React from 'react';
import config from 'config';
import translate from 'counterpart';
import Translate from 'react-translate-component';
import LocalizedThemeImage from '../common/localizedimage/localizedthemeimage';
import LocalizedImage from '../common/localizedimage/localizedimage';

let hakaLoginImage = require('../../images/Haka_login_vaaka_lg.jpg');

export default class Content extends React.Component {

  constructor(props) {
    super(props);

    this.state = {
      locale: translate.getLocale()
    };
  }

  extractCurrentDomain() {
    return window.location.protocol + '//' +
      window.location.hostname +
      ((window.location.port === '') ? '' : ':' + window.location.port);
  }

  componentDidMount() {
    translate
      .onLocaleChange(this.localeChanged.bind(this));
  }

  localeChanged(newLocale) {
    this.setState({locale: newLocale});
  }

  render() {
    const link = <a href={translate.translate('content.tulokset.link1.url')}>{translate.translate('content.tulokset.link1.text')}</a>;
    return (
      <div>
        <LocalizedThemeImage />

        <section id="login">
          <div className="container">
            <div className="row">

              <div id="haka-login">
                <Translate component="h4" content="content.login.header"/>
                <Translate component="p" content="content.login.description"/>
              </div>

              <div id="haka" className="centered" onClick={this.login}>
                <a href={config.hakaLoginUrl(this.extractCurrentDomain(), this.props.params.lang)}>
                  <img src={hakaLoginImage} alt="haka-login"/>
                </a>
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
                <p><a href={'./privacy_'+this.state.locale+'.pdf'}> <Translate component="span" content="content.kysely.privacy"/></a></p>
              </div>
              <div className="u-full-width"><Translate component="h4" content="content.tulokset.header"/></div>
              <div className="u-full-width"><Translate component="p" content="content.tulokset.results1"/></div>
              <div className="u-full-width"><Translate link={link} component="p" content="content.tulokset.results2"/></div>
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
