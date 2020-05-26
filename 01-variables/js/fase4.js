let nomComplet = "Jordi Calderón Santamaría";
let data = "05/07/1973";

let any = data.substr(6);

console.log("El meu nom és " + nomComplet);
console.log("Vaig nèixer el " + data);
console.log("El meu any de naixement " + (es_bisiesto(any) ? "" : "NO ") + "és de traspàs");



function es_bisiesto(year) {
    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
}