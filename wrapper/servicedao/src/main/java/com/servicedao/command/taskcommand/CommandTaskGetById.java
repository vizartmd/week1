package com.servicedao.command.taskcommand;

import com.servicedao.command.Command;
import com.servicedao.dao.MySQLTaskDAO;
import com.servicedao.domain.Task;

public class CommandTaskGetById implements Command {

	MySQLTaskDAO mySQLTaskDAO;
	Task task;
	int id;
	
	public Task getTask() {
		return task;
	}

	public CommandTaskGetById(MySQLTaskDAO mySQLTaskDAO, int id) {
		this.mySQLTaskDAO = mySQLTaskDAO;
		this.id = id;
	}

	@Override
	public void execute() {
		this.task = mySQLTaskDAO.getById(id);
	}

}
