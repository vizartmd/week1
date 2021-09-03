package com.servicedao.command.usercommand;

import java.util.List;
import com.servicedao.command.Command;
import com.servicedao.daoimpl.MySQLUserDAOImpl;
import com.servicedao.daointf.UserDAOIntf;
import com.servicedao.domain.User;

public class UserGetAllCommand implements Command {

	private MySQLUserDAOImpl mySQLUserDAO;
	private List<User> users;

	public UserGetAllCommand(MySQLUserDAOImpl mySQLUserDAO, List<User> users) {
		this.mySQLUserDAO = mySQLUserDAO;
		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}

	@Override
	public void execute() {
		this.users = mySQLUserDAO.getAll();
	}
}
