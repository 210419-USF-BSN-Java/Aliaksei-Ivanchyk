package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

public class ViewControllerServlet extends DefaultServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String path = request.getRequestURI().substring(request.getContextPath().length());
		
		if (path.startsWith("/static/") || path.equals("/") || path.equals("/index.html")) {
			super.doGet(request, response);
		} else {
			StringBuilder uriString = new StringBuilder(request.getRequestURI());
			uriString.replace(0, request.getContextPath().length() + 1, "");

			if (uriString.indexOf("/") != -1) {	
				
				request.setAttribute("path", uriString.substring(uriString.indexOf("/") + 1));
				uriString.replace(uriString.indexOf("/"), uriString.length(), "");
			}

			switch (uriString.toString()) {
			case "login":
//				getServletContext().getRequestDispatcher("/static/login.html").forward(request, response);
//				request.getRequestDispatcher("/static/login.html").forward(request, response);
				response.sendRedirect("static/login.html");

				break;
			case "employee":
//				getServletContext().getRequestDispatcher("/static/Employee.html").forward(request, response);
				response.sendRedirect("static/Employee.html");
//				request.getRequestDispatcher("/static/employee.html").include(request, response);
				break;
			case "submit":
//				getServletContext().getRequestDispatcher("/static/submit.html").forward(request, response);
				response.sendRedirect("static/submit.html");
				break;
			case "pendingreim":
//				getServletContext().getRequestDispatcher("/static/pendingreim.html").forward(request, response);
				response.sendRedirect("static/pendingreim.html");
				break;
			case "resolvedreim":
//				getServletContext().getRequestDispatcher("/static/resolvedreim.html").forward(request, response);
				response.sendRedirect("static/resolvedreim.html");
				break;
			case "manager":
//				getServletContext().getRequestDispatcher("/static/manager.html").forward(request, response);
				response.sendRedirect("static/manager.html");
				break;
			default:
				response.sendError(404, "Path not supported");
			}

		}

	}
}
