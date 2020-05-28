package itinerari.restaurant.controller;

import java.util.List;
import java.util.Scanner;

import itinerari.restaurant.Menu;
import itinerari.restaurant.MenuDish;

public class MenuConsoleController implements MenuController {

    public Menu menu = new Menu();
    // Demana per consola que s’introdueixin els noms.
    Scanner sc = new Scanner(System.in);

    @Override
    /**
     * Show a menu in console and reacts consequently
     *
     */
    public synchronized Menu askForMenu() {

        do {
            System.out.println("************************************************************");
            System.out.println("*** WELCOME TO IT-ACADEMY's RESTAURANT *********************");
            System.out.println("***                                                      ***");
            System.out.println(
                    "*** You can currently choose amongst " + menu.getDishesInMenuChart() + " delicious dishes!");
            System.out.println();
            System.out.println("*** 1) Search for a plate. (currently ordered " + menu.getNumberOfDishes() + ")");
            System.out.println("*** 2) Enter number of customers (currently " + menu.getEaters() + ")");
            System.out.println("*** 3) Show order so far");
            System.out.println("*** 4) Calculate price and bills");
            System.out.println();
            System.out.println("*** 99) Leave application. Ready to order!");
            System.out.println("************************************************************");
            final String userSelection = sc.nextLine();
            evaluateUserSelection(userSelection);
        } while (!menu.isReadyToOrder());

        sc.close();

        return new Menu();
    }

    private void evaluateUserSelection(final String userSelection) {
        switch (userSelection) {
            case "99":
                menu.setReadyToOrder(true);
                break;
            case "2":
                addCustomer();
                break;
            case "1":
                searchForAPlate();
                break;
            case "3":
                showOrderList();;
                break;
            default:
                break;
        }
    }

    @Override
    /**
     * Calculates price of order and show how many bills are needed to pay for the
     * meal
     */
    public synchronized void checkOutPrice() {
    }

    @Override
    public void addCustomer() {
        System.out.println(">>> Enter desired number of eaters (must be between 1 and 20)");
        try {
            String input = sc.nextLine();

            int value = Integer.parseInt(input);
            /**
             * TODO: BAD PRACTICE. This bussiness rule should be somewhere else!
             */
            if (value >= 1 && value <= 20) {
                menu.setEaters(value);
            }

        } catch (final Exception e) {
            /**
             * TODO: Silent exception to capture parse error, will return to the menu
             * without any changes. BAD PRACTICE!!
             */
        }
    }

    @Override
    /**
     * Lets the user search a plate from Restaurant menu or choose from suggestions
     */
    public MenuDish searchForAPlate() {
        final MenuDish suggestion = getRandomSuggestion();
        List<MenuDish> dishes;

        System.out.println(">>> Type what you'd like to eat (in Spanish). Random suggestion: " + suggestion);
        String inputText = sc.nextLine();
        dishes = searchPlates(inputText);
        dishes.add(suggestion);

        System.out.println("*** These are some dishes you could like. Choose with number: ");
        MenuDish selected = null;
        do {
            int i = 0;
            for (MenuDish menuDish : dishes) {
                System.out.println("*** " + i + ": " + menuDish);
                i++;
            }
            try {
                String inputNumber = sc.nextLine();
                selected = dishes.get(Integer.parseInt(inputNumber));
                menu.addDishToMenu(selected);
            } catch (Exception e) {
                // TODO: BAD PRACTICE. Forces user to select among suggested dishes
            }
        } while (selected == null);

        return selected;

    }

    @Override
    public MenuDish getRandomSuggestion() {
        return menu.getRandomSuggestion();
    }

    @Override
    public List<MenuDish> searchPlates(String input) {
        return menu.searchPlates(input);
    }

    @Override
    public void showOrderList() {

        if (menu.getDishes().size() > 0) {
            System.out.println("*** This is what you have chosen so far:");
            for (MenuDish menuDish : menu.getDishes()) {
                System.out.println("*** " + menuDish);
            }
        }else {
            System.out.println("*** You haven't selected anything yet");
        }
        System.out.println();
        System.out.println("Press <ENTER> to continue ...");
        sc.nextLine();
    }

}
