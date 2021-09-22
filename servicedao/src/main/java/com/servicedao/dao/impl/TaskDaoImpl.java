package com.servicedao.dao.impl;

import java.util.List;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.servicedao.dao.TaskDao;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;

public class TaskDaoImpl  extends DAOimpl<Task> {
	
	protected TaskDaoImpl(Class<Task> clazz) {
		super(clazz);
	}

	private Logger logger;
	private TaskDaoImpl taskDaoImpl;


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
		Task task = super.findById(id);
		return task;
	}

	@Override
	public List<Task> getAll() {
		return super.getAll();
	}

	@Override
	public void insert(Task task) {
		Session session = openTransactionSession();
		try {
	        session.save(task);
	        logger.info("Task has been inserted successfully!");
		}
		catch (IllegalStateException | HibernateException e) {
			session.getTransaction().rollback();
			logger.warn("Task not inserted! " + e.getMessage());
		} finally {
	        closeTransactionSession();
		}
		
	}

	@Override
	public void update(Task task) {
		super.update(task);
	}
	
	@Override
	public void delete(Task task) {
		super.delete(task);
	}

	// ========== to check ============
	@Override
	public void deleteById(int id) {
		super.deleteById(id);
	}

}
