package com.main.command.taskcommand;

import com.main.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.service.Service;
import com.servicedao.service.impl.TaskServiceImpl;

/**
 * This class is a part of Command Design Pattern and operating with Task class
 * It has a single method "execute()" that calls the "insert()" method on
 * the TaskServiceImpl class from the service layer and send a new Task as a parameter.
 */
public class TaskInsertCommand implements Command {
	
	private Service<Task> service;
	Task task;

	public TaskInsertCommand(TaskServiceImpl taskServiceImpl, Task task) {
		this.service = taskServiceImpl;
		this.task = task;
	}

	public void execute() {
		service.insert(task);
	}
}
