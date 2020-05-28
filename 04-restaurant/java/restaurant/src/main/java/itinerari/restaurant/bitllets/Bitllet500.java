package itinerari.restaurant.bitllets;

public class Bitllet500 extends Bitllet {

    private int valor;

    public Bitllet500(){
        this.color = Colors.PURPLE;
        this.divisa = Divises.EUR;
        this.valor = 500;
    }

    public int getValor(){
        return this.valor;
    }
}
