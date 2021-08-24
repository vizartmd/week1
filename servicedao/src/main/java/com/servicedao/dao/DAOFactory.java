package com.servicedao.dao;

import java.sql.SQLException;

import com.servicedao.daointf.TaskDAO;
import com.servicedao.daointf.UserDAO;

/**
 * This class provides a factory from many different types of DAOFactory
 * "Abstract Factory"-Pattern
 */
public abstract class DAOFactory {

	public static final int MYSQL = 1;
	public static final int ORACLE = 2;

	public abstract UserDAO getUserDAO() throws SQLException;

	public abstract TaskDAO getTaskDAO() throws SQLException;

	public static DAOFactory getDAOFactory(int whichFactory) {

		switch (whichFactory) {
		case MYSQL:
			return new MySQLDAOFactory();
		case ORACLE:
			return new OracleDAOFactory();
		}
		return null;

	}

}
