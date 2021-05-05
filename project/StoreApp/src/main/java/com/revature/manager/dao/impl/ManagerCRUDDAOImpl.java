package com.revature.manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.dbutil.PostgresConnection;
import com.revature.exception.BusinessException;
import com.revature.main.menu.CustomerMenu;
import com.revature.manager.ManagerDAOCRUD;
import com.revature.model.Employee;
import com.revature.model.Rock;
import com.revature.model.SaleRecord;

public class ManagerCRUDDAOImpl implements ManagerDAOCRUD {
	private static Logger Log = Logger.getLogger(ManagerCRUDDAOImpl.class);

	@Override
	public int deleteEmployee(int employee_id) throws BusinessException {
		int c=0;
		try(Connection connection=PostgresConnection.getConnection()){
			String sql = "delete from store.employees where employee_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, employee_id);
			c=preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			Log.info("Internal error");
			throw new BusinessException("Internal error occured... Please contact SYSSADMIN");
		}
		return c;
	}

	@Override
	public int addEmployee(Employee employee) throws BusinessException {
		int c = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "insert into store.employees(firstname, lastname, username, password)" + " values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getUsername());
			preparedStatement.setString(4, employee.getPassword());

			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			Log.info("Internal error");
			throw new BusinessException("Internal error occured... Please contact SYSSADMIN");
		}
		return c;
	}

	@Override
	public List<SaleRecord> getSalesHistory() throws BusinessException {
		List<SaleRecord> salerecords = new ArrayList<>();
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select *  from store.salerecords";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				SaleRecord saleRecord = new SaleRecord();
				saleRecord.setCustomer_id(resultSet.getInt("customer_id"));
				saleRecord.setRock_id(resultSet.getInt("rock_id"));
				saleRecord.setSale_id(resultSet.getInt("sales_id"));
				saleRecord.setTimestamp(resultSet.getTimestamp("timestamp"));
				saleRecord.setSaleAmount(resultSet.getDouble("saleamount"));
				

				salerecords.add(saleRecord);

			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error");
		}
		return salerecords;
	}

	@Override
	public Employee logIn(String username, String password) throws BusinessException {
		Employee employee = null;

		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select * from store.managers where username=? and password=? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				employee = new Employee();
				employee.setUsername(resultSet.getString("username"));
				employee.setPassword(resultSet.getString("password"));
				employee.setFirstName(resultSet.getString("firstname"));
				employee.setLastName(resultSet.getString("lastname"));
				employee.setEmployee_type(resultSet.getInt("employee_type"));
				employee.setManager_id(resultSet.getInt("manager_id"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

			Log.warn("Internal Error");
			throw new BusinessException("Internal Error");
		}

		return employee;
	}

}
