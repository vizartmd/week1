package com.servicedao.dao;

import java.sql.SQLException;

import com.servicedao.daointf.TaskDAO;
import com.servicedao.daointf.UserDAO;

public class OracleDAOFactory extends DAOFactory {

	@Override
	public UserDAO getUserDAO() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskDAO getTaskDAO() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
