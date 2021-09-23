package com.main.multithreading;

import org.apache.log4j.Logger;
import com.main.command.CommandInvoker;
import com.main.command.usercommand.UserInsertCommand;
import com.servicedao.domain.User;

public class ThreadCreateUser extends Thread {
	
	Logger logger = Logger.getLogger(ThreadCreateTask.class);

	UserInsertCommand userInsertCommand;
	CommandInvoker commandInvoker;
	User user;

	public ThreadCreateUser(User user) {
		this.userInsertCommand = new UserInsertCommand(user);
		this.commandInvoker = new CommandInvoker();
		this.user = user;
	}

	@Override
	public void run() {
		logger.info("ThreadCreateUser run(), user = " + user);
		commandInvoker.execute(userInsertCommand);
	}

}


