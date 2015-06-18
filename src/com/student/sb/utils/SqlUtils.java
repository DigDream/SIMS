package com.student.sb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlUtils {
	static Connection conn;
	static String driver = "com.mysql.jdbc.Driver";

	public static void setConnection(String url, String user, String password)
			throws SQLException {
		try {
			Class.forName(driver);
			System.out.println(url);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void isConnectSql() throws SQLException {
		// 首先读取配置
		// 连接测试
		String url = "jdbc:mysql://" + PropertiesUtils.readKey("DB_ADD") + ":"
				+ PropertiesUtils.readKey("DB_PORT") + "/"
				+ PropertiesUtils.readKey("DB_TABLE");
		setConnection(url, PropertiesUtils.readKey("DB_USER"),
				PropertiesUtils.readKey("DB_PASSWORD"));
	}

	public static int execSql(String sql) {
		try {
			Statement stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static String execResultSetSql(String sql) {

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sql;
	}

	public static ResultSet execReturnRS(String sql) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				return rs;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
