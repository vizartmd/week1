package com.servicedao.command.taskcommand;

import com.servicedao.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.service.mysqlservice.MySQLTaskService;

public class TaskInsertCommand implements Command {
	
	private MySQLTaskService mySQLTaskService;
	private Task task;
	
	public TaskInsertCommand(MySQLTaskService mySQLTaskService, int userId, String title, String description) {
		this.mySQLTaskService = mySQLTaskService;
		this.task = new Task(userId, title, description);
	}

	public void execute() {
		mySQLTaskService.insert(task);
	}
}
