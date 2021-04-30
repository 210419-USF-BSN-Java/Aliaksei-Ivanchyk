package com.revature.customer.dao;

import com.revature.model.Customer;

public interface CustomerCRUDDAO {
	public Customer registerCustomer(Customer customer);
	public int updateBalance(int balance);  
	
	

}
