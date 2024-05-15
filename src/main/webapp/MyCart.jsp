
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.game, model.Cart,model.User"%>
    
  <%
		
  User user = (User) request.getSession().getAttribute("user");
  if(user == null){
		 user = new User(null, null, null, 0, "Guest", null, null); 
	} 
	Cart cart = (Cart) request.getSession().getAttribute("cart");
	game gioco;
	String nome = request.getParameter("newCart");
	String valore="1";
	if(nome!=null)
		valore= request.getParameter("newValue");
	%>
 
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>GameMarket</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/SaldoCheck.js"></script>
</head>
<body>
<jsp:include page="header.jsp" />

<script>
	const unita = new Map();
</script>


<% if(user.getRole()!=null)
	if(user.getRole().equalsIgnoreCase("admin")){ %>
<span id="acc_manage"><a href="AccountManage"> <input type="button" value="Account Manage" class="LR"></a></span>
<span id="game_manage"><a href="GameManage"> <input type="button" value="Game Manage" class="LR"></a></span>
<span id="ordini"><a href="Ordini"> <input type="button" value="Ordini" class="LR"></a></span>
<%} %>


<% if((cart != null)&&(cart.size()>0)) { %>
		<h2>Cart</h2>
		<table id="CartTable" border="1">
		<tr class="head">
			<th>Nome</th>
			<th>Quantita</th>
			<th>Unita disponibili</th>
			<th>Prezzo unita</th>
			<th>Totale</th>
			<th>Iva</th>
			<th>Rimuovi</th>
		</tr>
		<% Float totale = 0f,iva = 0f;
			int i=0;
		List<game> prodcart = cart.getProducts(); 	
		   for(game beancart: prodcart) {
			   totale = totale + beancart.getPrice()*beancart.getCQ();
			   if(iva==0f) iva = iva + beancart.getIva();
			   else iva = (iva + beancart.getIva())/2;
			   
			   if(nome!=null)
			   if(nome.compareTo(beancart.getName())==0)
				   beancart.setCQ(Integer.parseInt(valore));
			   
		%>
		
		<script>
			unita.set("<%=beancart.getName()%>",<%=beancart.getCQ()%>);
		</script>
		
		<tr>
			<td class="Contenuto"><%=beancart.getName()%></td>
			<td class="Contenuto"><input class="Quantita <%="element"+i%>" type="number" min="1" max="<%=beancart.getQuantity()%>" value="<%=beancart.getCQ()%>" onchange="CartQuant(`<%=beancart.getName()%>`,'<%=beancart.getQuantity()%>',this)"></td>
			<td class="Contenuto"><%=beancart.getQuantity()%></td>
			<td class="unita<%="element"+i%> Contenuto"><%=beancart.getPrice()%>$</td>
			<td class="price <%="element"+i%> Contenuto"><%=beancart.getPrice()%>$</td>
			<td class="Contenuto"><%=beancart.getIva()%>%</td>
			<td class="Contenuto"><a class="deleteX" href="Paga?delete=<%=beancart.getName()%> ">X</a></td>
		</tr>
		<%i++;} %>
		<tr>
		<td class="NoMob"></td>
		<td>Imponibile</td>
		<td class="imponibile"><%=totale%>$</td>
		<td> iva <%=iva %>%</td>
		<td class="totale" colspan="3">Totale <%=totale+totale/100*iva%>$</td>
		</tr>
	</table>
	<span id="buttonPay"><a  href="Paga"><input type="button" value="Paga" class="LR" >	</a></span>
	<span id="Svuota"><a  href="Svuota"><input type="button" value="Svuota" class="LR" >	</a></span>
	<% }
		else
	%>	<h1>Carello vuoto!</h1>
	<% %>
	<br>
<%@ include file="html/footer.html" %>			
</body>
</html>