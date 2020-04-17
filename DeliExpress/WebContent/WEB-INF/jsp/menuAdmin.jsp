<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrar Menú</title>
    </head>
    <body>
        <div align="center">
            <h1>Categorías</h1>
            <h3><a href="/DeliExpress/agregarCategoria">Agregar Categoría</a></h3>
            <table border="1">
                <th>No</th>
                <th>Nombre</th>
                 
                <c:forEach var="categoria" items="${listCat}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${categoria.getNombre()}</td>
                    <td>
                        <a href="/editContact?id=${categoria.getId()}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/deleteContact?id=${categoria.getId()}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>