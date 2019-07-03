package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.carappbeans.Car;
import com.revature.carappbeans.Offer;
import com.revature.connections.ConnFactory;
import com.revature.dao.OffersDAO;

import revature.util.Cars;
import revature.util.Offers;

public class OffersDAOImp implements OffersDAO{

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createOffer(int user_id, int car_id, double current_offer, String offer_date, int accepted)
			throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO OFFERS VALUES(OFFERSEQ.NEXTVAL,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, user_id);
		ps.setInt(2, car_id);
		ps.setDouble(3, current_offer);
		ps.setString(4, offer_date);
		ps.setInt(5, accepted);
		ps.executeUpdate();
		//Refreshes the offer list to reflect changes
		getAllOffers();
	}

	public List<Offer> getAllOffers() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM OFFERS";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		Offer o = null;
		while (rs.next()) {
			o = new Offer(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4), rs.getInt(5));
			Offers.offerList.add(o);
		}

		return Offers.offerList;
	}

}
