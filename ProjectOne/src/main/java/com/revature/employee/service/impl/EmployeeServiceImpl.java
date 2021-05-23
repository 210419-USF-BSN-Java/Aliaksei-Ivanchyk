package com.revature.employee.service.impl;

import com.revature.employee.dao.EmployeeDAO;
import com.revature.employee.dao.impl.EmployeeDAOImpl;
import com.revature.employee.service.EmployeeService;
import com.revature.exception.BusinessException;
import com.revature.models.Employee;
import com.revature.validations.Validations;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDAO ed = new EmployeeDAOImpl();

	@Override
	public Employee getEmployee(String username, String password) {
		Employee employee = null;
		if (Validations.isValidUserName(username) && Validations.isValidPassword(password)) {
			try {
				employee = ed.getEmployee(username, password);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return employee;
	}

}
