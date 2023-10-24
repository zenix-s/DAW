<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Aplicacion de clientes</h1>
	<h3>mensajes: ${mensaje}</h3>
	<p><a href="client?opcion=altaCliente">Cliente Nuevo</a></p>
	<table border="2">
		<tr>
			<th>Id Cliente</th>
			<th>Nombre</th>
			<th>Ver Detalle</th>
			<th>Eliminar</th>
			
		</tr>
		<c:forEach items="${clientes}" var="cliente">
		<tr>
			<td>${cliente.idCliente}</td>
			<td>${cliente.nombre}</td>
			<td><a href="client?opcion=ver&idCliente=${cliente.idCliente}">Ver Detalle</a>
			<td><a href="client?opcion=eliminar&idCliente=${cliente.idCliente}">Eliminar</a>
			
		</tr>
		</c:forEach>
		
	
	
	</table>
	
	
</body>
</html>