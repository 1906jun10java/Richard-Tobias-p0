package com.revature.carappbeans;

public class Car {


	private int car_id;
	private String make;
	private String model;
	private String color;
	private double stickerPrice;
	private int yearManufactured;

	public Car(String make, String model, String color, double stickerPrice, int yearManufactured) {
		super();
		this.make = make;
		this.model = model;
		this.color = color;
		this.stickerPrice = stickerPrice;
		this.yearManufactured = yearManufactured;
	}
	
	public Car(int car_id, String make, String model, String color, double stickerPrice, int yearManufactured) {
		super();
		this.car_id = car_id;

		this.yearManufactured = yearManufactured;
	}
	

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}


	}

	private int yearManufactured;
	private String make;
	private String model;
	private String color;
	private double stickerPrice;
	

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

	@Override
	public String toString() {
		return "Car [yearManufactured=" + yearManufactured + ", make=" + make + ", model=" + model + ", color=" + color
				+ ", stickerPrice=" + stickerPrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		long temp;
		temp = Double.doubleToLongBits(stickerPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + yearManufactured;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Double.doubleToLongBits(stickerPrice) != Double.doubleToLongBits(other.stickerPrice))
			return false;
		if (yearManufactured != other.yearManufactured)
			return false;
		return true;
	}



	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + car_id;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		long temp;
		temp = Double.doubleToLongBits(stickerPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + yearManufactured;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (car_id != other.car_id)
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Double.doubleToLongBits(stickerPrice) != Double.doubleToLongBits(other.stickerPrice))
			return false;
		if (yearManufactured != other.yearManufactured)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Car [car_id=" + car_id + ", make=" + make + ", model=" + model + ", color=" + color + ", stickerPrice="
				+ stickerPrice + ", yearManufactured=" + yearManufactured + "]";
	}
}
