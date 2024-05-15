<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.game, model.Cart,model.User,model.Ordine"%>
    <%
    Collection<?> orders = (Collection<?>) request.getAttribute("orders");
    User user = (User) request.getSession().getAttribute("user");
	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ordini</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/OdiniTable.js"></script>
</head>
<body>
<jsp:include page="header.jsp" />
<%-- <% if(user.getLogin()!=null){ %>
<span id="account"><a href="Account.jsp"> <input type="button" value="account" class="LR"></a></span>
<span id="logout"><a href="Logout"> <input type="button" value="Logout" class="LR"></a></span>
<%} %> --%>
<% if(user==null) response.sendError(response.SC_BAD_REQUEST, "Sessione scaduta!");
	else 

	if(user.getRole()!=null)
	if(user.getRole().equalsIgnoreCase("admin")){ %>
<span id="acc_manage"><a href="AccountManage"> <input type="button" value="Account Manage" class="LR" style="
    width: fit-content;"></a></span>
<span id="game_manage"><a href="GameManage"> <input type="button" value="Game Manage" class="LR"></a></span>
<span id="ordini"><a href="Ordini"> <input type="button" value="Ordini" class="LR"></a></span>
<span id="addGame"><a href="addGame.jsp"> <input type="button" value="addGame" class="LR"></a></span>

<table id="AccountOrdiniTable" border="1">


		<tr class="head">
		<th><a href="Ordini?type=Simple&sort=nome_utente">NomeUtente </a></th> 
		<th><a href="Ordini?type=Simple&sort=nome">NomeGioco </a></th>
		<th><a href="Ordini?type=Simple&sort=totale">Prezzo </a></th>
		<th><a href="Ordini?type=Simple&sort=quantita">Quantita </a></th>
		<th><a href="Ordini?type=Simple&sort=buyed">Data e Ora di vendita </a></th>
		<th><a href="Ordini?type=Simple&sort=iva">Iva sul gioco </a></th>
		<th>Fattura numero </th>
		<th>Totale fattura </th>
		
		  
		</tr>
		
		<%
		int i= 0;
		if (orders != null && orders.size() != 0) {
			Iterator<?> it = orders.iterator();
			while(it.hasNext()) { //while
				Ordine order = (Ordine) it.next();
	%>

	
		
	<tr>
	 <td><a href="Ordini?type=NU&sort=<%=order.getNomeUtente()%>"><%=order.getNomeUtente()%></a></td>
     <td><a href="Ordini?type=NG&sort=<%=order.getNomeGame()%>"><%=order.getNomeGame()%></a></td>
     <td class="totale<%=i%>"><a href="Ordini?type=Totale&sort=<%=order.getTotale()%>"><%=order.getTotale()%></a></td>
     <td class="quantita<%=i%>"><a href="Ordini?type=Quant&sort=<%=order.getQuant()%>"><%=order.getQuant()%></a></td>
     <td><a href="Ordini?type=Date&sort=<%=order.getDate()%>"><%=order.getDate()%></a></td>
     <td class="iva<%=i%>"><a href="Ordini?type=Iva&sort=<%=order.getIva()%>"><%=order.getIva()%>%</a></td>
     <td class="fattura<%=i%>"><a href="Ordini?type=Fattura&sort=<%=order.getFattura()%>"><%=order.getFattura()%></a></td>
     <td class="result<%=i%>"></td>
	</tr>	
	<%
	i++;
			} //while
		} else {
	%>
	<tr>
		<td colspan="1">No products available</td>
	</tr>
	<%
		}
	%>
	</table> 
	<h2>Scegli range di data</h2>
	<form action="Ordini" method="get">
	<input type="hidden" name="type" value="Special">
	Prima data -> <input type="date" name="sort" required pattern="\d{4}\\\d{2}\\d{2}"> <br>
	Seconda data ->  <input type="date" name="sort2" required pattern="\d{4}\\\d{2}\\d{2}"> 
	<input type="submit" value="Sort">
	</form>
	
	<%} %>
	<br>
<%@ include file="html/footer.html" %>		
	
</body>
</html>