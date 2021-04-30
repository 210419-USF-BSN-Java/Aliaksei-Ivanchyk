package com.revature.customer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;


import com.revature.customer.dao.CustomerSearchDAO;
import com.revature.dao.dbutil.PostgresConnection;
import com.revature.exception.BusinessException;
import com.revature.model.Customer;


public class CustomerSearchDAOImpl implements CustomerSearchDAO {
	private static Logger Log = Logger.getLogger(CustomerSearchDAOImpl.class);

	@Override
	public Customer logIn(String username, String password ) throws BusinessException {
		Customer customer = null;
		
		try(Connection connection = PostgresConnection.getConnection()){
			String sql = "select * from store.customers where usernames=? and passwords=? ";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				customer = new Customer();
				customer.setUsername(resultSet.getString("usernames"));
				customer.setPassword(resultSet.getString("passwords"));
				customer.setCustomer_id(resultSet.getInt("customer_id"));
				customer.setEmail(resultSet.getString("email"));
				customer.setFirstName(resultSet.getString("firstname"));
				customer.setLastName(resultSet.getString("lastname"));
				customer.setPhoneNumber(resultSet.getString("phonenumber"));
			}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();

				Log.warn("Internal Error");
				throw new BusinessException("Internal Error");
			}

			
			
		return customer;
	}

}
