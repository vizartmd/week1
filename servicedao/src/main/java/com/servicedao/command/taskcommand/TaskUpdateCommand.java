package com.servicedao.command.taskcommand;

import com.servicedao.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.service.mysqlservice.MySQLTaskService;

/**
 * This class is a part of Command Design Pattern and operating with Task class
 * It has a single method "execute()" that calls the "update()" method on
 * the MySQLTaskService class from the service layer and update a Task
 */
public class TaskUpdateCommand implements Command {

	private MySQLTaskService mySQLTaskService;
	private Task task;

	public TaskUpdateCommand(MySQLTaskService mySQLTaskService, int id, String title, String description, User user) {
		this.mySQLTaskService = mySQLTaskService;
		this.task = new Task(id, title, description, user);
	}
	
	@Override
	public void execute() {
		mySQLTaskService.update(task);
	}
}
