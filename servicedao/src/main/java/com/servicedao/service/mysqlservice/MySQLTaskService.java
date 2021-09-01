package com.servicedao.service.mysqlservice;

import java.util.List;

/**
 * This class includes the methods that receive the classes that implements
 * Command interface as a parameter in execute() method of CommandInvoker class.
 * This is an element of Command Design Pattern
 */
import com.servicedao.command.taskcommand.TaskDeleteCommand;
import com.servicedao.command.taskcommand.TaskGetAllCommand;
import com.servicedao.command.taskcommand.TaskGetByIdCommand;
import com.servicedao.command.taskcommand.TaskInsertCommand;
import com.servicedao.command.taskcommand.TaskUpdateCommand;
import com.servicedao.daoimpl.MySQLTaskDAOImpl;
import com.servicedao.domain.Task;
import com.servicedao.service.CommandInvoker;

public class MySQLTaskService extends MySQLService{
	CommandInvoker commandInvoker = new CommandInvoker();
	MySQLTaskDAOImpl mySQLTaskDAOImpl = new MySQLTaskDAOImpl();
	TaskInsertCommand taskInsertCommand;
	TaskGetAllCommand taskGetAllCommand;
	TaskGetByIdCommand taskGetByIdCommand;
	TaskUpdateCommand taskUpdateCommand;
	TaskDeleteCommand taskDeleteCommand;
	
	public void insertTask(int id, int userId, String title, String description) {
		taskInsertCommand = new TaskInsertCommand(mySQLTaskDAOImpl, userId, title, description);
		commandInvoker.execute(taskInsertCommand);
	}
	
	public Task getTaskById(int id) {
		taskGetByIdCommand = new TaskGetByIdCommand(mySQLTaskDAOImpl,id);
		commandInvoker.execute(taskGetByIdCommand);
		return taskGetByIdCommand.getTask();
	}
	
	public void updateTask(int id, int userId, String title, String description) {
		taskUpdateCommand = new TaskUpdateCommand(mySQLTaskDAOImpl, id, userId, title, description);
		commandInvoker.execute(taskUpdateCommand);
	}
	
	public void deleteTask(int id) {
		taskDeleteCommand = new TaskDeleteCommand(mySQLTaskDAOImpl, id);
		commandInvoker.execute(taskDeleteCommand);
	}
	
	public List<Task> gelAllTasks() {
		taskGetAllCommand = new TaskGetAllCommand(mySQLTaskDAOImpl);
		commandInvoker.execute(taskGetAllCommand);
		return taskGetAllCommand.getTasks();
	}
}
