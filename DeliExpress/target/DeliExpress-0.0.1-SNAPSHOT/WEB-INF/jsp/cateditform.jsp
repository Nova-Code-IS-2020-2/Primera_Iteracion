<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
	<h1>Editar Categoria</h1>  
    	<form:form method="POST" action="/SpringMVCCRUDSimple/editsave">    
        	<table >    
        		<tr>  
        			<td></td>    
         			<td><form:hidden  path="id" /></td>  
         		</tr>   
         		<tr>    
          			<td>Nombre : </td>   
         			<td><form:input path="name"  /></td>  
         		</tr>      
           
         		<tr>    
          			<td> </td>    
          			<td><input type="submit" value="Edit Save" /></td>    
         		</tr>    
        	</table>  
        </form:form>