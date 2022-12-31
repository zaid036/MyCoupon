package com.Coupon.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {

	public static Connection getConnection() {
		Connection con = null;

		try {
			Class.forName(DBinfo.driver);
			con = DriverManager.getConnection(DBinfo.url, DBinfo.username, DBinfo.password);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

}
