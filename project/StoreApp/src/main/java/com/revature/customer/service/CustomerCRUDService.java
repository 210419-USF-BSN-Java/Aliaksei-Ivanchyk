package com.revature.customer.service;

import com.revature.model.Customer;

public interface CustomerCRUDService {
	public Customer registerCustomer(Customer customer);
	public int updateBalance(int balance);  

}
