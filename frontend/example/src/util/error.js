import {browserHistory} from 'react-router';
import request from './request'


function jslog(sessionId, err){
  request('/api/log', {
    method: 'post',
    credentials: 'same-origin',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({sessionid: sessionId,
      message: err,
      level: 'error'})
  })
}

export function handleError(lang, obj){

  const status = obj['error'] ? obj['error'] : 'general_error';
  const sessionId = obj['sessionid'] ? obj['sessionid'] : '';

  if(sessionId){
    jslog(sessionId, JSON.stringify(obj));
  }

  browserHistory.push(`/${lang}/error/${status}/${sessionId}`)
}
