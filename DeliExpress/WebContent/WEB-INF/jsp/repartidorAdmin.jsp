<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html style="font-family: ABeeZee, sans-serif;font-size: 20px;">
  <style type="text/css">
    .page-name {
      text-align: center;
      padding: 60px 0;
    }

    .h1, h1 {
      color: #bd6d10;
    }

    body {
      margin: 0;
      font-family: ABeeZee, sans-serif;
      font-size: 20px;
      font-weight: 400;
      line-height: 1.5;
      color: #bd6d10;
      text-align: left;
      background-color: #fff;
    }

    .h3, h3 {
      color: #6C3313;
      font-family: Actor, sans-serif;
    }

    table.table-striped.table-bordered{
      color:#ffffff;
      background-color: #6C3313;
      font-family: Actor, sans-serif;
    }
    btn.btn-primary.border.rounded.shadow-sm{
      background-color: #ffff;
      border: 1px solid #6c3313!important;
      border-style: groove;
    }


  </style>
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>repartidorAdmin</title>
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=ABeeZee">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Actor">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		<script>
			$(function(){
 				$("#header").load("menuportatilAdmin.html");
			});
		</script>
  </head>

  <body>
	<div id="header"></div>
    <div class="container page-name">
      <h1 style="font-family: ABeeZee, sans-serif;">DeliExpress</h1>
      <div class="btn-toolbar">
        <div class="btn-group" role="group"></div>
      </div>
      <h3 class="categorias" style="font-family: Actor, sans-serif;">Repartidores </h3>
      <div class="table-responsive table-bordered border rounded shadow">
          <table class="table table-striped table-bordered" >
              <thead>
                  <tr>
                      <th class="border border-light shadow-sm" style="color:#6C3313 ;background-color: #ffffff;" >Id</th>
                      <th class="border border-light shadow-sm" style="color:#6C3313 ;background-color: #ffffff;">Nombre</th>
                      <th class="border border-light shadow-sm" style="color:#6C3313 ;background-color: #ffffff;">aPAt</th>
                      <th class="border border-light shadow-sm" style="color:#6C3313 ;background-color: #ffffff;">aMat</th>
                      <th class="border border-light shadow-sm" style="color:#6C3313 ;background-color: #ffffff;">E-Mail</th>
                  </tr>
                  <c:forEach var="repartidores" items="${listRep}" varStatus="status">
                  <tr>
                      <td style="border: 1px solid #ffffff!important;">${repartidores.getId_repartidor()}</td>
                      <td style="border: 1px solid #ffffff!important;">${repartidores.getNombre()}</td>
                      <td style="border: 1px solid #ffffff!important;">${repartidores.getAPat()}</td>
                      <td style="border: 1px solid #ffffff!important;">${repartidores.getAMat()}</td>
                      <td style="border: 1px solid #ffffff!important;">${repartidores.getEmail()}</td>
                      <td style="border: 1px solid #ffffff!important;">${repartidores.getContr()}</td>
                      <td style="border: 1px solid #ffffff!important;">
                          <a href="/DeliExpress/editarRepartidor.jsp?id=${repartidores.getId_repartidor()}">Editar</a>
                          &nbsp;&nbsp;&nbsp;&nbsp;
                          <a href="/DeliExpress/borrarRepartidor.jsp?id=${repartidores.getId_repartidor()}">Borrar</a>
                      </td>
                  </tr>
                  </c:forEach>
              </thead>
              <tbody>
                  <tr></tr>
              </tbody>
          </table>
      </div>
      </div>
      <script src="assets/js/jquery.min.js"></script>
      <script src="assets/bootstrap/js/bootstrap.min.js"></script>
  </body>

</html>