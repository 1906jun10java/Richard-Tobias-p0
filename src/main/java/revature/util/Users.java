package revature.util;

import revature.carappbeans.User;

public interface Users {

	User login(boolean loggedIn);
	void logout();
}
