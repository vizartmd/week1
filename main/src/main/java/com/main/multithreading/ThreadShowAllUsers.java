package com.main.multithreading;

import java.util.Set;
import java.util.concurrent.Callable;
import org.apache.log4j.Logger;
import com.main.command.CommandInvoker;
import com.main.command.usercommand.UserGetAllCommand;
import com.servicedao.domain.User;

public class ThreadShowAllUsers extends Thread {
	
	Logger logger = Logger.getLogger(ThreadShowAllUsers.class);

	UserGetAllCommand userGetAllCommand;
	CommandInvoker commandInvoker;
	Set<User> users;

	public ThreadShowAllUsers() {
		this.userGetAllCommand = new UserGetAllCommand();
		this.commandInvoker = new CommandInvoker();
	}

	public Callable newCallable() {
		return new Callable() {
			@Override
			public Object call() throws Exception {
				logger.info("ThreadShowAllUsers call()");
				commandInvoker.execute(userGetAllCommand);
				return users = userGetAllCommand.getAll();
			}
		};
	}
}
