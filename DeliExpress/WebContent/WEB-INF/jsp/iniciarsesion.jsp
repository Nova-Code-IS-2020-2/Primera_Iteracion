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

</style>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>iniciarsesion</title>
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
    <h1 style="font-size: 86px;height: 53px;padding: 75px;margin: 58px;">Deli Express</h1>
    <form action="login" method="post">
	    <label for="email">Email:</label>
         <input name="email" size="30" />
         <br><br>
         <label for="password">Password:</label>
         <input type="password" name="password" size="30" />
         <br>${message}
         <br><br>           
         <button type="submit">Login</button>
    </form>
</body>
<script type="text/javascript">
 
    $(document).ready(function() {
        $("#loginForm").validate({
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