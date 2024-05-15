<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.game, model.Cart,model.User,model.Ordine"%>
    <%
    User user = (User) request.getSession().getAttribute("user");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ordini</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="css/styleR.css">
<script type="text/javascript" src="js/GameFormInsertCheck.js"></script>
</head>
<body>
<jsp:include page="header.jsp" />


<% if(user==null) response.sendError(response.SC_UNAUTHORIZED, "Sessione scaduta oppure non sei Autorizzato!");
else{
	if(user.getRole()!=null)
	if(user.getRole().equalsIgnoreCase("admin")){ %>
<span id="acc_manage"><a href="AccountManage"> <input type="button" value="Account Manage" class="LR" style="
    width: fit-content;"></a></span>
<span id="game_manage"><a href="GameManage"> <input type="button" value="Game Manage" class="LR"></a></span>
<span id="ordini"><a href="Ordini"> <input type="button" value="Ordini" class="LR"></a></span>
<span id="addGame"><a href="addGame.jsp"> <input type="button" value="addGame" class="LR"></a></span>
<%}} %>


<h2 id="error_warning"></h2>

<form  onsubmit="return validate()" action="UploadGame" method="post" enctype="multipart/form-data">
	<fieldset>
		<legend>Dati Gioco</legend>
			<input type="text" name="nomeGame" placeholder="nome" class="formInput" required autofocus > <br>
			<label for="date">data uscita gioco </label>
			<input type="date" name="years" class="formInput" required> <br>
			<label for="myfile">Select a foto for game</label>
			<input type="file" id="myfile" name="myfile" class="formInput" required accept="image/*"> <br>
			
			<input type="number" name="quantita" placeholder="quantita cifra intera senza virgola o punto" class="formInput" required> <br>
				<textarea id="desc" name="desc" rows="4" cols="50" class="formInput" required>Inserisci descrizione</textarea>
				<br>
				<label for="genere">Seleziona genere</label>
 				 <select id="genere" name="genere"  class="formInput" required>
    				<option value="rpg" checked>RPG</option>
    				<option value="simulator">simulator</option>
    				<option value="FPS">FPS</option>
    				<option value="other">Altro</option>
  				</select>
  				<br>
  				<input type="text" name="price" placeholder="prezzo 0.99 non usare virgola" class="formInput" required> <br>
				<input type="number" name="PEG" placeholder="PEG cifra intera senza virgola o punto" class="formInput" required> <br>
				<input type="number" name="iva" placeholder="iva % cifra intera senza virgola o punto" class="formInput" required> <br>
	</fieldset>
	
	<input type="submit" name="invio" value="Invia" class="button1" >
	<input type="reset" name="reset" value="Reset" class="button1" >
</form>
	<br>
<%@ include file="html/footer.html" %>		
	
</body>
</html>