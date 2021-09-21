package com.main.command.usercommand;

import org.apache.log4j.Logger;

import com.main.command.Command;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.service.Service;
import com.servicedao.service.UserService;
import com.servicedao.service.impl.TaskServiceImpl;
import com.servicedao.service.impl.UserServiceImpl;

/**
 * This class is a part of Command Design Pattern and operating with Task class
 * It has a single method "execute()" that calls the "getById()" method on
 * the TaskServiceImpl class from the service layer
 */
public class UserGetByIdCommand implements Command {
	
	Logger logger = Logger.getLogger(UserGetByIdCommand.class);

	private UserService service;
	private int id;
	User user;
	
	public UserGetByIdCommand(int id) {
		this.service = UserServiceImpl.getInstance();
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	@Override
	public void execute() {
		logger.info("UserGetByIdCommand execute(userId: " + id +")");
		this.user = service.findById(id);
	}

}