package com.servicedao.datasource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * This class provides an instance of "DataSource" Object with configuration
 * for connection to the database. "Singleton"-Pattern
 */
public class DataSource {

	private static DataSource instance = null;
	private static String filePathConnectionDB = "resources/db.properties";
	private String jdbcDriver;
	private String url;
	private String user;
	private String pass;
	
	private DataSource(){
		initDataSource();
	}
	
	public static DataSource getInstance(){
		if(instance == null)
			instance = new DataSource();
		return instance;
	}
	
	private void initDataSource(){
		Properties properties = getPropertiesConnection();
		
		setJdbcDriver(properties.getProperty("MYSQL_DB_DRIVER_CLASS"));
		setUrl(properties.getProperty("MYSQL_DB_URL"));
		setUser(properties.getProperty("MYSQL_DB_USERNAME"));
		setPass(properties.getProperty("MYSQL_DB_PASSWORD"));
	}

	private Properties getPropertiesConnection(){
		Properties properties = new Properties();
		
		try{
			properties.load(new FileInputStream(getFilePathConnectionDB()));
		}catch(IOException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		
		return properties;
	}
	
//	@SuppressWarnings("deprecation")
	public Connection getConnection(){
		Connection conn = null;
		
		try {
			Class.forName(getJdbcDriver()).newInstance();
			conn = DriverManager.getConnection(getUrl(), getUser(), getPass());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static String getFilePathConnectionDB() {
		return filePathConnectionDB;
	}

	public static void setFilePathConnectionDB(String filePathConnectionDB) {
		DataSource.filePathConnectionDB = filePathConnectionDB;
	}

	public String getJdbcDriver() {
		return jdbcDriver;
	}

	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}	
}

