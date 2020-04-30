
<html>
<head>
<title>Example</title>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script> 
$(function(){
  $("#header").load("menuportatil.html");
});
</script> 
<style type="text/css">
body {
	background-color: #6C3313 ;
	margin-top: 10%;
}
.boton_personalizado{
    text-decoration: none;
    padding: 10px;
    font-weight: 600;
    font-size: 20px;
    color: #ffffff;
    font-family: Arial;
    background-color: #6C3313;
    border: 2px solid #ffffff;
  }
.boton_personalizado:hover{
    color: #6C3313;
    background-color: #ffffff;
}

input {
  width: 20%;
  padding: 10px;
  font-weight: 600;
  font-size: 12px;
  color: #ffffff;
  font-family: Arial;
  padding: 12px 20px;
  margin: 8px ;
  background-color: #6C3313;
  border: 2px solid #ffffff;
}

.title{
	margin: 180px;
	padding: 150px;
    font-weight: 600;
    font-size: 60px;
    color: #ffffff;
    font-family: Arial;
}


</style>

</head>
<body>${message}
<div id="header"></div>
<div class="container">

	<div style='text-align:center;'>
        <a class="title">PRUEBA</a>
    </div>
        
    <div style='text-align:center;'>
        <input type="text" class="form-control" name="username"required placeholder="example@dom.com">
    </div>
    
    <div style='text-align:center;'>
        <input type="password" class="form-control" name="password"required>
    </div>
    
    <div style='text-align:center;'>
    	<button type="submit" class="boton_personalizado" >Login</button>
    </div>

         
</div>
</body>
</html>