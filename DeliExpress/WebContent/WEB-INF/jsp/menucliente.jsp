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
	.btn.btn-default:hover {
	  color: #fff;
	  background-color: #6C3313;
	}
	
	.btn.btn-default {
	  /*text-decoration: none;*/
	  /*padding: 10px;*/
	  /*font-weight: 600;*/
	  /*font-size: 20px;*/
	  color: #6C3313;
	  /*font-family: Arial;*/
	  background-color: Transparent;
	  border: 2px solid #6C3313;
	}

 	
  </style>
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>menu cliente</title>
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
	<jsp:directive.include file="/menuportatil.html"/>
    <div class="container page-name">
      <h1 style="font-family: ABeeZee, sans-serif;">DeliExpress</h1>
      
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
                      </td>
                    </tr>
                    <tr>
                      <table class="table table-striped table-bordered" >
                      <c:forEach var="alimento" items="${elem.value}" varStatus="status">
                      <tr>
                      	 <td style="border: 1px solid #ffffff!important;" width="25%" ><img src="${pageContext.request.contextPath}/${alimento.getDireccionFoto()}" alt="${alimento.getNombre()}" width="100%"></td>
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
				          	<a  href="/DeliExpress/agregarCarrito?id_alim=${alimento.getId()}" class="btn btn-default active btn-lg"  style="font-size: 25px;font-family: Lato, sans-serif;width: 186px;height: 56px;margin: 30px;">Seleccionar</a>
          					&nbsp;&nbsp;&nbsp;

          					<div class="btn-group" role="group"></div>
			             </td>
                      </tr>
					 
					 </c:forEach>
					 </table>
                  </tr>
                  </c:forEach>
              </tbody>
          </table>
          <a  href="carrito"class="btn btn-default active btn-lg" role="button" style="font-size: 25px;font-family: Lato, sans-serif;width: 186px;height: 56px;margin: 30px;">Carrito</a>
          				
      </div>
      </div>
      <script src="assets/js/jquery.min.js"></script>
      <script src="assets/bootstrap/js/bootstrap.min.js"></script>
  </body>

</html>