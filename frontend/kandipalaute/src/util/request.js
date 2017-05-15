import fetch from 'isomorphic-fetch';

function parseJSON(response) {
  return new Promise((resolve) => response.json()
    .then((json) => resolve({
      status: response.status,
      ok: response.ok,
      json
    })));
}

export default function request(url, options) {
  return new Promise((resolve, reject) => {
    fetch(url, options)
      .then(parseJSON)
      .then((response) => {
        if (response.ok) {
          return resolve(response.json);
        }
        // extract the error from the server's json
        return reject(
          {
            status: response.status,
            json: response.json})
      })
      .catch((error) => reject({
        networkError: error.message
      }));
  });
}
