package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.connections.ConnFactory;
import com.revature.dao.UserDAO;

import revature.carappbeans.User;

public class UserDAOImp implements UserDAO {

	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void createUser(String username, String password, String name) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO USER VALUES(USERSEQ.NEXTVAL,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, name);
		ps.executeUpdate();

	}

	@Override
	public List<User> getUserList() throws SQLException {
		List<User> userList = new ArrayList<>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM USER";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		User u = null;
		while (rs.next()) {
			u = new User(rs.getString(1), rs.getString(2), rs.getString(3));
			userList.add(u);
		}

		return userList;
	}
	
	
}
