<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Manager Home</title>
    </head>
    <body>
        <div align="center">
            <h1>Los alimentos son los siguientes</h1>
            <table border="1">
                <th>No</th>
                <th>Name</th>
                <th>Action</th>
                 
                <c:forEach var="al" items="${alims}" varStatus="status">
                <tr>
                    <td>${al.getIdAlimento()}</td>
                    <td>${al.getNombreAlim()}</td>
                    <td>
                        <a href="/DeliExpress/agregarCarrito?idOrden=${idOrden}&idAlim=${al.getIdAlimento()}&idCliente=${idCliente}">Edit</a>
                    </td>
                             
                </tr>
                </c:forEach>  
                <a href="/DeliExpress/comprarComida?idOrden=${idOrden}">Presiona para comprar comida</a>           
            </table>
        </div>
    </body>
</html>