package com.revature.employee.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.dao.dbutil.PostgresConnection;
import com.revature.employee.dao.EmployeeSearchDAO;
import com.revature.exception.BusinessException;
import com.revature.main.menu.CustomerMenu;
import com.revature.model.Employee;

public class EmployeeSearchDAOImpl implements EmployeeSearchDAO {
	private static Logger Log = Logger.getLogger(CustomerMenu.class);

	@Override
	public Employee logIn(String username, String password) throws BusinessException {
		Employee employee = null;

		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select * from store.employees where username=? and password=? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				employee = new Employee();
				employee.setUsername(resultSet.getString("username"));
				employee.setPassword(resultSet.getString("password"));
				employee.setEmployee_id(resultSet.getInt("employee_id"));
				employee.setFirstName(resultSet.getString("firstname"));
				employee.setLastName(resultSet.getString("lastname"));
				employee.setEmployee_type(resultSet.getInt("employee_type"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

			Log.warn("Internal Error");
			throw new BusinessException("Internal Error");
		}

		return employee;
	}

}
