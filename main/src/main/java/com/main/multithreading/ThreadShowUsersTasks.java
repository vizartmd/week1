package com.main.multithreading;

import java.util.Set;
import java.util.concurrent.Callable;
import org.apache.log4j.Logger;
import com.main.command.CommandInvoker;
import com.main.command.taskcommand.TaskGetUsersTasksByUserNameCommand;
import com.servicedao.domain.Task;

public class ThreadShowUsersTasks  extends Thread {
	
	Logger logger = Logger.getLogger(ThreadShowUsersTasks.class);

	TaskGetUsersTasksByUserNameCommand taskGetUsersTasksByUserNameCommand;
	CommandInvoker commandInvoker;
	Set<Task> tasks;
	String username;

	public ThreadShowUsersTasks(String username) {
		this.commandInvoker = new CommandInvoker();
		this.username = username;
	}

	@SuppressWarnings("rawtypes")
	public Callable newCallable() {
		return new Callable() {
			@Override
			public Object call() throws Exception {
				logger.info("ThreadShowUsersTasks call()");
				taskGetUsersTasksByUserNameCommand = new TaskGetUsersTasksByUserNameCommand(username);
				commandInvoker.execute(taskGetUsersTasksByUserNameCommand);
				return tasks = taskGetUsersTasksByUserNameCommand.getUsersTask();
			}
		};
	}
	
}
