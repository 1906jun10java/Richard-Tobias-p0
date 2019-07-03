package com.revature.util;


import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.*;

import com.revature.carappbeans.Car;

public class Lots {
	 private static final Logger LOGGER = LogManager.getLogger(Lots.class.getName());
	
	static ArrayList<Car> carLot = new ArrayList<>();
	
	public static ArrayList<Car> generateCars(ArrayList<Car> carLot) {
		carLot.add(new Car(2010, "Chrysler", "Sebring", "Black", 15000));
		carLot.add(new Car(2014, "Ford", "Explorer", "Black", 15000));
		carLot.add(new Car(2010, "Dodge", "Wrangler", "White", 15000));
		
		return carLot;
	}

	public static void displayLot() {
		LOGGER.info("Generating Cars");
		
		carLot = generateCars(carLot);
		System.out.println("Displaying cars available in the lot: ");
		for(int i = 0; i < carLot.size(); i++) {
			System.out.println("# " + i + " " + carLot.get(i));
		}
	}

}
