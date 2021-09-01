package com.servicedao.command.usercommand;

import com.servicedao.command.Command;
import com.servicedao.daoimpl.MySQLUserDAOImpl;
import com.servicedao.daointf.UserDAOIntf;
import com.servicedao.domain.User;

public class UserInsertCommand implements Command{
	
	MySQLUserDAOImpl mySQLUserDAO = new MySQLUserDAOImpl();
	User user;
	
	public UserInsertCommand(UserDAOIntf mySQLUserDAOImpl, String firstName, String lastName, String userName) {
		super();
		this.mySQLUserDAO = (MySQLUserDAOImpl) mySQLUserDAOImpl;
		this.user = new User(firstName, lastName, userName);
	}

	@Override
	public void execute() {
		mySQLUserDAO.insert(user);
	}
}
