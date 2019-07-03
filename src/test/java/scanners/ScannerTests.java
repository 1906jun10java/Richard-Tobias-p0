package scanners;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;
import org.junit.Test;

import revature.carappbeans.User;
import revature.util.Scanners;

public class ScannerTests {

	static Scanner sc = new Scanner(System.in);
	
	@Test
	public void properPasswordAndUsernameGiveTrue() {
		boolean ans = true;
		User.userList.add(new User ("username", "password", "name"));
		assertEquals(ans, Scanners.getUsername(sc));
		sc.close();
	}
	
}
