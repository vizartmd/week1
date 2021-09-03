package com.servicedao.command.usercommand;

import java.util.List;
import com.servicedao.command.Command;
import com.servicedao.dao.UserDAO;
import com.servicedao.dao.impl.MySQLUserDAOImpl;
import com.servicedao.domain.User;
import com.servicedao.service.mysqlservice.MySQLUserService;

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
