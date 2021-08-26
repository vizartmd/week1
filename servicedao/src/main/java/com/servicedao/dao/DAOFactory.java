package com.servicedao.dao;

/**
 * This class provides a factory from many different types of DAOFactory
 * "Abstract Factory"-Pattern
 */
public abstract class DAOFactory {

	public static DAOFactory getDAOFactory(Database whichFactory) {

		switch (whichFactory) {
		case MYSQL:
			return new MySQLDAOFactory();
		case ORACLE:
			return new OracleDAOFactory();
		}
		return null;

	}

}
