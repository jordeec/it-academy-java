package itinerari.jordic.model;

import lombok.Getter;
import lombok.Setter;

public class Propulsor  {
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private Rocket rocket;
    @Getter @Setter
    private Float maxPower;
    @Getter @Setter
    private Float currentPower;

    public Propulsor(Rocket rocket, Float maxPower) {
        this.rocket = rocket;
        this.maxPower = maxPower;
    }

    


    
}