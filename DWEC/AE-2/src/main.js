import { getRequest } from "./actions/getRequest.js";
import Pizza from "./class/pizza.js";

/**
 * 
 * @param {name, price} O Un objeto con el nombre y precio del ingrediente
 * @returns HTMLElement El elemento html que compone el input y el label de ingrediente
 */
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

/**
 * 
 * @param {name, price} p Nombre y precio del tamaño 
 * @returns HTMLElement El elemento html que lleva el input para el size
 */
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

/**
 * Hace una llamada a la clase pizza
 * @param {String} size 
 * @param {String[]} ingridients 
 * @returns Int el precio de la pizza 
 */
async function getPizzaPrice(size, ingridients) {
  const pizza = new Pizza(size, ingridients);
  return await pizza.checkPrice();
}
function cleanElement(id) {
  const element = document.getElementById(id);

  if (element) {
    while (element.firstChild) {
      element.removeChild(element.firstChild);
    }
  }
}


function loadData(datos) {
  const checkboxContainer = document.getElementById("checkboxcontainer");
  const radioContainer = document.getElementById("radioContainer");
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
}

/**
 * La función main Carga los datos y los event listeners para calcular el precio y reiniciar los datos
 */
async function main() {
  
  const asset = "/assets/json/pizza.json";
  const datos = await getRequest(asset);
  loadData(datos);

  const form = document.getElementById("pizzaForm");

  const rebootButton = document.getElementById("rebootButton");


  // Ejecuta el codigo para reiniciar todos los datos del formulario
  rebootButton.addEventListener("click", async (e) => {
    e.preventDefault();
    const ingridientsSpan = document.getElementById("ingridientsSpan");
    const sizeSpan = document.getElementById("sizeSpan");
    const priceSpan = document.getElementById("priceSpan");
    const nombrespan = document.getElementById("inputNombre")
    const direccionspan = document.getElementById("inputDireccion")
    const telefonospan = document.getElementById("inputTelefono")
    const emailspan = document.getElementById("inputEmail")

    nombrespan.value = ""
    direccionspan.value = ""
    telefonospan.value = ""
    emailspan.value = ""


    cleanElement("radioContainer");
    cleanElement("checkboxcontainer");
    ingridientsSpan.textContent = "";
    sizeSpan.textContent = "";
    priceSpan.textContent = "";
    const asset = "/assets/json/pizza.json";
    const datos = await getRequest(asset);
    loadData(datos);



  });

  // Se ejecuta al querer comprobar el precio de la pizza
  form.addEventListener("submit", async (e) => {
    e.preventDefault();
    const ingridientsSpan = document.getElementById("ingridientsSpan");
    ingridientsSpan.textContent = "";
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
      ingridientsSpan.textContent =
        ingridientsSpan.textContent +
        (ingridientsSpan.textContent == "" ? "" : ", ") +
        ingridient;
    });
  });
}

main();
