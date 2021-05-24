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
import com.revature.models.Reimbursement;
import com.revature.reimbursement.dao.ReimbursementDAO;
import com.revature.reimbursement.dao.impl.ReimbursementDAOImpl;

public class ViewAllPendingReimServlet  extends HttpServlet {
	
	ReimbursementDAO rd = new ReimbursementDAOImpl();
	ObjectMapper mapper = new ObjectMapper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("inside view all pending servlet ");

//		String token = request.getHeader("Authorization");

		List<Reimbursement> reimList = null;
		try {
			reimList = rd.getAllPendingReiumbursementRequests();
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println(reimList.size());

		for (Reimbursement reimbursement : reimList) {
			System.out.println(reimbursement);
		}

		String reimJsonList = null;
		try {
			reimJsonList = mapper.writeValueAsString(reimList);

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		response.setStatus(200);
		response.setHeader("pList", reimJsonList);
	}

}
