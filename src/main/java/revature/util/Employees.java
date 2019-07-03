package revature.util;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.carappbeans.Car;
import com.revature.carappbeans.User;
import com.revature.daoimpl.CarDAOImp;

import revature.Driver;

public class Employees {
	
	//static Logger Log = LogManager.getLogger(Driver.class);

	public static boolean acceptOffer() {
		
	}
	
	public static void rejectOffer() {
		
	}
	
	public static double[] viewAllPayments() {
		
		return null;
	}
	
	public static boolean addNewCar(Car c) throws SQLException{
		CarDAOImp cdao = new CarDAOImp();
		try {
			cdao.createCar(c.getYearManufactured(), c.getMake(), c.getModel(), c.getColor(), c.getStickerPrice());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
		
	}
	
	public static void login(boolean loggedIn) {
		if(loggedIn) {
			Scanners.employeeMenu();
		} else {
			Log.error("Invalid login credentials");
			System.out.println("Invalid login");
		}
	}
	
	public void logout() {
		
	}
}
