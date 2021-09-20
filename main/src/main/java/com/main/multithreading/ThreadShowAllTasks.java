package com.main.multithreading;

import java.util.List;
import java.util.concurrent.Callable;
import com.main.command.CommandInvoker;
import com.main.command.taskcommand.TaskGetAllCommand;
import com.servicedao.domain.Task;

public class ThreadShowAllTasks extends Thread {

	TaskGetAllCommand taskGetAllCommand;
	CommandInvoker commandInvoker;
	List<Task> tasks;

	public ThreadShowAllTasks() {
		this.taskGetAllCommand = new TaskGetAllCommand();
		this.commandInvoker = new CommandInvoker();
	}

	@SuppressWarnings("rawtypes")
	public Callable newCallable() {
		return new Callable() {
			@Override
			public Object call() throws Exception {
				commandInvoker.execute(taskGetAllCommand);
				return tasks = taskGetAllCommand.getAll();
			}
		};
	}
	
}
