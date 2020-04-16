<html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Categorias</h1>  
<table >  
<tr><th>Id</th><th>Nombre</th><th>Editar</th></tr>  
   <c:forEach var="cat" items="${list}">   
   <tr>  
   <td>${cat.id_cat}</td>  
   <td>${cat.nombre_cat}</td>    
   <td><a href="editemp/${cat.id_cat}">Edit</a></td>  
   <td><a href="deleteemp/${cat.id_cat}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="/DeliExpress/agregarCategoria">Agregar nueva Categoria</a> 
  
</html>