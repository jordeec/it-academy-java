

let inici = 1948;
let final = 1973;

let isLeap = false;

/*
Partint de l’any 1948 heu de fer un bucle for i mostrar els anys de traspàs fins arriba al vostre any de naixement.
*/

for (let index = inici; index <= final; index++) {
    // Creeu una variable bool que sera certa si l’any de naixement és de traspàs o falsa si no ho és.
    isLeap = es_bisiesto(index);

    // En cas de que la variable bool sigui certa, heu de mostrar per consola una frase on ho digui, en cas de ser 
    // falsa mostrareu la frase pertinent. Creeu dues variables string per guardar les frases.

    let positiu = "L'any " + index + " és de traspàs";
    let negatiu = "L'any " + index + " NO és de traspàs"; 
    
    console.log( isLeap ? positiu : negatiu);   
}

function es_bisiesto(year) {
    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
}