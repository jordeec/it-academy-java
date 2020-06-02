/** Some enumerations just for fun */
const COLORS = {
    PURPLE= 'purple',
    YELLOW= 'yellow',
    GREEN = 'green',
    BROWN = 'brown',
    NAVY  = 'navy',
    CYAN = 'cyan',
    LIGHT_BROWN = 'light-brown'

}

const DIVISES = {
    EUR='EUR',
    USD='USD',
    JPY='JPY',
    BTC='BTC',
    CHF='CHF'
}

/** Main class definition for Bill  */
var Bitllet = {
    color = COLORS,
    divisa = DIVISES,
    valor: 0
};

/** Empty constructor that should never be called */
class Bitllet {
    constructor() {
        this.valor = 0;
    }
}

/** Several types of bill our application is dealing with
 * The value of each bill is different
 */
class Bitllet5 {
    constructor() {
        this.color = COLORS.CYAN;
        this.divisa = COLORS.EUR;
        this.valor = 5;
    }
}

class Bitllet10 {
    constructor() {
        this.color = COLORS.BROWN;
        this.divisa = COLORS.EUR;
        this.valor = 10;
    }
}


class Bitllet20 {
    constructor() {
        this.color = COLORS.NAVY;
        this.divisa = COLORS.EUR;
        this.valor = 20;
    }
}

class Bitllet50 {
    constructor() {
        this.color = COLORS.CYAN;
        this.divisa = COLORS.EUR;
        this.valor = 50;
    }
}

class Bitllet100 {
    constructor() {
        this.color = COLORS.GREEN;
        this.divisa = COLORS.EUR;
        this.valor = 100;
    }
}

class Bitllet200 {
    constructor() {
        this.color = COLORS.YELLOW;
        this.divisa = COLORS.EUR;
        this.valor = 200;
    }
}

class Bitllet500 {
    constructor() {
        this.color = COLORS.PURPLE;
        this.divisa = COLORS.EUR;
        this.valor = 500;
    }
}
