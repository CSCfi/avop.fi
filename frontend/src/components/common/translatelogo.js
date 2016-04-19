import React from 'react';
import translate from 'counterpart';
let logo_fi = require('../../images/logo-fi.png');
let logo_en = require('../../images/logo-en.png');
let logo_sv = require('../../images/logo-sv.png');


export default class TranslateLogo extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      locale: translate.getLocale()
    };
  }

  componentDidMount() {
    translate
      .onLocaleChange(this.localeChanged.bind(this));
  }

  localeChanged(newLocale) {
    this.setState({locale: newLocale});
  }

  render() {
    let img = logo_fi;

    if(this.state.locale === 'en') {
      img = logo_en;
    } else if(this.state.locale === 'sv') {
      img = logo_sv;
    }

    return React.createElement('img', {src: img, alt: 'Avop'});
  }
}
