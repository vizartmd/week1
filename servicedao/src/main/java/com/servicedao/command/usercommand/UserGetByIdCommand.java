package com.servicedao.command.usercommand;

import com.servicedao.command.Command;
import com.servicedao.domain.User;
import com.servicedao.service.mysqlservice.MySQLUserService;

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
