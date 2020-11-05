import React from 'react';
import Translate from 'react-translate-component';
import LocalizedImage from '../common/localizedimage/localizedimage'
import request from '../../util/request'
import {handleError} from '../../util/error.js'

export default class Userprofile extends React.Component {
  constructor(props) {
    super(props);
    this.history = props.history
  }

  async componentDidMount() {
    let hasStorage = 'sessionStorage' in window && window.sessionStorage;
    let key = 'opiskeluoikeudet';
    let data = hasStorage ? sessionStorage.getItem(key) : null;

    if (hasStorage && data) {
      let now = new Date();
      let expiration = new Date(data.timestamp);
      expiration.setMinutes(expiration.getMinutes() + 15);
      if (now.getTime() > expiration.getTime()) {
        data = null;
        sessionStorage.removeItem(key);
      }
    }
    try {
      const registration = await request('/api/rekry', {
        method: 'post',
        credentials: 'same-origin',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }});
      if (registration['kysely_url']) {
        window.location = registration['kysely_url'];
      } else {
        handleError(this.props.match.params.lang, registration, this.history);
      }
    } catch(e) {
      handleError(this.props.match.params.lang, e.json, this.history);
    }
  }


  static headerImages() {
    return(
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

          </div>
        </div>
      </section>
    )
  }

  render() {
    return (
      <div>
        {Userprofile.headerImages()}
        <section id="userprofile">
          <div className="container">
            <div className="row">
              <div className="u-full-width"><Translate component="h4" content="profiledata.header"/></div>
            </div>
          </div>
        </section>
      </div>
    )
  }

}
