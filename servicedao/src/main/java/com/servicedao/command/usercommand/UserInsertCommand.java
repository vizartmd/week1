package com.servicedao.command.usercommand;

import com.servicedao.command.Command;
import com.servicedao.daoimpl.MySQLUserDAOImpl;
import com.servicedao.daointf.UserDAOIntf;
import com.servicedao.domain.User;

public class UserInsertCommand implements Command {

	private MySQLUserDAOImpl mySQLUserDAO;
	private User user;

	public UserInsertCommand(MySQLUserDAOImpl mySQLUserDAO, String firstName, String lastName, String userName) {
		this.mySQLUserDAO = mySQLUserDAO;
		this.user = new User(firstName, lastName, userName);
	}

	@Override
	public void execute() {
		mySQLUserDAO.insert(user);
	}
}
