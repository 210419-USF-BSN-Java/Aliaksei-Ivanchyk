package com.revature.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {

	private static Connection connection;

	private PostgresConnection() {
		// TODO Auto-generated constructor stub
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

			Class.forName("org.postgresql.Driver");
			String dbName = "postgres";
			String password = "password";
			String RDS_HOSTNAME = "database-1.cumqiq8zmh1g.us-east-2.rds.amazonaws.com";
			String RDS_USERNAME = "postgres";
			String jdbcURL = "jdbc:postgresql://" + RDS_HOSTNAME + ":" + 5432 + "/" + dbName 
					+ "?user=" + RDS_USERNAME + "&password=" + password;
			
//			String url = "jdbc:postgresql://localhost:5432/postgres";
//			String username = "postgres";
//			String password = "password";
			if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(jdbcURL);
			}
			return connection;

	}
}
