package com.revature.reimbursement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.dbutil.PostgresConnection;
import com.revature.exception.BusinessException;
import com.revature.models.Reimbursement;
import com.revature.reimbursement.dao.ReimbursementDAO;

public class ReimbursementDAOImpl implements ReimbursementDAO {
	private Logger Log = Logger.getLogger(ReimbursementDAOImpl.class);
	
	@Override
	public int createReiumbursementRequest(Reimbursement rb) throws BusinessException {

		java.util.Date date = new Date();
		int c=0;
		try(Connection connection=PostgresConnection.getConnection()){
			System.out.println("inside dao create reim");
			String sql = "insert into company.reimbursements (amount, description, status, submitdate, type, user_id)"
					+ " values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setDouble(1, rb.getAmount());
			preparedStatement.setString(2, rb.getDescription());
			preparedStatement.setInt(3, 2);
			preparedStatement.setTimestamp(4, new java.sql.Timestamp(date.getTime()));
			preparedStatement.setString(5, rb.getType());
			preparedStatement.setInt(6, rb.getUser_id());
			
			
			c=preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			Log.info("Internal error");
			e.printStackTrace();
			throw new BusinessException("Internal error occured... Please contact SYSSADMIN");
		}
		return c;
	}

	@Override
	public List<Reimbursement> getAllPendingReiumbursementRequestsByEmployeeId(int user_id) throws BusinessException {
		List<Reimbursement> rbs = new ArrayList<>();
		System.out.println("inside dao " + user_id);
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select * from company.reimbursements where user_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user_id);

			ResultSet resultSet = preparedStatement.executeQuery();
//			System.out.println(resultSet.next());
			while (resultSet.next()) {
				if (resultSet.getInt("status") == 2) {
					Reimbursement rb = new Reimbursement();
					rb.setAmount(resultSet.getDouble("amount"));
					rb.setDescription(resultSet.getString("description"));
					Timestamp timeStampObj = resultSet.getTimestamp("submitdate");
					rb.setSubmitDate(timeStampObj.toString());
					rb.setStatus(resultSet.getInt("status"));
					rb.setManager_id(resultSet.getInt("manager_id"));
					rb.setReim_id(resultSet.getInt("reim_id"));
					rb.setDescription(resultSet.getString("type"));
				
					rbs.add(rb);
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error");
		}
		return rbs;
	}

	@Override
	public List<Reimbursement> getAllResolvedReiumbursementRequestsByEmployeeId(int user_id) throws BusinessException {
		List<Reimbursement> rbs = new ArrayList<>();
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select *  from company.reimbursements where user_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user_id);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt("status") == 1 || resultSet.getInt("status") == 0 ) {
					Reimbursement rb = new Reimbursement();
					rb.setAmount(resultSet.getDouble("amount"));
					rb.setDescription(resultSet.getString("description"));
					Timestamp timeStampObj = resultSet.getTimestamp("submitdate");
					rb.setSubmitDate(timeStampObj.toString());
					Timestamp timeStampObj1 = resultSet.getTimestamp("resolveddate");
					rb.setResolveDate(timeStampObj1.toString());
					rb.setStatus(resultSet.getInt("status"));
					rb.setType(resultSet.getString("type"));
					rb.setManager_id(resultSet.getInt("manager_id"));
					rb.setReim_id(resultSet.getInt("reim_id"));
				
					rbs.add(rb);
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error");
		}
		return rbs;
	}

	@Override
	public List<Reimbursement> getAllResolvedReiumbursementRequests() throws BusinessException {
		List<Reimbursement> rbs = new ArrayList<>();
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select *  from company.reimbursements ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt("status") == 1 || resultSet.getInt("status") == 0 ) {
					Reimbursement rb = new Reimbursement();
					rb.setAmount(resultSet.getDouble("amount"));
					rb.setDescription(resultSet.getString("description"));
//					rb.setSubmitDate(resultSet.getTimestamp("date"));
					rb.setStatus(resultSet.getInt("status"));
				
					rbs.add(rb);
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error");
		}
		return rbs;
	}

	@Override
	public List<Reimbursement> getAllPendingReiumbursementRequests() throws BusinessException {
		List<Reimbursement> rbs = new ArrayList<>();
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select *  from company.reimbursements ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt("status") == 2 ) {
					Reimbursement rb = new Reimbursement();
					rb.setAmount(resultSet.getDouble("amount"));
					rb.setDescription(resultSet.getString("description"));
//					rb.setSubmitDate(resultSet.getTimestamp("date"));
					rb.setStatus(resultSet.getInt("status"));
					rb.setReim_id(resultSet.getInt("reim_id"));
				
					rbs.add(rb);
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error");
		}
		return rbs;
	}

}
