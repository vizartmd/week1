package com.main.command.taskcommand;

import java.util.Set;
import org.apache.log4j.Logger;
import com.main.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.service.impl.UserServiceImpl;

public class TaskGetUsersTasksByUserNameCommand implements Command {
	
	Logger logger = Logger.getLogger(TaskGetUsersTasksByUserNameCommand.class);

	private UserServiceImpl  service;
	private Set<Task> usersTasks;
	private String userName;
	
	public TaskGetUsersTasksByUserNameCommand(String userName) {
		this.service = UserServiceImpl.getInstance();
		this.userName = userName;
	}

	public Set<Task> getUsersTask() {
		return usersTasks;
	}

	@Override
	public void execute() {
		logger.info("TaskGetUsersTasksByUserNameCommand execute()");
		this.usersTasks = service.getUsersTasksByUserName(userName);
	}
	
}
