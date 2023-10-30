# AE-1. DOM y Formularios

## Ejecutar el codigo

### Metodo 1

Para ejecutar el codigo solo hay que descargar todos los ficheros mediante un live server Ejemplo: `https://marketplace.visualstudio.com/items?itemName=ritwickdey.LiveServer` ejecutar index.html

Ejecutar directamente el fichero index.html no funciona debido a la separación de las clases y metodos es varios ficheros .js provoca el error CORS request not HTTP

### Metodo 2

En la carpeta SoloHTML se ha simplificado juntando todo el js en el fichero html por lo que este puede ser ejecutado directamente abriendo el fichero index.html de la carpeta SoloHTML

## Requerimiento 1

Requerimiento 1, se genera el formulario de forma dinámica utilizando métodos de modificación del DOM.

Con el objetivo de estructurar el código de manera más organizada y modular, se ha creado la clase `InputComponent`. Esta clase contiene el método `inputContainer`, el cual acepta un objeto con los siguientes parámetros:

- **`inputType` (string)**: Indica el tipo de input que se creará en el formulario. Puede ser `"text"`, `"radio"`, `"checkbox"`, `"select"`, `"textarea"` o `"submit"`.

- **`inputLabel` (string)**: Indica el texto que acompaña al input

- **`idName` (string)**: Es el valor del atributo `id` del campo de entrada.

- **`options` (Array)**: Parámetro es opcional y se utiliza en campos de tipo `"radio"` y `"select"`. Es un array de objetos que contiene las opciones para los elementos de radio o las opciones de un select. Cada objeto debe tener `value` y `label`

- **`required` (boolean)**: Parámetro opcional que indica si el campo de entrada es obligatorio o no.

Para ver el código fuente del Requerimiento 1 este se ejecuta en la función req1, haz clic [aquí](./script.js).

### Resultado

![Alt text](readme/image.png)

## Requerimiento 2: Pedido de Pizza

Para el requerimiento 2, se ha generado el formulario de forma dinámica utilizando la clase `InputComponent` y se ha calculado el precio del pedido utilizando la clase `Pizza`

### Clase `Pizza`

La clase `Pizza` se utiliza para calcular el precio total del pedido en función del tamaño de la pizza y los ingredientes seleccionados. El constructor de la clase acepta dos parámetros:

- `size`: representa el tamaño de la pizza (pequeña, mediana o grande).
- `ingridients`: representa la cantidad de ingredientes seleccionados para la pizza.

La función `checkPrice()` calcula el precio de la pizza en base a los siguientes criterios:

- 5€ pequeña.
- 10€ mediana.
- 15€ grande.
- Cada ingrediente seleccionado 1€.

Con un `form.addEventListener("submit", (e) => {}` se comprueba cuando se ha submiteado el formulario se recolectan los datos del formulario.
Con estos datos se construye un objeto de la clase `pizza` y se comprueba el precio con el función `checkPrice()` que devolvera el precio del pedido.

Para ver el código fuente del Requerimiento 2 este se ejecuta en la función req2, haz clic [aquí](./script.js).

### Resultado

- Caso de no haber seleccinado una opción como el tamaño
  ![Alt text](readme/req2img1.png)
- Caso de no haber seleccionado minimamente un ingrediente
  ![Alt text](readme/req2img2.png)

- Caso de haber seleccionado el tamaño y un ingrediente minimo
  ![Alt text](readme/req2img3.png)
