package itinerari.variables;

/**
 * Variables
 */
public class Fase1 {

    public static void main(String[] args) {
        String nom = "Jordi";
        String cognom1 = "Calderón";
        String cognom2 = "Santamaría";

        int dia, mes, any;

        final String SEP_ESPAI = " ";
        final String SEP_COMA = ",";
        final String SEP_BARRA = "/";

        System.out.println(cognom1 + SEP_ESPAI + cognom2 + SEP_COMA + SEP_ESPAI +  nom);

        /**
         * Fem servir tipus bàsics, però es podria resoldre també amb
         * Integer any = new Integer(1973);
         */

        any = 1973;
        mes = 7;
        dia = 5;

        System.out.println(dia + SEP_BARRA + mes + SEP_BARRA + any);
    }
    
}