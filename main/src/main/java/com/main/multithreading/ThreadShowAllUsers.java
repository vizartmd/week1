package com.main.multithreading;

import java.util.List;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

import com.main.command.CommandInvoker;
import com.main.command.usercommand.UserGetAllCommand;
import com.servicedao.domain.User;

public class ThreadShowAllUsers extends Thread {
	
	Logger logger = Logger.getLogger(ThreadShowAllUsers.class);

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
				logger.info("ThreadShowAllUsers call()");
				commandInvoker.execute(userGetAllCommand);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return users = userGetAllCommand.getAll();
			}
		};
	}
}
