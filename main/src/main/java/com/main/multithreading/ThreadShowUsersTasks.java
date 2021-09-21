package com.main.multithreading;

import java.util.List;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

import com.main.command.CommandInvoker;
import com.main.command.taskcommand.TaskGetUsersTasksCommand;
import com.servicedao.domain.Task;

public class ThreadShowUsersTasks {
	
	Logger logger = Logger.getLogger(ThreadShowUsersTasks.class);

	TaskGetUsersTasksCommand taskGetUsersTasksCommand;
	CommandInvoker commandInvoker;
	List<Task> tasks;
	int userId;;

	public ThreadShowUsersTasks(int userId) {
		this.commandInvoker = new CommandInvoker();
		this.userId = userId;
	}

	@SuppressWarnings("rawtypes")
	public Callable newCallable() {
		return new Callable() {
			@Override
			public Object call() throws Exception {
				logger.info("ThreadShowUsersTasks call()");
				taskGetUsersTasksCommand = new TaskGetUsersTasksCommand(userId);
				commandInvoker.execute(taskGetUsersTasksCommand);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return tasks = taskGetUsersTasksCommand.getUsersTask();
			}
		};
	}
	
}
