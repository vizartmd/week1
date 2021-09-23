package com.main.multithreading;

import java.util.Set;
import org.apache.log4j.Logger;
import com.main.command.CommandInvoker;
import com.main.command.usercommand.AddTasksToUserCommand;
import com.servicedao.domain.Task;

public class ThreadAssignTasksToUser extends Thread {

	Logger logger = Logger.getLogger(ThreadAssignTaskToUser.class);

	AddTasksToUserCommand addTasksToUserCommand;
	CommandInvoker commandInvoker;
	Set<Task> tasks;
	String userName;

	public ThreadAssignTasksToUser(Set<Task> tasks, String userName) {
		this.addTasksToUserCommand = new AddTasksToUserCommand(tasks, userName);
		this.commandInvoker = new CommandInvoker();
		this.tasks = tasks;
		this.userName = userName;
	}

	@Override
	public void run() {
		logger.info("ThreadAssignTasksToUser run()");
		commandInvoker.execute(addTasksToUserCommand);
	}
	
}
