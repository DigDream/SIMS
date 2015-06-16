package com.student.sb.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
	private static Properties props;
	private static InputStream in;

	public static void initialize() {
		props = new Properties();

		in = PropertiesUtils.class.getResourceAsStream("/.properties");

		try {
			props.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String readKey(String key) {
		initialize();
		return props.getProperty(key);
	}

	public static void writeKey(String key, String value) {
		initialize();
		props.setProperty(key, value);
	}

}
