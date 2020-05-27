package itinerari.variables;

public class Fase1 {

    public static char[] executar() {
        /*
         * Crea una taula (char[]) amb el teu nom on cada posició correspongui a una
         * lletra.
         */
        final String nomComplet = "Jordi";
        final char[] taula = nomComplet.toCharArray();

        // Fes un bucle que recorri aquesta taula i mostri per consola cadascuna de les
        // lletres.
        for (final char c : taula) {
            System.out.println(c);
        }

        return taula;
    }
    
}