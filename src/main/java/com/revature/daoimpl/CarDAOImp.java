package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.revature.carappbeans.Car;
import com.revature.connections.ConnFactory;
import com.revature.dao.CarDAO;

public class CarDAOImp implements CarDAO {

	//TEST VALUES
	
	public static List<Car> carList = new ArrayList<Car>();
	public static List<Car> currentLot = new ArrayList<Car>();
	public static List<Car> ownedList = new ArrayList<Car>();
	public static Set<Car> newCurrentLot = new HashSet<Car>();
	public static ConnFactory cf = ConnFactory.getInstance();
	static CarDAOImp cd = new CarDAOImp();
	static InvoiceDAOImp id = new InvoiceDAOImp();

	//pulls the current car table into the program
	public List<Car> getCarList() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM CAR";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		Car c = null;
		while (rs.next()) {
			c = new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6));
			carList.add(c);
		}

		return carList;
	}

	
	public void createCar(String make, String model, String color, double stickerPrice, int yearManufactured)
			throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO CAR VALUES(USERSEQ.NEXTVAL,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, make); 
		ps.setString(2, model); 
		ps.setString(3, color);
		ps.setDouble(4, stickerPrice); 
		ps.setInt(5, yearManufactured);
		ps.executeUpdate();
		//Refreshes the car list to reflect changes
		getCarList();
	}
	

	/*
	 * public static void displayCurrentLot() throws SQLException {
	 * ownedList.clear(); Connection conn = cf.getConnection(); String sql =
	 * "SELECT * FROM CAR RIGHT OUTER JOIN INVOICE ON CAR.CAR_ID = INVOICE.CAR_ID";
	 * PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs =
	 * stmt.executeQuery(); Car c = null; while (rs.next()) { c = new
	 * Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
	 * rs.getDouble(5), rs.getInt(6)); ownedList.add(c); } for(int i = 0; i <
	 * carList.size(); i++) { for(int j = 0; j < ownedList.size(); j++) {
	 * if(ownedList.get(j).getCar_id() == carList.get(i).getCar_id()) {
	 * newCurrentLot.add(carList.get(j)); } } }
	 * while(newCurrentLot.iterator().hasNext()){
	 * System.out.println(newCurrentLot.iterator().next()); } if(ownedList.size() ==
	 * 0) { System.out.println("There are no owned cars for this user."); }
	 * 
	 * 
	 * }
	 */
	public static void displayCurrentLot(){
		try {
			cd.getCarList();
			id.getInvoiceList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Getting Cars In Lot");
		boolean[] checker = new boolean[InvoiceDAOImp.invoiceList.size()];
		for(int i = 1; i < carList.size(); i++) {
			for(int j = 0; j <InvoiceDAOImp.invoiceList.size(); j++) {
				if(carList.get(i).getCar_id() == InvoiceDAOImp.invoiceList.get(j).getCar_id()) {
					//System.out.println("Car " + j + " has been purchased.");
					checker[j] = false;
					
				}else {
					//System.out.println("Car " + j + " has not been purchased.");
					checker[j] = true;
				}
			}
			
			int exists = 0;
			for(int k = 0; k < checker.length; k++) {
				if (checker[k] == false) {
					exists++;
				}
			}
			if(exists > 0) {
				continue;
			}else {
				currentLot.add(carList.get(i));
				System.out.println(carList.get(i));
			}
		}
		
	}
	
	public static void deleteCar(int car_id) throws SQLException{
				Connection conn = cf.getConnection();
				String sql = "DELETE FROM CAR WHERE CAR_ID = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, car_id);
				ps.executeUpdate();
				System.out.println("Car with ID # " + car_id + " has been successfuly removed.");
				System.out.println("Refreshing the lot...");
				carList = cd.getCarList();
				//displayCurrentLot();
	}
	
	public static void getOwnedList(int user_id) throws SQLException {
		ownedList.clear();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM CAR WHERE CAR_ID IN(SELECT CAR_ID FROM INVOICE WHERE USER_ID = 1)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, user_id);
		ResultSet rs = stmt.executeQuery();
		Car c = null;
		while (rs.next()) {
			c = new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6));
			ownedList.add(c);
		}
		for(int i = 0; i < ownedList.size(); i++) {
			System.out.println(ownedList.get(i));
		}
		if(ownedList.size() == 0) {
			System.out.println("There are no owned cars for this user.");
		}
		
		
	}
	
	public static List<Car> getAllOwnedList() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM CAR WHERE CAR_ID IN(SELECT USER_ID FROM INVOICE)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		Car c = null;
		while (rs.next()) {
			c = new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6));
			ownedList.add(c);
		}
		
		for(int i =0; i < ownedList.size(); i++) {
			System.out.println(ownedList.get(i));
		}
		if(ownedList.size() == 0) {
			System.out.println("There are no owned cars currently.");
		}
		
		return ownedList;
	}
	
	public static void getAllPayments() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT CAR.CAR_ID, (CAR.STICKER_PRICE)-(INVOICE.AMOUNT_OWED) AS AMOUNT_PAID FROM CAR INNER JOIN INVOICE ON CAR.CAR_ID = INVOICE.CAR_ID";
		PreparedStatement stmt = conn.prepareStatement(sql);
		//stmt.setInt(1, user_id);
		ResultSet rs = stmt.executeQuery();
		while(rs.next() == true) {
			System.out.println("Car # " + rs.getInt(1) + " accounted for $" + rs.getInt(2));
			//System.out.println(rs.getInt(2));
		}
	}
	
	
}
