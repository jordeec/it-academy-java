package itinerari.jordic.vehicles.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;

public class MyCustomLayout extends Composite<FormLayout> {

    /**
     * 
     */

    private static final long serialVersionUID = -8103844462943842105L;

    public void addItemWithLabel(String label, Component... items) {
        Div itemWrapper = new Div();
        // Wrap the given items into a single div
        itemWrapper.add(items);
        // getContent() returns a wrapped FormLayout
        getContent().addFormItem(itemWrapper, label);
    }

}