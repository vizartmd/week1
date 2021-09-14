package com.main.command.taskcommand;

import com.main.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.service.Service;
import com.servicedao.service.impl.TaskServiceImpl;

/**
 * This class is a part of Command Design Pattern and operating with Task class
 * It has a single method "execute()" that calls the "update()" method on
 * the TaskServiceImpl class from the service layer and update Task object
 */
public class TaskUpdateCommand implements Command {

	private Service<Task> service;
	Task task;
	
	public TaskUpdateCommand(TaskServiceImpl taskServiceImpl, Task task) {
		this.service = taskServiceImpl;
		this.task = task;
	}

	@Override
	public void execute() {
		service.update(task);
	}
}
