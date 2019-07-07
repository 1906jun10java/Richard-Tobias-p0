package com.revature.carappbeans;

public class Offer {
	
	private int user_id;
	private int car_id;
	private double current_offer;
	private String offer_date;
	private int accepted;
	
	public Offer(int user_id, int car_id, double current_offer, String offer_date, int accepted) {
		super();
		this.user_id = user_id;
		this.car_id = car_id;
		this.current_offer = current_offer;
		this.offer_date = offer_date;
		this.accepted = accepted;
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

	public double getCurrent_offer() {
		return current_offer;
	}

	public void setCurrent_offer(double current_offer) {
		this.current_offer = current_offer;
	}

	public String getOffer_date() {
		return offer_date;
	}

	public void setOffer_date(String offer_date) {
		this.offer_date = offer_date;
	}

	public int isAccepted() {
		return accepted;
	}

	public void setAccepted(int accepted) {
		this.accepted = accepted;
	}

	@Override
	public String toString() {
		return "Offers [user_id=" + user_id + ", car_id=" + car_id + ", current_offer=" + current_offer
				+ ", offer_date=" + offer_date + ", accepted=" + accepted + "]";
	}
	
	
	
}
