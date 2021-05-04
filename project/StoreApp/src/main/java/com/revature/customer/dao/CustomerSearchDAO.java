package com.revature.customer.dao;

import com.revature.exception.BusinessException;
import com.revature.model.Customer;
import com.revature.model.User;

public interface CustomerSearchDAO {
	public Customer logIn(String username, String password) throws BusinessException;
	public double returnCustomerBalance(int customer_id) throws BusinessException;

}
