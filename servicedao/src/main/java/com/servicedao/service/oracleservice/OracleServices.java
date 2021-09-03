package com.servicedao.service.oracleservice;

public class OracleServices {

	public OracleUserService getOracleUserService() {
		return new OracleUserService();
	}
	
	public OracleTaskService getOracleTaskService() {
		return new OracleTaskService();
	}


}
