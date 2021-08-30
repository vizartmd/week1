package com.servicedao.service;

import com.servicedao.enums.DatabaseTypes;
import com.servicedao.service.mysqlservice.MySQLService;
import com.servicedao.service.oracleservice.OracleService;

public abstract class ServiceFactory {

	public static final int MYSQL = 1;
	public static final int ORACLE = 2;

	public static ServiceIntf getServiceFactory(DatabaseTypes type) {

		switch (type) {
		case MYSQL:
			return new MySQLService();
		case ORACLE:
			return new OracleService();
		}
		return null;

	}

}
