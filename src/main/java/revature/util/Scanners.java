package revature.util;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import revature.Driver;
import revature.carappbeans.Car;
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
				if (attempt.equals(user.getUserName())) {
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
			if (u.getPasswrd().equals(null)) {
				System.out.println("This user has no password! Please register a new account");
				return false;
			} else if (attempt.equals(u.getPasswrd())) {
				return true;
			} else {
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
			try {
				amount = sc.nextDouble();
				con = false;
			} catch (InputMismatchException e) {
				Log.error("Data entry was not a numeric value.");
				System.out.println("Please enter a valid money value ($.¢¢): ");
				sc.next();
			}
		}
		return amount;
	}

	public static Car newCarDescription(Scanner sc) {
		boolean con = true;
		int year = 0;
		System.out.println("What year was this car manufactured?");
		while (con) {
			try {
				year = sc.nextInt();
				con = false;
			} catch (InputMismatchException e) {
				Log.error("Data entry was not numeric.");
				System.out.println("Please enter a valid year");
				sc.next();
			}
		}
		System.out.println("Please enter the car's manufacturer.");
		String make = "";
		con = true;
		while (con) {
			try {
				make = sc.nextLine();
				con = false;
			} catch (Exception e) {
				Log.error("Invalid Input");
				System.out.println("Invalid input, please try again");
				sc.next();
			}
		}
		System.out.println("What model is the car?");
		String model = "";
		con = true;
		while (con) {
			try {
				model = sc.nextLine();
				con = false;
			} catch (Exception e) {
				Log.error("Invalid Input");
				System.out.println("Invalid input, please try again");
				sc.next();
			}
		}
		System.out.println("What is the color of the car?");
		String color = "";
		con = true;
		while (con) {
			try {
				color = sc.nextLine();
				con = false;
			} catch (Exception e) {
				Log.error("Invalid Input");
				System.out.println("Invalid input, please try again");
				sc.next();
			}
		}
		System.out.println("Please enter the car's sticker price");
		double sticker = 0.0;
		con = true;
		while(con) {
			try {sticker = sc.nextDouble(); con = false;}
			catch(InputMismatchException e) {
				Log.error("A double value was not entered");
				System.out.println("Please enter a valid monetary value ($.¢¢)");
				sc.next();
			}
		}
		Car c = new Car(year,make,model,color,sticker);
		return c;

	}

	public static void mainMenu(Scanner sc) {
		int choice = 0;
		boolean con = true;
		System.out.println(
				"Thank you for using ACME car dealership. \nPlease enter the number for the action you would like to perform");
		System.out.println("1. Login \n" + "2. View Cars in Lot \n" + "3. Exit the program");
		while (con) {
			try {
				choice = sc.nextInt();
			} catch (Exception e) {
				Log.error("No integer input");
				System.out.println("Invalid input. Please enter the number corresponding to your choice.");
				System.out.println("1. Login \n" + "2. View Cars in Lot \n" + "3. Exit the program");
				sc.next();
			}
			if (choice > 0 && choice < 4) {
				con = false;
			} else {
				Log.info("invalid choice");
				System.out.println("Invalid input. Please enter the number corresponding to your choice.");
				System.out.println(
						"1. Login \n" + "2. View Cars in Lot \n" + "3. Create a new Account \n" + "4. Exit program");
			}
			switch (choice) {
			case 1:
				Customers.login(getUsername(sc));
				break;
			case 2:
				displayLot();
				break;
			case 3:
				break;
			case 4:
				break;
			case 0:
				Employees.login(getUsername(sc));
				break;
			default:
				Log.info("The switch case reached it's default case. Invalid scanner input");
				break;
			}
		}
	}

	public static void employeeMenu(Scanner sc) {
		int choice = 0;
		boolean con = true;
		System.out.println("Welcome Employee! Please enter what you would like to do.");
		System.out.println("1. Add Car to Lot \n" + "2. Remove Car from Lot \n" + "3. View Payment Histories \n"
				+ "4. Manage Pending Offers");
		while (con) {
			try {
				choice = sc.nextInt();
				con = false;
			} catch (Exception e) {
				Log.error("Invalid choice");
				System.out.println("Invalid input. Please enter the number corresponding to your choice.");
				System.out.println("1. Add Car to Lot \n" + "2. Remove Car from the Lot \n"
						+ "3. View Payment Histories \n" + "4.Manage Pending Offers");
			}
			switch (choice) {
			case 1:
				Employees.AddNewCar(newCarDescription(sc));
				break;
			case 2:
				Employees.removeCarFromLot(c);
				break;
			case 3:
				Employees.viewAllPayments();
				break;
			case 4:
				Employees.managePendingOffers();
				break;
			default:
				System.out.println("Invalid User Input");
				break;
			}
		}
	}
}
