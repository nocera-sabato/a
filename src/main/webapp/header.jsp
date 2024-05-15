<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.game, model.Cart,model.User"%>
    
  <%
	
	
	
  /*Cart cart = (Cart) request.getAttribute("cart");
	 if(cart == null){
		response.sendRedirect("./CreateCart");
		return;
	} */
	
	User user = (User) request.getSession().getAttribute("user");
	 if(user == null){
		 user = new User(null, null, null, 0, "Guest", null, null); 
	} 
	 else	request.getSession().setAttribute("user", user); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/buttonChange.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<title>GameMarket</title>
</head>
<body>



<div id="logoLogin">
	<div>
		<header id="headerL">
			<img src="img/logo1.jpeg" id="logo">
			<div id="textLogo">Migliori giochi a prezzi stracciati!</div>
			<span id="ricerca">
				<form action="Search" method="get">
				<input type="search" id="inputSearch" name="ricerca">
				<input type="submit" value="cerca" id="BSearch">
				</form> 
			</span>
			<div id="login">
			<span id="home"><a href="gameList"> <input type="button" value="home" class="LR"></a></span>
			<span id="LoginButton"><a href="LoginPage?value=Login"> <input type="button" value="Login" class="LR"></a></span>
			<span id="RegisterButton"><a href="LoginPage?value=Registrazione"><input type="button" value="Registrazione" class="LR"></a></span>
			<span id="Carrello"><a href="MyCart.jsp"><input type="button" value="Carrello" class="LR"></a></span>
			</div>
		</header>
	</div>
	
</div>


<!-- <div id="navmenuaside">

<nav id="navnav">
 	<ul class="nav">
 		<li><a href="#" >Primo piano</a> </li>
 		<li><a href="#" >Sconti</a></li>
 		<li><a href="#" >Categorie</a>
 		<ul id="undernav"> 
 		<li><a href="#" >RPG</a></li>
 		<li><a href="#" >Action</a></li>
 		<li><a href="#" >Strategy</a></li>
 		<li><a href="#" >Simulator</a></li>
 		</ul>
 		</li>
 	</ul>
</nav>



</div> -->


<% if(user.getLogin()!=null){ %>
	
	<script >
	var balance = "<%=user.getQuantity()%>";
	logged(balance)
	</script>
	
<%} %>
</body>
</html>