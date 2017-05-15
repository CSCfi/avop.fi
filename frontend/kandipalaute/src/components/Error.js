import React from 'react';
import Translate from 'react-translate-component';

import LocalizedImage from './common/localizedimage/localizedimage';

export default class Error extends React.Component {

  render() {
    const status = this.props.params.status;
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
              <Translate component="p" content={"errors."+status}/>
            </div>
          </div>
        </section>

      </div>
    )
  }
}
