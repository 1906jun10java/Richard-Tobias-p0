package com.revature.util;

import java.util.ArrayList;

import com.revature.carappbeans.Car;

public class Lots {
	
	static ArrayList<Car> carLot = new ArrayList<>();
	
	public static ArrayList<Car> generateCars(ArrayList<Car> carLot) {
		carLot.add(new Car(2010, "Chrysler", "Sebring", "Black", 15000));
		carLot.add(new Car(2014, "Ford", "Explorer", "Black", 15000));
		carLot.add(new Car(2010, "Dodge", "Wrangler", "White", 15000));
		
		return carLot;
	}

	public static void displayLot() {
		carLot = generateCars(carLot);
	}
}
