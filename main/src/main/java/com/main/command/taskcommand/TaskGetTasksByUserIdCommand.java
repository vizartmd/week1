package com.main.command.taskcommand;

import java.util.Set;

import org.apache.log4j.Logger;

import com.main.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.service.impl.UserServiceImpl;

public class TaskGetTasksByUserIdCommand implements Command {
	
	Logger logger = Logger.getLogger(TaskGetTasksByUserIdCommand.class);

	private UserServiceImpl  service;
	private Set<Task> usersTasks;
	private int userId;
	
	public TaskGetTasksByUserIdCommand(int userId) {
		this.service = UserServiceImpl.getInstance();
		this.userId = userId;
	}

	public Set<Task> getUsersTaskById() {
		return usersTasks;
	}

	@Override
	public void execute() {
		logger.info("TaskGetTasksByUserIdCommand execute()");
		this.usersTasks = service.getUsersTasksByUserId(userId);
	}
	
}
