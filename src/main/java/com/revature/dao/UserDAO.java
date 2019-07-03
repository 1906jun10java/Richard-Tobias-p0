package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.carappbeans.User;

public interface UserDAO {

	public abstract void createUser(String username, String password, String name) throws SQLException;
	public abstract List<User> getUserList() throws SQLException;
}
