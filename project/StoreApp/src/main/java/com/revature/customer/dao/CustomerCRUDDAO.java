package com.revature.customer.dao;

import com.revature.exception.BusinessException;
import com.revature.model.Customer;
import com.revature.model.Offer;

public interface CustomerCRUDDAO {
	public Customer registerCustomer(Customer customer);
	public int updateBalance(double newbalance, int customer_id) throws BusinessException;
	public int makeAnOffer(double amount, int customer_id, int rock_id) throws BusinessException;
	public Offer getOffer(int customer_id, int rock_id) throws BusinessException;
	public int cancelOffer(int customer_id, int rock_id) throws BusinessException;
	
	
	

}
