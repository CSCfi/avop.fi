import React from 'react';
import Header from './header/Header';
import Footer from './footer/Footer';
import counterpart from 'counterpart';

import localizations_fi from '../localizations/localizations_fi';
import localizations_en from '../localizations/localizations_en';
import localizations_sv from '../localizations/localizations_sv';
import {Route, Switch} from "react-router-dom";
import Home from "./home/Home";
import Userprofile from "./user/userprofile";
import Error from "./Error";

import 'react-skeleton-css/styles/skeleton.2.0.4.css';
import 'react-skeleton-css/styles/normalize.3.0.2.css';
import './main.scss';

class AppComponent extends React.Component {

  constructor(props) {
    super(props);
    counterpart.registerTranslations('fi', localizations_fi);
    counterpart.registerTranslations('en', localizations_en);
    counterpart.registerTranslations('sv', localizations_sv);
    this.setLocale();
  }

  setLocale() {
    if (this.props.match.params.lang) {
      if (this.props.match.params.lang.indexOf('en') === 0 ) {
        counterpart.setLocale('en');
      } else if (this.props.match.params.lang.indexOf('sv') === 0 ) {
        counterpart.setLocale('sv');
      } else {
        counterpart.setLocale('fi');
      }
    }
  }

  componentDidUpdate() {
    this.setLocale();
  }

  render() {
    return (
      <div>
        <Header {...this.props}/>
        <div>
          <Switch>
            <Route exact path="/:lang" component={Home} />
            <Route path="/:lang/user" component={Userprofile}/>
            <Route path="/:lang/error/:status" component={Error}/>
            <Route component={Error}/>
          </Switch>
        </div>
        <Footer/>
      </div>
    )
  }
}

export default AppComponent;

