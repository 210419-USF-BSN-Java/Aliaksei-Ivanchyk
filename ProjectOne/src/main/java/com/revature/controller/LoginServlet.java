package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.employee.service.EmployeeService;
import com.revature.employee.service.impl.EmployeeServiceImpl;
import com.revature.models.Employee;

public class LoginServlet extends HttpServlet {
	EmployeeService es = new EmployeeServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Employee employee = null; 

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		employee = es.getEmployee(username, password);
		

		System.out.println(employee);
		
		if (employee != null) {
			String token = employee.getEmployee_id() + ":" + employee.getFirst_name() + ":" + employee.getRole();
			response.setStatus(200);
			response.setHeader("Authorization", token);
			
		} else {
			response.sendError(401);
		}
		
		
		
//		if(!username.equals(null) && !password.equals(null)) {
//			boolean validateLogin = commonService.validateLogin(username, password);
//			if(validateLogin == true) {
//				
//				user = commonService.getUser(username, password);
//				
//				HttpSession session = request.getSession();
//				session.setAttribute("user", user);
//				//response.addCookie((Cookie) session);
//				if(user.getUser_role_id().getUser_role().equalsIgnoreCase("employee")) {
//					response.sendRedirect("employee-main-page.html");
//				}
//				else if(user.getUser_role_id().getUser_role().equalsIgnoreCase("manager")) {
//					// TODO
//					response.sendRedirect("");
//				}
//			}
//			else {			
//				PrintWriter out= response.getWriter();
//				out.println("<font color=red>Either user name or password is wrong.</font>");
//				RequestDispatcher rd = request.getRequestDispatcher("/login.html");
//				rd.include(request, response);
//			}
//
//		}else {
//			request.getRequestDispatcher("/login.html").forward(request, response);;
//		}
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	}

}
