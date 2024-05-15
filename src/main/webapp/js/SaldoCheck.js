$( window ).on( "load", function() { 
    let but = $('#LoginButton').html();
    let d =but.replace(/\D+/,"");
    if(d!=''){
        d=d.replace(/" \w+.+>/,"");
        //d.substring(0,4);
        let totale = $('.totale').html();
        if(totale!=undefined){
        totale=totale.replace(/\w+ /,"");
        totale=totale.replace(/\$/,"");
        //if(totale<1) 
           // $('#buttonPay').html(`'<a href="javascript:void(0)"><input type="button" value="" class="LR" style="width: fit-content;color:red"></a>'`);
        if(parseFloat(d)<parseFloat(totale)){
            $('#buttonPay').html(`'<a href="javascript:void(0)"><input type="button" value="saldo insufficiente" class="LR" style="
            width: fit-content;color:red"></a>'`);
    
        }
        }

    }
     
    
});
