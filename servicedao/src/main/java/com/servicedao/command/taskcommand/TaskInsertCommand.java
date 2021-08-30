package com.servicedao.command.taskcommand;

import com.servicedao.command.Command;
import com.servicedao.daointf.TaskDAOIntf;
import com.servicedao.domain.Task;

public class TaskInsertCommand implements Command {
	
	private TaskDAOIntf taskDAOImpl;
	private Task task;
	
	public TaskInsertCommand(TaskDAOIntf taskDAOImpl, int id, int userId, String title, String description) {
		this.taskDAOImpl = taskDAOImpl;
		this.task = new Task(id, userId, title, description);
	}

	public void execute() {
		taskDAOImpl.insert(task);
	}
}
