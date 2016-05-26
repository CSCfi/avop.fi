require('./localizedthemeimage.scss');

import React from 'react';
import translate from 'counterpart';

export default class LocalizedBackgroundImage extends React.Component {

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
    return React.createElement('div', {id: 'theme', className: this.state.locale});
  }
}

