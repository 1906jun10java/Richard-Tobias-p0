package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import com.revature.carappbeans.Car;
import com.revature.carappbeans.Invoice;
import com.revature.carappbeans.User;

public class Cars {
	
	public static List<Car> carList = new ArrayList<Car>();

	public static void displayCurrentLot(){
		boolean[] checker = new boolean[Invoices.invoiceList.size()];
		for(int i = 0; i < Cars.carList.size(); i++) {
			for(int j = 0; j <Invoices.invoiceList.size(); j++) {
				if(Cars.carList.get(i).getCar_id() == Invoices.invoiceList.get(j).getCar_id()) {
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
				System.out.println(Cars.carList.get(i));
			}
		}
		
	}
}
