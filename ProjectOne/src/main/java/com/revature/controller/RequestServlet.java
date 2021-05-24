package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.manager.dao.ManagerDAO;
import com.revature.manager.dao.impl.ManagerDAOImpl;

public class RequestServlet extends HttpServlet {
	ManagerDAO md = new ManagerDAOImpl();
	ObjectMapper mapper = new ObjectMapper();
	private int managerID;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
	}

}
