package com.pwioi.movie.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectivity {

	public static Connection getDBConnection() throws IOException, SQLException {
		
		InputStream fis = DBConnectivity.class
		        .getClassLoader()
		        .getResourceAsStream("dbconfig.properties");
		
		Properties props = new Properties();
		
		props.load(fis);
		
		
		String url = props.getProperty("dburl");
		String user = props.getProperty("dbuser");
		String password = props.getProperty("dbpassword");
		
		return DriverManager.getConnection(url,user,password);
	}
}
