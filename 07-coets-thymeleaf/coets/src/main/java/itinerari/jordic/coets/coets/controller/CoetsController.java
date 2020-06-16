package itinerari.jordic.coets.coets.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import itinerari.jordic.model.Rocket;
import itinerari.jordic.service.RocketService;

@Controller
public class CoetsController  {

    private final List<Rocket> rockets = new ArrayList<Rocket>();
    private final RocketService svc = new RocketService();

    @GetMapping("/index")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "Ready to control") final String name,
            final Model model) {
        model.addAttribute("status", name);

        // Initializes the screen with default values
        svc.init(model);

        // Extract information from the model and sets some screen attributes

        return "index";
    }


}
