package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import com.revature.carappbeans.User;

public interface Users {
	
	public static List<User> userList = new ArrayList<User>();

	User login(boolean loggedIn);
	void logout();
}
