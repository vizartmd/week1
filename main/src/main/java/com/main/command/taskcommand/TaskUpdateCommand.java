package com.main.command.taskcommand;

import com.main.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.service.Service;
import com.servicedao.service.TaskService;
import com.servicedao.service.impl.TaskServiceImpl;

/**
 * This class is a part of Command Design Pattern and operating with Task class
 * It has a single method "execute()" that calls the "update()" method on
 * the TaskServiceImpl class from the service layer and update Task object
 */
public class TaskUpdateCommand implements Command {

	private TaskService service;
	Task task;
	
	public TaskUpdateCommand(Task task) {
		this.service = TaskServiceImpl.getInstance();
		this.task = task;
	}

	@Override
	public void execute() {
		service.update(task);
	} 
}
