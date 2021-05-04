package com.revature.manager;

import java.util.List;

import com.revature.exception.BusinessException;
import com.revature.model.Employee;
import com.revature.model.SaleRecord;

public interface ManagerDAOCRUD {
	
	public int deleteEmployee(int id) throws BusinessException;
	public int addEmployee(Employee employee) throws BusinessException;
	public List<SaleRecord> getSalesHistory() throws BusinessException;
	public Employee logIn(String username, String password) throws BusinessException;
}
