package com.main.multithreading;

import com.main.command.CommandInvoker;
import com.main.command.taskcommand.TaskInsertCommand;
import com.servicedao.domain.Task;

public class ThreadCreateTask implements Runnable {

	TaskInsertCommand taskInsertCommand;
	CommandInvoker commandInvoker;
	Task task;

	public ThreadCreateTask(Task task) {
		this.taskInsertCommand = new TaskInsertCommand(task);
		this.task = task;
	}

	@Override
	public void run() {
		System.out.println("user from ThreadCreateTask = " + task);
		commandInvoker.execute(taskInsertCommand);
	}

}
