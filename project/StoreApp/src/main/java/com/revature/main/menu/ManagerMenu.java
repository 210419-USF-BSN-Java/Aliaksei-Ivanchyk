package com.revature.main.menu;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.exception.BusinessException;
import com.revature.manager.ManagerDAOCRUD;
import com.revature.manager.dao.impl.ManagerCRUDDAOImpl;
import com.revature.manager.service.ManagerCRUDService;
import com.revature.manager.service.impl.ManagerCRUDServiceImpl;
import com.revature.model.Employee;
import com.revature.scanner.Input;

public class ManagerMenu {
	private Logger Log = Logger.getLogger(ManagerMenu.class);
	Scanner scanner = Input.getScanner();
	ManagerDAOCRUD mdc = new ManagerCRUDDAOImpl();
	ManagerPrintMenu mpm = new ManagerPrintMenu();
	ManagerCRUDService mcs = new ManagerCRUDServiceImpl();
	
	public void logIn() {
		boolean logedIn = false;
		Employee employee = null;
		Log.info("Enter username: ");
		String username = scanner.nextLine();
		Log.info("Enter password: ");
		String password = (scanner.nextLine());
		
		try {
			employee = mdc.logIn(username, password);
			Log.info(employee);
			logedIn = true;

		} catch (BusinessException e) {

			Log.warn("Entered User name and password do not match our records");

		}
		
		if (logedIn) {
			int ch = 0;
			
			do {
				mpm.printActiveMenu();
				try {
					ch = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					Log.warn("Please enter a number only");
				}
				
				switch (ch) {
				
				case 1:
					addNewEmployee();
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					
					break;
					
				}

				
				
				
			} while (ch != 4);
		}
	}

	private void addNewEmployee() {
		Employee employee = new Employee();
		Log.info("Enter first name: ");
		employee.setFirstName(scanner.nextLine());
		Log.info("Enter last name: ");
		employee.setLastName(scanner.nextLine());
		Log.info("Enter username name: ");
		employee.setUsername(scanner.nextLine());
		Log.info("Enter password: ");
		employee.setPassword(scanner.nextLine());
		try {
			mcs.addEmployee(employee);
		} catch (BusinessException e) {
			Log.info("Unable to add new employee");
			e.printStackTrace();
		}
		
		
		
	}

}
