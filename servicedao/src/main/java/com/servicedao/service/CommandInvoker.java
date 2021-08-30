package com.servicedao.service;

import com.servicedao.command.Command;

public class CommandInvoker {

	public void execute(Command command) {
		command.execute();
	}

}
