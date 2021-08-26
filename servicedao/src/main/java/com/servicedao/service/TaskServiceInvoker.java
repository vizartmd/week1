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

public class TaskServiceInvoker {
	CommandTaskInsert commandTaskInsert;
	CommandTaskUpdate commandTaskUpdate;
	CommandTaskGetById commandTaskGetById;
	CommandTaskDelete commandTaskDelete;
	CommandTaskGetAll commandTaskGetAll;
	
	public void insert(Task task) {
		commandTaskInsert = new CommandTaskInsert(task);
		commandTaskInsert.execute();
	}
 
	public Task getById(int id) {
		commandTaskGetById = new CommandTaskGetById(id);
		commandTaskGetById.execute();
		return commandTaskGetById.getTask();
	}
 
	public void update(Task task, int id) {
		commandTaskUpdate = new CommandTaskUpdate(task, id);
		commandTaskUpdate.execute();
		
	}
 
	public void deleteById(int id) {
		commandTaskDelete = new CommandTaskDelete(id);
		commandTaskDelete.execute();
	}
 
	public List<Task> getAll() {
		commandTaskGetAll = new CommandTaskGetAll();
		commandTaskGetAll.execute();
		return commandTaskGetAll.getTasks();
	}

}

