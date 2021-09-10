package com.servicedao.command.usercommand;

import java.util.List;
import com.servicedao.command.Command;
import com.servicedao.dao.UserDAO;
import com.servicedao.dao.impl.MySQLUserDAOImpl;
import com.servicedao.domain.User;
import com.servicedao.service.mysqlservice.MySQLUserService;

/**
 * This class is a part of Command Design Pattern and operating with User class
 * It has a single method "execute()" that calls the "getAll()" method on
 * the MySQLUserService class from the service layer
 */
public class UserGetAllCommand implements Command {

	private MySQLUserService mySQLUserService;
	private List<User> users;

	public UserGetAllCommand(MySQLUserService mySQLUserService) {
		this.mySQLUserService = mySQLUserService;
	}

	public List<User> getUsers() {
		return users;
	}

	@Override
	public void execute() {
		this.users = mySQLUserService.getAll();
	}
}
