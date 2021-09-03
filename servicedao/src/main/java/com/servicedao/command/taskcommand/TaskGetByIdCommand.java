package com.servicedao.command.taskcommand;

import com.servicedao.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.service.mysqlservice.MySQLTaskService;

public class TaskGetByIdCommand implements Command {

	private MySQLTaskService mySQLTaskService;
	private Task task;
	private int id;

	public TaskGetByIdCommand(MySQLTaskService mySQLTaskService, int id) {
		this.mySQLTaskService = mySQLTaskService;
		this.id = id;
	}

	public Task getTask() {
		return task;
	}

	@Override
	public void execute() {
		this.task = mySQLTaskService.getById(id);
	}

}