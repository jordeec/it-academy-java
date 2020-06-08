package itinerari.jordic.vehicles.model;

import java.util.List;


public class Car extends Vehicle {

	public Car(String plate, String brand, String color) {

		this.plate = plate;
		this.brand = brand;
		this.color = color;

	}

	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	}

	public void addTwoWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception();

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		if (!rightWheel.equals(leftWheel))
			throw new Exception();

		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
	}

	

}
