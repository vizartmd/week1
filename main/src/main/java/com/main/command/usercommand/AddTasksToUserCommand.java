package com.main.command.usercommand;

import java.util.Set;

import org.apache.log4j.Logger;

import com.main.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.service.UserService;
import com.servicedao.service.impl.UserServiceImpl;

public class AddTasksToUserCommand implements Command {

	Logger logger = Logger.getLogger(AddTaskToUserCommand.class);

	private UserService service;
	Set<Task> tasks;
	String userName;

	public AddTasksToUserCommand(Set<Task> tasks, String userName) {
		this.service = UserServiceImpl.getInstance();
		this.tasks = tasks;
		this.userName = userName;
	}

	public void execute() {
		logger.info("AddTasksToUserCommand execute()");
		 service.addTasksToUserByUserName(tasks, userName);
	}
	
}