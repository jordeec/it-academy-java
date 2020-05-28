package itinerari.restaurant;

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
        System.out.println("Hello World!");

        Menu menu = demanarMenu(); // Fase 1 i Fase 2 (demanar fins que no hi hagi mes comensals)
        menu.calcularPreu(); //
    }

    private static Menu demanarMenu() {
        return new Menu();
    }

}
