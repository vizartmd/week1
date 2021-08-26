package com.servicedao.command.taskcommand;

import com.servicedao.command.Command;
import com.servicedao.dao.MySQLTaskDAO;
import com.servicedao.domain.Task;

public class CommandTaskUpdate implements Command {

	MySQLTaskDAO mySQLTaskDAO = new MySQLTaskDAO();
	Task task;
	int id;

	public CommandTaskUpdate(Task task, int id) {
		this.task = task;
		this.id = id;
	}

	@Override
	public void execute() {
		mySQLTaskDAO.update(task, id);

	}
}
