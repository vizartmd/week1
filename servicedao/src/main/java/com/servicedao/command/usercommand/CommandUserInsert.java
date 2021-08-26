package com.servicedao.command.usercommand;

import com.servicedao.command.Command;
import com.servicedao.dao.MySQLUserDAO;
import com.servicedao.domain.User;

public class CommandUserInsert implements Command{
	
	MySQLUserDAO mySQLUserDAO = new MySQLUserDAO();
	User user;
	
	public CommandUserInsert(User user) {
		this.user = user;
	}

	@Override
	public void execute() {
		mySQLUserDAO.insert(user);
	}
}
