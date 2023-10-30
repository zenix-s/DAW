# AE-1. DOM y Formularios 

## Requerimiento 1

Para el Requerimiento 1, se ha generado un formulario dinámico utilizando métodos de modificación del DOM en JavaScript.

Con el objetivo de estructurar el código de manera más organizada y modular, se ha creado la clase `InputComponent`. Esta clase contiene el método `inputContainer`, el cual acepta un objeto con los siguientes parámetros:

- **`inputType` (string)**: Define el tipo de campo de entrada que se creará en el formulario. Puede ser `"text"`, `"radio"`, `"checkbox"`, `"select"`, `"textarea"` o `"submit"`. Este parámetro determina el tipo de elemento de entrada HTML que se generará.

- **`inputLabel` (string)**: Representa la etiqueta o texto asociado al campo de entrada. Es la descripción del campo que se mostrará al lado del elemento de entrada generado. Por ejemplo, para un campo de tipo `"text"`, `inputLabel` podría ser `"Nombre"`, `"Apellidos"`, etc.

- **`idName` (string)**: Es el valor del atributo `id` del campo de entrada. Este identificador es útil para asociar la etiqueta del campo de entrada con el propio campo, mejorando así la accesibilidad y la usabilidad del formulario.

- **`options` (Array)**: Este parámetro es opcional y se utiliza en campos de tipo `"radio"` y `"select"`. Es un array de objetos que contiene las opciones para los elementos de radio o las opciones del menú desplegable. Cada objeto debe tener `value` y `label`, donde `value` es el valor que se enviará al servidor cuando se seleccione esa opción, y `label` es la etiqueta visible para el usuario.

- **`required` (boolean)**: Es un parámetro opcional que indica si el campo de entrada es obligatorio o no. Si se establece en `true`, el campo de entrada requerirá una entrada antes de que el formulario pueda ser enviado. Si no se proporciona, se asume como `false` por defecto.

Usando esta estructura modular y orientada a objetos, se han añadido al formulario del Requerimiento 1 los elementos HTML requeridos, cumpliendo con los criterios establecidos en el enunciado. La clase `InputComponent` permite crear y gestionar fácilmente distintos tipos de campos de entrada y mejorar la legibilidad y mantenibilidad del código.