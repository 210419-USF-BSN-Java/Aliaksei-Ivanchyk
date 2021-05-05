package com.revature.main.menu;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.exception.BusinessException;
import com.revature.manager.ManagerDAOCRUD;
import com.revature.manager.dao.impl.ManagerCRUDDAOImpl;
import com.revature.manager.service.ManagerCRUDService;
import com.revature.manager.service.impl.ManagerCRUDServiceImpl;
import com.revature.model.Employee;
import com.revature.model.SaleRecord;
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
					try {
						addNewEmployee();
					} catch (NumberFormatException e) {
						Log.warn("Please enter values in aa right format");
					}
					break;
				case 2:
					try {
						deleteEmployee();
					} catch (BusinessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NumberFormatException e) {
						Log.warn("Please enter values in aa right format");
					}
					
					
					break;
				case 3:
					try {
						listSalesRecords();
					} catch (BusinessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
				case 4:
					
					break;
					
				}

				
				
				
			} while (ch != 4);
		}
	}

	private void listSalesRecords() throws BusinessException {
		List<SaleRecord> salerecords = mdc.getSalesHistory();
		
		for (int i = 0; i < salerecords.size(); i++) {
			Log.info(salerecords.get(i).toString());
		}
		
		
	}

	private void deleteEmployee() throws BusinessException {
		Log.info("Enter employee id: ");
		int employee_id = Integer.parseInt(scanner.nextLine());
		int c = mdc.deleteEmployee(employee_id);
		if (c > 0) {
			Log.info("Employee deleted succesfully");
		} else {
			Log.info("Unable to delete employee");
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
