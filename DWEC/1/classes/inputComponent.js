export default class InputComponent{
  constructor(){}
  /**
   * 
   * @param {string} inputType
   * @param {string} inputLabel 
   * @param {string} idName
   * @param {} Options 
   * @returns 
   */
  inputContainer(inputType, inputLabel, idName,  Options = []){
    
    const inputContainer = document.createElement("div");

    inputContainer.classList.add("input" + inputType + "Container")
    
    
    inputType === "radio" && (inputContainer.appendChild(this.#radioContainer(Options, idName)))
    inputType === "select" && (inputContainer.appendChild(this.#selectContainer(Options, idName)))
    inputType === "textarea" && (inputContainer.appendChild(this.#textAreaContainer()))
    inputType === "text" && (inputContainer.appendChild(this.#standardInputContainer(inputType, idName)))
    inputType === "checkbox" && (inputContainer.appendChild(this.#standardInputContainer(inputType, idName)))
    inputType === "submit" && (inputContainer.appendChild(this.#standardInputContainer(inputType)))
    
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

  #radioContainer(Options, idName){
    const radioContainer = document.createElement("div");

    Options.forEach((radioOption) => {
      const input = document.createElement("input");
      input.type = "radio";
      input.value = radioOption.value;
      input.name = idName
      const label = document.createElement("label");
      label.textContent = radioOption.label;

      radioContainer.appendChild(input);
      radioContainer.appendChild(label);
    });

    
    
    return radioContainer
  }

  #selectContainer(Options, idName){
    const selectContainer = document.createElement("div");

    const select = document.createElement("select")
    selectContainer.appendChild(select)
    Options.forEach((selectOption) => {
      const input = document.createElement("option");
      input.value = selectOption.value;
      input.textContent = selectOption.label

      select.appendChild(input);
    });

    return selectContainer
  }

  #textAreaContainer(){
    const textAreaContainer = document.createElement("div");
    const textArea = document.createElement("textarea");
    textAreaContainer.appendChild(textArea)
    return textAreaContainer
  }

  #standardInputContainer(inputType, idName){
    const standardInputContainer = document.createElement("div")
    const input = document.createElement("input");
    input.type = inputType;
    input.id = idName
    input.setAttribute("name", idName)
    
    inputType === "text" && (input.placeholder = "")
    inputType === "submit" && (input.value = "Submit" )
    
    standardInputContainer.appendChild(input);

    return input

  }

}