package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.carappbeans.Invoice;
import com.revature.connections.ConnFactory;

public class InvoiceDAOImp {


	public static List<Invoice> invoiceList = new ArrayList<Invoice>();
	public static ConnFactory cf = ConnFactory.getInstance();

	//pulls the current car table into the program
r
	public List<Invoice> getInvoiceList() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM INVOICE";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		Invoice i = null;
		while (rs.next()) {
			i = new Invoice(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			invoiceList.add(i);
		}

		return invoiceList;
	}

	public void createInvoice(int user_id, int car_id, double amount_owed)
			throws SQLException {

		Connection conn = cf.getConnection();
		String sql = "INSERT INTO INVOICE VALUES(USERSEQ.NEXTVAL,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, user_id);
		ps.setInt(2, car_id);
		ps.setDouble(3, amount_owed);
		ps.executeUpdate();

		//Refreshes the car list to reflect changes
		getInvoiceList();
	}
	

	public void getMyInvoices(int user_id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM INVOICE WHERE USER_ID = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, user_id);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {

			System.out.println("Car # " + rs.getInt(3) + " Total Owed: $" +  rs.getInt(4));
		}
	}
	
}

