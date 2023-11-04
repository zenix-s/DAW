import { getRequest } from "./actions/getRequest.js";
import Pizza from "./class/pizza.js";


function componentIngredient({ name, price }) {
  const inputContainer = document.createElement("div");
  const input = document.createElement("input");
  input.type = "checkbox";
  input.setAttribute("name", "ingridient");
  input.setAttribute("value", name);
  const label = document.createElement("label");

  label.textContent = name + " +" + price + "€";

  inputContainer.appendChild(label);
  inputContainer.appendChild(input);

  return inputContainer;
}

function componentSize({ name, price }) {
  const inputContainer = document.createElement("div");
  const input = document.createElement("input");
  input.type = "radio";
  input.id = "pizzaSize";
  input.setAttribute("name", "size");
  input.setAttribute("value", name);
  input.setAttribute("required", true);
  const label = document.createElement("label");

  label.textContent = name + " +" + price + "€";

  inputContainer.appendChild(input);
  inputContainer.appendChild(label);

  return inputContainer;
}

/**
 *
 */
window.addEventListener("load", () => {
  const checkboxContainer = document.getElementById("checkboxcontainer");
  const radioContainer = document.getElementById("radioContainer");

  const asset = "/assets/json/pizza.json";
  getRequest(asset, function (datos) {
    datos.toppings.map((topping) => {
      checkboxContainer.appendChild(
        componentIngredient({ name: topping.name, price: topping.price })
      );
    });
    datos.size.map((size) => {
      radioContainer.appendChild(
        componentSize({ name: size.name, price: size.price })
      );
    });
  });
});

function main() {
  const form = document.getElementById("pizzaForm");
  form.addEventListener("submit", (e) => {
    e.preventDefault();
    const ingridients = Array.from(
      document.querySelectorAll("input[type='checkbox'][name='ingridient']")
    )
      .filter((check) => check.checked)
      .map((check) => check.value);
    const size = document.querySelector(
      "input[type='radio'][name='size']:checked"
    ).value;

    const pizza = new Pizza(size, ingridients);
    console.log(pizza.checkPrice());
  });
}

main();
