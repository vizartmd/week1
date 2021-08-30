package com.servicedao.command.usercommand;

import java.util.List;
import com.servicedao.command.Command;
import com.servicedao.daoimpl.MySQLUserDAOImpl;
import com.servicedao.domain.User;

public class UserGetAllCommand implements Command {

	MySQLUserDAOImpl mySQLUserDAO = new MySQLUserDAOImpl();
	List<User> users;
	
	public List<User> getUsers() {
		return users;
	}

	@Override
	public void execute() {
	    this.users = mySQLUserDAO.getAll();
	}
}
