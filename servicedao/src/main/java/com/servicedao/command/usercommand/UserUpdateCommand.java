package com.servicedao.command.usercommand;

import com.servicedao.command.Command;
import com.servicedao.daoimpl.MySQLUserDAOImpl;
import com.servicedao.domain.User;

public class UserUpdateCommand implements Command {

	private MySQLUserDAOImpl mySQLUserDAO;
	private User user;

	public UserUpdateCommand(MySQLUserDAOImpl mySQLUserDAO, String firstName, String lastName, String userName) {
		this.mySQLUserDAO = mySQLUserDAO;
		this.user = new User(firstName, lastName, userName);
	}

	@Override
	public void execute() {
		mySQLUserDAO.update(user);
	}

}
