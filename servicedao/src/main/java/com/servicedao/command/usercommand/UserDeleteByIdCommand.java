package com.servicedao.command.usercommand;

import com.servicedao.command.Command;
import com.servicedao.service.mysqlservice.MySQLUserService;

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