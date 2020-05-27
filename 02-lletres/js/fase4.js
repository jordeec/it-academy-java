let nom = ['J', 'o', 'r', 'd', 'i'];

// Crea una altra llista amb el teu cognom on cada posició correspongui a una lletra.
let cognom = 'Calderón';

// Fusiona les dues llistes en una sola. A més, afegeix una posició amb un espai buit entre 
// la primera i la segona. És a dir, partim de la llista name i surname i al acabar l’execució 
// només tindrem una que es dirà fullName.
let fullName = [];
fullName = nom;
fullName.push(' ');
for (let index = 0;index < cognom.length; index++) {
    fullName.push(cognom[index]);
}

console.log(fullName);