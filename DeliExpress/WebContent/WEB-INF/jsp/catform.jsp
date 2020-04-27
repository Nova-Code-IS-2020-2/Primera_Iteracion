<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Categoría</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<!---- boostrap.min link local ----->

<link rel="stylesheet" href="css/style.css">
<!---- boostrap.min link local ----->

<script src="js/bootstrap.min.js"></script>
<!---- Boostrap js link local ----->

<link rel="icon" href="images/icon.png" type="image/x-icon" />
<!---- Icon link local ----->

<link href="https://fonts.googleapis.com/css?family=Lobster"
	rel="stylesheet">
<!---- Font awesom link local ----->
<script type="text/javascript"
	src="/bower_components/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="/bower_components/moment/min/moment.min.js"></script>
<script type="text/javascript"
	src="/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="/bower_components/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet"
	href="/bower_components/bootstrap/dist/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="/bower_components/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css" />


</head>
<body>
	<h1>Crear Categoría</h1>
	<form:form  action="guardarCategoria" method="post" modelAttribute="categoria">
		<table border="1" align="center">
		<tr>
			<td><a>Id:</a></td>		
			<td><form:input  path="id" /></td>	
		</tr>
		<tr>
			<td><a>Nombre:</a></td>		
			<td><form:input  path="Nombre"  /></td>	
		</tr>		
		</table>
		<br>
		<table border="0" align="center">
		<tr>
			<td><input type="submit" value="Agregar" name="guardarCategoria"></td>	
		</tr>
		</table>
	</form:form>
</body>
</html>