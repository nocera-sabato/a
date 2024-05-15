<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page contentType="text/html; charset=UTF-8"  import="java.util.*,model.game, model.Cart,model.User,model.Ordine"%>
     <%
 
	User user = (User) request.getSession().getAttribute("user");
	 if(user == null){
		response.sendRedirect("./getUser");
		return;
	} 
	 
	 Collection<?> orders = (Collection<?>) request.getAttribute("orders");
	if((orders == null)&&(request.getAttribute("ordini")==null)){ //verifico 2 condizioni se orders sono vuoti perche non ci sono o non sono stati caricati ancora
			request.getSession().setAttribute("Account", "Account.jsp");
			request.getSession().setAttribute("sortUser",user.getLogin());
		 response.sendRedirect("./Ordini"); //?sort="+user.getLogin()
	}
	
	
	%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/AccountTableFormatter.js"></script>
<meta charset="UTF-8">
<title>Account</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h1>
	<table id="acc" style="border solid 1px">
		<tr>
			<td>nome: </td><td><%= user.getNome() %> </td>
		</tr>
		<tr>
			<td>cognome: </td><td><%= user.getCognome() %> </td>
		</tr>
		<tr>
			<td>data di nascita: </td><td><%= user.getDataNascita() %> </td>
			</tr>
			<tr>
			<td>Saldo sul conto : </td><td><%= user.getQuantity() %> </td>
			</tr>
			<tr>
			<td>Sei un : </td><td><%= user.getRole() %> </td>
			</tr>
			<tr>
			<td>Il tuo login: </td><td><%= user.getLogin() %> </td>
			</tr>
	</table>
	</h1>
	<table id="AccountOrdiniTable" border="1">

		<tr class="head">
		<th>NomeGioco </th>
		<th>Prezzo </th>
		<th>Quantita</th>
		<th>Data e Ora di vendita </th>
		<th>Iva sul gioco</th>
		<th>Fattura numero </th>
		<th>Totale fattura </th>
		
		  
		</tr>
		
		<%
		int i= 0;
		if (orders != null && orders.size() != 0) {
			Iterator<?> it = orders.iterator();
			while(it.hasNext()) { //while
				Ordine order = (Ordine) it.next();
				// total = ((order.getTotale()/100*order.getIva()) + order.getTotale());
	%>

	
		
	<tr>
	
     <td><%=order.getNomeGame()%></td>
     <td class="totale<%=i%>"><%=order.getTotale()%></td>
     <td class="quantita<%=i%>"><%=order.getQuant()%></td>
     <td><%=order.getDate()%></td>
     <td class="iva<%=i%>"><%=order.getIva()%>%</td>
     <td class="fattura<%=i%>"><%=order.getFattura()%></td>
     <td class="result<%=i%>"></td>
	</tr>	
	<%
	i++;
			}
		} else {
	%>
	<tr>
		<td colspan="1">Non hai nessun acquisto!</td>
	</tr>
	<%
		}
	%>
	</table> 
	
	<%@ include file="html/footer.html" %>	
</body>
</html>