package itinerari.jordic.vehicles.model;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		this.setBrand(brand);
		this.setDiameter(diameter);
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return brand + " " + diameter;
	}
}
