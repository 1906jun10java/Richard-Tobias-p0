package com.revature.util;

import java.sql.SQLException;

import com.revature.carappbeans.Car;
import com.revature.carappbeans.User;
import com.revature.daoimpl.CarDAOImp;

public class Customers {

    
    
    public static Car[] viewMyCars(User u) {
    	try {
			CarDAOImp.getOwnedList(u.getUserID());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Scanners.Log.error("SQL Exception was thrown by ViewMyCars method");
		}
        return null;
    }
    
    public static double[] viewMyPayments(User u) {
        return null;
    }
    
    public static void addNewAccount() {
        Scanners.getUserInfo(Scanners.sc);
    }
    
    public static void login(boolean loggedIn) {
        if(loggedIn) {
            Scanners.customerMenu(Scanners.sc);
        }
    }
    
    public void logout() {
        
    }
}