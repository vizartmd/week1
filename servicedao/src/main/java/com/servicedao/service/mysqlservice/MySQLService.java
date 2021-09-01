package com.servicedao.service.mysqlservice;

import com.servicedao.service.ServiceIntf;

/**
 * @return one of several classes that implements interface ServiceIntf
 */
public class MySQLService implements ServiceIntf{

	public MySQLUserService getMySQLUserService() {
		return new MySQLUserService();
	}
	
	public MySQLTaskService getMySQLTaskService() {
		return new MySQLTaskService();
	}
	
}
