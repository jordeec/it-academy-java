package itinerari.jordic.vehicles.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import itinerari.jordic.vehicles.exceptions.VehicleException;

public abstract class Vehicle {
	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();

	public void addWheels(final Wheel... wheels) {
		for (final Wheel wheel : wheels) {
			this.wheels.add(wheel);
		}
	}

	/**
	 * Checks if the vehicle contains all the required properties
	 * 
	 */
	public boolean isVehicleValid() throws VehicleException {

		try {
			if (Objects.isNull(plate) || !isPlateValid())
				throw new VehicleException("Plate of vehicle is invalid");
			if (Objects.isNull(brand) || brand.isEmpty())
				throw new VehicleException("Vehicle brand can't be empty!");
			if (Objects.isNull(color) || color.isEmpty())
				throw new VehicleException("Vehicle color can't be empty");

		} catch (RuntimeException e) {
			throw new VehicleException(e.toString());
		}

		return true;
	}

	/**
	 * Check whether the plate is valid according to a regular expression
	 * 
	 * @return
	 */
	public boolean isPlateValid() {
		return plate.matches(CustomMocks.PLATE_REGEXP);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer();

		sb.append("Vehicle:");
		sb.append(plate).append(" ");
		sb.append(brand).append(" ");
		sb.append(color).append(" ");
		;

		for (final Wheel wheel : wheels) {
			sb.append(wheel.getBrand()).append(" ");
			sb.append(Double.valueOf(wheel.getDiameter())).append(" ");
		}

		return sb.toString();
	}

	@Override
	public int hashCode() {
		if (getPlate() != null) {
			return getPlate().hashCode();
		}
		return super.hashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Vehicle other = (Vehicle) obj;
		if (getPlate() == null || other.getPlate() == null) {
			return false;
		}
		return getPlate().equals(other.getPlate());
	}

	/** Getters and Setters */

	public String getPlate() {
		return this.plate;
	}

	public void setPlate(final String plate) {
		this.plate = plate;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(final String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(final String color) {
		this.color = color;
	}

	public List<Wheel> getWheels() {
		return this.wheels;
	}

	public void setWheels(final List<Wheel> wheels) {
		this.wheels = wheels;
	}

}
