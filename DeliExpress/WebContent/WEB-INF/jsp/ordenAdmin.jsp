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
        <title>Orden</title>
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=ABeeZee">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Actor">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  </head>

  <body>
	<jsp:directive.include file="/menuportatilAdmin.html"/>
    <div class="container page-name">
      <h1 style="font-family: ABeeZee, sans-serif;">DeliExpress</h1>
      <h3 class="categorias" style="font-family: Actor, sans-serif;">Orden </h3>
      <div class="table-responsive table-bordered border rounded shadow">
          <table class="table table-striped table-bordered" >
              <thead>
                  <tr>
                      <td class="border border-light shadow-sm" style="color:#6C3313 ;background-color: #ffffff;" >Nombre Cliente</td>
                      <td class="border border-light shadow-sm" style="color:#6C3313 ;background-color: #ffffff;">Precio Total</td>
                      <td class="border border-light shadow-sm" style="color:#6C3313 ;background-color: #ffffff;">Dirección</td>
                  </tr>
                  <tr>
                      <td style="border: 1px solid #ffffff!important;">${cliente.getNombre()} ${cliente.getApPat()} ${cliente.getApMat()}</td>
                      <td style="border: 1px solid #ffffff!important;">${orden.getPrecio()}</td>
					  <td style="border: 1px solid #ffffff!important;">${cliente.getDireccion()}</td>
                  </tr>
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
