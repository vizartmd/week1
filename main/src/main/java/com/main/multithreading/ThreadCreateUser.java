package com.main.multithreading;

import com.main.command.CommandInvoker;
import com.main.command.usercommand.UserInsertCommand;
import com.servicedao.domain.User;

class ThreadCreateUser implements Runnable {

	UserInsertCommand userInsertCommand;
	CommandInvoker commandInvoker;
	User user;

	public ThreadCreateUser(User user) {
		this.userInsertCommand = new UserInsertCommand(user);
		this.user = user;
	}

	@Override
	public void run() {
		System.out.println("user from ThreadCreateUser = " + user);
		commandInvoker.execute(userInsertCommand);
	}

}


