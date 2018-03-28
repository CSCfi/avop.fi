import 'core-js/fn/object/assign';
import React from 'react';
import ReactDOM from 'react-dom';
import {Router, Route, Redirect, IndexRoute, browserHistory} from 'react-router';
import AsyncProps from 'async-props'
import Main from './components/Main';
import Error from './components/Error';
import Userprofile from './components/user/userprofile';
import Home from './components/home/Home';
import Spinner from 'react-spin';

let browserLanguage = window.navigator.userLanguage || window.navigator.language;
if (browserLanguage.indexOf('en') === 0) {
  browserLanguage = 'en';
} else if (browserLanguage.indexOf('sv') === 0) {
  browserLanguage = 'sv';
} else {
  browserLanguage = 'fi';
}

// Render the main component into the dom
ReactDOM.render(
  <Router history={browserHistory} render={props =>
   <AsyncProps {...props}
    renderLoading={() => <Spinner/>} />}>
    <Redirect from="/" to={'/rekrykysely/' + browserLanguage}/>
    <Redirect from="/rekrykysely" to={'/rekrykysely/' + browserLanguage}/>
    <Route path="/rekrykysely/:lang" component={Main}>
      <IndexRoute component={Home}/>
      <Route path="user" component={Userprofile}/>
      <Route path="error/:status" component={Error}/>
      <Route path="*" component={Error}/>
    </Route>
  </Router>,
  document.getElementById('app')
);
