export default class InputComponent {
  constructor() {}
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
   * }} opciones - Opciones para configurar el elemento.
   *
   * @returns {HTMLElement}
   */
  inputContainer(opciones) {
    const {
      inputType,
      inputLabel,
      idName,
      options = [],
      required = false,
    } = opciones;
    const inputContainer = document.createElement("div");

    inputContainer.classList.add("input" + inputType + "Container");

    inputType === "radio" &&
      inputContainer.appendChild(
        this.#radioContainer(options, idName, required)
      );
    inputType === "select" &&
      inputContainer.appendChild(
        this.#selectContainer(options, idName, required)
      );
    inputType === "textarea" &&
      inputContainer.appendChild(this.#textAreaContainer(required));
    inputType === "text" &&
      inputContainer.appendChild(
        this.#standardInputContainer(inputType, idName, required)
      );
    inputType === "checkbox" &&
      inputContainer.appendChild(
        this.#standardInputContainer(inputType, idName, required, inputLabel)
      );
    inputType === "submit" &&
      inputContainer.appendChild(
        this.#standardInputContainer(inputType, required, required, inputLabel)
      );

    if (inputType !== "submit") {
      const labelContainer = this.#labelContainer(inputLabel, idName);

      inputContainer.appendChild(labelContainer);
    }

    return inputContainer;
  }

  /**
   * Crea un contenedor para la etiqueta del input.
   *
   * @private
   * @param {string} inputLabel - Etiqueta del input.
   * @param {string} idName - ID del input.
   * @returns {HTMLLabelElement} - Elemento de etiqueta HTML.
   */
  #labelContainer(inputLabel, idName) {
    const labelContainer = document.createElement("label");
    labelContainer.textContent = inputLabel;
    labelContainer.setAttribute("for", idName);

    return labelContainer;
  }

  /**
   * Crea un contenedor para los elementos de tipo radio.
   *
   * @private
   * @param {Array} Options - Opciones para los botones de radio.
   * @param {string} idName - ID del grupo de radio.
   * @param {boolean} required - Indica si el radio es obligatorio.
   * @returns {HTMLDivElement} - Contenedor de elementos de tipo radio.
   */
  #radioContainer(Options, idName, required) {
    const radioContainer = document.createElement("div");

    Options.forEach((radioOption) => {
      const input = document.createElement("input");
      input.type = "radio";
      input.value = radioOption.value;
      input.name = idName;
      required && input.setAttribute("required", required);
      const label = document.createElement("label");
      label.textContent = radioOption.label;

      const divCon = document.createElement("div");

      divCon.appendChild(input);
      divCon.appendChild(label);

      radioContainer.appendChild(divCon);
    });

    return radioContainer;
  }

  /**
   * Crea un contenedor para los elementos de tipo select.
   *
   * @private
   * @param {Array} Options - Opciones para el elemento de tipo select.
   * @param {string} idName - ID del elemento de tipo select.
   * @param {boolean} required - Indica si el select es obligatorio.
   * @returns {HTMLDivElement} - Contenedor de elementos de tipo select.
   */
  #selectContainer(Options, idName, required) {
    const selectContainer = document.createElement("div");

    const select = document.createElement("select");
    selectContainer.appendChild(select);
    Options.forEach((selectOption) => {
      const input = document.createElement("option");
      required && input.setAttribute("required", required);
      input.value = selectOption.value;
      input.textContent = selectOption.label;

      select.appendChild(input);
    });

    return selectContainer;
  }

  #textAreaContainer(required) {
    const textAreaContainer = document.createElement("div");
    const textArea = document.createElement("textarea");
    required && textArea.setAttribute("required", required);
    textAreaContainer.appendChild(textArea);
    return textAreaContainer;
  }

  /**
   * Crea un contenedor para el elemento de tipo input (text, checkbox, submit, etc.).
   *
   * @private
   * @param {string} inputType - Tipo del input (text, checkbox, submit, etc.).
   * @param {string} idName - ID del input.
   * @param {boolean} required - Indica si el input es obligatorio.
   * @param {string} inputLabel - Etiqueta del input (solo para checkbox y submit).
   * @returns {HTMLInputElement} - Elemento de tipo input HTML.
   */
  #standardInputContainer(inputType, idName, required, inputLabel) {
    const standardInputContainer = document.createElement("div");
    const input = document.createElement("input");
    input.type = inputType;
    input.id = idName;

    required && input.setAttribute("required", required);
    input.setAttribute("name", idName);
    inputType === "checkbox" && (input.value = inputLabel);
    inputType === "text" && (input.placeholder = "");
    inputType === "submit" && (input.value = inputLabel);

    standardInputContainer.appendChild(input);

    return input;
  }
}
