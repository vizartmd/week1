package com.servicedao.command.usercommand;

import com.servicedao.command.Command;
import com.servicedao.daoimpl.MySQLUserDAOImpl;
import com.servicedao.domain.User;

public class UserInsertCommand implements Command{
	
	MySQLUserDAOImpl mySQLUserDAO = new MySQLUserDAOImpl();
	User user;
	
	public UserInsertCommand(User user) {
		this.user = user;
	}

	@Override
	public void execute() {
		System.out.println(user);
		mySQLUserDAO.insert(user);
	}
}
