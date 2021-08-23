package com.servicedao.service;

import java.util.List;
import com.servicedao.command.taskcommand.CommandTaskDelete;
import com.servicedao.command.taskcommand.CommandTaskGetAll;
import com.servicedao.command.taskcommand.CommandTaskGetById;
import com.servicedao.command.taskcommand.CommandTaskInsert;
import com.servicedao.command.taskcommand.CommandTaskUpdate;
import com.servicedao.dao.MySQLTaskDAO;
import com.servicedao.daointf.TaskDAO;
import com.servicedao.domain.Task;

/**
 * @author vrobu1
 * Class-Invoker for TaskDAO class. "Command"-Pattern
 */

public class TaskServiceInvoker implements TaskDAO {
	MySQLTaskDAO mySQLTaskDAO = new MySQLTaskDAO();
	CommandTaskInsert commandTaskInsert;
	CommandTaskUpdate commandTaskUpdate;
	CommandTaskGetById commandTaskGetById;
	CommandTaskDelete commandTaskDelete;
	CommandTaskGetAll commandTaskGetAll;
	
	public void insert(Task task) {
		commandTaskInsert = new CommandTaskInsert(mySQLTaskDAO, task);
		commandTaskInsert.execute();
	}

	@Override
	public Task getById(int id) {
		commandTaskGetById = new CommandTaskGetById(mySQLTaskDAO, id);
		commandTaskGetById.execute();
		return commandTaskGetById.getTask();
	}

	@Override
	public void update(Task task, int id) {
		commandTaskUpdate = new CommandTaskUpdate(mySQLTaskDAO, task, id);
		commandTaskUpdate.execute();
		
	}

	@Override
	public void deleteById(int id) {
		commandTaskDelete = new CommandTaskDelete(mySQLTaskDAO, id);
		commandTaskDelete.execute();
	}

	@Override
	public List<Task> getAll() {
		commandTaskGetAll = new CommandTaskGetAll(mySQLTaskDAO);
		commandTaskGetAll.execute();
		return commandTaskGetAll.getTasks();
	}

}

