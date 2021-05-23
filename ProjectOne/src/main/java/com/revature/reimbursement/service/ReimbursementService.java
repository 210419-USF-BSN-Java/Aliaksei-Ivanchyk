package com.revature.reimbursement.service;

import com.revature.exception.BusinessException;
import com.revature.models.Reimbursement;

public interface ReimbursementService {
	public int  createReiumbursementRequest(Reimbursement rb) throws BusinessException;

}
