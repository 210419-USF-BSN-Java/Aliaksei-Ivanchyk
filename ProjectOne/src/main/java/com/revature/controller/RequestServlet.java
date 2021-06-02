package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exception.BusinessException;
import com.revature.manager.dao.ManagerDAO;
import com.revature.manager.dao.impl.ManagerDAOImpl;
import com.revature.models.Reimbursement;

public class RequestServlet extends HttpServlet {
	private static Logger Log = Logger.getLogger(ManagerDAOImpl.class);
	ManagerDAO md = new ManagerDAOImpl();
	ObjectMapper mapper = new ObjectMapper();
	private int managerID;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		Log.info("inside review request servlet");
//		System.out.println("inside submit servlet");
		String token = request.getHeader("Authorization");

		if (token != null) {
			String[] userInfo = token.split(":");
			managerID = Integer.parseInt(userInfo[0]);
		}
		Log.info("managerId = " + managerID);
		int reimId = Integer.parseInt(request.getParameter("reimid"));
		Log.info("reimId = " + reimId);
		
		int status = Integer.parseInt(request.getParameter("status"));
		Log.info("reimId = " + reimId);
		
//		= Double.parseDouble(request.getParameter("amount"));
		int c = 0;
		try {
			c = md.updateReim(reimId, status, managerID);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (c > 0) {
			response.setStatus(200);
		}
		
	}

}
