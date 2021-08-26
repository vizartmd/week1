package com.servicedao.command.usercommand;

import java.util.List;

import com.servicedao.command.Command;
import com.servicedao.dao.MySQLUserDAO;
import com.servicedao.domain.User;

public class CommandUserGetAll implements Command {

	MySQLUserDAO mySQLUserDAO = new MySQLUserDAO();
	List<User> users;

	public List<User> getUsers() {
		return users;
	}

	@Override
	public void execute() {
	    this.users = mySQLUserDAO.getAll();
	}

}
