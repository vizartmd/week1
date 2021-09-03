package com.servicedao.command.taskcommand;

import java.util.List;
import com.servicedao.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.service.mysqlservice.MySQLTaskService;

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
