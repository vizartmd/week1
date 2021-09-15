package com.main.command.taskcommand;

import java.util.List;

import com.main.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.service.TaskService;
import com.servicedao.service.impl.TaskServiceImpl;

/**
 * This class is a part of Command Design Pattern and operating with Task class
 * It has a single method "execute()" that calls the "getAll()" method on
 * the TaskServiceImpl class from the service layer
 */
public class TaskGetAllCommand implements Command {

	private TaskService  service;
	private List<Task> list;
	
	public TaskGetAllCommand() {
		this.service = TaskServiceImpl.getInstance();
	}

	public List<Task> getAll() {
		return list;
	}

	@Override
	public void execute() {
		this.list = (List<Task>) service.getAll();
	}
}
