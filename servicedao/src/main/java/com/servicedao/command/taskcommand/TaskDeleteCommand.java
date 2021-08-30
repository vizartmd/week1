package com.servicedao.command.taskcommand;

import com.servicedao.command.Command;
import com.servicedao.daointf.DAOIntf;
import com.servicedao.daointf.TaskDAOIntf;
import com.servicedao.domain.Task;

public class TaskDeleteCommand implements Command {

	private TaskDAOIntf taskDAOImpl;
	private int id;
	
	public TaskDeleteCommand(TaskDAOIntf taskDAOImpl, int id) {
		this.taskDAOImpl = taskDAOImpl;
		this.id = id;
	}
	
	@Override
	public void execute() {
		taskDAOImpl.deleteById(id);
	}
	
}
