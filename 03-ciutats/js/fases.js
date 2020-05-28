console.log("Al fases.js");

/**
 * 
 * Executa les 4 fases de l'exercici
 * 
 * @param {Element} citiesList DOM Element de tipus ul on hi ha les dades amb les que treballarem
 */

function fillPhases(citiesList) {

    let arrCities = new Array();

    var lis = citiesList.getElementsByTagName("li");

    for (let index = 0; index < lis.length; index++) {
        const elem = lis[index];
        arrCities.push(elem.textContent);
    }

    // Phase 1:
    runPhase1(arrCities);
    runPhase2(arrCities);
    runPhase3(arrCities);
    runPhase4(arrCities);

}


/**
 * Funció auxiliar per omplir una llista de resultats amb el contingut de l'array
 * 
 * @param {Array} arr de cadenes amb el contingut a llistar
 * @param {String} UlContainer nom del contenidor de tipus ul que caldrà omplir
 */
function fillListWithItems(arr, UlContainer) {

    container = document.getElementById(UlContainer);
    var lis = container.getElementsByTagName("li");

    while (container.firstChild) {
        container.removeChild(container.firstChild);
    }

    var iterator = arr.values();
    for (let element of iterator) {
        console.log(element);
        var li = document.createElement("li");
        li.className = "list-group-item list-group-item-action";
        li.appendChild(document.createTextNode(element));
        container.appendChild(li);
    }    
}


function runPhase1(arrCities){
    // Mostra per consola el nom de les 6 ciutats.
    fillListWithItems(arrCities, "phase1-results");
}

function runPhase2(arrCities){
    // Quan tinguem l’array ple, haurem de mostrar per consola el nom de les ciutats ordenadas per ordre alfabetic
    fillListWithItems(arrCities.sort(), "phase2-results");
}

function runPhase3(arrCities){
    // Cambieu les vocals “a” dels noms de les ciutats per el numero 4 i guardeu els noms modificats en un nou array(ArrayCiutatsModificades)
    let arrayModifiedCities = new Array();

    arrCities.forEach(element => {
        // source: https://www.w3schools.com/jsref/jsref_replace.asp
        let newCity = element.replace(/a/gi, '4');
        arrayModifiedCities.push(newCity);
    });

    fillListWithItems(arrayModifiedCities, "phase3-results");
}

function runPhase4(arrCities){

    let arrayInvertedCities = new Array();

    arrCities.forEach(element => {
        console.log(element[0]);
        let arraySingleCity = new Array(element);
        // Creeu un nou array per cada una de les ciutats que tenim. La mida dels nous arrays sera la llargada de cada string
        let invertedCity = new String();
            
        for (let index = element.length; index > 0 ; index--) {
            // Ompliu els nous arrays lletra per lletra.
            invertedCity += element[index-1];
        }
        arrayInvertedCities.push(invertedCity);        
    });

    fillListWithItems(arrayInvertedCities, "phase4-results");
}
