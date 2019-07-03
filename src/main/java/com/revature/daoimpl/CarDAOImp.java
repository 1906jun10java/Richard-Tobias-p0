package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.connections.ConnFactory;
import com.revature.dao.CarDAO;

import revature.carappbeans.Car;

public class CarDAOImp implements CarDAO {

	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public List<Car> getCarList() throws SQLException {
		List<Car> carList = new ArrayList<>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM CAR";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		Car c = null;
		while (rs.next()) {
			c = new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
			carList.add(c);
		}

		return carList;
	}

	@Override
	public void createCar(int yearManufactured, String make, String model, String color, double stickerPrice)
			throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO CAR VALUES(USERSEQ.NEXTVAL,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, yearManufactured);
		ps.setString(2, make);
		ps.setString(3, model);
		ps.setString(4, color);
		ps.setDouble(5, stickerPrice);
		ps.executeUpdate();
		
	}

	
}
