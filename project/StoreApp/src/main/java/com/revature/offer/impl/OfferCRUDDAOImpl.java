package com.revature.offer.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.dbutil.PostgresConnection;
import com.revature.exception.BusinessException;
import com.revature.main.menu.EmployeeMenu;
import com.revature.model.Offer;
import com.revature.model.Rock;
import com.revature.offer.OfferCRUDDAO;

public class OfferCRUDDAOImpl implements OfferCRUDDAO {
	private Logger Log = Logger.getLogger(OfferCRUDDAOImpl.class);


	@Override
	public int makeAnOffer(double amount, int customer_id, int rock_id) throws BusinessException {
		int c=0;
		try(Connection connection=PostgresConnection.getConnection()){
			String sql = "insert into store.offers(offeramount, customer_id, rock_id)"
					+ " values(?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setDouble(1, amount);
			preparedStatement.setInt(2, customer_id);
			preparedStatement.setInt(3, rock_id);
			
			c=preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			Log.info("Internal error");
			e.printStackTrace();
			throw new BusinessException("Internal error occured... Please contact SYSSADMIN");
		}
		return c;
	}

	@Override
	public Offer checkIfOfferAlreadyMade(int customer_id, int rock_id) throws BusinessException {
		Offer offer = null;
		try(Connection connection=PostgresConnection.getConnection()){
			String sql = "select * from store.offers where customer_id = ? and rock_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer_id);
			preparedStatement.setInt(2, rock_id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				if (resultSet.getInt("status") == 2) {
				offer = new Offer();
				
				offer.setCustomer_id(resultSet.getInt("customer_id"));
				offer.setOffer_id(resultSet.getInt("offer_id"));
				offer.setOfferAmount(resultSet.getDouble("offeramount"));
				offer.setRock_id(resultSet.getInt("rock_id"));
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			Log.warn("Internal error");
			throw new BusinessException("Internal error");
		}
		return offer;
	}

	@Override
	public int cancelOffer(int customer_id, int rock_id) throws BusinessException {
		int c=0;
		try(Connection connection=PostgresConnection.getConnection()){
			String sql = "delete from store.offers where rock_id=? and customer_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, rock_id);
			preparedStatement.setInt(2, customer_id);
			c=preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			Log.info("Internal error");
			throw new BusinessException("Internal error occured... Please contact SYSSADMIN");
		}
		return c;
	}

	@Override
	public List<Offer> getAllActiveOffers() throws BusinessException {
		List<Offer> offers = new ArrayList<>();
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select *  from store.offers";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt("status") == 2) {
					Offer offer = new Offer();
					offer.setCustomer_id(resultSet.getInt("customer_id"));
					offer.setOffer_id(resultSet.getInt("offer_id"));
					offer.setOfferAmount(resultSet.getDouble("offeramount"));
					offer.setStatus(resultSet.getInt("status"));
					offer.setRock_id(resultSet.getInt("rock_id"));


					offers.add(offer);
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error");
		}
		return offers;
	}


	@Override
	public int rejectOffer(int offer_id) throws BusinessException {
		int c=0;
		try(Connection connection=PostgresConnection.getConnection()){
			String sql = "delete from store.offers  where offer_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, offer_id);
			
			c=preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			Log.info("Internal error");
			throw new BusinessException("Internal error occured... Please contact SYSSADMIN");
		}
		return c;
	}

	@Override
	public int acceptOffer(double newBalance, Offer offer, Rock rock) throws BusinessException {
		java.util.Date date = new Date();
		Connection connection = null;
		Log.info(offer);
		int c = 0;
		int c1 = 0;
		int c2 = 0;
		int c3 = 0;
		int c4 = 0;
		int c5 = 0;
		try {
			connection=PostgresConnection.getConnection();
			String sql1 = "update store.customers set balance =? where customer_id=?"; // updates balance of customer
			String sql2 = "update store.offers set status=? where offer_id=?"; // updates offer to accepted
			String sql3 = "update store.rocks set status=? where rock_id=?"; // updates rock item to sold
			String sql4 = "update store.offers set status=? where rock_id=? and status=?"; // updates all other offers to rejected
			String sql5 =  "insert into store.salerecords(saleamount, timestamp, rock_id,customer_id)" 
					+ " values(?,?,?,?)"; // sales 
			String sql6 =  "insert into store.customer_rocks(type, weight,price,rock_id, customer_id)" 
					+ " values(?,?,?,?,?)"; // puts the purchased rock item into customer owned rock table
			connection.setAutoCommit(false);
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql1);
			preparedStatement.setDouble(1, newBalance);
			preparedStatement.setInt(2, offer.getCustomer_id());
			c = preparedStatement.executeUpdate();
			Log.info(c);
			
			preparedStatement=connection.prepareStatement(sql2);
			preparedStatement.setInt(1, 1);
			preparedStatement.setInt(2, offer.getOffer_id());
			c1 = preparedStatement.executeUpdate();
			Log.info(c1);
			
			preparedStatement=connection.prepareStatement(sql3);
			preparedStatement.setInt(1, 0);
			preparedStatement.setInt(2, offer.getRock_id());
			c2 = preparedStatement.executeUpdate();
			Log.info(c2);
			
			preparedStatement=connection.prepareStatement(sql4);
			preparedStatement.setInt(1, 0);
			preparedStatement.setInt(2, offer.getRock_id());
			preparedStatement.setInt(3, offer.getStatus());
			c3 = preparedStatement.executeUpdate();
			Log.info(c3);
			
			preparedStatement=connection.prepareStatement(sql5);
			preparedStatement.setDouble(1, offer.getOfferAmount());
			preparedStatement.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
			preparedStatement.setInt(3, offer.getRock_id());
			preparedStatement.setInt(4, offer.getCustomer_id());
			c4 = preparedStatement.executeUpdate();
			Log.info(c4);
			
			preparedStatement=connection.prepareStatement(sql6);
			preparedStatement.setString(1, rock.getType());
			preparedStatement.setDouble(2, rock.getWeight());
			preparedStatement.setDouble(3, offer.getOfferAmount());
			preparedStatement.setInt(4, offer.getRock_id());
			preparedStatement.setInt(5, offer.getCustomer_id());
			
			c5 = preparedStatement.executeUpdate();
			Log.info(c5);
			
			connection.commit();
			if (c >0  &&  c1 > 0 && c2 >0 && c3 >0 && c4 > 0 && c5 > 0) {
				Log.info("The transaction was successful");
			} 
		} catch (SQLException | ClassNotFoundException e) {
			Log.info("Internal error");
			e.printStackTrace();
			
			try {
				connection.rollback();
				Log.warn("Rolling back the query");
			} catch (SQLException e1) {

				throw new BusinessException("Internal error occured... with roll back");

			}
			throw new BusinessException("Internal error occured... Please contact SYSSADMIN");
		} 
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c3;
	}

}
