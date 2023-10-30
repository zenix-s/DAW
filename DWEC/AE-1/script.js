import Pizza from "./classes/pizza.js";
import InputComponent from "./classes/inputComponent.js";

// Adquisición del elemento main
const main = document.getElementById("main");

/**
 * Función inicia la ejecución del codigo
 */
function init() {
  const titulo = document.createElement("h1");
  titulo.textContent = "AE-1. DOM y Formularios ";
  main.appendChild(titulo);
}

/**
 * Genera el formulario del requerimiento 1
 */
function req1() {
  const inputComponent = new InputComponent();
  const requerimiento1 = document.createElement("section");
  const requerimiento1titulo = document.createElement("h2");
  requerimiento1titulo.textContent = "Requerimiento 1";
  requerimiento1.id = "Requerimiento1";

  main.appendChild(requerimiento1titulo);
  main.appendChild(requerimiento1);

  const form = document.createElement("form");
  form.id = "req1form";
  const img1 = document.createElement("img");
  img1.src = "assets/img/Req1Img1.png";
  form.appendChild(img1);
  requerimiento1.appendChild(form);

  const dat1 = document.createElement("h3");
  dat1.textContent = "Datos del instructor";
  form.appendChild(dat1);
  form.appendChild(
    inputComponent.inputContainer({
      inputType: "text",
      inputLabel: "Nombre",
      idName: "inputNombreReq1",
    })
  );
  form.appendChild(
    inputComponent.inputContainer({
      inputType: "text",
      inputLabel: "Apellidos",
      idName: "inputApellidosReq1",
    })
  );
  form.appendChild(
    inputComponent.inputContainer({
      inputType: "text",
      inputLabel: "Dni",
      idName: "inputDniReq1",
    })
  );
  form.appendChild(
    inputComponent.inputContainer({
      inputType: "text",
      inputLabel: "Direccion",
      idName: "inputDireccionReq1",
    })
  );
  form.appendChild(
    inputComponent.inputContainer({
      inputType: "text",
      inputLabel: "Telefono",
      idName: "inputTelefonoReq1",
    })
  );

  const dat2 = document.createElement("h3");
  dat2.textContent = "Datos del evento";
  form.appendChild(dat2);

  form.appendChild(
    inputComponent.inputContainer({
      inputType: "radio",
      inputLabel: "Nivel",
      idName: "inputRadioNiveladReq1",
      options: [
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
      ],
    })
  );

  form.appendChild(
    inputComponent.inputContainer({
      inputType: "radio",
      inputLabel: "Tipo",
      idName: "inputRadioTipoReq1",
      options: [
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
      ],
    })
  );

  const checkboxContainer = document.createElement("div");
  checkboxContainer.classList.add("checkboxcontainer");
  const checkboxtitle = document.createElement("p");

  checkboxtitle.textContent = "Contenidos";
  checkboxContainer.appendChild(checkboxtitle);

  form.appendChild(checkboxContainer);

  checkboxContainer.appendChild(
    inputComponent.inputContainer({
      inputType: "checkbox",
      inputLabel: "Programación",
      idName: "inputCheckboxProgramacionReq1",
    })
  );
  checkboxContainer.appendChild(
    inputComponent.inputContainer({
      inputType: "checkbox",
      inputLabel: "Diseño",
      idName: "inputCheckboxDisenoReq1",
    })
  );
  checkboxContainer.appendChild(
    inputComponent.inputContainer({
      inputType: "checkbox",
      inputLabel: "Redes",
      idName: "inputCheckboxRedesReq1",
    })
  );
  checkboxContainer.appendChild(
    inputComponent.inputContainer({
      inputType: "checkbox",
      inputLabel: "Bases de datos",
      idName: "inputCheckboxBBDDReq1",
    })
  );
  checkboxContainer.appendChild(
    inputComponent.inputContainer({
      inputType: "checkbox",
      inputLabel: "Seguridad",
      idName: "inputCheckboxSeguridadReq1",
    })
  );

  form.appendChild(
    inputComponent.inputContainer({
      inputType: "select",
      inputLabel: "Modalidad",
      idName: "inputSelectModalidadReq1",
      options: [
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
      ],
    })
  );

  form.appendChild(
    inputComponent.inputContainer({
      inputType: "textarea",
      inputLabel: "Descripción del evento",
      idName: "inputTextareaDescripcionReq1",
    })
  );

  const img2 = document.createElement("img");
  img2.src = "assets/img/Req1Img2.png";
  form.appendChild(img2);
}

/**
 * Limpia todos los hijos de un elemento html
 * @param {HTMLElement} section
 */
function cleanSection(section) {
  const children = Array.from(section.children);
  console.log(children);
  children.forEach((child) => {
    section.removeChild(child);
  });
}

/**
 * Se encarga de generar el formulario para el requerimiento 2
 *
 */
function req2() {
  const inputComponent = new InputComponent();
  const requerimiento2 = document.createElement("section");
  requerimiento2.id = "Requerimiento2";
  const requerimiento2titulo = document.createElement("h2");
  requerimiento2titulo.textContent = "Requerimiento 2";
  main.appendChild(requerimiento2titulo);
  main.appendChild(requerimiento2);

  const form = document.createElement("form");
  form.id = "req2form";

  const section1 = document.createElement("div");
  section1.id = "pizzasec1";
  const section2 = document.createElement("div");
  section2.id = "pizzasec2";
  const section3 = document.createElement("div");
  section3.id = "pizzasec3";

  const subsection = document.createElement("div");
  subsection.id = "subsection";

  form.appendChild(section1);
  form.appendChild(subsection);
  subsection.appendChild(section2);
  subsection.appendChild(section3);

  const img1 = document.createElement("img");
  img1.src = "assets/img/Req2Img1.png";
  form.appendChild(img1);

  const title = document.createElement("h2");
  title.textContent = "FaxPizza";
  section1.appendChild(title);

  section2.appendChild(
    inputComponent.inputContainer({
      inputType: "text",
      inputLabel: "Nombre",
      idName: "inputNombreReq2",
      required: true,
    })
  );
  section2.appendChild(
    inputComponent.inputContainer({
      inputType: "text",
      inputLabel: "Direccion",
      idName: "inputDireccionReq2",
      required: true,
    })
  );
  section2.appendChild(
    inputComponent.inputContainer({
      inputType: "text",
      inputLabel: "Telefono",
      idName: "inputTelefonoReq2",
      required: true,
    })
  );
  section2.appendChild(
    inputComponent.inputContainer({
      inputType: "text",
      inputLabel: "Email",
      idName: "inputEmailReq2",
      required: true,
    })
  );

  section2.appendChild(
    inputComponent.inputContainer({
      inputType: "radio",
      inputLabel: "Tamaño",
      idName: "inputSizeReq2",
      required: true,
      options: [
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
      ],
    })
  );

  const checkboxContainer = document.createElement("div");
  checkboxContainer.classList.add("checkboxcontainer");
  section2.appendChild(checkboxContainer);

  checkboxContainer.appendChild(
    inputComponent.inputContainer({
      inputType: "checkbox",
      inputLabel: "Pollo",
      idName: "ingredientes",
    })
  );
  checkboxContainer.appendChild(
    inputComponent.inputContainer({
      inputType: "checkbox",
      inputLabel: "Atun",
      idName: "ingredientes",
    })
  );
  checkboxContainer.appendChild(
    inputComponent.inputContainer({
      inputType: "checkbox",
      inputLabel: "Bacon",
      idName: "ingredientes",
    })
  );
  checkboxContainer.appendChild(
    inputComponent.inputContainer({
      inputType: "checkbox",
      inputLabel: "Extra queso",
      idName: "ingredientes",
    })
  );

  section2.appendChild(
    inputComponent.inputContainer({
      inputType: "submit",
      inputLabel: "Detallar Pedido",
      idName: "inputSubmitReq2",
    })
  );

  const priceLabel = document.createElement("p");
  priceLabel.textContent = "Detalles del pedido";

  form.addEventListener("submit", (e) => {
    e.preventDefault();

    const priceSection = document.getElementById("pizzasec3");

    cleanSection(priceSection);

    const priceLabel = document.createElement("p");
    priceLabel.textContent = "Detalles del pedido";
    section3.appendChild(priceLabel);
    const data = new FormData(e.target);
    const ingredientes = document.querySelectorAll(
      "input[type='checkbox'][name='ingredientes']"
    );
    const ingredientesMarcados = [];

    const pListaIngredientes = document.createElement("p");
    const pSize = document.createElement("p");
    const pPrecio = document.createElement("p");

    pListaIngredientes.textContent = "Ingredientes: ";

    let minimunIngriedient = false;
    ingredientes.forEach((ingrediente) => {
      if (ingrediente.checked) {
        minimunIngriedient === false && (minimunIngriedient = true);
        ingredientesMarcados.push(ingrediente.value);
        pListaIngredientes.textContent =
          pListaIngredientes.textContent + ingrediente.value + ", ";
      }
    });
    if (minimunIngriedient === false) {
      alert("Debes elegir al menos un ingrediente");
    } else {
      priceSection.appendChild(pListaIngredientes);
      priceSection.appendChild(pSize);
      priceSection.appendChild(pPrecio);

      const size = data.get("inputSizeReq2");
      pSize.textContent =
        "Tamaño: " +
        (size === 1 ? "pequeña" : size === 2 ? "Mediana" : "Grande");
      const pizza = new Pizza(size, ingredientesMarcados.length);
      const precio = pizza.checkPrice();
      pPrecio.textContent = "Precio Final " + precio + "€";
    }
  });
  section3.appendChild(priceLabel);
  requerimiento2.appendChild(form);
}

init();
req1();
req2();
