
    $(document).ready(function () {	
        var c=0,p=1;
        
        while($(".fattura"+c).html() != undefined){
            var price = $(".totale"+c).html();
            var quantita = $(".quantita"+c).html();
            var iva = $(".iva"+c).html();
            iva= iva.replace(/%/,"");
            var fattura = $(".fattura"+c).html();

            //calcolo prezzo con iva

            price =  price/100*iva*quantita + price*quantita;
              $(".result"+c).html(price);
            c++;
            p++;
        }
    for(j=0;j<c-1;j++){
        m=j+1;
            if(($(".fattura"+j).html()==$(".fattura"+m).html())){
                //faccio la somma se e` la stessa fattura
                
                    price =Number($(".result"+j).html()) + Number($(".result"+m).html());
                    $(".result"+j).html("");
                    $(".result"+m).html(price);
                   console.log(price);
            }
    }

       /*  $('#AccountOrdiniTable').each(function () {
            
            var Column_number_to_Merge = 4;
 
            // Previous_TD holds the first instance of same td. Initially first TD=null.
            var Previous_TD = null ;
            var i = 1;
            $("tbody",this).find('tr').each(function () {
                // find the correct td of the correct column
                // we are considering the table column 1, You can apply on any table column
                var Current_td = $(this).find('td:nth-child(' + Column_number_to_Merge + ')');
                 
                if (Previous_TD == null) {
                    // for first row
                    Previous_TD = Current_td;
                    i = 1;
                } 
                else if (Current_td.text() == Previous_TD.text()) {
                    // the current td is identical to the previous row td
                    // remove the current td
                    Current_td.remove();
                    // increment the rowspan attribute of the first row td instance
                    Previous_TD.attr('rowspan', i + 1);
                    i = i + 1;
                } 
                else {
                    // means new value found in current td. So initialize counter variable i
                    Previous_TD = Current_td;
                    i = 1;
                }
            });
           
        });	 */	
    });