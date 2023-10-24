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


  form.appendChild(inputComponent.inputContainer({inputType:"text",inputLabel:"Nombre",idName:"inputNombreReq1"}))
  form.appendChild(inputComponent.inputContainer({inputType:"text",inputLabel:"Dni",idName:"inputDniReq1"}))
  form.appendChild(inputComponent.inputContainer({inputType:"text",inputLabel:"Direccion",idName:"inputDireccionReq1"}))
  form.appendChild(inputComponent.inputContainer({inputType:"text",inputLabel:"Telefono",idName:"inputTelefonoReq1"}))

  form.appendChild(inputComponent.inputContainer({inputType:"radio",inputLabel:"Genero",idName:"inputRadioGeneroReq1", options:[
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
  ]}))

  form.appendChild(inputComponent.inputContainer({inputType:"radio",inputLabel:"Options",idName:"inputRadioOptionsReq1", options:[
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
  ]}))

  const checkboxContainer = document.createElement("div")

  form.appendChild(checkboxContainer)

  
  checkboxContainer.appendChild(inputComponent.inputContainer({inputType:"checkbox",inputLabel:"CheckBox",idName:"inputCheckbox1Req1"}))
  checkboxContainer.appendChild(inputComponent.inputContainer({inputType:"checkbox",inputLabel:"CheckBox",idName:"inputCheckbox21Req1"}))
  checkboxContainer.appendChild(inputComponent.inputContainer({inputType:"checkbox",inputLabel:"CheckBox",idName:"inputCheckbox3Req1"}))
  checkboxContainer.appendChild(inputComponent.inputContainer({inputType:"checkbox",inputLabel:"CheckBox",idName:"inputCheckbox4Req1"}))
  checkboxContainer.appendChild(inputComponent.inputContainer({inputType:"checkbox",inputLabel:"CheckBox",idName:"inputCheckbox5Req1"}))

  form.appendChild(inputComponent.inputContainer({inputType:"select",inputLabel:"Options",idName:"inputSelectOptionsReq1", options:[
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
  ]}))

  form.appendChild(inputComponent.inputContainer("textarea", "TextArea", "inputTextArea1Req1"))



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
  
  





  
  
  
  form.appendChild(inputComponent.inputContainer({inputType:"text",inputLabel:"Nombre",idName:"inputNombreReq2"}))
  form.appendChild(inputComponent.inputContainer({inputType:"text",inputLabel:"Direccion",idName:"inputDireccionReq2"}))
  form.appendChild(inputComponent.inputContainer({inputType:"text",inputLabel:"Telefono",idName:"inputTelefonoReq2"}))
  form.appendChild(inputComponent.inputContainer({inputType:"text",inputLabel:"Email",idName:"inputEmailReq2"}))
  
  form.appendChild(
    inputComponent.inputContainer({inputType:"radio",inputLabel:"Tamaño",idName:"inputSizeReq2",required:true , options:[
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
    ]})
    );
    
    const checkboxContainer = document.createElement("div")
    
    form.appendChild(checkboxContainer)
    
    checkboxContainer.appendChild(inputComponent.inputContainer({inputType:"checkbox",inputLabel:"Pollo",idName:"inputPolloReq2"}))
    checkboxContainer.appendChild(inputComponent.inputContainer({inputType:"checkbox",inputLabel:"Atun",idName:"inputAtunReq2"}))
    checkboxContainer.appendChild(inputComponent.inputContainer({inputType:"checkbox",inputLabel:"Bacon",idName:"inputBaconReq2"}))
    
    
    form.appendChild(inputComponent.inputContainer({inputType:"submit",inputLabel:"Submit",idName:"inputSubmitReq2"}))

    // price container
    const priceContainer = document.createElement("div")
    const priceLabel = document.createElement("p")
    priceLabel.textContent = "Precio de la pizza = 0€"

    
    form.addEventListener("submit", (e) => {
      e.preventDefault()
      
      const data = new FormData(e.target)
      
      const size = data.get("inputSizeReq2")
      
      const ingridients =   ((data.get("inputPolloReq2") === "on") ? 1 : 0) + ((data.get("inputAtunReq2") === "on") ? 1 : 0) + ((data.get("inputBaconReq2") === "on") ? 1 : 0)
      


      const pizza = new Pizza(size, ingridients)
      const precio = pizza.checkPrice();

      priceLabel.textContent = "Precio de la pizza = " + precio + "€"
  
    })

    priceContainer.appendChild(priceLabel)
    
    requerimiento2.appendChild(form)
    requerimiento2.appendChild(priceContainer)


  }
  
  
  
  init();
  req1();
  req2();