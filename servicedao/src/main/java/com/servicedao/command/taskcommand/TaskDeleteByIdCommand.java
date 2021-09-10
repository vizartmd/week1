package com.servicedao.command.taskcommand;

import com.servicedao.command.Command;
import com.servicedao.service.mysqlservice.MySQLTaskService;

/**
 * This class is a part of Command Design Pattern and operating with Task class
 * It has a single method "execute()" that calls the "deleteById()" method on
 * the MySQLTaskService class from the service layer
 */
public class TaskDeleteByIdCommand implements Command {

	private MySQLTaskService mySQLTaskService;
	private int id;
	
	public TaskDeleteByIdCommand(MySQLTaskService mySQLTaskService, int id) {
		this.mySQLTaskService = mySQLTaskService;
		this.id = id;
	}
	
	@Override
	public void execute() {
		mySQLTaskService.deleteById(id);
	}
	
}
