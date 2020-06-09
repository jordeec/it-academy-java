package java.itinerari.variables;

public class Fase2 {

    // Creeu una constant amb el valor de l’any (1948).
    final static int TRASPAS = 1948;

    public static void main(final String[] args) {

        // Creeu una variable que guardi cada quan hi ha un any de traspàs.
        final boolean esTraspas = isLeap(TRASPAS);
        System.out.println("Valor de la variable esTraspas: " + esTraspas);

        // Calculeu quants anys de traspàs hi ha entre 1948 i el vostre any de naixement
        // i emmagatzemeu el valor
        // resultant en una variable.
        int anysTraspas = calcularAnysTraspas(1973);

        // Mostreu per pantalla el resultat del càlcul.
        System.out.println("Hi ha " + anysTraspas + " anys de diferència entre 1973 i " + TRASPAS );

    }
    /**
     * Calcula quants anys de traspas hi ha entre 1948 i l'any del paràmetre
     * 
     * @param any
     * @return
     */
    public static int calcularAnysTraspas(final int any) {

        int contador = 0;

        for (int i = any; i > TRASPAS; i--) {
            if (isLeap(i)) {
                contador++;
            }
        }

        return contador;
    }

    /**
     * Calcular si un any és de traspàs a través d'una funció. He tret l'algoritme
     * de:
     * 
     * https://es.wikibooks.org/wiki/Algoritmo_bisiesto#M%C3%A9todo_programado_en_Java
     * 
     * @param year
     * @return
     */
    public static boolean isLeap(final int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}