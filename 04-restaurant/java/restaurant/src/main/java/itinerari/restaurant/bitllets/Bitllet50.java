package itinerari.restaurant.bitllets;

public class Bitllet50 extends Bitllet {

    private int valor;

    public Bitllet50() {
        this.color = Colors.BROWN;
        this.divisa = Divises.EUR;
        this.valor = 500;
    }

    public int getValor(){
        return this.valor;
    }

}
