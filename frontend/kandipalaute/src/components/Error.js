import React from 'react';
import Translate from 'react-translate-component';

import LocalizedThemeImage from './common/localizedimage/localizedthemeimage';

export default class Error extends React.Component {
  render() {
    const status = this.props.params.status ? this.props.params.status : 'general_error';
    return (
      <div>
        <section>
          <LocalizedThemeImage />
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

