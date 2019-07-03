package revature.util;

import revature.carappbeans.Car;

import java.sql.SQLException;

import com.revature.daoimpl.CarDAOImp;
import revature.carappbeans.User;

public class Cars {
	static CarDAOImp cdi = new CarDAOImp();

	public static void addToLot(Car c) {
		try {
			cdi.createCar(c.getYearManufactured(), c.getMake(), c.getModel(), c.getColor(), c.getStickerPrice());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void changeOwner(Car c, User u) {
		
	}
	
	public static void removeFromLot(Car c) {
		
	}
}
