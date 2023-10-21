import Pizza from "./classes/pizza.js";
import InputComponent from "./classes/inputComponent.js";




const main = document.getElementById("main");

function init(){
  const titulo = document.createElement("h1")
  titulo.textContent = "AE-1. DOM y Formularios "
  main.appendChild(titulo)
}

function req1() {

  const inputComponent = new InputComponent()


  const requerimiento1 = document.createElement("section")
  const requerimiento1titulo = document.createElement("h2")
  requerimiento1titulo.textContent = "Requerimiento 1"
  requerimiento1.appendChild(requerimiento1titulo)
  requerimiento1.id = "Requerimiento1"

  main.appendChild(requerimiento1)

  const form = document.createElement("form")
  requerimiento1.appendChild(form)


  form.appendChild(inputComponent.inputContainer("text","Nombre","inputNombreReq1"))
  form.appendChild(inputComponent.inputContainer("text","Apellidos","inputApellidosReq1"))
  form.appendChild(inputComponent.inputContainer("text","Dni","inputDniReq1"))
  form.appendChild(inputComponent.inputContainer("text","Direccion","inputDireccionReq1"))
  form.appendChild(inputComponent.inputContainer("text","Telefono","inputTelefonoReq1"))
  
  form.appendChild(inputComponent.inputContainer("radio","Genero","inputRadioGeneroReq1", [
    {
      value: "hombre",
      label: "Hombre",
    },
    {
      value: "mujer",
      label: "Mujer",
    },
    {
      value: "no",
      label: "No",
    },
    {
      value: "other",
      label: "Otro",
    },
  ]))

  form.appendChild(inputComponent.inputContainer("radio","Options","inputRadioOptionsReq1", [
    {
      value: "Option1",
      label: "Option",
    },
    {
      value: "Option2",
      label: "Option",
    },
    {
      value: "Option3",
      label: "Option",
    },
    {
      value: "Option4",
      label: "Option",
    },
  ]))

  const checkboxContainer = document.createElement("div")

  form.appendChild(checkboxContainer)

  checkboxContainer.appendChild(inputComponent.inputContainer("checkbox", "CheckBox", "inputCheckbox1Req1"))
  checkboxContainer.appendChild(inputComponent.inputContainer("checkbox", "CheckBox", "inputCheckbox1Req1"))
  checkboxContainer.appendChild(inputComponent.inputContainer("checkbox", "CheckBox", "inputCheckbox1Req1"))
  checkboxContainer.appendChild(inputComponent.inputContainer("checkbox", "CheckBox", "inputCheckbox1Req1"))
  checkboxContainer.appendChild(inputComponent.inputContainer("checkbox", "CheckBox", "inputCheckbox1Req1"))

  form.appendChild(inputComponent.inputContainer("select","Options","inputSelectOptionsReq1", [
    {
      value: "Option1",
      label: "Option",
    },
    {
      value: "Option2",
      label: "Option",
    },
    {
      value: "Option3",
      label: "Option",
    },
    {
      value: "Option4",
      label: "Option",
    },
  ]))

  form.appendChild(inputComponent.inputContainer("textarea", "TextArea", "inputTextArea1Req1"))



}

/**
 * Calcula el precio de la pizza
 */
function checkPizzaPrice(size, ingridients){

  const pizza = new Pizza(size, ingridients)

  const precio = pizza.checkPrice();
  
  return precio
  
}

/**
 * Se encarga de generar el formulario para pedir pizza.
 * 
 */
function req2(){


  const inputComponent = new InputComponent()


  const requerimiento2 = document.createElement("section")
  requerimiento2.id = "Requerimiento2"
  const requerimiento2titulo = document.createElement("h2")
  requerimiento2titulo.textContent = "Requerimiento 2"
  requerimiento2.appendChild(requerimiento2titulo)

  main.appendChild(requerimiento2)

  const form = document.createElement("form")
  
  





  requerimiento2.appendChild(form)

  

  form.appendChild(inputComponent.inputContainer("text","Nombre","inputNombreReq2"))
  form.appendChild(inputComponent.inputContainer("text","Direccion","inputDireccionReq2"))
  form.appendChild(inputComponent.inputContainer("text","Telefono","inputTelefonoReq2"))
  form.appendChild(inputComponent.inputContainer("text","Email","inputEmailReq2"))

  form.appendChild(
    inputComponent.inputContainer("radio","Tamaño","inputSizeReq2", [
      {
        value: "1",
        label: "Pequeña",
      },
      {
        value: "2",
        label: "Mediana",
      },
      {
        value: "3",
        label: "Grande",
      },
    ])
  );

  const checkboxContainer = document.createElement("div")

  form.appendChild(checkboxContainer)
  
  checkboxContainer.appendChild(inputComponent.inputContainer("checkbox","Pollo","inputPolloReq2"));
  checkboxContainer.appendChild(inputComponent.inputContainer("checkbox","Atun","inputAtunReq2"));
  checkboxContainer.appendChild(inputComponent.inputContainer("checkbox","Bacon","inputBaconReq2"));

  form.appendChild(inputComponent.inputContainer("submit","Submit","inputSubmitReq2"))

  form.addEventListener("submit", (e) => {
    e.preventDefault()
    
    const data = new FormData(e.target)

    const size = data.get("inputSizeReq2")

    const ingridients =   ((data.get("inputPolloReq2") === "on") ? 1 : 0) + ((data.get("inputAtunReq2") === "on") ? 1 : 0) + ((data.get("inputBaconReq2") === "on") ? 1 : 0)
  
    

    alert(checkPizzaPrice(size, ingridients))
  })


}



init();
req1();
req2();