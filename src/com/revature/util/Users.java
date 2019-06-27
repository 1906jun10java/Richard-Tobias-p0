package com.revature.util;

import com.revature.carappbeans.User;

public interface Users {

	User login(boolean loggedIn);
	void logout();
}
