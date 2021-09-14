package com.main.command.usercommand;

import com.main.command.Command;
import com.servicedao.domain.User;
import com.servicedao.service.Service;
import com.servicedao.service.impl.UserServiceImpl;

/**
 * This class is a part of Command Design Pattern and operating with User class
 * It has a single method "execute()" that calls the "deleteById()" method on
 * the UserServiceImpl class from the service layer
 */
public class UserDeleteByIdCommand implements Command {

	private Service<User> service;
	private int id;
	
	public UserDeleteByIdCommand(UserServiceImpl userServiceImpl, int id) {
		this.service = (Service<User>) userServiceImpl;
		this.id = id;
	}

	@Override
	public void execute() {
		service.deleteById(id);
	}
	
}