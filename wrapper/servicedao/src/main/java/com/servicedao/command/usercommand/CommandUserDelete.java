package com.servicedao.command.usercommand;

import com.servicedao.command.Command;
import com.servicedao.dao.MySQLUserDAO;

public class CommandUserDelete implements Command {

	MySQLUserDAO mySQLUserDAO;
	int id;

	public CommandUserDelete(MySQLUserDAO mySQLUserDAO, int id) {
		this.mySQLUserDAO = mySQLUserDAO;
		this.id = id;
	}

	@Override
	public void execute() {
		mySQLUserDAO.deleteById(id);
	}

}
