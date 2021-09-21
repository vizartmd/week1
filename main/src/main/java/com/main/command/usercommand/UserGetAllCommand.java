package com.main.command.usercommand;

import java.util.List;

import org.apache.log4j.Logger;

import com.main.command.Command;
import com.servicedao.domain.User;
import com.servicedao.service.Service;
import com.servicedao.service.UserService;
import com.servicedao.service.impl.UserServiceImpl;

/**
 * This class is a part of Command Design Pattern and operating with Task class
 * It has a single method "execute()" that calls the "getAll()" method on
 * the TaskServiceImpl class from the service layer
 */
public class UserGetAllCommand implements Command {
	
	Logger logger = Logger.getLogger(UserGetAllCommand.class);

	private UserService service;
	private List<User> list;
	
	public UserGetAllCommand() {
		this.service = UserServiceImpl.getInstance();
	}

	public List<User> getAll() {
		return list;
	}

	@Override
	public void execute() {
		logger.info("UserGetAllCommand execute()");
		this.list = (List<User>) service.getAll();
	}
}
