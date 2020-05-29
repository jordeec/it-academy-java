package itinerari.restaurant.controller;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import itinerari.restaurant.Menu;
import itinerari.restaurant.MenuDish;
import itinerari.restaurant.bitllets.Bitllet;

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
                    "*** You can currently choose amongst " + menu.getDishesInMenuChart() + " delicious dishes! *");
            System.out.println("***                                                      ***");
            System.out
                    .println("*** 1) Search for a plate.        (currently ordered " + menu.getNumberOfDishes() + ")");
            System.out.println("*** 2) Change number of customers (currently " + menu.getEaters() + ")");
            System.out.println("*** 3) Show receipt so far           (currently " + menu.getTotal() + "€ )");
            System.out.println("*** 4) Calculate number of bills. ");
            System.out.println("***                                                      ***");
            System.out.println("*** 99) Leave application. Ready to order!               ***");
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
                showOrderList();
                break;
            case "4":
                calculateBills();
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
        System.out.println("************************************************************");
        System.out.println(">>> Enter desired number of eaters (must be between 1 and 20)");
        System.out.println("************************************************************");
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
        List<MenuDish> dishes;
        MenuDish suggestion = menu.getRandomSuggestion();
        System.out.println(">>> Type what you'd like to eat (in Spanish). Random suggestion: " + suggestion);
        String inputText = sc.nextLine();
        dishes = searchPlates(inputText);

        if (menu.isLastSearchSuccessful() == false) {
            System.out.println("*** We haven't found anything like " + inputText + ". Do not worry, though!");

        }

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
        float total = 0;

        if (menu.getDishes().size() > 0) {
            System.out.println("************************************************************");
            System.out.println("*** This is what you have chosen so far:");
            for (MenuDish menuDish : menu.getDishes()) {
                System.out.println("*** " + menuDish);
                total += menuDish.getPrice();
            }
            System.out.println("***");
            System.out.println("*** Total bill: " + total + "€");
            System.out.println("*** Total eaters: " + menu.getEaters());
            System.out.println("*** Total dishes: " + menu.getNumberOfDishes());
            System.out.println("***");
            System.out.println("***");
        } else {
            System.out.println("*** You haven't selected anything yet");
        }
        System.out.println();
        System.out.println("Press <ENTER> to continue ...");
        sc.nextLine();
    }

    @Override
    /**
     * Shows the total of bill and describes the minimum amount of each type of
     * available bills
     */
    public void calculateBills() {

        if (menu.getTotal() > 0) {
            menu.calculateBills();
            System.out.println("************************************************************");
            System.out.println("*** We will need ");

            // source:
            // https://es.stackoverflow.com/questions/2464/c%C3%B3mo-iterar-a-trav%C3%A9s-de-un-hashmap
            for (Map.Entry<Bitllet, Integer> entry : menu.getBitllets().entrySet()) {
                System.out.println("*** " + entry.getValue().intValue() + " bills of " + entry.getKey().valor + "€");
            }
        }else {
            System.out.println("*** Your order is still empty! ");

        }
        System.out.println("*** ");
        System.out.println();
        System.out.println("Press <ENTER> to continue ...");
        sc.nextLine();

    }

}
