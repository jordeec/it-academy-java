package itinerari.jordic.vehicles.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import itinerari.jordic.vehicles.exceptions.VehicleException;
import itinerari.jordic.vehicles.model.Bike;
import itinerari.jordic.vehicles.model.Car;
import itinerari.jordic.vehicles.model.CustomMocks;
import itinerari.jordic.vehicles.model.Vehicle;
import itinerari.jordic.vehicles.model.Wheel;

public class VehicleController {

    List<Vehicle> vehicles;

    /**
     * Initializes an empty array list with the vehicles we are holding in our
     * application
     */

    public VehicleController() {
        vehicles = new ArrayList<Vehicle>();
    }

    /**
     * Adds a vehicle to the list with all the required attributes
     * 
     * @param type       we are currently restricting to CAR and BIKE
     * @param plate      String with the plate
     * @param brand      Brand of the vehicle
     * @param color      Color of the vehicle
     * @param brandFR    Brand of the front wheels
     * @param diameterFR Diameter for the front wheel
     * @param brandBK    Brand for the rear wheels
     * @param diameterBK Diamter for the rear wheel
     * 
     * @return  a correct Vehicle object or VehicleException
     */

    public Vehicle addVehicle(final String type, final String plate, final String brand, final String color,
            final String brandFR, final String diameterFR, final String brandBK, final String diameterBK)
            throws VehicleException {

        Vehicle v = null;

        switch (type) {
            case CustomMocks.CAR:
                v = new Car(plate, brand, color);
                break;
            default:
                v = new Bike(plate, brand, color);
                break;
        }

        if (v.isVehicleValid()) {
            addWheels(v, brandFR, diameterFR, brandBK, diameterBK);
            vehicles.add(v);
        }

        return v;

    }

    /**
     * Gets the contents of the controller list of objects
     * 
     * @return
     */
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Creates a couple of valid wheels and adds them to the vehicle. Will return an
     * exception if the wheels are not valid
     * 
     * @param vehicle    is the object where we want to add the wheels to
     * @param brandFR    brand of the front wheel
     * @param diameterFR diameter of the front wheel
     * @param brandBK    brand of the rear wheel
     * @param diameterBK diameter of the rear wheels
     * 
     * @throws VehicleException
     */
    public void addWheels(final Vehicle vehicle, final String brandFR, final String diameterFR, final String brandBK,
            final String diameterBK) throws VehicleException {

        double diameterFront, diameterBack;

        System.out.format("addWheels starting with parameters: %s %s %s %s", brandFR, diameterFR, brandBK, diameterBK);
        if (Objects.isNull(brandFR) || brandFR.isEmpty())
            throw new VehicleException("Front wheels brand is empty");
        if (Objects.isNull(brandBK) || brandBK.isEmpty())
            throw new VehicleException("Back wheels brand is empty");

        try {
            diameterFront = Double.parseDouble(diameterFR);
        } catch (final Exception e) {
            throw new VehicleException("Front wheels diameter seems invalid");
        }

        try {
            diameterBack = Double.parseDouble(diameterBK);
        } catch (final Exception e) {
            throw new VehicleException("Read wheels diameters seems invalid");
        }

        if (diameterFront <= 0.4 || diameterFront >= 4)
            throw new VehicleException("Front wheels are out of range");
        if (diameterBack <= 0.4 || diameterBack >= 4)
            throw new VehicleException("Back wheels are out of range");

        final Wheel frontWheel = new Wheel(brandFR, diameterFront);
        final Wheel backWheel = new Wheel(brandBK, diameterBack);

        // Call to method receving a list of parameters of type wheels
        addWheels(vehicle, frontWheel, backWheel);
    }

    /**
     * Adds some wheels to the vehicle, regarding of the kind of them
     * 
     * @param vehicle
     * @param wheels
     */
    public void addWheels(final Vehicle vehicle, final Wheel... wheels) {
        vehicle.addWheels(wheels);
    }
}