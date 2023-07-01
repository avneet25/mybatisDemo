package com.customer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private static Connection connection = null;
	
	public static Connection getConnection() throws ClassNotFoundException {
		if(connection != null) {
			return connection;
		} else {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@//on34c03183963.cihs.ad.gov.on.ca:1521/test_pdb.cihs.ad.gov.on.ca";
			String username = "avneet";
			String password = "avneet";
			Class.forName(driver);
			try {
				connection = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}
	}
}
