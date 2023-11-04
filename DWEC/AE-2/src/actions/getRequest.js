export function getRequest(asset, callback) {
  const url = "http://127.0.0.1:5500";
  const xhr = new XMLHttpRequest();

  xhr.open("GET", url + asset, true);

  xhr.onreadystatechange = () => {
    if (xhr.readyState == 4 && xhr.status == 200) {
      const response = JSON.parse(xhr.responseText);
      callback(response);
    }
  };

  xhr.send();
}
