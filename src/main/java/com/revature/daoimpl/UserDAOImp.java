package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.carappbeans.User;
import com.revature.connections.ConnFactory;
import com.revature.dao.UserDAO;

public class UserDAOImp implements UserDAO {
	
	public static List<User> userList = new ArrayList<User>();

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createUser(String username, String password, String name, int access) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO SYSTEM_USERS VALUES(USERSEQ.NEXTVAL,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, name);
		ps.setInt(4, access);
		ps.executeUpdate();

	}

	public List<User> getUserList() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT USER_ID, USER_NAME, USERNAME, PASS, USER_TYPE FROM SYSTEM_USERS";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		User u = null;
		while (rs.next()) {
			u = new User(rs.getInt("USER_ID"), rs.getString("USERNAME"), rs.getString("PASS"), rs.getString("USER_NAME"), rs.getInt("USER_TYPE"));
			userList.add(u);
		}

		return userList;
	}

	  public boolean validateUser(String username) throws SQLException{
		  Connection conn = cf.getConnection(); String sql = "SELECT * FROM SYSTEM_USERS WHERE USERNAME = ? AND ACCESS = 1";
		  PreparedStatement stmt = conn.prepareStatement(sql);
		  stmt.setString(1, username);
		  ResultSet rs =stmt.executeQuery();
		  if(rs.getFetchSize() > 0) {
			  return true;
		  }else { 
			  return false; 
		  } 
	  }
	 
}