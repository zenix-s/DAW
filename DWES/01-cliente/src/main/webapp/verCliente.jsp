<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Aplicacion de Clientes</h1>
	<h2>Ver detalle de un cliente</h2>
	<ul>
	
		<li>Nombre ${cliente.nombre}</li>
		<li>Empleados ${cliente.cantidadEmpleados}</li>
		<li>Facturacion ${cliente.facturacionAnual}</li>
		<li>IdCliente ${cliente.idCliente}</li>
		
	</ul>
	<a href="client?opcion=todos">Volver inicio</a>
</body>
</html>