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
			
			System.out.println("inside view servlet");
			System.out.println(uriString.toString());

			switch (uriString.toString()) {
			case "login":
				response.sendRedirect("static/login.html");
				break;
			case "employee":
				response.sendRedirect("static/Employee.html");
				break;
			case "submit":
				response.sendRedirect("static/submit.html");
				break;
			case "pendingreim":
				response.sendRedirect("static/pendingreim.html");
				break;
			case "resolvedreim":
				response.sendRedirect("static/resolvedreim.html");
				break;
			case "updateinfo":
				response.sendRedirect("static/updateInfo.html");
				break;
			case "manager":
				response.sendRedirect("static/manager.html");
				break;
			case "viewallpendingreim":
				response.sendRedirect("static/viewallpendingreim.html");
				break;
			case "viewallresolvedreim":
				response.sendRedirect("static/viewallresolvedreim.html");
				break;
			case "reviewrequest":
				response.sendRedirect("static/reviewrequest.html");
				break;
			case "allemployees":
				response.sendRedirect("static/allemployees.html");
				break;
			case "reimbyemployee":
				response.sendRedirect("static/viewreimbyemployee.html");
				break;
			default:
				response.sendError(404, "Path not supported");
				break;
			}

		}

	}
}
