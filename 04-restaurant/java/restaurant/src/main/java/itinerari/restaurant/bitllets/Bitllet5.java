package itinerari.restaurant.bitllets;

public class Bitllet5 extends Bitllet {

    private int valor;

    public Bitllet5() {
        this.color = Colors.CYAN;
        this.divisa = Divises.EUR;
        this.valor = 5;
    }

    public int getValor(){
        return this.valor;
    }

}
