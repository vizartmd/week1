package com.main.command.taskcommand;

import org.apache.log4j.Logger;
import com.main.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.service.TaskService;
import com.servicedao.service.impl.TaskServiceImpl;

/**
 * This class is a part of Command Design Pattern and operating with Task class
 * It has a single method "execute()" that calls the "getById()" method on
 * the TaskServiceImpl class from the service layer
 */
public class TaskGetByIdCommand implements Command {
	
	Logger logger = Logger.getLogger(TaskGetByIdCommand.class);

	private TaskService service;
	private int id;
	Task task;
	
	public TaskGetByIdCommand(int id) {
		this.service = TaskServiceImpl.getInstance();
		this.id = id;
	}

	public Task getItem() {
		return task;
	}

	@Override
	public void execute() {
		logger.info("TaskGetByIdCommand execute(taskId: " + id +")");
		this.task = (Task) service.findById(id);
	}

}