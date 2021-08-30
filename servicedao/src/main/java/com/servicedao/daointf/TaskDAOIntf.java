package com.servicedao.daointf;

import java.util.List;
import com.servicedao.domain.Task;

public interface TaskDAOIntf extends DAOIntf<Task> {

	public void insert(Task task);

	public Task getById(int id);

	public void update(Task task);

	public void deleteById(int id);

	public List<Task> getAll();
}