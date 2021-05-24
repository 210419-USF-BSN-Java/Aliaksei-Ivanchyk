package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.exception.BusinessException;
import com.revature.manager.dao.impl.ManagerDAOImpl;
import com.revature.models.Reimbursement;
import com.revature.reimbursement.service.ReimbursementService;
import com.revature.reimbursement.service.impl.ReimbursementServiceImpl;

public class SubmitServlet extends HttpServlet {
	private static Logger Log = Logger.getLogger(ManagerDAOImpl.class);

	private ReimbursementService rs = new ReimbursementServiceImpl();
	private int user_id;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Log.info("inside submit servlet");
//		System.out.println("inside submit servlet");
		String token = request.getHeader("Authorization");

		if (token != null) {
			String[] userInfo = token.split(":");
			user_id = Integer.parseInt(userInfo[0]);
		}

		double amount = Double.parseDouble(request.getParameter("amount"));
		String type = request.getParameter("type");
		String description = request.getParameter("description");

		Reimbursement reim = new Reimbursement();
		reim.setAmount(amount);
		reim.setDescription(description);
		reim.setType(type);
		reim.setUser_id(user_id);
		
		try {
			rs.createReiumbursementRequest(reim);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
