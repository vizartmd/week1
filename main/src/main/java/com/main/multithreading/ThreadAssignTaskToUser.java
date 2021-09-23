package com.main.multithreading;

import org.apache.log4j.Logger;
import com.main.command.CommandInvoker;
import com.main.command.usercommand.AddTaskToUserCommand;
import com.servicedao.domain.Task;

public class ThreadAssignTaskToUser extends Thread {
	
	Logger logger = Logger.getLogger(ThreadAssignTaskToUser.class);

	AddTaskToUserCommand addTaskToUserCommand;
	CommandInvoker commandInvoker;
	Task task;
	String userName;

	public ThreadAssignTaskToUser(Task task, String userName) {
		this.addTaskToUserCommand = new AddTaskToUserCommand(task, userName);
		this.commandInvoker = new CommandInvoker();
		this.task = task;
		this.userName = userName;
	}

	@Override
	public void run() {
		logger.info("ThreadAssignTaskToUser run()");
		commandInvoker.execute(addTaskToUserCommand);
	}

}
