import React from 'react';
import ReactDOM from 'react-dom';
import {Route, Redirect, BrowserRouter,} from 'react-router-dom';
import './index.css';
import Main from './components/Main';
import * as serviceWorker from './serviceWorker';

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
  <React.StrictMode>
    <BrowserRouter basename="/rekrykysely">
      <Route path="/" exact>
        <Redirect exact from="/" to={'/' + browserLanguage}/>
      </Route>
      <Route path="/:lang" component={Main}/>
    </BrowserRouter>,
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
