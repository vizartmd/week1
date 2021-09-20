package com.main.multithreading;

import com.main.command.CommandInvoker;
import com.main.command.usercommand.UserInsertCommand;
import com.servicedao.domain.User;

public class ThreadCreateUser extends Thread {

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
		System.out.println("ThreadCreateUser, user = " + user);
		commandInvoker.execute(userInsertCommand);
	}

}


