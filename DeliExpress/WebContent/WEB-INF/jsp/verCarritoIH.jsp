<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tus alimentos son</title>
    </head>
    <body>
        <div align="center">
            <table border="1">
                <th>No</th>
                <th></th>
                <c:forEach var="al" items="${carrito.getAlimentos()}" varStatus="status">
                <tr>
                    <td>${al.getNombre()}</td>
                     <td>
                        <a href="/DeliExpress/eliminarCarrito?id_alim=${al.getId()}">Eliminar</a>
                    </td>
				</tr>       
				</c:forEach>
            </table>
              <a href="/DeliExpress/comprarComida">Comprar</a>
        </div>
    </body>
</html>