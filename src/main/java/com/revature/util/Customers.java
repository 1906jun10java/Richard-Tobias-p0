package com.revature.util;

import java.sql.SQLException;

import com.revature.carappbeans.User;
import com.revature.daoimpl.CarDAOImp;

public class Customers {

    
    public static void viewMyCars(User u) {
        try {
        	CarDAOImp.getOwnedList(u.getUserID());
		} catch (SQLException e) {
			Scanners.Log.error("Could not successfuly retrieve users cars");
		}
        
    }
    
    public static void viewMyPayments(User u) {
    	try {
			Scanners.idao.getMyInvoices(u.getUserID());
		} catch (SQLException e) {
			Scanners.Log.error("That aint right");
		}
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