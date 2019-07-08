package com.revature.carappbeans;

public class Invoice {

	private int invoice_id;
	private int user_id;
	private int car_id;
	private String sell_date;
	private double amount_owed;
	
	public Invoice(int user_id, int car_id, double amount_owed) {
		super();
		this.user_id = user_id;
		this.car_id = car_id;
		this.amount_owed = amount_owed;
	}

	public int getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public String getSell_date() {
		return sell_date;
	}

	public void setSell_date(String sell_date) {
		this.sell_date = sell_date;
	}

	public double getAmount_owed() {
		return amount_owed;
	}

	public void setAmount_owed(double amount_owed) {
		this.amount_owed = amount_owed;
	}

	@Override
	public String toString() {
		return "Invoice [invoice_id=" + invoice_id + ", user_id=" + user_id + ", car_id=" + car_id + ", sell_date="
				+ sell_date + ", amount_owed=" + amount_owed + "]";
	}
	
	
	
	
}
