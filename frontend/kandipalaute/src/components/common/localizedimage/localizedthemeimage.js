import React from 'react';
import translate from 'counterpart';
import './localizedthemeimage.scss'

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
    let alt = (this.props.alt !== undefined) ? translate.translate(this.props.alt) : null;
    return React.createElement('div', {id: 'theme', role: 'img', aria_label: alt, className: this.state.locale});
  }
}

