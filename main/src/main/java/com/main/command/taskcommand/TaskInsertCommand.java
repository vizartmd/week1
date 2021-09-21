package com.main.command.taskcommand;

import org.apache.log4j.Logger;
import com.main.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.service.TaskService;
import com.servicedao.service.impl.TaskServiceImpl;

/**
 * This class is a part of Command Design Pattern and operating with Task class
 * It has a single method "execute()" that calls the "insert()" method on
 * the TaskServiceImpl class from the service layer and send a new Task as a parameter.
 */
public class TaskInsertCommand implements Command {
	
	Logger logger = Logger.getLogger(TaskInsertCommand.class);
	
	private TaskService service;
	Task task;

	public TaskInsertCommand(Task task) {
		this.service = TaskServiceImpl.getInstance();
		this.task = task;
	}

	public void execute() {
		logger.info("UserInsertCommand execute(" + task +")");
		 service.insert(task);
	}
}
