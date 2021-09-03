package com.servicedao.command.taskcommand;

import com.servicedao.command.Command;
import com.servicedao.dao.TaskDAO;
import com.servicedao.domain.Task;

public class TaskInsertCommand implements Command {
	
	private TaskDAO taskDAOImpl;
	private Task task;
	
	public TaskInsertCommand(TaskDAO taskDAOImpl, int userId, String title, String description) {
		this.taskDAOImpl = taskDAOImpl;
		this.task = new Task(userId, title, description);
	}

	public void execute() {
		taskDAOImpl.insert(task);
	}
}
