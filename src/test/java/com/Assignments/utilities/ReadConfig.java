package com.Assignments.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is : " + e.getMessage());
		}
	}

	public String getChromePath() {
		String chromePath = prop.getProperty("chromepath");
		return chromePath;
	}
	public String getFirefoxPath() {
		String firefoxPath = prop.getProperty("firefoxpath");
		return firefoxPath;
	}
	public String getEdgePath() {
		String edgePath = prop.getProperty("edgepath");
		return edgePath;
	}
	public String getApplicationURL() {
		String url = prop.getProperty("baseURL");
		return url;
	}
	public String getUserName() {
		String userName = prop.getProperty("username");
		return userName;
	}
	public String getPassword() {
		String password = prop.getProperty("password");
		return password;
	}
	
	public String getEmail() {
		String email = prop.getProperty("email");
		return email;
	}
}
