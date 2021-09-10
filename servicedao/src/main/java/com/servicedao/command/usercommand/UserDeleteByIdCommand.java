package com.servicedao.command.usercommand;

import com.servicedao.command.Command;
import com.servicedao.service.mysqlservice.MySQLUserService;

/**
 * This class is a part of Command Design Pattern and operating with User class
 * It has a single method "execute()" that calls the "deleteById()" method on
 * the MySQLUserService class from the service layer
 * deleteById() method is deleting an User object by unique id
 */
public class UserDeleteByIdCommand implements Command {

	private MySQLUserService mySQLUserService;
	private int id;

	public UserDeleteByIdCommand(MySQLUserService mySQLUserService, int id) {
		this.mySQLUserService = mySQLUserService;
		this.id = id;
	}

	public void execute() {
		mySQLUserService.deleteById(id);
	}

}