package com.servicedao.command.taskcommand;

import com.servicedao.command.Command;
import com.servicedao.dao.MySQLTaskDAO;
import com.servicedao.domain.Task;

public class CommandTaskGetById implements Command {

	MySQLTaskDAO mySQLTaskDAO = new MySQLTaskDAO();
	Task task;
	int id;
	
	public Task getTask() {
		return task;
	}

	public CommandTaskGetById(int id) {
		this.id = id;
	}

	@Override
	public void execute() {
		this.task = mySQLTaskDAO.getById(id);
	}

}