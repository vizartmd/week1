package com.servicedao.command.taskcommand;

import com.servicedao.command.Command;
import com.servicedao.dao.MySQLTaskDAO;
import com.servicedao.domain.Task;

public class CommandTaskInsert implements Command{
	
	MySQLTaskDAO mySQLTaskDAO;
	Task task;
	
	public CommandTaskInsert(MySQLTaskDAO mySQLUserDAO, Task task) {
		this.mySQLTaskDAO = mySQLUserDAO;
		this.task = task;
	}

	@Override
	public void execute() {
		mySQLTaskDAO.insert(task);
		
	}
}
