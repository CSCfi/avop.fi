import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter, Redirect, Route} from 'react-router-dom';
import './index.css';
import Main from './components/Main';
import reportWebVitals from './reportWebVitals';

let browserLanguage = window.navigator.userLanguage || window.navigator.language;
if (browserLanguage.indexOf('en') === 0) {
  browserLanguage = 'en';
} else if (browserLanguage.indexOf('sv') === 0) {
  browserLanguage = 'sv';
} else {
  browserLanguage = 'fi';
}

ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter>
      <Route path="/" exact>
        <Redirect exact from="/" to={'/' + browserLanguage}/>
      </Route>
      <Route path="/:lang" component={Main}/>
    </BrowserRouter>,
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
