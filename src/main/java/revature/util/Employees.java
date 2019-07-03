package revature.util;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import revature.Driver;

public class Employees {
	
	static Logger Log = LogManager.getLogger(Driver.class);
	static Scanner sc = new Scanner(System.in);

	public static void acceptOffer() {
		
	}
	
	public static void rejectOffer() {
		
	}
	
	public static double[] viewAllPayments() {
		return null;
	}
	
	public static void login(boolean loggedIn) {
		if(loggedIn) {
			Scanners.employeeMenu(sc);
		} else {
			Log.error("Invalid login credentials");
			System.out.println("Invalid login");
		}
	}
	
	public void logout() {
		
	}
}
