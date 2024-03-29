package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.carappbeans.Offer;
import com.revature.connections.ConnFactory;
import com.revature.dao.OffersDAO;
import com.revature.util.Scanners;

public class OffersDAOImp implements OffersDAO {

	public static List<Offer> offerList = new ArrayList<Offer>();
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createOffer(int user_id, int car_id, double current_offer, int accepted) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO OFFERS VALUES(OFFERSEQ.NEXTVAL,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, user_id);
		ps.setInt(2, car_id);
		ps.setDouble(3, current_offer);
		ps.setInt(4, accepted);
		ps.executeUpdate();
		// Refreshes the offer list to reflect changes
		getAllOffers();
	}

	public List<Offer> getAllOffers() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM OFFERS";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		Offer o = null;
		while (rs.next()) {
			o = new Offer(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getInt(4));
			offerList.add(o);
		}

		return offerList;
	}

	public static boolean makeOffer(int car_id, double offer, int user_id) {
		Connection conn = cf.getConnection();
		/*
		 * String sql1 = "SELECT * FROM OFFERS WHERE USER_ID = " + user_id +
		 * " AND CAR_ID = " + car_id; PreparedStatement stmt =
		 * conn.prepareStatement(sql1); ResultSet rs = stmt.executeQuery();
		 */
		// if (rs.isFirst() == false) {
		System.out.println("Attempting to create new offer.");
		String sql2 = "INSERT INTO OFFERS VALUES(?,?,?,NULL)";
		PreparedStatement ps1;
		try {
			ps1 = conn.prepareStatement(sql2);
			ps1.setInt(1, user_id);
			ps1.setInt(2, car_id);
			ps1.setDouble(3, offer);
			ps1.executeUpdate();
			System.out.println("Successfuly added new offer for Car ID: " + car_id);
			Scanners.odao.getAllOffers();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		/*
		 * }else { String sql3 =
		 * "UPDATE OFFERS SET CURRENT_OFFER = ? WHERE USER_ID = ? AND CAR_ID = ?";
		 * PreparedStatement ps2 = conn.prepareStatement(sql3); ps2.setDouble(1, offer);
		 * ps2.setInt(2, user_id); ps2.setInt(3, car_id); ps2.executeUpdate();
		 * System.out.println("Successfuly updated current offer for Car ID: " +
		 * car_id); return true; }
		 */
	}

	public static boolean acceptOffer(int user_id, int car_id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql1 = "UPDATE OFFERS SET ACCEPTED = ? WHERE USER_ID = ? AND CAR_ID = ?";
		PreparedStatement ps2 = conn.prepareStatement(sql1);
		ps2.setInt(1, 1);
		ps2.setInt(2, user_id);
		ps2.setInt(3, car_id);
		ps2.executeUpdate();
		System.out.println("Successfuly accepted current offer for Car ID: " + car_id);
		System.out.println("Creating invoice for sale.");
		// creates invoice after accepting offer
		InvoiceDAOImp i = new InvoiceDAOImp();
		// Fix invoice cost amount
		i.createInvoice(user_id, car_id, 15000);
		deleteOffer(user_id, car_id);
		return true;
	}

	public static boolean rejectOffer(int user_id, int car_id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql3 = "UPDATE OFFERS SET ACCEPTED = ? WHERE USER_ID = ? AND CAR_ID = ?";
		PreparedStatement ps2 = conn.prepareStatement(sql3);
		ps2.setInt(1, 0);
		ps2.setInt(2, user_id);
		ps2.setInt(3, car_id);
		ps2.executeUpdate();
		System.out.println("Successfuly rejected current offer for Car ID: " + car_id);
		return true;
	}

	public static boolean deleteOffer(int user_id, int car_id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql3 = "DELETE FROM OFFERS WHERE USER_ID = ? AND CAR_ID = ?";
		PreparedStatement ps2 = conn.prepareStatement(sql3);
		ps2.setInt(1, user_id);
		ps2.setInt(2, car_id);
		ps2.executeUpdate();
		// System.out.println("Successfully deleted offer for Car ID: " + car_id + " &
		// User ID: " + user_id);
		return true;
	}

	public static boolean deleteOtherOffers(int car_id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql3 = "DELETE FROM OFFERS WHERE CAR_ID = ?";
		PreparedStatement ps2 = conn.prepareStatement(sql3);
		ps2.setInt(1, car_id);
		ps2.executeUpdate();
		System.out.println("Successfuly deleted all offers for Car ID: " + car_id);
		return true;
	}

}