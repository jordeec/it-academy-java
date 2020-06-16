package itinerari.jordic.model;

import java.util.ArrayList;
import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

public class Rocket {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String code;
    @Getter
    @Setter
    private Float targetSpeed;
    @Getter
    @Setter
    private Float currentSpeed;
    @Getter
    @Setter
    private Collection<Propulsor> propulsors;
    @Getter @Setter
    private Integer maxPropulsors;

    public Rocket(Long id, String codi, Integer maxPropulsors) {
        this.id = id;
        this.code = codi;
        this.maxPropulsors = maxPropulsors;
        this.targetSpeed = new Float(0);
        this.currentSpeed = new Float(0);
        this.propulsors = new ArrayList<Propulsor>();
    }

    public Propulsor addPropulsor(Propulsor p) throws MaxPropulsorsReachedException {

        if(propulsors.size() < maxPropulsors.intValue()){
            propulsors.add(p);
        }else {
            throw new MaxPropulsorsReachedException(String.format("Rocket %s does not allow more than %1 propulsors", code, maxPropulsors));
        }

        return p;
    }

    /**
     * Checks the maximum power available for this rocket by the sum of each propulsor 
     * 
     * @return
     */
    public Float getMaxAvailablePower(){
        Float max = 0F;

        // TODO: Jose. Com es pot fer aquesta operació amb lambda??????
        // max = propulsors.forEach(p -> p.getMaxPower() :: sum())); 

        for (Propulsor propulsor : propulsors) {
            max += propulsor.getMaxPower();
        }

        return max;
    }

}