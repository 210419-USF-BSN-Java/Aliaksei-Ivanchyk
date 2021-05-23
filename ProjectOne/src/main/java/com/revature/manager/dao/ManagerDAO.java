package com.revature.manager.dao;

import java.util.List;

import com.revature.exception.BusinessException;
import com.revature.models.Employee;

public interface ManagerDAO {
	public List<Employee> getAllEmployees() throws BusinessException;
	

}
