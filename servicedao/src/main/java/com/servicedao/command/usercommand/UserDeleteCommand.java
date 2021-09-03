package com.servicedao.command.usercommand;

import com.servicedao.daoimpl.MySQLUserDAOImpl;

public class UserDeleteCommand {

	private MySQLUserDAOImpl mySQLUserDAO;
	private int id;

	public UserDeleteCommand(MySQLUserDAOImpl mySQLUserDAO, int id) {
		this.mySQLUserDAO = mySQLUserDAO;
		this.id = id;
	}

	public void execute() {
		mySQLUserDAO.deleteById(id);
	}

}
