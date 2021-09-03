package com.servicedao.service.mysqlservice;

/**
 * @return one of several classes that implements interface ServiceIntf
 */
public class MySQLServices {

	public MySQLUserService getMySQLUserService() {
		return new MySQLUserService();
	}
	
	public MySQLTaskService getMySQLTaskService() {
		return new MySQLTaskService();
	}
}
