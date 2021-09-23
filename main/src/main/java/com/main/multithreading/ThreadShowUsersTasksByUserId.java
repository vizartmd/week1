package com.main.multithreading;

import java.util.Set;
import java.util.concurrent.Callable;
import org.apache.log4j.Logger;
import com.main.command.CommandInvoker;
import com.main.command.taskcommand.TaskGetTasksByUserIdCommand;
import com.servicedao.domain.Task;

public class ThreadShowUsersTasksByUserId  extends Thread {
	
	Logger logger = Logger.getLogger(ThreadShowUsersTasksByUserId.class);

	TaskGetTasksByUserIdCommand taskGetTasksByUserIdCommand;
	CommandInvoker commandInvoker;
	Set<Task> tasks;
	int userId;

	public ThreadShowUsersTasksByUserId(int userId) {
		this.commandInvoker = new CommandInvoker();
		this.userId = userId;
	}

	@SuppressWarnings("rawtypes")
	public Callable newCallable() {
		return new Callable() {
			@Override
			public Object call() throws Exception {
				logger.info("ThreadShowUsersTasksByUserId call()");
				taskGetTasksByUserIdCommand = new TaskGetTasksByUserIdCommand(userId);
				commandInvoker.execute(taskGetTasksByUserIdCommand);
				return tasks = taskGetTasksByUserIdCommand.getUsersTaskById();
			}
		};
	}
	
}