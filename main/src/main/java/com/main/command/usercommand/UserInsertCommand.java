package com.main.command.usercommand;

import org.apache.log4j.Logger;

import com.main.command.Command;
import com.servicedao.domain.User;
import com.servicedao.service.UserService;
import com.servicedao.service.impl.UserServiceImpl;

/**
 * This class is a part of Command Design Pattern and operating with Task class
 * It has a single method "execute()" that calls the "insert()" method on
 * the TaskServiceImpl class from the service layer and send a new Task as a parameter.
 */
public class UserInsertCommand implements Command {
	
	Logger logger = Logger.getLogger(UserInsertCommand.class);
	
	private UserService userService;
	User user;

	public UserInsertCommand(User user) {
		this.userService = UserServiceImpl.getInstance();
		this.user = user;
	}

	public void execute() {
		logger.info("UserInsertCommand execute(), user: " + user);
		userService.insert(user);
	}
}
