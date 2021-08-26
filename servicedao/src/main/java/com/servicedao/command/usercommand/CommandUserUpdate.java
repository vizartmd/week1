package com.servicedao.command.usercommand;

import com.servicedao.command.Command;
import com.servicedao.dao.MySQLUserDAO;
import com.servicedao.domain.User;

public class CommandUserUpdate implements Command {

	MySQLUserDAO mySQLUserDAO = new MySQLUserDAO();
	User user;
	int id;

	public CommandUserUpdate(User user, int id) {
		this.user = user;
		this.id = id;
	}

	@Override
	public void execute() {
		mySQLUserDAO.update(user, id);
	}

}
