package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import revature.carappbeans.Car;

public interface CarDAO {

	public abstract void createCar(int yearManufactured, String make, String model, String color, double stickerPrice) throws SQLException;
	public abstract List<Car> getCarList() throws SQLException;
}
