// Canvia la taula per una llista (List<Character>)
// JCS: En Javascript crec que no existeix el concepte de "llista" (Jose)
let nom = ['J', 'o', 'r', 'd', 'i'];

// Al bucle, si la lletra és una vocal imprimeix a la consola: ‘VOCAL’. Sinó, imprimeix: ‘CONSONTANT’.
nom.forEach(element => {
    switch (element.toLowerCase()) {
        case 'a': case 'e': case 'i': case 'o': case 'u':
            console.log('VOCAL');
            break;
        case 'b': case 'c': case 'd': case 'f': case 'g':
        case 'h': case 'j': case 'k': case 'l': case 'm': case 'n':
        case 'ñ': case 'p': case 'q': case 'r': case 's': case 't':
        case 'v': case 'w': case 'x': case 'y': case 'z':
            console.log('CONSONANT');
            break;
        // Si trobes un numero, mostra per pantalla: ‘Els noms de persones no contenen números!’.
        case '0': case '1': case '2': case '3': case '4':
        case '5': case '6': case '7': case '8': case '9':
            console.log('‘Els noms de persones no contenen números');
            break;            
        default:
            console.log('Trobat un caràcter especial o accentuat');
            break;
    }
});