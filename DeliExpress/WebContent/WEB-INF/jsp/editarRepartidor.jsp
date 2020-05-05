<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html style="font-family: ABeeZee, sans-serif;font-size: 20px;">
<style type="text/css">
body {
  margin: 0;
  font-family: ABeeZee, sans-serif;
  font-size: 20px;
  color: #bd6d10;
  text-align: left;
  background-color: #ffffff;
}
.h1, h1 {
  color: #bd6d10;
}

.border.rounded-0.id-input {
	border: 1px solid #6c3313!important;
	border-style: groove;
}
.page-name {
  text-align: center;
  padding: 60px 0;
}

.cat-alim {
  color: #6C3313;
}

.nombre {
  font-family: SeoulNamsan CBL;
  font-style: normal;
  font-weight: normal;
  color: #6c3313;
}

.id_cat {
  color: #6C3313;
  font-family: SeoulNamsan CBL;
  font-style: normal;
  font-weight: normal;
}

.border {
  border: 1px solid #6c3313!important;
  border-style: groove;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Alimento</title>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script> 
$(function(){
  $("#header").load("menuportatilAdmin.html");
});
</script>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=ABeeZee">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Abhaya+Libre">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Actor">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amiko">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>

<body>
	<div id="header"></div>
	<div class="container page-name">
		<h1 style="font-family: ABeeZee, sans-serif;">DeliExpress</h1>
		<h3 class="cat-alim" style="font-family: Actor, sans-serif;">Editar Perfil de Repartidor</h3>
		<div class="card-body">
			<form:form  action="actualizarRep" method="post" modelAttribute="rep">
		<form:hidden  path="id_repartidor"/>
		<div class="form-group">
			<label for="name">Nombre</label>
		    <form:input type="text" class="form-control" maxlength="45" id="name" path="Nombre" required="required"/>
		</div>
		<div class="form-group">
			<label for="ap_pat">Apellido Paterno</label>
		    <form:input type="text" class="form-control" maxlength="45" id="ap_pat" path="ap_pat" required="required"/>
		</div>
		<div class="form-group">
			<label for="ap_mat">Apellido Materno</label>
		    <form:input type="text" class="form-control" maxlength="45"  id="ap_mat" path="ap_mat" required="required"/>
		</div>
		<div class="form-group">
			<label for="email">Dirección De correo electronico</label>
		    <form:input type="email" class="form-control" maxlength="45" id="email" path="email" required="required"/>
			<small id="HelpBlock" class="form-text text-muted">
				Introduce un email nuevo
			</small>
		</div>
		<div class="form-group">
			<label for="contr">Contraseña</label>
		    <form:input type="password" class="form-control" maxlength="8" id="contr" path="contr" required="required" />
		</div>
		<div class="text-center">
			 ${message}
		</div>
		<div class="text-center">
			<button class="btn btn-default active btn-lg" type="submit"value="Actualizar Datos" name="actualizarCuenta">Actualizar Datos</button>
		</div>
	
	</form:form>
		
				</div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
