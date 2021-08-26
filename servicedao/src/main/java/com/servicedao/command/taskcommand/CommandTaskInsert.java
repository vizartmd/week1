package com.servicedao.command.taskcommand;

import com.servicedao.command.Command;
import com.servicedao.dao.MySQLTaskDAO;
import com.servicedao.domain.Task;

public class CommandTaskInsert implements Command{
	
	MySQLTaskDAO mySQLTaskDAO = new MySQLTaskDAO();
	Task task;
	
	public CommandTaskInsert(Task task) {
		this.task = task;
	}

	@Override
	public void execute() {
		mySQLTaskDAO.insert(task);
		
	}
}
