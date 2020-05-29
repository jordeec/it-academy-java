package itinerari.vaadim.java.backend.bitllets;

enum Colors {
    PURPLE,
    YELLOW,
    GREEN,
    BROWN,
    NAVY,
    CYAN,
    LIGHT_BROWN
  }

 enum Divises {
      EUR,
      USD,
      JPY,
      BTC,
      CHF
  }
public class Bitllet {
    public Colors color;
    public Divises divisa;
    public float valor;
}
