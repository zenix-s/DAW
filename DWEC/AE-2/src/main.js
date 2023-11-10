import { getRequest } from "./actions/getRequest.js";
import Pizza from "./class/pizza.js";

function createIngredientComponent({ name, price }) {
  const inputContainer = document.createElement("div");
  const input = document.createElement("input");
  input.type = "checkbox";
  input.setAttribute("name", "ingridient");
  input.setAttribute("value", name);
  const label = document.createElement("label");

  label.textContent = name + " +" + price + "€";

  inputContainer.appendChild(input);
  inputContainer.appendChild(label);

  return inputContainer;
}

function createSizeComponent({ name, price }) {
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



async function getPizzaPrice(size, ingridients) {
  const pizza = new Pizza(size, ingridients);
  return await pizza.checkPrice();
}

async function main() {
  const checkboxContainer = document.getElementById("checkboxcontainer");
  const radioContainer = document.getElementById("radioContainer");
  const asset = "/assets/json/pizza.json";
  const datos = await getRequest(asset);
  console.log("datos" + datos);
  datos.toppings.map((topping) => {
    checkboxContainer.appendChild(
      createIngredientComponent({ name: topping.name, price: topping.price })
    );
  });
  datos.size.map((size) => {
    radioContainer.appendChild(
      createSizeComponent({ name: size.name, price: size.price })
    );
  });

  const form = document.getElementById("pizzaForm");

  form.addEventListener("submit", async (e) => {
    e.preventDefault();
    const ingridientsSpan = document.getElementById("ingridientsSpan");
    const sizeSpan = document.getElementById("sizeSpan");
    const priceSpan = document.getElementById("priceSpan");
    const ingridients = Array.from(
      document.querySelectorAll("input[type='checkbox'][name='ingridient']")
    )
      .filter((check) => check.checked)
      .map((check) => check.value);
    const size = document.querySelector(
      "input[type='radio'][name='size']:checked"
    ).value;

    const price = await getPizzaPrice(size, ingridients);

    priceSpan.textContent = price;
    sizeSpan.textContent = size;
    ingridients.forEach((ingridient) => {
      ingridientsSpan.textContent = ingridientsSpan.textContent + (ingridientsSpan.textContent == "" ? "" : ", ") + ingridient
    });
  });
}

main();
