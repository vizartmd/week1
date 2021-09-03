package com.servicedao.command.usercommand;

import com.servicedao.command.Command;
import com.servicedao.domain.User;
import com.servicedao.service.mysqlservice.MySQLUserService;

/**
 * This class is a part of Command Design Pattern and operating with User class
 * It has a single method "execute()" that calls the "getById()" method on
 * the MySQLUserService class from the service layer
 * @return a User object by unique @param id
 */
public class UserGetByIdCommand implements Command {

	private MySQLUserService mySQLUserService;
	private User user;
	int id;

	public UserGetByIdCommand(MySQLUserService mySQLUserService, int id) {
		this.mySQLUserService = mySQLUserService;
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	@Override
	public void execute() {
		user = mySQLUserService.getById(id);
	}

}
