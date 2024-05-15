<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.game, model.Cart,model.User"%>
    <%
    Collection<?> games = (Collection<?>) request.getSession().getAttribute("games");
    if(games == null) {
		response.sendRedirect("./gameList");	
		return;
	}
    User user = (User) request.getSession().getAttribute("user");
	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account manage</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<jsp:include page="header.jsp" />

<%	if(user==null) response.sendError(response.SC_UNAUTHORIZED, "Sessione scaduta!");
	else 
		
		if (user.getRole().equalsIgnoreCase("admin")){ %>
<span id="acc_manage"><a href="AccountManage"> <input type="button" value="Account Manage" class="LR" style="
    width: fit-content;"></a></span>
<span id="game_manage"><a href="GameManage"> <input type="button" value="Game Manage" class="LR"></a></span>
<span id="ordini"><a href="Ordini"> <input type="button" value="Ordini" class="LR"></a></span>
<span id="addGame"><a href="addGame.jsp"> <input type="button" value="addGame" class="LR"></a></span>
<%} %>
<table border="1">
		<tr class="head1">
		<th><a href="gameList?sort=nome&page=admin">Titolo</a></th>
		<th><a href="gameList?sort=quantita&page=admin">Quantita</a></th>
		<th><a href="gameList?sort=years DESC&page=admin">Data Uscita</a></th>
		<th><a href="gameList?sort=added DESC&page=admin">Aggiunto</a></th>
		<th><a href="gameList?sort=price&page=admin">Prezzo</a></th>
		<th><a href="gameList?sort=iva&page=admin">iva</a></th>
		<th>Descrizione</th>
		
		<th>Action</th>
		</tr>
		
		<%
		int i =0;
		if (games != null && games.size() != 0) {
			Iterator<?> it = games.iterator();
			while (it.hasNext()) { //while
				game bean = (game) it.next();
	%>
	<tr>
	<td class="GameManage">	<%=bean.getName()%></td>
	<td class="GameManage">	<%=bean.getQuantity()%></td>
	<td class="GameManage">	<%=bean.getYears()%></td>
	<td class="GameManage">	<%=bean.getAdded()%></td>
	<td class="GameManage">	<%=bean.getPrice()%></td>
	<td class="GameManage">	<%=bean.getIva()%>%</td>
	<td class="GameManage">	<%=bean.getDesc()%></td>
	
	<td> <a href="gameList?action=delete&nomeGame=<%=bean.getName() %>">1.Delete</a> 
	
	<input type="number" onfocusout="myFunction(this)"  id="Info" class="p p<%=i%>"  required style="text-align: center; " ><br>
	
	 <a class="p<%=i%>" href="gameList?action=mod&nomeGame=<%=bean.getName() %>&type=i&num=1">2. Set Iva</a> <br>
	 <a class="p<%=i%>" href="gameList?action=mod&nomeGame=<%=bean.getName() %>&type=q&num=1">3. Set Quantita</a> <br>
	 <a class="p<%=i%>" href="gameList?action=mod&nomeGame=<%=bean.getName() %>&type=p&num=1">4. Set Prezzo</a> </td>

	</tr>	
	<%
	i++;
			}
		} else {
	%>
	<tr>
		<td colspan="8">No products available</td>
	</tr>
	<%
		}
	%>
	</table> 
	<br>
	
	
<%@ include file="html/footer.html" %>		
	<script>
	function myFunction(valore){
		
		  let inputAll = document.querySelectorAll('.p');
			let urlMod;
			for(var i of inputAll) {
	            m= i.value;
	            m = m.replace(/^[.]|\.$/g,"");
			     if (m != '') {
			    	 console.log("valore di ",m);
				    	urlMod= i.classList[1];  //leggo il secondo value del class p+numero
		                
					     let links = document.querySelectorAll("."+urlMod); //leggo <a> tags e input
		                c=3;
		                
					     while(links[c]!=undefined){ 
		                     
					    	 y = links[c].attributes[1].value; //leggo HREF da <a>
					    	 console.log("valore m ed y ",m," y =",y);
					    	 if(c<3)  m=m.replace(/\.\d+/,""); //in caso di float sostituisco con intero per iva e quantita
	                         y=y.replace(/\d*$|\d*\.\d*$/,m);		//aggiungo a HREF nuovo parametro per il GET
					    	 //y=y+"&num="+i.value;			
					    	 links[c].setAttribute("href",y); //nuovo valore di href
		                     c--;
					     }
			     }
          }
	}
	</script>
</body>
</html>