package com.revature.main.menu;


import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.customer.service.CustomerSearchService;
import com.revature.customer.service.impl.CustomerSearchServiceImpl;
import com.revature.exception.BusinessException;
import com.revature.main.Main;
import com.revature.model.Customer;
import com.revature.model.User;
import com.revature.scanner.Input;

import jdk.internal.org.jline.utils.Log;

public class CustomerMenu {
	CustomerSearchService csm = new CustomerSearchServiceImpl();
	Scanner scanner = Input.getScanner();
	private static Logger Log = Logger.getLogger(CustomerMenu.class);
	

	public  void LogIn() {
		boolean logedIn = false;
		Customer customer = new Customer();;
		Log.info("Enter username: ");
		String username = scanner.nextLine();
		Log.info("Enter password: ");
		String password = (scanner.nextLine());
		customer.setPassword(password);
		customer.setUsername(username);
		
		try {
			customer = csm.logIn(username, password);
			Log.info(customer);
			logedIn = true;

		} catch (BusinessException e) {

			Log.warn("Entered User name and password do not match our records");

		}
		
		
		
	};

}
