package com.main.command.taskcommand;

import com.main.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.service.Service;
import com.servicedao.service.impl.TaskServiceImpl;

/**
 * This class is a part of Command Design Pattern and operating with Task class
 * It has a single method "execute()" that calls the "getById()" method on
 * the TaskServiceImpl class from the service layer
 */
public class TaskGetByIdCommand implements Command {

	private Service<Task> service;
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
		this.task = (Task) service.getById(id);
	}

}