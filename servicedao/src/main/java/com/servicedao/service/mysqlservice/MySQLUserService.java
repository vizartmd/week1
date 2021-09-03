package com.servicedao.service.mysqlservice;

import java.util.List;

import com.servicedao.command.usercommand.UserDeleteCommand;
import com.servicedao.command.usercommand.UserGetAllCommand;
import com.servicedao.command.usercommand.UserGetByIdCommand;
import com.servicedao.command.usercommand.UserInsertCommand;
import com.servicedao.command.usercommand.UserUpdateCommand;
import com.servicedao.daoimpl.MySQLUserDAOImpl;
import com.servicedao.domain.User;
import com.servicedao.service.CommandInvoker;

/**
 * This class includes the methods that receive the classes that implements
 * Command interface as a parameter in execute() method of CommandInvoker class.
 * This is an element of Command Design Pattern
 */
public class MySQLUserService extends MySQLService {
	private CommandInvoker commandInvoker;
	private UserInsertCommand userInsertCommand;
	private UserGetAllCommand userGetAllCommand;
	private UserGetByIdCommand userGetByIdCommand;
	private UserUpdateCommand userUpdateCommand;
	private UserDeleteCommand UserDeleteCommand;

	public void insertUser(String firstName, String lastName, String userName, MySQLUserDAOImpl mySQLUserDAOImpl) {
		userInsertCommand = new UserInsertCommand(mySQLUserDAOImpl, firstName, lastName, userName);
		commandInvoker.execute(userInsertCommand);
	}

	public User getUserById(int id, MySQLUserDAOImpl mySQLUserDAOImpl) {
		userGetByIdCommand = new UserGetByIdCommand(mySQLUserDAOImpl, id);
		commandInvoker.execute(userGetByIdCommand);
		return userGetByIdCommand.getUser();
	}

	public void updateUser(int id, String firstName, String lastName, String userName, MySQLUserDAOImpl mySQLUserDAOImpl) {
		userUpdateCommand = new UserUpdateCommand(mySQLUserDAOImpl,firstName,lastName,userName);
		commandInvoker.execute(userUpdateCommand);
	}

	public void deleteUser(int id, MySQLUserDAOImpl mySQLUserDAOImpl) {
		UserDeleteCommand = new UserDeleteCommand(mySQLUserDAOImpl, id);
		commandInvoker.execute(UserDeleteCommand);
	}

	public List<User> gelAllUsers(MySQLUserDAOImpl mySQLUserDAOImpl) {
		userGetAllCommand = new UserGetAllCommand(mySQLUserDAOImpl);
		commandInvoker.execute(userGetAllCommand);
		return userGetAllCommand.getUsers();
	}
}
