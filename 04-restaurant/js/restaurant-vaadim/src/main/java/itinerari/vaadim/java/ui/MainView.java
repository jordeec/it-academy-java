package itinerari.vaadim.java.ui;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

import itinerari.vaadim.java.backend.MenuDish;
import itinerari.vaadim.java.controller.MenuVaadinController;

/**
 * Empty route means default page
 */
@Route("")
public class MainView extends VerticalLayout {

    /**
     *
     */
    private static final long serialVersionUID = 9077102326994533021L;

    private final MenuVaadinController service = new MenuVaadinController();
    private final TextField filterText = new TextField();
    private final Grid<MenuDish> grid = new Grid<>(MenuDish.class);

    public MainView() {

        final H1 h1 = new H1("Welcome to IT Academy's restaurant");
        final H2 h2 = new H2("Choose amongst our delicious dishes! ");

        configureFilter();

        // Add all elements to the visualization
        add(h1, h2, filterText, grid);
    }

    private void configureFilter() {
        filterText.setPlaceholder("Type any dish (in Spanish)");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());
    }

    private void updateList() {
        service.searchPlates(filterText.getValue());
    }
    
}
