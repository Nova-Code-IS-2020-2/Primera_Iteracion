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
        <title>menuAdmin</title>
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
 			$("#header").load("menuportatil.html");
			});
		</script>
  </head>

  <body>
	<div id="header"></div>
    <div class="container page-name">
      <h1 style="font-family: ABeeZee, sans-serif;">DeliExpress</h1>
      <div class="btn-toolbar">
        <div class="btn-group" role="group">
          <a  href="/DeliExpress/agregarCategoria"
            class="btn btn-primary border rounded shadow-sm" role="button" style="color: #6c3313; background-color: #ffffff; border: 1px solid #6c3313!important; ">+Categoría</a>
          <a href="/DeliExpress/agregarAlimento"class="btn btn-primary border rounded shadow-sm" role="button" style="color: #6c3313; background-color: #ffffff; border: 1px solid #6c3313!important;">+Alimento</a></div>
          <div class="btn-group" role="group"></div>
      </div>
      <h3 class="categorias" style="font-family: Actor, sans-serif;">Menú de alimentos </h3>
      <div class="table-responsive table-bordered border rounded shadow">
          <table class="table table-striped table-bordered" >
              <thead>
                  <tr>
                      <th class="border border-light shadow-sm" style="color:#6C3313 ;background-color: #ffffff;" >Id</th>
                      <th class="border border-light shadow-sm" style="color:#6C3313 ;background-color: #ffffff;">Nombre</th>
                      <th class="border border-light shadow-sm" style="color:#6C3313 ;background-color: #ffffff;"></th>
                  </tr>
                  <c:forEach var="categoria" items="${listCat}" varStatus="status">
                  <tr>
                      <td style="border: 1px solid #ffffff!important;">${categoria.getId()}</td>
                      <td style="border: 1px solid #ffffff!important;">${categoria.getNombre()}</td>
                      <td style="border: 1px solid #ffffff!important;">
                          <a href="/DeliExpress/editarCategoria?id=${categoria.getId()}">Editar</a>
                          &nbsp;&nbsp;&nbsp;&nbsp;
                          <a href="/DeliExpress/borrarCategoria?id=${categoria.getId()}">Borrar</a>
                      </td>

                  </tr>
                  	 <table class="table table-striped table-bordered" >
			              <thead>
			                  <tr>
			                      <th class="border border-light shadow-sm" style="color:#6C3313 ;background-color: #ffffff;" >Id</th>
			                      <th class="border border-light shadow-sm" style="color:#6C3313 ;background-color: #ffffff;">Imagen</th>
			                      <th class="border border-light shadow-sm" style="color:#6C3313 ;background-color: #ffffff;">Nombre</th>
			                      <th class="border border-light shadow-sm" style="color:#6C3313 ;background-color: #ffffff;">Descripcion</th>
			                      <th class="border border-light shadow-sm" style="color:#6C3313 ;background-color: #ffffff;">Precio</th>
			                  </tr>
			                  <c:forEach var="alimento" items="${listAlim(categoria)}" varStatus="status">
			                  <tr>
			                      <td style="border: 1px solid #ffffff!important;">${alilmento.getId()}</td>
			                      <td style="border: 1px solid #ffffff!important;">${alilmento.getFoto()}</td>
			                      <td style="border: 1px solid #ffffff!important;">${alimento.getNombre()}</td>
			                      <td style="border: 1px solid #ffffff!important;">${alilmento.getDescripcion()}</td>
			                      <td style="border: 1px solid #ffffff!important;">${alilmento.getPrecio()}</td>
			                      <td style="border: 1px solid #ffffff!important;">
			                          <a href="/DeliExpress/editarAlimento?id=${alimento.getId()}">Editar</a>
			                          &nbsp;&nbsp;&nbsp;&nbsp;
			                          <a href="/DeliExpress/menuAdmin?id=${alimento.getId()}">Borrar</a>
			                      </td>
			
			                  </tr>
			                  </c:forEach>
			              </thead>
			              <tbody>
			                  <tr></tr>
			              </tbody>
			          </table>
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

