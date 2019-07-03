package revature.util;

import java.util.ArrayList;
import java.util.List;

import com.revature.daoimpl.CarDAOImp;

import revature.carappbeans.Car;
import revature.carappbeans.User;

public class Customers {
	
	static CarDAOImp cdi = new CarDAOImp();
	

	public static double makeOffer(double offer, Car c) {
		return 0.0;
	}
	
	public static List<Car> viewMyCars(User u) {
		List<Car> carList = new ArrayList<>();
		try {carList = cdi.getCarList();}
		catch(Exception e) {
		
		}
		for (Car c : carList) {
			if 
		}
	}
	
	public static double[] viewMyPayments(User u) {
		return null;
	}
	
	public static User login(boolean loggedIn) {
		return null;
	}
	
	public void logout() {
		
	}
}
