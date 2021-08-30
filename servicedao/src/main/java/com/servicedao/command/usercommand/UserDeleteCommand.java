package com.servicedao.command.usercommand;

import com.servicedao.daoimpl.MySQLUserDAOImpl;

public class UserDeleteCommand {

	MySQLUserDAOImpl mySQLUserDAO = new MySQLUserDAOImpl();
	int id;

	public UserDeleteCommand(int id) {
		this.id = id;
	}

	public void execute() {
		mySQLUserDAO.deleteById(id);
	}

}
