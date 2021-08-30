package com.servicedao.command.usercommand;

import com.servicedao.command.Command;
import com.servicedao.daoimpl.MySQLUserDAOImpl;
import com.servicedao.domain.User;

public class UserGetByIdCommand implements Command {
	
	MySQLUserDAOImpl mySQLUserDAO = new MySQLUserDAOImpl();
	User user;
	int id;

	public UserGetByIdCommand(int id) {
		this.id = id;
	} 

	public User getUser() {
		return user;
	}

	@Override
	public void execute() {
	    user = mySQLUserDAO.getById(id);
	}

}
