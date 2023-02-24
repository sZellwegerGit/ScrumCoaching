<!--prüft, ob $_Get{'email'} bereits im System vorhanden ist,
    rückgabe "false" wenn vorhanden
    rüclgabe "true" wenn nicht vorhanden
    1.Schrit synchron serverseitig 
-->

<?php
 $vorhanden = array('me@me.com','biena_maja@wiss.com');

 if (isset($_GET['email'])){
    // sleep(10);//synroch aufruf ausbremsen
    if (in_array($_GET['email'], $vorhanden) == 1){
        echo"false";
     } else {
        echo "true";
    }
}
else{
    echo "innvalid usage";
}
?>