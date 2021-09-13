package com.main.command;

/**
 * this class receives as a parameter another class that implements the interface
 * Command and And fulfills his only method
 * This is invoker class from Command Design Pattern
 */
public class CommandInvoker{

	public void execute(Command command) {
		command.execute();
	}

}
