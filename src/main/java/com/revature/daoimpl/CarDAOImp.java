package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.carappbeans.Car;
import com.revature.connections.ConnFactory;
import com.revature.dao.CarDAO;
import com.revature.util.Cars;

public class CarDAOImp implements CarDAO {

	public static ConnFactory cf = ConnFactory.getInstance();

	//pulls the current car table into the program
	public List<Car> getCarList() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM CAR";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		Car c = null;
		while (rs.next()) {
			c = new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6));
			Cars.carList.add(c);
		}

		return Cars.carList;
	}

	
	public void createCar(int car_id, String make, String model, String color, double stickerPrice, int yearManufactured)
			throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO CAR VALUES(USERSEQ.NEXTVAL,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, car_id);
		ps.setString(2, make);
		ps.setString(3, model);
		ps.setString(4, color);
		ps.setDouble(5, stickerPrice);
		ps.setInt(6, yearManufactured);
		ps.executeUpdate();
		//Refreshes the car list to reflect changes
		getCarList();
	}

	
}
