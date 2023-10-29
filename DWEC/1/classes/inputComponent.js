export default class InputComponent{
  constructor(){}
 /**
   * Crea un elemento HTML el cual incluye un input y un label
   * {inputType, inputLabel, idName,  options = [], required = false} = opciones
   * 
   * @param {{
   *   inputType: string,
   *   inputLabel: string,
   *   idName: string,
   *   options?: [],
   *   required?: boolean,
   * }} options
   *
   * @returns {HTMLElement}
   */
  inputContainer(opciones){
    const {inputType, inputLabel, idName,  options = [], required = false} = opciones
    const inputContainer = document.createElement("div");

    inputContainer.classList.add("input" + inputType + "Container")
    
    
    inputType === "radio" && (inputContainer.appendChild(this.#radioContainer(options, idName, required)))
    inputType === "select" && (inputContainer.appendChild(this.#selectContainer(options, idName, required)))
    inputType === "textarea" && (inputContainer.appendChild(this.#textAreaContainer(required)))
    inputType === "text" && (inputContainer.appendChild(this.#standardInputContainer(inputType, idName, required)))
    inputType === "checkbox" && (inputContainer.appendChild(this.#standardInputContainer(inputType, idName, required, inputLabel)))
    inputType === "submit" && (inputContainer.appendChild(this.#standardInputContainer(inputType, required, required, inputLabel)))
    
    if (inputType !== "submit"){
      const labelContainer = this.#labelContainer(inputLabel, idName)
      
      inputContainer.appendChild(labelContainer)

    }



    return inputContainer
  }

  #labelContainer(inputLabel, idName){
    const labelContainer = document.createElement("label")
    labelContainer.textContent = inputLabel
    labelContainer.setAttribute("for", idName)

    return labelContainer
  }

  #radioContainer(Options, idName, required){
    const radioContainer = document.createElement("div");

    Options.forEach((radioOption) => {
      const input = document.createElement("input");
      input.type = "radio";
      input.value = radioOption.value;
      input.name = idName
      required && input.setAttribute("required", required)
      const label = document.createElement("label");
      label.textContent = radioOption.label;

      const divCon = document.createElement("div")

      

      divCon.appendChild(input);
      divCon.appendChild(label);

      radioContainer.appendChild(divCon)

    });

    
    
    return radioContainer
  }

  #selectContainer(Options, idName, required){
    const selectContainer = document.createElement("div");

    const select = document.createElement("select")
    selectContainer.appendChild(select)
    Options.forEach((selectOption) => {

      const input = document.createElement("option");
      required && input.setAttribute("required", required)
      input.value = selectOption.value;
      input.textContent = selectOption.label

      select.appendChild(input);
    });

    return selectContainer
  }

  #textAreaContainer(required){
    const textAreaContainer = document.createElement("div");
    const textArea = document.createElement("textarea");
    required && textArea.setAttribute("required", required)
    textAreaContainer.appendChild(textArea)
    return textAreaContainer
  }

  #standardInputContainer(inputType, idName, required, inputLabel){
    const standardInputContainer = document.createElement("div")
    const input = document.createElement("input");
    input.type = inputType;
    input.id = idName

    required && input.setAttribute("required", required)
    input.setAttribute("name", idName)
    inputType === "checkbox" && (input.value = inputLabel)
    inputType === "text" && (input.placeholder = "")
    inputType === "submit" && (input.value = inputLabel )
    
    standardInputContainer.appendChild(input);

    return input

  }

}