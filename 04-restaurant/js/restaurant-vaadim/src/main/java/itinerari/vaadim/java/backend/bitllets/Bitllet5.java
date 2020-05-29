package itinerari.vaadim.java.backend.bitllets;

public class Bitllet5 extends Bitllet {

    public Bitllet5() {
        super.color = Colors.CYAN;
        super.divisa = Divises.EUR;
        super.valor = 5;
    }

    public float getValor(){
        return super.valor;
    }

}
