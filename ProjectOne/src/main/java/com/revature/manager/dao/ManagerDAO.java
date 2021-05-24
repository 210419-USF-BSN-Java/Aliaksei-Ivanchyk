package com.revature.manager.dao;

import java.util.List;

import com.revature.exception.BusinessException;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;

public interface ManagerDAO {
	public List<Employee> getAllEmployees() throws BusinessException;
	public List<Reimbursement> getReimByEmployee(int employee_id) throws BusinessException;
	public int updateReim(int reim_id, int status) throws BusinessException;
	

}
