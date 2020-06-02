//TODO: Discuss with Jose (mentoring)
// Em vaig liar moltíssim en fer la part de javascript i vaig muntar un arc d'esglèsia amb una estructura maven, un framework per
// dibuixar html des de Java (vaadin) i al final ho vaig deixar estar, aquest exercici en js conte lo mínim i imprescindible

// Creeu una variable int per cada un dels bitllets que existeixen des de 5€ a 500€, haureu de crear un altre variable per guardar el preu total del menjar
// Els bitllets estan en objectes a bitllets.js
let total = 0;

// Creeu dos arrays, un on guardarem el menú (5 plats) i un altre on guardarem el preu de cada plat.
let menuNoms = new Array();
let menuPreus = new Array();

 // Array per saber qué volem per menjar
 let ordreNoms = new Array();
 let ordrePreus = new Array();


function addDish(value) {
    let nom = document.getElementById('availableDishes').getElementsByTagName('tr')[value].getElementsByTagName('td')[0].innerText;
    let preu = document.getElementById('availableDishes').getElementsByTagName('tr')[value].getElementsByTagName('td')[1].innerText;

    menuNoms.push(nom);
    menuPreus.push(preu);

    // Amb un bucle for haurem d’omplir els dos arrays anteriorment creats. Afegirem el nom del plat i després el preu
    // En comptes de fer-ho amb un for ho fem llegint el que hi ha a l'HTML
    // Add selected dish to lower table
    tbl = document.getElementById('selectedDishes')
    row = tbl.insertRow();

    cell = row.insertCell(0);
    cell.appendChild(document.createTextNode(nom));

    cell = row.insertCell(1);
    cell.appendChild(document.createTextNode(preu));

}

function getNewMenu() {
    // TODO: Discuss with mentor. I want to load local resource and can't due to security reasons
    // https://stackoverflow.com/questions/14052473/go-to-local-url-with-javascript
    console.log('New menu start');
    location.reload();
}

function fase2() {
    // Un cop plens els dos arrays haurem de mostrar-los i preguntar que es vol per menjar, guardarem la informació en 
    // una List fent servir un bucle while.

    let counter = 0;
    if (menuNoms.length > 0 ) {

        let nom = menuNoms[counter];
        let preu = menuPreus[counter];

        while (nom != undefined) {
            ordreNoms.push(menuNoms[counter])
            ordrePreus.push(menuPreus[counter]);
            counter = counter + 1;
            nom = menuNoms[counter];
            preu = menuPreus[counter];
        }
    }
}

function fase3(){

    // Cridem a la fase2 per omplir els arrays
    fase2();
    // Sumar preu de la ordre
    let total = 0;

    ordrePreus.forEach(element => {
        total += Number(element);
    });

    document.getElementById('totalOrder').innerText = total + " €";

}

