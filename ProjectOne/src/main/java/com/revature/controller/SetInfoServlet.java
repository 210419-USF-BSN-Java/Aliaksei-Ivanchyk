package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.employee.dao.EmployeeDAO;
import com.revature.employee.dao.impl.EmployeeDAOImpl;
import com.revature.exception.BusinessException;
import com.revature.models.Employee;

public class SetInfoServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	EmployeeDAO ed = new EmployeeDAOImpl();
	ObjectMapper mapper = new ObjectMapper();
	private int userID;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		System.out.println("inside set info servlet ");

		String token = request.getHeader("Authorization");

		if (token != null) {
			String[] userInfo = token.split(":");
			userID = Integer.parseInt(userInfo[0]);
		}
		
		Employee employee = null;
		try {
			employee = ed.getEmployeeById(userID);
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String employeejson = null;
		try {
			employeejson = mapper.writeValueAsString(employee);
			System.out.println(employeejson);
			response.setStatus(200);
			response.setHeader("userInfo", employeejson);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setStatus(404);
		}
		System.out.println(employeejson);
//		response.setStatus(200);
//		response.setHeader("userInfo", employeejson);
		
	}
	

}
