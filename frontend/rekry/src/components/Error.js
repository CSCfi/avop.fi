import React from 'react';
import Translate from 'react-translate-component';

import LocalizedImage from './common/localizedimage/localizedimage';

export default class Error extends React.Component {

  render() {
    const status = this.props.match.params.status ? this.props.match.params.status : 'general_error';
    const sessionid = this.props.match.params.sessionid;
    const showSessionId = sessionid && (status === 'general_error' || status === 'arvo_error');

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

            </div>
          </div>
        </section>

        <section>
          <div className="container">
            <div className="row">
              <Translate component="h1" content='errors.title'/>
              <Translate component="p" content={'errors.'+ status}/>
              {showSessionId ?
                <p><Translate component="text" content='errors.attach_code'/>: <strong>{sessionid}</strong></p> : ''
              }
            </div>
          </div>
        </section>

      </div>
    )
  }
}
