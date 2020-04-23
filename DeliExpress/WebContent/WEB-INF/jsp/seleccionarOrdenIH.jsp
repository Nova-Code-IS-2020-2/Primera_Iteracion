<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
            <h1>Hola ${rep.getNombre()} las ordenes disponibles son</h1>
            <table border="1">
                <th>direccion</th>
                <th>Action</th>
                <c:forEach var="d" items="${did}" varStatus="status">
                <tr>
                    <td>${d[0]}</td>
                    <td>
                    	<a href="/DeliExpress/seleccionarOrden?idOrden=${d[1]}&direc=${d[0]}&idRep=${rep.getIdRepartidor()}">Seleccionar</a>
                    </td>
                </tr>
                </c:forEach>             
            </table>
        </div>
</body>
</html>