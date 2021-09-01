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

public class MySQLUserService extends MySQLService {
	CommandInvoker commandInvoker = new CommandInvoker();
	MySQLUserDAOImpl mySQLUserDAOImpl = new MySQLUserDAOImpl();
	UserInsertCommand userInsertCommand;
	UserGetAllCommand userGetAllCommand;
	UserGetByIdCommand userGetByIdCommand;
	UserUpdateCommand userUpdateCommand;
	UserDeleteCommand UserDeleteCommand;

	public void insertUser(String firstName, String lastName, String userName) {
		userInsertCommand = new UserInsertCommand(mySQLUserDAOImpl, firstName, lastName, userName);
		commandInvoker.execute(userInsertCommand);
	}

	public User getUserById(int id) {
		userGetByIdCommand = new UserGetByIdCommand(id);
		commandInvoker.execute(userGetByIdCommand);
		return userGetByIdCommand.getUser();
	}

	public void updateUser(int id, String firstName, String lastName, String userName) {
		User user = new User(id, firstName, lastName, userName);
		userUpdateCommand = new UserUpdateCommand(user);
		commandInvoker.execute(userUpdateCommand);
	}
//
//	public void deleteUser(int id) {
//		UserDeleteCommand = new UserDeleteCommand(mySQLUserDAOImpl, id);
//		commandInvoker.execute(UserDeleteCommand);
//	}

	public List<User> gelAllUsers() {
		userGetAllCommand = new UserGetAllCommand(mySQLUserDAOImpl);
		commandInvoker.execute(userGetAllCommand);
		return userGetAllCommand.getUsers();
	}
}
