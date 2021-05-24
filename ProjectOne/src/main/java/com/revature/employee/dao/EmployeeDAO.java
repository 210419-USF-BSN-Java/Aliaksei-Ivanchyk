package com.revature.employee.dao;

import com.revature.exception.BusinessException;
import com.revature.models.Employee;

public interface EmployeeDAO {
	public Employee getEmployee(String username, String password) throws BusinessException;
	public Employee getEmployeeById(int id) throws BusinessException;
	public int updateEmployee(int id, String first_name, String last_name, String email) throws BusinessException;

}
