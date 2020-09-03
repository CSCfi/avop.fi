import React from 'react';
import {browserHistory} from 'react-router';
import Translate from 'react-translate-component';
import TranslateProperty from '../common/translateproperty';
import LocalizedImage from '../common/localizedimage/localizedimage'
import request from '../../util/request'
import {handleError} from '../../util/error.js'

require('es6-promise').polyfill();
require('array.prototype.find').shim();

export default class Userprofile extends React.Component {
  constructor(props) {
    super(props);
    this.state = {selectedOppilaitos: this.props.oppilaitokset[0]};
  }

  static loadProps(params, cb) {
    let hasStorage = 'sessionStorage' in window && window.sessionStorage;
    let key = 'opiskeluoikeudet';
    let data = hasStorage ?
      sessionStorage.getItem(key) : null;

    if (hasStorage && data) {
      let now = new Date();
      let expiration = new Date(data.timestamp);
      expiration.setMinutes(expiration.getMinutes() + 15);
      if (now.getTime() > expiration.getTime()) {
        data = null;
        sessionStorage.removeItem(key);
      }
    }

    request('/api/rekry', {
      method: 'post',
      credentials: 'same-origin',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }})
      .then(registration => {
        const kysely_url = registration['kysely_url'];
        const oppilaitokset = registration['oppilaitokset'];
        const sessionid = registration['sessionid'];

        if(kysely_url){
          window.location = kysely_url;
        }
        else if(registration['oppilaitokset']){
          cb(null, {oppilaitokset, sessionid});
        }
        else {
          handleError(this.props.params.lang, registration);
        }
      })
      .catch(e => {
        handleError(params.params.lang, e.json)});
  }

  onSubmit(event) {
    event.preventDefault();
    let data = {
      oppilaitos: this.state.selectedOppilaitos.oppilaitoskoodi,
      kieli: this.props.params.lang,
      tyyppi: 'rekry'
    };
    request('/api/rekry/valitse-oppilaitos', {
      method: 'post',
      credentials: 'same-origin',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    })
      .then(registration => {
        if(registration['kysely_url']){
          window.location = registration['kysely_url']
        } else {
          handleError(this.props.params.lang, registration)
        }
      })
      .catch(e => this.onError(e));
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

  selectOppilaitos(event) {
    this.setState({
      selectedOppilaitos: this.props.oppilaitokset
        .find(x => x.oppilaitoskoodi === event.target.value)
    });
  }

  render() {
    return (
      <div>
        {Userprofile.headerImages()}
        <section id="userprofile">
          <div className="container">
            <div className="row">
              <div className="u-full-width"><Translate component="h4" content="profiledata.header"/></div>
              <div className="u-full-width"><Translate component="p" content="profiledata.about"/></div>
              <form onSubmit={this.onSubmit.bind(this)}>
                {(this.props.oppilaitokset.length > 1) ?
                  <select onChange={this.selectOppilaitos.bind(this)}
                          value={this.state.selectedOppilaitos.oppilaitoskoodi}>
                    {
                      this.props.oppilaitokset.map(oppilaitos =>
                        <TranslateProperty component="option"
                                           value={oppilaitos.oppilaitoskoodi}
                                           data={oppilaitos}>
                        </TranslateProperty>
                      )
                    }
                  </select>
                  : ''
                }
                <div className="u-full-width">
                  <button type="submit">
                    <Translate component="span" content="profiledata.submit"></Translate>
                  </button>
                </div>
              </form>

            </div>
          </div>
        </section>
      </div>
    )
  }
}
