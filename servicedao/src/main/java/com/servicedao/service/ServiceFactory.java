package com.servicedao.service;

import com.servicedao.enums.DatabaseTypes;
import com.servicedao.service.mysqlservice.MySQLServices;
import com.servicedao.service.oracleservice.OracleServices;

public abstract class ServiceFactory {
	
	@SuppressWarnings("unchecked")
	public static <T> ServiceIntf<T> getServiceFactory(DatabaseTypes type) {

		switch (type) {
		case MYSQL:
			return (ServiceIntf<T>) new MySQLServices();
		case ORACLE:
			return (ServiceIntf<T>) new OracleServices();
		}
		return null;
	}
}
