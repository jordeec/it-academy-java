package itinerari.variables;

import java.util.List;
import java.util.Map;


/**
 * Variables
 */
public class Lletres {

    public static void main(final String[] args) {
        final char[] taula = Fase1.executar();
        final List<Character> llista = Fase2.executar(taula);
        final Map<Character, Integer> mapa = Fase3.executar(llista);
        System.out.println(mapa);
        List<Character> novaLlista = Fase4.executar(llista);
        System.out.println(novaLlista);
    }

    
}