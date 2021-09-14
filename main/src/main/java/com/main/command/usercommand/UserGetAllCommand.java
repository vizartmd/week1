package com.main.command.usercommand;

import java.util.List;

import com.main.command.Command;
import com.servicedao.domain.User;
import com.servicedao.service.Service;
import com.servicedao.service.impl.UserServiceImpl;

/**
 * This class is a part of Command Design Pattern and operating with Task class
 * It has a single method "execute()" that calls the "getAll()" method on
 * the TaskServiceImpl class from the service layer
 */
public class UserGetAllCommand implements Command {

	private Service<User>  service;
	private List<User> list;
	
	@SuppressWarnings("unchecked")
	public UserGetAllCommand(UserServiceImpl userServiceImpl) {
		this.service = (Service<User>) userServiceImpl;
	}

	public List<User> getAll() {
		return list;
	}

	@Override
	public void execute() {
		this.list = service.getAll();
	}
}
