package com.servicedao.dao;

import java.util.List;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;

public interface TaskDAO extends DAO<Task> {

	public void insert(Task task);

	public Task getById(int id);

	public void update(Task task);

	public void deleteById(int id);

	public List<Task> getAll();
	
}