<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html style="font-family: ABeeZee, sans-serif;font-size: 20px;">
<style type="text/css">
input {
  border: none;
  border-bottom: 2px solid #ffffff;
}

.btn.btn-default:hover {
  color: #6C3313;
  background-color: #ffffff;
}

.btn.btn-default {
  /*text-decoration: none;*/
  /*padding: 10px;*/
  /*font-weight: 600;*/
  /*font-size: 20px;*/
  color: #ffffff;
  /*font-family: Arial;*/
  background-color: Transparent;
  border: 2px solid #ffffff;
}
.center {
  text-align: center;
  }

</style>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
   
    <title>Deli Express</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=ABeeZee:400,400i">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
    <link rel="stylesheet" href="assets/css/styles.css">
    <script
	 	src="https://code.jquery.com/jquery-3.4.1.min.js"
	 	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	 	crossorigin="anonymous"></script>
	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
</head>

<body class="text-center" style="background-color: #6c3313;color: rgb(255,255,255);font-family: ABeeZee, sans-serif;font-size: 18px;margin: 58px;padding: 0px;">
    <div class="center">
    <h1 style="font-size: 86px;height: 53px;padding: 75px;margin: 58px;">Deli Express</h1>
   <form action="login" method="post" >
	    
         <input type="text" placeholder="example@email.com" inputmode="email" required="@" name="email" style="filter: blur(0px) brightness(100%) invert(0%);color: rgb(255,255,255);background-color: #6c3313;font-size: 25px;font-family: Lato, sans-serif;padding: 0px;margin: 30px;height: 60px;width: 440px;">
         <br>
         <input type="password" placeholder="contraseña" inputmode="password"  name="password" style="filter: blur(0px) brightness(100%) invert(0%);color: rgb(255,255,255);background-color: #6c3313;font-size: 25px;font-family: Lato, sans-serif;padding: 0px;margin: 30px;height: 60px;width: 440px;">
         <br>${message}
         <br>         
         <button class="btn btn-default active btn-lg" type="submit" style="font-size: 25px;font-family: Lato, sans-serif;width: 186px;height: 56px;margin: 30px;">Iniciar sesión</button>
    	 	
    </form>
    <section></section>
    	 <button onclick="location.href = 'agregarCliente';" id="myButton" class="btn btn-default active btn-lg"  style="font-size: 25px;font-family: Lato, sans-serif;width: 186px;height: 56px;margin: 30px;">Registrarme</button>
	    
    </div>
</body>
<script type="text/javascript">
    document.getElementById("myButton").onclick = function () {
        location.href = "agregarCliente";
    };
</script>
<script type="text/javascript">
 
    $(document).ready(function() {
        $("#login").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                },
         		password: "required",
            },
            messages: {
                email: {
                    required: "Please enter email",
                    email: "Please enter a valid email address"
                },
                password: "Please enter password"
            }
        });
    });
</script>
</html>