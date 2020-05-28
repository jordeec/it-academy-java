package itinerari.restaurant.bitllets;

public class Bitllet200 extends Bitllet {

    private int valor;

    public Bitllet200() {
        this.color = Colors.YELLOW;
        this.divisa = Divises.EUR;
        this.valor = 200;
    }

    public int getValor(){
        return this.valor;
    }
}
