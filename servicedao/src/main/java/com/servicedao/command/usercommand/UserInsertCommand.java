package com.servicedao.command.usercommand;

import com.servicedao.command.Command;
import com.servicedao.domain.User;
import com.servicedao.service.mysqlservice.MySQLUserService;

public class UserInsertCommand implements Command {

	private MySQLUserService mySQLUserService;
	private User user;

	public UserInsertCommand(MySQLUserService mySQLUserService, String firstName, String lastName, String userName) { 
		this.mySQLUserService = mySQLUserService;  
		this.user = new User(firstName, lastName, userName); 
	}

	@Override
	public void execute() {
		mySQLUserService.insert(user);
	}
}
