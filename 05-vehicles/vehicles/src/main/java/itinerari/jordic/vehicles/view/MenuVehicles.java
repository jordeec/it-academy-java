package itinerari.jordic.vehicles.view;

import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import itinerari.jordic.vehicles.controller.VehicleController;
import itinerari.jordic.vehicles.exceptions.VehicleException;
import itinerari.jordic.vehicles.model.CustomMocks;
import itinerari.jordic.vehicles.model.Vehicle;

/**
 * This is the main view of our application. It uses Vaadin, this framework
 * allows me to draw the html page directly from Java
 * 
 * The @Route annotation is used to identify the empty page in my Spring
 * application
 * 
 * @Viewport is used in the same way as it would be used in HTML5
 * 
 * @author jordeec
 * 
 */

@Route("")
@Viewport("width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes, viewport-fit=cover")
public class MenuVehicles extends VerticalLayout {

    private static final long serialVersionUID = -908657519287510104L;

    final TextField carPlate = new TextField();
    final ComboBox<String> bikeBrands = fillCombox(CustomMocks.getBikeBrands());
    final ComboBox<String> carBrands = fillCombox(CustomMocks.getCarBrands());
    final ComboBox<String> colors = fillCombox(CustomMocks.getColors());
    final RadioButtonGroup<String> rbVehicle = fillRadioButton();
    final Div selectedVehicle = new Div(); // Will store the kind of vehicle we are working with
    final Div saveStatus = new Div();
    final UnorderedList listOfVehicles = new UnorderedList();
    final ComboBox<String> wheelsFR = fillCombox(CustomMocks.getWheels());
    final ComboBox<String> wheelsBK = fillCombox(CustomMocks.getWheels());
    final TextField diameterFR = new TextField();
    final TextField diameterBK = new TextField();

    final VehicleController vehicleController = new VehicleController();

    /**
     * Will build a rich html view in Java, all the attributes are set with methods
     * 
     */
    public MenuVehicles() {

        final H1 mainHeader = new H1("Welcome to IT Academy's garage");
        final H2 subHeader = new H2("Selling wheels since 2020");

        /**
         * MyCustomLayout is an auxiliary component that fills a DIV in an horizontal
         * layout with a label on the left
         * 
         */
        final MyCustomLayout layoutPlate = new MyCustomLayout();
        /**
         * First component is the plate input text. Contains a placeholder and a
         * validation mak It also includes a value listener in order to always store the
         * plate in uppercase
         */
        carPlate.setClearButtonVisible(true);
        carPlate.setPattern(CustomMocks.PLATE_REGEXP);
        carPlate.setPlaceholder("9999-XXX");
        carPlate.setErrorMessage("Please input the plate according to the placeholder");
        layoutPlate.addItemWithLabel("Input the plate for your vehicle", carPlate);
        carPlate.addValueChangeListener(event -> {
            carPlate.setValue(carPlate.getValue().toUpperCase());
        });

        /**
         * Second component is the vehicle details, a couple of self-hiding combobox to
         * seggregate cars and bikes' brands and a common combobox for the color
         * 
         */

        final MyCustomLayout layoutVehicle = new MyCustomLayout();
        bikeBrands.setPlaceholder("Choose your bike's brand");
        carBrands.setPlaceholder("Choose your car's brand");
        colors.setPlaceholder("Pick a color");

        layoutVehicle.addItemWithLabel("Enter your vehicle's details", rbVehicle, carBrands, bikeBrands, colors);

        /**
         * Third component is a layout with a couple of buttons (each with its own
         * function) and a small status text
         */
        final MyCustomLayout layoutButtons = new MyCustomLayout();
        final HorizontalLayout hl = new HorizontalLayout();
        final Button saveButton = new Button("Save Vehicle", new Icon(VaadinIcon.ARROW_FORWARD));
        saveButton.addClickListener(click -> saveButton());
        final Button resetButton = new Button("Reset Fields", new Icon(VaadinIcon.ARROW_BACKWARD));
        resetButton.addClickListener(click -> resetFields());
        hl.add(resetButton, saveButton);
        layoutButtons.addItemWithLabel("Operations", hl, saveStatus);

        /**
         * Fourth component is the front wheels' input fields
         */
        final MyCustomLayout layoutFRWheels = new MyCustomLayout();
        wheelsFR.setPlaceholder("Choose your tyre's brand");
        diameterFR.setPlaceholder("Input diameter for your front wheels");
        setDiameterValidations(diameterFR, diameterBK);
        layoutFRWheels.addItemWithLabel("Choose your front wheels", wheelsFR, diameterFR);

        final MyCustomLayout layoutRWWheels = new MyCustomLayout();
        wheelsBK.setPlaceholder("Choose your tyre's brand");
        diameterBK.setPlaceholder("Input diameter for your rear wheels");
        layoutRWWheels.addItemWithLabel("Choose your rear wheels", wheelsBK, diameterBK);

        /**
         * In the following method all the components including a header and sections
         * are distributed vertically
         */
        add(mainHeader, subHeader, selectedVehicle, layoutPlate, layoutVehicle, layoutFRWheels, layoutRWWheels,
                layoutButtons, listOfVehicles);

        /**
         * Since everything is controlled from the server side a few auxilary methods
         * are required
         * 
         */
        resetFields();

    }

    /**
     * Specifies the validation rules for diameter input fields There's a bug in the
     * regular expression accepting values such as 0.3 and 4.9
     * 
     * I hope I will handle this properly in the backend
     * 
     * @param diameter
     */
    private void setDiameterValidations(final TextField... diameter) {
        for (final TextField textField : diameter) {
            textField.setErrorMessage("Only diameters between 0.4 and 4 are allowed");
            textField.setPattern(CustomMocks.DIAMETER_REGEXP);
        }

    }

    /**
     * Clears the fields to get the screen ready for new input data
     * 
     */
    private Object resetFields() {
        // Init values in the screen
        rbVehicle.setValue(CustomMocks.CAR);
        carPlate.clear();
        carBrands.clear();
        colors.clear();
        wheelsFR.clear();
        wheelsBK.clear();
        diameterBK.clear();
        diameterFR.clear();

        fillSaveStatus("Select brand and color to continue");

        return null;

    }

    /**
     * Fills a unordered list with the contents of the vehicles stored in the app
     * 
     * @return Vaddin component unordered list html
     */
    private void fillListOfVehicles() {
        final List<Vehicle> list = vehicleController.getVehicles();
        listOfVehicles.removeAll();

        System.out.format("Elements in the vehicle list %s", list.size());

        for (final Vehicle vehicle : list) {
            final ListItem li = new ListItem();
            li.add(vehicle.toString());
            listOfVehicles.add(li);
        }

    }

    /**
     * Saves a vehicle with the values from screen by sending it to the controller
     * 
     * @return new Vehicle from controlller
     */
    private Vehicle saveButton() {

        String brand = "";
        final String plate = carPlate.getValue();
        final String color = colors.getValue();
        Vehicle vehicle = null;

        try {

            switch (rbVehicle.getValue()) {
                case CustomMocks.CAR:
                    brand = carBrands.getValue();
                    break;
                case CustomMocks.BIKE:
                    brand = bikeBrands.getValue();
                    break;
            }

            vehicle = vehicleController.addVehicle(rbVehicle.getValue(), plate, brand, color, wheelsFR.getValue(), diameterFR.getValue(), wheelsBK.getValue(), diameterBK.getValue());
            fillSaveStatus("Vehicle " + rbVehicle.getValue() + " " + vehicle + " is saved!");
            // Updates the list of vehicles
            fillListOfVehicles();

        } catch (final VehicleException e) {
            fillSaveStatus(e.getMessage() + ". Vehicle couldn't be saved!");
        }

        return vehicle;
    }

    /**
     * Shows an status line depending of the conditions of the screen
     * 
     * @param string
     * 
     */
    private void fillSaveStatus(final String... string) {

        final StringBuffer sb = new StringBuffer();
        for (final String str : string) {
            sb.append(str);
        }

        saveStatus.setText(sb.toString());

    }

    /**
     * Fills a combobox html component with the contents of a list
     * 
     * @param l String list with the values to be inserted as elements in the
     *          component
     * 
     * @return Vaadin component of type combobox
     */
    private ComboBox<String> fillCombox(final List<String> l) {
        final ComboBox<String> ret = new ComboBox<String>();

        ret.setItems(l);
        return ret;

    }

    /**
     * Builds a radio button group specifically for our application (it can
     * currently works with CAR and BIKE only) when an option is selected the
     * corresponding combobox for the brand is shown
     * 
     * @return Vaadin component of type Radio Button
     */
    private RadioButtonGroup<String> fillRadioButton() {
        final RadioButtonGroup<String> rbVehicle = new RadioButtonGroup<String>();
        rbVehicle.setItems(CustomMocks.CAR, CustomMocks.BIKE);

        /**
         * This lambda add a Change Listener to the radio button that allows me to
         * show/hide components
         */

        rbVehicle.addValueChangeListener(event -> {
            if (event.getValue() == null) {
                selectedVehicle.setText("No option selected");
            } else {

                switch (event.getValue()) {
                    case CustomMocks.CAR:
                        selectedVehicle.setText("We have the wheels for your car!");
                        break;
                    case CustomMocks.BIKE:
                        selectedVehicle.setText("Does your bike need a new set of wheels?");
                        break;
                }

                bikeBrands.setVisible(CustomMocks.BIKE.equals(rbVehicle.getValue()));
                carBrands.setVisible(CustomMocks.CAR.equals(rbVehicle.getValue()));
            }
        });

        return rbVehicle;

    }

}