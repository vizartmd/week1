package com.servicedao.daointf;

import java.util.List;
import com.servicedao.domain.Task;

public interface TaskDAOIntf extends DAOIntf<Task> {

	/**
	 * @inheritDoc
	 */
	public void insert(Task task);
	
	/**
	 * @inheritDoc
	 */
	public Task getById(int id);

	/**
	 * @inheritDoc
	 */
	public void update(Task task);

	/**
	 * @inheritDoc
	 */
	public void deleteById(int id);

	/**
	 * @inheritDoc
	 */
	public List<Task> getAll();
	
}