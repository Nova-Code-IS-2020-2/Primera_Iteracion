<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Categoría</title>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script> 
$(function(){
  $("#header").load("menuportatil.html");
});
</script>
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
	<div id="header"></div>
	<h1>Editar Categoría</h1>
	<form:form  action="actualizarCategoria" method="post" modelAttribute="categoria">
		<table border="1" align="center">
		<form:hidden  path="id" />
		<tr>
			<td><a>Nombre:</a></td>		
			<td><form:input  path="Nombre" value="${categoria.getNombre()}" /></td>	
		</tr>		
		</table>
		<br>
		<table border="0" align="center">
		<tr>
			<td><input type="submit" value="Actualizar" name="actualizarCategoria"></td>	
		</tr>
		</table>
	</form:form>
</body>
</html>