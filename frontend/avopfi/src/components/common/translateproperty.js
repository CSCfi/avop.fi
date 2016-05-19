import React from 'react';
import translate from 'counterpart';

export default class TranslateProperty extends React.Component {
  static defaultLang = 'fi';

  static defaultProps = {
    component: 'span'
  };

  constructor(props) {
    super(props);
    this.state = {
      locale: this.getTranslator().getLocale()
    };
  }

  componentDidMount() {
    this.getTranslator()
      .onLocaleChange(this.localeChanged.bind(this));
  }

  getTranslator() {
    return translate;
  }

  localeChanged(newLocale) {
    this.setState({locale: newLocale});
  }

  render() {
    let str = this.props.data[this.state.locale];
    if (str === undefined) {
      str = this.props.data[TranslateProperty.defaultLang];
    }
    return React.createElement(this.props.component,
      this.props, str);
  }
}

