package itinerari.restaurant.bitllets;

enum Colors {
    PURPLE,
    YELLOW,
    GREEN,
    BROWN,
    NAVY,
    CYAN
  }

 enum Divises {
      EUR,
      USD,
      JPY,
      BTC,
      CHF
  }

public abstract class Bitllet {
    public Colors color;
    public Divises divisa;
}
