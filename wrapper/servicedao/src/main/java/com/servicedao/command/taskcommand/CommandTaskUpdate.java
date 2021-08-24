package com.servicedao.command.taskcommand;

import com.servicedao.command.Command;
import com.servicedao.dao.MySQLTaskDAO;
import com.servicedao.domain.Task;

public class CommandTaskUpdate implements Command {

	MySQLTaskDAO mySQLTaskDAO;
	Task task;
	int id;

	public CommandTaskUpdate(MySQLTaskDAO mySQLTaskDAO, Task task, int id) {
		this.mySQLTaskDAO = mySQLTaskDAO;
		this.task = task;
		this.id = id;
	}

	@Override
	public void execute() {
		mySQLTaskDAO.update(task, id);

	}
}
