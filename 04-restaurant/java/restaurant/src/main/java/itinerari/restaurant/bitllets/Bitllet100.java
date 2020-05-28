package itinerari.restaurant.bitllets;

public class Bitllet100 extends Bitllet {

    private int valor;

    public Bitllet100() {
        this.color = Colors.GREEN;
        this.divisa = Divises.EUR;
        this.valor = 100;
    }

    public int getValor(){
        return this.valor;
    }

}
