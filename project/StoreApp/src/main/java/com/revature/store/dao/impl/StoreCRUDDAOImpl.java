package com.revature.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.dbutil.PostgresConnection;
import com.revature.exception.BusinessException;
import com.revature.model.Rock;
import com.revature.store.StoreCRUDDAO;

public class StoreCRUDDAOImpl implements StoreCRUDDAO {
	private static Logger Log = Logger.getLogger(StoreCRUDDAOImpl.class);

	@Override
	public List<Rock> getAllAvailableRock() throws BusinessException {
		List<Rock> rocks = new ArrayList<>();
		try(Connection connection=PostgresConnection.getConnection()){
			String sql = "select *  from store.rocks";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				if (resultSet.getInt("status") == 1) {
				Rock rock=new Rock();
				rock.setPrice(resultSet.getDouble("price"));
				rock.setWeight(resultSet.getDouble("weight"));
				rock.setRock_id(resultSet.getInt("rock_id"));
				rock.setStatus(resultSet.getInt("status"));
				rock.setType(resultSet.getString("type"));

				rocks.add(rock);
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error");
		}
		return rocks;
	}

	@Override
	public List<Rock> getRockItemsOwnedByCustomerID(int customer_id) throws BusinessException {
		List<Rock> rocks=new ArrayList<>();
		try(Connection connection=PostgresConnection.getConnection()){
			String sql = "select * from store.customer_rocks where customer_id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer_id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Rock rock=new Rock();
				
				rock.setPrice(resultSet.getDouble("price"));
				rock.setWeight(resultSet.getDouble("weight"));
				rock.setRock_id(resultSet.getInt("rock_id"));
				rock.setType(resultSet.getString("type"));
				rock.setCustomer_id(resultSet.getInt("customer_id"));
				
				rocks.add(rock);
			}
			if(rocks.size()==0) {
				throw new BusinessException("No rock speciments found for the current customer ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			Log.warn("Internal error");
			throw new BusinessException("Internal error");
		}
		return rocks;
	}

	@Override
	public int removeRockItem(int rock_id) throws BusinessException {
		int c=0;
		try(Connection connection=PostgresConnection.getConnection()){
			String sql = "delete from store.rocks where rock_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, rock_id);
			c=preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			Log.info("Internal error");
			throw new BusinessException("Internal error occured... Please contact SYSSADMIN");
		}
		return c;
	}

	@Override
	public int updateRockItem(Rock rock) throws BusinessException {
		int c=0;
		try(Connection connection=PostgresConnection.getConnection()){
			String sql = "update store.rocks set price =?, type=?, status=?, weight=? where rock_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setDouble(1, rock.getPrice());
			preparedStatement.setString(2, rock.getType());
			preparedStatement.setInt(3, rock.getStatus());
			preparedStatement.setDouble(4, rock.getWeight());
			preparedStatement.setInt(5, rock.getRock_id());
			c=preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			Log.info(e); 
			throw new BusinessException("Internal error occured... Please contact SYSSADMIN");
		}
		
		Log.info(c);
		return c;
	}

	@Override
	public int addRockItem(Rock rock) throws BusinessException {
		int c=0;
		try(Connection connection=PostgresConnection.getConnection()){
			String sql = "insert into store.rocks(type, weight, price, status)"
					+ " values(?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, rock.getType());
			preparedStatement.setDouble(2, rock.getWeight());
			preparedStatement.setDouble(3, rock.getPrice());
			preparedStatement.setInt(4, 1);
			
			c=preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			Log.info("Internal error");
			throw new BusinessException("Internal error occured... Please contact SYSSADMIN");
		}
		return c;
	}
	

}
