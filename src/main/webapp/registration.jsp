<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="css/styleR.css">
<script type="text/javascript" src="js/checkInput.js"></script>
<title>Reg Page</title>
</head>
<body>
<%-- <jsp:include page="header.jsp" /> --%>
<%@ include file="header.jsp" %>
<h1 id="error_warning">  </h1>
<form  onchange="validate()" action="Registrazione" method="post">
	<fieldset>
		<legend>Dati personali</legend>
			<input type="text" name="nome" placeholder="nome" class="formInput" required autofocus>
			<input type="text" name="cognome" placeholder="cognome" class="formInput" required>
			<input type="text" name="data" placeholder="data di nascita 01/01/2000" class="formInput" required>
			<!-- <input type="text" name="indirizzo" placeholder="indirizzo(via palombo 19)" class="formInput" required>
			<input type="text" name="citta" placeholder="citta" class="formInput" required>
			<input type="text" name="zip" placeholder="zip" class="formInput" required>
			<input type="text" name="telefono" placeholder="cellulare" class="formInput" required> -->
	</fieldset>
	<fieldset>
	<legend>Dati di login</legend>
	<input type="text" name="email" placeholder="email" class="formInput" required>
	<input type="password" name="pass" placeholder="password" class="formInput" required>
	<input type="password" name="repass" placeholder="reinserisci password" class="formInput" required>
	</fieldset>
	
	<input type="submit" name="invio" value="Invia" class="button1" >
	<input type="reset" name="reset" value="Reset" class="button1" >
</form>

</body>
</html>