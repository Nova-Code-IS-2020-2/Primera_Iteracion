<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Sign up</title>

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
<style type="text/css">
body{
background: url(cr120-melon.jpg) no-repeat center center fixed;
-webkit-background-size: cover;
-moz-background-size: cover;
-o-background-size: cover;
background-size: cover;
}
</style>

</head>

<body  >

	
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<div class="card mx-auto" style="width: 18rem;">
<h5 class="card-header text-center">REGISTRATE</h5>
<div class="card-body">
	<form:form action="guardarCuenta" method="post" modelAttribute="cuenta" >
		
		  <div class="form-group">
		    <form:input type="text" class="form-control" id="nombre" path="nombre" placeholder="Nombre" required="required"/>
		  </div>
		  <div class="form-group">
		    <form:input type="text" class="form-control" id="ap_pat" path="ap_pat" placeholder="Apellido Paterno" required="required"/>
		  	
		  </div>
		  <div class="form-group">
		    <form:input type="text" class="form-control" id="ap_mat" path="ap_mat" placeholder="Apellido Materno" required="required"/>
		  	
		  </div>
	  
	  <div class="form-group">
	    <form:input type="email" class="form-control" id="email" path="email" placeholder="Dirección de correo elecotronico" required="required"/>
	  		
	  </div>
	  <div class="form-group">
	    <form:input type="password" class="form-control" id="contr" path="contr" placeholder="Contraseña" required="required"/>
	  </div>
	  <div class="text-center">
	  <button type="submit" class="btn btn-outline-success" value="Agregar" name="guardarCuenta">Crear Cuenta</button>
	  </div>
	</form:form>
</div>
</div>
</body>
</html>
