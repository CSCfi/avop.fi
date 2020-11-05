import React from 'react';
import Translate from 'react-translate-component';

import LocalizedThemeImage from './common/localizedimage/localizedthemeimage';

export default class Error extends React.Component {

  render() {
    const status = this.props.match.params.status ? this.props.match.params.status : 'general_error';
    const sessionid = this.props.match.params.sessionid;
    const showSessionId = sessionid && (status === 'general_error' || status === 'arvo_error');

    return (
      <div>
        <section>
          <LocalizedThemeImage />
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

