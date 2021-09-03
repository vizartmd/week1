package com.servicedao.command.usercommand;

import com.servicedao.command.Command;
import com.servicedao.daoimpl.MySQLUserDAOImpl;
import com.servicedao.domain.User;

public class UserGetByIdCommand implements Command {

	private MySQLUserDAOImpl mySQLUserDAO;
	private User user;
	int id;

	public UserGetByIdCommand(MySQLUserDAOImpl mySQLUserDAO, int id) {
		this.mySQLUserDAO = mySQLUserDAO;
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	@Override
	public void execute() {
		user = mySQLUserDAO.getById(id);
	}

}
