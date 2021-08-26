package com.servicedao.command.usercommand;

import com.servicedao.command.Command;
import com.servicedao.dao.MySQLUserDAO;

public class CommandUserDelete implements Command {

	MySQLUserDAO mySQLUserDAO = new MySQLUserDAO();
	int id;

	public CommandUserDelete(int id) {
		this.id = id;
	}

	@Override
	public void execute() {
		mySQLUserDAO.deleteById(id);
	}

}
