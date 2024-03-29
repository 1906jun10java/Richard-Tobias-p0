package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.carappbeans.Invoice;

public interface InvoiceDAO {

	public abstract void createInvoice(int yearManufactured, String make, String model, String color, double stickerPrice) throws SQLException;
	public abstract List<Invoice> getCarList() throws SQLException;
}
