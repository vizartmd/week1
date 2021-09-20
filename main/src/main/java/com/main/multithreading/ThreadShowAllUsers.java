package com.main.multithreading;

import java.util.List;
import java.util.concurrent.Callable;
import com.main.command.CommandInvoker;
import com.main.command.usercommand.UserGetAllCommand;
import com.servicedao.domain.User;

public class ThreadShowAllUsers extends Thread {

	UserGetAllCommand userGetAllCommand;
	CommandInvoker commandInvoker;
	List<User> users;

	public ThreadShowAllUsers() {
		this.userGetAllCommand = new UserGetAllCommand();
		this.commandInvoker = new CommandInvoker();
	}

	@SuppressWarnings("rawtypes")
	public Callable newCallable() {
		return new Callable() {
			@Override
			public Object call() throws Exception {
				commandInvoker.execute(userGetAllCommand);
				return users = userGetAllCommand.getAll();
			}
		};
	}
}
