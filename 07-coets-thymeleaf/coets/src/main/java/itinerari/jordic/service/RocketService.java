package itinerari.jordic.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import itinerari.jordic.model.Propulsor;
import itinerari.jordic.model.Rocket;

@Service
public class RocketService {

    /**
     * Fills the model with the values specified in the exercise 
     * 
     * @param model
     */
    public void init(Model model) {
        Rocket r1 = new Rocket(1L, "Apollo XI", 3);
        r1.addPropulsor(new Propulsor(r1, 10F));
        r1.addPropulsor(new Propulsor(r1, 30F));
        r1.addPropulsor(new Propulsor(r1, 80F));

        Rocket r2 = new Rocket(2L, "Soyuz I", 6);
        r2.addPropulsor(new Propulsor(r2, 30F));
        r2.addPropulsor(new Propulsor(r2, 40F));
        r2.addPropulsor(new Propulsor(r2, 50F));
        r2.addPropulsor(new Propulsor(r2, 50F));
        r2.addPropulsor(new Propulsor(r2, 30F));
        r2.addPropulsor(new Propulsor(r2, 10F));

        // Adds the two rockets to the controller
        model.addAttribute("rocket1", r1);
        model.addAttribute("rocket2", r2);

        System.out.println(model.getAttribute("r1e1max"));
	}
    
}