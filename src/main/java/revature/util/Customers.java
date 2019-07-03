package revature.util;

import java.util.List;

import com.revature.daoimpl.CarDAOImp;

import revature.carappbeans.Car;
import revature.carappbeans.User;

public class Customers {
	
	static CarDAOImp cdi = new CarDAOImp();
	List<Car> carList = cdi.getCarList();

	public static double makeOffer(double offer, Car c) {
		return 0.0;
	}
	
	public static Car[] viewMyCars(User u) {
		for (Car c : CarList) {
			
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
