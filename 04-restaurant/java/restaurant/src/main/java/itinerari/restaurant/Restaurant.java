package itinerari.restaurant;

public class Restaurant {

    public static void main(String[] args) {

        Menu menu = demanarMenu();  // Fase 1 i Fase 2 (demanar fins que no hi hagi mes comensals)
        menu.calcularPreu();        // 
    }

    private static Menu demanarMenu() {
        return new Menu();
    }

    

}