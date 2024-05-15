
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.game, model.Cart,model.User"%>
    
  <%
  
  
  
  User user = (User) request.getSession().getAttribute("user");
	 if(user == null){
		 user = new User(null, null, null, 0, "Guest", null, null); 
	} 
	 else	request.getSession().setAttribute("user", user);
	 
	 
  Collection<?> games = (Collection<?>) request.getSession().getAttribute("games");
  
  		  if(games == null) {
		response.sendRedirect("./gameList");	
		return;
	}  
  		
	
	
	Cart cart = (Cart) request.getSession().getAttribute("cart");
	
	
	
	 
	 
%>


 
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>GameMarket</title>
<link rel="stylesheet" type="text/css" href="css/style.css">


</head>
<body>

<jsp:include page="header.jsp" />
<h1 id="navJsp">Ciao <%= user.getNome() %>!</h1>

<% if(user.getRole()!=null)
	if(user.getRole().equalsIgnoreCase("admin")){ %>
<span id="acc_manage"><a href="AccountManage"> <input type="button" value="Account Manage" class="LR" ></a></span>
<span id="game_manage"><a href="GameManage"> <input type="button" value="Game Manage" class="LR"></a></span>
<span id="ordini"><a href="Ordini"> <input type="button" value="Ordini" class="LR"></a></span>
<span id="addGame"><a href="addGame.jsp"> <input type="button" value="addGame" class="LR"></a></span>
<%} %>
 
	<div id="sideBar">
	<form >
  	<fieldset style=" font-size: 1.5em;">
    <legend>Sort by</legend>
   	<input type="radio" id="nameUp" name="SortNome" value="nome ASC" checked>
   	<label for="nameUp">Nome(Crescente)</label><br>
  	<input type="radio" id="nameDown" name="SortNome" value="nome DESC" >
  	<label for="nameDown">Nome(Decrescente)</label><br>
  	<input type="radio" id="PriceUP" name="SortNome" value="price ASC" >
  	<label for="PriceUP">Prezzo crescente</label><br>
  	<input type="radio" id="PriceDown" name="SortNome" value="price DESC" >
  	<label for="PriceDown">Prezzo decrescente</label><br>
  	
  	
  	Genere
  		<select id="genereSelected" name="Sort" >
  			<option value="None" selected>Qualsiasi</option>
  			<option value="RPG">RPG</option>
    		<option value="SIMULATOR">SIMULATOR</option>
    		<option value="FPS" >FPS</option>
    		<option value="other">Altro</option>
  		</select>
  	<br>
  	<input type="checkbox" id="PEGUnder18" name="Sort" value="peg<18" >
  	<label for="PEGUnder18">PEG sotto 18</label><br>
  	<input type="checkbox" id="PEGOver18" name="Sort" value="peg=18" >
  	<label for="PEGOver18">PEG 18+</label><br>
  	<input type="button" value="Sort" onclick="Sorting()" style="width: 60%;font-size: 1em;background-color: rgb(96, 255, 64);">
  	
  	</fieldset>
	</form>
	
	<th><p class="carrello">Carrello</p></th>
		
		<div class="ContenutoCart">
		
		<table id="ContenutoCartTable">
		 <%  if(cart!=null){
			List<game> prodcart = cart.getProducts(); 	
			   for(game beancart: prodcart) {%>
			   	<tr> 
			   	 	<td><%= beancart.getName()%></td>
			   	</tr>
				  
		
			   
		   <% } //for
		   } //if%> 
		   </table>
		</div>
		
		
	</div>
	<div id="main">
			<%
			
		if ((games != null) &&( games.size() != 0)) {
			Iterator<?> it = games.iterator();
			while (it.hasNext()){  //while
					
					game bean = (game) it.next();
					%>
					
			<div class="container">
				<div class="img"><img class="foto" src="img/<%=bean.getImg()%>"></div>
				<div class="title"><%=bean.getName()%></div>
				<div class="descriptionGame">PEG : <%=bean.getPEG()%></div>
				<div class="descriptionGame">Quantita : <%=bean.getQuantity()%></div>
				<div class="descriptionGame">Prezzo : <%=bean.getPrice()%></div>
				<div class="descriptionGame">Genere : <%=bean.getGenere().toUpperCase()%></div>
				<div class="descriptionGameInfo"><%=bean.getDesc()%></div>
<%-- 				<a href="CreateCart?nome=<%=bean.getName()%>"><img class="cart" src=img/cart.png></a> --%>
			<a onclick="loadCart(`<%=bean.getName()%>`)"><img class="cart" src=img/cart.png> </a>
			</div>
	
	<%
		} //while	
		} //(games)
		
	%>
	</div>
	
	
	<br>
<script>
$(document).ready(function(){
    $(".container").on({
    
        mouseenter: function(){
            $(this).css("background-color", "black");
        },  
        
        mouseleave: function(){
            $(this).css("background-color", "#000c4b");
        }, 
        
        click: function(){
            $(this).css("background-color", "#109e2c");
        }
       
    });
});
</script>
<%@ include file="html/footer.html" %>			
</body>
</html>