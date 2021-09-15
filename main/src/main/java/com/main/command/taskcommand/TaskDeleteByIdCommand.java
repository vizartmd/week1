package com.main.command.taskcommand;

import com.main.command.Command;
import com.servicedao.service.TaskService;
import com.servicedao.service.impl.TaskServiceImpl;

/**
 * This class is a part of Command Design Pattern and operating with Task class
 * It has a single method "execute()" that calls the "deleteById()" method on
 * the TaskServiceImpl class from the service layer
 */
public class TaskDeleteByIdCommand implements Command {

	private TaskService service;
	private int id;
	
	public TaskDeleteByIdCommand(int id) {
		this.service = TaskServiceImpl.getInstance();
		this.id = id;
	}

	@Override
	public void execute() {
		service.deleteById(id);
	}
	
}