package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

public class FrontController extends DefaultServlet {
	
	/*
	 *  All of the requests are redirected to this controller
	 *  	- should handle requests for all end points and methods
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		 System.out.println("Request URI: " + request.getRequestURI());
		 System.out.println("Request ContextPath: " + request.getContextPath());
		 System.out.println("Request URL: " + request.getRequestURL());
		 
		 // Stripping the URL to point to the appropriate delegate
		 String path = request.getRequestURI().substring(request.getContextPath().length());
		 System.out.println(path);
		 	// - - / FrontControllerDemo/planets
		 
		 	// We want - - / planets
		 /*
		  * Based on the url, we want to map to request to the appropriate URL
		  */
		 if (path.startsWith("/static/") || path.equals("/") || path.equals("/index.html")) {
			 super.doGet(request, response);
		 } else {
//			 rh.proccessRequest(request, response);
			 // route the request to the appropriate delegate using the Request
		 }
	}
	// We want to make sure that all of the HTTP methods are routed to the same logic
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}

}
