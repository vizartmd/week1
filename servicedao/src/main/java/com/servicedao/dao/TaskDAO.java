package com.servicedao.dao;

import java.util.List;
import com.servicedao.domain.Task;

public interface TaskDAO extends DAO<Task> {

	/**
	 * @inherited
	 */
	public void insert(Task task);
	
	/**
	 * @inherited
	 */
	public Task getById(int id);

	/**
	 * @inherited
	 */
	public void update(Task task);

	/**
	 * @inherited
	 */
	public void deleteById(int id);

	/**
	 * @inherited
	 */
	public List<Task> getAll();
	
}