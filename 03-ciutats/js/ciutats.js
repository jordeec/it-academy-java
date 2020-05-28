var CIUTATS_MIN = 6;

// Afegir event listener per a botó d'introduïr ciutat quan es presiona enter
// Font: https://www.w3schools.com/howto/howto_js_trigger_button_enter.asp

// Get the input field
var input = document.getElementById("txtCity");

// Execute a function when the user releases a key on the keyboard
input.addEventListener("keyup", function(event) {
  // Number 13 is the "Enter" key on the keyboard
  if (event.keyCode === 13) {
    // Cancel the default action, if needed
    event.preventDefault();
    // Trigger the button element with a click
    document.getElementById("btnAddCity").click();
  }
});

input.focus();

/**
 * Implementació del botó d'afegir ciutats
 * 
 */
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
    document.getElementById("txtCity").value = '';
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

/**
 * Implementació del botó de netejar camps
 * 
 */

function resetFields() {
    console.log("Al reset");
    location.reload();
}

/**
 * Implementació del botó calcular (fases.js)
 */
function calcular() {
    console.log("Calculant ... ");
    fillPhases(document.getElementById("cities"));
    console.log("Final de calcular ... ");

}

