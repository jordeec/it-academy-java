package itinerari.restaurant.bitllets;

public class Bitllet10 extends Bitllet {

    public Bitllet10() {
        super.color = Colors.LIGHT_BROWN;
        super.divisa = Divises.EUR;
        super.valor = 10;
    }

    public float getValor(){
        return super.valor;
    }

}
