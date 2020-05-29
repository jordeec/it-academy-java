package itinerari.vaadim.java.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


/**
 * The main view contains a button and a click listener.
 */
@Route("")
public class MainView extends VerticalLayout {

	/**
     *
     */
    private static final long serialVersionUID = 9077102326994533021L;

    public MainView() {
        H1 h1 = new H1("Welcome to the IT Academy's restaurant");

        Button button = new Button("Click me");
        add(h1, button);

        
    }
}
