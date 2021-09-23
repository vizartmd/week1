package com.main.multithreading;

import org.apache.log4j.Logger;
import com.main.command.CommandInvoker;
import com.main.command.taskcommand.TaskInsertCommand;
import com.servicedao.domain.Task;

public class ThreadCreateTask extends Thread {
	
	Logger logger = Logger.getLogger(ThreadCreateTask.class);

	TaskInsertCommand taskInsertCommand;
	CommandInvoker commandInvoker;
	Task task;

	public ThreadCreateTask(Task task) {
		this.taskInsertCommand = new TaskInsertCommand(task);
		this.commandInvoker = new CommandInvoker();
		this.task = task;
	}

	@Override
	public void run() {
		logger.info("ThreadAssignTaskToUser run()");
		commandInvoker.execute(taskInsertCommand);
	}

}
