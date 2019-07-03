package com.revature.util;

import com.revature.carappbeans.User;

public interface Users {

	User login(String username, String passwrd);
	void logout();
}
