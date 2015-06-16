package com.student.sb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlUtils {
	static Connection conn;
	static String driver = "com.mysql.jdbc.Driver";

	public static void setConnection(String url, String user, String password) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
		}
	}

	public static boolean isConnectSql() {
		// 首先读取配置
		System.out.println(PropertiesUtils.readKey("DB_ADD")
				+ PropertiesUtils.readKey("DB_PORT")
				+ PropertiesUtils.readKey("DB_USER")
				+ PropertiesUtils.readKey("DB_PASSWORD")
				+ PropertiesUtils.readKey("DB_TABLE"));
		// 连接测试
		String url = "jdbc:mysql://" + PropertiesUtils.readKey("DB_ADD") + ":"
				+ PropertiesUtils.readKey("DB_PORT") + "/"
				+ PropertiesUtils.readKey("DB_TABLE");
		try {

			setConnection(url, PropertiesUtils.readKey("DB_USER"),
					PropertiesUtils.readKey("DB_PASSWORD"));

			if (conn.isValid(500))
				return true;
			else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
			return false;
		}
	}

	public void execSql(String sql) {

	}

}
