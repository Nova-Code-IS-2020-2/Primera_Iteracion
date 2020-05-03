<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html style="font-family: ABeeZee, sans-serif;font-size: 20px;">
<style type="text/css">
.page_name {
  	text-align: center;
 	padding: 60px 0;
}

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
</style>


<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Deli Express - Administrador</title>
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script> 
		$(function(){
  		$("#header").load("menuportatil.html");
		});
	</script>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=ABeeZee">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>

<body>
	<div id="header"></div>
    <div class="container page_name">
        <h1 style="margin: 30 px;">DeliExpress</h1>
        <div><a class="btn btn-primary shadow" role="button" style="margin: 10px;padding: 9px 12px;color: #6c3313;background-color: rgb(255,255,255); border: 1px solid #6c3313!important; border-style: groove;" href="/DeliExpress/repartidorAdmin">Ver Repartidores</a></div>
        <div><a class="btn btn-primary shadow" role="button" style="margin: 10px;padding: 9px 12px;color: #6c3313;background-color: rgb(255,255,255); border: 1px solid #6c3313!important; border-style: groove;" href="/DeliExpress/menuAdmin">Editar Menú</a></div>
        <div><a class="btn btn-primary shadow" role="button" style="margin: 10px;padding: 9px 12px;color: #6c3313;background-color: rgb(255,255,255); border: 1px solid #6c3313!important; border-style: groove;" href="">Ordenes</a></div>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
