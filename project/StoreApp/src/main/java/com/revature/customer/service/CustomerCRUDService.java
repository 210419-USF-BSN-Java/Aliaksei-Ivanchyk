package com.revature.customer.service;

import com.revature.exception.BusinessException;
import com.revature.model.Customer;

public interface CustomerCRUDService {
	public double updateBalance(double balance, int customer_id, double payment) throws BusinessException;
	public int makeAnOffer(double amount, int customer_id, int rock_id) throws BusinessException;
	public int registerNewCustomer(Customer customer) throws BusinessException;
	

}
