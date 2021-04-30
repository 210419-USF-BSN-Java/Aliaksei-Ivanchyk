package com.revature.customer.service;

import com.revature.exception.BusinessException;
import com.revature.model.Customer;
import com.revature.model.User;

public interface CustomerSearchService {
	
	public Customer logIn(String username, String password) throws BusinessException;

}
