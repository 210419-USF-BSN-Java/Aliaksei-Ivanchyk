package com.revature.reimbursement.dao;

import java.util.List;

import com.revature.exception.BusinessException;
import com.revature.models.Reimbursement;

public interface ReimbursementDAO {
	public int  createReiumbursementRequest(Reimbursement rb) throws BusinessException;
	public List<Reimbursement>  getAllPendingReiumbursementRequestsByEmployeeId(int employee_id) throws BusinessException;
	public List<Reimbursement>  getAllResolvedReiumbursementRequestsByEmployeeId(int employee_id) throws BusinessException;
	public List<Reimbursement>  getAllResolvedReiumbursementRequests() throws BusinessException;
	public List<Reimbursement>  getAllPendingReiumbursementRequests() throws BusinessException;


	

}
