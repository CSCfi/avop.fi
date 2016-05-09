import React from 'react';
import translate from 'counterpart';
import imageUrls from './localizedimageurls';

export default class LocalizedImage extends React.Component {

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
    let img = imageUrls[this.state.locale][this.props.image];
    return React.createElement('img', {src: img});
  }
}
