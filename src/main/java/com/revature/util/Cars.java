package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import com.revature.carappbeans.Car;
import com.revature.daoimpl.CarDAOImp;


public class Cars {
	
	public static List<Car> carList = new ArrayList<Car>();

	public static void displayCurrentLot(){
		boolean[] checker = new boolean[Invoices.invoiceList.size()];
		for(int i = 0; i < CarDAOImp.carList.size(); i++) {
			for(int j = 0; j <Invoices.invoiceList.size(); j++) {
				if(CarDAOImp.carList.get(i).getCar_id() == Invoices.invoiceList.get(j).getCar_id()) {
					checker[j] = false;
					break;
				}else {
					checker[j] = true;
				}
			}
			
			int exists = 0;
			for(int k = 0; k < checker.length; k++) {
				if (checker[k] == false) {
					exists++;
				}
			}
			if(exists > 0) {
				continue;
			}else {
				System.out.println(CarDAOImp.carList.get(i));
			}
		}
		
	}
}
