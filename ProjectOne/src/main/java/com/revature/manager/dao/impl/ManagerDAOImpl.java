package com.revature.manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.dbutil.PostgresConnection;
import com.revature.exception.BusinessException;
import com.revature.manager.dao.ManagerDAO;
import com.revature.models.Employee;

public class ManagerDAOImpl implements ManagerDAO {

	@Override
	public List<Employee> getAllEmployees() throws BusinessException {
		List<Employee> employees = new ArrayList<>();
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select *  from company.employee";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				Employee employee = new Employee();
				employee.setEmployee_id(resultSet.getInt("employee_id"));
				employee.setUsername(resultSet.getString("username"));
				employee.setPassword(resultSet.getString("password"));
				employee.setFirst_name(resultSet.getString("first_name"));
				employee.setLast_name(resultSet.getString("last_name"));
				employee.setEmail(resultSet.getString("email"));
				employee.setRole(1);
				

				employees.add(employee);

			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error");
		}
		return employees;
	}

	

}
