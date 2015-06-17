package com.student.sb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

	public void execSql(String sql) {

	}

	public static void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
