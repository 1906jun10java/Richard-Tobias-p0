package com.revature.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.Driver;

public class Employees {
    
    static Logger Log = LogManager.getLogger(Driver.class);
    
    
    
    public static double[] viewAllPayments() {
        
        return null;

    }
    
    public static void login(boolean loggedIn) {
        if(loggedIn) {
            Scanners.employeeMenu(Scanners.sc);
        } else {

            Log.error("Invalid login credentials");
            System.out.println("Invalid login");
        }
    }
    
    public void logout() {
        
    }
}