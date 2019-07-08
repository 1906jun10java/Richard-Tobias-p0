package scanners;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

import com.revature.carappbeans.User;
import com.revature.util.Scanners;
import com.revature.util.Users;


public class ScannerTests {

	static Scanner sc = new Scanner(System.in);
	
	@Test
	public void properPasswordAndUsernameGiveTrue() {
		boolean ans = true;

		UserDAOImp.userList.add(new User ("username", "password", "name", 0));

		assertEquals(ans, Scanners.getUsername(sc));
		sc.close();
	}
	
}
