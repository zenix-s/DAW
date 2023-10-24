<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Aplicacion de clientes: Alta de Cliente</h1>
	<form action="client?opcion=altaCliente" method="post">
		
		<div>
			<label>Nombre</label>
			<input type="text" name="nombre">
		</div>
		<div>
			<label>Cantidad Empleados</label>
			<input type="text" name="cantidadEmpleados">
		<div>
			<label>Facturación Anual</label>
			<input type="text" name="facturacionAnual">
		</div>
		<div>
			<input type="submit" value="Enviar">
		</div>
	
	</form>
</body>
</html>