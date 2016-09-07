import React from 'react';
import Translate from 'react-translate-component';
import Footer from './footer/footer';
import Header from './header/header';

export default class Error extends React.Component {
  render() {
    var status = this.props.params.status;
    return (
      <div>
        <Header></Header>

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

        <Footer></Footer>
      </div>
  )
  }
}
