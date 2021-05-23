package com.revature.main;

import java.util.Date;

import com.revature.exception.BusinessException;
import com.revature.models.Reimbursement;
import com.revature.reimbursement.dao.ReimbursementDAO;
import com.revature.reimbursement.dao.impl.ReimbursementDAOImpl;

public class Main {

	public static void main(String[] args) {
		ReimbursementDAO rd = new ReimbursementDAOImpl();
		java.util.Date date = new Date();
		
		Reimbursement rb = new Reimbursement();
		rb.setAmount(100);
		rb.setDescription("Dinner");
		int c = -5;
		try {
			c = rd.createReiumbursementRequest(rb);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(c);

	}

}
