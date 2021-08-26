package com.servicedao.daointf;

import java.util.List;
import com.servicedao.domain.Task;

/**
 * interface with declaring methods for operating with the Task object in the database
 */
public interface TaskDAO extends DAO<Task> {

	/**
	 * the method for inserting a task into the database
	 */
	public void insert(Task task);

	/**
	 * method for getting a task from the database by id
	 */
	public Task getById(int id);

	/**
	 * method for updating a task in the database
	 */
	public void update(Task task, int id);

	/**
	 * method for deleting a task from the database
	 */
	public void deleteById(int id);

	/**
	 * method for getting all the task from the database
	 */
	List<Task> getAll();
}
