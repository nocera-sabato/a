
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, model.User, Controller.*"%>
  


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<jsp:include page="header.jsp" />



	<form action="Checklogin" method="post">
		<fieldset>
			
			<label for="username">Login</label>
			<input id="username" type="text" name="username" placeholder="enter login" class="LR" autofocus >
			<br>
			<label for="password">Password</label>
			<input id="password" type="password" name="password" placeholder="enter password" class="LR">
			<br>
			<input type="submit" value="login" class="LR">
			<input type="reset" value="Reset" class="LR">
		</fieldset>
	</form>
	<br>
	
<%@ include file="../html/footer.html" %>			
</body>
</html>