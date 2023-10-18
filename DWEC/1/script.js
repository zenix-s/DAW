const main = document.getElementById("main");

function init(){
  const titulo = document.createElement("h1")
  titulo.textContent = "AE-1. DOM y Formularios "
  main.appendChild(titulo)
}


const campoInput = (inputType = "text", inputLabel = "", radioOptions = []) => {
  const groupInput = document.createElement("div");

  const label = document.createElement("span");
  groupInput.appendChild(label);

  if (inputType === "radio") {
    const campoRadio = document.createElement("div");
    radioOptions.forEach((radioOption) => {
      const input = document.createElement("input");
      input.type = "radio";
      input.value = radioOption.value;
      input.name = inputLabel
      const label = document.createElement("label");
      label.innerText = radioOption.label;

      campoRadio.appendChild(input);
      campoRadio.appendChild(label);
    });

    groupInput.appendChild(campoRadio);
  }

  if (inputType === "select")

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

  form.appendChild(campoInput("checkbox", "Telefono"));
  form.appendChild(campoInput("checkbox", "Telefono"));
  form.appendChild(campoInput("checkbox", "Telefono"));
  form.appendChild(campoInput("checkbox", "Telefono"));
  form.appendChild(campoInput("checkbox", "Telefono"));

  form.appendChild(campoInput("select", ))


}

function req2(){
  const requerimiento2 = document.createElement("div")
  requerimiento2.id = "Requerimiento2"

  main.appendChild(requerimiento2)



  const form = document.createElement("form")
  requerimiento1.appendChild(form)
}

init();
req1();
req2();