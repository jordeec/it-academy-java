package itinerari.vaadim.java.controller;

import java.util.List;

import itinerari.vaadim.java.backend.Menu;
import itinerari.vaadim.java.backend.MenuDish;

public class MenuVaadinController implements MenuController {

    public Menu menu = new Menu();

    @Override
    public Menu askForMenu() {
        // No need to ask for menu. The Vaadin application will take charge instead
        return null;
    }

    @Override
    public void checkOutPrice() {
        // TODO Auto-generated method stub

    }

    @Override
    public void addCustomer() {
        // TODO Auto-generated method stub

    }

    @Override
    public MenuDish searchForAPlate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MenuDish> searchPlates(final String input) {
        return menu.searchPlates(input);
    }

    @Override
    public MenuDish getRandomSuggestion() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void showOrderList() {

    }

    @Override
    public void calculateBills() {
        // TODO Auto-generated method stub

    }

}