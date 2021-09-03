package com.servicedao.command.usercommand;

import com.servicedao.command.Command;
import com.servicedao.daoimpl.MySQLUserDAOImpl;
import com.servicedao.domain.User;

public class UserGetByIdCommand implements Command {

	private MySQLUserDAOImpl mySQLUserDAO;
	private User user;
	int id;

	public UserGetByIdCommand(MySQLUserDAOImpl mySQLUserDAO, User user, int id) {
		this.mySQLUserDAO = mySQLUserDAO;
		this.user = user;
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
