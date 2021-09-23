package com.main.command.usercommand;

import org.apache.log4j.Logger;
import com.main.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.service.UserService;
import com.servicedao.service.impl.UserServiceImpl;

public class AddTaskToUserCommand implements Command {
	
	Logger logger = Logger.getLogger(AddTaskToUserCommand.class);

	private UserService userService;
	Task task;
	String userName;

	public AddTaskToUserCommand(Task task, String userName) {
		this.userService = UserServiceImpl.getInstance();
		this.task = task;
		this.userName = userName;
	}

	public void execute() {
		logger.info("AddTaskToUserCommand execute(task: " + task + " , userName: " + userName + ")");
		userService.addTaskToUserByUserName(task, userName);
	}
	
}
