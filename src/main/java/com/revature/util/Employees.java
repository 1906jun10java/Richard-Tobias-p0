package com.revature.util;

import java.sql.SQLException;

import com.revature.daoimpl.CarDAOImp;

public class Employees {

	public static void viewAllPayments() {
		try {
			CarDAOImp.getAllPayments();
		} catch (SQLException e) {
			Scanners.Log.error("Trouble getting all user payments");
		}
	}

	public static void login(boolean loggedIn) {
		if (loggedIn) {

			if (Scanners.u.isAccess() != 1) {
				System.out.println("That's not an employee login! Sorry!");
				return;
			}

			Scanners.employeeMenu(Scanners.sc);
		} else {
			Scanners.Log.error("Invalid login credentials");
			System.out.println("Invalid login");
		}
	}

	public void logout() {

	}
}