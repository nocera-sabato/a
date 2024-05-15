<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.game, model.Cart,model.User"%>
    <%
    Collection<?> Users = (Collection<?>) request.getAttribute("users");
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

<% if(user==null) response.sendError(response.SC_BAD_REQUEST, "Sessione scaduta!");
else {
	if(user.getRole()!=null)
	if(user.getRole().equalsIgnoreCase("admin")){ %>
<span id="acc_manage"><a href="AccountManage"> <input type="button" value="Account Manage" class="LR" style="
    width: fit-content;"></a></span>
<span id="game_manage"><a href="GameManage"> <input type="button" value="Game Manage" class="LR"></a></span>
<span id="ordini"><a href="Ordini"> <input type="button" value="Ordini" class="LR"></a></span>
<span id="addGame"><a href="addGame.jsp"> <input type="button" value="addGame" class="LR"></a></span>

<%}} %>
<table border="1" style="width:100%">
		<tr class="head">
		<th> <a href="AccountManage?Sort=nome_utente">Login</a></th>
		<th>Password</th>
		<th> <a href="AccountManage?Sort=nome">Nome</a></th>
		<th> <a href="AccountManage?Sort=cognome">Cognome</a></th>
		<th> <a href="AccountManage?Sort=balance DESC">Saldo</a></th>
		<th> <a href="AccountManage?Sort=role">Ruolo</a></th>
		<th>Action</th>
		<th>Action</th>
		<th>Action</th>
		</tr>
		
		<%
		if (Users != null && Users.size() != 0) {
			Iterator<?> it = Users.iterator();
			while(it.hasNext()) { //while
				User utente = (User) it.next();
	%>

	
		
	<tr>
	<td class="AccManage">	<%=utente.getLogin()%></td>
	<td class="AccManage">	<%=utente.getPass()%></td>
	<td class="AccManage">	<%=utente.getNome()%></td>
	<td class="AccManage">	<%=utente.getCognome()%></td>
	<td class="AccManage">	<%=utente.getQuantity()%></td>
	<td class="AccManage">	<%=utente.getRole()%></td>
	<%if(utente.getRole().compareTo("admin")!=0){ %>
	 <td>  <a href="AccountManage?action=delete&id=<%=utente.getLogin() %>">Delete</a></td>
	 <td>  <a href="AccountManage?action=manager&id=<%=utente.getLogin() %>">Set Manager</a></td>
	 <td> <a href="AccountManage?action=admin&id=<%=utente.getLogin() %>">Set Admin </a></td>
	 <%}
		else{
	%>
		<td> </td>
		<td> </td>
		<td> </td>
		<%} %>
		
		
	</tr>	
	<%
			}//while
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
	
</body>
</html>