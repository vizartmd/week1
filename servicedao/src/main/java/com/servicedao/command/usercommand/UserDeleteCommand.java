package com.servicedao.command.usercommand;

import com.servicedao.command.Command;
import com.servicedao.daoimpl.MySQLUserDAOImpl;

public class UserDeleteCommand implements Command {

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
