import React from 'react';
import Translate from 'react-translate-component';

export default class Error extends React.Component {
  render() {
    return (
      <section>
        <div className="container">
          <div className="row">
            <Translate component="h1" content="errors.title"/>
            <Translate component="p" content="errors.general_error"/>
          </div>
        </div>
      </section>
    )
  }
}

