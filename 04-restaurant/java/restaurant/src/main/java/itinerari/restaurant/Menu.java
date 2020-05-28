package itinerari.restaurant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
     * Empty constructor, at least will contain 1 eater
     *
     */
    public Menu() {
        this(1);
    }

    /**
     * Constructor with number of eaters
     *
     * @param eaters Number of people to be sit on a table
     */

    public Menu(final int eaters) {
        this.dishes = new ArrayList<MenuDish>();
        this.eaters = eaters;
        this.isReadyToOrder = false;
        loadChart(); // Initialize the restaurant chart
    }

    public void addDishToMenu(final MenuDish dish) {
        dishes.add(dish);
    }

    public void setEaters(final int eaters) {
        this.eaters = eaters;
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
                final MenuDish menuDish = new MenuDish(arrPlate[0], Float.parseFloat(arrPlate[1]) / 10);    // Adjusting prices
                this.restaurantChart.add(menuDish);
            }
            myReader.close();
        } catch (final FileNotFoundException e) {
            System.out.println("An error occurred while reading resource file.");
            e.printStackTrace();
        }

    }

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

    public MenuDish getRandomSuggestion() {
        Random rand = new Random();
        return restaurantChart.get(rand.nextInt(restaurantChart.size()));
    }

    public List<MenuDish> searchPlates(String input) {
        List<MenuDish> list = new ArrayList<MenuDish>();
        int i = 0;
        for (MenuDish dish : this.restaurantChart) {
            if (dish.getDishName().toLowerCase().contains(input.toLowerCase())) {
                if(i <= MAX_SUGGESTIONS) {
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

}
