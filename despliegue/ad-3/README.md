Para este proyecto se va a hacer una herramienta para un equipo de recursos humanos que les permita llevar un control de los empleados, sus datos personales, sus salarios, sus vacaciones, sus bajas, sus permisos, etc. a traves de comentarios, son 3 tablas las que se van a utilizar,

Usuario - Que es la persona de recursos humanos que va a utilizar la herramienta
Empleado - Que es el empleado de la empresa
Comentario - Que es el comentario que se va a hacer sobre el empleado, puede consistir en una baja, un permiso, una vacación, un comentario sobre el salario, etc.

```sql
CREATE DATABASE `recursos_humanos`

USE `recursos_humanos`

CREATE TABLE `usuarios` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`nombre` varchar(255) NOT NULL,
	`email` varchar(255) NOT NULL,
	`password` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
)

CREATE TABLE `empleados` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`nombre` varchar(255) NOT NULL,
	`apellidos` varchar(255) NOT NULL,
	`email` varchar(255) NOT NULL,
	`telefono` varchar(255) NOT NULL,
	`direccion` varchar(255) NOT NULL,
	`salario` decimal(10,2) NOT NULL,
	`fecha_nacimiento` date NOT NULL,
	`fecha_contratacion` date NOT NULL,
	`fecha_baja` date,
	`activo` tinyint(1) NOT NULL,
	PRIMARY KEY (`id`)
)

CREATE TABLE `comentarios` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`id_empleado` int(11) NOT NULL,
	`comentario` text NOT NULL,
	`fecha` date NOT NULL,
	PRIMARY KEY (`id`)
)
```

Las urls que se van a utilizar son las siguientes:

GET /api/usuarios/:id - Para obtener un usuario en concreto
POST /api/usuarios - Para crear un usuario
PUT /api/usuarios/:id - Para modificar un usuario
DELETE /api/usuarios/:id - Para borrar un usuario

GET /api/empleados - Para obtener todos los empleados
GET /api/empleados/:id - Para obtener un empleado en concreto
POST /api/empleados - Para crear un empleado
PUT /api/empleados/:id - Para modificar un empleado
DELETE /api/empleados/:id - Para borrar un empleado

GET /api/comentarios/:idEmpleado - Para obtener todos los comentarios de un empleado
GET /api/comentarios/:idEmpleado/:id - Para obtener un comentario en concreto de un empleado
POST /api/comentarios - Para crear un comentario
PUT /api/comentarios/:id - Para modificar un comentario
DELETE /api/comentarios/:id - Para borrar un comentario
