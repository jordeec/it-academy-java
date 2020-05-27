package itinerari.variables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fase3 {

    // Emmagatzemar en un Map tant les lletres de la llista com el nombre de vegades
    // que apareixen
    public static Map<Character, Integer> executar(List<Character> llista) {

        Map<Character, Integer> mapa = new HashMap<Character, Integer>();

        for (Character character : llista) {
            if (!mapa.containsKey(Character.toLowerCase(character))) {
                mapa.put(character, 1);
            } else {
                mapa.put(character, mapa.get(character) + 1);
            }
        }

        return mapa;
    }

}