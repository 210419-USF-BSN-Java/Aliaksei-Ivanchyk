package com.revature.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exception.BusinessException;
import com.revature.manager.dao.ManagerDAO;
import com.revature.manager.dao.impl.ManagerDAOImpl;
import com.revature.models.Reimbursement;

public class EmployeeHistoryServlet extends HttpServlet {
	ManagerDAO md = new ManagerDAOImpl();
	ObjectMapper mapper = new ObjectMapper();
	private int managerID;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String token = request.getHeader("Authorization");
		
		if(token != null) {
			String[] userInfo = token.split(":");
			managerID = Integer.parseInt(userInfo[0]);
		}
		
		String id = request.getParameter("employeeID");
		System.out.println(id);
		System.out.println(managerID);
		int employeeID = Integer.parseInt(request.getHeader("employeeID"));
		
		List<Reimbursement> requestlist = null;
		try {
			requestlist = md.getReimByEmployee(employeeID);
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String requestJson = null;
		try {
			requestJson = mapper.writeValueAsString(requestlist);
			response.setStatus(200);
			response.setHeader("requestList", requestJson);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			response.setStatus(404);
		}
		
	}

}
