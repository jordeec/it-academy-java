package itinerari.restaurant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
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
     * Empty constructor, at least contains 1 eater
     *
     */
    public Menu() {
        this.eaters = 1;
        new Menu(this.eaters);
    }

    /**
     * Constructor with number of eaters
     *
     * @param eaters Number of people to be sit on a table
     */

    public Menu(final int eaters) {
        this.dishes = new ArrayList<MenuDish>();
        this.eaters = eaters;
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
     * @return list of MenuDish where eaters will be able to select from
     */
    private void loadChart() {

        this.restaurantChart = new ArrayList<MenuDish>();

        try {


            // final File f1 = new File("./resources/assets/menu.csv");
            // String[] arr = f1.list();
            // for (String string : arr) {
            //     System.out.println(">>>>>>>>>>>>>>>>> " + string);
            // }

            final File myObj = new File("./resources/assets/menu.csv");
            final Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                final String data = myReader.nextLine();
                final String[] arrPlate = data.split(";");
                final MenuDish menuDish = new MenuDish(arrPlate[0], Float.parseFloat(arrPlate[1]));
                System.out.println(this.restaurantChart.size() );
                this.restaurantChart.add(menuDish);
            }
            myReader.close();
        } catch (final FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

	public void calcularPreu() {
	}

}
