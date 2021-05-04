package com.revature.manager.service;

import com.revature.exception.BusinessException;
import com.revature.model.Employee;

public interface ManagerCRUDService {

	public int addEmployee(Employee employee) throws BusinessException;

}
