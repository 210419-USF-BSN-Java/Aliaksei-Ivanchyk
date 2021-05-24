package com.revature.manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.dbutil.PostgresConnection;
import com.revature.exception.BusinessException;
import com.revature.manager.dao.ManagerDAO;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;

public class ManagerDAOImpl implements ManagerDAO {

	@Override
	public List<Employee> getAllEmployees() throws BusinessException {
		List<Employee> employees = new ArrayList<>();
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select *  from company.employee";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt("role") == 1){

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

			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error");
		}
		return employees;
	}

	@Override
	public List<Reimbursement> getReimByEmployee(int employee_id) throws BusinessException {
		List<Reimbursement> rbs = new ArrayList<>();
		System.out.println("inside dao " + employee_id);
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select * from company.reimbursements where user_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employee_id);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
					Reimbursement rb = new Reimbursement();
					rb.setAmount(resultSet.getDouble("amount"));
					rb.setDescription(resultSet.getString("description"));
					Timestamp timeStampObj = resultSet.getTimestamp("submitdate");
					rb.setSubmitDate(timeStampObj.toString());
					rb.setStatus(resultSet.getInt("status"));
					rb.setManager_id(resultSet.getInt("manager_id"));
					rb.setReim_id(resultSet.getInt("reim_id"));
					rb.setDescription(resultSet.getString("type"));
					Timestamp timeStampObj1 = resultSet.getTimestamp("resolveddate");
					if (timeStampObj1 != null) {
					rb.setResolveDate(timeStampObj1.toString());
					}
					rbs.add(rb);
				
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error");
		}
		return rbs;
	}

	@Override
	public int updateReim(int reim_id, int status) throws BusinessException {
		int c = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "update company.reimbursements set status=? where reim_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, status);
			preparedStatement.setInt(2, reim_id);
			c = preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Internal error occured... Please contact SYSSADMIN");
		}

//		Log.info(c);
		return c;
	}

	

}
