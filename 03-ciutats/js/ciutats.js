
var CIUTATS_MIN = 6;

// 1 Omplir ciutats a la pàgina html 
function addCity() {
    let txtCity = document.getElementById("txtCity").value;

    if (!txtCity) {
        return false;
    }

    /* Afegim un nou element a la llista de ciutats  */
    let ulCities = document.getElementById("cities");
    var li = document.createElement("li");
    li.className = "list-group-item";
    li.appendChild(document.createTextNode(txtCity));
    ulCities.appendChild(li);

    /* Actualitzem el status */
    CIUTATS_MIN = CIUTATS_MIN - 1;

    /* Netejem el input d'entrada */
    document.getElementById("txtCity").textContent = '';
    document.getElementById("txtCity").focus();

    /* Habilitem botó de càlcul */
    if (CIUTATS_MIN <= 0) {
        let btnCalcular = document.getElementById('btnCalcular');
        btnCalcular.disabled = false;
        document.getElementById("statusCities").textContent = 'Fes click a Calcular per executar les 4 fases';
    } else {
        document.getElementById("statusCities").textContent = 'Entra el nom de la ciutat (falten ' + CIUTATS_MIN + ')';
    }

}

//TODO: Afegir llista com a elements  <li class="list-group-item">element</li> passant-li el id de la <ul>
function fillListWithItems(list) {

}

function resetFields() {
    console.log("Al reset");
    location.reload();
}

function fillPhases() {
    console.log("Al fill Phases");

    var ul = document.getElementById("cities");
    var items = ul.getElementsByTagName("li");
    for (var i = 0; i < items.length; ++i) {
        // do something with items[i], which is a <li> element
        console.log(items[i]);
        
    }
}
