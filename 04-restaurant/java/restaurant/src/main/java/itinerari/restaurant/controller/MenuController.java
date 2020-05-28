package itinerari.restaurant.controller;

import java.util.List;

import itinerari.restaurant.Menu;
import itinerari.restaurant.MenuDish;

public interface MenuController {

    public Menu askForMenu();
    public void checkOutPrice();
    public void addCustomer();
    public MenuDish searchForAPlate();
    public List<MenuDish> searchPlates(String input);
    public MenuDish getRandomSuggestion();
    public void showOrderList();

}
