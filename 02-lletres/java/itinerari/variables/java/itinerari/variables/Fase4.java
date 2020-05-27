package itinerari.variables;

import java.util.ArrayList;
import java.util.List;

public class Fase4 {

    public static List<Character> executar(List<Character> llista) {

        // Crea una altra llista amb el teu cognom on cada posició correspongui a una lletra
        String COGNOM = "Calderón";
        List<Character> surname = new ArrayList<Character>();
        for (Character character : COGNOM.toCharArray()) {
            surname.add(character);
        }
        
        // Fusiona les dues llistes en una sola. A més, afegeix una posició amb un espai buit entre 
        // la primera i la segona. És a dir, partim de la llista name i surname i al acabar l’execució 
        // només tindrem una que es dirà fullName.
        List<Character> fullName = new ArrayList<Character>();
        fullName.addAll(llista);
        fullName.add(' ');
        fullName.addAll(surname);

        return fullName;




        
    }

}