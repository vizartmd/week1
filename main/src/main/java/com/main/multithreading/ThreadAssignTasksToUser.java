package com.main.multithreading;

import java.util.Set;
import org.apache.log4j.Logger;
import com.main.command.CommandInvoker;
import com.main.command.usercommand.AddTasksToUserCommand;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;

public class ThreadAssignTasksToUser extends Thread {

	Logger logger = Logger.getLogger(ThreadAssignTaskToUser.class);

	AddTasksToUserCommand addTasksToUserCommand;
	CommandInvoker commandInvoker;
	Set<Task> tasks;
	User user;

	public ThreadAssignTasksToUser(Set<Task> tasks, User user) {
		this.addTasksToUserCommand = new AddTasksToUserCommand(tasks, user);
		this.commandInvoker = new CommandInvoker();
		this.tasks = tasks;
		this.user = user;
	}

	@Override
	public void run() {
		logger.info("ThreadAssignTasksToUser run()");
		commandInvoker.execute(addTasksToUserCommand);
	}
	
}
