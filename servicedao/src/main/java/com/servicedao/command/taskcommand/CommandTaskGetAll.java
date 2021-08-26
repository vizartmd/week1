package com.servicedao.command.taskcommand;

import java.util.List;

import com.servicedao.command.Command;
import com.servicedao.dao.MySQLTaskDAO;
import com.servicedao.domain.Task;

public class CommandTaskGetAll implements Command {
	
	MySQLTaskDAO mySQLTaskDAO = new MySQLTaskDAO();
	List<Task> tasks;
	
	public List<Task> getTasks() {
		return tasks;
	}

	@Override
	public void execute() {
		this.tasks = mySQLTaskDAO.getAll();
	}
}
