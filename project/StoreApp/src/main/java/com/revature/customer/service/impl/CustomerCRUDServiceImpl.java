package com.revature.customer.service.impl;

import org.apache.log4j.Logger;

import com.revature.customer.dao.CustomerCRUDDAO;
import com.revature.customer.dao.impl.CustomerCRUDDAOImpl;
import com.revature.customer.service.CustomerCRUDService;
import com.revature.exception.BusinessException;
import com.revature.model.Customer;


public class CustomerCRUDServiceImpl implements CustomerCRUDService {
	private static Logger Log = Logger.getLogger(CustomerCRUDServiceImpl.class);
	CustomerCRUDDAO ccd = new CustomerCRUDDAOImpl();
	@Override
	public Customer registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public double updateBalance(double balance, int customer_id, double payment) throws BusinessException {
		int c = 0;
		if (payment < 0) {
			Log.info("Payment cannot be negative");
			throw new BusinessException();
		} else if (balance - payment < 0) {
			Log.info("Payment cannot exceed the balance");
			throw new BusinessException();
		} else {
			balance = balance - payment;
			ccd.updateBalance(balance, customer_id);
		}
		
		return balance;
	}


	@Override
	public int makeAnOffer(double amount, int customer_id, int rock_id) throws BusinessException {
		if (amount < 0) {
			Log.warn("Entered amount cannot be zero");
			throw new BusinessException();
		}
		
		int c = ccd.makeAnOffer(amount, customer_id, rock_id);
		if (c == 0) {
			Log.warn("Something went wrong on adding the offer");
			throw new BusinessException();
		}
		return c;
	}

}
