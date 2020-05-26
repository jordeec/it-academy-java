package itinerari.variables;

public class Fase4 {
    public static void main(String[] args) {
        
        String nomComplet = "Jordi Calderón Santamaría";
        String data = "05/07/1973";

        int any = Integer.valueOf(data.substring(6));
        boolean esTraspas = Fase2.isLeap(any);

        System.out.println("El meu nom és " + nomComplet);
        System.out.println("Vaig nèixer el " + data);
        System.out.println("El meu any de naixement" + (!esTraspas ? " no " : "") + "és de traspàs." );

    }
}