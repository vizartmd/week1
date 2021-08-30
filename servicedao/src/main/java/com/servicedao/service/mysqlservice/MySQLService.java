package com.servicedao.service.mysqlservice;

import com.servicedao.service.ServiceIntf;

public class MySQLService implements ServiceIntf{

	public MySQLUserService getMySQLUserService() {
		return new MySQLUserService();
	}
	
	public MySQLTaskService getMySQLTaskService() {
		return new MySQLTaskService();
	}
	
}
