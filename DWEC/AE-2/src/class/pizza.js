import { getRequest } from "../actions/getRequest.js";
export default class Pizza {
  constructor(size, ingridients) {
    this.size = size;
    this.ingridients = ingridients;
  }

  /**
   * calcula el precio de la pizza basado en los datos requeridos por el get en la llamada al asset pizza.json
   * @returns {int} precio de la pizza
   */
  async checkPrice() {
    const asset = "/assets/json/pizza.json";
    let price = 0;
    const datos = await getRequest(asset);
    let ingridients = {};
    let sizes = {};
    datos.toppings.map((topping) => {
      ingridients[topping.name] = topping.price;
    });
    datos.size.map((size) => {
      sizes[size.name] = size.price;
    });
    price = price + sizes[this.size];
    this.ingridients.forEach((ing) => {
      price = price + ingridients[ing];
    });
    return price;
  }
}
