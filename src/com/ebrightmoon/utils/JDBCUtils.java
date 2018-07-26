package com.ebrightmoon.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {

	private static Properties props = new Properties();

	static {
		// ¶ÁÈ¡PropertiesÎÄ¼þ
		InputStream in = JDBCUtils.class.getResourceAsStream("/config.properties");

		try {
			props.load(in);
			Class.forName(props.getProperty("driverClassName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
	}
	/**
	 * 
	 * @param conn
	 * @param stmt
	 */
	public static void close(Connection conn, Statement stmt){
		try {
			if(stmt != null){stmt.close();}
			if(conn != null){conn.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs){
		try {
			if(rs != null){rs.close();}
			if(stmt != null){stmt.close();}
			if(conn != null){conn.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
