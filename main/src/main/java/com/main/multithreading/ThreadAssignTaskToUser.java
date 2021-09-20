package com.main.multithreading;

import org.apache.log4j.Logger;

import com.main.command.CommandInvoker;
import com.main.command.usercommand.TaskAddToUserCommand;
import com.servicedao.domain.Task;

public class ThreadAssignTaskToUser extends Thread {
	
	Logger logger = Logger.getLogger(ThreadAssignTaskToUser.class);

	TaskAddToUserCommand taskAddToUserCommand;
	CommandInvoker commandInvoker;
	Task task;
	String userName;

	public ThreadAssignTaskToUser(Task task, String userName) {
		this.taskAddToUserCommand = new TaskAddToUserCommand(task, userName);
		this.commandInvoker = new CommandInvoker();
		this.task = task;
		this.userName = userName;
	}

	@Override
	public void run() {
		logger.info("TaskAddToUserCommand execute(task: " + task + " , user: " + userName + ")");
		commandInvoker.execute(taskAddToUserCommand);
	}

}
