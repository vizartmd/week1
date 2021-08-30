package com.servicedao.command.taskcommand;

import java.util.List;

import com.servicedao.command.Command;
import com.servicedao.daointf.DAOIntf;
import com.servicedao.daointf.TaskDAOIntf;
import com.servicedao.domain.Task;

public class TaskGetAllCommand implements Command {
	
	private TaskDAOIntf taskDAOImpl;
	private List<Task> tasks;
	
	public TaskGetAllCommand(TaskDAOIntf taskDAOImpl) {
		this.taskDAOImpl = taskDAOImpl;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}

	@Override
	public void execute() {
		this.tasks = taskDAOImpl.getAll();
	}
}
