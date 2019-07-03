package revature;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.carappbeans.User;
import com.revature.daoimpl.CarDAOImp;
import com.revature.daoimpl.InvoiceDAOImp;
import com.revature.daoimpl.OffersDAOImp;
import com.revature.daoimpl.UserDAOImp;

import revature.util.Scanners;

public class Driver {
	
	static {
		CarDAOImp cdao = new CarDAOImp();
		try {
			cdao.getCarList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InvoiceDAOImp idao = new InvoiceDAOImp();
		try {
			idao.getInvoiceList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OffersDAOImp odao = new OffersDAOImp();
		try {
			odao.getAllOffers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserDAOImp udao = new UserDAOImp();
		try {
			udao.getUserList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		User.userList.add(new User("username", "password", "john smith"));
		Scanners.mainMenu(sc);
		sc.close();
		//System.out.println(test);
	}
}
