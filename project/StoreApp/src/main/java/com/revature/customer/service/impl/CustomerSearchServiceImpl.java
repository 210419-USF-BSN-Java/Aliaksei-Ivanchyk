package com.revature.customer.service.impl;



import org.apache.log4j.Logger;

import com.revature.customer.dao.CustomerSearchDAO;
import com.revature.customer.dao.impl.CustomerSearchDAOImpl;
import com.revature.customer.service.CustomerSearchService;
import com.revature.exception.BusinessException;
import com.revature.main.menu.CustomerMenu;
import com.revature.model.Customer;
import com.revature.model.User;
import com.revature.validations.CustomerValidations;

public class CustomerSearchServiceImpl implements CustomerSearchService {
	CustomerSearchDAO csd = new CustomerSearchDAOImpl();
	private static Logger Log = Logger.getLogger(CustomerSearchServiceImpl.class);

	@Override
	public Customer logIn(String username, String password) throws BusinessException {
		Customer customer = null;
		if (CustomerValidations.isValidPassword(password) && CustomerValidations.isValidUserName(username)) {
			customer = csd.logIn(username, password);
			if (customer != null) {
				Log.info("Loggin succesful");	
				} else {
					Log.info("Unable to retrieve the customer from database");
					throw new BusinessException("Entered User name and password are invalid format");
				}
			
		} else {
			throw new BusinessException("Entered User name and password are invalid format");
		}
		return customer;
	}





}
