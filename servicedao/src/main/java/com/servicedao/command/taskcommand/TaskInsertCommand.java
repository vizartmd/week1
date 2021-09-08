package com.servicedao.command.taskcommand;

import com.servicedao.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.service.mysqlservice.MySQLTaskService;

/**
 * This class is a part of Command Design Pattern and operating with Task class
 * It has a single method "execute()" that calls the "insert()" method on
 * the MySQLTaskService class from the service layer and send a new Task as a parameter.
 */
public class TaskInsertCommand implements Command {
	
	private MySQLTaskService mySQLTaskService;
	private Task task;
	
	public TaskInsertCommand(MySQLTaskService mySQLTaskService, String title, String description, User user) {
		this.mySQLTaskService = mySQLTaskService;
		this.task = new Task(title, description, user);
	}

	public void execute() {
		mySQLTaskService.insert(task);
	}
}
