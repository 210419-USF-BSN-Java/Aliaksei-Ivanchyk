package com.revature.employee.service.impl;

import org.apache.log4j.Logger;

import com.revature.customer.service.impl.CustomerSearchServiceImpl;
import com.revature.employee.dao.EmployeeSearchDAO;
import com.revature.employee.dao.impl.EmployeeSearchDAOImpl;
import com.revature.employee.service.EmployeeSearchService;
import com.revature.exception.BusinessException;
import com.revature.model.Customer;
import com.revature.model.Employee;
import com.revature.model.User;
import com.revature.validations.CustomerValidations;

public class EmployeeSearchServiceImpl implements EmployeeSearchService {
	private static Logger Log = Logger.getLogger(EmployeeSearchServiceImpl.class);
	EmployeeSearchDAO esd = new EmployeeSearchDAOImpl();

	@Override
	public Employee logIn(String username, String password) throws BusinessException {
		Employee employee = null;
		if (CustomerValidations.isValidPassword(password) && CustomerValidations.isValidUserName(username)) {
			employee = esd.logIn(username, password);
			if (employee != null) {
				Log.info("Loggin succesful");	
				} else {
					Log.info("Unable to retrieve the customer from database");
					throw new BusinessException("Entered User name and password are invalid format");
				}
			
		} else {
			throw new BusinessException("Entered User name and password are invalid format");
		}
		return employee;
	}

}
