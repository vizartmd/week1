package com.servicedao.command.taskcommand;

import com.servicedao.command.Command;
import com.servicedao.service.mysqlservice.MySQLTaskService;

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
