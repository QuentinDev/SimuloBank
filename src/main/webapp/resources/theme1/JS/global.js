/**
 * Created by maxco on 22/03/2017.
 */
$(document).ready(function(){
   $('div.compte').click(function(e){
       $('#account_'+this.id).slideToggle("fast");
       //e.stopPropagation();
   });
   $('div.acomte input').click(function(e){e.stopPropagation();});
   $('input.date').datepicker({
       dayNamesMin: ["D", "L", "M", "M", "J", "V", "S"],
       monthNames: [ "Janvier", "Février", "Mars", "Avril", "Mais", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Decembre" ],
       dateFormat: "mm/dd/yy"

   });
});