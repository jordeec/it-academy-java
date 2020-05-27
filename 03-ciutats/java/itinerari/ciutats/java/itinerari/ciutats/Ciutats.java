package itinerari.ciutats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ciutats {

    // Crea sis variables tipu string buides.
    static List<String> arrayCiutats = new ArrayList<String>();

    public static void main(String[] args) {

        executaFase1();
        executaFase2();
        executaFase3();
        executaFase4();

    }

    private static void executaFase1() {
        // Demana per consola que s’introdueixin els noms.
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter the names of 6 cities currently in memory (" + arrayCiutats.size() + "/6): ");
            // Introdueix els següents noms de ciutats (Barcelona, Madrid, Valencia, Malaga,
            // Cadis, Santander) per teclat.
            arrayCiutats.add(sc.nextLine());
        } while (arrayCiutats.size() < 6);
        sc.close();

        // Mostra per consola el nom de les 6 ciutats
        showCities(arrayCiutats);
    }

    private static void executaFase2() {
        // Un cop tenim els noms de les ciutats guardats en variables haurem de pasar
        // l’informacio a un array (arrayCiutats)

        // Quan tinguem l’array ple, haurem de mostrar per consola el nom de les ciutats
        // ordenadas per ordre alfabetic.
        Collections.sort(arrayCiutats);
        showCities(arrayCiutats);
    }

    private static void showCities(List<String> arrayCiutats) {

        System.out.println("Showing the cities entered by user: ");
        System.out.println("************************************");
        for (String city : arrayCiutats) {
            System.out.println(city);
        }
        System.out.println("************************************");

    }

    private static void executaFase3() {
        List<String> arrayCiutatsModificades = new ArrayList<String>();
        for (String ciutat : arrayCiutats) {
            arrayCiutatsModificades.add(ciutat.replaceAll("a", "4"));
        }
        showCities(arrayCiutatsModificades);
    }

    private static void executaFase4() {

        // Creeu un nou array per cada una de les ciutats que tenim. La mida dels nous
        // arrays sera la llargada de cada string ( string nomCiutat.Length). (0,5 punts
        List<String> citiesReversed = new ArrayList<String>();
        for (String city : arrayCiutats) {
            char[] arrCityReverse = new char[city.length()];
            int cont = 0;
            // Ompliu els nous arrays lletra per lletra
            for (int i = city.length(); i > 0; i--) {
                arrCityReverse[cont] = city.charAt(i-1);
                cont++;
            }
            citiesReversed.add(new String(arrCityReverse));
        }

        // Mostreu per consola els nous arrays amb els noms invertits
        for (int i = 0; i < arrayCiutats.size(); i++) {
            System.out.println(arrayCiutats.get(i) + " - " + citiesReversed.get(i));
        }
    }

}