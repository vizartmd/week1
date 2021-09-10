package com.servicedao.service.mysqlservice;

public class MySQLServices {

	public MySQLUserService getMySQLUserService() {
		return new MySQLUserService();
	}
	
	public MySQLTaskService getMySQLTaskService() {
		return new MySQLTaskService();
	}
}
