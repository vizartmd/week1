package com.servicedao.command.taskcommand;

import com.servicedao.command.Command;
import com.servicedao.dao.MySQLTaskDAO;

public class CommandTaskDelete implements Command {
	
	MySQLTaskDAO mySQLTaskDAO;
	int id;

	public CommandTaskDelete(MySQLTaskDAO mySQLTaskDAO, int id) {
		this.mySQLTaskDAO = mySQLTaskDAO;
		this.id = id;
	}

	@Override
	public void execute() {
		mySQLTaskDAO.deleteById(id);
	}

}
