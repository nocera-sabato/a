/**
 * 
 */

 function logged(balance){

    //cambio tasto login
    document.getElementsByClassName("LR")[1].value="saldo " + balance;
    document.getElementsByTagName("a")[1].href="Account.jsp";

    //cambio tasto registrazione
    document.getElementsByClassName("LR")[2].value="Logout";
    document.getElementsByTagName("a")[2].href="Logout";
 }

function createXMLHttpRequest() {
	var request;
	try {
		// Firefox 1+, Chrome 1+, Opera 8+, Safari 1.2+, Edge 12+, Internet Explorer 7+
		request = new XMLHttpRequest();
	} catch (e) {
		// past versions of Internet Explorer
		try {
			request = new ActiveXObject("Msxml2.XMLHTTP");  
		} catch (e) {
			try {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("Il browser non supporta AJAX");
				return null;
			}
		}
	}
	return request;
}


function loadCart(nameGame){
	$.ajaxSetup({timeout : 3000});
		var jqxhr = $.post("CreateCart", { "nome": nameGame}, function(data){
			
			if(data.quantity==1){
				var table = document.getElementById("ContenutoCartTable");
				var row = table.insertRow(0);
				  var cell1 = row.insertCell(0);
				  cell1.innerHTML = data.result;
			}
			
		});
			
		jqxhr.fail(function(_jqXHR, textStatus, errorThrown){
			if(textStatus == "timeout"){
				alert( "Problemi nell'esecuzione della richiesta: nessuna risposta ricevuta nel tempo limite");
        	} else {
	        	alert("Problemi nell'esecuzione della richiesta:" + errorThrown);
			}
  		});
	}

function Sorting(){
	let value = document.querySelectorAll('input:checked');  //prendo tutti input marcati
	let SizeValue = value.length;    // vedo quanti sono
	var jqxhr,a,c=null;
	var b= document.querySelector('#genereSelected option:checked').value; // prendo il valore di option genere altrimenti  è null
	console.log(value[0]);
	$.ajaxSetup({timeout : 3000});
		if((SizeValue>1)||(b!="None")){  //in questo caso utente ha scelto piu di un input e ha marcato anche Genere
			 a=value[0].value;
			if(SizeValue==2) c=value[1].value;
			if(SizeValue==3) c=value[1].value+" or "+value[2].value;
				
			if((b!="None")&&c!=null) jqxhr = $.post("gameList", { "sort": `where genere='${b}' and ${c} order by ${a}`}, function(){
				//document.location.reload(true);
				window.location.replace("http://localhost:8080/GAMEMARKET/home.jsp");
			 });
			else if(c!=null) jqxhr = $.post("gameList", { "sort": `where ${c} order by ${a}`}, function(){
				//document.location.reload(true);
				window.location.replace("http://localhost:8080/GAMEMARKET/home.jsp");
			 });
			 else jqxhr = $.post("gameList", { "sort": `where genere='${b}' order by ${a}`}, function(){
				//document.location.reload(true);
				window.location.replace("http://localhost:8080/GAMEMARKET/home.jsp");
			 });
		}
		else  jqxhr = $.post("gameList", { "sort": `order by `+value[0].value}, function(){
			//document.location.reload(true);
			window.location.replace("http://localhost:8080/GAMEMARKET/home.jsp");
		 });
		jqxhr.fail(function(_jqXHR, textStatus, errorThrown){
			if(textStatus == "timeout"){
				alert( "Problemi nell'esecuzione della richiesta: nessuna risposta ricevuta nel tempo limite");
        	} else {
	        	alert("Problemi nell'esecuzione della richiesta:" + errorThrown);
			}
  		});
	}

function CartQuant(nome,max,quantita){
	let num =quantita.value.replace(/\D/,'');
	if(num=="") num=0;
	if(Number(num)>Number(max)) num=max;
	$.ajaxSetup({timeout : 3000});
	$.post("MyCart.jsp", { "newCart": nome, "newValue": num}, function(){
		document.location.reload(true);
	 });
	
}





function setData(xhttp){
	var response = xhttp.responseXML.documentElement;
	
	var result = response.getElementsByTagName("result")[0].firstChild.nodeValue;
	alert("Risposta: \n" + result);
	//console.log(response);
	$(".ContenutoCart").append="ok";
	
	
}

function chekingName(nome){
				nome.replace(/'/,"&apos;")
				return nome;
	
}