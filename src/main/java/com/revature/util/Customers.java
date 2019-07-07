package com.revature.util;

import com.revature.carappbeans.Car;
import com.revature.carappbeans.User;

public class Customers {

    
    
    public static Car[] viewMyCars(User u) {
        return null;
    }
    
    public static double[] viewMyPayments(User u) {
        return null;
    }
    
    public static void addNewAccount() {
        Scanners.getUserInfo(Scanners.sc);
    }
    
    public static void login(boolean loggedIn) {
        if(loggedIn) {
            Scanners.customerMenu(Scanners.sc);
        }
    }
    
    public void logout() {
        
    }
}