package com.servicedao.dao;

import com.servicedao.dao.impl.OracleDAO;
import com.servicedao.dao.impl.mysqldao.MySQLDAO;
import com.servicedao.enums.DatabaseTypes;

public class DAOFactory {

	public static DAO getDAOFactory(DatabaseTypes database) {

		switch (database) {
		case MYSQL:
			return new MySQLDAO().getInstance();
		case ORACLE:
			return new OracleDAO().getInstance();
		}
		return null;
	}
}
