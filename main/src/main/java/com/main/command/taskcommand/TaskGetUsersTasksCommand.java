package com.main.command.taskcommand;

import java.util.List;
import org.apache.log4j.Logger;
import com.main.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.service.TaskService;
import com.servicedao.service.impl.TaskServiceImpl;

public class TaskGetUsersTasksCommand implements Command {
	
	Logger logger = Logger.getLogger(TaskGetUsersTasksCommand.class);

	private TaskService  service;
	private List<Task> usersTasks;
	int userId;
	
	public TaskGetUsersTasksCommand(int userId) {
		this.service = TaskServiceImpl.getInstance();
		this.userId = userId;
	}

	public List<Task> getUsersTask() {
		return usersTasks;
	}

	@Override
	public void execute() {
		logger.info("TaskGetUsersTasksCommand execute(userId: " + userId +")");
		this.usersTasks = (List<Task>) service.getUsersTask(userId);
	}
	
}
