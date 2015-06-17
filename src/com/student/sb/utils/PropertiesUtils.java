package com.student.sb.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesUtils {
	private static Properties props;
	private static InputStream in;
	static String filePath = "/.properties";

	public static void initialize() {
		if (props == null) {
			props = new Properties();
		}
	}

	public static String readKey(String key) {
		initialize();
		in = PropertiesUtils.class.getResourceAsStream(filePath);

		try {
			props.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props.getProperty(key);
	}

	public static void writeConn(String add, String Port, String User,
			String Pass) {
		// 输出流
		initialize();
		try {
			in = PropertiesUtils.class.getResourceAsStream(filePath);
			props.load(in);
			OutputStream fos = new FileOutputStream("src/.properties");
			props.setProperty("DB_ADD", add);
			props.setProperty("DB_PORT", Port);
			props.setProperty("DB_USER", User);
			props.setProperty("DB_PASSWORD", Pass);
			props.store(fos, "Update" + add + "is" + Port + User);
			in.close();
			fos.close();
			props.clear();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
