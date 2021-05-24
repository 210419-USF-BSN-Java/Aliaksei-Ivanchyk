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
import com.revature.models.Employee;

public class ViewEmployeesServlet extends HttpServlet {
	ManagerDAO md = new ManagerDAOImpl();
	ObjectMapper mapper = new ObjectMapper();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		System.out.println("inside employee info servlet ");
		List<Employee> employeeList = null;
		
		try {
			employeeList = md.getAllEmployees();
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String allEmployee = null;
		try {
			allEmployee = mapper.writeValueAsString(employeeList);
			System.out.println(allEmployee);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(allEmployee);
		response.setStatus(200);
		response.setHeader("employeeList", allEmployee);//parsed user object

	}
}
