package com.servicedao.command.usercommand;

import com.servicedao.command.Command;
import com.servicedao.daoimpl.MySQLUserDAOImpl;
import com.servicedao.domain.User;

public class UserUpdateCommand implements Command {

	MySQLUserDAOImpl mySQLUserDAO = new MySQLUserDAOImpl();
	User user;

	public UserUpdateCommand(User user) {
		this.user = user;
	}

	@Override
	public void execute() {
		mySQLUserDAO.update(user);
	}

}
