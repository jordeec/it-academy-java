// Emmagatzemar en un Map tant les lletres de la llista com el nombre de vegades que apareixen
let nom = ['J', 'o', 'r', 'd', 'i'];

let mapa = new Map();

for (let index = 0; index < nom.length; index++) {
    const element = nom[index];

    if(mapa.has(element)){
        mapa.set(element, mapa.get(element) + 1);
    }else {
        mapa.set(element, 1);
    }
    
}

console.log(mapa);