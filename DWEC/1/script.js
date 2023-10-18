const main = document.getElementById("main");

function init(){
  const titulo = document.createElement("h1")
  titulo.textContent = "AE-1. DOM y Formularios "
  main.appendChild(titulo)
}


const campoInput = (inputType = "text", inputLabel = "", Options = []) => {
  const groupInput = document.createElement("div");

  const label = document.createElement("span");
  groupInput.appendChild(label);

  if (inputType === "radio") {
    const campoRadio = document.createElement("div");
    Options.forEach((radioOption) => {
      const input = document.createElement("input");
      input.type = "radio";
      input.value = radioOption.value;
      input.name = inputLabel
      const label = document.createElement("label");
      label.textContent = radioOption.label;

      campoRadio.appendChild(input);
      campoRadio.appendChild(label);
    });

    groupInput.appendChild(campoRadio);
  }

  if (inputType === "select"){
    const campoSelect = document.createElement("div");
    const select = document.createElement("select")
    campoSelect.appendChild(select)
    Options.forEach((selectOption) => {
      const input = document.createElement("option");
      input.value = selectOption.value;
      input.textContent = selectOption.label

      select.appendChild(input);
    });

    groupInput.appendChild(campoSelect);
  }

  if(inputType === "textarea"){
    const input = document.createElement("textarea");
    groupInput.appendChild(input);
  }

  if (inputType === "text") {
    const input = document.createElement("input");
    input.type = inputType;
    groupInput.appendChild(input);
  } 
  

  label.innerText = inputLabel;

  return groupInput;
};

function req1() {


  const requerimiento1 = document.createElement("div")
  const requerimiento1titulo = document.createElement("h2")
  requerimiento1titulo.textContent = "Requerimiento 1"
  requerimiento1.appendChild(requerimiento1titulo)
  requerimiento1.id = "Requerimiento1"

  main.appendChild(requerimiento1)

  const form = document.createElement("form")
  requerimiento1.appendChild(form)

  form.appendChild(campoInput("text", "Nombre"));
  form.appendChild(campoInput("text", "Apellidos"));
  form.appendChild(campoInput("text", "DNI"));
  form.appendChild(campoInput("text", "Dirección"));
  form.appendChild(campoInput("text", "Telefono"));

  form.appendChild(
    campoInput("radio", "Genero", [
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
    ])
  );
  form.appendChild(
    campoInput("radio", "Options", [
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
    ])
  );

  const checkboxContainer = document.createElement("div")
  form.appendChild(checkboxContainer)
  checkboxContainer.appendChild(campoInput("checkbox", "Telefono"));
  checkboxContainer.appendChild(campoInput("checkbox", "Telefono"));
  checkboxContainer.appendChild(campoInput("checkbox", "Telefono"));
  checkboxContainer.appendChild(campoInput("checkbox", "Telefono"));
  checkboxContainer.appendChild(campoInput("checkbox", "Telefono"));

  form.appendChild(campoInput("select", "select", [
    {
      value: "Option1",
      label: "Option1",
    },
    {
      value: "Option2",
      label: "Option2",
    },
    {
      value: "Option3",
      label: "Option3",
    },
    {
      value: "Option4",
      label: "Option4",
    },
  ]))

  form.appendChild(campoInput("textarea", "textarea"))


}

function req2(){
  const requerimiento2 = document.createElement("div")
  requerimiento2.id = "Requerimiento2"
  const requerimiento2titulo = document.createElement("h2")
  requerimiento2titulo.textContent = "Requerimiento 2"
  requerimiento2.appendChild(requerimiento2titulo)

  main.appendChild(requerimiento2)



  const form = document.createElement("form")
  requerimiento1.appendChild(form)
}

init();
req1();
req2();