package com.servicedao.command.taskcommand;

import java.util.List;
import com.servicedao.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.service.mysqlservice.MySQLTaskService;

/**
 * This class is a part of Command Design Pattern and operating with Task class
 * It has a single method "execute()" that calls the "getAll()" method on
 * the MySQLTaskService class from the service layer
 * @return a list of Tasks 
 */
public class TaskGetAllCommand implements Command {

	private MySQLTaskService mySQLTaskService;
	private List<Task> tasks;

	public TaskGetAllCommand(MySQLTaskService mySQLTaskService) {
		this.mySQLTaskService = mySQLTaskService;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	@Override
	public void execute() {
		this.tasks = mySQLTaskService.getAll();
	}
}
