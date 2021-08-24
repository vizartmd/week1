package com.servicedao.daointf;

import java.util.List;
import com.servicedao.domain.Task;

public interface TaskDAO extends DAO<Task> {

	public void insert(Task task);

	public Task getById(int id);

	public void update(Task task, int id);

	public void deleteById(int id);

	List<Task> getAll();
}
