package com.revature.employee.dao;

import com.revature.exception.BusinessException;
import com.revature.models.Employee;

public interface EmployeeDAO {
	public Employee getEmployee(String username, String password) throws BusinessException;

}
