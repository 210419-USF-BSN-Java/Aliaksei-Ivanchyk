package com.revature.employee.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.dao.dbutil.PostgresConnection;
import com.revature.employee.dao.EmployeeDAO;
import com.revature.exception.BusinessException;
import com.revature.models.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static Logger Log = Logger.getLogger(EmployeeDAOImpl.class);

	@Override
	public Employee getEmployee(String username, String password) throws BusinessException {
		Employee employee = null;

		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select * from company.employee where username=? and password=? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				employee = new Employee();
				employee.setUsername(resultSet.getString("username"));
				employee.setPassword(resultSet.getString("password"));
				employee.setEmployee_id(resultSet.getInt("employee_id"));
				employee.setFirst_name(resultSet.getString("first_name"));
				employee.setLast_name(resultSet.getString("last_name"));
				employee.setEmail(resultSet.getString("email"));
				employee.setRole(resultSet.getInt("role"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

			Log.warn("Internal Error");
			throw new BusinessException("Internal Error");
		}

		return employee;
	}

}
