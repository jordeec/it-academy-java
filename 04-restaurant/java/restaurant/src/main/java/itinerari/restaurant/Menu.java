package itinerari.restaurant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import itinerari.restaurant.bitllets.Bitllet;
import itinerari.restaurant.bitllets.Bitllet10;
import itinerari.restaurant.bitllets.Bitllet100;
import itinerari.restaurant.bitllets.Bitllet20;
import itinerari.restaurant.bitllets.Bitllet200;
import itinerari.restaurant.bitllets.Bitllet5;
import itinerari.restaurant.bitllets.Bitllet50;
import itinerari.restaurant.bitllets.Bitllet500;

public class Menu {

    final int MAX_SUGGESTIONS = 4;
    /**
     * Contains all the dishes our cook can make! :=)
     */
    private List<MenuDish> restaurantChart;
    /**
     * List with all the dishes in a table
     */
    private List<MenuDish> dishes;
    /*
     * Number of people eating in a table
     */
    private int eaters = 0;

    /**
     * Indicates if the menu is ready to be ordered
     */
    private boolean isReadyToOrder;

    /**
     * Indicates if last search found something or not
     */
    private boolean isLastSearchSuccessful;

    /**
     * Map with Bills to checkout
     */
    private HashMap<Bitllet, Integer> bitllets;

    /**
     * Total amount of the bill
     */
    private float total;

    /**
     * CONSTRUCTORS
     */

    /**
     * Empty constructor, at least will contain 1 eater
     *
     */
    public Menu() {
        this(1);
    }

    /**
     * Constructor with number of eaters. Main constructor
     *
     * @param eaters Number of people to be sit on a table
     */

    public Menu(final int eaters) {
        this.dishes = new ArrayList<MenuDish>();
        this.eaters = eaters;
        this.isReadyToOrder = false;
        this.bitllets = new HashMap<Bitllet, Integer>();
        loadChart(); // Initialize the restaurant chart
    }

    /**
     * BUSSINESS METHODS
     */

    /**
     * Add a given dish to the menu
     *
     * @param dish
     */
    public void addDishToMenu(final MenuDish dish) {
        dishes.add(dish);
        total = total + dish.getPrice();
    }

    /**
     * Access external csv file with a list of delicious plates and random prices
     * generated in excel
     *
     */
    private synchronized void loadChart() {
        this.restaurantChart = new ArrayList<MenuDish>();

        try {

            final File myObj = new File("./resources/assets/menu.csv");
            final Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                final String data = myReader.nextLine();
                final String[] arrPlate = data.split(";");
                final MenuDish menuDish = new MenuDish(arrPlate[0], Float.parseFloat(arrPlate[1]) ); // Adjusting
                                                                                                         // prices
                this.restaurantChart.add(menuDish);
            }
            myReader.close();
        } catch (final FileNotFoundException e) {
            System.out.println("An error occurred while reading resource file.");
            e.printStackTrace();
        }
    }

    /**
     * Picks a dish from the chart randomly
     *
     * @return MenuDish
     */

    public MenuDish getRandomSuggestion() {
        Random rand = new Random();
        return restaurantChart.get(rand.nextInt(restaurantChart.size()));
    }

    /**
     * Search in the available chart given a text, if nothing is found provides a
     * list of suggestions
     *
     * @param input
     * @return
     */

    public List<MenuDish> searchPlates(String input) {
        setLastSearchSuccessful(false);
        List<MenuDish> list = new ArrayList<MenuDish>();
        int i = 0;
        for (MenuDish dish : this.restaurantChart) {
            if (dish.getDishName().toLowerCase().contains(input.toLowerCase())) {
                if (i <= MAX_SUGGESTIONS) {
                    setLastSearchSuccessful(true); // When something is found update boolean attribute
                    list.add(dish);
                    i++;
                }
            }
        }

        for (int j = list.size(); j < MAX_SUGGESTIONS; j++) {
            list.add(this.getRandomSuggestion());
        }

        return list;
    }

    /**
     * Calculates total of bill and fills a list with Bitllets so the minum required
     * amount of each is selected
     */

    public void calculateBills() {

        /*
         * Simple ordered array to better suit the algorith of retrieving the minumum
         * units of each bill
         */
        Bitllet[] lBitllets = { new Bitllet500(), new Bitllet200(), new Bitllet100(), new Bitllet50(), new Bitllet20(),
                new Bitllet10(), new Bitllet5() };

        float amount = this.getTotal();
        Integer module;

        this.getBitllets();
        this.setBitllets(new HashMap<Bitllet, Integer >());

        for (int i = 0; i < lBitllets.length; i++) {
            // for each bill, remember they are ordered from max to min
            if (amount >= lBitllets[i].valor) {
                // computes the minum amount of bills
                module = (int) Math.floor(amount / lBitllets[i].valor);
                // compute the remaining amount
                amount = amount - (module * lBitllets[i].valor);
                // Puts number of bills in map
                this.getBitllets().put(lBitllets[i], new Integer(module));
            }
        }
    }

    /**
     * GETTERS and SETTERS
     */

    public int getEaters() {
        return this.eaters;
    }

    public boolean isReadyToOrder() {
        return this.isReadyToOrder;
    }

    public void setReadyToOrder(boolean bool) {
        this.isReadyToOrder = bool;
    }

    public List<MenuDish> getDishes() {
        return this.dishes;
    }

    public int getNumberOfDishes() {
        return this.dishes.size();
    }

    public List<MenuDish> getRestaurantChart() {
        return this.restaurantChart;
    }

    public int getDishesInMenuChart() {
        return this.restaurantChart.size();
    }

    public boolean isLastSearchSuccessful() {
        return this.isLastSearchSuccessful;
    }

    public void setLastSearchSuccessful(boolean bool) {
        this.isLastSearchSuccessful = bool;
    }

    public HashMap<Bitllet, Integer> getBitllets() {
        return bitllets;
    }

    public void setBitllets(HashMap<Bitllet, Integer> bitllets) {
        this.bitllets = bitllets;
    }

    public void setEaters(final int eaters) {
        this.eaters = eaters;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

}
