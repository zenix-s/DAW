let ingridients = {};
let sizes = {};

function hacerSolicitud(asset, callback) {
  const url = "http://127.0.0.1:5500";
  var xhr = new XMLHttpRequest();

  xhr.open("GET", url + asset, true);

  xhr.onreadystatechange = () => {
    if (xhr.readyState == 4 && xhr.status == 200) {
      var respuesta = JSON.parse(xhr.responseText);
      callback(respuesta);
    }
  };

  xhr.send();
}

function componentIngredient({ name }) {
  const inputContainer = document.createElement("div");
  const input = document.createElement("input");
  input.type = "checkbox";
  input.setAttribute("name", "ingridient");
  input.setAttribute("value", name);
  const label = document.createElement("label");

  label.textContent = name;

  inputContainer.appendChild(label);
  inputContainer.appendChild(input);

  return inputContainer;
}

function componentSize({ name }) {
  const inputContainer = document.createElement("div");
  const input = document.createElement("input");
  input.type = "radio";
  input.setAttribute("name", "size");
  input.setAttribute("value", name);
  input.setAttribute("required", true)
  const label = document.createElement("label");

  label.textContent = name;

  inputContainer.appendChild(input);
  inputContainer.appendChild(label);

  return inputContainer;
}
function main() {
  const checkboxContainer = document.getElementById("checkboxcontainer");
  const radioContainer = document.getElementById("radioContainer");

  const asset = "/assets/json/pizza.json";
  hacerSolicitud(asset, function (datos) {
    datos.toppings.map((topping) => {
      ingridients[topping.name] = topping.price;
      checkboxContainer.appendChild(
        componentIngredient({ name: topping.name })
      );
    });
    datos.size.map((size) => {
      sizes[size.name] = size.price;
      radioContainer.appendChild(
        componentSize({name:size.name})
      )
    });
  });
}

main();
