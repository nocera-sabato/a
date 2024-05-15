const LettersNum = /^[A-Za-z0-9]+$/;
const GameNames = /^[a-zA-Z0-9\.\,\' ]+$/;
const Letters = /^[A-Za-z]+$/;
const cittaRegex = /^[A-Za-z]{4,}$/;
const OnlyNums = /^[0-9]+$/;
const FloatNums = /^[0-9]+\.[0-9]+$/m;
const NumZip = /^[0-9]{5}$/;
const NumCel = /^[0-9]{10}$/;
const emailcheck = /^\w+(\.-]?\w+)*@\w+(\.-]?\w+)*(\.\w{2,3})+$/;
const adress = /^via [A-Za-z ]+[0-9]{1,3}\/?[0-9A-Za-z]$/;
var valid = true;

function validate(){
    
    var nome = document.getElementsByName("nomeGame")[0];
    var quantita = document.getElementsByName("quantita")[0];
    var peg = document.getElementsByName("PEG")[0];
    var iva = document.getElementsByName("iva")[0];
    var price = document.getElementsByName("price")[0];
checkNome(nome);
checkNum(quantita);
checkNum(peg);
checkNum(iva);
checkPice(price);
if(!valid) {
	document.getElementById("error_warning").innerHTML= "Controlla i campi segnati in rosso";
	return false;
}
else return true;
/*
//checkIndirizzo(indirizzo);
//checkCitta(citta);
//checkZip(zip);
//checkCel(tel);
*/


}



function checkNome(Inputtext){
    if(Inputtext.value.match(GameNames)) Inputtext.style.backgroundColor = "#A9F6B1";
    else {
        Inputtext.style.backgroundColor = "#F6A9AE";
        valid = false;
    }
}
function checkNum(Inputtext){
	
    if(Inputtext.value.match(OnlyNums)) Inputtext.style.backgroundColor = "#A9F6B1";
    else {
        Inputtext.style.backgroundColor = "#F6A9AE";
        valid = false;
    }
}
function checkPice(Inputtext){
    if(Inputtext.value.match(FloatNums)) Inputtext.style.backgroundColor = "#A9F6B1";
    else {
        Inputtext.style.backgroundColor = "#F6A9AE";
        valid = false;
    }
} 


