package com.main.command.usercommand;

import com.main.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.service.Service;
import com.servicedao.service.impl.TaskServiceImpl;
import com.servicedao.service.impl.UserServiceImpl;

/**
 * This class is a part of Command Design Pattern and operating with User class
 * It has a single method "execute()" that calls the "update()" method on
 * the UserServiceImpl class from the service layer and update User object
 */
public class UserUpdateCommand implements Command {

	private Service<User> service;
	User user;
	
	public UserUpdateCommand(User user) {
		this.service = UserServiceImpl.getInstance();
		this.user = user;
	}

	@Override
	public void execute() {
		service.update(user);
	}
}
