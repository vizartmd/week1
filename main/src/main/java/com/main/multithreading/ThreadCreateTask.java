package com.main.multithreading;

import com.main.command.CommandInvoker;
import com.main.command.taskcommand.TaskInsertCommand;
import com.servicedao.domain.Task;

public class ThreadCreateTask extends Thread {

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
		System.out.println("ThreadCreateTask, task = " + task);
		commandInvoker.execute(taskInsertCommand);
	}

}
