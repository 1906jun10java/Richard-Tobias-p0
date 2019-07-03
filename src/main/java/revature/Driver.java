package revature;

import java.util.Scanner;

import revature.carappbeans.User;
import revature.util.Scanners;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		User.userList.add(new User("username", "password", "john smith"));
		Scanners.mainMenu(sc);
		sc.close();
		//System.out.println(test);
	}
}
