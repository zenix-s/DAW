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
  requerimiento1.id = "Requerimiento1"
  
  main.appendChild(requerimiento1titulo)
  main.appendChild(requerimiento1)

  const form = document.createElement("form")
  form.id="req1form"
  const img1 = document.createElement("img")
  img1.src = "assets/img/Req1Img1.png"
  form.appendChild(img1)
  requerimiento1.appendChild(form)

  const dat1 = document.createElement("h3")
  dat1.textContent = "Datos del instructor"
  form.appendChild(dat1)
  form.appendChild(inputComponent.inputContainer({inputType:"text",inputLabel:"Nombre",idName:"inputNombreReq1"}))
  form.appendChild(inputComponent.inputContainer({inputType:"text",inputLabel:"Apellidos",idName:"inputApellidosReq1"}))
  form.appendChild(inputComponent.inputContainer({inputType:"text",inputLabel:"Dni",idName:"inputDniReq1"}))
  form.appendChild(inputComponent.inputContainer({inputType:"text",inputLabel:"Direccion",idName:"inputDireccionReq1"}))
  form.appendChild(inputComponent.inputContainer({inputType:"text",inputLabel:"Telefono",idName:"inputTelefonoReq1"}))

  const dat2 = document.createElement("h3")
  dat2.textContent = "Datos del evento"
  form.appendChild(dat2)

  form.appendChild(inputComponent.inputContainer({inputType:"radio",inputLabel:"Nivel",idName:"inputRadioNiveladReq1", options:[
    {
      value: "principiante",
      label: "Principiante",
    },
    {
      value: "intermedio",
      label: "Intermedio",
    },
    {
      value: "avanzado",
      label: "avanzado",
    },
    {
      value: "experto",
      label: "experto",
    },
  ]}))

  form.appendChild(inputComponent.inputContainer({inputType:"radio",inputLabel:"Tipo",idName:"inputRadioTipoReq1", options:[
    {
      value: "conferencia",
      label: "conferencia",
    },
    {
      value: "taller",
      label: "Taller",
    },
    {
      value: "seminario",
      label: "Seminario",
    },
    {
      value: "presentacion",
      label: "Presentación",
    },
  ]}))

  const checkboxContainer = document.createElement("div")
  checkboxContainer.classList.add("checkboxcontainer")
  const checkboxtitle = document.createElement("p")

  checkboxtitle.textContent="Contenidos"
  checkboxContainer.appendChild(checkboxtitle)

  form.appendChild(checkboxContainer)

  
  checkboxContainer.appendChild(inputComponent.inputContainer({inputType:"checkbox",inputLabel:"Programación",idName:"inputCheckboxProgramacionReq1"}))
  checkboxContainer.appendChild(inputComponent.inputContainer({inputType:"checkbox",inputLabel:"Diseño",idName:"inputCheckboxDisenoReq1"}))
  checkboxContainer.appendChild(inputComponent.inputContainer({inputType:"checkbox",inputLabel:"Redes",idName:"inputCheckboxRedesReq1"}))
  checkboxContainer.appendChild(inputComponent.inputContainer({inputType:"checkbox",inputLabel:"Bases de datos",idName:"inputCheckboxBBDDReq1"}))
  checkboxContainer.appendChild(inputComponent.inputContainer({inputType:"checkbox",inputLabel:"Seguridad",idName:"inputCheckboxSeguridadReq1"}))

  form.appendChild(inputComponent.inputContainer({inputType:"select",inputLabel:"Modalidad",idName:"inputSelectModalidadReq1", options:[
    {
      value: "presencial",
      label: "Presencial",
    },
    {
      value: "online",
      label: "Online",
    },
    {
      value: "mixta",
      label: "Mixta",
    },
    {
      value: "fax",
      label: "Fax",
    },
  ]}))

  // form.appendChild(inputComponent.inputContainer("textarea", "TextArea", "inputTextArea1Req1"))
  form.appendChild(inputComponent.inputContainer({inputType:"textarea", inputLabel:"Descripción del evento", idName:"inputTextareaDescripcionReq1"}))

  const img2 = document.createElement("img")
  img2.src="assets/img/Req1Img2.png"
  form.appendChild(img2)

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
  main.appendChild(requerimiento2titulo)

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