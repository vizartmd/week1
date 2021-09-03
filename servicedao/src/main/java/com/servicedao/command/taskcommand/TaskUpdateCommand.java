package com.servicedao.command.taskcommand;

import com.servicedao.command.Command;
import com.servicedao.daointf.TaskDAOIntf;
import com.servicedao.domain.Task;

public class TaskUpdateCommand implements Command {

	private TaskDAOIntf taskDAOImpl;
	private Task task;

	public TaskUpdateCommand(TaskDAOIntf taskDAOImpl, int id, int userId, String title, String description) {
		this.taskDAOImpl = taskDAOImpl;
		this.task = new Task(id, userId, title, description);
	}
	
	@Override
	public void execute() {
		taskDAOImpl.update(task);
	}
}
