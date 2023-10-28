export default class Pizza{
  constructor(
    size,
    ingridients,
  ){
    this.size = size
    this.ingridients = ingridients
  }

  /**
   * 
   * @returns {int} precio de la pizza
   */
  checkPrice(){
    const price = 0 + (this.size * 5) + this.ingridients
    
    return price
  }
}