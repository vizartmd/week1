package com.servicedao.datasource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.servicedao.dao.impl.MySQLTaskDAOImpl;

/**
 * This class provides an instance of "DataSource" Object with configuration for
 * connection to the database. "Singleton"-Pattern
 */
public class DataSource {

	static Logger log = Logger.getLogger(MySQLTaskDAOImpl.class.getName());
	private static DataSource instance = null;
	private String jdbcDriver;
	private String url;
	private String user;
	private String pass;

	private DataSource() {
		initDataSource();
	}

	public static DataSource getInstance() {
		if (instance == null)
			instance = new DataSource();
		return instance;
	}

	private void initDataSource() {
		Properties properties = getPropertiesConnection();
		setJdbcDriver(properties.getProperty("MYSQL_DB_DRIVER_CLASS"));
		setUrl(properties.getProperty("MYSQL_DB_URL"));
		setUser(properties.getProperty("MYSQL_DB_USERNAME"));
		setPass(properties.getProperty("MYSQL_DB_PASSWORD"));
	}

	private Properties getPropertiesConnection() {
		Properties properties = new Properties();

		try {
			properties.load(new FileInputStream("resources/db.properties"));
		} catch (IOException e) {
			log.info("IOException in getPropertiesConnection() method: " + e);
		} catch (NullPointerException e) {
			log.info("NullPointerException in getPropertiesConnection() method: " + e);
		}
		return properties;
	}

	public Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName(getJdbcDriver()).getDeclaredConstructor().newInstance();
			conn = DriverManager.getConnection(getUrl(), getUser(), getPass());
		} catch (Exception e) {
			log.warn("Connection was not created", e);
		}
		return conn;
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
