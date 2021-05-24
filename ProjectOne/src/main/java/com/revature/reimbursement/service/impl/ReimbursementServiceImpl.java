package com.revature.reimbursement.service.impl;

import org.apache.log4j.Logger;

import com.revature.exception.BusinessException;
import com.revature.manager.dao.impl.ManagerDAOImpl;
import com.revature.models.Reimbursement;
import com.revature.reimbursement.dao.ReimbursementDAO;
import com.revature.reimbursement.dao.impl.ReimbursementDAOImpl;
import com.revature.reimbursement.service.ReimbursementService;

public class ReimbursementServiceImpl implements ReimbursementService {
	
	private  Logger Log = Logger.getLogger(ReimbursementServiceImpl.class);
	ReimbursementDAO rd = new ReimbursementDAOImpl();
	
	@Override
	public int createReiumbursementRequest(Reimbursement rb) throws BusinessException {
		int c = 0;
		if (rb.getAmount() < 0) {
		Log.warn("Entered amount cannot be zero");
		throw new BusinessException();
	}
	 c = rd.createReiumbursementRequest(rb);
	if (c == 0) {
		Log.warn("Something went wrong");
		throw new BusinessException();
	}
	return c;
	}

}
