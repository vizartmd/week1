package com.servicedao.dao.impl;

import java.util.List;
import java.util.Set;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;

public class TaskDaoImpl extends DAOimpl<Task> {

	protected TaskDaoImpl(Class<Task> clazz) {
		super(clazz);
	}

	private Logger logger;
	Session session;
	private TaskDaoImpl taskDaoImpl;
	private CriteriaBuilder cb;

	private final static class SingletonHolder {
		private final static TaskDaoImpl INSTANCE = new TaskDaoImpl(Task.class);
	}

	public static TaskDaoImpl getInstance() {
		TaskDaoImpl taskDaoImpl = SingletonHolder.INSTANCE;

		if (taskDaoImpl.logger == null) {
			taskDaoImpl.logger = Logger.getLogger(TaskDaoImpl.class);
		}
		if (taskDaoImpl.taskDaoImpl == null) {
			taskDaoImpl.taskDaoImpl = new TaskDaoImpl(Task.class);
		}
		return taskDaoImpl;
	}

	@Override
	public Task findById(int id) {
		List<Task> users = (List<Task>) getAll();
		Task task = users.stream().filter(el -> el.getTaskId() == id).findFirst().get();
		return task;
	}

	@Override
	public Set<Task> getAll() {
		Set<Task> tasks = super.getAll();
		return tasks;
	}

	@Override
	public void insert(Task task) {
		super.insert(task);
	}

	@Override
	public void update(Task task) {
		super.update(task);
	}

	@Override
	public void delete(Task task) {
		super.delete(task);
	}

	@Override
	public void deleteById(int id) {
		super.deleteById(id);
	}

}
