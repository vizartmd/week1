package com.servicedao.command.usercommand;

import com.servicedao.command.Command;
import com.servicedao.dao.MySQLUserDAO;
import com.servicedao.domain.User;

public class CommandUserGetById implements Command{
	
	MySQLUserDAO mySQLUserDAO = new MySQLUserDAO();
	User user;
	int id;
	
	public User getUser() {
		return user;
	}

	public CommandUserGetById(int id) {
		this.id = id;
	}
	
	@Override
	public void execute() {
	    this.user = mySQLUserDAO.getById(id);
	}

}
