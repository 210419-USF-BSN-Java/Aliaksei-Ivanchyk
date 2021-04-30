package com.revature.manager;

import java.util.List;

import com.revature.model.Employee;
import com.revature.model.SaleRecord;

public interface ManagerDAOCRUD {
	
	public int deleteEmployee(int id);
	public int addEmployee(Employee employee);
	public List<SaleRecord> getSalesHistory();
}
