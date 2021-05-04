package com.revature.employee.service;

import com.revature.exception.BusinessException;
import com.revature.model.Employee;


public interface EmployeeSearchService {

	public Employee logIn(String username, String password) throws BusinessException;



}
