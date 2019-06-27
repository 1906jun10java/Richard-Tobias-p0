package com.revature.util;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.carappbeans.User;

public class Scanners {
	
	public static boolean getUsername(Scanner sc) {
		boolean con = true;
		User u = new User();
		System.out.println("Please enter your Username: ");
		String attempt = sc.next();
		while (con) {
			for (User user : User.userList) {
				if(attempt.equals(user.getUserName())) {
					con = false;
					u = user;
				} else {
					System.out.println("The username entered does not match an existing username. Please try again.");
					sc.next();
				}
			}
		}
		return getPasswrd(sc, u);
		
	}
	
	public static boolean getPasswrd(Scanner sc, User u) {
		boolean con = true;
		System.out.println("Please enter your password: ");
		String attempt = sc.next();
		while (con) {
			if (attempt.equals(u.getPasswrd())) {
				return true;
			}
			else if(u.getPasswrd().equals(null)) {
				System.out.println("This user has no password! Please register a new account");
				return false;
			} else {
				System.out.println("This password does not match this username.");
				sc.next();
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
				System.out.println("Please enter a valid money value ($.¢¢): ");
				sc.hasNext();
			}
		}
		return amount;
	}
	

}
