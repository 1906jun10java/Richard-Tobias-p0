package com.revature.util;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.Driver;
import com.revature.carappbeans.Car;
import com.revature.carappbeans.User;
import com.revature.daoimpl.CarDAOImp;
import com.revature.daoimpl.InvoiceDAOImp;
import com.revature.daoimpl.OffersDAOImp;
import com.revature.daoimpl.UserDAOImp;

public class Scanners {

	static Logger Log = LogManager.getLogger(Driver.class);
	static UserDAOImp udao = new UserDAOImp();
	public static CarDAOImp cdao = new CarDAOImp();
	public static Scanner sc = new Scanner(System.in);
	static OffersDAOImp odao = new OffersDAOImp();
	public static InvoiceDAOImp idao = new InvoiceDAOImp();
	static User u = new User();

	public static boolean getUsername(Scanner sc) {
		boolean con = true;
		String attempt;
		User u = new User();
		System.out.println("Please enter your Username: ");
		while (con) {
			attempt = sc.next();
			for (User user : UserDAOImp.userList) {
				if (attempt.equals(user.getUserName())) {
					con = false;
					u = user;
					break;
				}
			}
			if (con) {
				Log.error("No matching username in database");
				System.out.println("The username entered does not match an existing username. Please try again.");
			}
		}
		return getPasswrd(sc, u);
	}

	public static boolean getPasswrd(Scanner sc, User u2) {
		boolean con = true;
		System.out.println("Please enter your password: ");
		while (con) {
			String attempt = sc.next();
			if (u2.getPasswrd().equals(null)) {
				System.out.println("This user has no password! Please register a new account");
				return false;
			} else if (attempt.equals(u2.getPasswrd())) {
				u = u2;
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
				// sc.next();
			}
		}
		System.out.println("Please enter the car's manufacturer.");
		String make = "";
		con = true;
		while (con) {
			try {
				make = sc.next();
				con = false;
			} catch (Exception e) {
				Log.error("Invalid Input");
				System.out.println("Invalid input, please try again");
				
			}
			sc.nextLine();
		}
		System.out.println("What model is the car?");
		String model = "";
		con = true;
		while (con) {
			try {
				model = sc.next();
				con = false;
			} catch (Exception e) {
				Log.error("Invalid Input");
				System.out.println("Invalid input, please try again");
				// sc.next();
			}
		}
		System.out.println("What is the color of the car?");
		String color = "";
		con = true;
		while (con) {
			try {
				color = sc.next();
				con = false;
			} catch (Exception e) {
				Log.error("Invalid Input");
				System.out.println("Invalid input, please try again");
				// sc.next();
			}
		}
		System.out.println("Please enter the car's sticker price");
		double sticker = 0.0;
		con = true;
		while (con) {
			try {
				sticker = sc.nextDouble();
				con = false;
			} catch (InputMismatchException e) {
				Log.error("A double value was not entered");
				System.out.println("Please enter a valid monetary value ($.¢¢)");
				sc.next();
			}
		}
		Car c = new Car();
		c.setColor(color);
		c.setMake(make);
		c.setModel(model);
		c.setStickerPrice(sticker);
		c.setYearManufactured(year);
		return c;
	}

	public static void getUserInfo(Scanner sc) {
		User u = new User();
		String attempt = "";
		boolean con = true;
		System.out.println("Hello new user! Welcome to the ACME car app! \nPlease enter your desired username.");
		while (con) {
			try {
				attempt = sc.next();
			} catch (InputMismatchException e) {
			}
			for (User i : UserDAOImp.userList) {
				if (i.getUserName() == attempt) {
					try {
						throw new InputMismatchException();
					} catch (InputMismatchException e) {
						System.out.println("Username already exists. Please try again.");
						sc.hasNext();
						break;
					}
				} else {
					u.setUserName(attempt);
					con = false;
				}
			}
		}
		con = true;
		System.out.println("Please enter the password you would like to use.");
		while (con) {
			try {
				attempt = sc.next();
			} catch (InputMismatchException e) {
			}
			u.setPasswrd(attempt);
			con = false;
		}
		con = true;
		System.out.println("Please enter your name");
		while (con) {
			try {
				attempt = sc.next();
			} catch (InputMismatchException e) {
			}
			u.setName(attempt);
			con = false;
		}
		try {
			udao.createUser(u.getUserName(), u.getPasswrd(), u.getName(), 0);
		} catch (SQLException e) {
			System.out.println("There was an error creating this account! Please try again!");
			Log.error("User creation encountered an error");
			e.printStackTrace();
			return;
		}
		try {
			UserDAOImp.userList = udao.getUserList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("User account created successfully! Please log in to view user functions!");
	}

	public static void mainMenu(Scanner sc) {
		int choice = 0;
		boolean con = true;
		boolean con2 = true;
		System.out.println(
				"Thank you for using ACME car dealership. All sales final. \nPlease enter the number for the action you would like to perform");
		while (con2) {
			System.out
					.println("1. Login \n" + "2. View Cars in Lot \n" + "3. Create New Account \n" + "4. Exit Program");
			con = true;
			while (con) {
				try {
					choice = sc.nextInt();
				} catch (Exception e) {
					Log.error("No integer input");
					System.out.println("Invalid input. Please enter the number corresponding to your choice.");
					System.out.println("1. Login \n" + "2. View Cars in Lot \n" + "3. Create a new Account \n"
							+ "4. Exit Program");
					sc.next();
				}
				if (choice >= 0 && choice < 5) {
				} else {
					Log.info("invalid choice");
					System.out.println("Invalid input. Please enter the number corresponding to your choice.");
					System.out.println("1. Login \n" + "2. View Cars in Lot \n" + "3. Create a new Account \n"
							+ "4. Exit program");
				}
				switch (choice) {
				case 1:
					Customers.login(getUsername(sc));
					sc.nextLine();
					con = false;
					break;
				case 2:
					CarDAOImp.displayCurrentLot();
					sc.nextLine();
					con = false;
					break;
				case 3:
					Customers.addNewAccount();
					sc.nextLine();
					con = false;
					break;
				case 4:
					con = false;
					con2 = false;
					break;
				case 0:
					Employees.login(getUsername(sc));
					sc.nextLine();
					con = false;
					break;
				default:
					Log.info("The switch case reached it's default case. Invalid user input");
					break;
				}
			}
		}
	}

	public static void employeeMenu(Scanner sc) {
		int choice = 0;
		boolean con = true;
		boolean con2 = true;
		System.out.println("Welcome Employee! Please enter what you would like to do.");
		while (con2) {
			System.out.println("1. Add Car to Lot \n" + "2. Remove Car from Lot \n" + "3. View Payment Histories \n"
					+ "4. Manage Pending Offers \n" + "5. Log out");
			con = true;
			while (con) {
				try {
					choice = sc.nextInt();
					con = false;
				} catch (Exception e) {
					Log.error("Invalid choice");
					System.out.println("Invalid input. Please enter the number corresponding to your choice.");
					System.out.println("1. Add Car to Lot \n" + "2. Remove Car from the Lot \n"
							+ "3. View Payment Histories \n" + "4.Manage Pending Offers \n" + "5.Log out");
				}
				switch (choice) {
				case 1:
					Car c = newCarDescription(sc);
					try {
						cdao.createCar(c.getMake(), c.getModel(), c.getColor(), c.getStickerPrice(),
								c.getYearManufactured());
						sc.next();
						System.out.println("Car created successfully");
						//Refreshes the car list to reflect changes
						cdao.carList = cdao.getCarList();
					} catch (SQLException e1) {
						Log.error("Error utilizing the SQL database");
					}
					break;
				case 2:
					try {
						CarDAOImp.deleteCar(selectCar2(sc).getCar_id());
					} catch (SQLException e1) {
						Log.error("SQL errors happen");
					}
					sc.nextLine();
					break;
				case 3:
					Employees.viewAllPayments();
					sc.nextLine();
					break;
				case 4:
						System.out.println(OffersDAOImp.offerList);
						sc.nextLine();
					break;
				case 5:
					con2 = false;
					con = false;
					break;
				default:
					System.out.println("Invalid User Input, returning to previous menu");
					con = false;
					break;
				}
			}
		}
	}

	public static void customerMenu(Scanner sc) {
		int choice = 0;
		boolean con = true;
		boolean con2 = true;
		System.out.println("Welcome customer, please select what you would like to do!");
		while (con2) {
			System.out.println("1. View my cars \n" + "2. View remaining payments \n"
					+ "3. Make an offer on a car in the lot\n " + "4. Log Out");
			con = true;
			while (con) {
				try {
					choice = sc.nextInt();
					con = false;
				} catch (InputMismatchException e) {
					Log.info("Invalid choice");
					System.out.println("Invalid choice, please select a number corresponding to an option");
					System.out.println("1. View my cars \n" + "2. View remaining payments \n"
							+ "3. Make an offer on a car in the lot\n " + "4. Log Out");
				}
				switch (choice) {
				case 1:
					Customers.viewMyCars(u);
					sc.nextLine();
					con = false;
					break;
				case 2:
					Customers.viewMyPayments(u);
					sc.nextLine();
					con = false;
					break;
				case 3:
					try {
						OffersDAOImp.makeOffer(selectCar(sc).getCar_id(), getMoneyValue(sc), u.getUserID());
					} catch (SQLException e) {
						Log.error("SQL communication borked");
					}
					sc.nextLine();
					con = false;
					break;
				case 4:
					con = false;
					con2 = false;
					break;
				default:
					System.out.println("Invalid selection. please try again");
					con = false;
					break;
				}
			}
			
		}
	}

	public static Car selectCar(Scanner sc) {
		boolean con = true;
		int attempt = -1;
		System.out.println("Please select the car you would like to make an offer on");
		CarDAOImp.displayCurrentLot();
		while (con) {
			try {
				attempt = sc.nextInt();
				con = false;
			} catch (InputMismatchException e) {
				Log.info("Invalid entry from user");
			}
		}
		Car c = CarDAOImp.currentLot.get(attempt - 1);
		return c;
	}
	
	public static Car selectCar2(Scanner sc) {
		boolean con = true;
		int attempt = 0;
		System.out.println("Please select the car you would like to remove from the lot");
		CarDAOImp.displayCurrentLot();
		while (con) {
			try {
				attempt = sc.nextInt();
				con = false;
			} catch (InputMismatchException e) {
				Log.info("Invalid entry from user");
			}
		}
		Car c = CarDAOImp.currentLot.get(attempt - 1);
		return c;
	}
}