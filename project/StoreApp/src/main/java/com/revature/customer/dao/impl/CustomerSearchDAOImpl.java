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
import com.revature.model.Offer;


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
				customer.setBalance(resultSet.getDouble("balance"));
			}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();

				Log.warn("Internal Error");
				throw new BusinessException("Internal Error");
			}

			
			
		return customer;
	}

	@Override
	public double returnCustomerBalance(int customer_id) throws BusinessException {
		double balance = 0;
		try(Connection connection=PostgresConnection.getConnection()){
			String sql = "select balance from store.customers where customer_id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer_id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				balance = resultSet.getDouble("balance");
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			Log.warn("Internal error");
			throw new BusinessException("Internal error");
		}
		return balance;
	}

}
