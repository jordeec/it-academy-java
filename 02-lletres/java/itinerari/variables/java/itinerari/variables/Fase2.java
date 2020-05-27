package itinerari.variables;

import java.util.ArrayList;
import java.util.List;

public class Fase2 {

    public static List<Character> executar(final char[] taula) {

        // Canvia la taula per una llista (List<Character>)
        final List<Character> llista = new ArrayList<Character>();
        for (final Character character : taula) {
          llista.add(character);
           // Al bucle, si la lletra és una vocal imprimeix a la consola: ‘VOCAL’. Sinó, imprimeix: ‘CONSONTANT’.
           switch(Character.toLowerCase(character)){
            case 'a': case 'e': case 'i': case 'o': case 'u':
                System.out.println("VOCAL");
                break;
            case 'b': case 'c': case 'd': case 'f': case 'g':
            case 'h': case 'j': case 'k': case 'l': case 'm': case 'n':
            case 'ñ': case 'p': case 'q': case 'r': case 's': case 't': 
            case 'v': case 'w': case 'x': case 'y': case 'z': 
                System.out.println("CONSONANT");
                break;
            // Si trobes un numero, mostra per pantalla: ‘Els noms de persones no contenen números!’.
            case '0': case '1': case '2': case '3': case '4': 
            case '5': case '6': case '7': case '8': case '9':
                System.out.println("Els noms de persones no contenen números!");
                break;
            default:
                // No fem res si es tracta d'un espai en blanc o qualsevol altre símbol          
          }
        } 

        return llista;

    }
    
}