package com.servicedao.command.taskcommand;

import com.servicedao.command.Command;
import com.servicedao.daointf.TaskDAOIntf;
import com.servicedao.domain.Task;

public class TaskGetByIdCommand implements Command {

	private TaskDAOIntf taskDAOImpl;
	private Task task;
	private int id;
	
	public TaskGetByIdCommand(TaskDAOIntf taskDAOImpl, int id) {
		this.taskDAOImpl = taskDAOImpl;
		this.id = id;
	}

	public Task getTask() {
		return task;
	}

	@Override
	public void execute() {
		this.task = taskDAOImpl.getById(id);
	}

}