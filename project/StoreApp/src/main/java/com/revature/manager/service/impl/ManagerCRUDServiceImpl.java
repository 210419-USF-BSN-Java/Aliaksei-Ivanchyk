package com.revature.manager.service.impl;

import org.apache.log4j.Logger;

import com.revature.exception.BusinessException;
import com.revature.manager.ManagerDAOCRUD;
import com.revature.manager.dao.impl.ManagerCRUDDAOImpl;
import com.revature.manager.service.ManagerCRUDService;
import com.revature.model.Employee;
import com.revature.validations.CustomerValidations;

public class ManagerCRUDServiceImpl implements  ManagerCRUDService{
	ManagerDAOCRUD mcd = new ManagerCRUDDAOImpl();
	private static Logger Log = Logger.getLogger(ManagerCRUDServiceImpl.class);

	@Override
	public int addEmployee(Employee employee) throws BusinessException {
		int c = 0;
		if (CustomerValidations.isValidFirstName(employee.getFirstName()) && CustomerValidations.isValidLastName(employee.getLastName()) 
				&& CustomerValidations.isValidPassword(employee.getPassword()) 
				&& CustomerValidations.isValidUserName(employee.getUsername())) {
			c = mcd.addEmployee(employee);
		}
		return c;
	}

}
