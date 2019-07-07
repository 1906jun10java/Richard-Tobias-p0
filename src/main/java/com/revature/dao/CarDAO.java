package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.carappbeans.Car;

public interface CarDAO {

	public abstract void createCar(String make, String model, String color, double stickerPrice, int yearManufactured) throws SQLException;
	public abstract List<Car> getCarList() throws SQLException;
}
