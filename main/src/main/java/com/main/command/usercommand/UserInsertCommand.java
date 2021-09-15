package com.main.command.usercommand;

import com.main.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.service.Service;
import com.servicedao.service.impl.TaskServiceImpl;
import com.servicedao.service.impl.UserServiceImpl;

/**
 * This class is a part of Command Design Pattern and operating with Task class
 * It has a single method "execute()" that calls the "insert()" method on
 * the TaskServiceImpl class from the service layer and send a new Task as a parameter.
 */
public class UserInsertCommand implements Command {
	
	private Service<User> service;
	User user;

	public UserInsertCommand(User user) {
		this.service = UserServiceImpl.getInstance();
		this.user = user;
	}

	public void execute() {
		service.insert(user);
	}
}
