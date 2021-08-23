package com.servicedao.command.usercommand;

import com.servicedao.command.Command;
import com.servicedao.dao.MySQLUserDAO;
import com.servicedao.domain.User;

public class CommandUserUpdate implements Command {

	MySQLUserDAO mySQLUserDAO;
	User user;
	int id;

	public CommandUserUpdate(MySQLUserDAO mySQLUserDAO, User user, int id) {
		super();
		this.mySQLUserDAO = mySQLUserDAO;
		this.user = user;
		this.id = id;
	}

	@Override
	public void execute() {
		mySQLUserDAO.update(user, id);
	}

}
