package com.main.command.usercommand;

import org.apache.log4j.Logger;
import com.main.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.service.UserService;
import com.servicedao.service.impl.UserServiceImpl;

public class TaskAddToUserCommand implements Command {
	
	Logger logger = Logger.getLogger(TaskAddToUserCommand.class);

	private UserService service;
	Task task;
	String userName;

	public TaskAddToUserCommand(Task task, String userName) {
		this.service = UserServiceImpl.getInstance();
		this.task = task;
		this.userName = userName;
	}

	public void execute() {
		logger.info("TaskAddToUserCommand execute(task: " + task + " , userName: " + userName + ")");
		 service.AddTaskToUser(task, userName);
	}
	
}
