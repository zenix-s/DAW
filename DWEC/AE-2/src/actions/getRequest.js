/**
 * Un objeto que contiene los datos de una request tipo get a una url usando el asset recibido por los parameetros
 * Se crea una promesa la cual se resuelve cuando se han conseguido los datos de la request status 200
 * @param {object} 
 * @returns el objeto con los datos de la request tipo get a la url y asset requerido
 */
export function getRequest(asset) {
  const url = "http://127.0.0.1:5500/AE-2";

  return new Promise((resolve, reject) => {
    const xhr = new XMLHttpRequest();

    xhr.open("GET", url + asset, true);

    xhr.onreadystatechange = () => {
      if (xhr.readyState == 4) {
        if (xhr.status >= 200 && xhr.status <= 299) {
          resolve(JSON.parse(xhr.responseText));
        } else {
          reject(new Error(xhr.statusText));
        }
      }
    };

    xhr.send();
  });
}

