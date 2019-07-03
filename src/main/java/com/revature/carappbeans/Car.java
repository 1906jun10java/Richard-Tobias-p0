package com.revature.carappbeans;

public class Car {

	private int car_id;
	private String make;
	private String model;
	private String color;
	private double stickerPrice;
	private int yearManufactured;

	public Car(int car_id, String make, String model, String color, double stickerPrice, int yearManufactured) {
		super();
		this.car_id = car_id;
		this.make = make;
		this.model = model;
		this.color = color;
		this.stickerPrice = stickerPrice;
		this.yearManufactured = yearManufactured;
	}
	
	

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public int getYearManufactured() {
		return yearManufactured;
	}

	public void setYearManufactured(int yearManufactured) {
		this.yearManufactured = yearManufactured;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getStickerPrice() {
		return stickerPrice;
	}

	public void setStickerPrice(double stickerPrice) {
		this.stickerPrice = stickerPrice;
	}

	@Override
	public String toString() {
		return "Car [car_id=" + car_id + ", make=" + make + ", model=" + model + ", color=" + color + ", stickerPrice="
				+ stickerPrice + ", yearManufactured=" + yearManufactured + "]";
	}
	
	

}
