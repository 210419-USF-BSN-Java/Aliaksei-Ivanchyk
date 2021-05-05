package com.revature.customer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.customer.dao.CustomerCRUDDAO;
import com.revature.dao.dbutil.PostgresConnection;
import com.revature.exception.BusinessException;
import com.revature.main.menu.CustomerMenu;
import com.revature.model.Customer;
import com.revature.model.Offer;
import com.revature.model.Rock;

public class CustomerCRUDDAOImpl implements CustomerCRUDDAO {
	private static Logger Log = Logger.getLogger(CustomerCRUDDAOImpl.class);

	@Override
	public int updateBalance(double newbalance, int customer_id) throws BusinessException {
		int c = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "update store.customers set balance =? where customer_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, newbalance);
			preparedStatement.setInt(2, customer_id);
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			Log.info(e);
			throw new BusinessException("Internal error occured... Please contact SYSSADMIN");
		}
		Log.info(c);
		return c;
	}

	@Override
	public Offer getOffer(int customer_id, int rock_id) throws BusinessException {
		Offer offer = null;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select * from store.offers where customer_id = ? and rock_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer_id);
			preparedStatement.setInt(2, rock_id);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				if (resultSet.getInt("status") == 2) {
					offer = new Offer();

					offer.setCustomer_id(resultSet.getInt("customer_id"));
					offer.setOffer_id(resultSet.getInt("offer_id"));
					offer.setOfferAmount(resultSet.getDouble("offeramount"));
					offer.setRock_id(resultSet.getInt("rock_id"));
					offer.setStatus(resultSet.getInt("status"));

				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			Log.warn("Internal error");
			throw new BusinessException("Internal error");
		}
		return offer;
	}

	@Override
	public int makeAnOffer(double amount, int customer_id, int rock_id) throws BusinessException {
		int c = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "insert into store.offers(offeramount, customer_id, rock_id)" + " values(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, amount);
			preparedStatement.setInt(2, customer_id);
			preparedStatement.setInt(3, rock_id);

			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			Log.info("Internal error");
			e.printStackTrace();
			throw new BusinessException("Internal error occured... Please contact SYSSADMIN");
		}
		return c;
	}

	@Override
	public int cancelOffer(int customer_id, int rock_id) throws BusinessException {
		int c = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "delete from store.offers where rock_id=? and customer_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, rock_id);
			preparedStatement.setInt(2, customer_id);
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			Log.info("Internal error");
			throw new BusinessException("Internal error occured... Please contact SYSSADMIN");
		}
		return c;
	}

	@Override
	public int registerNewCustomer(Customer customer) throws BusinessException {
		int c = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "insert into store.customers(firstname, lastname, usernames, passwords, email, phonenumber, balance)"
					+ " values(?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getUsername());
			preparedStatement.setString(4, customer.getPassword());
			preparedStatement.setString(5, customer.getEmail());
			preparedStatement.setString(6, customer.getPhoneNumber());
			preparedStatement.setDouble(7, 0);

			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			Log.info("Internal error");
			throw new BusinessException("Internal error occured... Please contact SYSSADMIN");
		}
		return c;
	}

}
