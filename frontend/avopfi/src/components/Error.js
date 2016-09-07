import React from 'react';
import Translate from 'react-translate-component';

import LocalizedImage from './common/localizedimage/localizedimage';

export default class Error extends React.Component {

  render() {
    var status = this.props.params.status;
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
              <Translate component="h1" content="errors.title"/>
              {status === 'haka_error' ?
                <Translate component="p" content="errors.haka_error"/> :
                <Translate component="p" content="errors.general_error"/>}
            </div>
          </div>
        </section>

      </div>
    )
  }
}
