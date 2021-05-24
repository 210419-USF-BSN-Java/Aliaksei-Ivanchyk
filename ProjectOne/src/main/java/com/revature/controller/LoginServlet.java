package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.employee.service.EmployeeService;
import com.revature.employee.service.impl.EmployeeServiceImpl;
import com.revature.models.Employee;
import com.revature.reimbursement.service.impl.ReimbursementServiceImpl;

public class LoginServlet extends HttpServlet {
	EmployeeService es = new EmployeeServiceImpl();
	private  Logger Log = Logger.getLogger(ReimbursementServiceImpl.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Employee employee = null; 

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		employee = es.getEmployee(username, password);
		
		Log.info(password);
//		System.out.println(employee);
		
		if (employee != null) {
			String token = employee.getEmployee_id() + ":" + employee.getFirst_name() + ":" + employee.getRole();
			response.setStatus(200);
			response.setHeader("Authorization", token);
			
		} else {
			response.sendError(401);
		}
		
		
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	}

}
