package revature.util;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import revature.Driver;

import revature.carappbeans.User;

public class Scanners {
	static Logger Log = LogManager.getLogger(Driver.class);

	public static boolean getUsername(Scanner sc) {
		boolean con = true;
		User u = new User();
		System.out.println("Please enter your Username: ");
		while (con) {
			String attempt = sc.nextLine();
			for (User user : User.userList) {
				if(attempt.equals(user.getUserName())) {
					con = false;
					u = user;
				} else {
					Log.error("No matching username in database");
					System.out.println("The username entered does not match an existing username. Please try again.");
				}
			}
		}
		return getPasswrd(sc, u);
		
	}
	
	public static boolean getPasswrd(Scanner sc, User u) {
		boolean con = true;
		System.out.println("Please enter your password: ");
		while (con) {
			String attempt = sc.next();
			if(u.getPasswrd().equals(null)) {
				System.out.println("This user has no password! Please register a new account");
				return false;
			}
			else if (attempt.equals(u.getPasswrd())) {
				return true;
			}else {
				Log.error("Password entered does not match the expected password.");
				System.out.println("This password does not match this username.");
			}
		}
		return false;
	}
	
	public static double getMoneyValue(Scanner sc) {
		boolean con = true;
		double amount = 0.0;
		while (con) {
			System.out.println("Please enter the money value desired ($.¢¢): ");
			try { amount = sc.nextDouble(); con = false;}
			catch(InputMismatchException e) {
				Log.error("Data entry was not a numeric value.");
				System.out.println("Please enter a valid money value ($.¢¢): ");
				sc.hasNext();
			}
		}
		return amount;
	}
	
	public static void mainMenu(Scanner sc) {
		int choice = 0;
		boolean con = true;
		System.out.println("Thank you for using ACME car dealership. \nPlease enter the number for the action you would like to perform");
		System.out.println("1. Login \n" + "2. View Cars in Lot \n" + "3. Exit the program");
		while(con) {
			try{choice = sc.nextInt();}
			catch(Exception e) {
				Log.error("No integer input");
				System.out.println("Invalid input. Please enter the number corresponding to your choice.");
				System.out.println("1. Login \n" + "2. View Cars in Lot \n" + "3. Exit the program");
				sc.next();
			}
			if(choice > 0 && choice < 4) {
				con = false;
			} else {
				Log.info("invalid choice");
				System.out.println("Invalid input. Please enter the number corresponding to your choice.");
				System.out.println("1. Login \n" + "2. View Cars in Lot \n" + "3. Create a new Account \n" + "4. Exit program");
			}
			switch(choice) {
			case 1: Customers.login(getUsername(sc)); break;
			case 2: Lots.displayLot(); break;
			case 3: break;
			case 4: break;
			case 0: Employees.login(getUsername(sc)); break;
			default:Log.info("The switch case reached it's default case. Invalid scanner input"); break;
			}
		}
	}

	public static void employeeMenu() {
		// TODO Auto-generated method stub
		
	}
}
