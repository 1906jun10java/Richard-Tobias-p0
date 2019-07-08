package com.revature;
import java.sql.SQLException;

import com.revature.daoimpl.*;

public class DriverTest {
	static CarDAOImp cdao = new CarDAOImp();
	static {
		
		try {
			cdao.getCarList();
		} catch (SQLException e) {
			System.out.println("Throwing Exception for Cars DAO");
			e.printStackTrace();
		}
		InvoiceDAOImp idao = new InvoiceDAOImp();
		try {
			idao.getInvoiceList();
		} catch (SQLException e) {
			System.out.println("Throwing Exception for Invoice DAO");
			e.printStackTrace();
		}
		OffersDAOImp odao = new OffersDAOImp();
		try {
			odao.getAllOffers();
		} catch (SQLException e) {
			System.out.println("Throwing Exception for Offers DAO");
			e.printStackTrace();
		}
		UserDAOImp udao = new UserDAOImp();
		try {
			udao.getUserList();
		} catch (SQLException e) {
			System.out.println("Throwing Exception for Users DAO");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			OffersDAOImp.makeOffer(8, 25000, 2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//CarDAOImp.getAllPayments();
	}
}
