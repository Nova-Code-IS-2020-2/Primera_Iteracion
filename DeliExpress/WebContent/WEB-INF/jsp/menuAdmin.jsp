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
 			$("#header").load("menuportatilAdmin.html");
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
            class="btn btn-primary border rounded shadow-sm" role="button" style="color: #6c3313; background-color: #ffffff; border: 1px solid #6c3313!important;">+Categoría</a>
          &nbsp;&nbsp;&nbsp;
          <a href="/DeliExpress/agregarAlimento"
            class="btn btn-primary border rounded shadow-sm" role="button" style="color: #6c3313; background-color: #ffffff; border: 1px solid #6c3313!important;">+Alimento</a>
          &nbsp;&nbsp;&nbsp;
        </div>

      </div>
      <h3 class="categorias" style="font-family: Actor, sans-serif;">Menú de alimentos </h3>
      <div class="table-responsive table-bordered border rounded shadow">
          <table class="table table-striped table-bordered" >
              <thead> </thead>
              <tbody>
                  <c:forEach var="elem" items="${menu}" varStatus="status">
                  <tr>
                      <td style="border: 1px solid #ffffff!important; background-color: #ffffff;""  width="10%"></td>
                      <td style="border: 1px solid #ffffff!important;" width="60%">${elem.key.getNombre()}</td>
                      <td style="border: 1px solid #ffffff!important; background-color: #ffffff;"" width="10%"></td>
                      <td style="border: 1px solid #ffffff!important;" >
                          <div class="btn-group" role="group">
				          	<a  href="/DeliExpress/editarCategoria?id=${elem.key.getId()}"
				            	class="btn btn-primary border rounded shadow-sm" role="button" style="color: #6c3313; background-color: #ffffff; border: 1px solid #6c3313!important; ">Editar</a>
          					&nbsp;&nbsp;&nbsp;
          					<a href="/DeliExpress/borrarCategoria?id=${elem.key.getId()}"
          						class="btn btn-primary border rounded shadow-sm" role="button" style="color: #6c3313; background-color: #ffffff; border: 1px solid #6c3313!important;">Borrar</a></div>
          				<div class="btn-group" role="group"></div>
                      </td>
                    </tr>
                    <tr>
                      <table class="table table-striped table-bordered" >
                      <c:forEach var="alimento" items="${elem.value}" varStatus="status">
                      <tr>
                      	 <td style="border: 1px solid #ffffff!important;" width="25%" >
                      	 	<img src="${pageContext.request.contextPath}/${alimento.getDireccionFoto()}" alt="${alimento.getNombre() }" width="100%" >
                      	 </td>
                      	 <td width="55%">
                      	 	<table>
                      	 		<tr>
								 	<td class="border border-light shadow-sm" style="border: 1px solid #6C3313!important;color:#6C3313 ;background-color: #ffffff;" width="70%">${alimento.getNombre() }</td>
								 	<td class="border border-light shadow-sm" style="border: 1px solid #6C3313!important;color:#6C3313 ;background-color: #ffffff;" width="30%">${alimento.getPrecio() }</td>
								 </tr>
								 <tr>
								 	<td class="border border-light shadow-sm" style="border: 1px solid #6C3313!important;color:#6C3313 ;background-color: #ffffff;" width="100%" colspan="2">${alimento.getDescripcion() }</td>
								 </tr>
                      	 	</table>

                      	 </td>
                      	 <td class="border border-light shadow-sm" style="border: 1px solid #6C3313!important;color:#6C3313 ;background-color: #ffffff;" width="30%">
                      	 	 <div class="btn-group" role="group">
				          	<a  href="/DeliExpress/editarAlimento?id=${alimento.getId()}"
				            	class="btn btn-primary border rounded shadow-sm" role="button" style="color: #6c3313; background-color: #ffffff; border: 1px solid #6c3313!important; ">Editar</a>
          					&nbsp;&nbsp;&nbsp;
          					<a href="/DeliExpress/borrarAlimento?id=${alimento.getId()}"
          						class="btn btn-primary border rounded shadow-sm" role="button" style="color: #6c3313; background-color: #ffffff; border: 1px solid #6c3313!important;">Borrar</a></div>
          					<div class="btn-group" role="group"></div>
			             </td>
                      </tr>

					 </c:forEach>
					 </table>
                  </tr>
                  </c:forEach>
              </tbody>
          </table>
      </div>
      </div>
      <script src="assets/js/jquery.min.js"></script>
      <script src="assets/bootstrap/js/bootstrap.min.js"></script>
  </body>

</html>
