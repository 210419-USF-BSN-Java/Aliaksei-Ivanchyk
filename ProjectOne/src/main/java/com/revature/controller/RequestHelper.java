package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestHelper {

	/*
	 * route the quest to the appropriate delegate
	 */
	public void proccessRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String path = request.getRequestURI().substring(request.getContextPath().length());
		
		switch (path) {
		
		case "/moons":
			/*
			 * methods: - POST - Create a moon
			 * 			- Get - Get all moons
			 * 
			 * Bonus: how to handle more specific requests ie: moons/{id} to retrieve a moon for an id
			 */
			break;
		case "/planets":
//			pd.process(request, response);
			/*
			 * methods:
			 * 			- Get - Get all planets
			 * 
			 * 
			 */
//			pd.process(request, response);
			break;
			
			default:
				response.sendError(404, "Path not supported");
		}
	}

}
