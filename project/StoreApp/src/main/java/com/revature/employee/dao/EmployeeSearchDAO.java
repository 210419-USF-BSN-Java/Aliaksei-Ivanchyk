package com.revature.employee.dao;

import com.revature.exception.BusinessException;
import com.revature.model.Employee;
import com.revature.model.User;

public interface EmployeeSearchDAO {
	public Employee logIn(String username, String password ) throws BusinessException;

}
