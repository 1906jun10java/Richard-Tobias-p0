package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.carappbeans.Invoice;
import com.revature.connections.ConnFactory;
import com.revature.util.Invoices;

public class InvoiceDAOImp {

	public static ConnFactory cf = ConnFactory.getInstance();

	//pulls the current car table into the program
	public List<Invoice> getInvoiceList() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM INVOICE";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		Invoice i = null;
		while (rs.next()) {
			i = new Invoice(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
			Invoices.invoiceList.add(i);
		}

		return Invoices.invoiceList;
	}

	
	public void createInvoice(int invoice_id, int user_id, int car_id, String sell_date, double amount_owed)
			throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO INVOICE VALUES(USERSEQ.NEXTVAL,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, invoice_id);
		ps.setInt(2, user_id);
		ps.setInt(3, car_id);
		ps.setString(4, sell_date);
		ps.setDouble(5, amount_owed);
		ps.executeUpdate();
		//Refreshes the car list to reflect changes
		getInvoiceList();
	}
}
