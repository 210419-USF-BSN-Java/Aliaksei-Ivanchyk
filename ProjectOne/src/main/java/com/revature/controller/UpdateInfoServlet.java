package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.employee.dao.EmployeeDAO;
import com.revature.employee.dao.impl.EmployeeDAOImpl;
import com.revature.exception.BusinessException;
import com.revature.manager.dao.impl.ManagerDAOImpl;
import com.revature.models.Employee;

public class UpdateInfoServlet extends HttpServlet {
	private static Logger Log = Logger.getLogger(ManagerDAOImpl.class);

	EmployeeDAO ed = new EmployeeDAOImpl();
	ObjectMapper mapper = new ObjectMapper();
	private int userID;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Log.info("inside update info servlet ");

//		System.out.println("inside update info servlet ");

		String token = request.getHeader("Authorization");

		if (token != null) {
			String[] userInfo = token.split(":");
			userID = Integer.parseInt(userInfo[0]);
		}
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");

		Employee employee = new Employee();
		employee.setEmail(email);
		employee.setFirst_name(firstName);
		employee.setLast_name(lastName);
		employee.setEmployee_id(userID);

		System.out.println(employee);
		int c = 0;
		try {
			c = ed.updateEmployee(userID, firstName, lastName, email);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		if (c > 0) {
			response.setStatus(200);
		}
	}

}
