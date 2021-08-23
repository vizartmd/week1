package com.servicedao.dao;

import java.sql.SQLException;

import com.servicedao.daointf.TaskDAO;
import com.servicedao.daointf.UserDAO;
import com.servicedao.service.TaskServiceInvoker;
import com.servicedao.service.UserServiceInvoker;

public class MySQLDAOFactory extends DAOFactory {
	UserDAO userDao;

	@Override
	public UserDAO getUserDAO() throws SQLException {
		return new UserServiceInvoker();
	}

	@Override
	public TaskDAO getTaskDAO() throws SQLException {
		return new TaskServiceInvoker();
	}

}
