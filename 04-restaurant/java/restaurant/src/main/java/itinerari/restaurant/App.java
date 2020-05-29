package itinerari.restaurant;

import itinerari.restaurant.controller.MenuConsoleController;
import itinerari.restaurant.controller.MenuController;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        MenuController controller = new MenuConsoleController();
        controller.askForMenu();        // Fase 1 i Fase 2 (demanar fins que no hi hagi mes comensals)
                                        // Fase 3. Calcular preu i nombre de bitllets

    }

}
