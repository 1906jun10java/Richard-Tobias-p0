package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.carappbeans.Offer;

public interface OffersDAO {
	public abstract void createOffer(int user_id, int car_id, double current_offer, int accepted) throws SQLException;
	public abstract List<Offer> getAllOffers() throws SQLException;
}
