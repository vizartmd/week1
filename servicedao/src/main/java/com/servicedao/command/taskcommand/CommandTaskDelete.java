package com.servicedao.command.taskcommand;

import com.servicedao.command.Command;
import com.servicedao.dao.MySQLTaskDAO;

public class CommandTaskDelete implements Command {
	
	MySQLTaskDAO mySQLTaskDAO = new MySQLTaskDAO();
	int id;

	public CommandTaskDelete(int id) {
		this.id = id;
	}

	@Override
	public void execute() {
		mySQLTaskDAO.deleteById(id);
	}

}
