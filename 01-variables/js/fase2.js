
/*
Creeu una constant amb el valor de l’any (1948).
*/
const TRASPAS = 1948;
/*
Creeu una variable que guardi cada quan hi ha un any de traspàs.
*/
let variable = es_bisiesto(TRASPAS);

// https://es.wikibooks.org/wiki/Algoritmo_bisiesto#M%C3%A9todo_programado_en_Javascript
// Función que determina si un año es bisiesto o no
// beta3designs 2009
function es_bisiesto(year) {
    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
}

/*
Calculeu quants anys de traspàs hi ha entre 1948 i el vostre any de naixement i emmagatzemeu el valor resultant en una variable.
*/

let anys = quantsAnysTraspas(1973);

function quantsAnysTraspas(year) {

    let counter = 0;
    let index = 0;

    for (let index = TRASPAS; index <= year; index++) {
        if (es_bisiesto(index)) {
            counter++;
        }
    }

    return counter;

    /*
    Mostreu per pantalla el resultat del càlcul
    */
    console.log("El resultat del càlcul és: " + anys);

}

