package itinerari.vaadim.java.controller;

import java.util.List;

import itinerari.vaadim.java.backend.Menu;
import itinerari.vaadim.java.backend.MenuDish;

public interface MenuController {

    public Menu askForMenu();
    public void checkOutPrice();
    public void addCustomer();
    public MenuDish searchForAPlate();
    public List<MenuDish> searchPlates(String input);
    public MenuDish getRandomSuggestion();
    public void showOrderList();
    public void calculateBills();

}
