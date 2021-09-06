package com.servicedao.command.usercommand;

import com.servicedao.command.Command;
import com.servicedao.domain.User;
import com.servicedao.service.mysqlservice.MySQLUserService;

/**
 * This class is a part of Command Design Pattern and operating with User class
 * It has a single method "execute()" that calls the "update()" method on
 * the MySQLUserService class from the service layer and update a User 
 */
public class UserUpdateCommand implements Command {

	private MySQLUserService mySQLUserService;
	private User user;

	public UserUpdateCommand(MySQLUserService mySQLUserService, int id, String firstName, String lastName, String userName) {
		this.mySQLUserService = mySQLUserService;
		this.user = new User(id, firstName, lastName, userName);
	}

	@Override
	public void execute() {
		mySQLUserService.update(user);
	}

}
