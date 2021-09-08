package com.servicedao.command.usertaskcommand;

import java.util.Set;

import com.servicedao.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.service.mysqlservice.MySQLUserService;

public class CreateUserAndAddHimTasksCommand implements Command { 

	private MySQLUserService mySQLUserService;
	private User user;
	private Set<Task> tasks;
	
	public CreateUserAndAddHimTasksCommand(MySQLUserService mySQLUserService, User user, Set<Task> tasks) {
		this.mySQLUserService = mySQLUserService;
		this.user = user;
		this.tasks = tasks;
	}

	@Override
	public void execute() {
		mySQLUserService.createUserAndAddHimTasks(user, tasks);
	}

}
